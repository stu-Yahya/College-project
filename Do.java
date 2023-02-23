public class Do {

    College college;

    public Do(College college) {
        this.college = college;
    }

    public College getCollege() {
        return college;
    }

    public void addStudent(Student student) {
        this.college.getStudents().add(student);
    }

    public void addDoctor(Doctor doctor) {
        this.college.getDoctors().add(doctor);
    }

    public void addSpecialty(String specialty) {
        this.college.getSpecialtys().add(specialty);
    }

    public void removeStudent(Student student) {
        this.college.getStudents().remove(student);
    }

    public void removeDoctor(Doctor doctor) {
        this.college.getDoctors().remove(doctor);
    }

    public void removeSpecialty(String specialty) {
        this.college.getSpecialtys().remove(specialty);
    }

    public Student getStudentByName(String name) {

        for (Student student : this.college.getStudents()) {
            if (student.getName().toUpperCase().equals(name.toUpperCase())) {
                return student;
            }
        }
        System.out.println(" No one has this name in college");
        return null;
    }

    public Doctor getDoctorByName(String name) {

        for (Doctor doctor : this.college.getDoctors()) {
            if (doctor.getName().toUpperCase().equals(name.toUpperCase())) {
                return doctor;
            }
        }
        System.out.println(" No one has this name in college");
        return null;
    }

    public String getBySpecialtyName(String name) {

        for (String specialty : this.college.getSpecialtys()) {
            if (specialty.toUpperCase().equals(name.toUpperCase())) {
                return specialty;
            }
        }
        return null;
    }

    public void showAllSpecialtys() {
        int index = 1;
        if (getCollege().getSpecialtys().size() == 0){
            System.out.println(" !!! It's empty, nothing has been added before !!! ");
        }else
        
        for (int i = 0; i<getCollege().getSpecialtys().size(); i++) {
            System.out.println(index + "-" + getCollege().getSpecialtys().get(i));
            index++;
        }
    }

    public void showAllStudents() {
        int index = 1;
        if(getCollege().getStudents().size() == 0)
        {
            System.out.println(" !!! It's empty, nothing has been added before !!! ");
        }else
        System.out.println("\n-----ALL STUDENT IN COLLEGE-----");
        for (int i = 0; i < getCollege().getStudents().size(); i++) {
            Student student = getCollege().getStudents().get(i);
            System.out.println(index + "- " + student.getName());
            System.out.println("");
            index++;
        }
    }

    public void showAllDoctors() {
        int index = 1;
        if(getCollege().getDoctors().size() ==0)
        {
            System.out.println(" !!! It's empty, nothing has been added before !!! ");
        }else
        System.out.println("\n-----ALL DOCTOR IN COLLEGE-----");
        for (int i = 0; i<getCollege().getDoctors().size();  i++) {
            Doctor doctor = getCollege().getDoctors().get(i);
            System.out.println(index + "- " + doctor.getName());
            System.out.println("");
            index++;
        }
    }

}