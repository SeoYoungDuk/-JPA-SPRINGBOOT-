package kr.co.fastcampus.eatgo.filters;

import io.jsonwebtoken.Claims;
import kr.co.fastcampus.eatgo.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAutenticationFilter extends BasicAuthenticationFilter {

    private JwtUtil jwtUtil;

    public JwtAutenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
    }

    //TODO: 실제로 JWT 분석 필요함.

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws IOException, ServletException {
        Authentication authentication = getAuthentication(request);
        
        if( authentication != null ){
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authentication);
        }

        //TODO:JWT
        chain.doFilter(request, response);
    }
    private Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token == null){
            return null;
        }

        //TODO: jwtUtil에서 claims 얻기
        Claims claims = jwtUtil.getClaims(token.substring("Bearer ".length()));
        Authentication authentication = new UsernamePasswordAuthenticationToken(claims, null);
        return  authentication;

    }
}

