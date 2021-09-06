package coding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static coding.prject.Login.个人头像;
import static coding.prject.Login.密码输入框;
import static coding.prject.Login.待确认发布;
import static coding.prject.Login.新建项目;
import static coding.prject.Login.用户名输入框;
import static coding.prject.Login.登录按钮;
import static coding.prject.Login.退出登录;
import static coding.prject.Project.我管理的项目;
import static coding.prject.Project.我管理的项目Tab;
import static coding.prject.Project.第一个项目;
import static coding.prject.Project.项目;


public class TestLogin {
    WebDriver driver;
    public String projectName;

//    WebDriverWait wait = new WebDriverWait(driver, 20);


    @BeforeClass
    public void testLogin() throws InterruptedException {
        Date date = new Date();
        SimpleDateFormat dateNow = new SimpleDateFormat("yyyyMMddHHmm");
        projectName = dateNow.format(date);
        String url = "";
        String userName = "";
        String passWorld = "";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.findElement(By.cssSelector(登录按钮)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(用户名输入框)));
        driver.findElement(By.cssSelector(用户名输入框)).sendKeys(userName);
        driver.findElement(By.cssSelector(密码输入框)).sendKeys(passWorld);
        driver.findElement(By.cssSelector(登录按钮)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(待确认发布)));
    }


    /**
     * 访问我管理的第一个项目
     */
    public void gotoFirstProject() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(项目)));
        driver.findElement(By.cssSelector(项目)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(我管理的项目Tab)));
        driver.findElement(By.cssSelector(我管理的项目Tab)).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(第一个项目)));
        driver.findElement(By.cssSelector(第一个项目)).click();

    }

    @AfterClass
    public void afterTest() {
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        action.moveToElement(driver.findElement(By.cssSelector(个人头像))).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(个人头像)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(退出登录)));
        driver.findElement(By.cssSelector(退出登录)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(登录按钮)));
        driver.findElement(By.cssSelector(登录按钮));
        driver.quit();
    }
}
