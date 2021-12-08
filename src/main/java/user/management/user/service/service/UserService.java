package user.management.user.service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.management.user.service.entity.User;
import user.management.user.service.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public User registerUser(User user) {
		return userRepo.save(user);
	}

	public List<User> getAllUsers(){
		return userRepo.findAll();
	}	
	
	public User getById(String id) {
		return userRepo.findById(id).get();
	}
	
	public User updateUser(User user, String id) {
		User getUser = user;
		getUser.setId(id);
		return userRepo.save(getUser);
	}
	 public void deleteUserById(String id) {
		  userRepo.deleteById(id);
		 
	 }
}
