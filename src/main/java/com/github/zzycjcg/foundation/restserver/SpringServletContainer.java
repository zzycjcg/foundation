package com.github.zzycjcg.foundation.restserver;

import java.lang.reflect.Field;

import javax.servlet.ServletException;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.WebConfig;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * The Class SpringServletContainer.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class SpringServletContainer extends ServletContainer
{
    
    /** The Constant REST_APPLICATION. */
    protected static final String REST_APPLICATION = "javax.ws.rs.core.Application";
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2747438268677470649L;
    
    /** {@inheritDoc} */
    
    @Override
    protected void init(WebConfig webConfig)
        throws ServletException
    {
        initResourceConfig(webConfig);
        super.init(webConfig);
    }
    
    /**
     * Inits the resource config.
     *
     * @param webConfig the web config
     */
    protected void initResourceConfig(WebConfig webConfig)
    {
        try
        {
            Field field = ServletContainer.class.getDeclaredField("resourceConfig");
            field.setAccessible(true);
            field.set(this, createResourceConfig(webConfig));
        }
        catch (ReflectiveOperationException e)
        {
            throw new RuntimeException("Failed to createResourceConfig.", e);
        }
    }
    
    /**
     * Creates the resource config.
     *
     * @param webConfig the web config
     * @return the resource config
     */
    protected ResourceConfig createResourceConfig(WebConfig webConfig)
    {
        return WebApplicationContextUtils.getWebApplicationContext(webConfig.getServletContext())
            .getBean(webConfig.getServletConfig().getInitParameter(REST_APPLICATION), ResourceConfig.class);
    }
}
