package com.github.zzycjcg.foundation.restserver;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * The Class SpringResourceConfig.
 */
public class SpringResourceConfig extends ResourceConfig
{
    
    /**
     * Sets the beans.
     *
     * @param beans the new beans
     */
    public void setBeans(Collection<?> beans)
    {
        if (!CollectionUtils.isEmpty(beans))
        {
            for (Object bean : beans)
            {
                register(bean);
            }
        }
    }
}
