public class Main{
    public static void main(String[] args){
        Array arr = new Array();
        arr.print(Array.arrayToPass);
        System.out.println("Searching element 8 in array and outputting where its found if found:");
        System.out.println(arr.search(Array.arrayToPass, 8));
        System.out.println("Searching if zero is found at zeroth location:");
        System.out.println(arr.searchAtLocation(Array.arrayToPass, 0, 0));
    }
}

abstract class List {
    public void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    } // End of Print Method

    public void addAtStart(int element,int[] arr){};
    public void addAtEnd(int element,int[] arr){};
    public void addAtLocation(int location,int element,int[] arr){};
    public void delAtEnd(int[] arr){};
    public void delAtStart(int[] arr){};
    public void delAtLocation(int location,int element,int[] arr){};

    public int search(int[] arr,int element){
        for(int i=0;i<arr.length;i++){  // Linear Searching
            if (arr[i] == element){
                return i;
            }
        }
        return -1;
    }
    public boolean searchAtLocation(int[] arr,int element,int location){
        if (arr[location] == element){
            return true;
        }
        else{
            return false;
        }
    }
}

class Array extends List{
    public static int[] arrayToPass;

    public Array(){                         // Non parameter Constructor
        arrayToPass = new int[10];
        for(int i = 0;i<arrayToPass.length;i++){    // Adding values into Array
            arrayToPass[i] = i;
        }
    }
}
