package tests.UI;

import dto.FormData;
import dto.FormFactory;
import dto.NavigationData;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ElementsTest extends BaseTest {

    @Test(description = "Testing Text Box")
    public void testOfTextBox() {
        FormData form = FormFactory.getTextBox();
        elementsSteps.goToElements();
        pageManager.getElementsPage().isPageOpened()
                .useNCheckTextBox(form);
    }

    @Test(description = "Testing Radio Button")
    public void testOfRadioButton() {
        elementsSteps.goToElements();
        pageManager.getElementsPage().isPageOpened()
                .useNCheckRadioButton();
    }

    @Test(description = "Testing Web Tables")
    public void testOfWebTables() {
        FormData form = FormFactory.getWebPages();
        elementsSteps.goToElements();
        pageManager.getElementsPage().isPageOpened()
                .useNCheckWebTables(form);
    }

    @Test(description = "Testing Buttons")
    public void testOfButtons() {
        elementsSteps.goToElements();
        pageManager.getElementsPage().isPageOpened()
                .useNCheckButtons();
    }

    @Test(description = "Testing Links", dataProvider = "navigationData", dataProviderClass = NavigationData.class)
    public void testOfLinks(String linkText, String expectedUrlPart) {
        elementsSteps.goToElements();
        pageManager.getElementsPage().isPageOpened()
                .useNCheckLinks(linkText, expectedUrlPart);

    }

    @Test(description = "Testing Response", dataProvider = "responseAnswers", dataProviderClass = NavigationData.class)
    public void testOfResponse(String linkText, String expectedStatus) {
        elementsSteps.goToElements();
        pageManager.getElementsPage().isPageOpened()
                .useNCheckResponse(linkText, expectedStatus);

    }
}
