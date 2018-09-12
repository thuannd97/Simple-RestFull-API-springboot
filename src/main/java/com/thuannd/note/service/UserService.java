package com.thuannd.note.service;

import java.util.List;

import com.thuannd.note.model.SearchUserDTO;
import com.thuannd.note.model.UserDTO;

public interface UserService {
	public void addUser(UserDTO userDTO);

	public void deleteUser(Long id);

	public void editUser(UserDTO userDTO);

	public UserDTO getUserById(Long id);

	public List<UserDTO> findUser(SearchUserDTO searchUserDTO);

	public void resetPassword(UserDTO userDTO);

	public void changePassword(UserDTO userDTO);

	public Long countUser(SearchUserDTO searchUserDTO);
}
