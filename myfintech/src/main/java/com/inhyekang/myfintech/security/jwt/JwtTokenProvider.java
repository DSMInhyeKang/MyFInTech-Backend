package com.inhyekang.myfintech.security.jwt;

import com.inhyekang.myfintech.dto.response.TokensResponse;
import com.inhyekang.myfintech.entity.user.RefreshToken;
import com.inhyekang.myfintech.exception.TokenExpiredException;
import com.inhyekang.myfintech.exception.TokenInvalidException;
import com.inhyekang.myfintech.repository.RefreshTokenRepository;
import com.inhyekang.myfintech.security.auth.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider implements InitializingBean {

    private final JwtProperties jwtProperties;

    private final CustomUserDetailsService customUserDetailsService;

    private final RefreshTokenRepository refreshTokenRepository;

    private Key key;

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    private String createAccessToken(String email) {

        Date now = new Date();

        return Jwts.builder()
                .setSubject(email)
                .claim("type", "access")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getAccess() * 1000))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    private String createRefreshToken(String email) {

        Date now = new Date();

        String refreshToken = Jwts.builder()
                .setSubject(email)
                .claim("type", "refresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getRefresh() * 1000))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .email(email)
                        .refreshToken(refreshToken)
                        .expiration(jwtProperties.getRefresh())
                        .build());

        return refreshToken;
    }

    public TokensResponse createTokens(String email){
        return TokensResponse
                .builder()
                .accessToken(createAccessToken(email))
                .refreshToken(createRefreshToken(email))
                .build();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public TokensResponse reissue(String refreshToken) {

        if(!isRefreshToken(refreshToken))
            throw TokenInvalidException.EXCEPTION;

        String userId = getId(refreshToken);

        refreshTokenRepository.findById(userId)
                .filter(token -> token.getRefreshToken().equals(refreshToken))
                .map(token -> token.updateExpiration(jwtProperties.getRefresh()))
                .orElseThrow(() -> TokenInvalidException.EXCEPTION);

        return TokensResponse.builder()
                .accessToken(createAccessToken(userId))
                .refreshToken(refreshToken)
                .build();
    }

    private boolean isRefreshToken(String token) {
        return getClaims(token).get("type").equals("refresh");
    }

    private String getId(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw TokenExpiredException.EXCEPTION;
        } catch (Exception e) {
            throw TokenInvalidException.EXCEPTION;
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.getPrefix())
                && bearerToken.length() > jwtProperties.getPrefix().length() + 1) {
            return bearerToken.substring(7);
        }
        return null;
    }

}