package ifellowPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class EduJiraMenuPage {
    private final SelenideElement projectsMenu = $x("//a[@id='browse_link']").as("Меню в шапке страницы");
    private final SelenideElement testProject = $x("//a[@id='admin_main_proj_link_lnk']").as("Проект Test");
    private final SelenideElement findWindow = $x("//input[@id='quickSearchInput']").as("Поисковое окно");
    private final SelenideElement headerDetailsUser = $x("//a[@id='header-details-user-fullname']").as("Информация о пользовательском профиле");

    public void goToProjectTest() {
        projectsMenu.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        testProject.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public void findIssue(String issue) {
        findWindow.setValue(issue).pressEnter();
    }

    public SelenideElement getHeaderDetailsUser() {
        return headerDetailsUser;
    }
}
