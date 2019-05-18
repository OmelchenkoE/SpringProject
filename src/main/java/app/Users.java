package app;

import java.util.HashMap;

public class Users {
    private HashMap<String, String> users = new HashMap<>();

    public void addUser(String name, String password) {
        users.put(name, password);
    }
    public HashMap<String, String> getUsers(){
        return users;
    }
}