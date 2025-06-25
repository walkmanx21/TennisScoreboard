import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ErrorResponseDto;
import exceptions.SameNamesException;
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
            writeErrorResponse(res, SC_BAD_REQUEST, e);
        }
    }

    private void writeErrorResponse(HttpServletResponse response, int errorCode, RuntimeException e) throws IOException {
        response.setStatus(errorCode);
        objectMapper.writeValue(response.getWriter(), new ErrorResponseDto(errorCode, e.getMessage()));


    }
}
