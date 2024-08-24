package com.example.demo.dto.respone;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloResponse {

    private String action;

    @JsonProperty("timezone_offset_min")
    private Integer timezoneOffsetMin;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getTimezoneOffsetMin() {
        return timezoneOffsetMin;
    }

    public void setTimezoneOffsetMin(Integer timezoneOffsetMin) {
        this.timezoneOffsetMin = timezoneOffsetMin;
    }
}
