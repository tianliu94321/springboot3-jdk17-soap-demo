package com.tl.soap.demo.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tl.soap.demo.config.ClientLoginInterceptor;
import com.tl.soap.demo.dto.UserDTO;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.List;

/**
 * @author TL
 */
public class SoapRequestUtil {


    public static UserDTO getUser(Long id){
       return invoke("getUser", new TypeReference<>() {},id);
    }

    public static List<UserDTO> getUsers(Long qty){
        return invoke("getUsers", new TypeReference<>() {}, qty);
    }

    public static <T>T invoke(String operationName, TypeReference<T> returnRef,Object ...args){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/webservice/api?wsdl");

        client.getOutInterceptors().add(new ClientLoginInterceptor("admin","123456"));

        ObjectMapper mapper = new ObjectMapper();
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            Object[] getUsers = client.invoke(operationName, args);
            return mapper.readValue(mapper.writeValueAsString(getUsers[0]), returnRef);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getUser(1L));
        System.out.println(getUsers(2L));
    }
}
