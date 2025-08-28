package com.api.produtos_api;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password(new BCryptPasswordEncoder().encode("123456"))
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
    }
}
