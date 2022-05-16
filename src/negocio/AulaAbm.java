package negocio;

import dao.AulaDao;
import datos.Aula;

public class AulaAbm {
	AulaDao aulaDao = new AulaDao();
	
	public Aula traer(int idAula) {
		return aulaDao.traer(idAula);
	}
}
