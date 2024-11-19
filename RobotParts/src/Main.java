import java.util.*;

public class Main {

    public static List<String> get_robots(String[] all_parts, String required_parts_1){

        Map<String,List<String>> map = new HashMap<>(); // Robot -> list of parts
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<String> removedRobots = new HashSet<>();

        for (String str : all_parts){

            String robotKey = null;
            String partVal = null;

            String[] strTokens = str.split("_");
            robotKey = strTokens[0];
            partVal = strTokens[1];

            if(!map.containsKey(robotKey)){
                map.put(robotKey,new ArrayList<>());
            }
            map.get(robotKey).add(partVal);
        }
        System.out.println(map);

        List<String> listOfParts = Arrays.asList(required_parts_1.split(","));

        for(String part : listOfParts){

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {

                if (entry.getValue().contains(part) && !removedRobots.contains(entry.getKey())) {
                    set.add(entry.getKey());
                }else{
                    removedRobots.add(entry.getKey());
                    set.remove(entry.getKey());
                }
            }
        }
        System.out.println(set);








        return null;
    }





    public static void main(String[] args) {

        String required_parts_1 = "sensors,case,speaker,wheels";
        String required_parts_2 = "sensors,case,speaker,wheels,claw";
        String required_parts_3 = "sensors,case,screws";

        String[] all_parts = {
                "Rosie_claw",
                "Rosie_sensors",
                "Dustie_case",
                "Optimus_sensors",
                "Rust_sensors",
                "Rosie_case",
                "Rust_case",
                "Optimus_speaker",
                "Rosie_wheels",
                "Rosie_speaker",
                "Dustie_case",
                "Dustie_arms",
                "Rust_claw",
                "Dustie_case",
                "Dustie_speaker",
                "Optimus_case",
                "Optimus_wheels",
                "Rust_legs",
                "Optimus_sensors"};

        List<String> list = get_robots(all_parts, required_parts_1);
        System.out.println(list);



    }
}