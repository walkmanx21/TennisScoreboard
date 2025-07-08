package org.walkmanx21;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import org.walkmanx21.dto.ErrorResponseDto;
import org.walkmanx21.exceptions.PlayerAlreadyExistException;
import org.walkmanx21.exceptions.SameNamesException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

@WebFilter("/*")
public class ExceptionHandlingFilter extends HttpFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        try {
            super.doFilter(req, res, chain);
        } catch (SameNamesException e) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/newMatchSameNameUsers.jsp");
            dispatcher.forward(req, res);
        }
    }
}
