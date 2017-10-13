package com.cas.authority.model;

public class ProductCategory {
    /**
     * 产品类别ID
     */
    private Integer id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 获取产品类别ID
     *
     * @return id - 产品类别ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产品类别ID
     *
     * @param id 产品类别ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品名称
     *
     * @return name - 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品名称
     *
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name;
    }
}