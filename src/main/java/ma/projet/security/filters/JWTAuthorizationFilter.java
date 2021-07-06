package ma.projet.security.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import ma.projet.security.config.SecurityConstants;

public class JWTAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range,Authorization");
		response.addHeader("Access-Control-Expose-Headers", "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range,Authorization");
		
		String jwt = request.getHeader(SecurityConstants.HEADER_STRING);
		System.out.println("jwt : "+jwt);
		if(jwt==null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET)
									 .parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, ""))
									 .getBody();
		System.out.println(claims);
		String username = claims.getSubject();
		System.out.println(username);
		@SuppressWarnings("unchecked")
		ArrayList<Map<String,String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		roles.forEach((role) -> authorities.add(new SimpleGrantedAuthority(role.get("authority"))));
		Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);
		
	}

	

}
