// when we get some data through website like filling a form and get data then these value pass as a json format
// that case we have to create a json that case we use serialization technique
// we have result in any format data then convert into json format


package Serialization_Deserialization;

public class Serialization {

    //pojo class till getter and setter method (Plain old java class)

    private String name;
    private String job;

    public Serialization(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Serialization{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
