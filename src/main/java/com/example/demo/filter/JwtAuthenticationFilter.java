package com.example.demo.filter;

import com.example.demo.security.JwtAuthenticationToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        // 1. Decide whether we want to apply the filter

        // 2. Check credentials and [authenticate | reject]
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Type", "text/plain;charset=UTF-8");
            response.getWriter().println(request.getHeader("Authorization"));
            response.getWriter().println("who the fuck are you??");
            return;
        }

        // Get token from Authorization header
        final String jwt = authHeader.substring(7);


        // Create new context and save jwt as username
        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(jwt);
        SecurityContext newContext = SecurityContextHolder.getContext();
        newContext.setAuthentication(jwtAuthenticationToken);
        SecurityContextHolder.setContext(newContext);


        // (*) Persisting the session of authentication
        // SecurityContextRepository securityContextRepository;
        // securityContextRepository.saveContext(newContext, request, response);

        // 3. Call next
        filterChain.doFilter(request, response);

        // 4. ...
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().startsWith("/auth")
                || request.getServletPath().startsWith("/welcome");
    }
}
