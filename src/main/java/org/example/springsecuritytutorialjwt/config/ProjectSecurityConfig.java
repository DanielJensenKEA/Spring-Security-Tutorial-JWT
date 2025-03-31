package org.example.springsecuritytutorialjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
       // http.csrf(csrfconfig -> csrfconfig.disable())
          http.csrf((csrf) -> csrf.ignoringRequestMatchers("/contact", "/register"))
                        .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("myAccount", "/myBalance").authenticated()
                                .requestMatchers("/contact", "/register").permitAll());

        http.authorizeHttpRequests(
                (requests) -> { requests
                        .requestMatchers("/myAccount","/myBalance")
                        .authenticated() .requestMatchers("/contact")
                        .permitAll(); });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
//        var obj = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        return obj;
    }

}
