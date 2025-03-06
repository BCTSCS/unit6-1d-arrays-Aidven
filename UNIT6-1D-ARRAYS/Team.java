public class Team {
    public int num_arenas;
    private String name;
    private String location;
    private String arena;

    public Team(String n, String l, String a){
        name = n;
        location = l;
        arena = a;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }
    
    public String getArena(){
        return arena;
    }

    public setName(String n){
        name = n;
    }

    public setLocation(String l){
        location = l;
    }

    public setArena(String a){
        arena = n;
    }
}
