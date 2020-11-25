package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {


    public static HashMap<String, Integer> urlLookForWord(ArrayList<String> words) throws IOException {

        URL hjemmeside = new URL("https://www.geeksforgeeks.org/stringbuffer-class-in-java/");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(hjemmeside.openStream()));

        HashMap<String, Integer> wordMap = new HashMap<>();

        for(String result: words){

            wordMap.put(result, 0);

        }

        String inputline = "";
        while(inputline != null){
            //System.out.println(inputline);
            for(String result: words){
                if((inputline.indexOf(result)) > -1){
                    Integer ii = wordMap.get(result);
                    ii++;
                    wordMap.put(result, ii);



                }

            }

            inputline = bufferedReader.readLine();
        }
        bufferedReader.close();
        return wordMap;

    }


    public static void main(String[] args) throws IOException {

        ArrayList<String> wordList = new ArrayList<>();

        wordList.add("java");
        wordList.add("string");
        wordList.add("class");

        HashMap<String, Integer> hm1;
        try{

            hm1 = urlLookForWord(wordList);
            for(String key: hm1.keySet()){

                System.out.println("Vi fandt " + key + " " + hm1.get(key) + " times");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
