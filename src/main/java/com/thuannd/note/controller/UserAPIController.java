package com.thuannd.note.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuannd.note.model.ResponseDTO;
import com.thuannd.note.model.SearchUserDTO;
import com.thuannd.note.model.UserDTO;
import com.thuannd.note.service.UserService;

@RestController
@CrossOrigin(origins = "http://locahost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class UserAPIController {

	@Autowired
	private UserService userService;

	@PostMapping("/add-user")
	public ResponseEntity<Void> addUser(@RequestBody UserDTO userDTO) {
		userService.addUser(userDTO);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/get-user/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		UserDTO userDTO = userService.getUserById(id);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<Void> deleteuser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/edit-user")
	public ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDTO) {
		userService.editUser(userDTO);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<List<UserDTO>> findUser(@RequestBody SearchUserDTO searchUserDTO) {
		return new ResponseEntity<List<UserDTO>>(userService.findUser(searchUserDTO), HttpStatus.OK);
	}
}
