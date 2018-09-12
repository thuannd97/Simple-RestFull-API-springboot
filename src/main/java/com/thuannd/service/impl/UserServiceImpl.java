package com.thuannd.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuannd.note.dao.UserDAO;
import com.thuannd.note.entity.User;
import com.thuannd.note.model.SearchUserDTO;
import com.thuannd.note.model.UserDTO;
import com.thuannd.note.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void addUser(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
	
		userDAO.addUser(user);
		userDTO.setId(user.getId());
	}

	@Override
	public void deleteUser(Long id) {
		User user = userDAO.getUserById(id);
		if (user != null) {
			userDAO.deleteUser(user);
		}
	}

	@Override
	public void editUser(UserDTO userDTO) {
		User user = userDAO.getUserById(userDTO.getId());
		if (user != null) {
			user.setName(userDTO.getName());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			
			userDAO.editUser(user);
		}
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = userDAO.getUserById(id);
		if (user != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			
			return userDTO;
		}
		return null;
	}

	@Override
	public List<UserDTO> findUser(SearchUserDTO searchUserDTO) {
		List<User> users = userDAO.findUser(searchUserDTO);
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		users.forEach(user -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTOs.add(userDTO);
		});
		return userDTOs;
	}

	@Override
	public void resetPassword(UserDTO userDTO) {

	}

	@Override
	public void changePassword(UserDTO userDTO) {

	}

	@Override
	public Long countUser(SearchUserDTO searchUserDTO) {
		return userDAO.countUser(searchUserDTO);
	}

}
