package guru.qa.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.NavigationMenu;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private NavigationMenu menu = new NavigationMenu();

    private SelenideElement
            logo = $(".logo");

    @Step("Открыть страницу")
    public void openPage(String url) {
        open(url);
    }

    @Step("Проверить наличие логотипа на главной странице")
    public MainPage checkLogo() {
        logo.shouldBe(visible);
        return this;
    }

    @Step("Проверить количество элементов меню")
    public MainPage checkNavMenuElementsCount(int resultCount) {
        menu.checkCountMenuElements(resultCount);
        return this;
    }

    @Step("Проверить список элементов меню")
    public MainPage checkNavMenuElements(List<String> menuElement) {
        menu.checkMenuElements(menuElement);
        return this;
    }

    @Step("Проверить наличие категории на странице")
    public MainPage findCategory(String category) {
        $x("//a[contains(text(),'" + category + "')]").click();
        return this;
    }

    @Step("Проверить наличие субкатегории на странице")
    public MainPage checkSubcategory(List<String> subcategory) {
        $$(".MANUFACTURER_SORT a").filter(visible)
                .shouldHave(CollectionCondition.texts(subcategory));
        return this;
    }

    @Step("Быстрый поиск с главной страницы")
    public MainPage quickSearchProduct(String productName) {
        menu.quickSearchInput(productName);
        return this;
    }

    @Step("Перейти к странице расширенного поиска")
    public MainPage goAdvancedSearchPage() {
        $x("//a[contains(text(),'Расширенный поиск')]").click();
        return this;
    }

    @Step("Перейти к корзине")
    public MainPage goToCart() {
        $x("//a[contains(text(),'Корзина')]").click();
        return this;
    }
}