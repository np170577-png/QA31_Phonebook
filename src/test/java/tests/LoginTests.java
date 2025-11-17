package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @Test
    public void loginSuccess(){
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm("np77@inbox.ru", "Satiblai4t!");
       app.getHelperUser().submitLogin();

       //Assert

    }

    }

