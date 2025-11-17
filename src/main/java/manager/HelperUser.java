package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
//        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//        loginTab.click();

        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
//        WebElement emailInput = wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(login);

        type(By.name("email"), email);

//        WebElement passwordInput = wd.findElement(By.cssSelector("[placeholder = 'Password']"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);

        type(By.cssSelector("[placeholder = 'Password']"), password);
    }

    public void submitLogin(){
        click(By.xpath("//button[text()='Login']"));
    }
}
