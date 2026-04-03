import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ifellowPages.CreateTaskDialogWindowPage;
import ifellowPages.EduJiraLoginPage;
import ifellowPages.EduJiraMenuPage;
import ifellowPages.EduJiraTestProjectPage;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class EduJiraSteps {
    public void login(String login, String password) {
        open("https://edujira.ifellow.ru");
        new EduJiraLoginPage().login(login, password);
        String toolTip = new EduJiraMenuPage().getHeaderDetailsUser().shouldBe(Condition.visible, Duration.ofSeconds(10)).getAttribute("title");
        Assertions.assertEquals(login, toolTip.split(" ")[3]);
    }

    public void openTestProject() {
        new EduJiraMenuPage().goToProjectTest();
        Assertions.assertEquals("Открытые задачи",
                new EduJiraTestProjectPage().getOpenTasksMarker().shouldBe(Condition.visible, Duration.ofSeconds(10)).getText());
    }

    public void checkCountOfTasks(String summaryForTestTask) {
        EduJiraTestProjectPage eduJiraTestProjectPage = new EduJiraTestProjectPage();
        int countTaskBefore = eduJiraTestProjectPage.getCountTasks();
        CreateTaskDialogWindowPage createTaskDialogWindowPage = eduJiraTestProjectPage.createTaskInDialogWindow();
        createTaskDialogWindowPage.createTestTask(summaryForTestTask);
        new EduJiraMenuPage().goToProjectTest();
        int countTaskAfter = eduJiraTestProjectPage.getCountTasks();
        Assertions.assertEquals(countTaskAfter, countTaskBefore + 1);
    }

    public void checkFieldsInTask(String issue, String status, String version) {
        EduJiraMenuPage menuPage = new EduJiraMenuPage();
        menuPage.findIssue(issue);
        EduJiraTestProjectPage issuePage = new EduJiraTestProjectPage();
        Assertions.assertEquals(status, issuePage.getStatusTask().shouldBe(Condition.visible, Duration.ofSeconds(10)).getText());
        Assertions.assertEquals(version, issuePage.getVersionForFix().shouldBe(Condition.visible, Duration.ofSeconds(10)).getText());
    }

    public void createTestTask(String summaryForTestTask) {
        new EduJiraMenuPage().goToProjectTest();
        CreateTaskDialogWindowPage dialogWindow = new EduJiraTestProjectPage().createTaskInDialogWindow();
        dialogWindow.createTestTask(summaryForTestTask);
        dialogWindow.getSectionDialogWindow().shouldBe(Condition.disappear);
        Selenide.sleep(2000);
        EduJiraTestProjectPage testProjectPage = new EduJiraTestProjectPage();
        Assertions.assertEquals(summaryForTestTask, testProjectPage.getSummaryVal().shouldBe(Condition.visible, Duration.ofSeconds(10)).getText());
        testProjectPage.getInWorkButton().click();
        Selenide.sleep(3000);
        testProjectPage.getBusinessProcessesList().click();
        testProjectPage.getCompleteStatus().shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        Selenide.sleep(3000);
        Assertions.assertEquals("ГОТОВО", testProjectPage.getStatusTask().getText());
    }
}
