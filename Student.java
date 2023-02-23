public class Student extends Person {
    
    public Student() {
    }

    
    public Student(String name, String age ,int id) {
        super(name, age);
        
    }

    public Student(String name, String age, String specialty, String email, String id) {
        super(name, age, specialty, email, id);
    }


    public Student(String name, String age, String specialty, String email, int id) {
        super(name, age, specialty, email);
        
    }


    @Override
    public String getData() {
        return "NANE : "+ getName()+"\nAGE : "+getAge()+"\nSPECIALTY : "+getSpecialty()
        +"\nEmail : "+getEmail()+"\nNATIONAL ID : "+getId()+"\n";
    }

    
    
}
