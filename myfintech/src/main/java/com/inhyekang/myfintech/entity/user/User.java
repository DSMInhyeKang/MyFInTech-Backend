package com.inhyekang.myfintech.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

@Entity
@Table
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "sub", nullable = false, unique = true)
    private String sub;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return new HashSet<GrantedAuthority>(); }

    @Override
    public String getPassword() { return ""; }

    @Override
    public String getUsername() { return this.getEmail(); }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

//    refreshToken이 들어갈 column 생성, reissue하는 함수 생성!
//    Service에서 reissue하는 함수 안에 새로운 유저 객체 생성 후 새로운 refreshToken set
//    reissue하는 함수에 @Transactioinal 키워드 붙이면 repository 불러와서 save 안 해도 알아서 업데이트!!!
}