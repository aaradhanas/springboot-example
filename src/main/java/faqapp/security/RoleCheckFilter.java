package faqapp.security;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by AAS on 3/3/2018.
 * To understand how to register a filter and check the flow.
 */
public class RoleCheckFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Inside RoleCheckFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
