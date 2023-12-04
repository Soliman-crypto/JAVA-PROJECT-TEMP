package semestarovka.servlets;


import semestarovka.reposetories.Filesrepo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/files")
public class FilesList extends HttpServlet {

    private Filesrepo filesrepo;

    @Override
    public void init(ServletConfig config) throws ServletException {
        filesrepo = (Filesrepo) config.getServletContext().getAttribute("files");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/files.jsp").forward(req, resp);
    }
}