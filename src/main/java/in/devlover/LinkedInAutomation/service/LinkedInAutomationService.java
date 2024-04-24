package in.devlover.LinkedInAutomation.service;

import in.devlover.LinkedInAutomation.constantas.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Rajan Kesharwani
 */
@Service
public class LinkedInAutomationService {

    /**
     * This method is for login
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        WebDriver driver = new ChromeDriver();
        driver.get(AppConstants.LINKEDIN_PAGE);
        driver.findElement(By.id(AppConstants.SESSION_KEY)).sendKeys(username);
        driver.findElement(By.id(AppConstants.SESSION_PASSWORD)).sendKeys(password);
        driver.findElement(By.className(AppConstants.SIGN_IN_FORM_SUBMIT_BTN)).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    /**
     *This method is for post anything contents
     * @param username
     * @param password
     * @param content
     */
    public void postOnLinkedIn(String username, String password, String content) {
        WebDriver driver = new ChromeDriver();
        driver.get(AppConstants.LINKEDIN_PAGE);
        driver.findElement(By.id(AppConstants.SESSION_KEY)).sendKeys(username);
        driver.findElement(By.id(AppConstants.SESSION_PASSWORD)).sendKeys(password);
        driver.findElement(By.className(AppConstants.SIGN_IN_FORM_SUBMIT_BTN)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(AppConstants.LINKEDIN_NEW_POST);
        WebElement contentTextArea = driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']"));
        contentTextArea.click();
        contentTextArea.sendKeys(content);
        WebElement postButton = driver.findElement(By.xpath("//button[contains(@aria-label, 'Post')]"));
        postButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    /**
     * This method is use for send anything to any recipient
     * @param username
     * @param password
     * @param recipient
     * @param message
     */
    public void sendMessage(String username, String password, String recipient, String message) {
        WebDriver driver = new ChromeDriver();
        driver.get(AppConstants.LINKEDIN_PAGE);
        driver.findElement(By.id(AppConstants.SESSION_KEY)).sendKeys(username);
        driver.findElement(By.id(AppConstants.SESSION_PASSWORD)).sendKeys(password);
        driver.findElement(By.className(AppConstants.SIGN_IN_FORM_SUBMIT_BTN)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(AppConstants.LINKEDIN_MESSAGING);
        driver.findElement(By.xpath("//button[contains(text(), 'Start a new message')]")).click();
        WebElement toField = driver.findElement(By.xpath("//input[@placeholder='Type a name or multiple names']"));
        toField.sendKeys(recipient);
        toField.sendKeys(Keys.RETURN);
        WebElement messageField = driver.findElement(By.xpath("//div[contains(@class, 'msg-form__contenteditable')]"));
        messageField.sendKeys(message);
        driver.findElement(By.xpath("//button[contains(text(), 'Send')]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }


    /**
     * This method get all New feeds from you profile
     * @param username
     * @param password
     * @return
     */
    public List<String> getAllFeeds(String username, String password) {
        List<String> feeds = new ArrayList<>();
        WebDriver driver = new ChromeDriver();
        driver.get(AppConstants.LINKEDIN_PAGE);
        driver.findElement(By.id(AppConstants.SESSION_KEY)).sendKeys(username);
        driver.findElement(By.id(AppConstants.SESSION_PASSWORD)).sendKeys(password);
        driver.findElement(By.className(AppConstants.SIGN_IN_FORM_SUBMIT_BTN)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(AppConstants.LINKEDIN_FEEDS);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> feedItems = driver.findElements(By.xpath("//div[contains(@class, 'feed-shared-update-v2')]"));
        for (WebElement item : feedItems) {
            feeds.add(item.getText());
        }
        driver.quit();
        return feeds;
    }

    /**
     * This methon get All Notification form your profile
     * @param username
     * @param password
     * @return
     */
    public List<String> getAllNotifications(String username, String password) {
        List<String> notifications = new ArrayList<>();
        WebDriver driver = new ChromeDriver();
        driver.get(AppConstants.LINKEDIN_PAGE);
        driver.findElement(By.id(AppConstants.SESSION_KEY)).sendKeys(username);
        driver.findElement(By.id(AppConstants.SESSION_PASSWORD)).sendKeys(password);
        driver.findElement(By.className(AppConstants.SIGN_IN_FORM_SUBMIT_BTN)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get(AppConstants.LINKEDIN_NOTIFILCATION);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> notificationItems = driver.findElements(By.xpath("//li[contains(@class, 'notification-item')]"));
        for (WebElement item : notificationItems) {
            notifications.add(item.getText());
        }
        driver.quit();
        return notifications;
    }

}