package de.tine.springuitestexample;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerHtmlUnitMockMvcTest {

    @Autowired
    private WebDriver webDriver;

    @MockBean
    private RemoteService remoteService;

    @Test
    public void test() throws Exception {
        final String value = RandomStringUtils.randomNumeric(10);
        when(remoteService.getText()).thenReturn(value);

        webDriver.get("/hello.html");
        assertEquals(value, webDriver.findElement(By.tagName("body")).getText());
    }


}
