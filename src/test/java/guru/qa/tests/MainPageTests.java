package guru.qa.tests;

import guru.qa.helpers.TestData;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import guru.qa.pages.MainPage;
import guru.qa.pages.SearchResultPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.baseUrl;

@Tag("ui")
public class MainPageTests extends BaseTest {
    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    private static TestData testData = new TestData();

    @BeforeEach
    public void openMainPage() {
        mainPage.openPage(baseUrl);
    }

    @Test
    @Owner("Anton Pimnev")
    @Story("Главная страница")
    @DisplayName("Проверка наличия логотипа на главной странице")
    void checkLogoTest() {
        mainPage.checkLogo();
    }

    static Stream<Arguments> checkNavMenuButtonsTest() {
        return Stream.of(
                Arguments.of(testData.menuElementsCount, TestData.menuElements)
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка наличия кнопок {1} в меню и их общее кол-во {0}")
    @Owner("Anton Pimnev")
    @Story("Меню")
    @DisplayName("Проверка меню на главной странице")
    void checkNavMenuButtonsTest(int count, List<String> menuElements) {
        mainPage.checkNavMenuElementsCount(count)
                .checkNavMenuElements(menuElements);
    }

    static Stream<Arguments> checkSubcategoryTest() {
        return Stream.of(Arguments.of("Обувь",
                        List.of("5.11 Tactical (США)", "DexShell", "Dragon Tooth", "Elkland", "Garsing", "LOWA",
                                "Moretan", "Pentagon", "Prabos", "RockRooster", "Salomon", "Sibearian", "STURMER", "X-Bionic",
                                "Бутекс", "Оригинал", "Россия", "Фарадей (РФ)", "Все производители")),
                Arguments.of("Медицина",
                        List.of("LEAF Project (РФ)",
                                "STURMER",
                                "Wartech",
                                "Апполо",
                                "Оригинал",
                                "Россия",
                                "Все производители")));
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка наличия подкатегорий {1} в категории {0}")
    @Owner("Anton Pimnev")
    @Story("Меню")
    void checkSubcategoryTest(String category, List<String> subcategory) {
        mainPage.findCategory(category)
                .checkSubcategory(subcategory);

    }

    @ValueSource(strings = {"Муляж функционального маркера бедствия FMA MS2000", "Фонарь Olight Baton 3 Pro"})
    @DisplayName("Проверка результатов поиска")
    @Owner("Anton Pimnev")
    @Story("Быстрый поиск")
    @ParameterizedTest
    void checkSearchResult(String productName) {
        mainPage.quickSearchProduct(productName);
        searchResultPage.verifySearchResult(productName);
    }

    @CsvSource({
            "Муляж функционального маркера бедствия FMA MS2000, 1.110 руб.",
            "Фонарь Olight Baton 3 Pro,  7.000 руб."
    })
    @DisplayName("Проверка соотвествия что товар {0} соотвествует заявленной цене {1}")
    @Owner("Anton Pimnev")
    @Story("Быстрый поиск")
    @ParameterizedTest
    void checkProductPrice(String productName, String price){
        mainPage.quickSearchProduct(productName);
        searchResultPage.verifyProductPrice(productName,price);
    }
}
