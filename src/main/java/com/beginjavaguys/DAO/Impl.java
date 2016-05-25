package com.beginjavaguys.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beginjavaguys.model.Product;


@Repository
public class Impl implements ProductDao {

	@Autowired
	private SessionFactory sess;
	//Product p;
	

	public void add(Product pd) {
	
		System.out.println("data added66");
		//sess.openSession().save(pd);
		sess.getCurrentSession().persist(pd);
		System.out.println("data added55");
		System.out.println("name!!!!!!!!"+pd.getPname());
	}

	public void edit(Product pd) {
		
		sess.getCurrentSession().update(pd);
		
	}

	public void delete(int pid) {
	
		sess.getCurrentSession().delete(getProduct(pid));
	}

	public Product getProduct(int pid) {

		return (Product)sess.openSession().get(Product.class, pid);
	}

	public List getallProduct() {
	
		//return sess.getCurrentSession().createQuery("from product").list();
		return sess.openSession().createQuery("from Product").list();
	}

}
