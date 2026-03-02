package tests;

import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        //if SignOut button present --->logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
            logger.info("Before method finished logout");
        }
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password) {
        logger.info("Start test with name 'Login Success'");
        logger.info("Test data ---> email: " + email + "password: " + password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sign out' present");
    }

    @Test(dataProvider = "loginModel", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {
        logger.info("Test data ---> " + user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sign out' present");
    }

    @Test(dataProvider = "loginFile", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDPF(User user) {
        logger.info("Test data ---> " + user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sign out' present");
    }

    @Test(groups = {"smoke"})
    public void loginWrongEmail() {
        logger.info("Test data 'np77inbox.ru' and password 'WadiNisnas8#'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("np77inbox.ru", "WadiNisnas8#");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert checks if alert 'Wrong email or password' is present");

    }

    @Test
    public void loginWrongPassword() {
        logger.info("Test data 'np7788@inbox.ru' and password 'WadiNisn'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("np7788@inbox.ru", "WadiNisn");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert checks if alert 'Wrong email or password' is present");


    }

    @Test
    public void loginUnregisteredUser() {
        logger.info("Test data 'np@inbox.ru' and password 'WadiNisnas5#'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("np@inbox.ru", "WadiNisnas5#'");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert checks if alert 'Wrong email or password' is present");

    }

}