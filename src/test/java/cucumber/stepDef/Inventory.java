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

public class Inventory {
    WebDriver driver;
    String base_url = "https://www.saucedemo.com";

    @Given("Pengguna sudah membuka halaman login saucedemo.com")
    public void penggunaSudahMembukaHalamanLoginSaucedemoCom() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(base_url);
        String titlePage = driver.findElement(By.xpath("//*[@id=\'root\']/div/div[1]")).getText();
        Assert.assertEquals("Swag Labs",titlePage);
    }

    @When("Pengguna input username dan password dengan akun standard_user")
    public void penggunaInputUsernameDanPasswordDenganAkunStandard_user() {
        // Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");;
        // Input Username
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("Pengguna input username dan password dengan akun problem_user")
    public void penggunaInputUsernameDanPasswordDenganAkunProblem_user() {
        // Input Username
        driver.findElement(By.id("user-name")).sendKeys("problem_user");;
        // Input Username
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Pengguna klik button login")
    public void penggunaKlikButtonLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Pengguna berhasil login dan aplikasi menampilkan gambar produk yang sesuai")
    public void penggunaBerhasilLoginDanAplikasiMenampilkanGambarProdukYangSesuai() {
        String src_img = driver.findElement(By.xpath("//*[@id=\'item_4_img_link\']/img")).getAttribute("src");
        Assert.assertNotEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", src_img);

        driver.close();
    }

    @Then("Pengguna berhasil login dan aplikasi menampilkan gambar produk yang tidak sesuai")
    public void penggunaBerhasilLoginDanAplikasiMenampilkanGambarProdukYangTidakSesuai() {
        String src_img = driver.findElement(By.xpath("//*[@id=\'item_4_img_link\']/img")).getAttribute("src");
        Assert.assertEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", src_img);

        driver.close();
    }


}
