package guru.qa.pages.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class NavigationMenu {

    private ElementsCollection menuElements = $$(".CatLevel0"); //40 = список элементов меню

    public void quickSearchInput(String productName) {
        $x("//input[@id='quick_find_keyword']").setValue(productName).pressEnter();
    };

    public void checkMenuElements(List<String> menuElement) {
        menuElements.filter(visible).shouldHave(CollectionCondition.texts(menuElement));
    }

    public void checkCountMenuElements(int resultCount) {
        menuElements.should(CollectionCondition.size(resultCount));
    }

    public void clickMenuElement(String name) {
        menuElements.find(text(name)).click();
    }

}