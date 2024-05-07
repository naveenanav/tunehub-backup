package com.kodnest.tunehub.service;

import com.kodnest.tunehub.entity.User;

public interface Userservice {
	public String addUser(User user);

	 public boolean emailExists(String email);

	public boolean validateUser(String email, String password);

	public String getRole(String email);

	public User getUser(String mail);

	public void updateUser(User user);
}
