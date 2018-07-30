package br.com.rezk.environment.service.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DAO<T, PK extends Serializable> {
	
	protected Class<T> clazz;

	@Autowired
	private SessionFactory factory;
	
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

	public T insert(T t) {
		beginTransaction();
		session.save(t);
		commit(session);
		
		return t;
	}
	
	public T find(PK pk) {
		beginTransaction();
		T result = session.get(this.clazz, pk);
		commit(session);
		
		return result;
	}
	
	private void beginTransaction() {
		// Create a session
		this.session = this.factory.getCurrentSession();
		this.session.beginTransaction();
	}
	
	private void commit(Session session) {
		// Commit and close
		this.session.getTransaction().commit();
		this.session.close();
	}
	
}
