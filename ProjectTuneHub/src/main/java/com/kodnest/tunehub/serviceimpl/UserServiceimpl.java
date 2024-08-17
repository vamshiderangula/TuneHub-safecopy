package com.kodnest.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.UserRepository;
import com.kodnest.tunehub.service.UserService;
@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository  userRepository;
	public String addUsers(User user) {
		userRepository.save(user);
		return "succes";

	}
	//logic to check the duplicate entries
	public boolean emailExists(String email) {
		if(userRepository.findByEmail(email)!=null) {
			return true;
		}
		else {
			System.out.println("absent");
			return false;

		}
	}
	public boolean validateUser(String email, String password) {
		User user =userRepository.findByEmail(email);
		String dbpass=user.getPassword();
		if(password.equals(dbpass)) {
			return true;
		}
		else {
			return false;
		}
		
		}
	public String getRole(String email) {
		User user=userRepository.findByEmail(email);
		String r=user.getRole();
		return r;
		
	}
	public void addSong(Song song) {
		userRepository.save(song);
		
	}
	public String getPass(String email) {
		User user=userRepository.findByEmail(email);
		String r=user.getPassword();
		return r;
	}
	@Override
	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
}
