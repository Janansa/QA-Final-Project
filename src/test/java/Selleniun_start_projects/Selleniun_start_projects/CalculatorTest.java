package Selleniun_start_projects.Selleniun_start_projects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class CalculatorTest {

    private WebDriver driver;

    @Before
    public void setUp() {
    	
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win32\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://testpages.eviltester.com/styled/apps/calculator.html");
    }

    @Test
    public void testAddition1() {
    	
    	WebElement clear = driver.findElement(By.id("buttonallclear"));
        clear.click();
        
        WebElement firstNumber = driver.findElement(By.id("button01"));
        firstNumber.click();
      
        WebElement addButton = driver.findElement(By.id("buttonplus"));
        addButton.click();

        WebElement secondNumber = driver.findElement(By.id("button02"));
        secondNumber.click();
        
        WebElement submitButton = driver.findElement(By.id("buttonequals"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("calculated-display"));

        assertEquals("3", result.getAttribute("value"));

    }
    
    @Test
    public void testAddition2() {
    	WebElement clear = driver.findElement(By.id("buttonallclear"));
        clear.click();
        
        WebElement firstNumber = driver.findElement(By.id("button09"));
        firstNumber.click();
      
        WebElement addButton = driver.findElement(By.id("buttonplus"));
        addButton.click();

        WebElement secondNumber = driver.findElement(By.id("button01"));
        secondNumber.click();
        
        WebElement thirdNumber = driver.findElement(By.id("button00"));
        thirdNumber.click();
        
        WebElement submitButton = driver.findElement(By.id("buttonequals"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("calculated-display"));

        assertEquals("19", result.getAttribute("value"));

    }

    @Test
    public void testSubtraction1() {
    	WebElement clear = driver.findElement(By.id("buttonallclear"));
        clear.click();
    	
    	WebElement firstNumber = driver.findElement(By.id("button09"));
        firstNumber.click();
      
        WebElement subButton = driver.findElement(By.id("buttonminus"));
        subButton.click();

        WebElement secondNumber = driver.findElement(By.id("button02"));
        secondNumber.click();
        
        WebElement submitButton = driver.findElement(By.id("buttonequals"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("calculated-display"));

        assertEquals("7", result.getAttribute("value"));
    }
    
    @Test
    public void testSubtraction2() {
    	WebElement clear = driver.findElement(By.id("buttonallclear"));
        clear.click();
    	
    	WebElement firstNumber = driver.findElement(By.id("button09"));
        firstNumber.click();

        WebElement secondNumber = driver.findElement(By.id("button02"));
        secondNumber.click();
        
        WebElement subButton = driver.findElement(By.id("buttonminus"));
        subButton.click();
        
        WebElement thirdNumber = driver.findElement(By.id("button05"));
        thirdNumber.click();
        
        WebElement submitButton = driver.findElement(By.id("buttonequals"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("calculated-display"));

        assertEquals("87", result.getAttribute("value"));
    }
    
    
    @Test
    public void testMultiplication1() {
    	WebElement clear = driver.findElement(By.id("buttonallclear"));
        clear.click();
    	
    	WebElement firstNumber = driver.findElement(By.id("button02"));
        firstNumber.click();
      
        WebElement subButton = driver.findElement(By.id("buttonmultiply"));
        subButton.click();

        WebElement secondNumber = driver.findElement(By.id("button02"));
        secondNumber.click();
        
        WebElement submitButton = driver.findElement(By.id("buttonequals"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("calculated-display"));

        assertEquals("4", result.getAttribute("value"));
    }
    
    @Test
    public void testMultiplication2() {
    	WebElement clear = driver.findElement(By.id("buttonallclear"));
        clear.click();
    	
    	WebElement firstNumber = driver.findElement(By.id("button06"));
        firstNumber.click();
      
        WebElement subButton = driver.findElement(By.id("buttonmultiply"));
        subButton.click();

        WebElement secondNumber = driver.findElement(By.id("button04"));
        secondNumber.click();
        
        WebElement submitButton = driver.findElement(By.id("buttonequals"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("calculated-display"));

        assertEquals("24", result.getAttribute("value"));
    }
    
    @Test
    public void testDivision1() {
    	WebElement clear = driver.findElement(By.id("buttonallclear"));
        clear.click();
    	
    	WebElement firstNumber = driver.findElement(By.id("button06"));
        firstNumber.click();
      
        WebElement subButton = driver.findElement(By.id("buttondivide"));
        subButton.click();

        WebElement secondNumber = driver.findElement(By.id("button04"));
        secondNumber.click();
        
        WebElement submitButton = driver.findElement(By.id("buttonequals"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("calculated-display"));

        assertEquals("1.5", result.getAttribute("value"));
    }
    
    @Test
    public void testDivision2() {
    	WebElement clear = driver.findElement(By.id("buttonallclear"));
        clear.click();
    	
    	WebElement firstNumber = driver.findElement(By.id("button09"));
        firstNumber.click();
      
        WebElement subButton = driver.findElement(By.id("buttondivide"));
        subButton.click();

        WebElement secondNumber = driver.findElement(By.id("button03"));
        secondNumber.click();
        
        WebElement submitButton = driver.findElement(By.id("buttonequals"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("calculated-display"));

        assertEquals("3", result.getAttribute("value"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
