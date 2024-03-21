package studentdetails.online_student_information;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class My_Authentication {

    @Autowired
    studentinfoService service;

    AuthenticationManager manager;

    @Bean
    public PasswordEncoder coder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer customizer() {
        return (web) -> web.ignoring().requestMatchers("/myproject/create");
    }

    @Bean
    public InMemoryUserDetailsManager myuserdetails() {
        UserDetails myuser1 = User.withUsername("Hari")
                .password(coder().encode("Hari@123"))
                .roles("Manager").build();

        return new InMemoryUserDetailsManager(myuser1);
    }

    @Bean
    public SecurityFilterChain connection(HttpSecurity hs) throws Exception {
        hs.authorizeRequests().requestMatchers("/myproject/**").authenticated();
        hs.csrf().disable();
        hs.formLogin();
        hs.httpBasic();

        AuthenticationManagerBuilder builder = hs.getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(service).passwordEncoder(coder());

        manager = builder.build();

        hs.authenticationManager(manager);

        return hs.build();

    }

}
