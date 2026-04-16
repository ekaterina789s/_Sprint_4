import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.AboutRentForm;
import pages.CustomerDataForm;
import pages.MainPage;

@RunWith(Parameterized.class)
public class OrderTests extends BaseUITest{
    WebDriver driver;

    //поля класса(те, что в форме)
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String dateDelivery;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTests(String name, String surname, String address, String metro, String phone, String dateDelivery, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.dateDelivery = dateDelivery;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] dataCustomer(){
        return new Object[][]{
                {"Мария", "Петрова", "Москва ул.Ленина д. 120", "Сокольники", "89185630405", "25.04.2026", "сутки", "grey", "хочу кататься"},
                {"Владимир", "Кузнецов", "Москва ул. Пушкина д.30", "Красносельская", "89884058207", "01.05.2026", "двое суток", "black", "всегда хотел"},
        };
    }

    @Test
    public void makeOrderHeader() {
        MainPage mainPage = new MainPage(driver);
        CustomerDataForm customerDataForm = new CustomerDataForm(driver);
        AboutRentForm aboutRentForm = new AboutRentForm(driver);

        mainPage.clickButtonCookie();
        mainPage.clickButtonOrder1();
        customerDataForm.enterCustomerData(name, surname, address, metro, phone);
        aboutRentForm.enterRentalData(dateDelivery, rentalPeriod, color, comment);
    }
    @Test
    public void makeOrderInPage(){
        MainPage mainPage = new MainPage(driver);
        CustomerDataForm customerDataForm = new CustomerDataForm(driver);
        AboutRentForm aboutRentForm = new AboutRentForm(driver);

        mainPage.clickButtonCookie();
        mainPage.clickButtonOrder2();
        customerDataForm.enterCustomerData(name, surname, address, metro, phone);
        aboutRentForm.enterRentalData(dateDelivery, rentalPeriod, color, comment);


    }

}