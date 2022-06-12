package web.portal.permits.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.portal.permits.entities.User;
import web.portal.permits.errors.ResourceNotFoundProblem;
import web.portal.permits.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long Id){
        User User = userRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundProblem(Id));
        return User;
    }

    public User save(User User){
        return userRepository.save(User);
    }

    public User update(Long Id, User User){
        User _User = userRepository.getById(Id);

        _User.setName(User.getName());
        _User.setEmail(User.getEmail());
        _User.setCreatedAt(User.getCreatedAt());

        return userRepository.save(_User);
    }

    public boolean delete(Long Id){

        try{
            userRepository.deleteById(Id);

            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            logger.error("User not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        logger.info("User found: " + username);
        return user;
    }
}
