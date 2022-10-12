package org.apache.dubbo.springboot.demo.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext APPLICATION_CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.APPLICATION_CONTEXT = applicationContext;
    }

    public static <T> T getBean(String var1, Class<T> var2) {
        if (SpringUtil.APPLICATION_CONTEXT == null) {
            return null;
        }
        return SpringUtil.APPLICATION_CONTEXT.getBean(var1, var2);
    }
}
