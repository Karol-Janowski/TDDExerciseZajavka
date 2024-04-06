package pl.zajavka;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<User> findByName(String name) {
        return dataBase.values().stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
    }

    public Map<String, User> findAll() {
        return dataBase;
    }

    public void update(String oldMail, User userUpdate) {
        if (!dataBase.containsKey(oldMail)) {
            throw new RuntimeException(
                    String.format("User with email: [%s] doesnt exist", oldMail)
            );
        }
        if (!oldMail.equals(userUpdate.getEmail())) {
            dataBase.remove(oldMail);
        }
        dataBase.put(userUpdate.getEmail(), userUpdate);
    }




    public void delete(String email) {
        if (dataBase.containsKey(email)) {
            dataBase.remove(email);
        } else {
            throw new RuntimeException(String.format("User with email: [%s] doesn't exist", email));
        }
    }
}

