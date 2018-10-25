package no.hvl.dat108;

import static no.hvl.dat108.Validator.getErrorMessage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet(name = "LoginServlet", urlPatterns = {"login", "/"}, loadOnStartup = 1, initParams = {@WebInitParam(name="pwd", value="dat108"), @WebInitParam(name="maxSec", value="10")}) 
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        boolean requiresLoginRedirect = request
        .getParameter("requiresLogin") != null;
        boolean invalidPasswordRedirect = request
        .getParameter("invalidPassword") != null;

        String error = "";
        if(requiresLoginRedirect == true || invalidPasswordRedirect == true)
            error = getErrorMessage(requiresLoginRedirect, invalidPasswordRedirect);
        response.setContentType("text/hmtl; charset=ISO-8859-1");

        request.setAttribute("error", error);
        request.setAttribute("requiresLoginRedirect", requiresLoginRedirect);
        request.setAttribute("invalidPasswordRedirect", invalidPasswordRedirect);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        
        String password = Jsoup.clean(request.getParameter("password"), Whitelist.none());
        if(password == null || !password.equals(getInitParameter("pwd")))
            response.sendRedirect("login" + "?invalidPassword");
        else {
            HttpSession session = request.getSession(false);
            if(session != null)
                session.invalidate();
            session = request.getSession(true);
            session.setMaxInactiveInterval(Integer.parseInt(getInitParameter("maxSec")));
            
            session.setAttribute("password", password);
            session.setAttribute("todoList", new TodoList());

            response.sendRedirect("todoapp");
        }
    }
}