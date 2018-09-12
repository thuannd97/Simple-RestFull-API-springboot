package com.thuannd.note.dao;

import java.util.List;

import com.thuannd.note.entity.Post;
import com.thuannd.note.model.SearchPostDTO;

public interface PostDAO {
	public void addPost(Post post);

	public void updatePost(Post post);

	public void deletePost(Post post);
	
	public Post getPostById(Long id);
	
	public List<Post> findPost(SearchPostDTO searchPostDTO);

	public Long countPost(SearchPostDTO searchPostDTO);
}
