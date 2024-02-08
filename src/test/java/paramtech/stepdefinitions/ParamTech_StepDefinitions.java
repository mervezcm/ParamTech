package paramtech.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import org.junit.Assert;

import paramtech.pages.ParamTechPage;
import paramtech.utilities.BrowserUtilities;
import paramtech.utilities.ConfigurationReader;
import paramtech.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ParamTech_StepDefinitions {
    Faker faker = new Faker();
    ParamTechPage paramtech = new ParamTechPage();

    @Given("Kullanici anasayfaya gider")
    public void kullanici_anasayfaya_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("website"));
    }

    @When("Anasayfa'da olduğunu dogrular")
    public void anasayfa_da_oldugunu_dogrular() {

        BrowserUtilities.verifyTitle(Driver.getDriver(), "Param: Nakit iade Avantaji ve Düsük Komisyon Orani - Param");

    }

    @When("Anasayfa'da yer alan Giris Yap butonuna tiklar")
    public void anasayfa_da_yer_alan_giris_yap_butonuna_tiklar() {
        paramtech.girisYap.click();

    }

    @When("Hesap olustur sayfasina yonlenir.")
    public void hesap_olustur_sayfasina_yonlenir() {
        BrowserUtilities.verifyTitle(Driver.getDriver(), "Ücretsiz Param Hesabi Olustur - Param");

    }

    @When("Hesap olustur sayfasinda Kurumsal Giris butonuna tiklar")
    public void hesap_olustur_sayfasinda_kurumsal_giris_butonuna_tiklar() {
        BrowserUtilities.clickWithJS(paramtech.kurumsalgirisButonu);

    }

    @When("Yeni acilan login ekranini gorür")
    public void yeni_acilan_login_ekranini_gorür() {
        BrowserUtilities.switchToWindow("https://isyerim.param.com.tr/#/");


    }

    @And("Login ekraninda GSM, TCKN ya da Kart Numarasi'ni  girer")
    public void loginEkranindaGSMTCKNYaDaKartNumarasiNiGirer() {
        paramtech.telefonNumarasi.sendKeys("5554443311");

    }

    @And("Login ekraninda sifresini girer.")
    public void loginEkranindaSifresiniGirer() {
        paramtech.sifre.sendKeys(faker.number().digits(8));
    }

    @When("Giris Yap butonuna tiklar")
    public void giris_yap_butonuna_tiklar() {
        paramtech.girisyapButonu.click();

    }


    @Then("Verileri yanlis girdiğinde uyari mesajini gorür")
    public void verileriYanlisGirdigindeUyariMesajiniGorur() {
        String expectedHataMesaji = "Hatali bilgi girisi yaptiniz.\n" +
                " Lütfen bilgilerinizi kontrol ediniz.";
        String actualHataMesaji = paramtech.hataMesaji.getText();
        Assert.assertEquals(actualHataMesaji, expectedHataMesaji);
    }

    @And("Hesap olustur butonuna tiklar")
    public void hesapOlusturButonunaTiklar() {
        BrowserUtilities.sleep(3);
        //BrowserUtilities.hover(paramtech.hesapOlustur);
         BrowserUtilities.clickWithJS(paramtech.hesapOlustur);


    }

    @And("Adini yazar")
    public void adiniYazar() {
        paramtech.kullaniciAdi.sendKeys(faker.name().firstName());
    }

    @And("Soyadini yazar")
    public void soyadiniYazar() {
        paramtech.kullaniciSoyadi.sendKeys(faker.name().lastName());
    }

    @And("E-posta adresini yazar")
    public void ePostaAdresiniYazar() {
        paramtech.kullaniciEmail.sendKeys(faker.name().username() + "@paramtech.com");
    }


    @And("GSM numarasini yazar")
    public void gsmNumarasiniYazar() {
        paramtech.kullaniciGsmNo.sendKeys("5559986589");

    }

    @And("Kullanici aydinlatma metnini,Veriaktarim acik riza metnini ve Hesap acilis sozlesmesini isaretler.")
    public void kullaniciAydinlatmaMetniniVeriaktarimAcikRizaMetniniVeHesapAcilisSozlesmesiniisaretler() {

        paramtech.aydinlatmaMetni.click();
        paramtech.acikRizaMetni.click();
        paramtech.hesapAcilisSozlesmesi.click();

    }

    @And("Devam butonuna tiklar")
    public void devamButonunaTiklar() {
        paramtech.devamButonu.click();

    }

    @And("Telefonuna gelen onay kodunu yanlis girer")
    public void telefonunaGelenOnayKodunuYanlisGirer() {
        BrowserUtilities.sleep(2);
        paramtech.onaykodu1.sendKeys(faker.number().digits(1));
        paramtech.onaykodu2.sendKeys(faker.number().digits(1));
        paramtech.onaykodu3.sendKeys(faker.number().digits(1));
        paramtech.onaykodu4.sendKeys(faker.number().digits(1));
        paramtech.onaykodu5.sendKeys(faker.number().digits(1));
        paramtech.onaykodu6.sendKeys(faker.number().digits(1));


    }

    @And("Onayla butonuna tiklar")
    public void onaylaButonunaTiklar() {
        paramtech.onaylaButonu.click();

    }

    @Then("Girilen onay kodu yanlis olduğundan hata mesajini gorür")
    public void girilenOnayKoduYanlisOldugundanHataMesajiniGorur() {
        System.out.println(paramtech.errorMessage.isDisplayed());
    }
}
