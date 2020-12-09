package lisproject;

public class LongestIncreasingSub {

	public int lis(int arr[]) {
		/*making a new array T with the same length as the original one and filled in with 1 for all elements
		a new array result filling with starting 0 to array.length-1(for the index purpose)
		*/
		int T[] = new int[arr.length];
		int result[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			T[i] = 1;
			result[i] = i;
		}
		
		//loop through the given array with i will starting checking from the index 1 
		for (int i = 1; i < arr.length; i++) {
			 //second loop j will starting from index 0
			for (int j = 0; j < i; j++) {//j must less than i , so j pointer always point to the previous elements
				//condition if the current i greater than current j go check the second condition, if not, i +=1 and keep checking the condition
				if (arr[i] > arr[j]) {
					/*if arr[i] greater than arr[j], then check array T if T[j] +1 greater than T[i]
					if yes, then T[i] new value will be T[j]+1 result[i] new value equal to j and j increase by 1
					if no, j increase by 1
					result index will swap when the both condition meet
					*/
					if (T[j] + 1 > T[i]) {
						T[i] = T[j] + 1;
						result[i] = j;
					}
				}
			}
		}
		//finding the index of max number in T array
		int maxIndex = 0;
		for (int i = 0; i < T.length; i++) {
			if (T[i] > T[maxIndex]) {
				maxIndex = i;
			}
		}
		
		//return the max value of the T array and that will be the longest increasing subsequence length
		int t = maxIndex;
		int newT = maxIndex;
		System.out.println("elements are: ");
		do {
			t = newT;
			System.out.print(arr[t] + " ");
			
			
			newT = result[t];
		} while (t != newT);
		return T[maxIndex];
	}
	
	public static void main(String[] args) {
		LongestIncreasingSub l = new LongestIncreasingSub();
		int arr[] = {10,22,9,33,21,50,41,60};
		int result = l.lis(arr);
		System.out.println();
		System.out.println("longest length is: ");
		System.out.println(result);
	}
	
	
}
