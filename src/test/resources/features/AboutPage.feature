Feature: Mengakses Halaman About

  @Positive
  Scenario: Mengakses halaman about menggunakan akun standard_user
    Given Pengguna sudah login menggunakan standard_user
    When Pengguna klik menu utama
    And Pengguna klik item menu about
    Then pengguna diarahkan kehalaman about

  @Negative
  Scenario: Mengakses halaman about menggunakan akun problem_user
    Given Pengguna sudah login menggunakan problem_user
    When Pengguna klik menu utama
    And Pengguna klik item menu about
    Then halaman about tidak ditemukan 404