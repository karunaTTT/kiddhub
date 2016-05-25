package com.beginjavaguys.DAO;

import java.util.List;

import com.beginjavaguys.model.Product;

public interface ProductDao {
public void add(Product pd);
public void edit(Product pd);
public void delete(int pid);
public Product getProduct(int pid);
public List getallProduct();
}
