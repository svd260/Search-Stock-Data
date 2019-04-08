package com.tickers.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by sumanthdommaraju on 4/6/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true )
public class TickerResponse {

    private Datatable datatable;

    public Datatable getDatatable() {
        return datatable;
    }

    public void setDatatable(Datatable datatable) {
        this.datatable = datatable;
    }
}
