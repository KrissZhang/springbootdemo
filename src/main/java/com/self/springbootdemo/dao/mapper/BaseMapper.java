package com.self.springbootdemo.dao.mapper;

import java.io.Serializable;

/**
 * 基础mapper接口,用于其他接口继承
 * @author zp
 */
public interface BaseMapper<E,ID extends Serializable> {

    /**
     * 根据主键删除
     * @param id 主键id
     * @return 删除数量
     */
    int deleteByPrimaryKey(ID id);

    /**
     * 保存对象
     * @param record 对象
     * @return 保存数量
     */
    int insert(E record);

    /**
     * 根据对象参数保存对象
     * @param record 对象
     * @return 保存数量
     */
    int insertSelective(E record);

    /**
     * 根据主键查询对象
     * @param id 主键id
     * @return 对象
     */
    E selectByPrimaryKey(ID id);

    /**
     * 根据对象参数更新
     * @param record 对象
     * @return 更新数量
     */
    int updateByPrimaryKeySelective(E record);

    /**
     * 根据主键id更新对象
     * @param record 对象
     * @return 更新数量
     */
    int updateByPrimaryKey(E record);

}
