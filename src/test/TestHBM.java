package test;

import org.hibernate.Session;
import dao.HibernateUtil;

public class TestHBM {
	
	// PROBAR ESTE TEST UNA VEZ TERMINADOS LOS MAPEOS
	// SI ESTÁ TODO OK MOSTRARA MENSAJE
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		System.out.println("OK"); 
	}
}