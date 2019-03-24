package com.coding.practice.misc;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.*;
import com.google.gson.*;
import javax.net.ssl.HttpsURLConnection;

public class Solution {
    /*
     * Complete the function below.
     * Base query: https://jsonmock.hackerrank.com/api/stocks
     */

    private static final String URL = "https://jsonmock.hackerrank.com/api/stocks?";

    static void openAndClosePrices(String firstDate, String lastDate) {
        Set<String> result = new LinkedHashSet<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("d-MMMMM-yyyy");
            Date startDate = dateFormat.parse(firstDate);
            Date endDate = dateFormat.parse(lastDate);
            while(startDate.before(endDate) || startDate.equals(endDate)) {
                String res = getStockPriceForaDate(dateFormat.format(startDate));
                if(res != null) {
                    result.add(res);
                }
                Calendar c = Calendar.getInstance();
                c.setTime(startDate);
                c.add(Calendar.DATE, 1);  // number of days to add
                startDate = c.getTime();
            }
            for(String s : result) {
                System.out.println(s);
            }
        } catch (Exception ex) {
            System.out.println("Invalid Date");
        }
    }

    static String getStockPriceForaDate(String date) {
        String response = getResponse(date);
        String stockInfo = getTextContent(response);
        if(stockInfo == null)
            return null;
        else
            return date + " " + stockInfo;
    }

    private static String getResponse(String date) {
        try {
            URL url = new URL(URL + "date=" + date);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String input;

            while ((input = br.readLine()) != null) {
                sb.append(input);
            }
            return sb.toString();
        } catch (Exception ex) {
            return null;
        }
    }

    private static String getTextContent(String s) {
        try {
            JsonParser parser = new JsonParser();
            JsonObject res = (JsonObject) parser.parse(s);
            if(res.getAsJsonArray("data").size() == 0) return null;
            JsonObject data = res.getAsJsonArray("data").get(0).getAsJsonObject();
            return data.get("open").toString() + " " + data.get("close").toString();
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        openAndClosePrices("1-January-2000", "11-January-2000");
    }
}