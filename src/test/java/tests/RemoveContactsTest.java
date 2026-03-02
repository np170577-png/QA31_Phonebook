package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactsTest extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void precondition() {

        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User()
                    .setEmail("np7788@inbox.ru").setPassword("WadiNisnas8#"));

            app.getHelperContact().provideContact();//if contact list size <3 ==> add 3 contacts
        }
    }

    @Test(groups = {"smoke"})
    public void removeFirstContact() {
        //Assert -->size contact list less by one
        Assert.assertEquals(app.getHelperContact().removeOneContact(),1);
    }

    @Test
    public void removeAllContacts() {
        app.getHelperContact().removeAllContacts();
        //Assert --> "No Contacts here!"
        Assert.assertTrue(app.getHelperContact().isNoContactsHereDisplayed());
    }
}
