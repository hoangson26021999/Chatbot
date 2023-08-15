package com.example.Chatbot.service;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CommonService {

    private static final String URL_SEND_MESSAGE = "https://mbasic.facebook.com/messages/read/?fbid=";
    private static final String USERNAME = "0388765475";
    private static final String PASSWORD = "01237525708";

    public void sendMessage(String msg, String userId) {


        WebDriver webDriver = initDriver();
        login(webDriver);
        sleep(1000l);
        String url = URL_SEND_MESSAGE + "100006028390798";
        webDriver.get(url);
        sleep(1000l);
        webDriver.findElement(By.xpath("//*[@id=\"composerInput\"]")).sendKeys(msg);
        sleep(2000l);
        webDriver.findElement(By.xpath("//*[@id=\"composer_form\"]/table/tbody/tr/td[2]/input")).click();
        sleep(2000l);
        webDriver.close();
    }

    public void login(WebDriver webDriver) {
        webDriver.get("https://www.facebook.com/");
        String title = webDriver.getTitle();
        if (title.matches("^(\\(.*\\) ){0,1}Facebook$")) {
            return;
        }
        webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(USERNAME);
        webDriver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(PASSWORD);
        webDriver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Keys.ENTER);

        title = webDriver.getTitle();
        if (title.matches("^(\\(.*\\) ){0,1}Facebook$")) {
            System.out.println("Da login");
        }
    }
}
