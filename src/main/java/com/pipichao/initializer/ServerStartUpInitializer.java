package com.pipichao.initializer;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ServerStartUpInitializer implements ApplicationInitializer, WebApplicationInitializer {
    @Override
    public void onStartUp(ServletContext servletContext) {
//        System.out.println("************服务器初始化8888888");
//        servletContext.log("自己的容器初始化器");
        System.out.println("自己的容器初始化器");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("spring 的容器从初始化器");
    }

    /**
     * 相当于初始化了两次
     * 一个是自己的 onStartUp
     * 一个是spring 的 onStartup
     *
     * */
}
