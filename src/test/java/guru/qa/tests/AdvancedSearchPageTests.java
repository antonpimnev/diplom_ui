package guru.qa.tests;

import guru.qa.pages.SearchResultPage;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import guru.qa.pages.MainPage;
import guru.qa.pages.AdvancedSearchPage;

@Tag("UITests")
public class AdvancedSearchPageTests extends BaseTest {
    private MainPage mainPage = new MainPage();
    private AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @BeforeEach
    void openSearchPage() {
        mainPage.goAdvancedSearchPage();
    }

    @Test
    @Owner("Anton Pimnev")
    @Story("Расширенный поиск")
    @DisplayName("Проверка отображения полей на странице поиска")
    void advancedSearchInputsTest() {
        advancedSearchPage.checkElements();
    }

    @Test
    @Owner("Anton Pimnev")
    @Story("Расширенный поиск")
    @DisplayName("Расширенный поиск с фильтрами")
    void advancedSearchTest() {
        advancedSearchPage.searchWithFilters();
        searchResultPage.checkCountResultOfSearch(3);
    }

}