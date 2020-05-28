package com.pipichao.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@ConfigurationProperties(prefix = "com.pipichao.chat")
public class PipichaoChatServerProperties {

    //端口，
    private int port;
    //线程数等配置字段
    private String other;


    //setter getter 必须有，不然 yaml文件的字段设置不会成功
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public PipichaoChatServerProperties() {
//        initServerParam();
    }

//    @Bean
//    public void initServerParam(){
//        if (port==0){
//            this.port=DEFAULT_PORT;
//        }
//        if (other==null || other.equals("")){
//            throw new RuntimeException("other 字段必须设置");
//        }
//    }

}
