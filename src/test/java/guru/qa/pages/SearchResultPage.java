package guru.qa.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    @Step("Проверка результатов поиска по названию")
    public SearchResultPage verifySearchResult(String result) {
        $x("//a[contains(text(),'" + result + "')]").should(Condition.visible).shouldHave(Condition.text(result));
        return this;
    }

    @Step("Проверка результатов поиска по названию и цене")
    public SearchResultPage verifyProductPrice (String product, String price) {
        $x("//a[contains(text(),'" + product + "')]").should(Condition.visible).shouldHave(Condition.text(product));
        $(".itemDescriptionPrice").shouldHave(Condition.text(price));
        return this;
    }

    @Step("Подсчёт числа позиций в результате поиска")
    public SearchResultPage checkCountResultOfSearch(int count) {
        $(".pageItem").$$(".itemNewProductsDefault").shouldHave(sizeGreaterThanOrEqual(count));
        return this;
    }

    @Step("Добавление найденного товара в корзину")
    public SearchResultPage addItemToCart(String testItem) {
        $x("//a[contains(text(),'" + testItem + "')]").parent().parent().$(".button").click();
        $(".cart_popuptext").shouldHave(Condition.text("Товар добавлен в корзину!"));
        return this;
    }

    @Step("Продолжаем покупки")
    public SearchResultPage continueAfterAddItemToCart() {
        $x("//span[contains(text(),'Продолжить покупки')]").click();
        return this;
    }
}