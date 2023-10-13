package helpDesk;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.BaseSelenidePage;
import helpers.TestValues;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TicketPage extends BaseSelenidePage{

    public String getEmail() {
        ElementsCollection elementsCollection2 = $$("tbody td");
        List<String> stringKeyValues2 = new ArrayList<>();
        for (SelenideElement element: elementsCollection2) {
            stringKeyValues2.add(element.getText());
        }
        String email = null;
        for (String x:stringKeyValues2) {
            if (x.equals(TestValues.TEST_EMAIL)) {
                email = x;
            }
        }
        return email;
    }

    public String getTitle() {
        return $(".table-responsive h3").getText();
    }

    public String getBody() {
        return $("#ticket-description p").getText();
    }

}
