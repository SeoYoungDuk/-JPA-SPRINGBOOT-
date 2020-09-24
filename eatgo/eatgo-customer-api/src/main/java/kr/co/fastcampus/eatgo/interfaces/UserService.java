package kr.co.fastcampus.eatgo.interfaces;


import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String email, String name, String password) {
        //TODO : 제대로 된 구현 필요함.
        User user = User.builder()
                .id(1004L)
                .email(email)
                .name(name)
                .password(password)
                .build();
        return userRepository.save(user);
    }
}
