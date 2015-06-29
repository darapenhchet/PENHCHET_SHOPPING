package com.penhchet.shopping.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.penhchet.shopping.model.Product;
import com.penhchet.shopping.utils.HibernateUtil;

public class ProductDAOImp implements ProductDAO {

	@Override
	public List<Product> selectAllProducts() {
		// TODO Select All Products
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.getTransaction();
			transaction.begin();
			Query query = session.createQuery("FROM Product");
			List<Product> products = query.list();
			for(Product product : products){
				System.out.println("  ID   : " + product.getId());
				System.out.println("  NAME : " + product.getProductName());
			}
			transaction.commit();
			session.close();
			return products;
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean registerNewProduct(Product product) {
		// TODO Register New Product
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = session.getTransaction();
			transaction.begin();
			session.save(product);
			transaction.commit();
			session.close();
			return true;
		}catch(Exception ex){
			transaction.rollback();
			session.close();
			ex.printStackTrace();
		}
		return false;
	}

}
