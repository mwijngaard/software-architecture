package com.qc.qcr.common.pf;

import java.util.Arrays;

public class IntegerBetweenRangeFilterTest extends AbstractDataFilterTest<Integer, Integer> {

	public IntegerBetweenRangeFilterTest() {
		super(new IntegerBetweenRangeFilter(80, 100));

		setInputData(Arrays.asList(10, 20, 40, 50, 60, 70, 80, 90, 99, 100, 110));
		setExpectedOutput(Arrays.asList(80, 90, 99));
	}
}
