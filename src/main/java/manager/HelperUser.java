package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import models.User;

import java.time.Duration;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
//        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//        loginTab.click();

        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginRegistrationForm(User user) {
//        WebElement emailInput = wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(login);

        type(By.name("email"), user.getEmail());

//        WebElement passwordInput = wd.findElement(By.cssSelector("[placeholder = 'Password']"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);

        type(By.cssSelector("[placeholder = 'Password']"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[text()='Login']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));

    }

    public void logOut() {
        click(By.xpath("//button[text()='Sign Out']"));

    }

    public boolean isAlertPresent(String message) {
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());

        if (alert != null && alert.getText().contains(message)) {
            alert.accept();

//            alert.dismiss();
//            alert.sendKeys("hello");
            return true;
        }
        return false;
    }

    public void submitRegistration() {
        click(By.xpath("//button[text()='Registration']"));
    }


    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }
}
