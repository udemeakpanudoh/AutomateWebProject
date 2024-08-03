package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class BbcSportSteps {
    WebDriver driver;

    @Given("I navigate to the BBC Sport page")
    public void i_navigate_to_the_bbc_sport_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bbc.com/sport");
    }

    @When("I navigate to Formula 1 results page")
    public void i_navigate_to_formula_1_results_page() throws InterruptedException {
        WebElement formula1Link = driver.findElement(By.linkText("Formula 1"));
        formula1Link.click();
        Thread.sleep(2000);
        WebElement resultsLink = driver.findElement(By.xpath("//span[contains(text(),'Results')]"));
        resultsLink.click();
        Thread.sleep(2000);
    }

    @And("I confirmed that the results page has been displayed")
    public void i_confirmed_that_the_results_page_has_been_displayed() throws InterruptedException {
        WebElement heading = driver.findElement(By.xpath("//h1[contains(text(),'Formula 1 Results')][@id='main-heading']"));
        Assert.assertEquals(heading.getText(),"Formula 1 Results");
        Thread.sleep(2000);
    }

    @And("I navigate to the year on the results page")
    public void i_navigate_to_the_year_on_the_results_page() throws InterruptedException {
        WebElement yearLink = driver.findElement(By.xpath("//div[@data-content='2023' and @type='year']"));
        yearLink.click();
        Thread.sleep(7000);
    }

    @When("I retrieve the 3rd place driver at the Las Vegas Grand Prix on 19 November 2023")
    public void i_retrieve_the_3rd_place_driver_at_the_las_vegas_grand_prix_on_19_november_2023() throws InterruptedException {
        WebElement dateLink = driver.findElement(By.xpath("//*[@id=\"main-data\"]/div/div/div/section[2]/h2/button/div/span[4]"));
        dateLink.click();
        Thread.sleep(2000);
    }

    @Then("I print the driver's name")
    public void i_print_the_driver_name() throws InterruptedException {
        WebElement thirdPlaceDriver = driver.findElement(By.xpath("//*[@id=\"main-data\"]/div/div/div/section[2]/div/div/div[1]/table/tbody/tr[3]/td[2]/div"));
        System.out.println("3rd place driver is: " + thirdPlaceDriver.getText());
        Thread.sleep(2000);
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        WebElement searchIcon = driver.findElement(By.xpath("//*[@id='global-navigation']/div[3]/div[2]/a/span[1]"));
        searchIcon.click();
        WebElement searchInput = driver.findElement(By.xpath("//*[@id='searchInput']"));
        searchInput.sendKeys(query);
        searchInput.submit();
    }

    @When("I retrieve the first 3 results of the search")
    public void i_retrieve_the_first_3_results_of_the_search() {
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".css-1aofmbn-PromoHeadline e1f5wbog0"));
        for (int i = 0; i < 3 && i < searchResults.size(); i++) {
            WebElement result = searchResults.get(i);
            String resultTitle = result.getText();
            System.out.println("Title " + (i + 1) + ": " + resultTitle);
        }
    }

    @Then("I print the text under the hyperlink for each of these results")
    public void i_print_the_text_under_the_hyperlink_for_each_of_these_results() {
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".css-1aofmbn-PromoHeadline e1f5wbog0"));
        for (int i = 0; i < 3 && i < searchResults.size(); i++) {
            WebElement result = searchResults.get(i);
            String resultTitle = result.getText();
            System.out.println("Title " + (i + 1) + ": " + resultTitle);
        }

    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}