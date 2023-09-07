public class Main{
    public static void main(String[] args){
        List arr=new Array();
        arr.print();
        System.out.println("Searching element in array and outputting where its found if found:");
        int location = arr.search(8);
        if (location == -1){
            System.out.println("Element not Found in the Array");
        }
        else{
            System.out.printf("Element Found in Array at Location : %d\n",location);
        }
        System.out.println("Sorting Array now and printing it :");
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
    abstract public int search(int element);
    abstract public void sortArray();
}

class Array extends List{
    public  int[] arrayToPass;

    public Array(){                         // Non parameter Constructor
        arrayToPass = new int[10];
        int count = 100;
        for(int i = 0;i<arrayToPass.length;i++){    // Adding values into Array
            arrayToPass[i] = count--;
        }
    }

    @Override
    public int search(int element){
         for(int i=0;i<arrayToPass.length;i++){  // Linear Searching
             if (arrayToPass[i] == element){
                 return i;
             }
         }
         return -1;
    }// End of Search Method

    @Override
    public void print(){
        for(int i=0;i<arrayToPass.length;i++){
            System.out.println(arrayToPass[i]);
        }
    } // End of Print Method

    @Override
    public void sortArray(){
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
      }
                                        // no swapping means the array is already sorted so no need for further comparison
      if (!swapped)
        break;
    }                                   // End of the inner loop
    }                                   // End of the outer Loop
}
