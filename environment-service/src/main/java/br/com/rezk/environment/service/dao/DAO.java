package br.com.rezk.environment.service.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DAO<T, PK extends Serializable> {
	
	protected Class<T> clazz;
	
	@Autowired
	private Session session;
	
	@SuppressWarnings("unchecked")
	public DAO() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		if(type.getActualTypeArguments()[0] instanceof java.lang.reflect.ParameterizedType) {
			this.clazz = (Class<T>) ((java.lang.reflect.ParameterizedType)type.getActualTypeArguments()[0]).getRawType();
		} else {
			this.clazz = (Class<T>) type.getActualTypeArguments()[0];
		}
	}

	public T persist(T t) {
		beginTransaction();
		session.save(t);
		commit();
		
		return t;
	}
	
	public T find(PK pk) {
		beginTransaction();
		T result = session.get(this.clazz, pk);
		commit();
		
		return result;
	}
	
	public T merge(T t) {
		beginTransaction();
		session.merge(t);
		commit();
		
		return t;
	}
	
	public void delete(T t) {
		beginTransaction();
		session.delete(t);
		commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> list() {
		beginTransaction();
		Query<T> query = session.createQuery("from " + this.clazz.getName());
		List<T> result = (List<T>) query.getResultList();
		commit();
		
		return result;
	}
	
	private void beginTransaction() {
		// Create a session
		this.session.beginTransaction();
	}
	
	private void commit() {
		// Commit and close
		this.session.getTransaction().commit();
		this.session.close();
	}
	
}
