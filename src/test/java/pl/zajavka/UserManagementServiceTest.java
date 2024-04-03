package pl.zajavka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserManagementServiceTest {

    private UserManagementService userManagementService;

    @BeforeEach
    void init() {
        this.userManagementService = new UserManagementService();
    }

    @Test
    void shouldCreateUserCorrectly() {
        //given
        var user = someUser();

        //when
        userManagementService.create(user);

        var result = userManagementService.findByMail(user.getMail());

        //then
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(user, result.get());
    }

    @Test
    void shouldCreateMultipleUsersCorrectly() {
        //given
            var user1 = someUser().withEmail("email1@gmail.com");
            var user2 = someUser().withEmail("email2@gmail.com");
            var user3 = someUser().withEmail("email3@gmail.com");

        //when
        userManagementService.create(user1);
        userManagementService.create(user2);
        userManagementService.create(user3);

        var result1 = userManagementService.findByEmail(user1.getEmail());
        var result2 = userManagementService.findByEmail(user2.getEmail());
        var result3 = userManagementService.findByEmail(user3.getEmail());
        var all = userManagementService.findAll();

        //then
        Assertions.assertEquals(3, all.size());
        Assertions.assertTrue(result1.isPresent());
        Assertions.assertEquals(user1, result1.get());



    }
}
