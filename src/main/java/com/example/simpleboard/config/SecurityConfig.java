//package com.example.simpleboard.config;
//
//
//
//// I should understand this part sometime.
//// https://victorydntmd.tistory.com/328?category=764331
//
//import com.example.simpleboard.service.MemberService;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//@AllArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//    private MemberService memberService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception{
//        web.ignoring().antMatchers("");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()//Page Authorization Configuration
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/myinfo").hasRole("MEMBER")
//                .antMatchers("/**").permitAll()
//                .and() //Login Configuration
//                .formLogin()
//                .loginPage("/user/login")
//                .defaultSuccessUrl("/user/login/success")
//                .permitAll()
//                .and() // Logout Configuration
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/user/iogout"))
//                .logoutSuccessUrl("/user/logout/success")
//                .invalidateHttpSession(true)
//                .and() //403 exception handling
//                .exceptionHandling().accessDeniedPage("/user/denied");
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
//    }
//
//}