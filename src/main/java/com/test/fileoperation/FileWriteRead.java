package com.test.fileoperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileWriteRead {

	public static void main(String[] args) {
		
		String txt="This is a file write and read program \n Please make sure all words are correctt spell";
		String str ="C://Operation/samplefile.txt";
		Path fileName = Path.of(str);
		

		String txt2="This is a file write and read program \n Please make sure all words are correctt spell. \n Good contant";
		String str2 ="C://Operation/samplefile2.txt";
		
		Path fileName2 = Path.of(str2);
		try {
			Files.writeString(fileName, txt);
			
			String readString = Files.readString(fileName);
			System.out.println(readString);
			
			Files.writeString(fileName2, txt2);
			String readString2 = Files.readString(fileName2);
			
			System.out.println(readString2); 
			
			String[] firstFile = readString.split(" ");
			
			Set<String> fileFirstSet = new HashSet<>();
			Set<String> fileSecondSet = new HashSet<>();
			
			BufferedReader br1 = new BufferedReader(new FileReader(str));
			String word;
			while((word = br1.readLine()) !=null) {
				fileFirstSet.add(word);
			}
			
			br1.close();
			BufferedReader br2 = new BufferedReader(new FileReader(str2));
			
			while((word = br2.readLine()) != null) {
				fileSecondSet.add(word);
			}
			br2.close();
			
			Set<String> commanContentSet = new HashSet<>(fileFirstSet);
			
			commanContentSet.retainAll(fileSecondSet);
			
			commanContentSet.stream().forEach(System.out::print);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
