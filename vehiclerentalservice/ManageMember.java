package vehiclerentalservice;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageMember {

    private ArrayList<Member> member = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ManageMember() {
        member = TextFile.loadMember();
    }

    public int memberLogin() {
        String id, pass;

        System.out.println("\nLogin");
        System.out.println("=====");
        System.out.print("Enter your id : ");
        id = scanner.nextLine();
        System.out.print("Enter your password : ");
        pass = scanner.nextLine();

        for (int i = 0; i < member.size(); i++) {
            if (id.equals(member.get(i).getMemberId()) && pass.equals(member.get(i).getPassword())) {
                System.out.println("Login Successful!!");

                return i;
            }
        }

        return -1;
    }

    public int memberReg() {
        String id, name, ic, phoneNo, email, ques, answer, pass;

        System.out.println("\nRegister\n========");
        //no duplicate id
        while (true) {
            System.out.print("Id: ");
            id = scanner.nextLine();
            boolean exists = false;
            for (Member m : member) {
                if (m.getMemberId().equals(id)) {
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

        Member temp = new Member(id, name, ic, phoneNo, email, ques, answer, pass);
        member.add(temp);

        System.out.println("Register Successful, Login Now!\n");

        return ((member.size()) - 1);
    }

    public int memberForgotPassword() {
        String temp, answer;
        System.out.println("\nForgot Password\n===============");
        System.out.print("Enter your ID : ");
        temp = scanner.nextLine();

        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).getMemberId().equals(temp)) {
                System.out.println(member.get(i).getQuestion());
                System.out.print("Answer : ");
                answer = scanner.nextLine();

                if (member.get(i).getAnswer().equals(answer)) {
                    System.out.print("Enter new password : ");
                    temp = scanner.nextLine();
                    member.get(i).setPassword(temp);
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
            member.remove(loginId);
            return 1;
        }
        return 0;
    }

    public int memberDetail(int loginId) {
        int option, temp, x;
        String data;

        System.out.println("\nMember Detail\n=============");
        System.out.println(member.get(loginId).toString());
        System.out.println("\nModify\n======");
        System.out.println("1. Name");
        System.out.println("2. Question(Forgot Password)");
        System.out.println("3. Answer");
        System.out.println("4. IC");
        System.out.println("5. Phone Number");
        System.out.println("6. Email");
        System.out.println("7. Change Password");
        System.out.println("8. Delete Account");
        System.out.println("9. Back");

        option = validation(1, 9);

        switch (option) {
            case 1:
                System.out.println("Your Current Name Is: " + member.get(loginId).getName());
                data = modifyString("Name");
                member.get(loginId).setName(data);
                System.out.println("Modify Successful!!");
                System.out.println("Your Current Name Is: " + member.get(loginId).getName());
                break;
            case 2:
                System.out.println("Your Current Question Is: " + member.get(loginId).getQuestion());
                data = modifyString("Question");
                member.get(loginId).setQuestion(data);
                System.out.println("Modify Successful!!");
                System.out.println("Your Current Question Is: " + member.get(loginId).getQuestion());
                break;
            case 3:
                System.out.println("Your Current Answer Is: " + member.get(loginId).getAnswer());
                data = modifyString("Answer");
                member.get(loginId).setAnswer(data);
                System.out.println("Modify Successful!!");
                System.out.println("Your Current Answer Is: " + member.get(loginId).getAnswer());
                break;
            case 4:
                System.out.println("Your Current IC Is: " + member.get(loginId).getIc());
                data = modifyString("IC");
                member.get(loginId).setIc(data);
                System.out.println("Modify Successful!!");
                System.out.println("Your Current IC Is: " + member.get(loginId).getIc());
                break;
            case 5:
                System.out.println("Your Current Phone Number Is: " + member.get(loginId).getPhoneNo());
                data = modifyString("Phone Number");
                member.get(loginId).setPhoneNo(data);
                System.out.println("Modify Successful!!");
                System.out.println("Your Current Phone Number Is: " + member.get(loginId).getPhoneNo());
                break;
            case 6:
                System.out.println("Your Current Email Is: " + member.get(loginId).getEmail());
                data = modifyString("Email");
                member.get(loginId).setEmail(data);
                System.out.println("Modify Successful!!");
                System.out.println("Your Current Email Is: " + member.get(loginId).getEmail());
                break;
            case 7:
                System.out.println("Your Current Email Is: " + member.get(loginId).getPassword());
                data = modifyString("Password");
                member.get(loginId).setPassword(data);
                System.out.println("Modify Successful!!");
                System.out.println("Your Current Email Is: " + member.get(loginId).getPassword());
                break;
            case 8:
                x = deleteAccount(loginId);
                if (x == 1) {
                    System.out.println("Delete Successful...");
                    return 1;
                }
                break;
            case 9:
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

    public int validation(int min, int max) {
        int option;

        while (true) {
            System.out.print("\nEnter option (" + min + "-" + max + ") > ");

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

    public void memberMenu(int loginId) {
        int option, x = 0;

        do {
            System.out.println("\nWelcome " + member.get(loginId).getName());
            System.out.println("===========================");
            System.out.println("1. Rent RV");
            System.out.println("2. Rental History");
            System.out.println("3. Bank");
            System.out.println("4. Member Details");
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
                    memberDetail(loginId);
                    break;
                case 5:
                    System.out.println("Logout successful!");

            }
        } while (option != 5);

        TextFile.writeMember(member);
    }

    public void back() {
        String q;
        System.out.print("Press <Enter> to back...");
        q = scanner.nextLine();
    }

}
