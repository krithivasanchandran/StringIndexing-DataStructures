package graph.code;

public class MergeSort {
	
	
	public static void mergeSort(int[] a,int n){
		
		int mid = n/2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];
		
		for(int i=0;i<mid;i++){
			l[i] = a[i];
		}
		
		for(int i=mid;i<n;i++){
			r[i-mid] = a[i];
		}
		
		mergeSort(l,mid);
		mergeSort(r,n-mid);
		
		merge(a,l,r,mid,n-mid);
	}
	
	public static void merge(int[] a, int[] l, int[] r, int left, int right){
		
		int i=0,j=0,k=0;
		
		while(i < left && j < right){
			if(l[i] <= r[j]){
				a[k++] = l[i++];
			}else{
				a[k++] = r[j++];
			}
		}
		
		while(i < left){
			a[k++] = l[i++];
		}
		
		while(j < right){
			a[k++] = r[j++];
		}
	}
	
//	public static void partition(int arr[], int low, int high){
//		
//		if(low < high){
//			int mid = (high - low) / 2;
//			System.out.println("Midpoint :: " + arr[mid]);
//			partition(arr,low,mid-1);
//			partition(arr,mid+1,high);
//		}
//	}
	
	public static void main(String args[]){
		
		int arr[] = {20,10,24,53,64,73,81,92,101,201};
		mergeSort(arr,arr.length);
		
//		for(int jk=0;jk<arr.length;jk++){
//			System.out.println("Final Array --> " + arr[jk]);
//		}
	}
}
