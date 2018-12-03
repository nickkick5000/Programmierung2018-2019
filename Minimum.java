import java.util.Arrays;
public class Minimum{
	public static int arrayMin(int[] inputArray){
		int min = Integer.MAX_VALUE;
		
		if(inputArray.length == 1) {
			return inputArray[0];
		}
		
		min = arrayMin(Arrays.copyOfRange(inputArray, 1, inputArray.length));
		
		return inputArray[0] < min ? inputArray[0] : min;
		
	}
}
