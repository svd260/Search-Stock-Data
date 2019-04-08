package com.tickers.connector;

import com.tickers.entity.StockResponse;
import com.tickers.entity.TickerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

/**
 * Created by sumanthdommaraju on 4/6/19.
 */
@Repository
public class QuandlConnector {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    @Cacheable("tickers")
    public CompletableFuture<TickerResponse> getAllTickers() {
        URI uri = UriComponentsBuilder
                .fromUriString(environment.getProperty("quandl.api.all.ticker.symbols.url"))
                .queryParam("api_key", environment.getProperty("quandl.api.key"))
                .queryParam("qopts.columns", "ticker")
                .build()
                .toUri();
        return CompletableFuture.supplyAsync(() -> restTemplate.getForObject(uri, TickerResponse.class));
    }

    @Cacheable("stockData")
    public CompletableFuture<StockResponse> getStockData(String symbol) {
        URI uri = UriComponentsBuilder
                .fromUriString(MessageFormat.format(environment.getProperty("quandl.api.stock.data.url"), symbol))
                .queryParam("api_key", environment.getProperty("quandl.api.key"))
                .build()
                .toUri();
        return CompletableFuture.supplyAsync(() -> restTemplate.getForObject(uri, StockResponse.class));
    }

}
