package negocio;

import dao.EdificioDao;
import datos.Edificio;

public class EdificioAbm {
	EdificioDao edificioDao = new EdificioDao();
	
	public Edificio traerEdificioConAulas(int idEdificio) {
		return edificioDao.traerEdificioConAulas(idEdificio);
	}
}
