package Task.Management.System.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Task.Management.System.example.Entity.User;
import Task.Management.System.example.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}