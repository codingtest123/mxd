package coding;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static coding.prject.Project.列表第一条;
import static coding.prject.Project.创建成功;
import static coding.prject.Project.创建缺陷按钮;
import static coding.prject.Project.删除;
import static coding.prject.Project.新建缺陷标题输入框;
import static coding.prject.Project.更多;
import static coding.prject.Project.更新成功;
import static coding.prject.Project.更新成功提示;
import static coding.prject.Project.确定删除;
import static coding.prject.Project.确认创建缺陷按钮;
import static coding.prject.Project.编辑缺陷名;
import static coding.prject.Project.缺陷描述;
import static coding.prject.Project.缺陷描述输入框;
import static coding.prject.Project.缺陷标题;
import static coding.prject.Project.缺陷编辑输入框;
import static coding.prject.Project.缺陷菜单;
import static coding.prject.Project.项目协同菜单;

/**
 * 缺陷管理
 */
public class TestBugTracking extends TestLogin {

    /**
     * 新建缺陷
     */
    @Test(priority = 1)
    public void testCreateBug() throws InterruptedException {

        String Strmsg;
        gotoFirstProject();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(项目协同菜单)));
        driver.findElement(By.cssSelector(项目协同菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(缺陷菜单)));
        driver.findElement(By.cssSelector(缺陷菜单)).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(使用默认配置)));
//        driver.findElement(By.cssSelector(使用默认配置)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(创建缺陷按钮)));
        driver.findElement(By.cssSelector(创建缺陷按钮)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(新建缺陷标题输入框)));
        driver.findElement(By.cssSelector(新建缺陷标题输入框)).sendKeys(缺陷标题);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(缺陷描述输入框)));
        driver.findElement(By.cssSelector(缺陷描述输入框)).sendKeys(缺陷描述);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(确认创建缺陷按钮)));
        driver.findElement(By.cssSelector(确认创建缺陷按钮)).click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(更新成功)));
        Strmsg = driver.findElement(By.cssSelector(更新成功)).getAttribute("textContent");
        System.out.println("Strmsg=" + Strmsg);

        Assert.assertTrue(Strmsg.contains(创建成功));
    }


    /**
     * 编辑缺陷
     */
    @Test(priority = 2, dependsOnMethods = "testCreateBug")
    public void testEditBug() throws InterruptedException {
        String Strmsg;

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(列表第一条)));
        driver.findElement(By.cssSelector(列表第一条)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(缺陷编辑输入框)));
        driver.findElement(By.cssSelector(缺陷编辑输入框)).clear();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(缺陷编辑输入框)).clear();
        driver.findElement(By.cssSelector(缺陷编辑输入框)).sendKeys(编辑缺陷名);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(缺陷菜单)));
        driver.findElement(By.cssSelector(缺陷菜单)).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(更新成功)));
        Strmsg = driver.findElement(By.cssSelector(更新成功)).getAttribute("textContent");
        System.out.println("Strmsg=" + Strmsg);

        Assert.assertTrue(Strmsg.contains(更新成功提示));
    }


    /**
     * 删除缺陷
     */
    @Test(priority = 3, dependsOnMethods = "testCreateBug")
    public void testDeleteBug() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(列表第一条)));
        driver.findElement(By.cssSelector(列表第一条)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(更多)));
        driver.findElement(By.cssSelector(更多)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(删除)));
        driver.findElement(By.cssSelector(删除)).click();

        Thread.sleep(1000);
        driver.findElement(By.cssSelector(确定删除)).click();

//        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
}
