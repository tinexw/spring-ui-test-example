package de.tine.springuitestexample;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerSeleniumIntegrationTest {

    @MockBean
    private RemoteService remoteService;

    @LocalServerPort
    private int port;

    private WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/tine/Downloads/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        webDriver = new ChromeDriver(chromeOptions);

        when(remoteService.getText()).thenReturn("test");
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

    @Test
    public void test() throws Exception {
        webDriver.get("http://localhost:" + port + "/hello.html");
        assertEquals("test", webDriver.findElement(By.tagName("body")).getText());
    }

}