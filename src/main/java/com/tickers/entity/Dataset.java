package com.tickers.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by sumanthdommaraju on 4/7/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Dataset {

    private String name;
    private String description;
    private List<String> column_names;
    private String newest_available_date;
    private List<List<String>> data;


    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }

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

    public List<String> getColumn_names() {
        return column_names;
    }

    public void setColumn_names(List<String> column_names) {
        this.column_names = column_names;
    }

    public String getNewest_available_date() {
        return newest_available_date;
    }

    public void setNewest_available_date(String newest_available_date) {
        this.newest_available_date = newest_available_date;
    }


}
