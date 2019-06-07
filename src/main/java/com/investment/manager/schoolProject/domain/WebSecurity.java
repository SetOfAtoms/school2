package com.investment.manager.schoolProject.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeRequests().antMatchers("/css/**", "/signup").permitAll()
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/booklist")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        ArrayList<UserDetails> users = new ArrayList();
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//
//        users.add(user);
//
//        user = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("USER", "ADMIN")
//                .build();
//
//        users.add(user);
//
//        return new InMemoryUserDetailsManager(users);
//    }
//}

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
                .and()
                .authorizeRequests().antMatchers("/signup", "/saveuser").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}