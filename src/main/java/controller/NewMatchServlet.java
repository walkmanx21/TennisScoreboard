package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Match;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

@WebServlet("/new-match")
public class NewMatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try (PrintWriter out = resp.getWriter()) {
//            resp.setContentType("application/json");
//            resp.setCharacterEncoding("UTF-8");
//            File file = Path.of("src","main","webapp", "css", "style.css").toFile();
//            out.println(file.exists());
//            out.println();
//            out.flush();
//        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/newMatch.jsp");
        dispatcher.forward(req, resp);
    }
}