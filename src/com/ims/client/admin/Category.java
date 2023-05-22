package com.ims.client.admin;


import com.ims.admin.dao.Impl.CategoryDAOImpl;
import com.ims.model.CategoryDetail;


import java.sql.SQLException;
import java.util.Scanner;

public class Category {


    static CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

    public static void categoryDetails() throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======================================================   ");
            System.out.println("                1)AddCategory                            ");
            System.out.println("                2)ViewCategory                           ");
            System.out.println("                3)UpdateCategory                         ");
            System.out.println("                4)Delete                                 ");
            System.out.println("                5)BackAdminPage                                  ");
            System.out.println("======================================================== ");
            System.out.print("Enter the choice=");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.print("Enter Category Name =");
                    String name = sc.next();
                    System.out.print("Enter Category Description=");
                    String ds = sc.next();
                    CategoryDetail cd=new CategoryDetail(name,ds);
                    categoryDAO.addCategory(cd);
                    break;
                case 2:
                      categoryDAO.viewCategory();
                    break;

                case 3:
                   System.out.print("Enter Category Id to update =");
                    int cid = sc.nextInt();
                    categoryDAO.updateCategory(cid);
                    break;
                case 4:
                    System.out.print("Enter Category Id to delete =");
                    int did = sc.nextInt();
                    categoryDAO.deleteCategory(did);
                    break;
                case 5:
                    Admin.adminPage();
                    break;
                default:
                    System.out.println("Choose 1 to 11 Between");

            }
        }
    }

}




