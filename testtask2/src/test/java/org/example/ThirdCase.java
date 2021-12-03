package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
public class ThirdCase {
    @Test
    public void Test() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1680, 1050));
        driver.get("https://testsheepnz.github.io/random-number.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement drop1 = driver.findElement(By.xpath(".//*[@id='buildNumber']"));
        Select sel = new Select(drop1);
        sel.selectByVisibleText("Demo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(".//*[@id='rollDiceButton']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(".//*[@id='numberGuess']")).sendKeys("string");
        driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String bodyText = driver.findElement(By.tagName("body")).getText();
        String checktext = "string: Not a number!";
        Assert.assertTrue("Text not found!", bodyText.contains(checktext));
        driver.quit();
    }
}