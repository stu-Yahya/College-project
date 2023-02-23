

public class Doctor extends Person {


    public Doctor() {
    }


    public Doctor(String name, String age, String specialty, String email) {
        super(name, age, specialty, email);
       
    }

    public String getData() {
        return "NANE : "+ getName()+"\nAGE : "+getAge()+"\nSPECIALTY : "+getSpecialty()
        +"\nEmail : "+getEmail()+"\nNATIONAL ID : "+getId()+"\nSALARY : "+getSalary()+"\n";
    }



    }
