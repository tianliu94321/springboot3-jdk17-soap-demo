package com.tl.soap.demo.server.config;

import com.tl.soap.demo.server.service.IUserServer;
import jakarta.annotation.Resource;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * webservice配置类
 * @author TL
 */
@Configuration
public class CxfConfig {
    @Resource
    private IUserServer userServer;

    /**
     * 注入Servlet 注意beanName不能为dispatcherServlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    /**
     * JAX-WS
     * 站点服务
     * @return
     */
    @Bean
    public Endpoint endpoint() {
        //http://localhost:8080/webservice/api?wsdl
        EndpointImpl endpoint = new EndpointImpl(springBus(), userServer);
        endpoint.getInInterceptors().add(new AuthInterceptor());
        endpoint.publish("/api");
        return endpoint;
    }

}