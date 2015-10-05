package com.github.zzycjcg.foundation.restserver;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.glassfish.jersey.server.ResourceConfig;

public class SpringResourceConfig extends ResourceConfig
{
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
