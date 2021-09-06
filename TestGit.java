package coding;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static coding.prject.Project.代码仓库菜单;
import static coding.prject.Project.代码浏览新建;
import static coding.prject.Project.代码浏览更多;
import static coding.prject.Project.分支Tab;
import static coding.prject.Project.分支创建成功;
import static coding.prject.Project.分支创建成功提示;
import static coding.prject.Project.分支删除成功;
import static coding.prject.Project.分支名称;
import static coding.prject.Project.分支名称输入框;
import static coding.prject.Project.列表第一个合并请求;
import static coding.prject.Project.删除分支;
import static coding.prject.Project.勾选删除源分支;
import static coding.prject.Project.合并分支按钮;
import static coding.prject.Project.合并请求tab;
import static coding.prject.Project.合并请求描述;
import static coding.prject.Project.合并请求描述输入框;
import static coding.prject.Project.合并请求标题;
import static coding.prject.Project.合并请求标题输入框;
import static coding.prject.Project.启用README文件初始化仓库;
import static coding.prject.Project.快速初始化仓库;
import static coding.prject.Project.快速初始化仓库按钮;
import static coding.prject.Project.提交创建新分支并发起合并请求;
import static coding.prject.Project.提交按钮;
import static coding.prject.Project.文件内容;
import static coding.prject.Project.文件内容输入框;
import static coding.prject.Project.新建代码分支按钮;
import static coding.prject.Project.新建合并请求;
import static coding.prject.Project.新建文件;
import static coding.prject.Project.新建文件名;
import static coding.prject.Project.新建文件名输入框;
import static coding.prject.Project.确定删除分支按钮;
import static coding.prject.Project.确认创建分支按钮;
import static coding.prject.Project.确认提交按钮;
import static coding.prject.Project.确认新建文件按钮;
import static coding.prject.Project.第一个分支更多;
import static coding.prject.Project.项目概览菜单;

@Test
public class TestGit extends TestLogin {

    /**
     * 初始化仓库
     */
    @Test(priority = 1)
    public void testInitGit() throws InterruptedException {

        gotoFirstProject();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(代码仓库菜单)));
        driver.findElement(By.cssSelector(代码仓库菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(快速初始化仓库)));
        driver.findElement(By.cssSelector(快速初始化仓库)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(启用README文件初始化仓库)));
        driver.findElement(By.cssSelector(启用README文件初始化仓库)).click();

        driver.findElement(By.cssSelector(快速初始化仓库按钮)).click();

        Assert.assertFalse(driver.findElement(By.cssSelector(启用README文件初始化仓库)).isSelected());
        Thread.sleep(1000);
    }


    /**
     * 新建分支
     */
    @Test(priority = 2)
    public void testCreateBranch() throws InterruptedException {

        gotoFirstProject();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(代码仓库菜单)));
        driver.findElement(By.cssSelector(代码仓库菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(分支Tab)));
        driver.findElement(By.cssSelector(分支Tab)).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(新建代码分支按钮)));
        driver.findElement(By.cssSelector(新建代码分支按钮)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(分支名称输入框)));
        driver.findElement(By.cssSelector(分支名称输入框)).sendKeys(分支名称);

        driver.findElement(By.cssSelector(确认创建分支按钮)).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(分支创建成功提示)).getAttribute("textContent").contains(分支创建成功));
        Thread.sleep(2000);
    }

    /**
     * 删除分支
     */
    @Test(priority = 3, dependsOnMethods = "testCreateBranch")
    public void testDeleteBranch() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(第一个分支更多)));
        driver.findElement(By.cssSelector(第一个分支更多)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(删除分支)));
        driver.findElement(By.cssSelector(删除分支)).click();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(确定删除分支按钮)));
        driver.findElement(By.cssSelector(确定删除分支按钮)).click();

        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.cssSelector(分支创建成功提示)).getAttribute("textContent").contains(分支删除成功));

    }

    /**
     * 新建文件并新建合并请求
     */
    @Test(priority = 3)
    public void testCreateMerage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        gotoFirstProject();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(代码仓库菜单)));
        driver.findElement(By.cssSelector(代码仓库菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(代码浏览更多)));
        driver.findElement(By.id(代码浏览更多)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(代码浏览新建)));
        driver.findElement(By.cssSelector(代码浏览新建)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(新建文件)));
        driver.findElement(By.cssSelector(新建文件)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(新建文件名输入框)));
        driver.findElement(By.cssSelector(新建文件名输入框)).sendKeys(新建文件名);

        driver.findElement(By.cssSelector(确认新建文件按钮)).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(文件内容输入框)));
        driver.findElement(By.cssSelector(文件内容输入框)).sendKeys(文件内容);

        driver.findElement(By.cssSelector(提交按钮)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(提交创建新分支并发起合并请求)));
        driver.findElement(By.cssSelector(提交创建新分支并发起合并请求)).click();
        driver.findElement(By.cssSelector(确认提交按钮)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(合并请求标题输入框)));
        driver.findElement(By.cssSelector(合并请求标题输入框)).sendKeys(合并请求标题);
        driver.findElement(By.cssSelector(合并请求描述输入框)).sendKeys(合并请求描述);

        driver.findElement(By.cssSelector(新建合并请求)).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("git/merge"));

        Thread.sleep(1000);
    }

    /**
     * 合并合并请求
     */
    @Test(priority = 4)
    public void testMergeMr() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        gotoFirstProject();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(代码仓库菜单)));
        driver.findElement(By.cssSelector(代码仓库菜单)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(合并请求tab)));
        driver.findElement(By.cssSelector(合并请求tab)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(列表第一个合并请求)));
        driver.findElement(By.cssSelector(列表第一个合并请求)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(合并分支按钮)));
        driver.findElement(By.cssSelector(合并分支按钮)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(勾选删除源分支)));
        driver.findElement(By.cssSelector(勾选删除源分支)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(合并分支按钮)));
        driver.findElement(By.cssSelector(合并分支按钮)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(项目概览菜单)));
        driver.findElement(By.cssSelector(项目概览菜单)).click();

        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("合并了"));
    }

}
