package pl.zajavka;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserManagementService {

    private Map<String, User> dataBase = new HashMap<>();
    public void create(User user) {
        dataBase.put(user.getEmail(), user);
    }

    public Optional<User> findByEmail(String email) {
        return dataBase.entrySet().stream()
                .filter(entry -> entry.getKey().equals(email))
                .map(entry -> entry.getValue())
                .findFirst();
    }


}
