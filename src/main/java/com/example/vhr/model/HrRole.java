package com.example.vhr.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Lenovo
 */
@Data
public class HrRole implements Serializable {
    private Integer id;

    private Integer hrid;

    private Integer rid;
}
