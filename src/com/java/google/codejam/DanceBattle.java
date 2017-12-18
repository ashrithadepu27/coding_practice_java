package com.java.google.codejam;

import java.util.ArrayList;
import java.util.Scanner;

public class DanceBattle {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int noOfTestCases = in.nextInt();
        
        ArrayList<ArrayList<Integer>> listArray = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> energy = new ArrayList<Integer>();
        for(int t = 1 ; t <= noOfTestCases; t++)	{
        	energy.add(in.nextInt());
        	int noOfElement = in.nextInt();
	        ArrayList<Integer> array = new ArrayList<Integer>();
	        for(int i=0; i < noOfElement; i++){
	            array.add(in.nextInt());
	        }
	        listArray.add(array);
        }
        in.close();
        
        for(int t = 0; t < listArray.size(); t++)	{        	
        	int honor = danceBattle(energy.get(t), 0, sortedMinSkill(listArray.get(t)));
	        System.out.println("Case #" + Integer.valueOf(t+1) + ": " + honor);       	
        }
	}

	public static int danceBattle(int energy, int honor, ArrayList<Integer> rivalTeamDanceSkill)	{
		/*System.out.println("energy: "  + energy);
		System.out.println("min: " + rivalTeamDanceSkill.get(0));*/
		if(energy > rivalTeamDanceSkill.get(0))	{
			for(int i =0; i < rivalTeamDanceSkill.size(); i++)	{
				if(energy > rivalTeamDanceSkill.get(i))	{
					energy = energy - rivalTeamDanceSkill.get(i);
					honor++;
					rivalTeamDanceSkill.remove(i);
				}
			}
		}
		else if(honor > 0)	{
			energy += rivalTeamDanceSkill.get(rivalTeamDanceSkill.size()-1);
			honor--;
			rivalTeamDanceSkill.remove(rivalTeamDanceSkill.size()-1);
			danceBattle(energy,honor, rivalTeamDanceSkill);
		}
		return honor;
	}
	
	public static ArrayList<Integer> sortedMinSkill(ArrayList<Integer> arr){
		int key, j;
		for(int i = 1; i< arr.size(); i++)	{
			
			key = arr.get(i);
			j = i - 1;
			while(j>=0 && arr.get(j) > key)	{
				arr.set(j+1, arr.get(j));
				j--;
			}
			arr.set(j+1, key);
		}
		return arr;
	}
}
