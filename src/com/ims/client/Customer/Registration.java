package com.ims.client.Customer;

import com.ims.admin.dao.Impl.UserDetailsDAOImpl;
import com.ims.client.HomePage;
import com.ims.model.UserList;

import java.sql.SQLException;
import java.util.Scanner;

public class Registration {
    static UserDetailsDAOImpl userDAO = new UserDetailsDAOImpl();

    public static void CustomerClientmenu() throws SQLException {


        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====================================================== ");
            System.out.println("                1)Register                              ");
            System.out.println("                2)Verification                         ");
            System.out.println("                3)forgotPassword                       ");
            System.out.println("                4)DeleteYourinfo                       ");
            System.out.println("                5)BackHomePage                          ");
            System.out.println("========================================================");
            System.out.print("Enter the choice=");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter User Name=");
                    String uname = sc.next();
                    System.out.print("Enter User Address=");
                    String add = sc.next();
                    System.out.print("Enter User Phone=");
                    long phone = sc.nextLong();
                    System.out.print("Enter email=");
                    String email = sc.next();
                    System.out.print("Enter Password =");
                    String psw = sc.next();
                    UserList user = new UserList(uname, add, phone, email, psw);
                    userDAO.addUser(user);
                    break;
                case 2:
                    System.out.print("Enter your email=");
                    String emaill = sc.next();
                    System.out.print("Enter your password=");
                    String password = sc.next();
                    userDAO.AuthenticationEmailandPassword(emaill, password);
                    break;
                case 3:

                    System.out.print("Enter  email for password recovery=");
                    String un = sc.next();
                    if (userDAO.getPassword(un) != null)
                        System.out.println("Your Password=" + userDAO.getPassword(un));
                    break;
                case 4:
                    System.out.print("Enter your ID=");
                    int did = sc.nextInt();
                    userDAO.deleteUser(did);
                    break;
                case 5:
                    HomePage.main(null);
                    break;

                default:
                    System.out.println("Enter 1 to 4 ");

            }
        }
    }
}




