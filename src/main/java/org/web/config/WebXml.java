package org.web.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 代码xml的java配置
 */
@Configuration
public class WebXml extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * context-param
     * @return
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationContext.class};
    }

    /**
     *
     * @return
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{DispatcherServlet.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
