package com.github.zzycjcg.foundation.db;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.FactoryBean;

import com.github.zzycjcg.foundation.util.AESUtil;

/**
 * 自定义DataSource工厂.
 *
 * @author zhiyong zhu at 2015-10-18
 * @since v0.0.1
 */
public class ConfigurableDataSourceFactory implements FactoryBean<DataSource>
{
    /** The data source properties. */
    protected Properties dataSourceProperties;
    
    /**
     * Gets the data source properties.
     *
     * @return the data source properties
     */
    public Properties getDataSourceProperties()
    {
        return dataSourceProperties;
    }
    
    /**
     * Sets the data source properties.
     *
     * @param dataSourceProperties the new data source properties
     */
    public void setDataSourceProperties(Properties dataSourceProperties)
    {
        this.dataSourceProperties = dataSourceProperties;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public DataSource getObject()
        throws Exception
    {
        return BasicDataSourceFactory.createDataSource(getCustomizedProperties());
    }
    
    /** {@inheritDoc} */
    
    @Override
    public Class<?> getObjectType()
    {
        return DataSource.class;
    }
    
    /** {@inheritDoc} */
    
    @Override
    public boolean isSingleton()
    {
        return true;
    }
    
    /**
     * Gets the customized properties.
     *
     * @return the customized properties
     */
    protected Properties getCustomizedProperties()
    {
        return decryptPassword(getDataSourceProperties());
    }
    
    /**
     * Decrypt password.
     *
     * @param properties the properties
     * @return the properties
     */
    protected Properties decryptPassword(final Properties properties)
    {
        String password = properties.getProperty("password");
        properties.put("password", AESUtil.decrypt(password, AESUtil.DEFAULT_KEY));
        return properties;
    }
    
}
