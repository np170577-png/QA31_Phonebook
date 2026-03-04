package tests;

import manager.DataProviderContacts;
import manager.DataProviderUser;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void precondition() {

        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User()
                    .setEmail("np7788@inbox.ru").setPassword("WadiNisnas8#"));

        }
    }

    @Test(dataProvider = "contactSuccess", dataProviderClass = DataProviderContacts.class)

    public void addContactSuccessAllFields(Contact contact) {
        int i = new Random().nextInt(1000) + 1000;

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test(dataProvider = "contactCSV", dataProviderClass = DataProviderContacts.class)
    public void addContactSuccessAllFieldsCSV(Contact contact) {
        int i = new Random().nextInt(1000) + 1000;

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i + ".png");
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test(groups = {"smoke","regress","retest"})

    public void addContactSuccessRequiredFields() {
        int i = new Random().nextInt(1000) + 1000;
        Contact contact = Contact.builder().
                name("JasonRegPosit" + i).
                lastName("Momoa").
                phone("122456" + i).
                email("momoa" + i + "@gmail.com").
                address("Washington, DC").
                build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
        //Assert.assertTrue(app.getHelperContact().isContactAddedByEmail(contact.getEmail()));
    }

    @Test
    public void addNewContactWrongName() {
        Contact contact = Contact.builder().
                name("").
                lastName("Momoa").
                phone("122456203947").
                email("momoa@gmail.com").
                address("Washington, DC").
                description("Wrong name").
                build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongLastName() {
        Contact contact = Contact.builder().
                name("Jason").
                lastName("").
                phone("122456203947").
                email("momoa@gmail.com").
                address("Washington, DC").
                description("Wrong LastName").
                build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());

    }

    @Test(dataProvider = "contactWrongPhone", dataProviderClass = DataProviderContacts.class)
    public void addNewContactWrongPhone(Contact contact) {
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent
                (" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));


    }

    @Test
    public void addNewContactWrongEmail() {
        Contact contact = Contact.builder().
                name("Jason").
                lastName("Momoa").
                phone("122456203947").
                email("momoagmail.com").
                address("Washington, DC").
                description("Wrong email").
                build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid: must be a well-formed email address"));

    }

    @Test
    public void addNewContactWrongAddress() {
        Contact contact = Contact.builder().
                name("Jason").
                lastName("Momoa").
                phone("122456203947").
                email("momoa@gmail.com").
                address("").
                description("Wrong address").
                build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddNewContactPageStillDisplayed());

    }


}

