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
            System.out.println();                                   // Printing the Menu
            System.out.println("+-----------------------------------+----------------------------------------+");
            System.out.println("|              Option               |                Action                  |");
            System.out.println("+-----------------------------------+----------------------------------------+");
            System.out.println("| Press 1                           | Linear Search the array                |");
            System.out.println("| Press 2                           | Print the array                        |");
            System.out.println("| Press 3                           | Binary Search the array                |");
            System.out.println("| Press 4                           | Sort the array                         |");
            System.out.println("| Press 5                           | Update Array Element                   |");
            System.out.println("| Press 6                           | Add at the start of Array              |");
            System.out.println("| Press 7                           | Add at the end of Array                |");
            System.out.println("| Press 8                           | Add at location                        |");
            System.out.println("| Press 9                           | Delete at the Start                    |");
            System.out.println("| Press 10                          | Delete at the End                      |");
            System.out.println("| Press 11                          | Delete at Location                     |");
            System.out.println("| Press -1                          | End                                    |");
            System.out.println("+-----------------------------------+----------------------------------------+");
            System.out.println("Welcome to the Menu! Please enter your choice.\n");

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
                System.out.println("Enter Element to search using Binary Search Algorithm:");
                int element = input.nextInt();
                int value = arr.binarySearch(element);
                if (value == -1)
                    System.out.println("Element is not found in array\n");
                else
                    System.out.printf("Element was found at : %d\n",value);
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
            else if (choice == 9){
                try {
                    int element = arr.delAtStart();
                    System.out.println("Deleted element: " + element);
                } catch (Exception e) {
                    System.out.println("Error Occured:  " + e.getMessage());
                }
            }
            else if (choice == 10){
                try {
                    int element = arr.delAtEnd();
                    System.out.println("Deleted element: " + element);
                } catch (Exception e) {
                    System.out.println("Error Occured:  " + e.getMessage());
                }  
            }
            else if (choice == 11){
                System.out.println("\nEnter Location to Delete at: ");
                int location = input.nextInt();
                try {
                    int element = arr.delAtLocation(location);
                    System.out.println("Deleted element: " + element);
                } catch (Exception e) {
                    System.out.println("Error Occured:  " + e.getMessage());
                }
            }
            else if (choice == -1)
                break;
            else
                System.out.println("Wrong Input Try again");
        }


    }   
}

abstract class List {
    abstract public void print();                                                   
    abstract public boolean addAtStart(int element);                                
    abstract public boolean addAtEnd(int element);                                  
    abstract public boolean addAtLocation(int location,int element);                
    abstract public int delAtEnd() throws Exception;
    abstract public int delAtStart() throws Exception;
    abstract public int delAtLocation(int location) throws Exception;
    abstract public int LinearSearch(int element);                                  
    abstract public int binarySearch(int element);                                  
    abstract public boolean sorting(int order);                                     
    abstract public void updateArray(int element,int location);                              
    
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
                                                                // Insertion Methods
    @Override                                                    
    public boolean addAtStart(int element){
        //validate to before adding the element at the start if there are empty spaces in the array
        if (n>=N){
            return false;
        }
        else{
            for(int i=n-1;i>=0;i--){
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
        array_int[n] = element;
        n++;
        return true;
        }
    }

    @Override   
    public boolean addAtLocation(int location,int element){
        if (location > -1 && location <=n && n<N){
            for(int i=n-1;i>=location;i--){
                array_int[i+1] = array_int[i];
            }
            array_int[location] = element;
            n++;
            return true;
        }
        else
            return false;
    }

                                                                // Deletion Methods
    @Override
    public int delAtStart() throws Exception{
        if (n>0){
            int element = array_int[0];
            for(int i=1;i<n;i++){
                array_int[i-1] = array_int[i];
            }
            n--;
            return element;
        }
        else
            throw new Exception("Deletion was not successful");
    }

    @Override
    public int delAtEnd() throws Exception{
        if (n>0){
            int element = array_int[n-1];
            n--;
            return element;
        }
        else
            throw new Exception("Deletion was not successful");
    }
    
    @Override
    public int delAtLocation(int location) throws Exception{
        if (location > -1 && location <n){
            int element = array_int[location];
            for(int i=location+1;i<n;i++){
                array_int[i-1] = array_int[i];
            }
            n--;
            return element;
        }
        else
            throw new Exception("Deletion was not successful");
    }
                                                                    // Searching Methods
    @Override
    public int LinearSearch(int element){
         for(int i=0;i<n;i++){  
             if (array_int[i] == element){
                 return i;
             }
         }
         return -1;
    }

    @Override
    public int binarySearch(int element){
        int low = 0;
        int high = n-1;
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
                if ((order == 1 && array_int[j] > array_int[j + 1]) || (order == 2 && array_int[j] < array_int[j + 1])) {   // Checking either to sort ascending or descending
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
