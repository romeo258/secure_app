package tech.springcorps.secureapp.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.springcorps.secureapp.domain.User;
import tech.springcorps.secureapp.dto.UserDTO;
import tech.springcorps.secureapp.dtomapper.UserDTOMapper;
import tech.springcorps.secureapp.repository.UserRepository;
import tech.springcorps.secureapp.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository<User> userRepository;
    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }
}
