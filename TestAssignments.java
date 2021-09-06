package coding;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static coding.prject.Project.任务描述;
import static coding.prject.Project.任务描述输入框;
import static coding.prject.Project.任务标题;
import static coding.prject.Project.任务标题输入框;
import static coding.prject.Project.任务编辑输入框;
import static coding.prject.Project.任务菜单;
import static coding.prject.Project.列表第一条;
import static coding.prject.Project.创建任务按钮;
import static coding.prject.Project.删除;
import static coding.prject.Project.更多;
import static coding.prject.Project.更新成功;
import static coding.prject.Project.更新成功提示;
import static coding.prject.Project.确定删除;
import static coding.prject.Project.确认创建任务按钮;
import static coding.prject.Project.编辑任务名;
import static coding.prject.Project.项目协同菜单;

/**
 * 任务管理
 */
public class TestAssignments extends TestLogin {

    /**
     * 新建任务
     */
    @Test(priority = 1)
    public void testCreateAssignment() throws InterruptedException {

        String Strmsg;
        gotoFirstProject();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(项目协同菜单)));
        driver.findElement(By.cssSelector(项目协同菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(任务菜单)));
        driver.findElement(By.cssSelector(任务菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(创建任务按钮)));
        driver.findElement(By.cssSelector(创建任务按钮)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(任务标题输入框)));
        driver.findElement(By.cssSelector(任务标题输入框)).sendKeys(任务标题);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(任务描述输入框)));
        driver.findElement(By.cssSelector(任务描述输入框)).sendKeys(任务描述);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(确认创建任务按钮)));
        driver.findElement(By.cssSelector(确认创建任务按钮)).click();

        Thread.sleep(2000);

        Strmsg = driver.findElement(By.cssSelector(更新成功)).getAttribute("textContent");
        System.out.println("Strmsg=" + Strmsg);

        Assert.assertTrue(Strmsg.contains("创建成功"));
    }


    /**
     * 编辑任务
     */
    @Test(priority = 2, dependsOnMethods = "testCreateAssignment")
    public void testEditAssignment() throws InterruptedException {
        String Strmsg;

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(列表第一条)));
        driver.findElement(By.cssSelector(列表第一条)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(任务编辑输入框)));
        driver.findElement(By.cssSelector(任务编辑输入框)).clear();
        driver.findElement(By.cssSelector(任务编辑输入框)).sendKeys(编辑任务名);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(任务菜单)));
        driver.findElement(By.cssSelector(任务菜单)).click();

        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(更新成功)));

        Strmsg = driver.findElement(By.cssSelector(更新成功)).getAttribute("textContent");
        System.out.println("Strmsg=" + Strmsg);

        Assert.assertTrue(Strmsg.contains(更新成功提示));

    }


    /**
     * 删除任务
     */
    @Test(priority = 3, dependsOnMethods = "testCreateAssignment")
    public void testDeleteAssignment() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(列表第一条)));
        driver.findElement(By.cssSelector(列表第一条)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(更多)));
        driver.findElement(By.cssSelector(更多)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(删除)));
        driver.findElement(By.cssSelector(删除)).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector(确定删除)).click();

        Thread.sleep(1000);
//        driver.switchTo().alert().accept();
    }
}
