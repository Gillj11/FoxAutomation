package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Excel;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Page {

    @FindBy(css = ".Header_userIcon_1VTS5")
    WebElement userIcon;

    @FindBy(xpath = "//div[@class='Header_navLinks_1WBD8']/a[text()='Shows']")
    WebElement showsLink;

    @FindBy(css = ".Tile_title_2XOxg")
    List<WebElement> showsVideosTile;

    @FindBy(xpath = "//div[contains(@class,'PageHeaderBrowse_tabContainer_3htBb')]/a[text()='FX']")
    WebElement FXLink;

    @FindBy(xpath = "//div[contains(@class,'PageHeaderBrowse_tabContainer_3htBb')]/a[text()='National Geographic']")
    WebElement nationalGeographicLink;

    @FindBy(xpath = "//div[contains(@class,'PageHeaderBrowse_tabContainer_3htBb')]/a[text()='FOX Sports']")
    WebElement foxSportsLink;

    @FindBy(xpath = "//div[contains(@class,'PageHeaderBrowse_tabContainer_3htBb')]/a[text()='All Shows']")
    WebElement allShowsLink;

    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> duplicateTitles = new ArrayList<String>();


    public void clickUserIcon() {
        userIcon.click();
    }

    public void clickShowsLink() throws Exception{
        showsLink.click();
        Thread.sleep(3000);
    }

    public void clickFXLink() throws Exception{
        FXLink.click();
        Thread.sleep(3000);
    }

    public void clickNationalGeographicLink() throws Exception {
        nationalGeographicLink.click();
        Thread.sleep(3000);
    }

    public void clickFoxSportsLink() throws Exception {
        foxSportsLink.click();
        Thread.sleep(3000);
    }

    public void clickAllShowsLink() throws Exception{
        allShowsLink.click();
        Thread.sleep(3000);
    }

    /**
     * To get the last four video titles
     * @throws Exception
     */
    public void getLastFourVideoTitles() throws Exception {
        Thread.sleep(3000);
        int videoTitles = showsVideosTile.size();
        for (int i = videoTitles - 1; i > videoTitles - 5; i--) {
            System.out.println(showsVideosTile.get(i).getText());
            titles.add(showsVideosTile.get(i).getText());
        }
        Excel.writeListToFile("OutPutData.xls", titles);
    }

    /**
     * To verify duplicate titles from all videos
     * @throws Exception
     */
    public void verifyDuplicateTitles() throws Exception {
        Thread.sleep(5000);
        for (int i = 0; i < titles.size(); i++) {
            if (findDuplicateTitle(titles.get(i))) {
                System.out.println("Found Duplicate value: " + titles.get(i));
                duplicateTitles.add(titles.get(i));
            }
        }
    }

    /**
     * To find a duplicate video by using title
     * @param title
     * @return boolean
     */
    public boolean findDuplicateTitle(String title) throws Exception{
        boolean found = false;
        int videoTitles = showsVideosTile.size();
        for (int i = 0; i<videoTitles; i++) {
            System.out.println("Comparing with "+showsVideosTile.get(i).getText());
            if ((showsVideosTile.get(i).getText().trim()).equals(title.trim())) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * To write final duplicated values into an excel sheet
     * @throws Exception
     */
    public void writeDuplicateValues() throws Exception{
        Excel.modifyExistingFile("OutPutData.xls", duplicateTitles);
    }

}
