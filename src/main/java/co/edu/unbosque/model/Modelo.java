package co.edu.unbosque.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Modelo {
	
	
	public Modelo() {}
	
	
	public List <Integer> calculoDivisores(int numero){
		List <Integer> list = new ArrayList <> ();
		for(int i = 1; i < numero / 2; i++) {
			for(int j = i; j <= numero; j++) {
				if(i*j == numero && j != i) {
					list.add(i);
					list.add(j);
				}else if(i*j == numero && j == i) {
					list.add(i);
				}
			}
		}
		Collections.sort(list);
		return list;
	}
	
	public int algoritmoEuclides(int primero, int segundo) {
		int residuo;
		do {
			int division = primero / segundo;                 
			residuo = primero  - (segundo * division);         
			primero = segundo;
			segundo = residuo;
		}while(residuo != 0);
		return primero;
	}
	
	public List <Integer> descomposicion(int numero){
		List <Integer> list = new ArrayList <> ();
		int index = 2;
		while(numero > 1) {
			if(numero % index == 0) {
				numero = numero / index;
				if(!list.contains(index)) list.add(index);
			}else {
				index ++;
			}
		}
		return list;
	}
	
	public int maximoComunDivisor(int primero, List <Integer> primeraLista, int segundo, List <Integer> segundaLista) {
		for(int i = primeraLista.size() -1; i >= 0; i--)
			for(int j = segundaLista.size() -1; j >= 0; j--)
				if(primeraLista.get(i) == segundaLista.get(j))
					return primeraLista.get(i);
		return -1;
	}
	
	public boolean isValidNumber(String str) {
		return str.matches("^[0-9]+$");
	}
	
	public int convertToInt(String str) {
		return Integer.parseInt(str);
	}
	
}