package com.tl.soap.demo.controller;

import com.tl.soap.demo.dto.UserDTO;
import com.tl.soap.demo.util.SoapRequestUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author TL
 */
@RestController
public class DemoController {

    @RequestMapping("/getUser")
    public static UserDTO getUser(Long id){
        return SoapRequestUtil.getUser(id);
    }

    @RequestMapping("/getUsers")
    public static List<UserDTO> getUsers(Long qty){
        return SoapRequestUtil.getUsers(qty);
    }
}
