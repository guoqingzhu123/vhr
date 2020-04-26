package com.example.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class JObLevel {
    private Integer id;

    private String name;

    private String titleLevel;

    @JsonFormat(pattern = "yyyy-MM-dd hh:hh",timezone = "Asia/Beijing")
    private Date createDate;

    private Boolean enabled;

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}