import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EduJiraScenarioTest {
    private final EduJiraSteps steps = new EduJiraSteps();

    private final String login = "AT2";
    private final String password = "Qwerty123";
    private final String issue = "TestSeleniumATHomework";
    private final String statusTask = "СДЕЛАТЬ";
    private final String versionForFix = "Version 2.0";
    private final String summaryForTestTask = "Test task";


    @BeforeAll
    static void setupDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterEach
    void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    void loginTest() {
        steps.login(login, password);
    }

    @Test
    void goToProjectTest() {
        steps.login(login, password);
        steps.openTestProject();
    }

    @Test
    void checkCountTasks() {
        steps.login(login, password);
        steps.openTestProject();
        steps.checkCountOfTasks(summaryForTestTask);
    }

    @Test
    void checkFieldsInTask() {
        steps.login(login, password);
        steps.openTestProject();
        steps.checkCountOfTasks(summaryForTestTask);
        steps.checkFieldsInTask(issue, statusTask, versionForFix);
    }

    @Test
    void createTestTask() {
        steps.login(login, password);
        steps.openTestProject();
        steps.checkCountOfTasks(summaryForTestTask);
        steps.checkFieldsInTask(issue, statusTask, versionForFix);
        steps.createTestTask(summaryForTestTask);
    }
}
