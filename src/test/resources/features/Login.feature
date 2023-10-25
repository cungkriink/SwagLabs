Feature: Login

  @Positive
  Scenario: Login menggunakan akun yang valid
    Given Pengguna sudah membuka halaman saucedemo.com
    When Pengguna input username dan password
    And Pengguna klik tombol login
    Then Pengguna berhasil login dan diarahkan kehalaman produk

  @Negative
  Scenario: Login menggunakan akun yang tidak valid
    Given Pengguna sudah membuka halaman saucedemo.com
    When Pengguna input username dan password yang salah
    And Pengguna klik tombol login
    Then Pengguna mendapatkan pesan error