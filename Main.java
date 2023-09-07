public class Main{
    public static void main(String[] args){
        List arr=new Array();
        //Array arr = new Array();
        arr.print(Array.arrayToPass);
        System.out.println("Searching element 8 in array and outputting where its found if found:");
        System.out.println(arr.search(Array.arrayToPass, 8));
        System.out.println("Searching if zero is found at zeroth location:");
        System.out.println(arr.searchAtLocation(Array.arrayToPass, 0, 0));
    }
}

abstract class List {
    abstract public void print(int[] arr); 
    public void addAtStart(int element,int[] arr){};
    public void addAtEnd(int element,int[] arr){};
    void addAtLocation(int location,int element,int[] arr){};
    public void delAtEnd(int[] arr){};
    public void delAtStart(int[] arr){};
    public void delAtLocation(int location,int element,int[] arr){};
    abstract public int search(int element);
  
}

class Array extends List{
    public  int[] arrayToPass;

    public Array(){                         // Non parameter Constructor
        arrayToPass = new int[10];
        for(int i = 0;i<arrayToPass.length;i++){    // Adding values into Array
            arrayToPass[i] = i;
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
     }
    public void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    } // End of Print Method
}
