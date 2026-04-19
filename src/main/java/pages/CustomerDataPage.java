package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerDataPage {
    private WebDriver driver;

    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public CustomerDataPage(WebDriver driver){
        this.driver = driver;
    }

    public CustomerDataPage writeName(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    //Ввод значения в поле "Фамилия"
    public CustomerDataPage writeSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }
    //Ввод значения в поле "Адрес"
    public CustomerDataPage writeAddress(String address){
        driver.findElement(addressField).sendKeys(address);
        return this;
    }
    //Ввод значения в поле "Станция метро"
    public CustomerDataPage selectMetro(String metro){
        driver.findElement(metroField).click();
        driver.findElement(By.xpath(".//ul[@class='select-search__options']/li//div[text()='" + metro + "']/parent::button")).click();
        return this;
    }
    //Ввод значения в поле "Номер телефона"
    public CustomerDataPage writePhoneNumber(String phoneNumber){
        driver.findElement(phoneField).sendKeys(phoneNumber);
        return this;
    }
    //Клик в кнопку "Далее"
    public void clickButtonNext(){
        driver.findElement(buttonNext).click();
    }

    //Метод ввода данных необходимых для заказа
    public void enterCustomerData(String name, String surname, String address, String metro, String phone){
        writeName(name)
                .writeSurname(surname)
                .writeAddress(address)
                .selectMetro(metro)
                .writePhoneNumber(phone)
                .clickButtonNext();
    }


}
