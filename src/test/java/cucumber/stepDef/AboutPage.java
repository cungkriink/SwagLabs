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

public class AboutPage {
    WebDriver driver;
    String base_url = "https://www.saucedemo.com";

    @Given("Pengguna sudah login menggunakan standard_user")
    public void penggunaSudahLoginMenggunakanStandard_user() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(base_url);

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");;
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("Pengguna klik menu utama")
    public void penggunaKlikMenuUtama() {
        driver.findElement(By.id("react-burger-menu-btn")).click();

    }

    @And("Pengguna klik item menu about")
    public void penggunaKlikItemMenuAbout() {
        driver.findElement(By.xpath("//*[@id=\'about_sidebar_link\']")).click();
    }

    @Then("pengguna diarahkan kehalaman about")
    public void penggunaDiarahkanKehalamanAbout() {
        Assert.assertEquals("Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing", driver.getTitle());
        driver.close();
    }

    @Given("Pengguna sudah login menggunakan problem_user")
    public void penggunaSudahLoginMenggunakanProblem_user() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(base_url);

        // Login
        driver.findElement(By.id("user-name")).sendKeys("problem_user");;
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Then("halaman about tidak ditemukan {int}")
    public void halamanAboutTidakDitemukan(int arg0) {
        Assert.assertEquals("404 Error Page", driver.getTitle());
        driver.close();
    }

}
