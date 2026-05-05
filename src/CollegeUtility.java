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
        for(int i = 0; i < colleges.size(); i++){
            int minIndex = i;
            for(int k = i ; k < colleges.size(); k++){
                if(colleges.get(k).getTuition() < colleges.get(minIndex).getTuition()){
                    minIndex = k;
                }
            }
            College temp = colleges.get(i);
            colleges.set(i, colleges.get(minIndex));
            colleges.set(minIndex, temp);
        }
        System.out.println("College sorted by Tuition");
        for (College college : colleges) {
            System.out.println("Name:" + college.getName() + "\nTuition:" + college.getTuition());
        }
    }

    public static void sortByEnrollment(){
        for(int i = 0; i < colleges.size(); i++){
            int minIndex = i;
            for(int k = i; k < colleges.size(); k++){
                if(colleges.get(k).getEnrollment() < colleges.get(minIndex).getEnrollment()){
                    minIndex = k;
                }
            }

            College temp = colleges.get(i);
            colleges.set(i, colleges.get(minIndex));
            colleges.set(minIndex, temp);
        }
        System.out.println("College sorted by Enrollment:");
        for (College college : colleges) {
            System.out.println("Name: " + college.getName() + "\nEnrollment: " + college.getEnrollment());
        }


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
