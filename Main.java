// Changing Function defination Branch
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        List arr=new Array();                                                                   // Task A:
        while(true){
            System.out.println("Welcome to the Menu:\nPress 1 to Linear Search the array\nPress 2 to Print the array\nPress 3 to Binary Search the array\nPress 4 to Sort the array ascendingly\nPress 5 to Sort the array Descending\n");
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
                // Do binary search here
            }
            else if (choice == 4){
                System.out.println("Sorting Array ascendingly:");                              
                arr.ascendSort();
            }
            else if (choice == 5){
                System.out.println("Sorting Array ascendingly:");                              
                // Do sorting here
            }
        }
        // Scanner input = new Scanner(System.in);
        // System.out.println("Now Using the Parametrized Constructor:");                         // Task C : Parametrized Constructor
        // System.out.println("Enter the Array Size:");
        // int size = input.nextInt();
        // List arr2 =new Array(size);
        // System.out.println("Outputting the new Array where Size was specified by the User:");
        // arr2.print();
        //                                                                                         // Task D: I am Adding another Method called Update
        // arr2.updateArray(5, 2);
        // System.out.println("Printing Array after Updating :");
        // arr2.print();
        // System.out.print("Add Value to Add to the start of the array: ");
        // int element = input.nextInt();
        // arr.addAtStart(element);
        // arr.print();
        // System.out.print("Add Value to Add to the End of the array: ");
        // element = input.nextInt();
        // arr.addAtEnd(element);
        // arr.print();
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
    abstract public void ascendSort();
    abstract public void descendSort();
    public void updateArray(int element,int location){};                               // Task D: Adding Another method we have missed
}

class Array extends List{
    public  int[] arrayToPass;

    public Array(){                         // Non parameter Constructor
        arrayToPass = new int[5];
        
    }

    public Array(int size){                 // parameterized Constructor
        arrayToPass = new int[size];
    }

    @Override
    public void addAtStart(int element){
        for(int i=arrayToPass.length-2;i>=0;i--){
            arrayToPass[i+1] = arrayToPass[i];
        }
        arrayToPass[0] = element;
    }

    @Override
    public void addAtEnd(int element){
        for(int i=1;i<arrayToPass.length;i++){
            arrayToPass[i-1] = arrayToPass[i];
        }
        arrayToPass[arrayToPass.length-1] = element;
    }

    @Override
    public int LinearSearch(int element){
         for(int i=0;i<arrayToPass.length;i++){  // Linear Searching
             if (arrayToPass[i] == element){
                 return i;
             }
         }
         return -1;
    }// End of LinearSearch Method

    @Override
    public void print(){
        for(int i=0;i<arrayToPass.length;i++){
            System.out.print(arrayToPass[i]+" ");
        }
        System.out.println();
    } // End of Print Method

    @Override
    public void ascendSort(){                // Using bubble Sorting
        int size = arrayToPass.length;
                                            // loop to access each array element
    for (int i = 0; i < (size-1); i++) {
                                            // check if swapping occurs
      boolean swapped = false;
                                            // loop to compare adjacent elements
      for (int j = 0; j < (size-i-1); j++) {
                                            // compare two array elements
        if (arrayToPass[j] > arrayToPass[j + 1]) {
                                            // swapping occurs if elements
                                            // are not in the intended order
          int temp = arrayToPass[j];
          arrayToPass[j] = arrayToPass[j + 1];
          arrayToPass[j + 1] = temp;
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
        int size = arrayToPass.length;
                                            // loop to access each array element
    for (int i = 0; i < (size-1); i++) {
                                            // check if swapping occurs
      boolean swapped = false;
                                            // loop to compare adjacent elements
      for (int j = 0; j < (size-i-1); j++) {
                                            // compare two array elements
        if (arrayToPass[j] < arrayToPass[j + 1]) {
                                            // swapping occurs if elements
                                            // are not in the intended order
          int temp = arrayToPass[j];
          arrayToPass[j] = arrayToPass[j + 1];
          arrayToPass[j + 1] = temp;
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
        arrayToPass[location] = element;
    }
}
