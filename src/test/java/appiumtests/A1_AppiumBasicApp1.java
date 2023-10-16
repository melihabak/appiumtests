package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class A1_AppiumBasicApp1 {

	static AndroidDriver driver;
	
	
	// App > Activity > Animation > Back to Home Page
	public void testBasicFlow() {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Activity\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'Animation\']")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

	}
	
	
	// Content > Assets > Read Asset > Copy Given Text > Back to Home Page
	public void testXPath() {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Content\"]")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Assets\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Read Asset\"]")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
		driver.navigate().back();
		
	}
	
	public void testClassNameLocator() {
		
		System.out.println("----------Element Name----------");
		List<WebElement> list = driver.findElements(By.className("android.widget.TextView"));
		for(WebElement ele : list) {
			if ("API_Demos".equals(ele.getText())) {
			} else {
				System.out.println(ele.getText());
			}
		}	
	}
	
	public void testIdAndAccessibilityId() {
		
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.navigate().back();
		driver.findElement(AppiumBy.accessibilityId("Animation")).click();
		driver.navigate().back();
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.navigate().back();
		
	}
	
	public void testGetAttribute() {
		
		String name = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'Accessibility\']"))
				.getAttribute("name");
		System.out.println(name);
		
		String getText = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getText();
		System.out.println(getText);
		
		String contentDesc = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getAttribute("content-desc");
		System.out.println(contentDesc);
		   
		String bounds = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getAttribute("bounds");
		System.out.println(bounds);
		
	}
	
	public static void main(String[] args) throws MalformedURLException {


		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getAPIDemosAPKOptions());
		
		A1_AppiumBasicApp1 obj = new A1_AppiumBasicApp1 ();
		//obj.testBasicFlow();
		//obj.testXPath();
		//obj.testClassNameLocator();
		//obj.testIdAndAccessibilityId();
		obj.testGetAttribute();
		System.out.println("----------Run Finished----------");
	}

}
