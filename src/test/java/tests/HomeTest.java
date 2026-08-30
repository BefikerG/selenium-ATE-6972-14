package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeTest extends BaseTest {

    @Test
    void homePageLoadsWithCorrectTitle() {
        driver.get("https://automationexercise.com");
        assertEquals("Automation Exercise", driver.getTitle());
    }
}
