package app.users;

import java.util.concurrent.ConcurrentHashMap;

public class Store {
    public ConcurrentHashMap<String, String> users = new ConcurrentHashMap<>();

    public void addUser(String name, String password) {
        users.put(name, password);
    }

    public ConcurrentHashMap<String, String> getUsers() {
        return users;
    }
}
