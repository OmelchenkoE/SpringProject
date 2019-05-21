package app.configs.users;

import java.util.HashMap;

public class Store {
    //it can use atomicHashMap as well
    public HashMap<String, String> users = new HashMap<>();

    public void addUser(String name, String password) {
        users.put(name, password);
    }

    public HashMap<String, String> getUsers() {
        return users;
    }
}
