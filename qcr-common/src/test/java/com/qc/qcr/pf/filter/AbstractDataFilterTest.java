package com.qc.qcr.pf.filter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

import com.qc.qcr.pf.DataFilter;
import com.qc.qcr.pf.DataPipe;

/**
 * This class provides a way to test {@link DataFilter} implementations. <br>
 * Extend this class and test the filter by:
 * <li>Pass an instance of the filter to the constructor of this class.
 * <li>call setInputData with the data to be used as input for the filter.
 * <li>call setExpectedOutput with the expected output of the filter.
 * 
 * @author Nick Lodewijks
 *
 * @param <I>
 *            The input type of the filter
 * @param <O>
 *            The output type of the filter
 */
public abstract class AbstractDataFilterTest<I, O> {

	private final DataFilter<I, O> filter;

	private List<I> inputData;
	private List<O> expectedOutput;

	public AbstractDataFilterTest(DataFilter<I, O> filter) {
		this.filter = filter;
	}

	protected void setInputData(List<I> inputData) {
		this.inputData = inputData;
	}

	protected void setExpectedOutput(List<O> expectedOutput) {
		this.expectedOutput = expectedOutput;
	}

	@Test
	public void testProcess() {
		TestInputDataPipe inputPipe;
		TestOutputDataPipe outputPipe;

		inputPipe = new TestInputDataPipe(inputData);
		outputPipe = new TestOutputDataPipe();

		// Keep filtering until the input pipe is empty
		while (!inputPipe.isEmpty()) {
			// TODO: Make sure this loop stops at some point, currently it will
			// keep running if the filter doesn't take from the inputPipe
			filter.process(inputPipe, outputPipe);
		}

		Assert.assertEquals(outputPipe.getData(), expectedOutput);
	}

	private class TestInputDataPipe implements DataPipe<I> {
		private final Queue<I> dataQueue;

		public TestInputDataPipe(List<I> inputData) {
			dataQueue = new LinkedList<I>();
			dataQueue.addAll(inputData);
		}

		public boolean isEmpty() {
			return dataQueue.isEmpty();
		}

		@Override
		public I read() {
			return dataQueue.poll();
		}

		@Override
		public void write(I data) {
			// Not writing to the pipe
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isClosedForWriting() {
			return true;
		}

		@Override
		public void closeForWriting() {
			// Pipe is closed for writing by default
		}

	}

	private class TestOutputDataPipe implements DataPipe<O> {
		private final List<O> actualData;

		public TestOutputDataPipe() {
			this.actualData = new ArrayList<O>();
		}

		public List<O> getData() {
			return actualData;
		}

		@Override
		public O read() {
			// Not reading from the pipe
			throw new UnsupportedOperationException();
		}

		@Override
		public void write(O data) {
			actualData.add(data);
		}

		@Override
		public boolean isClosedForWriting() {
			return false;
		}

		@Override
		public void closeForWriting() {
			// Not implemented
		}

	}
}
