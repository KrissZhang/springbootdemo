package com.self.springbootdemo.service;

import com.self.springbootdemo.util.RpcClientResult;

import java.io.Serializable;

/**
 * 基础service接口,用于其他接口继承
 * @author zp
 * @param <E> 实体
 * @param <ID> 主键id
 */
public interface BaseService<E,ID extends Serializable> {

    /**
     * 根据主键删除
     * @param id 主键id
     * @return 删除数量
     */
    RpcClientResult deleteByPrimaryKey(ID id);

    /**
     * 保存对象
     * @param record 对象
     * @return 保存数量
     */
    RpcClientResult insert(E record);

    /**
     * 根据对象参数保存对象
     * @param record 对象
     * @return 保存数量
     */
    RpcClientResult insertSelective(E record);

    /**
     * 根据主键查询对象
     * @param id 主键id
     * @return 对象
     */
    RpcClientResult selectByPrimaryKey(ID id);

    /**
     * 根据对象参数更新
     * @param record 对象
     * @return 更新数量
     */
    RpcClientResult updateByPrimaryKeySelective(E record);

    /**
     * 根据主键id更新对象
     * @param record 对象
     * @return 更新数量
     */
    RpcClientResult updateByPrimaryKey(E record);

}
