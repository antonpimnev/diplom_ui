package guru.qa.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    @Step("Удаление товара из корзины")
    public CartPage removeItemFromCart(String testItem) {
        $x("//a[contains(text(),'" + testItem + "')]").parent().parent().parent().$$("button")
                .findBy(attribute("class", "button btn btn-secondary add-to-cart cart_delete")).click();
        $x("//p[contains(text(),'Корзина пуста.')]").shouldBe(Condition.visible);
        return this;
    }
}
