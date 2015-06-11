package JUnitWebDriverPackage;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(Parameterized.class)
public class JUnitWebDriverTests {

	//private static String browser;
	private static WebDriver _webDriver;
	private static String browser;

	@Parameters(name = "WebDriverTests({0})")
	public static Collection data() {
	    return Arrays.asList(new Object[][]{{"firefox"},{"chrome"},{"InternetExplorer"}});
	}
	
	public JUnitWebDriverTests(String Browser)
	{
		browser=Browser;
	}
	
	@Before
	public void setUp() 
	{
		DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("browserName", browser);         
        URL server = null;
		try {
			server = new URL("http://atinbvsdesktop:4444/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         
        _webDriver = new RemoteWebDriver(server, capability);
        
        _webDriver.manage().window().maximize();
        _webDriver.get("http://bing.com");         
	}

	@After
	public void tearDown() 
	{
		_webDriver.quit(); 
	}

	@Test
	 public void TestNG_SeleniumGridBrowserTest(){   
		 
		 WebElement search = _webDriver.findElement(By.name("q"));
        WebElement go = _webDriver.findElement(By.name("go"));

        search.sendKeys("james bond");
        go.click();

       
            WebElement msWebsite =
                _webDriver.findElement(By.xpath("//a[@href='http://en.wikipedia.org/wiki/James_Bond']"));
            Assert.assertNotNull(msWebsite);
       
        /*catch () {
            // Save screenshot
            Screenshot screenshot = ((ITakesScreenshot)_webDriver).GetScreenshot();
            screenshot.SaveAsFile("NUnitResult.png", System.Drawing.Imaging.ImageFormat.Png);
        };*/
	 } 
	 
	}
