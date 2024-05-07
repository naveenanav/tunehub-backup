package com.kodnest.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.UserRepository;
import com.kodnest.tunehub.service.Userservice;

@Service
public class UserServiceImpl implements Userservice
{
	@Autowired
	UserRepository userRepository;
	
    @Override
	public String addUser(User user) {
		userRepository.save(user);
		return "User added successfully";
	}
    
	@Override
	public boolean validateUser(String email, String password) {
		
		User user=userRepository.findByEmail(email);
		String dbpwd=user.getPassword();
		if(password.equals(dbpwd)) {
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		User user=userRepository.findByEmail(email);
		return user.getRole();
	}

	@Override
	public User getUser(String mail) 
	{	
		return userRepository.findByEmail(mail);
	}

	@Override
	public void updateUser(User user) 
	{
		userRepository.save(user);
	}

	@Override
	public boolean emailExists(String email) {
		if(userRepository.findByEmail(email)!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
