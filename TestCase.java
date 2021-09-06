package coding;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static coding.prject.Project.分组名;
import static coding.prject.Project.分组名输入框;
import static coding.prject.Project.创建用例;
import static coding.prject.Project.前往管理用例;
import static coding.prject.Project.去编写用例;
import static coding.prject.Project.增加分组;
import static coding.prject.Project.测试概览菜单;
import static coding.prject.Project.测试管理菜单;
import static coding.prject.Project.用例标题;
import static coding.prject.Project.用例标题输入框;

public class TestCase extends TestLogin {

    /**
     * 新建用例
     */
    @Test
    public void testCreatCase() throws InterruptedException {

        String Strmsg;
        gotoFirstProject();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(测试管理菜单)));
        driver.findElement(By.cssSelector(测试管理菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(测试概览菜单)));
        driver.findElement(By.cssSelector(测试概览菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(前往管理用例)));
        driver.findElement(By.cssSelector(前往管理用例)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(去编写用例)));
        driver.findElement(By.cssSelector(去编写用例)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(增加分组)));
        driver.findElement(By.cssSelector(增加分组)).click();

        driver.findElement(By.cssSelector(分组名输入框)).sendKeys(分组名);
        driver.findElement(By.cssSelector(分组名输入框)).sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector(创建用例)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(用例标题输入框)));
        driver.findElement(By.cssSelector(用例标题输入框)).sendKeys(用例标题);






        Thread.sleep(1000);

    }
}
