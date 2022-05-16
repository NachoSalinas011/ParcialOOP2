package funciones;

import java.time.LocalDate;
public class Funciones {
	
	public static boolean esDiaHabil(LocalDate fecha) {
		int d = fecha.getDayOfWeek().getValue();
		return ((d>=1)&&(d<=5));
	}
	public static void imprimirVector(int[] v) {
		System.out.println("{");
		for(int e : v)
		{
			System.out.print(e+",");
		}
		System.out.println("}");
	}
	public static double convertirADouble(int n) {
		return((double)n);
	}
	public static boolean esBisiesto(int anio) {
		if((anio%4 == 0) && ((anio%100 != 0) || (anio%400 == 0)))
		{
			return true;
		}else
		{
			return false;
		}
	}
	public static boolean esFechaValida(LocalDate fecha) {
		boolean result= false;
		int dia = fecha.getDayOfMonth();
		int mes = fecha.getMonthValue();
		int anio = fecha.getYear();
		if((anio> 0) &&((mes >=1) && (mes <=12)))
		{
			if(Funciones.esBisiesto(fecha.getYear()) && dia == 29)
			{
				result = true;
			}
			if((mes == 1) || (mes == 3) || (mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12))
			{
				if(dia >= 1 && dia<=31)
				{
					result = true;
				}
			}
			if((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11))
			{
				if(dia>= 1 && dia<=30)
				{
					result = true;
				}
			}
		}
		return result;
	}
	public static String traerFechaCorta(LocalDate fecha) {
		int dia= fecha.getDayOfMonth(), mes = fecha.getMonthValue(), anio = fecha.getYear();
		String fechaCorta = dia+"/"+mes+"/"+anio;
		return fechaCorta;
	}
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		String cadenaDia = "";
		int dia = fecha.getDayOfWeek().getValue();
		switch(dia) {
			case(1):
				cadenaDia = "Lunes";
				break;
			case(2):
				cadenaDia = "Martes";
				break;
			case(3):
				cadenaDia = "Miercoles";
				break;
			case(4):
				cadenaDia = "Jueves";
				break;
			case(5):
				cadenaDia = "Viernes";
				break;
			case(6):
				cadenaDia = "Sabado";
				break;
			case(7):
				cadenaDia = "Domingo";
				break;
		}
		return cadenaDia;
	}
	public static String traerMesEnLetras(LocalDate fecha) {
		String cadenaMes = "";
		int mes = fecha.getMonthValue();
		switch(mes) {
			case(1):
				cadenaMes = "Enero";
				break;
			case(2):
				cadenaMes = "Febrero";
				break;
			case(3):
				cadenaMes = "Marzo";
				break;
			case(4):
				cadenaMes = "Abril";
				break;
			case(5):
				cadenaMes = "Mayo";
				break;
			case(6):
				cadenaMes = "Junio";
				break;
			case(7):
				cadenaMes = "Julio";
				break;
			case(8):
				cadenaMes = "Agosto";
				break;
			case(9):
				cadenaMes = "Septiembre";
				break;
			case(10):
				cadenaMes = "Octubre";
				break;
			case(11):
				cadenaMes = "Noviembre";
				break;
			case(12):
				cadenaMes = "Diciembre";
				break;
		}
		return cadenaMes;
	}
	public static String traerFechaLarga(LocalDate fecha) {
		int fechaMes = fecha.getDayOfMonth(); //fecha del mes
		String dia = traerDiaDeLaSemana(fecha); //Dia en letras
		String mes = traerMesEnLetras(fecha); //Mes en letras
		String fechaLarga = dia+" "+fechaMes+" de "+mes+" de "+fecha.getYear();
		return fechaLarga;
	}
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int cantDias = 0;
		switch(mes)
		{
			case(1): //Enero
				cantDias= 31;
			break;
			case(2): //Febrero
				if(esBisiesto(anio))
				{
					cantDias= 29;
				}else
				{
					cantDias= 28;
				}
			break;
			case(3): //marzo
				cantDias= 31;
			break;
			case(4): //Abril
				cantDias= 30;
			break;
			case(5): //Mayo
				cantDias= 31;
			break;
			case(6): //Junio
				cantDias= 30;
			break;
			case(7): //Julio
				cantDias= 31;
			break;
			case(8): //Agosto
				cantDias= 31;
			break;
			case(9): //Septiembre
				cantDias= 30;
			break;
			case(10): //Octubre
				cantDias= 31;
			break;
			case(11): //Noviembre
				cantDias= 30;
			break;
			case(12): //Diciembre
				cantDias= 31;
			break;
		}
		return cantDias;
	}
	public static double aproximar2Decimal(double valor) {
		return Math.round(valor*100d)/100d;
	}
	public static boolean esNumero(char c) {
		return Character.isDigit(c);
	}
	public static boolean esLetra(char c) {
		return Character.isAlphabetic(c);
	}
	public static boolean esCadenaNros(String cadena) {
		if(cadena.matches("[0-9]*"))
		{
			return true;
		}else
		{
			return false;
		}
	}
	public static boolean esCadenaLetras(String cadena) {
		cadena = cadena.toUpperCase();
		if(cadena.matches("[A-Z]*"))
		{
			return true;
		}else {
			return false;
		}
	}
}
