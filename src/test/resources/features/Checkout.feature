Feature: Checkout Cart

  @Positive
  Scenario: Checkout menggunakan akun standard_user
    Given Pengguna sudah login dengan standard_user dan memiliki item dikeranjang
    When Pengguna input nama depan nama belakang dan kode pos
    And Pengguna klik tombol continue
    And Pengguna klik tombol finish
    Then Pengguna berhasil melakukan checkout

  @Negative
  Scenario: Checkout menggunakan akun problem_user
    Given Pengguna sudah login dengan problem_user dan memiliki item dikeranjang
    When Pengguna input nama depan nama belakang dan kode pos
    And Pengguna klik tombol continue
    Then Pengguna menerima pesan error