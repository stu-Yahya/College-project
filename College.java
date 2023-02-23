import java.util.ArrayList;

public class College {

    private String name;
    private String branch;
    private ArrayList<Student> students;  //= new ArrayList<Student>();
    private ArrayList<Doctor> doctors;    //= new ArrayList<Doctor>();
    private ArrayList<String> specialtys; //= new ArrayList<String>();

    public College() {
        this.initObject();
    }

    public College(String name) {
        this.name = name;
        this.initObject();
    }

    private void initObject() {
        this.students = new ArrayList<Student>();
        this.doctors = new ArrayList<Doctor>();
        this.specialtys = new ArrayList<String>();
    }

    public College(String name, String branch) {
        this.name = name;
        this.branch = branch;
        this.initObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setSpecialtys(ArrayList<String> specialtys) {
        this.specialtys = specialtys;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<String> getSpecialtys() {
        return specialtys;
    }
}