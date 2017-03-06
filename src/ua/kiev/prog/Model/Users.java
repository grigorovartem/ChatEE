package ua.kiev.prog.Model;

import java.util.LinkedList;
import java.util.List;

public class Users {
    private static Users users;

    private final List<User> list;

    public static Users getInstance() {
        if (users == null){
            users = new Users();
        }
        return users;
    }

    private Users() {
        list = new LinkedList<>();
        list.add(new User("user1", "user1"));
        list.add(new User("user2", "user2"));
        list.add(new User("user3", "user3"));
    }

    public synchronized void add(User user) {
        list.add(user);
    }

    public boolean checkUser(String login, String password) {
        boolean registered = false;
        for (User u : list) {
            if (login.equals(u.getLogin()) && password.equals(u.getPassword())) {
                registered = true;
            }
        }
        return registered;
    }

    public User getUser(String login) {
        User user = null;
        for (User u : list) {
            if (login.equals(u.getLogin())) {
                user = u;
            }
        }
        return user;
    }

    public List<User> getList() {
        return list;
    }
}
