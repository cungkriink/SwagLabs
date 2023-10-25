package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Checkout {
    WebDriver driver;
    String base_url = "https://www.saucedemo.com";

    @Given("Pengguna sudah login dengan standard_user dan memiliki item dikeranjang")
    public void penggunaSudahLoginDenganStandard_userDanMemilikiItemDikeranjang() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(base_url);

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");;
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Tambah item ke keranjang
        driver.findElement(By.xpath("//*[@id=\'add-to-cart-sauce-labs-backpack\']")).click();

        // Masuk ke halaman keranjang
        driver.findElement(By.xpath("//*[@id=\'shopping_cart_container\']/a")).click();

        // Melakukan checkout item di dalam keranjang
        driver.findElement(By.xpath("//*[@id=\'checkout\']")).click();

    }

    @When("Pengguna input nama depan nama belakang dan kode pos")
    public void penggunaInputNamaDepanNamaBelakangDanKodePos() {
        driver.findElement(By.id("first-name")).sendKeys("Vicky");;
        driver.findElement(By.id("last-name")).sendKeys("Werenfridus");
        driver.findElement(By.id("postal-code")).sendKeys("78611");
    }

    @And("Pengguna klik tombol continue")
    public void penggunaKlikTombolContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @And("Pengguna klik tombol finish")
    public void penggunaKlikTombolFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("Pengguna berhasil melakukan checkout")
    public void penggunaBerhasilMelakukanCheckout() {
        String complete_text =  driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals("Thank you for your order!", complete_text);
        driver.close();
    }

    @Given("Pengguna sudah login dengan problem_user dan memiliki item dikeranjang")
    public void penggunaSudahLoginDenganProblem_userDanMemilikiItemDikeranjang() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(base_url);

        // Login
        driver.findElement(By.id("user-name")).sendKeys("problem_user");;
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Tambah item ke keranjang
        driver.findElement(By.xpath("//*[@id=\'add-to-cart-sauce-labs-backpack\']")).click();

        // Masuk ke halaman keranjang
        driver.findElement(By.xpath("//*[@id=\'shopping_cart_container\']/a")).click();

        // Melakukan checkout item di dalam keranjang
        driver.findElement(By.xpath("//*[@id=\'checkout\']")).click();
    }

    @Then("Pengguna menerima pesan error")
    public void penggunaMenerimaPesanError() {
        String error_msg =  driver.findElement(By.xpath("//*[@id=\'checkout_info_container\']/div/form/div[1]/div[4]/h3")).getText();
        Assert.assertEquals("Error: Last Name is required", error_msg);
        driver.close();
    }
}
