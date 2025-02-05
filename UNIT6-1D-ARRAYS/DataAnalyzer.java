public class DataAnalyzer{
    //reverse list
    public static int[] reverseList(int[] numbers){
        int[] tempList = new int[numbers.length];
        int index = numbers.length-1;
        int i = 0;
        while(index>0){
            tempList[i] = numbers[index];
            i++;
            index--;
        }
        return tempList;
    }
    //Binary Search
    public static int searchList(int target, int[] numbers){
        int minIndex = 0;
        int maxIndex = numbers.length;
        while(minIndex>maxIndex){
            int middleIndex = (int) Math.floor((minIndex+maxIndex)/2);
            if(target == numbers[middleIndex]){
                return middleIndex;
        }else{
            if(target>numbers[middleIndex]){
                minIndex = middleIndex + 1;
            }else{
                maxIndex = middleIndex - 1;
            }
        }
    }
        return -1;
    }
    public static int searchList(int[] numbers, int target){
        int index = 0;
        while(index<=numbers.length){
            if(numbers[index] == target){
                return index;
            }
            index++;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(searchList(arr ,5));

        int[] newArr = reverseList(arr);
        for(int i = 0; i< newArr.length; i++){
            System.out.println(newArr[i]);
        }
    }
}