package capgemini.paramjit.profileservice.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import capgemini.paramjit.profileservice.service.ProfileService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ProfileService profileService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(profileService); 
		super.configure(auth);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}

	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf()
	                .disable()
	                .authorizeRequests()
	                .antMatchers("/authenticate")
	                .permitAll()
	                .anyRequest()
	                .authenticated();
	                

	    }
}