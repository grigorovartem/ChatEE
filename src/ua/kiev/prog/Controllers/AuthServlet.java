package ua.kiev.prog.Controllers;

import ua.kiev.prog.Model.Status;
import ua.kiev.prog.Model.User;
import ua.kiev.prog.Model.Users;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    private Users users = Users.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        User user = null;

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String authorisation = req.getParameter("authorisation");

        if (login != null && password != null) {
            if (authorisation.equals("auth")) {
                if (users.checkUser(login, password)) {
                    user = users.getUser(login);
                } else {
                    resp.sendRedirect("Error.jsp");
                }
            } else if (authorisation.equals("reg")) {
                user = new User(login, password);
                users.add(user);
            }
            user.setStatus(Status.ONLINE);
            resp.sendRedirect("/get?from=" + login);
        } else
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
}
