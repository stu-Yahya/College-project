
public abstract class Person {
    private String name;
    private String age;
    private String specialty;
    private String email;
    private int salary;
    private String id;

    public Person() {
    }

    // con. to All
    public Person(String name, String age, String specialty, String email) {
        this.name = name;
        this.age = age;
        this.specialty = specialty;
        this.email = email;
    }

    public Person(String name, String age, String specialty, String email, int salary) {
        this.name = name;
        this.age = age;
        this.specialty = specialty;
        this.email = email;
        this.salary = salary;
    }

    // Studnt con.
    public Person(String name, String age, String specialty, String email, String idStuednt) {
        this.name = name;
        this.age = age;
        this.specialty = specialty;
        this.email = email;
        this.id = idStuednt;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getData();
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email= email;

    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String spespecialty) {
        this.specialty = spespecialty;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
