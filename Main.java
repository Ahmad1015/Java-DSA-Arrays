// Work on it 
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        List arr=new Array();
        System.out.println("Enter 1 to create an Non parameterized Contructor\nEnter 2 to create a parameterized Contructor");
        int type = input.nextInt();
        if (type == 1){                                             // Using the Non Parameterized Constructor
            arr=new Array();  
        }
        else if (type == 2){                                        // Using the Parameterized Constructor
            System.out.println("Enter the Parameter Value");
            List arr2 = new Array(input.nextInt());
            arr = arr2;
        }

        while(true){
            System.out.println("Welcome to the Menu:\nPress 1 to Linear Search the array\nPress 2 to Print the array\nPress 3 to Binary Search the array\nPress 4 to Sort the array ascendingly\nPress 5 to Sort the array Descending\nPress 6 to Update Array Element\n");
            int choice = input.nextInt();
            if (choice == 1){
                System.out.println("Enter the number to Linear Search in the Array and output if Found:");
                int location = arr.LinearSearch(input.nextInt());
                if (location == -1){
                    System.out.println("Element not Found in the Array");
                }
                else{
                    System.out.printf("Element Found in Array at Location : %d\n",location);
                }
            }
            else if (choice == 2){
                System.out.println("Printing Array now: ");
                arr.print();
            }
            else if (choice == 3){
                System.out.println("Doing Binary Searching");
                int element = input.nextInt();
                int value = arr.binarySearch(element);
                if (value == -1)
                    System.out.println("Element is not found in array\n");
                else
                    System.out.printf("Element was found at : %d",value);
            }
            else if (choice == 4){
                System.out.println("Sorting Array ascendingly:");                              
                arr.ascendSort();
            }
            else if (choice == 5){
                System.out.println("Sorting Array ascendingly:");                              
                arr.descendSort();
            }
            else if (choice == 6){
                System.out.println("Enter the Location");
                int location = input.nextInt();
                System.out.println("Enter the Element to Add there");
                int element = input.nextInt();
                arr.updateArray(element, location);
            }
        }

        // System.out.print("Add Value to Add to the start of the array: ");
        // int element = input.nextInt();
        // arr.addAtStart(element);
   
        // System.out.print("Add Value to Add to the End of the array: ");
        // element = input.nextInt();
        // arr.addAtEnd(element);

    }   
}

abstract class List {
    abstract public void print(); 
    public void addAtStart(int element){};
    public void addAtEnd(int element){};
    public void addAtLocation(int location,int element){};
    public void delAtEnd(){};
    public void delAtStart(){};
    public void delAtLocation(int location){};
    abstract public int LinearSearch(int element);
    abstract public int binarySearch(int element);
    abstract public void ascendSort();
    abstract public void descendSort();
    abstract public void updateArray(int element,int location);                               // Task D: Adding Another method we have missed
    
}

class Array extends List{
    public  int[] array_int;
    int n;//data size ->k
    int N;//array size

    public Array(){     
        N=5;           
        n=0;         // Non parameter Constructor
        array_int = new int[N];
    }

    public Array(int size){ 
        N=size;  
        n=o;              // parameterized Constructor
        array_int = new int[N];
    }

    @Override
    public void addAtStart(int element){//return boolean
        //validate
        for(int i=array_int.length-2;i>=0;i--){
            array_int[i+1] = array_int[i];
        }
        array_int[0] = element;
        n++;
    }

    @Override
    public void addAtEnd(int element){
        for(int i=1;i<array_int.length;i++){
            array_int[i-1] = array_int[i];
        }
        array_int[array_int.length-1] = element;
    }

    @Override
    public int LinearSearch(int element){
         for(int i=0;i<array_int.length;i++){  // Linear Searching
             if (array_int[i] == element){
                 return i;
             }
         }
         return -1;
    }// End of LinearSearch Method

    @Override
    public int binarySearch(int element){
        int low = 0;
        int high = array_int.length-1;
        while(low<=high){
            int mid = low + (high-low)/2 ;
            if (array_int[mid] == element){
                return mid;
            }
            else if (element > array_int[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            
        }
        return -1;
    }

    @Override
    public void print(){
        for(int i=0;i<array_int.length;i++){
            System.out.print(array_int[i]+" ");
        }
        System.out.println();
    } // End of Print Method

    @Override
    public void ascendSort(){                // Using bubble Sorting
        int size = array_int.length;
                                            // loop to access each array element
    for (int i = 0; i < (size-1); i++) {
                                            // check if swapping occurs
      boolean swapped = false;
                                            // loop to compare adjacent elements
      for (int j = 0; j < (size-i-1); j++) {
                                            // compare two array elements
        if (array_int[j] > array_int[j + 1]) {
                                            // swapping occurs if elements
                                            // are not in the intended order
          int temp = array_int[j];
          array_int[j] = array_int[j + 1];
          array_int[j + 1] = temp;
          swapped = true;
        }
      }                                 // End of the inner loop
                                        // no swapping means the array is already sorted so no need for further comparison
      if (!swapped)
        break;
    }                                   // End of the outer Loop
    }                                   // End of method

    @Override
    public void descendSort(){
        int size = array_int.length;
                                            // loop to access each array element
    for (int i = 0; i < (size-1); i++) {
                                            // check if swapping occurs
      boolean swapped = false;
                                            // loop to compare adjacent elements
      for (int j = 0; j < (size-i-1); j++) {
                                            // compare two array elements
        if (array_int[j] < array_int[j + 1]) {
                                            // swapping occurs if elements
                                            // are not in the intended order
          int temp = array_int[j];
          array_int[j] = array_int[j + 1];
          array_int[j + 1] = temp;
          swapped = true;
        }
      }                                 // End of the inner loop
                                        // no swapping means the array is already sorted so no need for further comparison
      if (!swapped)
        break;
    } 

    }

    @Override
    public void updateArray(int element,int location){
        array_int[location] = element;
    }
}
