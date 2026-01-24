package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import models.User;

public class LoginTests extends TestBase{
@BeforeMethod
public void preCondition(){
    //if Sing out button present ---> log out
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void loginSuccess() {

    User user = new User().setEmail("np77@inbox.ru").setPassword("Wasipulai7%");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }


        @Test
        public void loginSuccessModel(){

    User user = new User().setEmail("np77@inbox.ru").setPassword("Wasipulai7%");
            app.getHelperUser().openLoginRegistrationForm();
            app.getHelperUser().fillLoginRegistrationForm(user);
            app.getHelperUser().submitLogin();
            Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginWrongEmail(){

    User user = new User().setEmail("np@inbox.ru").setPassword("Wasipulai7%");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }

    @Test
    public void loginWrongPassword(){

    User user = new User().setEmail("np77@inbox.ru").setPassword("Wasip");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginEnregisteredUser(){

    User user = new User().setEmail("np@inbox.ru").setPassword("7mnchweavb!");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }
    }

