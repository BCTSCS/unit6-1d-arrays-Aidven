
public class UserStory {
    private String[] arenas;
    private int[] capacities;
    private FileOperator arenaFile;
    private FileOperator capacityFile;

    public UserStory(){
        arenaFile = new FileOperator("UNIT6-1D-ARRAYS/arenas.txt");
        capacityFile = new FileOperator("UNIT6-1D-ARRAYS/capacities.txt");
        arenas = arenaFile.toStringArray(30);
        capacities = capacityFile.toIntArray(30);
    }




  
}