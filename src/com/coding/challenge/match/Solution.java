package com.coding.challenge.match;

import java.io.*;
import java.util.*;
import java.text.*;
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
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("d-MMMMM-yyyy");
            Date startDate = dateFormat.parse(firstDate);
            Date endDate = dateFormat.parse(lastDate);
            List<String> stockInfo = new LinkedList<>();
            while (startDate.before(endDate)) {
                String date = dateFormat.format(startDate);
                String stock = getStockPriceForaDate(date);
                if (stock != null) {
                    System.out.println(stock);
                    stockInfo.add(stock);
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDate);
                calendar.add(Calendar.DATE, 1);
                startDate = calendar.getTime();
            }
            for (String s : stockInfo) {
                System.out.println(s);
            }
        } catch (Exception ex) {
            System.out.println("Invalid date");
        }
    }

    static String getStockPriceForaDate(String date) {
        String response = getResponse(date);
        String stockInfo = getTextContent(response);
        if(stockInfo == null)
            return null;
        return date + " " + stockInfo;

    }

    private static String getResponse(String date) {
        try {
            URL url = new URL(URL + "date=" + date);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String input;
            int count = 0;

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
            if(res.getAsJsonArray("data").size() == 0)  return null;
            JsonObject stockInfo = res.getAsJsonArray("data").get(0).getAsJsonObject();
            return stockInfo.get("open").toString() + " " + stockInfo.get("close").toString();
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        openAndClosePrices("1-January-2000", "11-January-2000");
    }
}