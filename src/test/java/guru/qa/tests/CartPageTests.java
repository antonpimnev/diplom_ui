package guru.qa.tests;

import guru.qa.helpers.TestData;
import guru.qa.pages.CartPage;
import guru.qa.pages.MainPage;
import guru.qa.pages.SearchResultPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;

@Tag("ui")
@Tag("cart")
public class CartPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    CartPage cartPage = new CartPage();
    private static TestData testData = new TestData();

    @BeforeEach
    public void openMainPage() {
        mainPage.openPage(baseUrl);
    }

    @Test
    @Owner("Anton Pimnev")
    @Story("Корзина")
    @DisplayName("Быстрый поиск и добавление товара в корзину")
    void addToCartTest() {
        mainPage.quickSearchProduct(testData.testItem);
        searchResultPage.addItemToCart(testData.testItem);
    }

    @Test
    @Owner("Anton Pimnev")
    @Story("Корзина")
    @DisplayName("Удаление товара из корзины")
    void removeFromCartTest() {
        mainPage.quickSearchProduct(testData.testItem);
        searchResultPage.addItemToCart(testData.testItem);
        searchResultPage.continueAfterAddItemToCart();
        mainPage.goToCart();
        cartPage.removeItemFromCart(testData.testItem);
    }
}
