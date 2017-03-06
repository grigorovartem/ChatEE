package ua.kiev.prog.Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomServlet extends HttpServlet {

    private List<Integer> rooms = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int i = Integer.parseInt(req.getParameter("room"));
        rooms.add(i);
        session.setAttribute("rooms", rooms);

        resp.sendRedirect("/get?from=" + req.getParameter("from"));
    }
}
