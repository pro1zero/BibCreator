import java.io.*;
import java.util.*;
public class BibCreator {
	static Scanner scan = null;
	static String filename = "";
	public static void main(String[] args) {
		
		for(int i = 1; i <= 10; i++) {
			String filename = "C:\\Users\\jenis\\eclipse-workspace\\assign2\\src\\assign2\\Files\\Latex" + i +".bib";
			try{
				createIEEE(filename, i);
				createACN(filename, i);
				createNJ(filename, i);
			}catch(Exception e) {}			
		}
	}
	
	public static void createNJ(String file, int i) {
		
		try {
			scan = new Scanner(new FileInputStream(file));
		}catch(Exception e) {
			System.out.println("Could not open input file Latex" + i + ".bib for reading.\n\n Please check if file exists! \n\nProgram will terminate after closing any opened files.");
		}
		List<List<String>> articles = new ArrayList<>();
		List<String> article = new ArrayList<>();
		while(scan.hasNextLine()){
			String s = scan.nextLine().strip();
			if(s.isEmpty()) continue; 
			article.add(s.strip());
			if(s.strip().equals("@ARTICLE{")) {
				article.remove(article.size() - 1);
				if(article.size() > 0) article.remove(article.size() - 1);
				articles.add(article);
				article = new ArrayList<>();
			}
		}
		articles.remove(0);
		articles.add(article);
		List<String> resultNJ = new ArrayList<>();
		for(List<String> arctic: articles) {
			Map<String, String> map = new HashMap<>();
			boolean[] flags = new boolean[11];
			for(String s: arctic) {
				try {
					if(s.isEmpty()) continue;
					boolean match = false;
					if(s.length() > 6 && s.substring(0, 6).equals("author")) {
						flags[0] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.replace("and", "&").strip().isEmpty()) {
							flags[0] = false;
							break;
						}
						map.put("author", key.replace("and", "&").strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("title")) {
						flags[1] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[1] = false;
							break;
						}
						map.put("title", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 7 && s.substring(0, 7).equals("journal")) {
						flags[2] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[2] = false;
							break;
						}
						map.put("journal", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 6 && s.substring(0, 6).equals("volume")) {
						flags[3] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[3] = false;
							break;
						}
						map.put("volume", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					
					if(s.length() > 5 && s.substring(0, 5).equals("pages")) {
						flags[4] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[4] = false;
							break;
						}
						map.put("pages", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("year")) {
						flags[5] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[5] = false;
							break;
						}
						map.put("year", key.strip());
						if(match) {
							match = false;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("month")) {
						match = true;
						flags[6] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[6] = false;
							break;
						}
						map.put("month", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("year")) {
						String key = "";
						flags[7] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[7] = false;
							break;
						}
						map.put("year", key.strip());
						if(match) {
							match = false;
						}
					}
					if(s.length() > 8 && s.substring(0, 8).equals("keywords")) {
						String key = "";
						flags[8] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[8] = false;
							break;
						}
					}
					if(s.length() > 3 && s.substring(0, 3).equals("doi")) {
						String key = "";
						flags[9] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[9] = false;
							break;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("ISSN")) {
						String key = "";
						flags[10] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[10] = false;
							break;
						}
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			if(!(flags[0] && flags[1] && flags[2] && flags[3] && flags[4] && flags[5] && flags[6] && flags[7] && flags[8] && flags[9] && flags[10])) {
				try {
					@SuppressWarnings("unused")
					FileInvalidException fie = new FileInvalidException("NJ", i);
				}catch(Exception e) {System.out.println(e);}
				return;
			}
			String a = map.get("author");
			
			String temp = a + ". " + (map.get("title")) + ". " + (map.get("journal")) + ". "  + (map.get("volume")) + ", "+ (map.get("pages")) + "(" + (map.get("year")) + ").";
						resultNJ.add(temp);
		}
		String location = "C:\\Users\\jenis\\Desktop\\Files\\" + "NJ" + i + ".json";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(location));
			for(String s: resultNJ) {
				pw.println(s);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		pw.close();
		scan.close();
	}
	public static void createACN(String file, int i) {
		try {
			scan = new Scanner(new FileInputStream(file));
		}catch(Exception e) {
			System.out.println("Could not open input file Latex" + i + ".bib for reading. Please check if file exists! Program will terminate after closing any opened files");
		}
		List<List<String>> articles = new ArrayList<>();
		List<String> article = new ArrayList<>();
		while(scan.hasNextLine()){
			String s = scan.nextLine().strip();
			if(s.isEmpty()) continue; 
			article.add(s.strip());
			if(s.strip().equals("@ARTICLE{")) {
				article.remove(article.size() - 1);
				if(article.size() > 0) article.remove(article.size() - 1);
				articles.add(article);
				article = new ArrayList<>();
			}
		}
		articles.remove(0);
		articles.add(article);
		List<String> resultACN = new ArrayList<>();
		for(List<String> artic: articles) {
			Map<String, String> map = new HashMap<>();
			boolean[] flags = new boolean[11];
			for(String s: artic) {
				try {
					if(s.isEmpty()) continue;
					boolean match = false;
					if(s.length() > 6 && s.substring(0, 6).equals("author")) {
						flags[0] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.replace(" and", ",").strip().isEmpty()) {
							flags[0] = false;
							break;
						}
						map.put("author", key.replace(" and", ",").strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("title")) {
						flags[1] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[1] = false;
							break;
						}
						map.put("title", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 7 && s.substring(0, 7).equals("journal")) {
						flags[2] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[2] = false;
							break;
						}
						map.put("journal", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 6 && s.substring(0, 6).equals("volume")) {
						flags[3] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[3] = false;
							break;
						}
						map.put("volume", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 6 && s.substring(0, 6).equals("number")) {
						flags[4] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[4] = false;
							break;
						}
						map.put("number", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("pages")) {
						flags[5] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[5] = false;
							break;
						}
						map.put("pages", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("month")) {
						flags[6] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[6] = false;
							break;
						}
						map.put("month", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("year")) {
						flags[7] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[7] = false;
							break;
						}
						map.put("year", key.strip());
						if(match) {
							match = false;
						}
					}
					if(s.length() > 3 && s.substring(0, 3).equals("doi")) {
						flags[8] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[8] = false;
							break;
						}
						map.put("doi", key.strip());
						if(match) {
							match = false;
						}
					}
					if(s.length() > 8 && s.substring(0, 8).equals("keywords")) {
						String key = "";
						flags[9] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[9] = false;
							break;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("ISSN")) {
						String key = "";
						flags[10] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[10] = false;
							break;
						}
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			if(!(flags[0] && flags[1] && flags[2] && flags[3] && flags[4] && flags[5] && flags[6] && flags[7] && flags[8] && flags[9] && flags[10])) {
				try {
					@SuppressWarnings("unused")
					FileInvalidException fie = new FileInvalidException("ACN", i);
				}catch(Exception e) {System.out.println(e);}
				
				return;
			}
			String a = map.get("author");
			boolean moreThanOne = false;
			String newA = "";
			if(a.contains(",")) {
				moreThanOne = true;
				int index = 0;
				while(index < a.length() && a.charAt(index) != ',') {
					newA += a.charAt(index++);
				}
			}
			if(!moreThanOne) newA = a; 
			String suffix = moreThanOne ? "et al." : "";
			String temp = "[1]\t" + newA + " " + suffix + " " + (map.get("year")) + ". " + (map.get("title")) + '.' + " " + (map.get("journal")) + ". " + (map.get("volume")) + ", " + (map.get("number")) + " (" + (map.get("year")) + "), " + (map.get("pages")) + ". DOI:https://doi.org/" + (map.get("doi")) + ".";
						resultACN.add(temp);
		}
		String location = "C:\\Users\\jenis\\Desktop\\Files\\" + "ACN" + i + ".json";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(location));
			for(String s: resultACN) {
				pw.println(s);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		pw.close();
		scan.close();
	}
	public static void createIEEE(String file, int i) throws Exception { 
		try {
			scan = new Scanner(new FileInputStream(file));
		}catch(Exception e) {
			System.out.println("Could not open input file Latex" + i + ".bib for reading. Please check if file exists! Program will terminate after closing any opened files");
		}
		List<List<String>> articles = new ArrayList<>();
		List<String> article = new ArrayList<>();
		while(scan.hasNextLine()){
			String s = scan.nextLine().strip();
			if(s.isEmpty()) continue; 
			article.add(s.strip());
			if(s.strip().equals("@ARTICLE{")) {
				article.remove(article.size() - 1);
				if(article.size() > 0) article.remove(article.size() - 1);
				articles.add(article);
				article = new ArrayList<>();
			}
		}
		articles.remove(0);
		articles.add(article);
		List<String> resultIEEE = new ArrayList<>();
		for(List<String> artic: articles) {
			Map<String, String> map = new HashMap<>();
			boolean[] flags = new boolean[11];
			for(String s: artic) {
				try {
					if(s.isEmpty()) continue;
					boolean match = false;
					if(s.length() > 6 && s.substring(0, 6).equals("author")) {	
						match = true;
						flags[0] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.replace("and", ",").strip().isEmpty()) {
							flags[0] = false;
							break;
						}
						map.put("author", key.replace("and", ",").strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("title")) {
						match = true;
						flags[1] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						
						if(key.strip().isEmpty()) {
							flags[1] = false;
							break;
						}
						map.put("title", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 7 && s.substring(0, 7).equals("journal")) {
						match = true;
						flags[2] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[2] = false;
							break;
						}
						map.put("journal", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 6 && s.substring(0, 6).equals("volume")) {
						match = true;
						flags[3] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[3] = false;
							break;
						}
						map.put("volume", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 6 && s.substring(0, 6).equals("number")) {
						match = true;
						flags[4] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[4] = false;
							break;
						}
						map.put("number", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("pages")) {
						match = true;
						flags[5] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[5] = false;
							break;
						}
						map.put("pages", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("month")) {
						match = true;
						flags[6] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[6] = false;
							break;
						}
						map.put("month", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("year")) {
						String key = "";
						flags[7] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[7] = false;
							break;
						}
						map.put("year", key.strip());
						if(match) {
							match = false;
						}
					}
					if(s.length() > 8 && s.substring(0, 8).equals("keywords")) {
						String key = "";
						flags[8] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[8] = false;
							break;
						}
					}
					if(s.length() > 3 && s.substring(0, 3).equals("doi")) {
						String key = "";
						flags[9] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[9] = false;
							break;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("ISSN")) {
						String key = "";
						flags[10] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[10] = false;
							break;
						}
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			if(!(flags[0] && flags[1] && flags[2] && flags[3] && flags[4] && flags[5] && flags[6] && flags[7] && flags[8] && flags[9] && flags[10])) {
				try {
					@SuppressWarnings("unused")
					FileInvalidException fie = new FileInvalidException("IEEE", i);
				}catch(Exception e) {System.out.println(e);}
				
				return;
			}
			String a = (map.get("author")).charAt(map.get("author").length() - 1) == ',' ? map.get("author").substring(0, map.get("author").length() - 1) + "." : map.get("author") + ".";
			String temp = a + " " + '"' + (map.get("title")) + '"' + " " + (map.get("journal")) + ", " + 
					" vol. " + (map.get("volume")) + ", no. " + (map.get("number")) + ", p. " + (map.get("pages")) + ", " + (map.get("month")) + " " + (map.get("year")) + ".";
						resultIEEE.add(temp);
		}
		String location = "C:\\Users\\jenis\\Desktop\\Files\\" + "IEEE" + i + ".json";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(location));
			for(String s: resultIEEE) {
				pw.println(s);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		pw.close();
		scan.close();
	}	
}

class FileInvalidException{
	public FileInvalidException() throws Exception {
		throw new Exception("Invalid file.");
	}
	
	public FileInvalidException(String field, int i) throws Exception{
		throw new Exception("Invalid syntax for the " + field + " type and the filename: " + "Latex" + i + ".bib");
	}
}