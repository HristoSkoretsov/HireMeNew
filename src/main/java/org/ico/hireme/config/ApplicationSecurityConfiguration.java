package org.ico.hireme.config;

import org.ico.hireme.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfiguration
        extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Autowired
    public ApplicationSecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();

        repository.setSessionAttributeName("_csrf");

        return repository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf()
//                    .disable()
                .csrfTokenRepository(csrfTokenRepository())
                .and()
                .authorizeRequests()
                .antMatchers("/", "/login", "/register").permitAll()
                .antMatchers("/css/**", "/js/**").permitAll()
                .antMatchers("/delete-user", "/create-company", "/delete-company").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .and()
                .rememberMe()
                .rememberMeParameter("rememberMe")
                .key("HireMe")
                .userDetailsService(this.userService)
                .rememberMeCookieName("MeHire")
                .tokenValiditySeconds(1200)
                .and()
                .exceptionHandling()
                .accessDeniedPage("/unauthorized");
    }
}
