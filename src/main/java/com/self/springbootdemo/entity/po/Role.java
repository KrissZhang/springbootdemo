package com.self.springbootdemo.entity.po;

/**
 * 角色po
 * @author zp
 */
public class Role {
    /**
     * id
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 角色描述
     */
    private String roledesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

}