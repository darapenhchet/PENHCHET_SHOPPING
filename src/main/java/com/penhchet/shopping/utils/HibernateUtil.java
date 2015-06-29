package com.penhchet.shopping.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.penhchet.shopping.model.Product;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildFactory();
	
	private static SessionFactory buildFactory(){
		try{
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Product.class);
			return configuration.buildSessionFactory(new ServiceRegistryBuilder()
							.applySettings(configuration.getProperties())
							.buildServiceRegistry());	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		return null;
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
