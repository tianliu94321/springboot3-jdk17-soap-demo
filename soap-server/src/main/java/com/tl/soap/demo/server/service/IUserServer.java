package com.tl.soap.demo.server.service;


import com.tl.soap.demo.server.dto.UserDTO;

import java.util.List;

public interface IUserServer {
    UserDTO getUser(Long id);

    List<UserDTO> getUsers(Long qty);
}