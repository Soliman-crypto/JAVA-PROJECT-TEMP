package semestarovka.servlets;

import semestarovka.reposetories.Userrepo;
import semestarovka.models.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
public class servletlogin extends HttpServlet {
    private Userrepo userRepo;
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the cookie value

        HttpSession session = request.getSession();

        if (session != null) {
            session.setAttribute("authenticated", true);

            createCookie(response);
        } else {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }

    }

    private String generateUniqueIdentifer() { return UUID.randomUUID().toString();
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        dataSource = (DataSource) config.getServletContext().getAttribute("datasource");
        userRepo = (Userrepo) config.getServletContext().getAttribute("accountRep");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userRepo.findUser(email, password);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user.getEmail());
            session.setAttribute("authenticated", true);

            createCookie(response);

            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login");
        }

    }
    private String getUserCookieValue(HttpServletRequest request) {
        String userCookieValue = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userCookie".equals(cookie.getName())) {
                    userCookieValue = cookie.getValue();
                    break;
                }
            }
        }
        return userCookieValue;
    }

    private Cookie createCookie(HttpServletResponse response) {
        String uuid = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("cookie", uuid);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return cookie;
    }
}



