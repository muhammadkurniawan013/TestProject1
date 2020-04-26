package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest {
	
	static AppiumDriver<MobileElement> driver;
	//AndroidDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			openCalculator();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void openCalculator() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "SM-A530F/DS");
		cap.setCapability("udid", "52007f95eac925bd");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9");
		
//		cap.setCapability("appPackage", "com.singaporegp.f1.staging");
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		System.out.println("Application Started...");
		
		MobileElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
		MobileElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
		MobileElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
		MobileElement equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
		MobileElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
		
		two.click();
		plus.click();
		three.click();
		equal.click();
		
		String res = result.getText();
		System.out.println("\n Result is :"+res);
		
		System.out.println("Completed...");
		
	}
	
	
	

}
