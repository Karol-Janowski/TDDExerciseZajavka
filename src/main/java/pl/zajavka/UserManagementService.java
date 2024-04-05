package pl.zajavka;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserManagementService {

    private Map<String, User> dataBase = new HashMap<>();

    public void create(User user) {
        if (!dataBase.containsKey(user.getEmail())) {
            dataBase.put(user.getEmail(), user);
        } else {
            throw new RuntimeException(String.format("User with email: [%s] is already created", user.getEmail()));
        }
    }

    public Optional<User> findByEmail(String email) {
        return dataBase.entrySet().stream()
                .filter(entry -> entry.getKey().equals(email))
                .map(entry -> entry.getValue())
                .findFirst();
    }

    public Optional<User> findByName(String name) {
        return dataBase.entrySet().stream()
                .filter(entry -> entry.getValue().getName().equals(name))
                .map(entry -> entry.getValue())
                .findFirst();
    }

    public Map<String, User> findAll() {
        return dataBase;
    }

    public void update(String oldMail, User newMail) {
        if (dataBase.containsKey(oldMail)) {
            dataBase.replace(oldMail, dataBase.get(oldMail), newMail);

        } else {
            throw new RuntimeException(String.format("User with email: [%s] doesnt exist", oldMail));
        }
    }


    public void delete(String email) {
        if (dataBase.containsKey(email)) {
            dataBase.remove(email);
        } else {
            throw new RuntimeException(String.format("User with email: [%s] doesn't exist", email));
        }
    }
}

