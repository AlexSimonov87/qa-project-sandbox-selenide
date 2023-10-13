package helpDesk;

import core.BaseSelenidePage;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BaseSelenidePage{

    public TicketsPage auth(String login, String password) {
        $("#userDropdown").click();
        $("#username").setValue(login);
        $("#password").setValue(password).sendKeys(Keys.ENTER);
        return new TicketsPage();
    }
}
