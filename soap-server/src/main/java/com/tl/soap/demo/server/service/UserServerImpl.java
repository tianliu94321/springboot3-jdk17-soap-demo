package com.tl.soap.demo.server.service;

import com.tl.soap.demo.server.dto.UserDTO;
import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author TL
 */
@Service
@WebService
public class UserServerImpl implements IUserServer {
    @Override
    public UserDTO getUser(Long id) {
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setAddress("Address");
        user.setAge(25);
        user.setName("Name");
        return user;
    }

    @Override
    public List<UserDTO> getUsers(Long qty) {

        return LongStream.range(0, qty).boxed().map(id -> {
            UserDTO user = new UserDTO();
            user.setId(id);
            user.setAddress("Address"+id);
            user.setAge(id.intValue());
            user.setName("Name"+id);
            return user;
        }).collect(Collectors.toList());
    }

}