package com.ebff.challenge.spaceflightnews.controller;


import com.ebff.challenge.spaceflightnews.util.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StatusController {

    @GetMapping
    public String getStatus() {
        return Constants.MESSAGE_TITLE;
    }
}