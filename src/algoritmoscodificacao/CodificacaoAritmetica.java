/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoscodificacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Maico-Abu
 */
public class CodificacaoAritmetica {
	static double high = 1;
	static double low = 0.0;
	static double high_new = 0;
	static double low_new = 0;
	static double[][] letter_prob;
	static ArrayList<ArithmeticCoding> seq = new ArrayList<>(); 
    
    /**
     * @param args the command line arguments
     */
     

	private static void encoding(double high_bukva, double low_bukva)   
	{
		double range = calcSub(high,low);
		high = calcSum(low,calcMult(range,high_bukva));
		low = calcSum(low,calcMult(range,low_bukva));
	}
	private static double calcSum(double a1, double a2)
	{
		BigDecimal bd = new BigDecimal(Double.toString(a1));
		BigDecimal bd2 = new BigDecimal(Double.toString(a2));
		return bd.add(bd2).doubleValue();
	}
	private static double calcSub(double a1, double a2)
	{
		BigDecimal bd = new BigDecimal(Double.toString(a1));
		BigDecimal bd2 = new BigDecimal(Double.toString(a2));
		return bd.subtract(bd2).doubleValue();
	}
	private static double calcMult(double a1, double a2)
	{
		BigDecimal bd = new BigDecimal(Double.toString(a1));
		BigDecimal bd2 = new BigDecimal(Double.toString(a2));
		return bd.multiply(bd2).doubleValue();
	}
	public static void bubble_srt(int length) 
	{
        int k;
        for (int m = length; m >= 0; m--) 
        {
            for (int i = 0; i < length - 1; i++) 
            {
                k = i + 1;
                if (letter_prob[1][i] < letter_prob[1][k]) 
                {
                	double temp,temp2;
                    temp = letter_prob[0][i];
                    temp2 = letter_prob[1][i];
                    letter_prob[0][i] = letter_prob[0][k];
                    letter_prob[1][i] = letter_prob[1][k];
                    letter_prob[0][k] = temp;
                    letter_prob[1][k] = temp2;
                }
            }
        }
	
    }
        
          
 public static void main(String[] args) {

    String input ="ABABABC";
    char[] letter = input.toCharArray(); 
    Double[] probability = new Double[letter.length]; 
	for(int k=0; k<letter.length; k++) 
                probability[0] =0.4; 
                probability[1]=0.4;
                 probability[2]=0.4;
                 probability[3]=0.4;
                 probability[4]=0.4;
                 probability[5]=0.4;
                probability[6]=0.1;

letter_prob = new double[letter.length][letter.length]; 
		
	for(int i=0; i<letter.length; i++){
			letter_prob[0][i] = letter[i];
			letter_prob[1][i] = probability[i];}
		bubble_srt(letter.length);
		for(int i=0; i<letter.length; i++){
			seq.add(new ArithmeticCoding(low,letter_prob[1][i],(char)letter_prob[0][i]));
			low = seq.get(i).getHigh();
		}
		
		high = 1;
		low  = 0;
		for(int i=0; i<letter.length; i++){
			int j=0;
			while(j<letter.length)
			{
				if(letter[i] == (char)letter_prob[0][j])
				{
					encoding(seq.get(j).getHigh(),seq.get(j).getLow());
					break;
				}
				else j++;
			}

		}
		System.out.println(low + " " + high);

	}
}