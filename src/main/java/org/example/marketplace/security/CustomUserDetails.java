package org.example.marketplace.security;

import lombok.AllArgsConstructor;
import org.example.marketplace.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles().stream()
                .flatMap(role -> {
                    Stream<GrantedAuthority> roleAuth = Stream.of(new SimpleGrantedAuthority(role.getName()));
                    Stream<GrantedAuthority> permAuths = role.getPermissions().stream()
                            .map(perm -> new SimpleGrantedAuthority(perm.getName()));
                    return Stream.concat(roleAuth, permAuths);
                })
                .collect(Collectors.toSet());
    }

    @Override public String getPassword() {
        return user.getPassword();
    }
    @Override public String getUsername() {
        return user.getUsername();
    }
    @Override public boolean isAccountNonExpired() {return true;}
    @Override public boolean isAccountNonLocked() {return true;}
    @Override public boolean isCredentialsNonExpired() {return true;}
    @Override public boolean isEnabled() {return true;}

    public User getUser() {
        return user;
    }
}
