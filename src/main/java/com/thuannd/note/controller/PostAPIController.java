package com.thuannd.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuannd.note.model.PostDTO;
import com.thuannd.note.model.ResponseDTO;
import com.thuannd.note.model.SearchPostDTO;
import com.thuannd.note.service.PostService;

@RestController
@CrossOrigin(origins="http://localhost:4200/", allowedHeaders="*")
@RequestMapping("/api")
public class PostAPIController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/add-post")
	public void addPost(@RequestBody PostDTO postDTO) {
		postService.addPost(postDTO);
	}
	
	@GetMapping("/get-post/{id}")
	public ResponseEntity<PostDTO> getPostById(@PathVariable Long id){
		PostDTO postDTO = postService.getPostById(id);
		return new ResponseEntity<PostDTO>(postDTO, HttpStatus.OK);
	}
	
	@PostMapping("/posts")
	public ResponseEntity<ResponseDTO<PostDTO>> findPost(@RequestBody SearchPostDTO searchPostDTO){
		ResponseDTO<PostDTO> responseDTO = new ResponseDTO<PostDTO>();
		responseDTO.setTotalRecords(postService.countPost(searchPostDTO));
		responseDTO.setData(postService.findPost(searchPostDTO));
		return new ResponseEntity<ResponseDTO<PostDTO>>(responseDTO, HttpStatus.OK);
	}
}
