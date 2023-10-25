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

public class Login {
    WebDriver driver;
    String base_url = "https://www.saucedemo.com";


    @Given("Pengguna sudah membuka halaman saucedemo.com")
    public void penggunaSudahMembukaHalamanSaucedemoCom() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(base_url);
        String titlePage = driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]")).getText();
        Assert.assertEquals("Swag Labs",titlePage);
    }

    @When("Pengguna input username dan password")
    public void penggunaInputUsernameDanPassword() {
        // Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");;
        // Input Username
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Pengguna klik tombol login")
    public void penggunaKlikTombolLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Pengguna berhasil login dan diarahkan kehalaman produk")
    public void penggunaBerhasilLoginDanDiarahkanKehalamanProduk() {
        String titleProducts = driver.findElement(By.xpath("//*[@id=\'header_container\']/div[2]/span")).getText();
        Assert.assertEquals("Products", titleProducts);
        driver.close();
    }

    @Then("Pengguna mendapatkan pesan error")
    public void penggunaMendapatkanPesanError() {
        String errorMessage = driver.findElement(By.xpath("//*[@id=\'login_button_container\']/div/form/div[3]/h3")).getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorMessage);
        driver.close();
    }

    @When("Pengguna input username dan password yang salah")
    public void penggunaInputUsernameDanPasswordYangSalah() {
        // Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");;
        // Input Username
        driver.findElement(By.id("password")).sendKeys("wrong_pass");
    }
}
