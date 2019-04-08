package com.tickers.controller;

import com.tickers.entity.SearchCriteria;
import com.tickers.entity.StockData;
import com.tickers.service.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sumanthdommaraju on 4/6/19.
 */
@RestController
public class SearchController {

    private TickerService tickerService;

    @Autowired
    public void setTickerService(TickerService tickerService) {
        this.tickerService = tickerService;
    }

    @GetMapping("/api/v1/tickers")
    public List<String> getAllTickerSymbols() {
        return tickerService.getTickerSymbols();
    }

    @PostMapping("/api/v1/ticker/data")
    public StockData getStockData(@Valid @RequestBody SearchCriteria searchCriteria) {
        String[] searchCriteriaArray = searchCriteria.getTicker().split(",");
        String symbol = searchCriteriaArray[0];
        int numberOfDays = StringUtils.isEmpty(searchCriteriaArray[1]) ? 1 : Integer.valueOf(searchCriteriaArray[1]);
        return tickerService.getStockData(symbol, numberOfDays);
    }

}
