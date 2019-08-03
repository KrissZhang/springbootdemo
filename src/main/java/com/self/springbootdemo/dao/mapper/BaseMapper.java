package com.self.springbootdemo.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * 基础mapper接口,用于其他接口继承
 * @author zp
 * @param <E> 实体
 * @param <P> example
 * @param <ID> 主键id
 */
public interface BaseMapper<E, P, ID extends Serializable> {

    /**
     * 根据example统计数量
     * @param example example
     * @return 统计数量
     */
    long countByExample(P example);

    /**
     * 根据example删除
     * @param example example
     * @return 删除数量
     */
    int deleteByExample(P example);

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
     * 根据example查询列表
     * @param example example
     * @return 列表结果
     */
    List<E> selectByExample(P example);

    /**
     * 根据主键查询对象
     * @param id 主键id
     * @return 对象
     */
    E selectByPrimaryKey(ID id);

    /**
     * 根据example设置属性更新对象
     * @param record 对象
     * @param example example
     * @return 更新数量
     */
    int updateByExampleSelective(@Param("record") E record, @Param("example") P example);

    /**
     * 根据example更新对象
     * @param record 对象
     * @param example example
     * @return 更新数量
     */
    int updateByExample(@Param("record") E record, @Param("example") P example);

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
