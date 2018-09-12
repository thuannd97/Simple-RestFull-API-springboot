package com.thuannd.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuannd.note.dao.PostDAO;
import com.thuannd.note.entity.Post;
import com.thuannd.note.model.PostDTO;
import com.thuannd.note.model.SearchPostDTO;
import com.thuannd.note.service.PostService;

@Service
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO postDAO;

	@Override
	public void addPost(PostDTO postDTO) {
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setContent(postDTO.getContent());

		postDAO.addPost(post);
		postDTO.setId(post.getId());
	}

	@Override
	public void editPost(PostDTO postDTO) {
		Post post = postDAO.getPostById(postDTO.getId());
		if (post != null) {
			post.setTitle(postDTO.getTitle());
			post.setContent(postDTO.getContent());
			postDAO.updatePost(post);
		}
	}

	@Override
	public void deletePost(PostDTO postDTO) {
		Post post = postDAO.getPostById(postDTO.getId());
		if (post != null) {
			postDAO.deletePost(post);
		}
	}

	@Override
	public List<PostDTO> findPost(SearchPostDTO searchPostDTO) {
		List<Post> posts = postDAO.findPost(searchPostDTO);
		List<PostDTO> postDTOs = new ArrayList<PostDTO>();
		posts.forEach(post -> {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(post.getId());
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setCreatedDate(post.getCreatedDate().toString());
			postDTO.setCreatedBy(post.getCreatedBy().getUsername());
			
			postDTOs.add(postDTO);
		});
		return postDTOs;
	}

	@Override
	public PostDTO getPostById(Long id) {
		Post post = postDAO.getPostById(id);
		if (post != null) {
			PostDTO postDTO = new PostDTO();
			postDTO.setId(id);
			postDTO.setTitle(post.getTitle());
			postDTO.setContent(post.getContent());
			postDTO.setCreatedDate(post.getCreatedDate().toString());
			postDTO.setCreatedBy(post.getCreatedBy().getUsername());
			
			return postDTO;
		}
		return null;
	}

	@Override
	public Long countPost(SearchPostDTO searchPostDTO) {
		return postDAO.countPost(searchPostDTO);
	}

}
