package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadData {

    public ReadData(){
        readProperties();
    }


    String url;
    String browser;
    String signUpEmailAddress;
    String signUpPassword;
    String firstName;
    String lastName;
    String gender;
    String dateOfBirth;
    String signInEmailAddress;
    String signInPassword;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getSignUpEmailAddress() {
        return signUpEmailAddress;
    }

    public void setSignUpEmailAddress(String signUpEmailAddress) {
        this.signUpEmailAddress = signUpEmailAddress;
    }

    public String getSignUpPassword() {
        return signUpPassword;
    }

    public void setSignUpPassword(String signUpPassword) {
        this.signUpPassword = signUpPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSignInEmailAddress() {
        return signInEmailAddress;
    }

    public void setSignInEmailAddress(String signInEmailAddress) {
        this.signInEmailAddress = signInEmailAddress;
    }

    public String getSignInPassword() {
        return signInPassword;
    }

    public void setSignInPassword(String signInPassword) {
        this.signInPassword = signInPassword;
    }

    /**
     * read properties of a test data file
     **/
    private void readProperties() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/test/resources/testdata.properties");
            prop.load(input);
            setUrl(prop.getProperty("url"));
            setBrowser(prop.getProperty("browser"));
            setSignUpEmailAddress(prop.getProperty("signUpEmailAddress"));
            setSignUpPassword(prop.getProperty("signUpPassword"));
            setGender(prop.getProperty("gender"));
            setFirstName(prop.getProperty("firstName"));
            setLastName(prop.getProperty("lastName"));
            setDateOfBirth(prop.getProperty("dateOfBirth"));
            setSignInEmailAddress(prop.getProperty("signInEmailAddress"));
            setSignInPassword(prop.getProperty("signInPassword"));

        } catch (Exception e) {
            throw new RuntimeException("Failed due to exception: " + e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException("Failed due to IOException: " + e);
                }
            }

        }
    }

}
