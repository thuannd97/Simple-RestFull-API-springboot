package com.thuannd.note.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.thuannd.note.dao.UserDAO;
import com.thuannd.note.entity.User;
import com.thuannd.note.model.SearchUserDTO;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void editUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(user);
	}

	@Override
	public User getUserById(Long id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> findUser(SearchUserDTO searchUserDTO) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);

		if (StringUtils.isNotBlank(searchUserDTO.getKeyWord())) {
			criteriaQuery.where(builder.like(builder.lower(root.get("username")), searchUserDTO.getKeyWord()));
		}

		TypedQuery<User> typedQuery = entityManager.createQuery(criteriaQuery.select(root));
		return typedQuery.getResultList();
	}

	@Override
	public Long countUser(SearchUserDTO searchUserDTO) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<User> root = criteriaQuery.from(User.class);

		if (StringUtils.isNotBlank(searchUserDTO.getKeyWord())) {
			criteriaQuery.where(builder.like(builder.lower(root.get("username")), searchUserDTO.getKeyWord()));
		}
		return entityManager.createQuery(criteriaQuery.select(builder.count(root))).getSingleResult();
	}

}
