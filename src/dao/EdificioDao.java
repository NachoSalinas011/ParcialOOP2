package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Edificio;

public class EdificioDao {
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
	
	public Edificio traerEdificioConAulas(int idEdificio) throws HibernateException{
		Edificio obj = null;
		try
		{
			iniciaOperacion();
			String hql = "from Edificio e where e.idEdificio="+idEdificio;
			obj = (Edificio) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(obj.getAulas());
		}
		finally
		{
			session.close();
		}
		return obj;
	}
}
