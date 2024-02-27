package BestStudentInTheClass;

public class Student {

    String name;
    Double avgTest;
    Double avgYear;

    public Student(String name, Double avgTest, Double avgYear) {
        this.name = name;
        this.avgTest = avgTest;
        this.avgYear = avgYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAvgTest() {
        return avgTest;
    }

    public void setAvgTest(Double avgTest) {
        this.avgTest = avgTest;
    }

    public Double getAvgYear() {
        return avgYear;
    }

    public void setAvgYear(Double avgYear) {
        this.avgYear = avgYear;
    }

}
