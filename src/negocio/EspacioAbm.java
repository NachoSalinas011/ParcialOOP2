package negocio;

import java.time.LocalDate;

import dao.EspacioDao;
import datos.Aula;
import datos.Espacio;

public class EspacioAbm {
	EspacioDao espacioDao = new EspacioDao();
	
	public Espacio traer(int idEspacio) {
		return espacioDao.traer(idEspacio);
	}
	
	public Espacio traer(LocalDate fecha, char turno, Aula aula) {
		return espacioDao.traer(fecha, turno, aula);
	}
	
	public int agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception{
		int id = 0;
		Espacio existeEspacio = traer(fecha, turno, aula);
		if(existeEspacio == null)
		{
			Espacio espacioAgregar = new Espacio(fecha, turno, aula, libre);
			id = espacioDao.agregar(espacioAgregar);
		}
		else
		{
			throw new Exception("Ya existe un Espacio para la fecha="+fecha+
					", turno="+turno+", idAula="+aula.getIdAula()+" y libre=" +libre);
		}
		return id;
	}
	
	public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) {
		int id = 0;
		LocalDate today = LocalDate.of(anio, mes, 1); //Obtengo la fecha en instancia LocalDate pasada por parámetro
		boolean esBisiesto = today.isLeapYear(); //Validar si es bisiesto
		int diasDelMes = today.getMonth().length(esBisiesto); //Obtengo la cantidad de días del mes
		

			for(int i = 1; i<= diasDelMes; i++)
			{
				try
				{
					LocalDate fechaAgregar = LocalDate.of(anio, mes, i); //Creo la instancia fecha para el espacio
					
					int idAgregado = agregar(fechaAgregar, turno, aula, true);
					System.out.println("\nAgregado espacio con id= "+idAgregado);
					
					Espacio borrar = traer(idAgregado);
					System.out.println("\nEspacio= "+borrar.toString());
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
			}
		}
	
	
	public void Eliminar(Espacio obj)
	{
		espacioDao.Eliminar(obj);
	}
}
