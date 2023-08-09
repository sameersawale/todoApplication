package woroMediaassignementsameersawale.woroMedia.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import woroMediaassignementsameersawale.woroMedia.Entity.User;
import woroMediaassignementsameersawale.woroMedia.Exception.UserNotFoundException;
import woroMediaassignementsameersawale.woroMedia.Repository.UserRepository;
import woroMediaassignementsameersawale.woroMedia.Security.JwtTokenProvider;
import woroMediaassignementsameersawale.woroMedia.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public User registerUser(User user) throws Exception{
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getAuthenticateUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User findUserById(int id) {
        return userRepository.findById(id).get();
    }


}
