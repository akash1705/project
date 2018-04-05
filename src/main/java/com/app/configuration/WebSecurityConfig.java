package com.app.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.app.service.LabDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	/*@Autowired
	private LabDetailsService labDetailsService;*/
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;
	
	/*@Autowired
	private AppAuthenticationEntryPoint appAuthenticationEntryPoint;*/
	
/*	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;


	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoder);
	}

	
	*/
	
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http
                .authorizeRequests()
                    .antMatchers("/views/register","/views/lablogin","/views/hosplogin","/role/**","/lab/**").permitAll().antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
    				.authenticated().and().csrf().disable().formLogin()
                    .loginPage("/views/lablogin").defaultSuccessUrl("/views/labdash")
                    .usernameParameter("email")
    				.passwordParameter("password")
                    .and()
                    .logout()
                    .permitAll().and().exceptionHandling().accessDeniedPage("/error");
    */
		
	
        http.csrf().disable();/*authorizeRequests()
	    .antMatchers("/user/**").hasAnyRole("ADMIN","USER")
	    .and().httpBasic().realmName("MY APP REALM")
	    .authenticationEntryPoint(appAuthenticationEntryPoint);*/
        
        // The pages does not require login
        http.authorizeRequests().antMatchers("/views/lablogin", "/role/**","/lab/**").permitAll();
 
        // /userInfo page requires login as ROLE_USER or ROLE_ADMIN.
        // If no login, it will redirect to /login page.
        http.authorizeRequests().antMatchers("/views/userInfo").access("hasAnyRole('USER', 'ADMIN')");
 
        // For ADMIN only.
        http.authorizeRequests().antMatchers("/views/admin").access("hasRole('ADMIN')");
 
        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will be thrown.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/views/403");
 
        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/views/lablogin")//
                .defaultSuccessUrl("/views/labdash")//
                .failureUrl("/views/lablogin?error=true")//
                .usernameParameter("email")//
                .passwordParameter("password");
                // Config for Logout Page
                //.and().logout().logoutUrl("/views/logout").logoutSuccessUrl("/logoutSuccessful");
 
        // Config Remember Me.
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
 
	
	
	
	}
	@Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
	
	
	
}
