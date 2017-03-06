package ua.kiev.prog.Controllers;

import ua.kiev.prog.Model.Message;
import ua.kiev.prog.Model.MessageList;
import ua.kiev.prog.Model.User;
import ua.kiev.prog.Model.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    private MessageList msgList = MessageList.getInstance();
    private Users users = Users.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String from = req.getParameter("from");

        User user = users.getUser(from);
        String to = req.getParameter("toUser");
        String message = req.getParameter("message");
        Message msg = new Message(from, message);
        if (to != null) {
            msg.setTo(to);
        }
        String room = req.getParameter("room");
        user.setRoom(room);
        msg.setRoom(room);
        if (msg != null) {
            msgList.add(msg);
            resp.sendRedirect("/get?from=" + user.getLogin() + "&room=" + room);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
