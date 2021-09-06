package coding;

import coding.prject.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static coding.prject.Login.DevOps项目;
import static coding.prject.Login.新建项目;
import static coding.prject.Project.第一个项目;
import static coding.prject.Project.项目;
import static coding.prject.Project.项目公告框;
import static coding.prject.Project.项目地址输入框;
import static coding.prject.Project.项目描述;
import static coding.prject.Project.项目描述输入框;


/**
 * 新建项目
 */
@Test
public class TestCreatProject extends TestLogin {

    @Test
    public void testCreatProject() throws InterruptedException {
        String elemEnt;
//        testLogin();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(项目)));
        driver.findElement(By.cssSelector(项目)).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(新建项目)));
        driver.findElement(By.cssSelector(新建项目)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(DevOps项目)));
        driver.findElement(By.cssSelector(DevOps项目)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Project.项目名称输入框)));
        driver.findElement(By.cssSelector(Project.项目名称输入框)).sendKeys(projectName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(项目描述输入框)));
        driver.findElement(By.cssSelector(项目描述输入框)).click();
        driver.findElement(By.cssSelector(Project.项目描述输入框)).sendKeys(项目描述);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(Project.完成创建)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(项目公告框)));
        Assert.assertEquals(driver.getCurrentUrl(), "http://codingcorp.coding.io/p/" + projectName);
//        Assert.assertThrows();
    }

}
