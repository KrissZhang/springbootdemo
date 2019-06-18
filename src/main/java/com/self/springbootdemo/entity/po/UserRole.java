package com.self.springbootdemo.entity.po;

/**
 * 用户角色关系po
 * @author zp
 */
public class UserRole {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 角色id
     */
    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}