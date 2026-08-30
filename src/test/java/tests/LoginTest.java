package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTest extends BaseTest {

    @Test
    void invalidLoginShowsErrorMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.login("not_a_real_user_" + System.currentTimeMillis() + "@example.com", "wrongpassword123");

        String actualError = loginPage.getErrorMessageText();
        assertEquals("Your email or password is incorrect!", actualError);
    }
}
