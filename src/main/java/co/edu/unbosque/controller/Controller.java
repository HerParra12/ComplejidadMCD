package co.edu.unbosque.controller;

import co.edu.unbosque.model.Modelo;
import co.edu.unbosque.view.Ventana;

public class Controller {

	private Modelo model;
	private Ventana view;
	
	public Controller() {
		model = new Modelo();
		view = new Ventana();
		funcionar();
	}
	
	private void funcionar() {
		try {
			int menu = 0;
			do {
				menu = view.leerDato("COMPLEJIDAD MAXIMO COMUN DIVISOR." + 
			           "\n Selecciona la opcion a realizar." +
					   "\n 1. Calculo por divisores." +
			           "\n 2. Descomposición de factores primos." +
					   "\n 3. Algoritmo de Euclides." + 
			           "\n 0. Salir");
				
				switch(menu) {
					case 1:
						addNumbers(1);
						break;
							
					case 2:
						addNumbers(2);
						break;
						
					case 3:
						addNumbers(3);
						break;
						
					case 0:
						view.mostrarInformacion("Hasta luego.");
						break;
						default:
							view.warningMessage("La opcion seleccionada no es valida.");
							break;
				}
			}while(menu != 0);
		} catch(NumberFormatException formt) {
			view.warningMessage("Debes tener mas cuidado.");
			funcionar();
		}
	}
	
	private void addNumbers(int option) {
		String primero, segundo;
		int first, second;
		do {
			primero = view.leerString("Ingresa el primero numero.");
			if(!model.isValidNumber(primero))
				view.warningMessage("El numero ingresado no es valido.");
		}while(!model.isValidNumber(primero));
		first = model.convertToInt(primero);
		do {
			segundo = view.leerString("Ingresa el segundo numero.");
			if(!model.isValidNumber(segundo))
				view.warningMessage("El numero ingresado no es valido.");
		}while(!model.isValidNumber(segundo));
		second = model.convertToInt(segundo);
		switch(option) {
		case 1:
			view.mostrarInformacion("El maximo comun divisor de los numeros " + primero + " y segundo " + segundo + " es: " + 
		                            model.maximoComunDivisor(first, model.calculoDivisores(first), second, model.calculoDivisores(second)));
			break;
		case 2:
			view.mostrarInformacion("El maximo comun divisor de los numeros " + primero + " y segundo " + segundo + " es: " + 
		                            model.algoritmoEuclides(first, second));
			break;	
		case 3:
			view.mostrarInformacion("El maximo comun divisor de los numeros " + primero + " y segundo " + segundo + " es: " + 
		                            model.maximoComunDivisor(first, model.descomposicion(first), second, model.descomposicion(second)));
			break;
		}
	}
}