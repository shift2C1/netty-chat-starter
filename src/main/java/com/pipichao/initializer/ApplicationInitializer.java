package com.pipichao.initializer;

import javax.servlet.ServletContext;

public interface ApplicationInitializer {
    public void onStartUp(ServletContext servletContext);
}
