package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ReadData;

import java.util.List;

public class AccountPage extends Page {

    @FindBy(css = ".Account_signUp_3SpTs")
    WebElement signUp;

    @FindBy(css = ".Account_signIn_Q0B7n")
    WebElement signIn;

    @FindBy(name = "signupFirstName")
    WebElement firstName;

    @FindBy(name = "signupLastName")
    WebElement lastName;

    @FindBy(name = "signupEmail")
    WebElement signUpEmailAddress;

    @FindBy(name = "signupPassword")
    WebElement signUpPassword;

    @FindBy(css = ".AccountSignupDropdown_headerInnerContainer_BaXaz")
    WebElement gender;

    @FindBy(css = ".AccountSignupDropdown_item_SGgzW")
    List<WebElement> genderValues;

    @FindBy(xpath = "//input[@placeholder='Birthdate']")
    WebElement birthDate;

    @FindBy(xpath = "//div[@class='Account_signupButtonDesktop_1PCXs']/button[text()='Create Profile']")
    WebElement createProfileButton;


    @FindBy(name = "signinEmail")
    WebElement signInEmailAddress;

    @FindBy(name = "signinPassword")
    WebElement signInPassword;

    @FindBy(xpath = "//button[text()='Sign In']")
    WebElement profileSignIn;

    @FindBy(xpath = "//button[text()='Done']")
    WebElement accountCompleteDoneButton;

    public void clickSignUpButton() {
        signUp.click();
    }

    public void clickSignInButton() {
        signIn.click();
    }

    public void clickAccountCompleteDoneButton() throws Exception{
        accountCompleteDoneButton.click();
        Thread.sleep(3000);
    }

    /**
     * To create profile
     * @throws Exception
     */
    public void createProfile() throws Exception{
        ReadData readData = new ReadData();
        firstName.sendKeys(readData.getFirstName());
        lastName.sendKeys(readData.getLastName());
        signUpEmailAddress.sendKeys(readData.getSignUpEmailAddress());
        signUpPassword.sendKeys(readData.getSignUpPassword());
        gender.click();
        for(int i=0;i<genderValues.size();i++){
            if((genderValues.get(i).getText()).equalsIgnoreCase(readData.getGender())){
                genderValues.get(i).click();
            }
        }
        birthDate.sendKeys(readData.getDateOfBirth());
        createProfileButton.click();
        Thread.sleep(4000);
    }

    /**
     * To login to an existing account
     */
    public void signIn() {
        ReadData readData = new ReadData();
        signInEmailAddress.sendKeys(readData.getSignInEmailAddress());
        signInPassword.sendKeys(readData.getSignInPassword());
        profileSignIn.click();
    }


}
