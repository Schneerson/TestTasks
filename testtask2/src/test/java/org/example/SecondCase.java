package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
public class SecondCase {
    @Test
    public void Test() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1680, 1050));
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement drop1 = driver.findElement(By.xpath(".//*[@id='selectBuild']"));
        Select sel = new Select(drop1);
        sel.selectByVisibleText("Prototype");
        driver.findElement(By.xpath(".//*[@id='number1Field']")).sendKeys("gs");
        driver.findElement(By.xpath(".//*[@id='number2Field']")).sendKeys("bu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement drop2 = driver.findElement(By.xpath(".//*[@id='selectOperationDropdown']"));
        Select sel2 = new Select(drop2);
        sel2.selectByVisibleText("Concatenate");
        driver.findElement(By.xpath(".//*[@id='calculateButton']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals("gsbu", driver.findElement(By.xpath(".//*[@id='numberAnswerField']")).getAttribute("value"));
        driver.quit();
    }
}