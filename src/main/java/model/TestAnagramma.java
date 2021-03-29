package model;

import java.util.List;

public class TestAnagramma {

	public static void main(String args[]) {
		
		Anagram a = new Anagram();
		
		List<String> anagrammi ;
		
		anagrammi = a.anagrammi("due");
		System.out.println(anagrammi+"\n");
		anagrammi = a.anagrammi("dog");
		System.out.println(anagrammi+"\n");
		anagrammi = a.anagrammi("casa");
		System.out.println(anagrammi+"\n");
		
	}
}
