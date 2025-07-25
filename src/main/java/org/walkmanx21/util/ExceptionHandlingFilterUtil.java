package org.walkmanx21.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import org.walkmanx21.dto.ErrorResponseDto;
import org.walkmanx21.exceptions.GetSessionFactoryException;
import org.walkmanx21.exceptions.MatchNotFoundException;
import org.walkmanx21.exceptions.SameNamesException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/*")
public class ExceptionHandlingFilterUtil extends HttpFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        try {
            super.doFilter(req, res, chain);
        } catch (SameNamesException e) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/newMatchSameNameUsers.jsp");
            dispatcher.forward(req, res);
        } catch (GetSessionFactoryException | MatchNotFoundException e) {
            writeErrorResponse(res, 500, e);
        }
    }

    private void writeErrorResponse (HttpServletResponse response, int errorCode, RuntimeException e) throws IOException {
        response.setStatus(errorCode);

        objectMapper.writeValue(response.getWriter(), new ErrorResponseDto(errorCode, e.getMessage()));
    }
}
