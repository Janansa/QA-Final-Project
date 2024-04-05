package Selleniun_start_projects.Selleniun_start_projects;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TriangleClassifierTest {
	
    private WebDriver driver;

    @Before
    public void setUp() {
    	
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.34.0-win32\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://testpages.eviltester.com/styled/apps/triangle/triangle001.html");
    }

    @Test
    public void test1() {
        submitSides("1", "2", "4");
        assertEquals("Error: Not a Triangle", getResult());
    }
    
    @Test
    public void test2() {
        submitSides("3", "1", "1");
        assertEquals("Error: Not a Triangle", getResult());
    }
    
    @Test
    public void test3() {
        submitSides("1", "3", "1");
        assertEquals("Error: Not a Triangle", getResult());
    }
    
    @Test
    public void test4() {
        submitSides("1", "1", "3");
        assertEquals("Error: Not a Triangle", getResult());
    }
    
    @Test
    public void test5() {
        submitSides("4", "5", "6");
        assertEquals("Scalene", getResult());
    }
    
    @Test
    public void test6() {
        submitSides("5", "4", "4");
        assertEquals("Isosceles", getResult());
    }
    
    @Test
    public void test7() {
        submitSides("4", "5", "4");
        assertEquals("Isosceles", getResult());
    }
    
    @Test
    public void test8() {
        submitSides("4", "4", "5");
        assertEquals("Isosceles", getResult());
    }
    
    @Test
    public void test9() {
        submitSides("4", "4", "4");
        assertEquals("Equilateral", getResult());
    }
    
    @Test
    public void test10() {
        submitSides("-1", "-5", "-5");
        assertEquals("Error: Not a Triangle", getResult());
    }

    @Test
    public void test11() {
        submitSides("a", "b", "c");
        assertEquals("Error: Side 1 is not a Number", getResult());
    }
    
    @Test
    public void test12() {
        submitSides("a", "1", "2");
        assertEquals("Error: Side 1 is not a Number", getResult());
    }
    
    @Test
    public void test13() {
        submitSides("1", "b", "3");
        assertEquals("Error: Side 2 is not a Number", getResult());
    }
    
    @Test
    public void test14() {
        submitSides("1", "2", "c");
        assertEquals("Error: Side 3 is not a Number", getResult());
    }

    private void submitSides(String a, String b, String c) {
        WebElement side1 = driver.findElement(By.id("side1"));
        WebElement side2 = driver.findElement(By.id("side2"));
        WebElement side3 = driver.findElement(By.id("side3"));
        WebElement calculateButton = driver.findElement(By.id("identify-triangle-action"));

        side1.clear();
        side2.clear();
        side3.clear();

        side1.sendKeys(a);
        side2.sendKeys(b);
        side3.sendKeys(c);
        calculateButton.click();
    }

    private String getResult() {
        WebElement result = driver.findElement(By.id("triangle-type"));
        return result.getText();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

