package com.github.zzycjcg.foundation.dao;

import java.util.List;

/**
 * 基础dao
 *
 * @author  ZZY
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
