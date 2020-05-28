package com.pipichao.initializer;

import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 * springboot 的内嵌web容器不支持该规范
 *
 *
 * */
@HandlesTypes(ApplicationInitializer.class)
public class PipiChaoContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            Object appInitializer = iterator.next();
////            if (appInitializer.getClass()){
////                ((ApplicationInitializer) appInitializer).onStartUp(servletContext);//不能强转成接口
//            System.out.println(appInitializer.getClass().getTypeName());
//            System.out.println("容器初始化器。。。");
////            ((ServerStartUpInitializer)appInitializer).onStartUp(servletContext);
////            }
//
//        }
        List<ApplicationInitializer> initializers = new LinkedList<>();
        if (set != null) {
            for (Class<?> waiClass : set) {
                // Be defensive: Some servlet containers provide us with invalid classes,
                // no matter what @HandlesTypes says...
                if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
                        WebApplicationInitializer.class.isAssignableFrom(waiClass)) {
                    try {
                        initializers.add((ApplicationInitializer)
                                ReflectionUtils.accessibleConstructor(waiClass).newInstance());
                    }
                    catch (Throwable ex) {
                        throw new ServletException("Failed to instantiate WebApplicationInitializer class", ex);
                    }
                }
            }
        }

        if (initializers.isEmpty()) {
            servletContext.log("No Spring WebApplicationInitializer types detected on classpath");
            return;
        }

        servletContext.log(initializers.size() + " Spring WebApplicationInitializers detected on classpath");
        AnnotationAwareOrderComparator.sort(initializers);
        for (ApplicationInitializer initializer : initializers) {
            initializer.onStartUp(servletContext);
        }
    }
}
