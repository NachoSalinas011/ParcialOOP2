package dao;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Aula;
import datos.Espacio;

public class EspacioDao {
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
	
	public Espacio traer(int idEspacio) {
		Espacio obj = null;
		try
		{
			iniciaOperacion();
			obj = (Espacio) session.createQuery("from Espacio e where e.idEspacio="+idEspacio).uniqueResult();
		}
		finally
		{
			session.close();
		}
		return obj;
	}
	
	public Espacio traer(LocalDate fecha, char turno, Aula aula) throws HibernateException{
		Espacio obj = null;
		try
		{
			iniciaOperacion();
			String hql = "from Espacio e where e.fecha = '"+fecha+"' and turno='"+turno+"' and idAula="+ aula.getIdAula();
			obj = (Espacio) session.createQuery(hql).uniqueResult();
		}
		finally
		{
			session.close();
		}
		return obj;
	}
	
	public int agregar(Espacio obj) throws HibernateException{ //Método de alta base
		int id = 0;
		try
		{
			iniciaOperacion();
			id = Integer.parseInt(session.save(obj).toString());
			tx.commit();
		}
		catch(HibernateException ex)
		{
			manejaExcepcion(ex);
			throw ex;
		}
		finally
		{
			session.close();
		}
		return id;
	}
	
	public void Eliminar(Espacio obj) throws HibernateException{ //Método eliminar
		try
		{
			iniciaOperacion();
			session.delete(obj);
			tx.commit();
		}
		catch(HibernateException ex)
		{
			manejaExcepcion(ex);
			throw ex;
		}
		finally
		{
			session.close();
		}
	}
}
