
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

public class LogInServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (request.getParameter("logout") != null){
            session.invalidate();
            request.setAttribute("message", "Successfully logged out");
        } else {
              if (session.getAttribute("username") != null){
                response.sendRedirect("home");
                return;
            }
        }
     
       getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       return;
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        
        String userInput = request.getParameter("userinput");
        String passInput = request.getParameter("passinput");
        
        if (userInput.length() > 0 && passInput.length() > 0) {
            AccountService service = new AccountService();
            User user = service.login(userInput,passInput);
            
            if (user != null){
                session.setAttribute("username", user.getName());
                response.sendRedirect("home");
                return;
            } else{
                request.setAttribute("uservalue", userInput);
                request.setAttribute("passvalue", passInput);
                request.setAttribute("message", "Failed authentication");
            }
        }else{
            request.setAttribute("uservalue", userInput);
            request.setAttribute("passvalue", passInput);
            request.setAttribute("message", "Failed authentication");
        }
        
       getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       return;
    }

}
