package com.tickers.service;

import com.tickers.connector.QuandlConnector;
import com.tickers.entity.StockData;
import com.tickers.entity.StockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sumanthdommaraju on 4/6/19.
 */
@Service
public class TickerService {

    private final QuandlConnector quandlConnector;

    @Autowired
    public TickerService(QuandlConnector quandlConnector) {
        this.quandlConnector = quandlConnector;
    }

    public List<String> getTickerSymbols() {
        return quandlConnector.getAllTickers().join().getDatatable().getData()
                .stream()
                .flatMap(symbolList -> symbolList.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public StockData getStockData(String symbol, int numberOfDays) {
        StockResponse stockResponse = quandlConnector.getStockData(symbol).join();
        StockData stockData = new StockData();
        stockData.setName(stockResponse.getDataset().getName());
        stockData.setDescription(stockResponse.getDataset().getDescription());
        stockData.setLatestAvailableDate(stockResponse.getDataset().getNewest_available_date());
        List<List<String>> stockPrices = stockResponse.getDataset().getData().stream().limit(numberOfDays).collect(Collectors.toList());
        List<String> columnNames = stockResponse.getDataset().getColumn_names();
        List<Map<String, String>> pricesWithColumnNames = stockPrices.stream().map(dayValues -> {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < dayValues.size(); i++) {
                map.put(columnNames.get(i), dayValues.get(i));
            }
            return map;
        }).collect(Collectors.toList());
        stockData.setStockPrice(pricesWithColumnNames);
        return stockData;
    }
}
