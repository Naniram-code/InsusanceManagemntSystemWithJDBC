package com.ims.client;

import com.ims.admin.dao.Impl.UserDetailsDAOImpl;
import com.ims.admin.dao.Impl.UserStatusDAOImpl;
import com.ims.client.Customer.Home;
import com.ims.client.Customer.Registration;
import com.ims.client.Customer.UserDashBoard;
import com.ims.client.admin.Admin;


import java.sql.SQLException;
import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) throws SQLException {
        UserStatusDAOImpl userStatusDAO = new UserStatusDAOImpl();
        UserDetailsDAOImpl userDAO = new UserDetailsDAOImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======================================================");
            System.out.println("                1)Home                                 ");
            System.out.println("                2)SignIn                               ");
            System.out.println("                3)SignOut                               ");
            System.out.println("                4)exit                                  ");
            System.out.println("========================================================");
            System.out.print("Enter the choice=");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Home.customermenu();
                    break;
                case 2:
                    System.out.print("Enter  login email:");
                    String em = sc.next();
                    System.out.print("Enter  login password:");
                    String psw = sc.next();
                    int uRole = userDAO.AuthenticationAdminaAndUser(em,psw);
                    if (uRole == 1)
                        Admin.adminPage();
                    else if (uRole == 2)
                        {System.out.println("Welcome to DashBoard");
                        UserDashBoard.UserDashBoardmenu();}
                    else {
                        System.out.print("invalid  email or Password ");
                    }
                case 3:
                    Registration.CustomerClientmenu();
                    break;
                case 4:
                    System.out.println("*******************Thanks For Using Apps****************");
                    System.exit(0);

                default:
                    System.out.println("Enter 1 to 4 ");
            }

        }
    }
}






