public class College {
    private String name;
    private int rank;
    private int tuition;
    private int enrollment;

    public College(String name, int rank, int tuition, int enrollment){
        this.name = name;
        this.rank = rank;
        this.tuition = tuition;
        this.enrollment = enrollment;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public String toString(){
        return "Name: " + name + "\nRank:" +  rank + "\nTuition:" + tuition + "\nEnrollment:" + enrollment;
    }
}
