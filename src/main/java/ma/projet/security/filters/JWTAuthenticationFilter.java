package ma.projet.security.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ma.projet.entities.AppUser;
import ma.projet.security.config.SecurityConstants;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authenticationManager;
	
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		AppUser user = null;
		try {
			user = new ObjectMapper().readValue(request.getInputStream(),AppUser.class);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		System.out.println(user.getPassword());
		Authentication auth = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
		);
		System.out.println("isAuthenticated : "+auth.isAuthenticated());

		return auth;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User springUser = (User)authResult.getPrincipal();
		String jwt = Jwts.builder()
						 .setSubject(springUser.getUsername())
						 .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
						 .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
						 .claim("roles", springUser.getAuthorities())
						 .compact();
		System.out.println("successfulAuthentication");
		
		response.setHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwt);

	}

}
