package pl.zajavka;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserManagementService userManagementService = new UserManagementService();

        userManagementService.create(
                User.builder()
                        .name("karol")
                        .surname("janowski")
                        .email("karoljanowski@gmail.com")
                        .build());

        userManagementService.create(
                User.builder()
                        .name("marcel")
                        .surname("kawalec")
                        .email("marcelkawalec@gmail.com")
                        .build());

        userManagementService.create(
                User.builder()
                        .name("milosz")
                        .surname("grabowski")
                        .email("miloszgrabowski@gmail.com")
                        .build());


    }


}
