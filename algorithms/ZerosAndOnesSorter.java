package loops;

public class ZerosAndOnesSorter {

	public void sortZerosAndOnes(int[] elements){

		int firstOneIndex =-1; // 1

		for(int index =0; index < elements.length; index ++){ // 1 + 2*(n) + n-1

			int data = elements[index]; //2*n

			if(data ==1) //1*n
				firstOneIndex = firstOneIndex == -1 ? index : firstOneIndex ; // 2*n
			else{
				if(firstOneIndex == -1) // 1*n
					continue;
				else{
					swap(firstOneIndex,index,elements); // (7)*n 
					firstOneIndex ++; // 1*n
				}
			}
			/*
				1 + 1 + 2n + n-1 + 2n + 1n + [2n | n + 7n + n] = 15n + 1 = O(15n) = O(n)
			*/
			System.out.println("End of index :"+index+" --firstOndexValue is :"+firstOneIndex+" and data is :");
			printArray(elements);
		}
	}

	private void swap(int firstOneIndex, int index,int[] elements) {
		int temp = elements[firstOneIndex]; // 2
		elements[firstOneIndex] = elements[index]; // 3
		elements[index] = temp; // 2
	}

	public static void main(String[] args) {

		ZerosAndOnesSorter sorter = new ZerosAndOnesSorter();
		int[] data ={0,0,0,1,1,0,1,0,1,0,1,1};
		sorter.sortZerosAndOnes(data);
	}

	private static void printArray(int[] data){
		for(int dataElement :data)
			System.out.print(dataElement+"\t");
		System.out.println();
	}

}
