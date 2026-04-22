package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutRentPage {
    WebDriver driver;
    //Дата привоза самоката
    private final By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды самоката
    private final By rentalPeriodDropDownField = By.xpath(".//div[text() = '* Срок аренды']");
    //Выбор цвета самоката
    private final By fieldColor = By.xpath(".//div[text() = 'Цвет самоката']");
    //Комментарий для курьера
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private final By orderConfirmationButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Кнопка "Да" для подтверждения заказа
    private final By yesConfirmationButton = By.xpath(".//button[contains(text(),  'Да')]");

    //Всплывающее окно "Заказ оформлен"
    private final By orderPlaced = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Заказ оформлен')]");

    //Поле с названием страницы "Про аренду"-нужно для того, чтобы закрыть поп-ап выбора даты
    private final By pageTitle = By.xpath(".//div[text()='Про аренду']");


    //геттер для получения поля orderPlaced
    public By getOrderPlaced(){
        return orderPlaced;
    }


    public AboutRentPage(WebDriver driver)
    {
        this.driver = driver;
    }

    // Выбор даты доставки
    public AboutRentPage writeDeliveryDate (String deliveryDate) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
        return this;
    }

    //Выбор срока аренды
    public AboutRentPage selectRentalPeriod (String rentalPeriod){
        driver.findElement(pageTitle).click();
        driver.findElement(rentalPeriodDropDownField).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + rentalPeriod + "']")).click();
        return this;
    }

    //Выбор цвета самоката
    public AboutRentPage selectColor(String color){
        driver.findElement(fieldColor).click();
        driver.findElement(By.xpath(".//label[@for='" + color + "']")).click();
        return this;
    }

    // Ввод коментария
    public AboutRentPage writeComment (String comment){
        driver.findElement(commentField).sendKeys(comment);
        return this;
    }

    //Клик в кнопку "Заказать"
    public void clickOrderConfirmationButton() {
        driver.findElement(orderConfirmationButton).click();
    }

    //Клик в кнопку "Да"
    public void clickYesConfirmationButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(yesConfirmationButton));
        driver.findElement(yesConfirmationButton).click();
    }

    // Ожидание заголовка Заказ оформлен
    public void waitOrderPlaced() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(orderPlaced));
    }

    //Метод ввода необходимых данных
    public void enterRentalData(String deliveryDate, String rentalPeriod, String color, String comment){
        writeDeliveryDate(deliveryDate)
                .selectRentalPeriod(rentalPeriod)
                .selectColor(color)
                .writeComment(comment)
                .clickOrderConfirmationButton();
        clickYesConfirmationButton();
        waitOrderPlaced();
    }

}
