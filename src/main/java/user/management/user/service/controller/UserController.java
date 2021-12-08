package user.management.user.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import user.management.user.service.entity.User;
import user.management.user.service.service.UserService;

@RestController
@RequestMapping("/user-service")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/saveUser")	
		public ResponseEntity<User> insertUser(@RequestBody @Valid User user){
		User saveUser = userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
		
	}
	
	@GetMapping("/getAll")
		public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
	
	@GetMapping("/getUserById/{id}")
		public ResponseEntity<User> findById(@PathVariable String id){
		User getUser = userService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(getUser);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUserById(@RequestBody User user,@PathVariable String id){
		User update = userService.updateUser(user, id);
		return ResponseEntity.status(HttpStatus.CREATED).body(update);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUserById(@PathVariable String id ){
		userService.deleteUserById(id);
		return "User deleted Sucessfully with id " + id;
	}
}
