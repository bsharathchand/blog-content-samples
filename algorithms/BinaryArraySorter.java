public class BinaryArraySorter {
	
	@Test
	public void recursionAlgo() {
		int count = 10;
		int[] data = getData(count);
		int startPos, endPos, iterationCount;
		startPos = 0; // 1
		endPos = count - 1; // 2
		
		while (endPos > 0) { // 1 * k { supposing k elements already sorted where k<n }
			if (data[endPos] == 0) { // 2*k
				break;
			}
			endPos--; // 2*k
		}
		
		sort(data, startPos, endPos); // n-k * ( [ 3 + 2 | 3 + 5 + 5 + 5] + 1 ) 
		/*
			1 + 2 + k + 2k + 2k + { n-k * ( 18 + 1) } = 1 + 2 + 5k + 19n - 19k = 19n - 14k = O(n-k)
		*/
		System.out.println("Sorted: " + Arrays.toString(data));
	}

	private void sort(int[] data, int startPos, int endPos) {
		
		if (data[startPos] == 0) { // 3
			startPos++; // 2
		} else {
			// Swapping
			data[startPos] = data[endPos] + data[startPos]; // 5
			data[endPos] = data[startPos] - data[endPos]; // 5
			data[startPos] = data[startPos] - data[endPos]; // 5
			endPos--; // 2
		}
		if (startPos >= endPos) { // 1
			System.out.println("Total Recursion Count: " + iterationCount);
			return;
		} else {
			sort(data, startPos, endPos); // 
		}

	}

	private int[] getData(int count) {
		int[] data = new int[count];
		int datum;
		for (int i = 0; i < count; i++) {
			datum = (int) (Math.random() * 1000) % 2;
			data[i] = datum;
		}
		System.out.println("Input: " + Arrays.toString(data));
		return data;
	}
}