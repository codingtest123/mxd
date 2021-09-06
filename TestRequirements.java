package coding;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static coding.prject.Project.列表第一条;
import static coding.prject.Project.创建需求;
import static coding.prject.Project.删除;
import static coding.prject.Project.新建需求成功;
import static coding.prject.Project.更多;
import static coding.prject.Project.测试需求描述;
import static coding.prject.Project.确定删除;
import static coding.prject.Project.确认创建需求;
import static coding.prject.Project.编辑成功;
import static coding.prject.Project.编辑需求成功;
import static coding.prject.Project.编辑需求标题;
import static coding.prject.Project.编辑需求输入框;
import static coding.prject.Project.选择敏捷配置;
import static coding.prject.Project.需求创建成功;
import static coding.prject.Project.需求描述;
import static coding.prject.Project.需求标题;
import static coding.prject.Project.需求标题输入框;
import static coding.prject.Project.需求菜单;
import static coding.prject.Project.项目协同菜单;


/**
 * 需求管理
 */
@Test
public class TestRequirements extends TestLogin {

    /**
     * 新建需求
     */
    @Test(priority = 1)
    public void testCreatRequirement() throws InterruptedException {
        String Strmsg;
        gotoFirstProject();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(项目协同菜单)));
        driver.findElement(By.cssSelector(项目协同菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(选择敏捷配置)));
        driver.findElement(By.cssSelector(选择敏捷配置)).click();

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(需求菜单)));
        driver.findElement(By.cssSelector(需求菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(创建需求)));
        driver.findElement(By.cssSelector(创建需求)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(需求标题输入框)));
        driver.findElement(By.cssSelector(需求标题输入框)).sendKeys(需求标题);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(需求描述)));
        driver.findElement(By.cssSelector(需求描述)).sendKeys(测试需求描述);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(确认创建需求)));
        driver.findElement(By.cssSelector(确认创建需求)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(新建需求成功)));

        Strmsg = driver.findElement(By.cssSelector(新建需求成功)).getAttribute("textContent");
//        Strmsg = driver.switchTo().activeElement().getText();
        System.out.println("Strmsg=" + Strmsg);
        Assert.assertTrue(Strmsg.contains(需求创建成功));

        //判断文件信息是否存在，存在为True
//        Assert.assertTrue(Strmsg.startsWith(需求创建成功));


    }


    /**
     * 编辑需求
     */
    @Test(dependsOnMethods = "testCreatRequirement", priority = 2)
    public void testEditRequirement() throws InterruptedException {
        String Strmsg;

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(列表第一条)));
        driver.findElement(By.cssSelector(列表第一条)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(编辑需求输入框)));
        driver.findElement(By.cssSelector(编辑需求输入框)).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(编辑需求输入框)).clear();

        driver.findElement(By.cssSelector(编辑需求输入框)).sendKeys(编辑需求标题);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(需求菜单)));
        driver.findElement(By.cssSelector(需求菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(编辑需求成功)));
        Strmsg = driver.findElement(By.cssSelector(编辑需求成功)).getAttribute("textContent");

        Assert.assertTrue(Strmsg.contains(编辑成功));

    }

    /**
     * 删除需求
     */
    @Test(dependsOnMethods = "testCreatRequirement", priority = 3)
    public void testDeleteRequirement() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(列表第一条)));
        driver.findElement(By.cssSelector(列表第一条)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(更多)));
        driver.findElement(By.cssSelector(更多)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(删除)));
        driver.findElement(By.cssSelector(删除)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(确定删除)));
        driver.findElement(By.cssSelector(确定删除)).click();
//        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }

}
