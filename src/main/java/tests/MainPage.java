package tests;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

public class MainPage {
//    Хочу зайти на на udemy.com, попытаться залогиниться с пустыми полями и увидеть присвоение класса user-error пустому полю
//    перейти на https://www.udemy.com
//    проверить, есть ли на странице кнопка "Log in"
//    нажать кнопку Log in
//    удостовериться, открылась страница логина, на странице присутствует заголовок "Log In to Your Udemy Account!"
//    ввести в поле "email" адрес электронной почты
//    поле "пароль" оставить пустым
//    нажать кнопку "Вход"
//    проверить, что пустому полю "пароль" присвоился класс user-error
//    очистить поле с электронной почтой
//    ввести в форму пароль
//    нажать кнопку "Вход"
//    проверить, что пустому полю "email" присвоился класс user-error
    @Test
    public void checkLoginError() {
        String logInBtn = "//a[@data-purpose='header-login']";
        open("https://www.udemy.com");

        $(By.xpath(logInBtn)).should(visible);
        $(By.xpath(logInBtn)).click();

        $("#auth-to-udemy-title").shouldHave(exactText("Log In to Your Udemy Account!"));
        $("input").shouldHave(name("email")).setValue("ww@ee.rr");
        $("#submit-id-submit").click();

        $(By.xpath("//input[@data-purpose='email']")).shouldHave(cssClass("user-error"));
        $("input").shouldHave(name("email")).clear();

        $("input").shouldHave(name("password")).setValue("ww@ee.rr");
        $("#submit-id-submit").click();

        $(By.xpath("//input[@data-purpose='password']")).shouldHave(cssClass("user-error"));
    }

//    Хочу зайти на на udemy.com и проверить корректность отображения карточки учителя
//    перейти на https://www.udemy.com
//    проверить, существует ли на странице div с классом "teach-on-udemy-non-student-cta-wrapper"
//    проскроллить страницу до этого div
//    проверить, что у блока есть фотография
//    проверить, что у блока есть заголовок h3
//    проверить, что в тексте под заголовком есть название школы Udemy
//    проверить, что у блока есть кнопка "Start teaching today"
//    нажать на кнопку, что бы перейти на страницу для учителей
//    проверить, что страница корректно открылась
    @Test
    public void checkTeacherInfo() {
        open("https://www.udemy.com");
        TeacherCardPage teacherInfo = new TeacherCardPage();

        teacherInfo.scrollToCard();
        teacherInfo.checkCardElement(".non-student-cta-image");
        teacherInfo.checkCardElement(".non-student-cta__header");
        teacherInfo.partialCheckCardInfo("Udemy");
        teacherInfo.checkCardElement(".non-student-cta__link");
        teacherInfo.openTeacherPage();
    }

//    Хочу зайти на на udemy.com, ввести данные в строку поиска и выбрать один из вариантов
//    перейти на https://www.udemy.com
//    ввести в строку поиска по сайту слово "java"
//    нажать на 3 строчку в выдаче результатов
//    кликнуть на эту строчку
    @Test
    public void searching() {
        open("https://www.udemy.com");
        SearchPage search = new SearchPage();

        search.searchFor("java");
        new SearchPage().getResult(2).click();
    }

//    Хочу зайти на на udemy.com и добавить в корзину один из продуктов
//    перейти на https://www.udemy.com
//    проскроллить страницу до блока с продуктами
//    в меню товаров выбрать раздел
//    навести курсор на продукт
//    проверить, что появилось окно с описанием продукта
//    проверить, что продукт доступен для покупки
//    проверить, есть ли продукта ярлык "Bestseller"
//    проверить, сколько часов длится обучение по данному продукту
//    если длительность менее 20 часов, нажать на кнопку Add to cart
//    проверить корректность добавления продукта в корзину
    @Test
    public void buyProduct() {
        open("https://www.udemy.com");
        BuyProductPage productBlock = new BuyProductPage();

        productBlock.scrollToProductBlock();
        productBlock.chooseProductSection(4).click();

        sleep(10000);
    }
}

