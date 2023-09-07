public class Main{
    public static void main(String[] args){
        Array arr = new Array();

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
    public int[] arr;

    public Array(){                         // Non parameter Constructor
        arr = new int[10];
        for(int i = 0;i<arr.length;i++){    // Adding values into Array
            arr[i] = i;
        }
    }
}
