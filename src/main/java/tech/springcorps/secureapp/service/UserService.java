package tech.springcorps.secureapp.service;

import tech.springcorps.secureapp.domain.User;
import tech.springcorps.secureapp.dto.UserDTO;

public interface UserService {
    UserDTO createUser(User user);
}
