package ua.kiev.prog.Controllers;

import ua.kiev.prog.Model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = Users.getInstance();
        req.setAttribute("users", users.getList());
        String login = req.getParameter("from");
        req.setAttribute("user", users.getUser(login));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UsersList.jsp");
        dispatcher.forward(req, resp);
    }
}
