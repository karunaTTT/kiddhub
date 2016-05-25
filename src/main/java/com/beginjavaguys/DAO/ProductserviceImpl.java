package com.beginjavaguys.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beginjavaguys.DAO.Impl;
import com.beginjavaguys.DAO.ProductDao;
import com.beginjavaguys.model.Product;

@Service
public class ProductserviceImpl {

	@Autowired
	private Impl imp;
	
@Transactional
	public void add(Product pd) {
		// TODO Auto-generated method stub
	System.out.println("Name inside the service!!!!!!"+pd.getPname());
		imp.add(pd);
		
	}
@Transactional
	public void edit(Product pd) {
		// TODO Auto-generated method stub
	imp.edit(pd);
		
	}
@Transactional
	public void delete(int pid) {
		// TODO Auto-generated method stub
		
		imp.delete(pid);
		
	}
	
	public Product getProduct(int pid) {
		// TODO Auto-generated method stub
		return imp.getProduct(pid);
	}
	
	public List getallProduct() {
		// TODO Auto-generated method stub
		return imp.getallProduct();
	}

}
