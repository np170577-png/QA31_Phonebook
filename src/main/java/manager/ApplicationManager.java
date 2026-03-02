package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;
    HelperContact helperContact;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);




    public ApplicationManager() {
        this.browser = browser;
    }



    public void init() {

       if (browser.equals(Browser.CHROME.browserName())) {
            wd = new ChromeDriver();
           logger.info("All tests run in CHROME Browser");
       }else if (browser.equals(Browser.FIREFOX.browserName())){
           wd = new FirefoxDriver();
           logger.info("All tests run in Firefox Browser");
       }else if (browser.equals(Browser.EDGE.browserName()))
           wd = new EdgeDriver();
        logger.info("All tests run in Edge Browser");


        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebDriverListener webDriverListener = new WDListener();
        wd = new EventFiringDecorator(webDriverListener).decorate(wd);

        wd.navigate().to("https://telranedu.web.app/");
        logger.info("The link is -->" + wd.getCurrentUrl());

        helperUser = new HelperUser(wd);
        helperContact = new HelperContact(wd);

    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperContact getHelperContact() {
        return helperContact;
    }

    public void stop() {
        wd.quit();
    }

}
