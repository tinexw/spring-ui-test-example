package de.tine.springuitestexample;

import org.springframework.stereotype.Service;

@Service
public class RemoteService {


    public String getText() {
        return "hallo";
    }
}
