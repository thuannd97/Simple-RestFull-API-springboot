package com.thuannd.note.dao;

import java.util.List;

import com.thuannd.note.entity.User;
import com.thuannd.note.model.SearchUserDTO;

public interface UserDAO {
	public void addUser(User user);

	public void editUser(User user);

	public void deleteUser(User user);

	public User getUserById(Long id);
	
	public List<User> findUser(SearchUserDTO searchUserDTO);
	
	public Long countUser(SearchUserDTO searchUserDTO);
}
