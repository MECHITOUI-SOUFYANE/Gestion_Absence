package ma.projet.security.config;

import org.aspectj.weaver.PerTypeWithinTargetTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ma.projet.security.filters.JWTAuthenticationFilter;
import ma.projet.security.filters.JWTAuthorizationFilter;
import ma.projet.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter{
	
	
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailServiceImp()).passwordEncoder(
		 bCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().frameOptions().disable();
		http.csrf().disable();
		http.addFilter(jWTAuthenticationFilter())
			.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	UserDetailServiceImpl userDetailServiceImp() {
		return new UserDetailServiceImpl();
	}
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	
	JWTAuthenticationFilter jWTAuthenticationFilter() throws Exception{
		JWTAuthenticationFilter filter = new JWTAuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/login");
		return filter;
	}
	@Bean
	JWTAuthorizationFilter jwtAuthorizationFilter() {
		return new JWTAuthorizationFilter();
	}
}
