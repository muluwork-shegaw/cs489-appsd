package cs489.project.carrental.filter;

import cs489.project.carrental.service.Impl.UserServiceImpl;
import cs489.project.carrental.utility.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtMgmtUtilityService;

    private final UserServiceImpl userService;

    //    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//
//        var token = extractTokenFromRequest(request);
//        if (token != null && jwtUtil.validateToken(token)) {
//
//            SecurityContextHolder.getContext().setAuthentication(jwtUtil.getAuthentication(token));
//        }
//        filterChain.doFilter(request, response);
//    }
//
//
//    public String extractTokenFromRequest(HttpServletRequest request) {
//        final String authorizationHeader = request.getHeader("Authorization");
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            var token = authorizationHeader.substring(7);
//            return token;
//        }
//        return null;
//    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        // Here is just an example jwt token -
        // Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbmEuYWRtaW4iLCJleHAiOjE2NTE0MzUwODEsImlhdCI6MTY1MTM5OTA4MX0.aPH-bBsaRETUip91m3y3_UTR_EwFFbIpkyOdKSTgM70KT0a7v0uAYh4NtnFqvwEgCN7kuR8MDO5VB3rktBAwpA
        String jwtToken = null;
        String username = null;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            username = jwtMgmtUtilityService.extractUsername(jwtToken);
        }
        if (username != null
                && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userService.loadUserByUsername(username);
            if (jwtMgmtUtilityService.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(
                                new WebAuthenticationDetailsSource()
                                        .buildDetails(request)
                        );
                SecurityContextHolder.getContext()
                        .setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}