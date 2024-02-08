#  https://param.com.tr adresinde Anasayfa’ da yer alan “Giris Yap” butonu araciliğiyla /hesap-olustur sayfasina yonlenilir.
# Yonlendirme sonrasi “Kurumsal Giris” seceneği secilerek farkli bir sayfada acilan Login ekranina redirect olunur.
# Acilan sayfada giris bilgileri yanlis girilerek , verilen validasyon uyarisinin doğrulandiğini teyit eden test senaryosunu tamamlamaniz beklenmektedir. //

Feature: Kullanicinin Login ve Hesap olusturma sayfasinda aldigi hata validasyonu

  @scenario1
  Scenario: Kullanicinin Kurumsal giristen Login olurken yanlis veri girdiğinde aldiği hatanin doğrulamasi
    Given Kullanici anasayfaya gider
    Then Anasayfa'da oldugunu dogrular
    And Anasayfa'da yer alan Giris Yap butonuna tiklar
    And Hesap olustur sayfasina yonlenir.
    And Hesap olustur sayfasinda Kurumsal Giris butonuna tiklar
    Then Yeni acilan login ekranini gorür
    And Login ekraninda GSM, TCKN ya da Kart Numarasi'ni  girer
    And Login ekraninda sifresini girer.
    And Giris Yap butonuna tiklar
    Then Verileri yanlis girdiğinde uyari mesajini gorür

    # Bir onceki Case de login adimina ilerlenilen adimlar tekrar edilir. Login Sayfasinda
#“Hesap Olustur” seceneği ile devam edilir.
# Hesap olusturmak icin gerekli bilgiler doldurulur.
#●“Devam” butonu araciliğiyla ilerlenir.
# OTP ekraninda yanlis sifre girisi yapilarak verilen validasyon doğrulanir.#

  @scenario2
  Scenario:Kullanicinin hesap olusturduktan sonra OTP ekraninda yanlis sifre girmesiyle aldiği hatanin doğrulanmasi
    Given Kullanici anasayfaya gider
    When Anasayfa'da oldugunu dogrular
    And Anasayfa'da yer alan Giris Yap butonuna tiklar
    And Hesap olustur sayfasina yonlenir.
    And Hesap olustur sayfasinda Kurumsal Giris butonuna tiklar
    And Yeni acilan login ekranini gorür
    And Hesap olustur butonuna tiklar
    And Adini yazar
    And Soyadini yazar
    And E-posta adresini yazar
    And GSM numarasini yazar
    And Kullanici aydinlatma metnini,Veriaktarim acik riza metnini ve Hesap acilis sozlesmesini isaretler.
    And Devam butonuna tiklar
    And Telefonuna gelen onay kodunu yanlis girer
    And Onayla butonuna tiklar
    Then Girilen onay kodu yanlis olduğundan hata mesajini gorür



