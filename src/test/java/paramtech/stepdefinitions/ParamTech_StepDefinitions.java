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

    @Given("Kullanıcı anasayfaya gider")
    public void kullanici_anasayfaya_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("website"));
    }

    @When("Anasayfa'da olduğunu dogrular")
    public void anasayfa_da_oldugunu_dogrular() {

        BrowserUtilities.verifyTitle(Driver.getDriver(), "Param: Nakit İade Avantajı ve Düşük Komisyon Oranı - Param");

    }

    @When("Anasayfa'da yer alan Giris Yap butonuna tıklar")
    public void anasayfa_da_yer_alan_giris_yap_butonuna_tiklar() {
        paramtech.girisYap.click();

    }

    @When("Hesap oluştur sayfasına yönlenir.")
    public void hesap_olustur_sayfasina_yonlenir() {
        BrowserUtilities.verifyTitle(Driver.getDriver(), "Ücretsiz Param Hesabı Oluştur - Param");

    }

    @When("Hesap oluştur sayfasında Kurumsal Giriş butonuna tıklar")
    public void hesap_olustur_sayfasında_kurumsal_giris_butonuna_tıklar() {
        BrowserUtilities.clickWithJS(paramtech.kurumsalgirisButonu);

    }

    @When("Yeni açılan login ekranını görür")
    public void yeni_açılan_login_ekranını_görür() {
        BrowserUtilities.switchToWindow("https://isyerim.param.com.tr/#/");


    }

    @And("Login ekranında GSM, TCKN ya da Kart Numarası'nı  girer")
    public void loginEkranındaGSMTCKNYaDaKartNumarasıNıGirer() {
        paramtech.telefonNumarası.sendKeys("5554443311");

    }

    @And("Login ekranında şifresini girer.")
    public void loginEkranındaSifresiniGirer() {
        paramtech.şifre.sendKeys(faker.number().digits(8));
    }

    @When("Giris Yap butonuna tıklar")
    public void giris_yap_butonuna_tıklar() {
        paramtech.girisyapButonu.click();

    }


    @Then("Verileri yanlış girdiğinde uyarı mesajını görür")
    public void verileriYanlısGirdigindeUyarıMesajınıGorur() {
        String expectedHataMesajı = "Hatalı bilgi girişi yaptınız.\n" +
                " Lütfen bilgilerinizi kontrol ediniz.";
        String actualHataMesajı = paramtech.hataMesajı.getText();
        Assert.assertEquals(actualHataMesajı, expectedHataMesajı);
    }

    @And("Hesap oluştur butonuna tıklar")
    public void hesapOlusturButonunaTıklar() {
        BrowserUtilities.sleep(3);
        //BrowserUtilities.hover(paramtech.hesapOlustur);
         BrowserUtilities.clickWithJS(paramtech.hesapOlustur);


    }

    @And("Adını yazar")
    public void adınıYazar() {
        paramtech.kullanıcıAdı.sendKeys(faker.name().firstName());
    }

    @And("Soyadını yazar")
    public void soyadınıYazar() {
        paramtech.kullanıcıSoyadı.sendKeys(faker.name().lastName());
    }

    @And("E-posta adresini yazar")
    public void ePostaAdresiniYazar() {
        paramtech.kullanıcıEmail.sendKeys(faker.name().username() + "@paramtech.com");
    }


    @And("GSM numarasını yazar")
    public void gsmNumarasınıYazar() {
        paramtech.kullanıcıGsmNo.sendKeys("5559986589");

    }

    @And("Kullanıcı aydınlatma metnini,Veriaktarım acık rıza metnini ve Hesap açılış sözleşmesini işaretler.")
    public void kullanıcıAydınlatmaMetniniVeriaktarımAcıkRızaMetniniVeHesapAcılısSozlesmesiniIsaretler() {

        paramtech.aydınlatmaMetni.click();
        paramtech.acıkRızaMetni.click();
        paramtech.hesapAcılısSözlesmesı.click();

    }

    @And("Devam butonuna tıklar")
    public void devamButonunaTıklar() {
        paramtech.devamButonu.click();

    }

    @And("Telefonuna gelen onay kodunu yanlış girer")
    public void telefonunaGelenOnayKodunuYanlısGirer() {
        BrowserUtilities.sleep(2);
        paramtech.onaykodu1.sendKeys(faker.number().digits(1));
        paramtech.onaykodu2.sendKeys(faker.number().digits(1));
        paramtech.onaykodu3.sendKeys(faker.number().digits(1));
        paramtech.onaykodu4.sendKeys(faker.number().digits(1));
        paramtech.onaykodu5.sendKeys(faker.number().digits(1));
        paramtech.onaykodu6.sendKeys(faker.number().digits(1));


    }

    @And("Onayla butonuna tıklar")
    public void onaylaButonunaTıklar() {
        paramtech.onaylaButonu.click();

    }

    @Then("Girilen onay kodu yanlış olduğundan hata mesajını görür")
    public void girilenOnayKoduYanlısOldugundanHataMesajınıGorur() {
        System.out.println(paramtech.errorMessage.isDisplayed());
    }
}
