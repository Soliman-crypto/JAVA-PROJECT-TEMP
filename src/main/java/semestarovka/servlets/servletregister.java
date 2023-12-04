package semestarovka.servlets;

import semestarovka.reposetories.Fileservice;
import semestarovka.reposetories.Filesrepo;
import semestarovka.reposetories.Userrepo;
import semestarovka.models.User;

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

@WebServlet("/register")
@MultipartConfig
public class servletregister extends HttpServlet {
    private Userrepo userRepo;
    private Fileservice fileservice;
    private Filesrepo filesrepo;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        userRepo = (Userrepo) config.getServletContext().getAttribute("accountRep");
        fileservice = (Fileservice) config.getServletContext().getAttribute("fileservice");
        filesrepo = (Filesrepo) config.getServletContext().getAttribute("files");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Get form parameters
//        Part filePart = request.getPart("file");
//        if (filePart == null) {
//            // Handle the case where no file is uploaded
//            // You might want to display an error message or redirect to the registration page
//            response.sendRedirect("Explore.jsp");
//            return;
//        }

        String full_name = request.getParameter("full_name");
        String user_name = request.getParameter("user_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        Part filePart = request.getPart("profile_picture");

        // Get the filename from the submitted form field
      //  String fileName = extractFileName(filePart);

        // Save the file to a specified location on the server
//        String savePath = "/Users/macbook/Desktop/Java23:24/StevenGrand/src/main/webapp/profilepics/" + fileName;  // Specify the path where you want to save the file
//        filePart.write(savePath);

        // Create a User object
        User user = User.builder()
                .Full_Name(full_name)
                .Username(user_name)
                .Email(email)
                .Password(password)
                .Gender(gender)
                .ProfilePicture(String.valueOf(filePart))  // Save the file path to the User object
                .build();

        // Now you can save the user object to the database using your repository
        userRepo.save(user);
        System.out.println("User registered successfully");

//        InputStream fileContent = filePart.getInputStream();
//        String originalFileName = filePart.getSubmittedFileName();
//        Long size = filePart.getSize();
//        String type = filePart.getContentType();
//        System.out.println("1111111111111");
//        fileservice.saveFileToStorage(fileContent, originalFileName, type, size);
//
//        System.out.println("------------------------");


        response.sendRedirect("Login.jsp");
    }


    // Helper method to extract filename from Part
//    private String extractFileName(Part part) {
//        String contentDisposition = part.getHeader("content-disposition");
//        String[] items = contentDisposition.split(";");
//        for (String item : items) {
//            if (item.trim().startsWith("filename")) {
//                return item.substring(item.indexOf("=") + 2, item.length() - 1);
//            }
//        }
//        return "";
//    }
}