package semestarovka.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import semestarovka.reposetories.Fileservice;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/insert")
@MultipartConfig
public class FilesUpload extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    private Fileservice fileservice;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.fileservice = (Fileservice) config.getServletContext().getAttribute("fileservice");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // You can add any necessary logic for the GET request if needed
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve userId from the session


        Part part = request.getPart("file");

        fileservice.saveFileToStorage(
                part.getInputStream(),
                part.getSubmittedFileName(),
                part.getContentType(),
                part.getSize(),
                userId);

        response.sendRedirect("/");
    }
}
