package com.tickers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by sumanthdommaraju on 4/6/19.
 */
@Controller
public class IndexContoller {

    @GetMapping("/")
    public String index() {
        return "ajax";
    }

}