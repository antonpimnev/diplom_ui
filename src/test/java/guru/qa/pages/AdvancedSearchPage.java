package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AdvancedSearchPage {

    private SelenideElement content = $("#content");

    @Step("Проверка отображения полей на странице поиска")
    public AdvancedSearchPage checkElements() {
        content.$("h1").shouldHave(text("Расширенный поиск")).shouldBe(visible);
        content.$$("p").shouldHave(textsInAnyOrder("Ключевые слова: ",
                "Категории: ",
                " Включая подкатегории",
                "Производитель: ",
                "Цена от: ",
                "до: "));
        content.$$("input").filterBy(attribute("type", "text")).shouldHave(size(3));
        content.$$("input").filterBy(attribute("type", "checkbox")).shouldHave(size(1));
        content.$$("select").shouldHave(size(2));
        return this;
    }

    @Step("Расширенный поиск c фильтрацией")
    public AdvancedSearchPage searchWithFilters() {
        $x("//input[@name='keywords']").setValue("Lowa");
        $x("//select[@name='categories_id']").click();
        $x("//option[contains(text(),'Обувь')]").click();
        $x("//button[@type='submit']").shouldHave(text(" Искать")).click();
        return this;
    }
}
