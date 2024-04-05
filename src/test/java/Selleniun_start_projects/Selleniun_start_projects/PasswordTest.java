package Selleniun_start_projects.Selleniun_start_projects;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PasswordTest {
	private WebDriver driver;

    @Before
    public void setUp() {
    	
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win32\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html");
    }

    @Test
    public void test1() {
    	submitPassword("Abc12*");
        assertEquals("Invalid Value", getResult());
    }
    
    @Test
    public void test2() {
    	submitPassword("Abc123456");
        assertEquals("Invalid Value", getResult());
    }
    
    @Test
    public void test3() {
    	submitPassword("Abc!234");
        assertEquals("Invalid Value", getResult());
    }
    
    @Test
    public void test4() {
    	submitPassword("A1b2C*3");
        assertEquals("Valid Value", getResult());
    }
    
    @Test
    public void test5() {
    	submitPassword("AaZz09*");
        assertEquals("Valid Value", getResult());
    }
    
    @Test
    public void test6() {
    	submitPassword("ggggggg");
        assertEquals("Valid Value", getResult());
    }
    
    @Test
    public void test7() {
    	submitPassword("1234567");
        assertEquals("Valid Value", getResult());
    }
    
    @Test
    public void test8() {
    	submitPassword("DFGHJKL");
        assertEquals("Valid Value", getResult());
    }
    
    @Test
    public void test9() {
    	submitPassword("otghwre");
        assertEquals("Valid Value", getResult());
    }
    
    @Test
    public void test10() {
    	submitPassword("*******");
        assertEquals("Valid Value", getResult());
    }
    
    @Test
    public void test11() {
    	submitPassword("אעיחלוט");
        assertEquals("Invalid Value", getResult());
    }
    
    @Test
    public void test12() {
    	submitPassword("       ");
        assertEquals("Invalid Value", getResult());
    }
    
    private void submitPassword(String password) {
        WebElement input = driver.findElement(By.name("characters"));
        WebElement checkButton = driver.findElement(By.name("validate"));

        input.clear();

        input.sendKeys(password);
        checkButton.click();
    }

    private String getResult() {
        WebElement result = driver.findElement(By.name("validation_message"));
        return result.getAttribute("value");
    }
    
    

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
