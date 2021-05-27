package tests;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class SearchPage {
    public void searchFor(String text) {
        $(By.name("q")).val(text);
    }

    public void searchForAndPressEnter(String text) {
        $(By.name("q")).val(text).pressEnter();
    }

    public SelenideElement partialSearch(String text) {
        SelenideElement autocompleteForm = $("a.udlite-block-list-item");
        return autocompleteForm.shouldHave(Condition.ownText(text));
    }

    public SelenideElement getResult(int index) {
        SelenideElement autocompleteForm = $("a.udlite-block-list-item");
        return $("a.udlite-block-list-item", index);
    }
}