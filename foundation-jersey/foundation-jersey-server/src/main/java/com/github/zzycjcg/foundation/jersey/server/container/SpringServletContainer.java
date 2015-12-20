package com.github.zzycjcg.foundation.jersey.server.container;

import java.lang.reflect.Field;

import javax.servlet.ServletException;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.WebConfig;
import org.springframework.beans.BeansException;
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
     * @throws ServletException the servlet exception
     */
    protected void initResourceConfig(WebConfig webConfig)
        throws ServletException
    {
        try
        {
            Field field = ServletContainer.class.getDeclaredField("resourceConfig");
            field.setAccessible(true);
            field.set(this, createResourceConfig(webConfig));
        }
        catch (ReflectiveOperationException e)
        {
            throw new ServletException("Failed to createResourceConfig.", e);
        }
        catch (BeansException e)
        {
            throw new ServletException("Failed to create bean.", e);
        }
    }
    
    /**
     * Creates the resource config.
     *
     * @param webConfig the web config
     * @return the resource config
     * @throws BeansException the beans exception
     */
    protected ResourceConfig createResourceConfig(WebConfig webConfig)
        throws BeansException
    {
        return WebApplicationContextUtils.getWebApplicationContext(webConfig.getServletContext())
            .getBean(webConfig.getServletConfig().getInitParameter(REST_APPLICATION), ResourceConfig.class);
    }
}
