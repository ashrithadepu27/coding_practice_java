/***
 * https://leetcode.com/problems/license-key-formatting/description/
 */

package com.coding.challenge.google.practice;

public class LicenseKeyFormatting {

    private static String formatLicenseKey(String key, int k)    {
        StringBuilder sb = new StringBuilder();
        for(int i = key.length()-1; i >= 0; i--)    {
            if(key.charAt(i) != '-')    {
                sb.insert(0, String.valueOf(key.charAt(i)).toUpperCase());
                if(sb.length() % (k+1) == k)    {
                    sb.insert(0, "-");
                }
            }
        }
        if(sb == null || sb.length() == 0)
            return null;
        if(sb.charAt(0) == '-')
            sb.deleteCharAt(0);
        return sb.toString();
    }

    public static void main(String[] args)  {
        System.out.println(formatLicenseKey("---", 3));
    }
}
