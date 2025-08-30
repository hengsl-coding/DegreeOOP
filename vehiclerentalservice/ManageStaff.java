package vehiclerentalservice;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageStaff {

    private ArrayList<Staff> staff = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ManageStaff() {
        staff = TextFile.loadStaff();
    }

    public int staffLogin() {
        String id, pass;

        System.out.println("Login");
        System.out.println("=====");
        System.out.print("Enter your id : ");
        id = scanner.nextLine();
        System.out.print("Enter your password : ");
        pass = scanner.nextLine();

        for (int i = 0; i < staff.size(); i++) {
            if (id.equals(staff.get(i).getStaffId()) && pass.equals(staff.get(i).getPassword())) {
                System.out.println("Login Successful!!");
                return i;
            }
        }

        return -1;
    }

     public int staffReg() {
        String id, name, ic, phoneNo, email, ques, answer, pass;

        System.out.println("\nRegister\n========");
        //no duplicate id
        while (true) {
            System.out.print("Id: ");
            id = scanner.nextLine();
            boolean exists = false;
            for (Staff s : staff) {
                if (s.getStaffId().equals(id)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                System.out.println("This ID already exists. Please Enter Again Another ID.");
            } else {
                break;  //no duplicate can use
            }
        }
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Your IC: ");
        ic = scanner.nextLine();
        System.out.print("Enter Youe Phone Number: ");
        phoneNo = scanner.nextLine();
        System.out.print("Enter Your Email: ");
        email = scanner.nextLine();
        System.out.print("Question(Forgot Password): ");
        ques = scanner.nextLine();
        System.out.print("Answer: ");
        answer = scanner.nextLine();
        System.out.print("Set Your Password: ");
        pass = scanner.nextLine();

        Staff temp = new Staff(id, name, ic, phoneNo, email, ques, answer, pass);
        staff.add(temp);

        System.out.println("Register Successful, Login Now!\n");

        return ((staff.size()) - 1);
    }
     
       public int staffForgotPassword() {
        String temp, answer;
        System.out.println("\nForgot Password\n===============");
        System.out.print("Enter your ID : ");
        temp = scanner.nextLine();

        for (int i = 0; i < staff.size(); i++) {
            if (staff.get(i).getStaffId().equals(temp)) {
                System.out.println(staff.get(i).getQuestion());
                System.out.print("Answer : ");
                answer = scanner.nextLine();

                if (staff.get(i).getAnswer().equals(answer)) {
                    System.out.print("Enter new password : ");
                    temp = scanner.nextLine();
                    staff.get(i).setPassword(temp);
                    System.out.println("Change successful!");
                    return i; // successful change
                } else {
                    System.out.println("Wrong answer!");
                    return -1; // answer wrong
                }
            }
        }

        
        System.out.println("ID not found!");
        return -1;
    }

    public int deleteAccount(int loginId) {
        int option;

        System.out.println("Sure to Delete Account (1=yes, 0= no) : ");
        option = validation(0, 1);
        if (option == 1) {
            staff.remove(loginId);
            return 1;
        }
        return 0;
    }

    public int staffDetail(int loginId) {
        int option, temp, x;
        String data;

        System.out.println("Staff Detail\n============");
        System.out.println(staff.get(loginId).toString());
        System.out.println("Modify\n======");
        System.out.println("1. Name");
        System.out.println("2. Question");
        System.out.println("3. Answer");
        System.out.println("4. Delete");
        System.out.println("5. Back");

        option = validation(1, 5);

        switch (option) {
            case 1:
                data = modifyString("Name");
                staff.get(loginId).setName(data);
                System.out.println("Modify Successful!!");
                break;
            case 2:
                data = modifyString("Question");
                staff.get(loginId).setQuestion(data);
                System.out.println("Modify Successful!!");
                break;
            case 3:
                data = modifyString("Answer");
                staff.get(loginId).setAnswer(data);
                System.out.println("Modify Successful!!");
                break;
            case 4:
                x = deleteAccount(loginId);
                if (x == 1) {
                    return 1;
                }
                break;
            case 5:
                break;
        }
        return 0;
    }

    public String modifyString(String what) {
        String data;
        System.out.print("Enter new " + what + " :");
        data = scanner.nextLine();

        return data;
    }

    public int modifyInt(String what) {
        int data;
        System.out.print("Enter new " + what + " :");
        data = scanner.nextInt();

        return data;
    }
    
        public void staffMenu(int loginId) {
        int option, x = 0;

        do {
            System.out.println("\nWelcome " + staff.get(loginId).getName());
            System.out.println("===========================");
            System.out.println("1. Manage Staff");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. Staff Details");
            System.out.println("5. Logout");

            option = validation(1, 5);

            switch (option) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    staffDetail(loginId);
                    break;
                case 5:
                    System.out.println("Logout successful!");

            }
        } while (option != 5);

        TextFile.writeStaff(staff);
    }

    public void back() {
        String q;
        System.out.print("Press <Enter> to back...");
        q = scanner.nextLine();
    }

    public int validation(int min, int max) {
        int option;

        while (true) {
            System.out.print("Enter option (" + min + "-" + max + ") > ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid Enter !");
                scanner.next();
            } else {
                option = scanner.nextInt();
                scanner.nextLine();

                if (option < min || option > max) {
                    System.out.println("Invalid Enter !");
                } else {
                    break;
                }
            }
        }

        return option;
    }

}
