package paramtech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import paramtech.utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParamTechPage {
    public ParamTechPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//a[@id='menu_login']")
    public WebElement girisYap;


    @FindBy(xpath = "//input[@name='userCardNo']")
    public WebElement telefonNumarasi;

    @FindBy(xpath = "//a[@class='btn btn-outline-primary btn-icon']")
    public WebElement kurumsalgirisButonu;

    @FindBy(xpath = "//input[@name='userPassword']")
    public WebElement sifre;

    @FindBy(xpath = "//button[@id='loginbutton']")
    public WebElement girisyapButonu;


    @FindBy(xpath = "//div[@class='modalTitle___WE5UD']")
    public WebElement hataMesaji;

    // scnario2
    @FindBy(xpath = "//span[@class='signUp___3OOhy']")
    public WebElement hesapOlustur;
    ////
    @FindBy(xpath = "//input[@placeholder='Ad']")
    public WebElement kullaniciAdi;
    @FindBy(xpath = "//input[@placeholder='Soyad']")
    public WebElement kullaniciSoyadi;
    @FindBy(xpath = "//input[@placeholder='GSM Numarası']")
    public WebElement kullaniciGsmNo;

    @FindBy(xpath = "//input[@placeholder='E-Posta Adresi']")
    public WebElement kullaniciEmail;

    @FindBy(xpath = "//div[@name='checkBox1']")
    public WebElement aydinlatmaMetni ;

    @FindBy(xpath = "//div[@name='checkBox2']")
    public WebElement acikRizaMetni;
    @FindBy(xpath = "//div[@name='checkBox3']")
    public WebElement hesapAcilisSozlesmesi;

    @FindBy(xpath = "//button[@id='continue_from_signup']")
    public WebElement devamButonu;
    @FindBy(xpath = "//input[@tabindex='1']")
    public WebElement onaykodu1;

    @FindBy(xpath = "//input[@tabindex='2']")
    public WebElement onaykodu2;

    @FindBy(xpath = "//input[@tabindex='3']")
    public WebElement onaykodu3;
    @FindBy(xpath = "//input[@tabindex='4']")
    public WebElement onaykodu4;
    @FindBy(xpath = "//input[@tabindex='5']")
    public WebElement onaykodu5;
    @FindBy(xpath = "//input[@tabindex='6']")
    public WebElement onaykodu6;

    @FindBy(xpath = "//button[@id='continue_from_otp']")
    public WebElement onaylaButonu;
        @FindBy(xpath = "//div[@id='errorVerificationNo']")
    public WebElement errorMessage;


}
