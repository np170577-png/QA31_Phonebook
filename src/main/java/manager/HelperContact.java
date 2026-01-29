package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.Random;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }


    public void openContactForm() {
        click(By.xpath("//*[@href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());
    }

    public void save() {
        click(By.xpath("//b[text()='Save']"));
    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                return true;
            }

        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

//    public boolean isContactAddedByEmail(String email) {
//        List<WebElement> list = wd.findElements(By.cssSelector(""));
//        for (WebElement el: list){
//            if (el.getText().equals(email)){
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean isAddNewContactPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of contacts before remove is " + before);
        removeContact();
        int after = countOfContacts();
        logger.info("Number of contacts after remove is " + after);
        return before - after;
    }

    private void removeContact() {
        click(By.cssSelector("contact-item_card__2SOIM"));
        click(By.xpath("//text()='Remove'"));
        pause(1000);
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector("contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
        while (countOfContacts() > 0) {
            removeContact();
        }
    }

    public void provideContact() {
        if (countOfContacts() < 3) {
            for (int i = 0; i < 3; i++) {
                addOneContact();

            }
        }
    }

    private void addOneContact() {
        int i = new Random().nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Sonia" +i)
                .lastName("Vasilenko")
                .email("sonia" +i + "gmail.com")
                .phone("2345"+ i + "953849")
                .address("Haifa")
                .description("workmate")
                .build();


        openContactForm();
        fillContactForm(contact);
        save();
        pause(500);
    }


    // public boolean isContactAddedByEmail(String email) {

//    }

}

