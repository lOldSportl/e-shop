//package veil.dev.productservice.security;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.security.Key;
//import java.util.Collections;
//
////@Component
//public class JWTAuthFilter extends OncePerRequestFilter {
//
//    private final Key key;
//
//    public JWTAuthFilter(@Value("${jwt.secret}") String secret) {
//        this.key = Keys.hmacShaKeyFor(secret.getBytes());
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            try {
//                String token = authHeader.substring(7);
//                Claims claims = Jwts.parserBuilder()
//                        .setSigningKey(key)
//                        .build()
//                        .parseClaimsJws(token)
//                        .getBody();
//
//                String username = claims.getSubject();
//
//                if (username != null) {
//                    UserDetails userDetails = User.withUsername(username)
//                            .password("") // пароль не нужен
//                            .authorities("ROLE_USER") // даём хотя бы одну роль
//                            .build();
//
//                    UsernamePasswordAuthenticationToken authentication =
//                            new UsernamePasswordAuthenticationToken(
//                                    userDetails,
//                                    null,
//                                    userDetails.getAuthorities()
//                            );
//
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                    System.out.println(">>> Authenticated as " + username);
//                }
//
//            } catch (JwtException e) {
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                return;
//            }
//        } else {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
