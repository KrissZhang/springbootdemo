package com.self.springbootdemo.entity.po;

/**
 * 角色权限关系po
 * @author zp
 */
public class RolePermission {
    /**
     * id
     */
    private Integer id;

    /**
     * 角色id
     */
    private Integer rid;

    /**
     * 权限id
     */
    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

}