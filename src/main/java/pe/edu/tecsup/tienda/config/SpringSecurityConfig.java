package pe.edu.tecsup.tienda.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {	// No encriptado, Texto Plano
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return rawPassword.toString().equals(encodedPassword);
			}
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		};
//	    return new BCryptPasswordEncoder();	// Algoritmo BCrypt
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {

		List<UserDetails> users = new ArrayList<UserDetails>();
		users.add(User.withUsername("user").password("user").roles("USER").build());
		users.add(User.withUsername("admin").password("admin").roles("USER", "ADMIN").build());

		return new InMemoryUserDetailsManager(users);
	}
		
}
