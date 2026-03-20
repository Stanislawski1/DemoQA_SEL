package dto;

import org.testng.annotations.DataProvider;

public class NavigationData {

    @DataProvider(name = "navigationData")
    public Object[][] navigationData() {
        return new Object[][]{
                {"//a[@id='simpleLink']", "https://demoqa.com/"},
                {"//a[@id='dynamicLink']", "https://demoqa.com/"}
        };
    }

    @DataProvider(name = "responseAnswers")
    public Object[][] response() {
        return new Object[][]{
                {"Created", "Link has responded with staus 201 and status text Created"},
                {"No Content", "Link has responded with staus 204 and status text No Content"},
                {"Moved", "Link has responded with staus 301 and status text Moved Permanently"},
                {"Bad Request", "Link has responded with staus 400 and status text Bad Request"},
                {"Unauthorized", "Link has responded with staus 401 and status text Unauthorized"},
                {"Forbidden", "Link has responded with staus 403 and status text Forbidden"},
                {"Not Found", "Link has responded with staus 404 and status text Not Found"}
        };
    }
}
