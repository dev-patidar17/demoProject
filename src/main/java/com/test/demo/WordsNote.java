package com.test.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.platform.commons.util.CollectionUtils;

public class WordsNote {
	
	private WordsNote(){
		
	}

	public static void main(String[] args) {
        List<String> words = Arrays.asList("baby", "cat", "bat", "man", "water", "toy");
        String note = "city";
        WordsNote obj = new WordsNote();
        List<String> matchList = obj.find(words,note);
        
        matchList.stream().forEach(System.out::println);
    }
    
    public List<String> find(List<String> words,String note){
        List<String> matchList = new ArrayList();
        for(String word : words){
            int count = 0;
          
            for(char c : word.toCharArray()){
                if(note.contains(String.valueOf(c))){
                    count++;
                }
            }
            if(count>1){
               matchList.add(word);
            }
        }
        
        if(org.springframework.util.CollectionUtils.isEmpty(matchList))
            matchList.add("_");
        
		return matchList;
        
    }

}
