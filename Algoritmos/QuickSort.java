package Algoritmos;

public class QuickSort {
    
    public static void swap(double arr[], int i, int j) {
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	  }
	  
	  public static int partition(double arr[], int low, int high) {
		double pivot = arr[high];
		int i = (low - 1);
	  
		for (int j = low; j <= high - 1; j++) {
		  if (arr[j] <= pivot) {
			i++;
			swap(arr, i, j);
		  }
		}
	  
		swap(arr, i + 1, high);
		return (i + 1);
	  }
	  
	  public void quickSort(double arr[], int low, int high) {
		int stack[] = new int[high - low + 1];
		int top = -1;
	  
		stack[++top] = low;
		stack[++top] = high;
	  
		while (top >= 0) {
		  high = stack[top--];
		  low = stack[top--];
	  
		  int p = partition(arr, low, high);
	  
		  if (p - 1 > low) {
			stack[++top] = low;
			stack[++top] = p - 1;
		  }
	  
		  if (p + 1 < high) {
			stack[++top] = p + 1;
			stack[++top] = high;
		  }
		}
	  }
}
  