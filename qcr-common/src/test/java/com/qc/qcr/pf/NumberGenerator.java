package com.qc.qcr.pf;

import java.util.Random;

import com.qc.qcr.pf.AbstractActiveDataSource;
import com.qc.qcr.pf.DataPipe;

public class NumberGenerator extends AbstractActiveDataSource<Integer> {

	public NumberGenerator(DataPipe<Integer> outputPipe) {
		super(outputPipe);
	}

	public void generateInto(DataPipe<Integer> outputPipe) {
		
		Integer number = 80;
		Integer seed = 5;
		Integer delta;
		
		Random randomGenerator = new Random();
		
		for (int i = 0; i < 1000; i++) {
			
			delta = randomGenerator.nextInt(seed) % 10;

			if (i % 2 == 0) {
				number -= delta;
			} else {
				number += delta;
			}
			
			System.out.println(number);
			
			outputPipe.write(number);
		}
		
		
		
	//	outputPipe.write(1);
		
	}
	
	public static void main(String[] args) {
		
		NumberGenerator ng = new NumberGenerator(null);
		ng.generateInto(null);
	}
}
