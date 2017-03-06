package ua.kiev.prog.Controllers;

import ua.kiev.prog.Model.Status;
import ua.kiev.prog.Model.User;
import ua.kiev.prog.Model.Users;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutServlet extends HttpServlet{

    private Users users = Users.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("from");
        User user = users.getUser(login);
        user.setStatus(Status.OFFLINE);

        resp.sendRedirect("/index.jsp");
    }
}
