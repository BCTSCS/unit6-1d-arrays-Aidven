import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

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
        while(index<=numbers.length - 1){
            if(numbers[index] == target){
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int getMax(int[] numbers){
        int maxNum = numbers[0];
        for(int num : numbers){
          if(num>maxNum){
            maxNum = num;
          }
        }
        return maxNum;
    }

    public static int getMin(int[] numbers){
        int minNum = numbers[0];
        for(int num : numbers){
          if(num<minNum){
            minNum = num;
          }
        }
        return minNum;
    }

    public static String[] arenaByCapacity(int[] capacities, String[] arenas, int capacity, int flip){
        // if flip = 1, for greater than
        // if flip = 0, for less than
        String[] arenaCapacities;
        if(flip == 0){
            for(int i = 0; i < capacities.length-1; i++){
                if(capacities[i] <= capacity){
                    
                }
            }
        }
        return arenas;
    }
    public static int[] ascendOrDescend(int[] arr, int flip){
        // if flip = 1, sorts in ascending order
        // if flip = 0, sorts in descending order
        int temp;
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j< arr.length; j++){
                if (arr[j] > arr[i]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        if(flip == 1){
            return reverseList(arr);
        }
        else{
            return arr;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(searchList(arr ,5));

        int[] newArr = reverseList(arr);
        for(int i = 0; i< newArr.length; i++){
            System.out.print(newArr[i] + " ");
        }
        System.out.println("");

        int[] fileArr = new int[100];
        try{
            File f = new File("UNIT6-1D-ARRAYS/numbers.txt");
            Scanner scan = new Scanner(f);
            for(int i=0; i<100; i++){
                fileArr[i] = scan.nextInt();
            }
        }catch(IOException f){
            System.out.println("file not found");
        }

        //linear search
        System.out.println(searchList(fileArr,81));

        //binary search
        System.out.println(searchList(81, fileArr));

        //reverse list
        int[] reverseArr = reverseList(fileArr);
        for(int i=0; i < reverseArr.length -1; i++){
            System.out.print(reverseArr[i] + " ");


        FileOperator file1 = new FileOperator("UNIT6-1D-ARRAYS/capacities.txt");
        int[] capacities = file1.toIntArray(30);
        for(int num : capacities){
              System.out.print(num + " ");
        }

        System.out.println("");
        System.out.println(getMax(capacities));
        System.out.println(getMin(capacities));
        int[] OrderedCapacities = ascendOrDescend(capacities, 1);

        FileOperator input = new FileOperator("UNIT6-1D-ARRAYS/college.txt");
        ArrayList<String> colleges = input.toStringList();
        for(String college : colleges){
            System.out.print(college + " ");
        }
    }
}}