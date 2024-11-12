Feature: Hepsiburada Giriş Yapma

  Scenario: kullaniciyapabilmeli
    Given Kullanıcı giriş sayfasına gider
    When Kullanıcı geçerli kullanıcı adı ve şifre girer
    And Kullanıcı giriş butonuna tıklar
    Then Kullanıcı ana sayfaya yönlendirilir
