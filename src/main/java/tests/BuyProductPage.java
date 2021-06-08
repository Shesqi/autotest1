package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BuyProductPage {
    SelenideElement productBlock = $(By.xpath("//div[@data-purpose='skills-hub-unit']"));

    ElementsCollection productBlockTabs = productBlock.$$(".udlite-nav-button-container");

    public void scrollToProductBlock() {
        productBlock.scrollIntoView(true);
    }

    public SelenideElement chooseProductSection(int index) {
        return productBlockTabs.get(index);
    }

    public void productHover(int sectionIndex, int cardIndex) {
//        productBlock.find(By.xpath("//div[@role='tabpanel'], div[@data-index='0']"));


//        возьмем раздел по индексу(передадим в метод), в котором лежит button с классом tabs--active... и у него уже возьмем карточку с нужным индексом(так же передадим в метод)
//        у активного раздела всегда tabindex=0, у неактивных tabindex=-1

        //tabs--active
    }
}
