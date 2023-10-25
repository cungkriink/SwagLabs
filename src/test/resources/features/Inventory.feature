Feature: Mengakses Halaman Inventory Product

  @Positive
  Scenario: Mengakses halaman inventory menggunakan akun standard_user
    Given Pengguna sudah membuka halaman login saucedemo.com
    When Pengguna input username dan password dengan akun standard_user
    And Pengguna klik button login
    Then Pengguna berhasil login dan aplikasi menampilkan gambar produk yang sesuai

  @Negative
  Scenario: Mengakses halaman inventory menggunakan akun problem_user
    Given Pengguna sudah membuka halaman login saucedemo.com
    When Pengguna input username dan password dengan akun problem_user
    And Pengguna klik button login
    Then Pengguna berhasil login dan aplikasi menampilkan gambar produk yang tidak sesuai