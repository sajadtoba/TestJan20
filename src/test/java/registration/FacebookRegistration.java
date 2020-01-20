package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FacebookRegistration {

    public WebDriver driver = null;

    @BeforeMethod
    public void setUp(){

        // in this method the driver is missing for that we created a globalVariable and initialized
        // Now we need to remove the WebDriver

        System.setProperty("webdriver.chrome.driver","/Users/sajadakbar/Documents/develop/SeleniumJuly2019/facebook/src/main/java/driver/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().fullscreen();
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    //Create to test if we are on the right website or not

    @Test
    public void testUserCannotRegisterIfEmailFieldIsEmpty() throws Exception {
//        System.setProperty("webdriver.chrome.driver","/Users/sajadakbar/Documents/develop/SeleniumJuly2019/facebook/src/main/java/driver/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().fullscreen();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String facebookUrl = "https:www.facebook.com";
        driver.get(facebookUrl);
        //Thread.sleep(3000);
        System.out.println(driver.getTitle());
       // Assert.assertEquals(driver.getTitle(),"Facebook - Log In or Sing Up");

        //driver.findElement(By.xpath("//*[@id=\'u_0_9\']")).click(); //.........Worked

        //Assert.assertEquals(driver.getTitle(),//*[@id="blueBarDOMInspector"]/div/div/div/div[1]/h1/a
         Assert.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up");



        driver.findElement(By.name("firstname")).sendKeys("Sajjad");
        driver.findElement(By.name("lastname")).sendKeys("ahmad");
        //driver.findElement(By.className("reg_passwd--")).sendKeys("adf234");

        driver.findElement(By.name("reg_passwd__")).sendKeys("T12345");
        Select monthDropDown = new Select(driver.findElement(By.id("month")));
        Select dayDropDown = new Select(driver.findElement(By.name("birthday_day")));
        Select yearDropDown = new Select(driver.findElement(By.id("year")));
        monthDropDown.selectByValue("7");
        //Thread.sleep(3000);
        dayDropDown.selectByValue("21");
       // Thread.sleep(3000);
        yearDropDown.selectByValue("1994");
        //Thread.sleep(3000);
        //driver.findElement(By.xpath("//*[@id=\'u_0_9\']")).click(); //.........Worked


        //**Did not work*** driver.findElement(By.xpath("//*[@id=\'u_0_7\']")).click();
        //driver.findElement(By.xpath("//input[@id='u_0_7']")).click(); // Worked
        driver.findElement(By.xpath("//input[@name='sex' and @value='2' ]")).click(); //

        //Thread.sleep(3000);
        driver.findElement(By.name("websubmit")).click();

        // It runs good untill now
        //driver.close();
    }

    @AfterMethod
    public void tearDown(){
        this.driver.close();
    }

}
