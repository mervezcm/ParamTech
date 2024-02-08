#  https://param.com.tr adresinde Anasayfa’ da yer alan “Giriş Yap” butonu aracılığıyla /hesap-olustur sayfasına yönlenilir.
# Yönlendirme sonrası “Kurumsal Giriş” seçeneği seçilerek farklı bir sayfada açılan Login ekranına redirect olunur.
# Açılan sayfada giriş bilgileri yanlış girilerek , verilen validasyon uyarısının doğrulandığını teyit eden test senaryosunu tamamlamanız beklenmektedir. //

Feature: Kullanıcının Login ve Hesap olusturma sayfasında aldıgı hata validasyonu

  @scenario1
  Scenario: Kullanıcının Kurumsal girişten Login olurken yanlış veri girdiğinde aldığı hatanın doğrulaması
    Given Kullanıcı anasayfaya gider
    Then Anasayfa'da olduğunu dogrular
    And Anasayfa'da yer alan Giris Yap butonuna tıklar
    And Hesap oluştur sayfasına yönlenir.
    And Hesap oluştur sayfasında Kurumsal Giriş butonuna tıklar
    Then Yeni açılan login ekranını görür
    And Login ekranında GSM, TCKN ya da Kart Numarası'nı  girer
    And Login ekranında şifresini girer.
    And Giris Yap butonuna tıklar
    Then Verileri yanlış girdiğinde uyarı mesajını görür

    # Bir önceki Case de login adımına ilerlenilen adımlar tekrar edilir. Login Sayfasında
#“Hesap Oluştur” seçeneği ile devam edilir.
# Hesap oluşturmak için gerekli bilgiler doldurulur.
#●“Devam” butonu aracılığıyla ilerlenir.
# OTP ekranında yanlış şifre girişi yapılarak verilen validasyon doğrulanır.#

  @scenario2
  Scenario:Kullanıcının hesap olusturduktan sonra OTP ekranında yanlış şifre girmesiyle aldığı hatanın doğrulanması
    Given Kullanıcı anasayfaya gider
    When Anasayfa'da olduğunu dogrular
    And Anasayfa'da yer alan Giris Yap butonuna tıklar
    And Hesap oluştur sayfasına yönlenir.
    And Hesap oluştur sayfasında Kurumsal Giriş butonuna tıklar
    And Yeni açılan login ekranını görür
    And Hesap oluştur butonuna tıklar
    And Adını yazar
    And Soyadını yazar
    And E-posta adresini yazar
    And GSM numarasını yazar
    And Kullanıcı aydınlatma metnini,Veriaktarım acık rıza metnini ve Hesap açılış sözleşmesini işaretler.
    And Devam butonuna tıklar
    And Telefonuna gelen onay kodunu yanlış girer
    And Onayla butonuna tıklar
    Then Girilen onay kodu yanlış olduğundan hata mesajını görür



