package com.cropdeal.FarmerService.Service;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;



@Component
public class JwtFilters extends OncePerRequestFilter{
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	UserService userService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationheader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		if (authorizationheader != null && authorizationheader.startsWith("Bearer ")) {
		 jwtToken = authorizationheader.substring(7);
			username = jwtUtils.extractUsername(jwtToken);
		}
		
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails currentUser= userService.loadUserByUsername(username);
			boolean tokenValidated= jwtUtils.validateToken(jwtToken, currentUser);
			if (tokenValidated) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(currentUser,null,currentUser.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
			}
			filterChain.doFilter(request, response);
	}

}
