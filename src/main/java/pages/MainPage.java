package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    //кнопка "Закзать" верхняя
    public By buttonOrder1 = By.xpath(".//button[@class='Button_Button__ra12g']");
    //кнопка "Заказать" нижняя
    public By buttonOrder2 = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By listImportantQuestions = By.xpath(".//div[@class='Home_FAQ__3uVm4']");
    //кнопка куки
    private By cookieButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonOrder1(){
        driver.findElement(buttonOrder1).click();
    }
    public void clickButtonOrder2(){
        driver.findElement(buttonOrder2).click();
    }


    //метод скролла и клик в кнопку принятия куки
    public void clickButtonCookie() {
        WebElement button = driver.findElement(cookieButton);
        if (button == null) {
            System.out.println("Кнопка не найдена!");
            return;
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", button);
        button.click();
    }

    //метод скролла до "Вопросы о важном"
    public void scrollImportantQuestions() {
        WebElement element = driver.findElement(listImportantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
    }

    public String clickQuestions(int indexQuestion) {
        driver.findElement(By.id("accordion__heading-" + (indexQuestion))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__panel-" + indexQuestion)));
        return driver.findElement(By.id("accordion__panel-" + indexQuestion)).getText();

    }
}

