package com.coding.challenge.match;

import java.io.*;
import java.net.*;
import com.google.gson.*;

import javax.net.ssl.HttpsURLConnection;

public class Question1 {

    /**
     * Make GET call to wikipedia with given keyword and count the number of occurrence of the keyword
     * @param topic keyword
     * @return count of the keyword
     */
    static int getTopicCount(String topic) {
        String res = getResponse("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + topic);
        // Response not returned
        if(res == null) {
            return -1;
        }
        String text = getTextContent(res);
        // Response doesn't contain text JSON Object
        if(text == null) {
            return -1;
        }
        int count = 0, index= 0;
//        text = stripHTMLTag(text);
        String[] word = text.split("");
        for(String s : word) {
            if(s.length() > 0) {
                if(s.charAt(0) == topic.charAt(index)) {
                    index++;
                    if(index == topic.length()) {
                        count++; index = 0;
                    }
                } else {
                    index = 0;
                }
            }
        }
        return count;
    }

    /**
     * Parse the response as JSON String and returns the content of the text variable
     * @param s response string of GET call to wikipedia
     * @return content of the text JSON attribute
     */
    static String getTextContent(String s) {
        try {
            JsonParser parser = new JsonParser();
            JsonObject res = (JsonObject) parser.parse(s);
            return res.getAsJsonObject("parse").getAsJsonObject("text").get("*").toString();
        } catch(Exception ex) {
            return null;
        }
    }

    /**
     * Make a HTTP Get call, and return the response of the call as String. The function will return null, if any exception is thrown
     * @param u URL
     * @return response string returned after making GET call to the given URL
     */
    static String getResponse(String u) {
        try {
            URL url = new URL(u);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String input;
            int count = 0;

            while ((input = br.readLine()) != null){
                sb.append(input);
            }
            return sb.toString();
        } catch(Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getTopicCount("Pizza"));
    }
}

