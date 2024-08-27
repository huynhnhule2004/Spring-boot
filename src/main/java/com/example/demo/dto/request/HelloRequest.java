package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.util.List;

public class HelloRequest {

    @NotBlank
    private String action;

    @Email
    @NotNull
    private String email;

    @Size(min = 1, max = 10)
    private String[] list;

    @JsonProperty("timezone_offset_min")
    @Min(-11)
    @Max(12)
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


    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }
}
