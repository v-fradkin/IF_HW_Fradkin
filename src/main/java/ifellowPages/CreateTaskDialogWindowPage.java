package ifellowPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class CreateTaskDialogWindowPage {
    private final SelenideElement issueTypeField = $x("//input[@id='issuetype-field']").as("Тип задачи");
    private final SelenideElement sectionDialogWindow = $x("//section[@id='prefillable-create-issue-dialog']").as("Секция диалогового окна");
    private final SelenideElement summary = $x("//input[@id='summary']").as("Тема");
    private final SelenideElement fixVersionSelect = $x("//select[@id='fixVersions']").as("Исправить в версиях");
    private final SelenideElement epicField = $x("//input[@id='customfield_10100-field']").as("Ссылка на эпик");
    private final SelenideElement sprintField = $x("//input[@id='customfield_10104-field']").as("Спринт");
    private final SelenideElement priorityField = $x("//input[@id='priority-field']").as("Приоритет");
    private final SelenideElement assignToMeButton = $x("//button[@id='assign-to-me-trigger']").as("Назначить меня");
    private final SelenideElement createButton = $x("//input[@id='create-issue-submit']").as("Кнопка создания задачи");

    public void createTestTask(String summaryForTestTask) {
        issueTypeField.shouldBe(Condition.visible, Duration.ofSeconds(5)).setValue("Ошибка");
        summary.setValue(summaryForTestTask);
        switchTo().frame($x("//iframe[contains(@id, 'mce_')]"));
        $x("//body").setValue("Тестовая задача с тестовым описанием");
        switchTo().defaultContent();
        fixVersionSelect.selectOption("Version 2.0");
        assignToMeButton.click();
        epicField.click();
        $x("//ul[@aria-label='Предложения']//li[1]").click();
        sprintField.setValue("Доска спринт 1");
        priorityField.setValue("Low");
        createButton.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
    }

    public SelenideElement getSectionDialogWindow() {
        return sectionDialogWindow;
    }
}
