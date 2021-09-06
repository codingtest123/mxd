package coding;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static coding.prject.Project.今天;
import static coding.prject.Project.保存;
import static coding.prject.Project.列表第一条;
import static coding.prject.Project.创建成功;
import static coding.prject.Project.创建迭代;
import static coding.prject.Project.创建迭代成功;
import static coding.prject.Project.创建迭代按钮;
import static coding.prject.Project.删除迭代;
import static coding.prject.Project.明天;
import static coding.prject.Project.更多;
import static coding.prject.Project.更新成功;
import static coding.prject.Project.更新成功提示;
import static coding.prject.Project.确定删除;
import static coding.prject.Project.编辑迭代;
import static coding.prject.Project.编辑迭代标题名;
import static coding.prject.Project.迭代删除成功;
import static coding.prject.Project.迭代删除成功提示;
import static coding.prject.Project.迭代更多;
import static coding.prject.Project.迭代标题;
import static coding.prject.Project.迭代标题输入框;
import static coding.prject.Project.迭代菜单;
import static coding.prject.Project.选择第一个人员;
import static coding.prject.Project.选择迭代开始时间;
import static coding.prject.Project.选择迭代结束时间;
import static coding.prject.Project.选择迭代负责人;
import static coding.prject.Project.项目协同菜单;

/**
 * 迭代管理
 */
@Test
public class TestIterations extends TestLogin {
    String text;

    /**
     * 新建迭代
     */
    @Test(priority = 1)
    public void testCreatIterations() throws InterruptedException {
        String IterationsName;

        gotoFirstProject();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(项目协同菜单)));
        driver.findElement(By.cssSelector(项目协同菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(迭代菜单)));
        driver.findElement(By.cssSelector(迭代菜单)).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(创建迭代按钮)));
        driver.findElement(By.cssSelector(创建迭代按钮)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(迭代标题输入框)));
        driver.findElement(By.cssSelector(迭代标题输入框)).sendKeys(迭代标题);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(选择迭代负责人)));
        driver.findElement(By.cssSelector(选择迭代负责人)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(选择第一个人员)));
        driver.findElement(By.cssSelector(选择第一个人员)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(选择迭代开始时间)));
        driver.findElement(By.cssSelector(选择迭代开始时间)).click();
        driver.findElement(By.cssSelector(今天)).click();

        driver.findElement(By.cssSelector(选择迭代结束时间)).click();
        driver.findElement(By.cssSelector(明天)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(创建迭代)));
        driver.findElement(By.cssSelector(创建迭代)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(创建迭代成功)));
        IterationsName = driver.findElement(By.cssSelector(创建迭代成功)).getAttribute("textContent");

        System.out.println("IterationsName=" + IterationsName);

        Assert.assertTrue(IterationsName.contains(创建成功));

        Thread.sleep(2000);

    }

    /**
     * 编辑迭代
     */
    @Test(dependsOnMethods = "testCreatIterations", priority = 2)
    public void testEditIterations() throws InterruptedException {
        String IterationsName;

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(列表第一条)));
        driver.findElement(By.cssSelector(列表第一条)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(迭代更多)));
        driver.findElement(By.cssSelector(迭代更多)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(编辑迭代)));
        driver.findElement(By.cssSelector(编辑迭代)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(迭代标题输入框)));

        driver.findElement(By.cssSelector(迭代标题输入框)).clear();
        driver.findElement(By.cssSelector(迭代标题输入框)).sendKeys(编辑迭代标题名);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(保存)));
        driver.findElement(By.cssSelector(保存)).click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(更新成功)));
        IterationsName = driver.findElement(By.cssSelector(更新成功)).getAttribute("textContent");
        System.out.println("IterationsName=" + IterationsName);

        Assert.assertTrue(IterationsName.contains(更新成功提示));

    }

    /**
     * 删除迭代
     */
    @Test(dependsOnMethods = "testCreatIterations", priority = 3)
    public void deleteIteration() throws InterruptedException {
        String Strmsg;

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(项目协同菜单)));
        driver.findElement(By.cssSelector(项目协同菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(迭代菜单)));
        driver.findElement(By.cssSelector(迭代菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(列表第一条)));
        driver.findElement(By.cssSelector(列表第一条)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(更多)));
        driver.findElement(By.cssSelector(更多)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(删除迭代)));
        driver.findElement(By.cssSelector(删除迭代)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(确定删除)));
        driver.findElement(By.cssSelector(确定删除)).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(迭代删除成功提示)));
        Strmsg = driver.findElement(By.cssSelector(迭代删除成功提示)).getAttribute("textContent");
        System.out.println("Strmsg=" + Strmsg);

        Assert.assertTrue(Strmsg.contains(迭代删除成功));

        Thread.sleep(1000);

    }

}
