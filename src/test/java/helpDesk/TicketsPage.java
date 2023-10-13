package helpDesk;

import core.BaseSelenidePage;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class TicketsPage extends BaseSelenidePage{
    public TicketPage findTicket(String str) {
        $("#search_query").setValue(str).sendKeys(Keys.ENTER);
        $(".tickettitle").click();
        return new TicketPage();
    }
}

