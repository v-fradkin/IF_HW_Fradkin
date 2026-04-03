package ifellowPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class EduJiraTestProjectPage {
    private final SelenideElement tasksCounterStr = $x("//div[contains(@class,'pager')]//div[@class='showing']/span").as("Блок с кол-вом задач в проекте");
    private final SelenideElement createTaskButton = $x("//button[.//span[contains(text(),'Создать задачу')]]").as("Кнопка создания задачи");
    private final SelenideElement openInDialogWindowButtonForTask = $x("//button[contains(text(),'Открыть в диалоговом окне')]").as("Кнопка для открытия окна создания задачи");
    private final SelenideElement statusTask = $x("//span[@id='status-val']//span[contains(@class, 'jira-issue-status-lozenge')]").as("Поле со статусом задачи");
    private final SelenideElement versionForFix = $x("//span[@id='fixfor-val']//a").as("Поле с версией для исправления");
    private final SelenideElement summaryVal = $x("//h1[@id='summary-val']").as("Тема задачи");
    private final SelenideElement openTasksMarker = $x("//span[@id='issues-subnavigation-title']").as("Маркер, на который ориентируемся, что выполнен переход на страницу");
    private final SelenideElement businessProcessesList = $x("//a[@id='opsbar-transitions_more']").as("Список бизнес-процессов");
    private final SelenideElement inWorkButton = $x("//a[@id='action_id_21']").as("Кнопка для статуса 'В работе'");
    private final SelenideElement completeStatus = $x("//span[@class='trigger-label' and text()='Выполнено']").as("Перевод задачи в статус выполненной");


    public int getCountTasks() {
        return Integer.parseInt(tasksCounterStr.shouldBe(Condition.visible, Duration.ofSeconds(30))
                .getText()
                .split(" ")[2]);
    }

    public CreateTaskDialogWindowPage createTaskInDialogWindow() {
        createTaskButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        openInDialogWindowButtonForTask.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        return new CreateTaskDialogWindowPage();
    }

    public SelenideElement getStatusTask() {
        return statusTask;
    }

    public SelenideElement getVersionForFix() {
        return versionForFix;
    }

    public SelenideElement getSummaryVal() {
        return summaryVal;
    }

    public SelenideElement getOpenTasksMarker() {
        return openTasksMarker;
    }

    public SelenideElement getBusinessProcessesList() {
        return businessProcessesList;
    }

    public SelenideElement getInWorkButton() {
        return inWorkButton;
    }

    public SelenideElement getCompleteStatus() {
        return completeStatus;
    }
}
