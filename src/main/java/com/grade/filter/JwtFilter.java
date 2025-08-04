package com.grade.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.grade.service.JwtService;
import com.grade.service.UtilisateurServiceImpl;

import java.io.IOException;
import java.util.Enumeration;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UtilisateurServiceImpl utilisateurService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("JwtFilter appliqué pour URI : " + request.getRequestURI());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println("En-tête : " + headerName + " = " + request.getHeader(headerName));
        }
        String authHeader = request.getHeader("Authorization");
        System.out.println("En-tête Authorization reçu : " + (authHeader != null ? authHeader : "null"));

        String jwt = null;
        String username = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            System.out.println("Token extrait : " + (jwt.length() > 10 ? jwt.substring(0, 10) + "..." : jwt));
            username = jwtService.extractUsername(jwt);
            System.out.println("Username extrait : " + username);
        } else {
            System.out.println("Aucun en-tête Authorization ou pas de préfixe Bearer");
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = utilisateurService.loadUserByUsername(username);
            if (jwtService.validateToken(jwt, userDetails)) {
                System.out.println("Token valide pour " + username + " avec authorities : " + userDetails.getAuthorities());
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                System.out.println("Token invalide pour " + username);
            }
        } else {
            System.out.println("Aucun username ou authentification déjà présente");
        }
        filterChain.doFilter(request, response);
    }
}