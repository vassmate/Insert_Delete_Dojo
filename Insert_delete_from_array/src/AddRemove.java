public class AddRemove {
	private int[] inputArray;
	
	public AddRemove(int[] initArray) {
		this.inputArray = initArray;
	}
	
	public int[] getArray() {
		return this.inputArray;
	}
	
	public int[] addElement(int element) {
		int[] result = new int[inputArray.length + 1];
		try{
			for(int i = 0; i < inputArray.length; i++) {
				result[i] = inputArray[i];
			}
			result[result.length - 1] = element;
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex);
		}
		inputArray = result;
		return result;
	}
	
	public int[] deleteElement(int element) {
		int[] result = new int[inputArray.length - 1];
		boolean founndElement = false;
		try {
			for(int i = 0; i < result.length; i++) {
				if(!founndElement) {
					if(inputArray[i] != element){
						result[i] = inputArray[i];
					} else {
						result[i] = inputArray[i + 1];
						founndElement = true;
					}
				} else {
					result[i] = inputArray[i + 1];
				}
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex);
		}
		inputArray = founndElement ? result : inputArray;
		return inputArray;
	}
	
	public static void main(String[] args) {
		int[] inArray = new int[]{1,2,3,4,5,6,7,8,9};
		AddRemove ar = new AddRemove(inArray);
		ar.addElement(10);
		ar.deleteElement(1);
		for(int num : ar.getArray()) {
			System.out.print(num + " ");
		}
	}
}