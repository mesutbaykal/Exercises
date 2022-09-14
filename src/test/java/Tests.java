import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import java.util.List;

public class Tests extends Hooks {

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("input[name=\"birthday\"]")).sendKeys("wrong_dob");
        Thread.sleep(1000);
        String message=driver.findElement(By.xpath("//*[.=\"The date of birth is not valid\"]")).getText();
        System.out.println("message = " + message);
        Assert.assertEquals(message,"The date of birth is not valid");
    }

    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        List<WebElement> progList=driver.findElements(By.cssSelector(".form-check-label"));
        for (WebElement list: progList){
            System.out.println("list.getText() = " + list.getText());
        }
    }

    @Test
    public void test3(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("a");
        String message2=driver.findElement(By.xpath("//*[.=\"first name must be more than 2 and less than 64 characters long\"]")).getText();
        System.out.println("message2 = " + message2);
        Assert.assertEquals("first name must be more than 2 and less than 64 characters long",message2);
    }

    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("mesut");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("baykal");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("maxutbykal");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("email@email.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("571-000-0000");
        driver.findElement(By.cssSelector("input[value='male']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("10/27/1988");
        Select select=new Select(driver.findElement(By.cssSelector("select[name='department']")));
        select.selectByValue("DE");
        Select select2=new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        select2.selectByVisibleText("SDET");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        String verifyMessage=driver.findElement(By.xpath("//*[.=\"You've successfully completed registration!\"]")).getText();
        System.out.println("verifyMessage = " + verifyMessage);

    }

    @Test
    public void test5(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$password']")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement>checkboxes=driver.findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));
        for (WebElement el: checkboxes){
            System.out.println("el.isSelected() = " + el.isSelected());
        }
        driver.findElement(By.xpath("//*[.='Uncheck All']")).click();
        List<WebElement>checkboxes2=driver.findElements(By.xpath("//tbody//tr//td//input[@type='checkbox']"));
        for (WebElement element: checkboxes2) System.out.println("element.isSelected() = " + element.isSelected());

    }

}
