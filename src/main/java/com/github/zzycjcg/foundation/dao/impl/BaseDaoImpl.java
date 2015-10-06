package com.github.zzycjcg.foundation.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.github.zzycjcg.foundation.dao.BaseDao;

/**
 * The Class BaseDaoImpl.
 *
 * @author zhiyong zhu at 2015-10-6
 * @param <T> the generic type
 * @since v0.0.1
 */
public class BaseDaoImpl<T> implements BaseDao<T>
{
    
    /** The sql session. */
    protected SqlSession sqlSession;
    
    /** The namespace. */
    protected String namespace;
    
    /**
     * Sets the namespace.
     *
     * @param namespace the new namespace
     */
    public void setNamespace(String namespace)
    {
        this.namespace = namespace;
    }
    
    /**
     * Sets the sql session.
     *
     * @param sqlSession the new sql session
     */
    public void setSqlSession(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public void insert(Object object)
    {
        sqlSession.insert(namespace + ".insert", object);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public int update(Object object)
    {
        return sqlSession.update(namespace + ".update", object);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public int delete(Object object)
    {
        return sqlSession.delete(namespace + ".delete", object);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public List<T> queryList(Object object)
    {
        return sqlSession.selectList(namespace + ".query", object);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public List<T> queryAll()
    {
        return sqlSession.selectList(namespace + ".queryAll");
    }
    
    /** {@inheritDoc} */
    
    @Override
    public T querySingle(Object object)
    {
        return sqlSession.selectOne(namespace + ".query", object);
    }
    
    /** {@inheritDoc} */
    
    @Override
    public int queryCount(Object object)
    {
        return sqlSession.selectOne(namespace + ".queryCount", object);
    }
    
}
