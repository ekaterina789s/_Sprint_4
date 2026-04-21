package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    //кнопка "Закзать" верхняя
    private By buttonOrder1 = By.xpath(".//button[@class='Button_Button__ra12g']");
    //кнопка "Заказать" нижняя
    private By buttonOrder2 = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By listImportantQuestions = By.xpath(".//div[@class='Home_FAQ__3uVm4']");
    //кнопка куки
    private By cookieButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonOrder1() {
        driver.findElement(buttonOrder1).click();
    }
    public void clickButtonOrder2() {
        driver.findElement(buttonOrder2).click();
    }


    //метод скролла и клик в кнопку принятия куки
    public void clickButtonCookie() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();
        } catch (TimeoutException e) {
            System.out.println("Кнопка куки не появилась в течение 15 секунд");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Элемент перекрыт другим элементом, используем JavaScript для клика");
            WebElement button = driver.findElement(cookieButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        } catch (NoSuchElementException e) {
            System.out.println("Кнопка куки не найдена на странице");
        }
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

