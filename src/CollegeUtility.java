import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CollegeUtility
{
    private static ArrayList<College> colleges = new ArrayList<College>();

    public static void addCollege(College college){
        colleges.add(college);
    }

    public static void loadFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner input = new Scanner(file);
        String throwaway = input.nextLine();
        while(input.hasNextLine()){
            String line = input.nextLine();
            College c = new College(line.split(",")[0], Integer.parseInt(line.split(",")[1]), Integer.parseInt(line.split(",")[2]), Integer.parseInt(line.split(",")[3]));
            colleges.add(c);
        }
        System.out.println("College loaded");
    }

    public static String findSmallestTuition(){
        String name = colleges.getFirst().getName();
        int smallestTuition = colleges.getFirst().getTuition();
        for(College c : colleges){
            if(c.getTuition() < smallestTuition){
                smallestTuition = c.getTuition();
                name = c.getName();
            }
        }
        return name + " with a tuition of " + smallestTuition;
    }

    public static void sortByTuition(){
        College cheap =  colleges.getFirst();
        int smallest = cheap.getTuition();
        for(int k = 0; k < colleges.size(); k++){
            int index = 0;
            for(int i = 0; i < colleges.size(); i++){
                if(colleges.get(k).getTuition() < smallest){
                    cheap = colleges.get(i);
                    index = i;
                }
            }
            colleges.set(index, colleges.get(k));
            colleges.set(k, cheap);
            System.out.println(colleges.get(k));
        }
    }

    public void listByEnrollment(){

    }

    public static ArrayList<College> getCollegeByRank(int rank){
        ArrayList<College> cs = new ArrayList<College>();
        for(College c : colleges){
            if(c.getRank() == rank){
                cs.add(c);
            }
        }
        if (cs.isEmpty()){
            return null;
        }
        return cs;
    }

    public static ArrayList<College> findHighestRanked(){
        ArrayList<College> cs = new ArrayList<College>();
        for(College c : colleges){
            if(c.getRank() == 1){
                cs.add(c);
            }
        }
        return cs;
    }
}
