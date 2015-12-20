package com.github.zzycjcg.foundation.jersey.server.config;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * The Class SpringResourceConfig.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
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
