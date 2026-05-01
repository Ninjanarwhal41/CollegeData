import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public static void main(String[] args) throws FileNotFoundException {
    College harvard = new College("harvard", 4, 12343, 1234);
    System.out.println(harvard.getTuition());
    System.out.println(harvard.toString());
    CollegeUtility.loadFromFile("2022 US College Rankings.csv");
    while(true){
        System.out.println(" (A) Add a college\n (B) Get a college by rank\n (C) Find cheapest college\n (D) Sort and list colleges by tuition \n (E) Get the highest ranked college \n (F) Sort and list colleges by enrollment \n (G) Quit program");
        Scanner input = new Scanner(System.in);

        switch(input.nextLine()){
            case "A":
                System.out.print("Enter the college name:");
                String n = input.nextLine();
                System.out.print("Enter the college rank:");
                int r = input.nextInt();
                System.out.print("Enter the college tuition:");
                int t = input.nextInt();
                System.out.print("Enter the college enrollment:");
                int e = input.nextInt();
                CollegeUtility.addCollege(new College(n, r, t, e));
                break;
            case "B":
                System.out.print("Enter the college rank:");
                int rank = input.nextInt();
                ArrayList<College> cs = CollegeUtility.getCollegeByRank(rank);
                if(cs == null){
                    System.out.println("No college found with that ranking");
                }
                else {
                    for (College c : cs) {
                        System.out.println(c);
                    }
                }
                break;
            case "C":
                System.out.println("The cheapest college is " + CollegeUtility.findSmallestTuition());
                break;
            case "D":
                CollegeUtility.sortByTuition();
                break;
            case "E":
                ArrayList<College> cols = CollegeUtility.findHighestRanked();
                for(int  i = 0; i < cols.size(); i++){
                    System.out.println("The highest ranked college is " + cols.get(i).getName());
                    System.out.println("Tuition:" + cols.get(i).getTuition());
                    System.out.println("Enrollment:" + cols.get(i).getEnrollment());
                }
                break;
            case "F:":
                break;
            case "G:":
                System.out.println("Until next time!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please enter a capital letter A-G.");
                break;

        }
    }

}