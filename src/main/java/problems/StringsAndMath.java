package main.java.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringsAndMath {
	
	//////////// COUNT DUPLICATE CHARS IN STRING - BEGIN
	
	private static int countDuplicateChars1(String input) {
		Map<Character,Integer> map = new HashMap<>();
		
		char[] charA = input.toCharArray();
		for(char ch : charA) {
			map.compute(ch, (k,v) -> (v == null ) ? 1 : ++v);
		}
		
		Long resultL = map.entrySet().stream().filter(e -> e.getValue() > 1).count();
		
		return resultL.intValue();
		
	}
	
	
	private static int countDuplicateChars2(String input) {
		
		Map<Character,Long> map =  input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		
		Long resultL = map.entrySet().stream().filter(e -> e.getValue() > 1).count();
		
		return resultL.intValue();
		
	}
	
	////////////GET FIRST NON REPEATED CHAR - BEGIN
	
	private static Character firstNonRepeatedChar1(String input) {
		
		Map<Character,Integer> map = new LinkedHashMap<>();
		
		char[] charA = input.toCharArray();
		for(char ch : charA) {
			map.compute(ch, (k,v) -> (v == null ) ? 1 : ++v);
		}
		
		Character object = map.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse(null);

		return object;
	}
	
	
	private static Character firstNonRepeatedChar2(String input) {
		
		Character result =  input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse(null);

		return result;
	}
	
	////////////REVERSE STRING - BEGIN
	
	
	private static String reverseOrderInString1(String input) {
		StringBuilder sd = new StringBuilder(input);
		String result = sd.reverse().toString();
		return result;
	}
	
	private static String reverseOrderInString2(String input) {
		return Stream.of(input).map(w -> new StringBuilder(w).reverse()).collect(Collectors.joining());
	}
	
	
	////////////CHECK IF STRING AHS ONLY NUMERICS - BEGIN
	
	private static boolean checkIfStringIsOnlyDigits1(String input) {	
		
		return input.chars().anyMatch(c ->  Character.isDigit(c));		
	}
	
	
	////////////NUMBER VOWELS AND CONSONANTS - BEGIN
	
	private static boolean checkNumberConsonantsAndVowels1(String input) {	
	
		Long  nC = input.chars().filter(c -> Character.isDigit(c)).count();
		Long  nV = input.chars().filter(c -> !Character.isDigit(c) && Character.isAlphabetic(c)).count();
		
		System.out.println("VOWELS Number: " + nV + "|CONSONANTS Number: " + nC);
		
		return true;		
	}
	
	////////////NUMBER VOWELS AND CONSONANTS - BEGIN
	
	
	public static void main(String[] args) {
		
		System.out.println("----- countDuplicateChars1");
		
		System.out.println(countDuplicateChars1(""));    //0
		System.out.println(countDuplicateChars1("abc")); //0
		System.out.println(countDuplicateChars1("aabc")); //1
		System.out.println(countDuplicateChars1("abcb")); //1
		System.out.println(countDuplicateChars1("ab#cb#")); //2
		
		System.out.println("----- countDuplicateChars2");
		
		System.out.println(countDuplicateChars2(""));    //0
		System.out.println(countDuplicateChars2("abc")); //0
		System.out.println(countDuplicateChars2("aabc")); //1
		System.out.println(countDuplicateChars2("abcb")); //1
		System.out.println(countDuplicateChars2("ab#cb#")); //2
		
		////////////
		
		System.out.println("----- firstNonRepeatedChar1");
		
		System.out.println(firstNonRepeatedChar1(""));    //0
		System.out.println(firstNonRepeatedChar1("abc")); //0
		System.out.println(firstNonRepeatedChar1("aabc")); //1
		System.out.println(firstNonRepeatedChar1("abcb")); //1
		System.out.println(firstNonRepeatedChar1("ab#acb#")); //2
		
		
		System.out.println("----- firstNonRepeatedChar2");
		
		System.out.println(firstNonRepeatedChar2(""));    //0
		System.out.println(firstNonRepeatedChar2("abc")); //0
		System.out.println(firstNonRepeatedChar2("aabc")); //1
		System.out.println(firstNonRepeatedChar2("abcb")); //1
		System.out.println(firstNonRepeatedChar2("ab#acb#")); //2
		
		
		////////////
		
		System.out.println("----- reverseOrderInString");
		
		System.out.println(reverseOrderInString1(""));    //0
		System.out.println(reverseOrderInString1("abc")); //0
		System.out.println(reverseOrderInString1("aabc")); //1
		System.out.println(reverseOrderInString1("abcb")); //1
		System.out.println(reverseOrderInString1("ab#acb#")); //2
		
		
		System.out.println("----- reverseOrderInString");
		
		System.out.println(reverseOrderInString2(""));    //0
		System.out.println(reverseOrderInString2("abc")); //0
		System.out.println(reverseOrderInString2("aabc")); //1
		System.out.println(reverseOrderInString2("abcb")); //1
		System.out.println(reverseOrderInString2("ab#acb#")); //2
		
		
		////////////
		
		System.out.println("----- checkIfStringIsOnlyDigits1");
		
		System.out.println(checkIfStringIsOnlyDigits1(""));    //0
		System.out.println(checkIfStringIsOnlyDigits1("abc")); //0
		System.out.println(checkIfStringIsOnlyDigits1("11113")); //1
		System.out.println(checkIfStringIsOnlyDigits1("abcb")); //1
		System.out.println(checkIfStringIsOnlyDigits1("ab#acb#")); //2
		
		
		////////////
		
		System.out.println("----- checkNumberConsonantsAndVowels1");
		
		checkNumberConsonantsAndVowels1("");    //0
		checkNumberConsonantsAndVowels1("abc"); //0
		checkNumberConsonantsAndVowels1("11113"); //1
		checkNumberConsonantsAndVowels1("abcb"); //1
		checkNumberConsonantsAndVowels1("ab#acb#"); //2
		checkNumberConsonantsAndVowels1("ab#acb#&&12"); //2
		
	}

}
