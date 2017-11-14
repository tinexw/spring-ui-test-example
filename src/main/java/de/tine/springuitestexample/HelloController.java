package de.tine.springuitestexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private RemoteService remoteService;

    @GetMapping("/hello")
    public String foo() {
        return remoteService.getText();
    }

}
