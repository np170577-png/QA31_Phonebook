package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {


    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        //if SignOut button present --->logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void registrationSuccess() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User().setEmail("lisa" + i + "@gmail.com").setPassword("Lisa14568$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }

    @Test(description = "Bug report #23456 Fixed",groups = {"smoke"})
    public void registrationWrongEmail() {

        User user = new User().setEmail("lisa.gmail.com").setPassword("12345&Aa");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }

    @Test
    public void registrationWrongPassword() {

        User user = new User().setEmail("lisa@gmail.com").setPassword("12357");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }

    @Test
    public void registrationRegisteredUser(){

        User user = new User().setEmail("np7788@inbox.ru").setPassword("WadiNisnas8#");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));
    }

}