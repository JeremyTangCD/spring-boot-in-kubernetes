package com.jeremy;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by jeremy on 2019/3/23.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String home() throws UnknownHostException {
        String hostname = InetAddress.getLocalHost().getHostName();
        return "Hello Docker World " + hostname;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class, args);
    }

}
