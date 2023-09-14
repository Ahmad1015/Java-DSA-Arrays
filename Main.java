// Work on it 
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        List arr=new Array();
        System.out.println("\nEnter 1 to create an Non parameterized Contructor\nEnter 2 to create a parameterized Contructor\n");
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
            System.out.println("\nWelcome to the Menu:\nPress 1 to Linear Search the array\nPress 2 to Print the array\nPress 3 to Binary Search the array\nPress 4 to Sort the array\nPress 5 to Update Array Element\nPress 6 to add at the start of Array\nPress 7 to add at the end of Array\nPress 8 to add at location\n");
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
                System.out.println("Enter 1 to Sort Ascendingly\nEnter 2 to Sort Descendingly");
                int order = input.nextInt();                            
                arr.sorting(order);
            }
            else if (choice == 5){
                System.out.println("Enter the Location");
                int location = input.nextInt();
                System.out.println("Enter the Element to Add there");
                int element = input.nextInt();
                arr.updateArray(element, location);
            }
            else if (choice == 6){
                System.out.println("Enter the element to add: ");
                int element = input.nextInt();
                boolean flag = arr.addAtStart(element);
                if (flag)
                    System.out.println("Element was successfully Added");
                else
                    System.out.println("Error!!!\nThere is no space left in the Array");
            }
            else if (choice == 7){
                System.out.println("Enter the element to add: ");
                int element = input.nextInt();
                boolean flag = arr.addAtEnd(element);
                if (flag)
                    System.out.println("Element was successfully Added");
                else
                    System.out.println("Error!!!\nThere is no space left in the Array");
            }
            else if (choice == 8){
                System.out.println("Enter the element to add: ");
                int element = input.nextInt();
                System.out.println("Enter a Valid Location to Add the Element at: ");
                int location = input.nextInt();
                boolean flag = arr.addAtLocation(location, element);
                if (flag)
                    System.out.println("Enter was successfully Added");
                else
                    System.out.println("Invalid Location!!!\nElement was not Added");
            }
        }


    }   
}

abstract class List {
    abstract public void print();                                                   // perfect
    abstract public boolean addAtStart(int element);                                // perfect
    abstract public boolean addAtEnd(int element);
    abstract public boolean addAtLocation(int location,int element);
    public void delAtEnd(){};
    public void delAtStart(){};
    public void delAtLocation(int location){};
    abstract public int LinearSearch(int element);  
    abstract public int binarySearch(int element);
    abstract public boolean sorting(int order);                                     // perfect
    abstract public void updateArray(int element,int location);                     // perfect          
    
}

class Array extends List{
    public  int[] array_int;
    int n;              //Actual number of elements  ->k
    int N;              //array size

    public Array(){     
        N=5;           
        n=0;         // Non parameter Constructor
        array_int = new int[N];
    }

    public Array(int size){ 
        N=size;  
        n=0;              // parameterized Constructor
        array_int = new int[N];
    }
                                                                // Insertion Algorithms
    @Override    
    public boolean addAtStart(int element){
        //validate to before adding the element at the start if there are empty spaces in the array
        if (n>=N){
            return false;
        }
        else{
            for(int i=N-2;i>=0;i--){
                array_int[i+1] = array_int[i];
            }
        array_int[0] = element;
        n++;
        return true;
        }
    }

    @Override    
    public boolean addAtEnd(int element){
        if(n>=N){
            return false;
        }
        else{
        for(int i=1;i<array_int.length;i++){
            array_int[i-1] = array_int[i];
        }
        array_int[array_int.length-1] = element;
        n++;
        return true;
        }
    }

    @Override   // 
    public boolean addAtLocation(int location,int element){
        if (location > -1 && location <=n && n<=N){
            for(int i=n;i>=location;i--){
                array_int[i-1] = array_int[i];
            }
            array_int[location] = element;
            n++;
            return true;
        }
        else
            return false;
    }

    @Override
    public int LinearSearch(int element){
         for(int i=0;i<n;i++){  // Linear Searching
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
        for(int i=0;i<n;i++){
            System.out.print(array_int[i]+" ");
        }
        System.out.println();
    } // End of Print Method

    @Override
    public boolean sorting(int order){                // Using bubble Sorting
        if (order == 1 || order == 2){
        int size = array_int.length;                                    
        for (int i = 0; i < (size-1); i++) {                                      
        boolean swapped = false;
        for (int j = 0; j < (size-i-1); j++) {                                  
                if ((order == 1 && array_int[j] > array_int[j + 1]) || (order == 2 && array_int[j] < array_int[j + 1])) {
                    int temp = array_int[j];
                    array_int[j] = array_int[j + 1];
                    array_int[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        return true;
    }
    else
        return false;                           
    }

    @Override
    public void updateArray(int element,int location){
        array_int[location] = element;
    }
}
