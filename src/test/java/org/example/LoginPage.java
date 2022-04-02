package org.example;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy (xpath = "//*[contains(@id, 'index_email')]")
    private WebElement loginField;

//    @FindBy(xpath = "//*[contains(@id, 'index_pass')]")
    @FindBy (css = "input#index_pass")
    private WebElement passwordField;

    @FindBy(xpath = "//*[contains(@id, 'index_login_button')]")
    private WebElement loginBtn;

    @FindBy(css = "#login_message > div > div > b:nth-child(1)")
    private WebElement message;



    public WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void inputPass(String password){
        passwordField.sendKeys(password);
    }

    public void login(){
        loginBtn.click();
    }

    public String getTextMessage(){
        return message.getText();
    }
}
