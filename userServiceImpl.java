package LoginSecurities.LoginSecurity.Service;

import LoginSecurities.LoginSecurity.Domain.User;
import LoginSecurities.LoginSecurity.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private userRepository userRepo;

    @Override
    public User signUp(User users) {
        // Example: Perform validation or additional logic before saving
        User user= new User(null,users.getFull_name(),users.getUsername(),passwordEncoder.encode(users.getPassword()),users.getRole());
        return userRepo.save(user);
    }


    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
