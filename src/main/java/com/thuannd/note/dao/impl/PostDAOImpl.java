package com.thuannd.note.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.thuannd.note.dao.PostDAO;
import com.thuannd.note.entity.Post;
import com.thuannd.note.model.SearchPostDTO;

@Repository
@Transactional
public class PostDAOImpl implements PostDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addPost(Post post) {
		entityManager.persist(post);
	}

	@Override
	public void updatePost(Post post) {
		entityManager.merge(post);
	}

	@Override
	public void deletePost(Post post) {
		entityManager.remove(post);
	}

	@Override
	public List<Post> findPost(SearchPostDTO searchPostDTO) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Post> criteriaQuery = builder.createQuery(Post.class);
		Root<Post> root = criteriaQuery.from(Post.class);

		if (searchPostDTO.getKeyWord() != null) {
			criteriaQuery.where(builder.like(builder.lower(root.get("title")), "%" + searchPostDTO.getKeyWord() + "%"));
		}

		TypedQuery<Post> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		return typedQuery.getResultList();
	}

	@Override
	public Post getPostById(Long id) {
		return entityManager.find(Post.class, id);
	}

	@Override
	public Long countPost(SearchPostDTO searchPostDTO) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<Post> root = criteriaQuery.from(Post.class);

		if (searchPostDTO.getKeyWord() != null) {
			criteriaQuery.where(builder.like(builder.lower(root.get("title")), "%" + searchPostDTO.getKeyWord() + "%"));
		}

		return entityManager.createQuery(criteriaQuery.select(builder.count(root))).getSingleResult(); 
	}

}
