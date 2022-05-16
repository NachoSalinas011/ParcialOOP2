package test;

import java.time.LocalDate;
import java.util.Set;

import datos.Aula;
import datos.Edificio;
import datos.Espacio;
import negocio.AulaAbm;
import negocio.EdificioAbm;
import negocio.EspacioAbm;

public class TestCU {

	public static void main(String[] args) throws Exception{
		//ABM's
		AulaAbm aulaAbm = new AulaAbm();
		EdificioAbm edificioAbm = new EdificioAbm();
		EspacioAbm espacioAbm = new EspacioAbm();
		
		System.out.println("\nPunto 1)\n");
		int idEdificio = 2;
		Edificio edificio = edificioAbm.traerEdificioConAulas(idEdificio);
		System.out.println("\nEdificio= "+edificio.toString());
		Set<Aula> aulasEnEdificio = edificio.getAulas();
		System.out.println("Aulas del edificio= \n");
		for(Aula a: aulasEnEdificio)
		{
			System.out.println(a.toString());
		}
		
		
		System.out.println("\nPunto 2)\n");
		int idAula = 6;
		Aula aula = aulaAbm.traer(idAula);
		System.out.println("\nAula= "+aula.toString());
		System.out.println("Edificio del aula= "+aula.getEdificio());
		
		
		
		System.out.println("\nPunto 3)\n");
		LocalDate fechaDeEspacio = LocalDate.of(2022, 5, 1);
		char turno = 'M';
		Aula aulaDeEspacio = aulaAbm.traer(6);

		Espacio espacio = espacioAbm.traer(fechaDeEspacio, turno, aulaDeEspacio);
		System.out.println("\nAula= "+aulaDeEspacio.toString());
		System.out.println("Espacio= "+espacio.toString());
		
		
		
		
		System.out.println("\nPunto 4)");
		//Ejemplo de agregación errado
		try
		{
			LocalDate fechaDeEspacioAgregar = LocalDate.of(2022, 5, 1);
			char turnoDeEspacioAgregar = 'M';
			Aula aulaDeEspacioAgregar = aulaAbm.traer(6);
			boolean libreAgregar = true;
			
			int espacioAgregado = espacioAbm.agregar(fechaDeEspacioAgregar, turnoDeEspacioAgregar, aulaDeEspacioAgregar, true);
			//Esto debería tirar excepción ya que existe el registro			
		}
		catch(Exception ex)
		{
			System.out.println("\nExcepción controlada:\n"+ex.toString());
		}
		
		//Ejemplo de agregación exitoso
		try
		{	
			LocalDate fechaDeEspacioAgregar = LocalDate.of(2022, 5, 1);
			char turnoDeEspacioAgregar = 'N';
			Aula aulaDeEspacioAgregar = aulaAbm.traer(6);
			boolean libreAgregar = false;
			
			int espacioAgregado = espacioAbm.agregar(fechaDeEspacioAgregar, turnoDeEspacioAgregar, aulaDeEspacioAgregar, libreAgregar);
						
			Espacio borrar = espacioAbm.traer(espacioAgregado);
			System.out.println("\nEspacio agregado= "+borrar.toString());
			espacioAbm.Eliminar(borrar);
		}
		catch(Exception ex)
		{
			System.out.println("\nExcepcion controlada: \n"+ex.toString());
		}
		
		System.out.println("\nPunto 5)\n");
		try
		{
			int anioAgregarMes = 2022;
			int mesAgregarMes = 5;
			char turnoAgregarMes = 'M';
			Aula aulaAgregarMes = aulaAbm.traer(7);
			boolean libreAgregarMes = true;
			
			espacioAbm.agregarEspacioMes(mesAgregarMes, anioAgregarMes, turnoAgregarMes, aulaAgregarMes);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	
	
}
