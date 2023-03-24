/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoscodificacao;

import java.math.BigDecimal;

/**
 *
 * @author Maico-Abu
 */
public class ArithmeticCoding {
 
	double low = 0;
	double high = 0;
	double prob = 0;
	char letter;
	
	ArithmeticCoding(double low, double prob, char bukva)
	{
		this.low = low;
		this.prob = prob;
		this.letter = bukva;
	}
	private double calcHigh()
	{
		BigDecimal bd = new BigDecimal(Double.toString(prob));
		BigDecimal bd2 = new BigDecimal(Double.toString(low));
		return bd.add(bd2).doubleValue();
	}
	
	public double getLow() { return low; }
	public double getHigh() { return calcHigh();}
	public double getProb() { return prob;}
}