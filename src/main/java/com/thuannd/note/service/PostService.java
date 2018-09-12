package com.thuannd.note.service;

import java.util.List;

import com.thuannd.note.model.PostDTO;
import com.thuannd.note.model.SearchPostDTO;

public interface PostService {

	public void addPost(PostDTO postDTO);

	public void editPost(PostDTO postDTO);

	public void deletePost(PostDTO postDTO);

	public List<PostDTO> findPost(SearchPostDTO searchPostDTO);

	public PostDTO getPostById(Long id);
	
	public Long countPost(SearchPostDTO searchPostDTO);
}
