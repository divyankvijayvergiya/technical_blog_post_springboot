package blogs.service;

import blogs.model.User;
import blogs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User login(User user) {
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());

        if(existingUser!=null){
            return existingUser;
        } else {
            return null;
        }
//        if (user.getUsername().equals("validuser")) {
//            return true;
//        } else {
//            return false;
//        }

    }

    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }
}
