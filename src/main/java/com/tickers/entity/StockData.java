package com.tickers.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * Created by sumanthdommaraju on 4/6/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class StockData {

    private String name;
    private String description;
    private String latestAvailableDate;
    private List<Map<String, String>> stockPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatestAvailableDate() {
        return latestAvailableDate;
    }

    public void setLatestAvailableDate(String latestAvailableDate) {
        this.latestAvailableDate = latestAvailableDate;
    }

    public List<Map<String, String>> getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(List<Map<String, String>> stockPrice) {
        this.stockPrice = stockPrice;
    }
}
