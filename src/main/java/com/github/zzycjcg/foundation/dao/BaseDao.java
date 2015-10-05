/*
 * 文 件 名:  BaseDao.java
 * 版    权:  zhuzhiyong Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZZY
 * 修改时间:  2015年6月7日
 * 修改内容:  <修改内容>
 */
package com.github.zzycjcg.foundation.dao;

import java.util.List;

/**
 * <一句话功能简述>
 *
 * @author  ZZY
 * @version  [版本号, 2015年6月7日]
 * @param <T> the generic type
 */
public interface BaseDao<T>
{
    
    /**
     * Insert.
     *
     * @param object the object
     */
    void insert(Object object);
    
    /**
     * Update.
     *
     * @param object the object
     * @return the int
     */
    int update(Object object);
    
    /**
     * Delete.
     *
     * @param object the object
     * @return the int
     */
    int delete(Object object);
    
    /**
     * Query list.
     *
     * @param object the object
     * @return the list
     */
    List<T> queryList(Object object);
    
    /**
     * Query all.
     *
     * @return the list
     */
    List<T> queryAll();
    
    /**
     * Query single.
     *
     * @param object the object
     * @return the t
     */
    T querySingle(Object object);
    
    /**
     * Query count.
     *
     * @param object the object
     * @return the int
     */
    int queryCount(Object object);
}
