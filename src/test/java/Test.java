import pages.AccountPage;
import pages.HomePage;
import util.Browser;

public class Test {

    public static void main(String args[]) throws Exception {

        Browser browser = new Browser();
        browser.launch();

        HomePage homePage = new HomePage();
        homePage.clickUserIcon();

        AccountPage accountPage = new AccountPage();

        // ===== Perform action by creating a profile =====
        accountPage.clickSignUpButton();
        accountPage.createProfile();
        accountPage.clickAccountCompleteDoneButton();

// =========if account is already created then use following two lines to do action by login to the existing account =======
//      accountPage.clickSignInButton();
//      accountPage.signIn();

        homePage.clickShowsLink();
        browser.executeScript("window.scrollBy(0,2000)");
        homePage.getLastFourVideoTitles();

        //For FX Link
        browser.executeScript("window.scrollBy(0,-2000)");
        homePage.clickFXLink();
        browser.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        homePage.verifyDuplicateTitles();

        //For National Geographic Link
        browser.executeScript("window.scrollBy(0,-2000)");
        homePage.clickNationalGeographicLink();
        browser.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        homePage.verifyDuplicateTitles();

        //For Fox Sports Link
        browser.executeScript("window.scrollBy(0,-2000)");
        homePage.clickFoxSportsLink();
        browser.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        homePage.verifyDuplicateTitles();

        //For Show All Link
        browser.executeScript("window.scrollBy(0,-2000)");
        homePage.clickAllShowsLink();
        browser.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
        browser.executeScript("window.scrollBy(0,-2000)");
        browser.executeScript("window.scrollBy(0,2000)");
        homePage.verifyDuplicateTitles();
        homePage.writeDuplicateValues();

        browser.close();

    }

}
