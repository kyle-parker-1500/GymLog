package com.example.hw04_gymlog_v300;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// could only get it to work with JUnit4
public class TestLogin {
    String username;
    String password;
    String adminUsername;
    String adminPassword;
    int userId;

    @Before
    public void setUp() {
        username = "testuser1";
        password = "testuser1";
        adminUsername = "admin1";
        adminPassword = "admin1";
        userId = 0;
    }

    @After
    public void tearDown() {
        username = "";
        password = "";
        adminUsername = "";
        adminPassword = "";
    }

    @Test
    public void userTest() {
        assertNotNull(username);
        assertNotNull(password);
        assertNotNull(userId);

        assertEquals(username, password);
        assertEquals(username, "testuser1");
        assertEquals(password, "testuser1");
        assertNotEquals(adminPassword, password);
        assertEquals(userId, 0);
    }

    @Test
    public void adminTest() {
        assertNotNull(adminUsername);
        assertNotNull(adminPassword);

        assertEquals(adminUsername, adminPassword);
        assertEquals(adminUsername, "admin1");
        assertEquals(adminPassword, "admin1");
        assertNotEquals(adminUsername, username);
        assertNotEquals(userId, adminPassword);
    }
}
