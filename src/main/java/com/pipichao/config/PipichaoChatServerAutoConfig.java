package com.pipichao.config;

import com.pipichao.annotations.EnablePipichaoChatServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PipichaoChatServerProperties.class)
@ConditionalOnClass(EnablePipichaoChatServer.class)
public class PipichaoChatServerAutoConfig {
    @Autowired
    private PipichaoChatServerProperties pipichaoChatServerProperties;

    private final int DEFAULT_PORT=6666;

    //验证参数：若空使用默认
}
