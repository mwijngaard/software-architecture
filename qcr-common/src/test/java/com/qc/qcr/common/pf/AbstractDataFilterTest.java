package com.qc.qcr.common.pf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

import junit.framework.Assert;

public abstract class AbstractDataFilterTest<I, O> {

	private DataFilter<I, O> filter;

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
		outputPipe = new TestOutputDataPipe(expectedOutput);

		// Keep filtering until the input pipe is empty
		while (!inputPipe.isEmpty()) {
			filter.process(inputPipe, outputPipe);
		}

		outputPipe.verifyContent();
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
		private final List<O> expectedData;

		public TestOutputDataPipe(List<O> expectedData) {
			this.actualData = new ArrayList<O>();
			this.expectedData = expectedData;
		}

		/**
		 * Verify whether the pipe contains the expected data
		 */
		public void verifyContent() {
			Assert.assertEquals(expectedData, actualData);
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
