import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Basketball{
    public ArrayList<Team> teams = new ArrayList<Team>();
    private static FileOperator input = new FileOperator("UNIT6-1D-ARRAYS/arenas.txt");

    public static void main(String[] args){
        Basketball org = new Basketball();
        FileOperator arenas = new FileOperator("UNIT6-1D-ARRAYS/arenas.txt");
        FileOperator location_file = new FileOperator("UNIT6-1D-ARRAYS/locations.txt");
        FileOperator names = new FileOperator("UNIT6-1D-ARRAYS/teams.txt");
        FileOperator capacities_file = new FileOperator("UNIT6-1D-ARRAYS/capacities.txt");
        FileOperator championships_file= new FileOperator("UNIT6-1D-ARRAYS/championships.txt");
        
        
        String[] arena_names = arenas.toStringArray(30);
        String[] locations = location_file.toStringArray(30);
        String[] team_names = names.toStringArray(30);
        int[] capacities = capacities_file.toIntArray(30);
        int[] championships = championships_file.toIntArray(30);
        for(int i = 0; i < arena_names.length; i++){
            org.teams.add(new Team(team_names[i], locations[i], arena_names[i], championships[i], capacities[i]));
        }
        System.out.println(org.teams.get(0));


        

        
       

    }
    public static void printArray(int[] nums){
        System.out.print("[");
        for(int i = 0; i < nums.length-1; i++){
            System.out.print(nums[i] + ", ");
        }
        System.out.print("]");
    }
     // Linear Search  
    public static int searchList(int[] numbers, int target){
        int index = 0;
        while(index <= numbers.length - 1){
            if(numbers[index] == target){
                return index;
            }
            index++;
        }

        return -1;
    }
    // Binary Search - List must be sorted first
    public static int searchList(int target, int[] numbers){
        int minIndex = 0;
        int maxIndex = numbers.length -1;
        while (minIndex <= maxIndex){
            int middleIndex = (maxIndex+minIndex)/2;
            if(numbers[middleIndex] == target){
                return middleIndex;
            }
            else{
                if(target > numbers[middleIndex]){
                    minIndex = middleIndex + 1;
                }else{
                    maxIndex = middleIndex - 1;
                }
            }
        }
        return -1;
    }
    public static int[] reverseList(int[] array){
        int[] newArray = new int[array.length];

        for(int i = 0; i < array.length-1; i++){
            newArray[i] = array[array.length-1-i];
        }
        return newArray;
    }

    public static int findMax(int[] values){
        int max = values[0];
        for(int i = 0; i < values.length; i++){
            if(values[i] > max){
                max = values[i];
            }
        }
        return max;
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
   
    public static int[] findString(String[] list, String target){
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            if(list[i].equals(target)){
                indices.add(i);
            }
            
        }
        int[] result = new int[indices.size()];
        for(int i = 0; i < indices.size(); i++){
            result[i] = indices.get(i);
        }
        return result;
    }

    public static String[] arenaSearch(String[] list, String target){
        int[] indices = findString(list, target);
        String[] arenaNames = input.toStringArray(30);
        String[] arenas = new String[indices.length];
        for(int i = 0; i<indices.length; i++){
            arenas[i] = arenaNames[indices[i]];
        }
        return arenas;
    }
    
    public static String[] arenasByCapacity(String target){
        input.setFile("UNIT6-1D-ARRAYS/capacities.txt");
        String[] foundList = input.toStringArray(30);
        String[] arenas = arenaSearch(foundList, target);        
        
        return arenas;
    }
    
    public static int[] capacityByCity(String target){
        input.setFile("UNIT6-1D-ARRAYS/arenas.txt");
        String[] arenas = input.toStringArray(30);

        input.setFile("UNIT6-1D-ARRAYS/capacities.txt");
        ArrayList<Integer> final_capacities = new ArrayList<>();

        int[] capacities = input.toIntArray(30);

        for (int i = 0; i < arenas.length; i++){
            if(arenas[i].equals(target)){
                System.out.println("it worked");
                final_capacities.add(capacities[i]);
            }
        }
        int[] new_capacities = new int[final_capacities.size()];
        
        for(int i = 0; i < new_capacities.length; i++){
            new_capacities[i] = final_capacities.get(i);
        }
        return new_capacities;

    }







}
