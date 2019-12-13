package com.gmail.goyter012.geo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//whitelabel page handling
@RestController
@Slf4j
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {



    @RequestMapping("/error")
    public String handleError(){
        log.error("Incorrect request!");
        return "This mapping is not correct!\n" +
                "Type to the address line /geoip/{ip} to know the Location with the help of IP";
    }


    @Override
    public String getErrorPath() {
        return "/error";

    }
}
