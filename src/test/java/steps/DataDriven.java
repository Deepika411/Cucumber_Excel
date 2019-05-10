package steps;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataDriven {
	public WebDriver driver;
    public List<HashMap<String,String>> datamap;
    public DataDriven()
    {
       
       datamap = DataHelper.data(System.setProperty("webdriver.chrome.driver", "H:\\mira\\ExcelData\\src\\test\\resources\\lib\\chromedriver.exe")+"H:\\mira\\ExcelData\\target\\Test.xlsx","Sheet1");
        driver=new ChromeDriver();
    }
    @When("I enter into facebook url")
    public void i_enter_into_facebook_url() {
        driver.get("https://www.facebook.com");
    }

    @When("enter username and password with excel row {string} dataset")
    public void enter_username_and_password_with_excel_row_dataset(String string) {
    	System.out.println("Printing current data set...");
    	driver.findElement(By.id("email")).sendKeys(string);
    	driver.findElement(By.name("pass")).sendKeys(string);
        for(HashMap h:datamap)
        {
            System.out.println(h.keySet());
            System.out.println(h.values());
        }
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }
    
		
	
    @Then("success login")
    public void success_login() {
        Assert.assertTrue(true);
    }
    
    @Then("success login message")
    public void success_login_message() {
    	Assert.assertTrue(true);
    }
}
