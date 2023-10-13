package helpDesk;

import core.BaseSelenideTest;
import helpers.TestValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static helpers.StringModifier.getUniqueString;

public class HelpDeskTest extends BaseSelenideTest {

    @Test
    void createTicket() throws InterruptedException {

        String title = getUniqueString(TestValues.TEST_TITLE);
        MainPage mainPage = new MainPage();

        TicketPage ticketPage =
        mainPage.createTicket(title, TestValues.TEST_BODY, TestValues.TEST_EMAIL)
                .openLoginPage()
                .auth("admin","adminat").findTicket(title);

        Assertions.assertTrue(ticketPage.getTitle().contains(title));
        Assertions.assertEquals(ticketPage.getBody(), TestValues.TEST_BODY);
        Assertions.assertEquals(ticketPage.getEmail(), TestValues.TEST_EMAIL);
    }
}
