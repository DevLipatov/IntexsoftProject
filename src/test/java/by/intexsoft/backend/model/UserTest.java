package by.intexsoft.backend.model;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testUser() {
        User user = new User();
        user.username = "admin";
        user.password = "password";
        Assert.assertEquals("admin", user.username);
        Assert.assertEquals("password", user.password);
    }
}
