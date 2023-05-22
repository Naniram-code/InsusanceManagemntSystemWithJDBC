package com.ims.client.admin;


import com.ims.admin.dao.Impl.SubCategoryDAOImpl;
import com.ims.model.SubCategoryDetails;


import java.sql.SQLException;
import java.util.Scanner;

public class SubCategory {
    static SubCategoryDAOImpl subCategoryDAO = new SubCategoryDAOImpl();

    public static void subCategoryDetails() throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======================================================  ");
            System.out.println("                1)AddSubCategory                        ");
            System.out.println("                2)ViewSubCategory                       ");
            System.out.println("                3)UpdateSubCategory                     ");
            System.out.println("                4)Delete                                ");
            System.out.println("                5)BackAdminPage                                 ");
            System.out.println("========================================================");
            System.out.print("Enter the choice=");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Sub Category Name =");
                    String name = sc.next();
                    System.out.print("Enter Sub Category  Description=");
                    String ds = sc.next();
                    SubCategoryDetails cd=new SubCategoryDetails(name,ds);
                    subCategoryDAO.addSubCategory(cd);
                    break;
                case 2:
                    if(subCategoryDAO.viewSubCategory()!=null);
                    for (SubCategoryDetails sb:subCategoryDAO.viewSubCategory())
                    {
                        System.out.println("cid: " + sb.getSbid() + ", Name: " + sb.getSbname()
                                + ", Address: " +sb.getDescription());}
                    break;

                case 3:
                    System.out.print("Enter Sub Category ID to update =");
                    int sbid = sc.nextInt();
                    subCategoryDAO.updateSubCategory(sbid);
                    break;
                case 4:
                    System.out.print("Enter Sub Category Id to delete =");
                    int did = sc.nextInt();
                    subCategoryDAO.deleteSubCategory(did);
                    break;
                case 5:
                    Admin.adminPage();
                    break;
                default:
                    System.out.println("Choose 1 to 5 Between");

            }
        }
    }

}






