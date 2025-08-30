/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vehiclerentalservice;

import java.util.Scanner;

public class VehicleRentalService {

    public static final Scanner scanner = new Scanner(System.in);

    public static void back() {
        String q;
        System.out.print("Press <Enter> to back...");
        q = scanner.nextLine();
    }

    public static int validation(int min, int max) {
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

    public static int mainMenu() {

        int option;
        System.out.println("============================================");
        System.out.println("Welcome To Recreational Cehicle Service System");
        System.out.println("============================================");
        System.out.println("1. Member");
        System.out.println("2. Staff");
        System.out.println("3. Exit");

        option = validation(1, 3);
        return option;
    }

    public static int loginMenu(String who) {
        int option;

        System.out.println(who);
        System.out.println("======");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Forgot Password");
        System.out.println("4. Back");

        option = validation(1, 4);
        return option;
    }

    public static void main(String[] args) {
        ManageMember manageMember = new ManageMember();     
        ManageStaff manageStaff = new ManageStaff();
        int mainMenuOption, loginMenuOption;      // 1=Login,2=Register,3=Forgot,4=Exit
        int loginId;                                        

        do {
            mainMenuOption = mainMenu();

            switch (mainMenuOption) {
                case 1:
                    do {
                        loginMenuOption = loginMenu("\nMember");
                        switch (loginMenuOption) {
                            case 1:
                                loginId = manageMember.memberLogin();
                                if (loginId != -1) {
                                    manageMember.memberMenu(loginId);
//                                    manageMember.memberMenu(loginId, inventory, bank, order);
                                } else {
                                    System.out.println("Login Unsuccessful!!");
                                }
                                break;
                            case 2:
                                loginId = manageMember.memberReg();
//                                manageMember.memberMenu(loginId, inventory, bank, order);
                                break;
                            case 3:
                                loginId = manageMember.memberForgotPassword();
                                if (loginId != -1) {
                                    back();
                                    manageMember.memberMenu(loginId);
//                                    manageMember.memberMenu(loginId, inventory, bank, order);
                                } else {
                                    System.out.println("Login Unsuccessful!!");
                                }
                                break;
                            case 4:
                                break;
                        }
                    } while (loginMenuOption != 4);
                    break;
                case 2:
                    do {
                        loginMenuOption = loginMenu("\nStaff");
                        switch (loginMenuOption) {
                            case 1:
                                loginId = manageStaff.staffLogin();
                                if (loginId != -1) {
                                     manageStaff.staffMenu(loginId);
//                                    manageStaff.staffMenu(loginId, inventory, bank, order, purchase);
                                } else {
                                    System.out.println("Login Unsuccessful!!");
                                }
                                break;
                            case 2:
                                loginId = manageStaff.staffReg();
//                                manageStaff.staffMenu(loginId, inventory, bank, order, purchase);
                                break;
                            case 3:
                                loginId = manageStaff.staffForgotPassword();
                                if (loginId != -1) {
                                    back();
//                                    manageStaff.staffMenu(loginId, inventory, bank, order, purchase);
                                } else {
                                    System.out.println("Login Unsuccessful!!");
                                }
                                break;
                            case 4:
                                break;
                        }
                    } while (loginMenuOption != 4);
                    break;
                case 3:
                    System.out.println("Thank for use!!!");
                    break;
            }
        } while (mainMenuOption != 3);

    }

}
