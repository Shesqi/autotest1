package tests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.ownText;
import static com.codeborne.selenide.Selenide.$;

public class TeacherCardPage {
    SelenideElement teacherInfo = $(".main-content-wrapper").find(By.className("teach-on-udemy-non-student-cta-wrapper"));

    public void partialCheckCardInfo(String text) {
        teacherInfo.find(".non-student-cta__content").shouldHave(ownText(text));
    }

    public void scrollToCard() {
        teacherInfo.scrollIntoView(true);
    }

    public void checkCardElement(String element) {
        teacherInfo.find(element);
    }

    public void openTeacherPage() {
        teacherInfo.find(".non-student-cta__link a").click();
        $(".teach-page").find(".teach-page__heading").shouldHave(ownText("Come teach with us"));
    }
}
