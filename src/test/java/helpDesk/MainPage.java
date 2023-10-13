package helpDesk;

import core.BaseSelenidePage;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BaseSelenidePage {

    public MainPage mainPage;

    public static String uniqueDate(String str) {
        return str + new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
    }

    public static String valueTitle = MainPage.uniqueDate("Кириллица тайтл");

    public MainPage openPage() {
        open("https://at-sandbox.workbench.lanit.ru/");
        return this;
    }

    public MainPage setQueue() {
        $("#id_queue option[value='1']").click();
        return this;
    }

    public MainPage setSummaryOfTheProblem(String value) {
        $("#id_title").setValue(value);
        return this;
    }

    public MainPage setDescriptionOfIssue(String value) {
        $("#id_body").setValue(value);
        return this;
    }

    public MainPage setPriority() {
        $("#id_priority option[value='2']").click();
        return this;
    }

    public MainPage setDueDate(String value) {
        $("#id_due_date").click();
        $("a[title='Next']").click();
        $(byText(value)).click();
        return this;
    }

    public MainPage setEmail(String value) {
        $("#id_submitter_email").setValue(value);
        $("button[type='submit']").click();
        return this;
    }


    public MainPage createTicket(String titleValue, String bodyValue, String emailValue) {
        openPage();
        setQueue();
        setSummaryOfTheProblem(titleValue);
        setDescriptionOfIssue(bodyValue);
        setPriority();
        setDueDate("15");
        setEmail(emailValue);
        return this;
    }

    public LoginPage openLoginPage() {
        return new LoginPage();
    }

}
