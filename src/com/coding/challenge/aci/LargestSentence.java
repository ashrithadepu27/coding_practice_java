package com.coding.challenge.aci;

public class LargestSentence {

    public static int solution(String s) {
        String[] sentences = s.split("[.?!]");
        String[] words;
        int maxWords = -1, currentWords = -1;
        for(String sen : sentences) {
            words = sen.split(" ");
//            System.out.println(sen);
            currentWords = words.length;
            for(String w : words) {
                if(w.trim().length() == 0)
                    currentWords--;
            }
//            System.out.println(currentWords);
            maxWords = maxWords < currentWords ? currentWords : maxWords;
        }
        return maxWords;
    }

    public static void main(String[] args) {
//        String sentence = "We test coders. Give us a try?";
        String sentence = "Anne-Marie Rose Nicholson (born 7 April 1991) is an English singer-songwriter. She has attained several charting singles on the UK Singles Chart, including Clean Bandit's \"Rockabye\", featuring Sean Paul, which peaked at number one, as well as \"Alarm\", \"Ciao Adios\", \"Friends\" and \"2002\".[2] Her debut studio album Speak Your Mind was released on 27 April 2018, and peaked at number three on the UK Albums Chart.[3] She has been nominated for four awards at the 2019 Brit Awards, including Best British Female Solo Artist.";
        System.out.println(solution(sentence));


    }
}
