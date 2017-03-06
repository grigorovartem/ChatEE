package ua.kiev.prog.Controllers;

import ua.kiev.prog.Model.MessageList;
import ua.kiev.prog.Model.User;
import ua.kiev.prog.Model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetListServlet extends HttpServlet {

    private MessageList msgList = MessageList.getInstance();
    private Users users = Users.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        String fromStr = req.getParameter("from");
        User user = users.getUser(fromStr);

        req.setAttribute("msg", msgList.getList());
        req.setAttribute("user", user);
        req.setAttribute("rooms", session.getAttribute("rooms"));
        req.setAttribute("currentRoom", req.getParameter("room"));

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mainChat.jsp");
        dispatcher.forward(req, resp);
    }
}
