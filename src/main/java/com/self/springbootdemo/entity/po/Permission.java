package com.self.springbootdemo.entity.po;

/**
 * 权限po
 * @author zp
 */
public class Permission {
    /**
     * id
     */
    private Integer id;

    /**
     * 模块名称
     */
    private String modelname;

    /**
     * 权限名
     */
    private String permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}