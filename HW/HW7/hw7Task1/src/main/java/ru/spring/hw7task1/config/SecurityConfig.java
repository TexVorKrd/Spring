package ru.spring.hw7task1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/private-data").hasRole("ADMIN")// Доступ к запросам для Админа
                .antMatchers("/public-data").authenticated()// Доступ для зарегистрированых пользователей
                .and()
                .formLogin()
                .loginPage("/login") //Страница Аутинитификации пользователей
                .permitAll() //Доступна для всех
                .loginProcessingUrl("/process_login") //Редирект аутинтификации
                .defaultSuccessUrl("/public-data") //Редирект на общедоступный ресурс
                .failureUrl("/login?error") //редирект пр ошибочной аутинтификации
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied"); // редирект при отсутствии доступа
    }


    @Bean
    /**
     * Роли
     */
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("user")
                .password("123")
                .roles("USER")
                .build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("admin")
                .password("321")
                .roles("ADMIN")
                .build());
        return manager;
    }

}
