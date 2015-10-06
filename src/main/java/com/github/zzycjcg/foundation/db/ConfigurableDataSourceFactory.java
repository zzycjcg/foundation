package com.github.zzycjcg.foundation.db;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.github.zzycjcg.foundation.util.AESUtil;

/**
 * A factory for creating ConfigurableDataSource objects.
 */
public class ConfigurableDataSourceFactory implements FactoryBean<DataSource>
{
    
    /** The config loaction. */
    private String configLocation;
    
    /**
     * Sets the config loaction.
     *
     * @param configLocation the new config location
     */
    public void setConfigLocation(String configLocation)
    {
        this.configLocation = configLocation;
    }
    
    /** {@inheritDoc} */
    
    public DataSource getObject()
        throws Exception
    {
        return BasicDataSourceFactory.createDataSource(getProperties());
    }
    
    /** {@inheritDoc} */
    
    public Class<?> getObjectType()
    {
        return DataSource.class;
    }
    
    /** {@inheritDoc} */
    
    public boolean isSingleton()
    {
        return true;
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
    
    /**
     * Load properties.
     *
     * @return the properties
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected Properties loadProperties()
        throws IOException
    {
        return PropertiesLoaderUtils.loadAllProperties(configLocation);
    }
    
    /**
     * Gets the properties.
     *
     * @return the properties
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected Properties getProperties()
        throws IOException
    {
        return decryptPassword(loadProperties());
    }
}
