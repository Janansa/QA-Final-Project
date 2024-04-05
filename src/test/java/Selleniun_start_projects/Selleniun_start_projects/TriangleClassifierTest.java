package Selleniun_start_projects.Selleniun_start_projects;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

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
    
    // non-numeric
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
    /*
	@Test
    public void testEquilateralTriangle() {
        assertEquals("Equilateral", classifyTriangle(3, 3, 3));
    }

    @Test
    public void testIsoscelesTriangle() {
        assertEquals("Isosceles", classifyTriangle(5, 5, 3));
    }

    @Test
    public void testScaleneTriangle() {
        assertEquals("Scalene", classifyTriangle(4, 5, 6));
    }

    @Test
    public void testInvalidTriangle() {
        assertEquals("Not a triangle", classifyTriangle(1, 2, 3));
    }

    @Test
    public void testZeroLength() {
        assertEquals("Invalid length", classifyTriangle(0, 5, 5));
    }

    @Test
    public void testNegativeLength() {
        assertEquals("Invalid length", classifyTriangle(-1, 5, 5));
    }

    // Note: This test is to demonstrate the concept. Non-numeric input handling depends on the method's input type/signature.
    @Test(expected = NumberFormatException.class)
    public void testNonNumericLength() {
        assertEquals("Invalid input", classifyTriangle(Integer.parseInt("a"), 5, 5));
    }
    
    public static String classifyTriangle(int a, int b, int c) {
            if (a <= 0 || b <= 0 || c <= 0) {
                return "Invalid length";
            }
            if (a == b && b == c) {
                return "Equilateral";
            }
            if (a >= b + c || b >= a + c || c >= a + b) {
                return "Not a triangle";
            }
            if (a == b || b == c || a == c) {
                return "Isosceles";
            }
            return "Scalene";
        }
    */

}

