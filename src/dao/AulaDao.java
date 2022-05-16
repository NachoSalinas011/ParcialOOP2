package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;

public class AulaDao {
	private Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public Aula traer(int idAula) throws HibernateException{
		Aula obj = null;
		try
		{
			iniciaOperacion();
			obj = (Aula) session.createQuery("from Aula a where a.idAula="+idAula).uniqueResult();
			Hibernate.initialize(obj.getEdificio());
		}
		finally
		{
			session.close();
		}
		return obj;
	}
}
