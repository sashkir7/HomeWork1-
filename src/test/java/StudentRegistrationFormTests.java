import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void beforeEach() {
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void checkRegisterForm() {
        String firstName = "Alex";
        String lastName = "Kireev";
        String email = "sashkir7@mail.ru";
        String phoneNumber = "8965872667";
        String subject = "Physics";
        String address = "Russia, Omsk";
        String state = "NCR";
        String city = "Delhi";
        String sex = "Male";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(sex)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1997");
        $("[aria-label='Choose Saturday, November 22nd, 1997']").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading"));
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(sex),
                text(phoneNumber),
                text(subject),
                text(address),
                text(state),
                text(city),
                text("22 November,1997"));
    }
}