package com.bbd.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 臧涛
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
        }
    }

    /**
     * 获取applicationContext
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 获取应用名称
     *
     * @return
     */
    public static String getApplicationName() {
        return SpringUtils.getValue("${spring.application.name}");
    }

    /**
     * 获取应用IP地址
     *
     * @return
     */
    public static String getIPAddress() {
        return SpringUtils.getValue("${spring.cloud.client.ipAddress}");
    }

    /**
     * 获取配置属性值
     *
     * @param placeHolder
     * @return
     */
    public static String getValue(String placeHolder) {
        return SpringUtils.getApplicationContext().getEnvironment().resolvePlaceholders(placeHolder);
    }
}