package com.spark.spark.security;

import com.spark.spark.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public class ShopDetailsImpl implements UserDetails {
    private final Shop shop;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Stream.of(shop.getRole())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }

    @Override
    public String getPassword() {

        return this.shop.getPassword();
    }

    public Long getUserId(){
        return this.shop.getId();
    }
    @Override
    public String getUsername() {
        return this.shop.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
