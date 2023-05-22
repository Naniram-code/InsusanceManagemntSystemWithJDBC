package com.pms.client.Customer;


import com.pms.admin.dao.Impl.CategoryDAOImpl;
import com.pms.admin.dao.Impl.PolicyDAOImpl;
import com.pms.admin.dao.Impl.SubCategoryDAOImpl;
import com.pms.client.HomePage;

import java.sql.SQLException;
import java.util.Scanner;

public class Home {
    static PolicyDAOImpl policyDAOc = new PolicyDAOImpl();
    static SubCategoryDAOImpl subCategoryDAO = new SubCategoryDAOImpl();
    static CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
    static PolicyDAOImpl policyDAO = new PolicyDAOImpl();

    public static void customermenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("====================================================");
            System.out.println("                1)View Category                     ");
            System.out.println("                2)View SubCategory                  ");
            System.out.println("                3)view Policy                       ");
            System.out.println("                4)Registration                      ");
            System.out.println("                5)Back                              ");
            System.out.println("=====================================================");
            System.out.print("Enter the choice=");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    categoryDAO.viewCategory();
                    break;

                case 2:
                    subCategoryDAO.viewSubCategory();
                    break;

                case 3:

                    policyDAO.viewPolicy();
                    break;
                case 4:
                   Registration.CustomerClientmenu();
                    break;
                case 5:
                    HomePage.main(null);
                    break;
                default:
                    System.out.println("Choose 1 to 5 Between");

            }
        }
    }

}




