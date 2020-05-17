package com.example.vhr.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Train implements Serializable {
    /**
     * moveID
     */
    private Integer id;

    /**
     * 员工编号
     */
    private Integer workId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 部门编号
     */
    private Integer sectorId;

    /**
     * 部门名称
     */
    private Integer sectorName;

    private Sector sector;
    /**
     * 培训名称
     */
    private String trainName;

    /**
     * 培训天数
     */
    private Integer trainTime;

    /**
     * 培训成绩
     */
    private Object trainResult;

    /**
     * 培训费用
     */
    private Integer trainPrize;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}