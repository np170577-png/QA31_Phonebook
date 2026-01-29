package tests;


import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        //if SignOut button present --->logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
            logger.info("Before method finished logout");
        }
    }

    @Test
    public void loginSuccess() {
        logger.info("Start test loginSuccess");
       User user = new User().setEmail("np7788@inbox.ru").setPassword("WadiNisnas8#");
        logger.info("Test data 'np7788@inbox.ru' and password 'WadiNisnas8#'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert checks if element button 'Sign out' is present");

    }


    @Test
    public void loginSuccessModel() {
        logger.info("Test data 'np7788@inbox.ru' and password 'WadiNisnas8#'");
        User user = new User().setEmail("np7788@inbox.ru").setPassword("WadiNisnas8#");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert checks if element button 'Sign out' is present");

    }

    @Test
    public void loginSuccessModelDPF(User user) {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }

    @Test
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