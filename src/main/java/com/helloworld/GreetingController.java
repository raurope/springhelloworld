package com.helloworld;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    

    @RequestMapping("/login")
    public Token login() {
    	return new Token(RequestContextHolder.currentRequestAttributes().getSessionId());
    }

    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/greetings")
    public ArrayList<Greeting> greetings(@RequestParam(value="name", defaultValue="World") String name) {
    	ArrayList<Greeting> greetings = new ArrayList<Greeting>();
    	greetings.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
    	greetings.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        return greetings;
    }
}