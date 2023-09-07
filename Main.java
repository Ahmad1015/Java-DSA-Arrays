public class Main{
    public static void main(String[] args){
        List arr=new Array();
        //Array arr = new Array();
        arr.print();
        System.out.println("Searching element in array and outputting where its found if found:");
        System.out.println(arr.search(8));
    }
}

abstract class List {
    abstract public void print(); 
    public void addAtStart(int element){};
    public void addAtEnd(int element){};
    void addAtLocation(int location,int element){};
    public void delAtEnd(){};
    public void delAtStart(){};
    public void delAtLocation(int location){};
    abstract public int search(int element);
    public void sortArray(){};
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

    @Override
    public void print(){
        for(int i=0;i<arrayToPass.length;i++){
            System.out.println(arrayToPass[i]);
        }
    } // End of Print Method
}
