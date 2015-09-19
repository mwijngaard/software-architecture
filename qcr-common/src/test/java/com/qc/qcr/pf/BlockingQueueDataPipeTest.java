package com.qc.qcr.pf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.qc.qcr.pf.BlockingQueueDataPipe;
import com.qc.qcr.pf.DataPipe;

public class BlockingQueueDataPipeTest {

	private final DataPipe<String> dataPipe = new BlockingQueueDataPipe<String>();

	@Test
	public void testWriteAndRead() throws InterruptedException {
		final List<String> readResult;
		final List<String> dataList;
		Thread t1;
		Thread t2;

		readResult = Collections.synchronizedList(new ArrayList<String>());
		dataList = Collections.synchronizedList(new ArrayList<String>());

		dataList.add("Data1");
		dataList.add("Data2");

		t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Writing Data");
				dataPipe.write(dataList.get(0));
				try {
					Thread.sleep(2000l);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Writing Data");
				dataPipe.write(dataList.get(1));

				dataPipe.closeForWriting();
			}
		});

		t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				String data;

				System.out.println("Reading.. ");
				data = dataPipe.read();
				System.out.println(" " + data);
				readResult.add(data);

				System.out.println("Reading.. ");
				data = dataPipe.read();
				System.out.println(" " + data);
				readResult.add(data);

				data = dataPipe.read();

				Assert.assertTrue(data == null);
				Assert.assertTrue(dataPipe.isClosedForWriting());

				System.out.println("Pipe Closed");
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		Assert.assertEquals(dataList, readResult);

	}

}
