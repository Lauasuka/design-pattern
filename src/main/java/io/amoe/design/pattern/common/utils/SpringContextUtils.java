package io.amoe.design.pattern.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * spring context utils
 *
 * @author amoe
 */
@Component("SpringContextUtils")
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static <T> ConcurrentHashMap<String, T> getBeansByType(Class<T> clazz) {
        Map<String, T> beans = getApplicationContext().getBeansOfType(clazz);
        return new ConcurrentHashMap<>(beans);
    }
}
