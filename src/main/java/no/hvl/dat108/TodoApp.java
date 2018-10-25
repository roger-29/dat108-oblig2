package no.hvl.dat108;

import static no.hvl.dat108.Validator.cleanInput;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TodoApp", urlPatterns = {"todoapp"}, loadOnStartup = 1) 
public class TodoApp extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private TodoList todoList = new TodoList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("password") == null)
            response.sendRedirect("login" + "?requiresLogin");
        else {
            String password = (String)session.getAttribute("password");
            TodoList todoList = (TodoList)session.getAttribute("todoList");
            response.setContentType("text/html; charset=ISO-8859-1");

            request.setAttribute("name", password);
            request.setAttribute("todoList", todoList);
            request.getRequestDispatcher("todoApp.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
            HttpSession session = request.getSession(false);

            if(session == null || session.getAttribute("password") == null) 
                response.sendRedirect("login" + "?requiresLogin");
            else if(request.getParameter("deleteItem") != null){
                    String item = request.getParameter("deleteItem").replaceAll("/", "");
                    todoList.removeItem(item);
                    session.setAttribute("todoList", todoList);
                    response.sendRedirect("todoapp");
                }

            else{
                if(request.getParameter("item") != null ) {
                    String postedItem = (String) request.getParameter("item");
                    postedItem = cleanInput(postedItem);
                    if(!Validator.isInvalid(postedItem))
                        todoList.addItem(new TodoItem(postedItem));
                        
                    session.setAttribute("todoList", todoList);
                    response.sendRedirect("todoapp");
                };
                }
    }
}