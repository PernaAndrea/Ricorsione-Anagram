package model;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
	
	//ESEMPIO RICORSIONE CON ANAGRAMMA ( slide 25 pacchetto ricorsione )
	
	public List<String> anagrammi(String parola){
		// struttura che contiene i miei dati 
		List<String> risultato = new ArrayList<String>(); // posso anche crearla fuori ..... la mia lista dei dati salvati
		permuta("",parola,0,risultato);// LANCIA LA RICORSIONE
		// potrei mettere qui un controllo che cancella dalla lista le parole non valide ( non presenti in un dizionario per esempio )
		return risultato;
	}
	
	
	//funzione riorsiva interna di anagrammi 
	
	//il livello = lunghezza della soluzione parziale 
	//livello iniziale = 0
	//parziale è la mia soluzione parziale 
	//lettere sono le lettere ancora da usare rispetto alla parola iniziale ( === al sottoproblema che dobbiamo risolvere ) 
	private void permuta(String parziale,String lettere, int livello,List<String> risultato) {
		
		//cCASO TERMINALE
		if(lettere.length()==0) {
			//la soluzione parziale è anche soluzione completa
			//System.out.println(parziale);
			//potri mettere qui il controllo della parola se è valida o no ... ad esempio cosi:
			// if(parziale è una parola valida ???){
			risultato.add(parziale);
		}else {
			//FAI LA RICORSIONE ( caso generale )
			//sottoproblema  == lettera ( un singolo carattere ) li lettere
			//il sottoproblema è dato dalla posizione !!! (pos)
			for(int pos = 0; pos<lettere.length();pos++) {
				
				Character tentativo = lettere.charAt(pos);
				
				String nuovaParziale = parziale + tentativo ; 
				String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos+1);// togli il carattere pos da lettere;
				
				//CONTROLLO DEL DIZIONARIO ( meglio farlo qui ) 
				//conviene però qui durante la ricorsione vedere se il prefisso o la parola creata è presente nel dizionario ( è valida ) 
				// controlllo con 
				//if(nuovoParziale è un PREFISSO valido di almeno una parola nel dizionario ?){
				//e posso poi decidere se bloccare la ricorsione se si verifica l IF o continuare a vedere se esistono altre parole ... cosa corretta da fare
				permuta(nuovaParziale, nuovaLettere,livello+1,risultato);
				
				//BACKTRACKING ( che va dentro il for e mi ripulisce le mie soluzioni ) 
				// rimetti a posto parziale e 
				//rimetti a posto lettere
			}
		}
	}

}
