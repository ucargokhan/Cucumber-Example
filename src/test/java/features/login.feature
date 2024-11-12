Feature: login

  Scenario: login
    Given Kullanıcı giriş sayfasına gider
    When Kullanıcı geçerli kullanıcı adı ve şifre girer
    And Kullanıcı giriş butonuna tıklar
    Then Kullanıcı ana sayfaya yönlendirilir
