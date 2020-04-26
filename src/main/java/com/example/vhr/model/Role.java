package com.example.vhr.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Lenovo
 */
@Data
public class Role implements Serializable {
    private Integer id;

    private String name;

    private String nameZh;

    private static final long serialVersionUID = 1L;
}
