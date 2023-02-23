import java.util.Scanner;
import java.util.regex.Pattern;

public class Start {

    private static Do services; // to use it in every method (make it easier)

    public static College createCollege() {
        College college = new College("Computer and information system", "Makkah");
        Start.services = new Do(college);
        return college;
    }

    public static void start() {
        College college = Start.createCollege();

        System.out.println(
                "=======  WELCOME TO  THE COLLEGE OF " + college.getName().toUpperCase() + " , "
                        + college.getBranch().toUpperCase()
                        + " Branch  ======\n");

        int choiceNum;
        int choiceNum2;
        boolean play = true;
        while (play == true) {

            System.out.println("\n-----Waht do you want to do?----\n");

            System.out.println("{1} : Add & del menu");
            System.out.println(" ---   ---   ---");
            System.out.println("{2} : Search menu");
            System.out.println(" ---   ---   --- ");
            System.out.println("{3} : Display all inforamtion");
            System.out.println(" ---   ---   --- ");
            System.out.println("{4} : EXIT ");
            System.out.print("\nENTER NUMBER : ");

            choiceNum = Start.validChoice4(InputMismatchException());

            System.out.println("--------------------------------");

            if (choiceNum == 1) {
                System.out.println("--------------------------------");
                System.out.println("\n{1} : ADD STUDENT");
                System.out.println(" ---   ---   ---");
                System.out.println("{2} : ADD DOCTOR");
                System.out.println(" ---   ---   ---");
                System.out.println("{3} : ADD SPECIALTY");
                System.out.println(" ---   ---   ---");
                System.out.println("{4} : DELETE STUDENT ");
                System.out.println(" ---   ---   ---");
                System.out.println("{5} : DELETE DOCTOR");
                System.out.println(" ---   ---   ---");
                System.out.println("{6} : DELETE SPECIALTY");
                System.out.println(" ---   ---   ---");
                System.out.println("{7} : EXIT ");
                System.out.print("\nENTER NUMBER : ");

                choiceNum2 = Start.validChoice7(InputMismatchException());
                System.out.println("--------------------------------");

                switch (choiceNum2) {
                    case 1:
                        Start.addStudent();
                        printDone();
                        System.out.println("--------------------------------");
                        break;

                    case 2:
                        Start.addDoctor();
                        printDone();
                        System.out.println("--------------------------------");
                        break;
                    case 3:
                        Start.addSpecialty();
                        System.out.println("--------------------------------");
                        break;
                    case 4:
                        Start.removePerson(Action.STUDENT);
                        System.out.println("--------------------------------");
                        break;
                    case 5:
                        Start.removePerson(Action.DOCTOR);
                        System.out.println("--------------------------------");
                        break;
                    case 6:
                        Start.removeSpecialty();
                        System.out.println("--------------------------------");
                        break;
                    case 7:
                        play = Start.exit();
                        break;
                }
            }

            if (choiceNum == 2) {
                System.out.println("\n--------------------------------");
                System.out.println("\n{1} : SEARCH STUDENT BY NAME");
                System.out.println(" ---   ---   ---");
                System.out.println("{2} : SEARCH DOCTOR BY NAME");
                System.out.println(" ---   ---   ---");
                System.out.println("{3} : EXIT ");
                System.out.print("\nENTER NUMBER : ");
                int search = Start.validChoice3(InputMismatchException());
                System.out.println("--------------------------------");

                // Scanner search = new Scanner(System.in);
                switch (search) {
                    case 1:
                        Start.printDataPersonByName(Action.STUDENT);
                        break;
                    case 2:
                        Start.printDataPersonByName(Action.DOCTOR);
                        break;
                    case 3:
                        play = Start.exit();
                }
            }

            if (choiceNum == 3) {
                // SHOW ALL MENU---<>
                System.out.println("\n--------------------------------");
                System.out.println("{1} : SHOW ALL STUDENTS IN COLLEGE ");
                System.out.println(" ---   ---   ---");
                System.out.println("{2} : SHOW ALL DOCTORS IN COLLEGE");
                System.out.println(" ---   ---   ---");
                System.out.println("{3} : SHOW ALL SPECIALTYS IN COLLEGE");
                System.out.println(" ---   ---   ---");
                System.out.println("{4} : EXIT ");
                System.out.print("\nENTER NUMBER : ");
                int c = Start.validChoice4(InputMismatchException());
                System.out.println("--------------------------------");

                switch (c) {

                    case 1:
                        showAllStudents();
                        break;
                    case 2:
                        showAllDoctors();
                        break;
                    case 3:
                        showAllSpecialtys();
                        break;
                    case 4:
                        play = Start.exit();
                        break;

                }
            }

            if (choiceNum == 4)
                play = Start.exit();

        }

    }
    // Adding section :
    public static void addSpecialty() {
        System.out.print("Enter a Specialty Name : ");
        services.addSpecialty(stringScanning());
    }

    public static void addDoctor() {
        Doctor doctor = new Doctor();
        Start.setPerson(doctor);
        Start.services.addDoctor(doctor);
    }

    public static void addStudent() {
        Student student = new Student();
        Start.setPerson(student);
        Start.services.addStudent(student);
    }
    // Set All information , After addign student or doctor.
    public static void setPerson(Person p) {

        // set name
        p.setName(validateName());

        // set age
        p.setAge(validateAge());

        // set id
        p.setId(validateId());

        // set specialty
        p.setSpecialty(validateSpecialty());

        // set email
        p.setEmail(validatEmail());

        if (p instanceof Doctor) {

            ((Doctor) p).setSalary(validatSalary());

        } else;
    }

    // remove section
    public static void removePerson(Action action) { // used action class To determine if the person is a student or a doctor
        Person p = Start.findPersonByName(action);
        if (p instanceof Student) {
            Start.services.removeStudent((Student) p);
        } else {
            Start.services.removeDoctor((Doctor) p);
        }
    }

    public static void removeSpecialty() {
        String a = Start.findSpecialtyByName();
        Start.services.removeSpecialty(a);
    }

    // Searchig section :
    public static Person findPersonByName(Action action) {
        System.out.print("\nENTER THE NAME : ");
        String name = stringScanning();
        if (name == null) {
            System.out.println(" You must write!! ");
        }
        Person p;
        if (action == Action.STUDENT) {
            p = Start.services.getStudentByName(name);
        } else {
            p = Start.services.getDoctorByName(name);
        }
        return p;
    }

    // show person information
    public static void printDataPerson(Person p) {
        System.out.println("\n-- RESULT OF SEARCHING : ");
        if (p == null) {
            System.out.println(" NOT FOUND !!! ");
        } else {
            System.out.println("");
            System.out.println(p.getData());
        }
    }
    // determine the person 
    public static void printDataPersonByName(Action action) {
        Person p = Start.findPersonByName(action);
        Start.printDataPerson(p);
    }


    public static String findSpecialtyByName() {
        System.out.print("\nENTER THE NAME : ");
        String a = Start.services.getBySpecialtyName(stringScanning());
        if (a == null) {
            System.out.println(" \n Not Found!!! \n");
            return "";
        } else {
            return a;
        }
    }

    // SHOW METHODES
    public static void showAllSpecialtys() {
        Start.services.showAllSpecialtys();
    }

    public static void showAllDoctors() {
        Start.services.showAllDoctors();
    }

    public static void showAllStudents() {
        Start.services.showAllStudents();
    }

    // Stop the program
    public static boolean exit() {
        return false;
    }
    // Validating section :
    public static int validChoice4(int choiceNum) {

        if (choiceNum < 1 || choiceNum > 4) {
            System.out.println(" [[[[NOT VALID OPTION , YOU CAN ONLY ENTER BETWEEN 1-4.]]]] ");
            return 0;
        } else {
            return choiceNum;
        }
    }

    public static int validChoice7(int choiceNum) {

        if (choiceNum < 1 || choiceNum > 7) {
            System.out.println(" [[[[NOT VALID OPTION , YOU CAN ONLY ENTER BETWEEN 1-7.]]]] ");
            return 0;
        } else {
            return choiceNum;
        }
    }

    public static int validChoice3(int choiceNum) {

        if (choiceNum < 1 || choiceNum > 3) {
            System.out.println(" [[[[NOT VALID OPTION , YOU CAN ONLY ENTER BETWEEN 1-3.]]]] ");
            return 0;
        } else {
            return choiceNum;
        }
    }
    // Validating
    public static String validateName() {

        String regex = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
        boolean s = true;
        String name;
        do {
            System.out.print("\n Enter name (start with capital letter): ");
            name = stringScanning();
            Pattern pattern = Pattern.compile(regex);
            if (pattern.matcher(name).matches()) { // test the name
                s = false;
            } else {
                System.out.println(" Please type correctly!!!");

            }
        } while (s == true);
        return name;
    }
 

    public static String validateAge() {
        int intAge; boolean loop = true;
        String finalAge = "";
        do {
            System.out.print("\n Enter Age : ");
            intAge = InputMismatchException();
            if (intAge < 18 || intAge > 55 || intAge == 0) {
                System.out.println(" Age is not true, try again");
            } else {
                finalAge = Integer.toString(intAge);
                loop = false;
            }
        } while (loop == true);

        return finalAge;
    }

    public static String validateId() {
        String stringId; boolean loop = true;
        int s;
        do {
            System.out.print("\n Enter National ID : ");
            s = (InputMismatchException());
            stringId = Integer.toString(s);
            if (stringId.length() < 10 || stringId.length() > 10 || stringId == null) {
                System.out.println(" ID is invalid, ID is only 10 numbers!!!");
            } else {
                loop = false;
            }
        } while (loop == true);
        return stringId;
    }

    public static String validateSpecialty() {
        String spe = ""; boolean loop = true;
        int tester = 0;
        int choice = 0;
        do {
            System.out.println("\n      #Choose Specialtys : ");
            System.out.println(" 1 - IS ~> inforamtion system");
            System.out.println(" 2 - CS ~> Computer Science");
            System.out.println(" 3 - CE ~> Computer Engineering\n");
            System.out.print(" Enter : ");
            tester = validChoice3(InputMismatchException());
            if (tester == 1 || tester == 2 || tester == 3) {
                choice = tester;
                {
                    switch (choice) {
                        case 1:
                            spe = "IS , inforamtion system";
                            break;

                        case 2:
                            spe = "CS , Computer Science";
                            break;

                        case 3:
                            spe = "CE , Computer Engineering";
                            break;
                    }
                }
                loop = false;
            }
        } while (loop == true);
        return spe;
    }

    public static String validatEmail() {
        boolean loop = true;
        String email;
        do {
            System.out.print("\n Enter an email : ");
            email = stringScanning();
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
                    + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            if (pattern.matcher(email).matches()) {
                loop = false;
            } else {
                System.out.println(" Eamil not valid , plese try again");
            }
        } while (loop == true);
        return email;
    }

    public static int validatSalary() {
        int salary;
        boolean loop = true;
        do {
            System.out.print("\n Enter Salary : ");
            salary = InputMismatchException();
            if (salary < 6550 || salary > 28710) {
                System.out.println("invalid number, salary out of limit");
            } else {
                loop = false;
            }
        } while (loop == true);
        return salary;
    }


    // After adding person;
    public static void printDone() {
        System.out.println("\n - - Added successfully - -");
    }
    
    // scanning section  
    public static int InputMismatchException() {
        // if the user input wrong value
        int tester = 0;
        Scanner inn = new Scanner(System.in);
        try {
            tester = inn.nextInt();
        } catch (Exception e) {
            System.out.println("\n Error");
            inn.next();
        }
        return tester;
    }

    public static int intScanning() {
        int value;
        Scanner scan = new Scanner(System.in);
        value = scan.nextInt();
        return value;
    }

    public static String stringScanning() {
        String value;
        Scanner scan = new Scanner(System.in);
        value = scan.nextLine();
        return value;

    }

}