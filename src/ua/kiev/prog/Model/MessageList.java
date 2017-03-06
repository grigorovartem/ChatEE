package ua.kiev.prog.Model;

import java.util.LinkedList;
import java.util.List;

public class MessageList {
    private static final MessageList msgList = new MessageList();
    private static final int LIMIT = 100;

    private final List<Message> list = new LinkedList<Message>();

    public static MessageList getInstance() {
        return msgList;
    }

    private MessageList() {
    }

    public synchronized void add(Message m) {
        if (list.size() + 1 == LIMIT) {
            list.remove(0);
        }
        list.add(m);
    }

    public List<Message> getList() {
        return list;
    }
}
