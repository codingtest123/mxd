package coding;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static coding.prject.Project.*;

public class TestCi extends TestLogin {

    /**
     * 新建CI任务
     */
    @Test(priority = 1)
    public void testCreatTask() throws InterruptedException {
        String Strmsg;
        gotoFirstProject();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(持续集成菜单)));
        driver.findElement(By.cssSelector(持续集成菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(构建计划)));
        driver.findElement(By.cssSelector(构建计划)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(创建构建计划)));
        driver.findElement(By.cssSelector(创建构建计划)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(简易模板)));
        driver.findElement(By.cssSelector(简易模板)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(代码仓库选择下拉框)));
        driver.findElement(By.cssSelector(代码仓库选择下拉框)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(第一个代码库)));
        driver.findElement(By.cssSelector(第一个代码库)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(确认创建构建任务)));
        driver.findElement(By.cssSelector(确认创建构建任务)).click();

        Assert.assertTrue(driver.getPageSource().contains("simple-example"));




//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(选择第一个分支)));
//        driver.findElement(By.cssSelector(选择第一个分支)).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(确认新建CI任务)));
//        driver.findElement(By.cssSelector(确认新建CI任务)).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(流水线配置)));
//        Strmsg = driver.findElement(By.cssSelector(流水线配置)).getAttribute("textContent");
//        System.out.println("Strmsg=" + Strmsg);

//        Assert.assertTrue(Strmsg.contains("流水线配置"));
    }

    /**
     * 修改CI任务名
     */
    @Test(priority = 2, dependsOnMethods = "testCreatTask")
    public void testEditTask() throws InterruptedException {
        String Strmsg;
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(构建计划)));
        driver.findElement(By.cssSelector(构建计划)).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(第一个任务更多)));
        driver.findElement(By.cssSelector(第一个任务更多)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(第一个任务编辑)));
        driver.findElement(By.cssSelector(第一个任务编辑)).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(编辑任务名输入框)));
        driver.findElement(By.cssSelector(编辑任务名输入框)).clear();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(编辑任务名输入框)).sendKeys(新任务名);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(编辑保存)));
        driver.findElement(By.cssSelector(编辑保存)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(保存成功)));
        Strmsg = driver.findElement(By.cssSelector(保存成功)).getAttribute("textContent");

        System.out.println("Strmsg=" + Strmsg);
        Assert.assertTrue(Strmsg.contains(编辑任务成功提示));

        Thread.sleep(3000);
    }

    /**
     * 删除CI任务名
     */
    @Test(priority = 3, dependsOnMethods = "testCreatTask")
    public void testDeleteTask() throws InterruptedException {
        String Strmsg;
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(构建计划)));
        driver.findElement(By.cssSelector(构建计划)).click();

        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(第一个任务更多)));
        driver.findElement(By.cssSelector(第一个任务更多)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(第一个任务删除)));
        driver.findElement(By.cssSelector(第一个任务删除)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(删除任务名输入框)));
        driver.findElement(By.cssSelector(删除任务名输入框)).sendKeys(任务名);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(确认删除任务)));
        driver.findElement(By.cssSelector(确认删除任务)).click();

    }

}
