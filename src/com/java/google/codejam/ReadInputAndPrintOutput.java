package com.java.google.codejam;

import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadInputAndPrintOutput {
  public static void main(String[] args) {
	try	{  
		Scanner in;
		PrintWriter out = null;
		boolean outputFile = false;
		if(args.length > 0)	{
			File file = new File(args[0]);
			in = new Scanner(file);		
		}
		else	
			 in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		if(args.length == 2)	{
			 out = new PrintWriter(args[1]);
			 outputFile = true;
		}
		int t = in.nextInt();  
		for (int i = 1; i <= t; ++i) {
		  int n = in.nextInt();
		  int m = in.nextInt();
		  System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
		  if(outputFile)
			  out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
		}
		in.close();
	}
	catch (FileNotFoundException e) {
        e.printStackTrace();
    }
  }
}