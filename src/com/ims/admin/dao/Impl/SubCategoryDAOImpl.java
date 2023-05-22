package com.ims.admin.dao.Impl;

import com.ims.configure.ConnectionManager;
import com.ims.exception.ExceptionSMS;
import com.ims.admin.dao.SubCategoryDetailsDAO;
import com.ims.model.SubCategoryDetails;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static com.ims.query.QueryConstant.*;

public class SubCategoryDAOImpl implements SubCategoryDetailsDAO {
        static Connection connection = null;
        static Statement statement = null;
        static ResultSet resultSet = null;
        static PreparedStatement preparedStatement = null;
        static Scanner sc = new Scanner(System.in);
        int row = 0;
        static List<SubCategoryDetails> subcategoryDetailList = new LinkedList<>();

        @Override

        public String addSubCategory(SubCategoryDetails subcategoryDetail) throws SQLException {

            try {
                connection = ConnectionManager.getConnection();//1

                preparedStatement = connection.prepareStatement(InsertSubCategory);//2
                preparedStatement.setString(1, subcategoryDetail.getSbname());
                preparedStatement.setString(2, subcategoryDetail.getDescription());

                row = preparedStatement.executeUpdate();//3

                if (row > 0) {
                    throw new ExceptionSMS("Category Added Successfully");
                } else {
                    throw new ExceptionSMS("Category Failed to Add");
                }
            } catch (ExceptionSMS e) {
                System.out.println(e.getMessage());
            } finally {
                ConnectionManager.closeconnection(connection, preparedStatement);
            }
            return null;
        }

        @Override
        public List<SubCategoryDetails> viewSubCategory() throws SQLException {

            try {
                connection = ConnectionManager.getConnection();//1
                preparedStatement = connection.prepareStatement(readSubCategory);//2
                resultSet = preparedStatement.executeQuery();//3
                while (resultSet.next()) {
                    System.out.println("sbid: "+resultSet.getInt(1)+
                                     "   SubCategory: "+resultSet.getString(2)+
                                     "   Descriptions:"+resultSet.getString(3));
                    row++;
                }
                if (row != 0) {
                    throw new ExceptionSMS("View All SubCategory Successfully");
                } else {
                    throw new ExceptionSMS("SubCategory  are not exit");
                }
            } catch (ExceptionSMS e) {
                System.out.println(e.getMessage());

            } finally {
                ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
            }

            return subcategoryDetailList;
        }


        @Override
        public int updateSubCategory(int sbid) throws SQLException {
            try {
                connection = ConnectionManager.getConnection();//1
                System.out.println("Enter 1 for  for update cname 2 for Description=");
                int ch = sc.nextInt();
                if (ch == 1) {
                    preparedStatement = connection.prepareStatement(updateSCsname);//2
                    System.out.println("Enter New SubCategory name for update=");
                    String sbna = sc.next();
                    preparedStatement.setString(1, sbna);
                    preparedStatement.setInt(2, sbid);
                } else {
                    preparedStatement = connection.prepareStatement(updateSCdes);//2
                    System.out.println("Enter New SubCategory for update=");
                    String des = sc.next();
                    preparedStatement.setString(1, des);
                    preparedStatement.setInt(2, sbid);
                }

                row = preparedStatement.executeUpdate();//row update count//3
                if (row > 0) {
                    throw new ExceptionSMS("SubCategory info update Successfully");
                } else {
                    throw new ExceptionSMS("SubCategory info Failed to update");
                }
            } catch (ExceptionSMS e) {
                System.out.println(e.getMessage());
            } finally {
                ConnectionManager.closeconnection(connection, preparedStatement);
            }

            return row;
        }


        @Override

        public int deleteSubCategory(int cid) throws SQLException {
            try {
                connection = ConnectionManager.getConnection();//1
                preparedStatement = connection.prepareStatement(deleteSBC);//2
                preparedStatement.setInt(1, cid);
                row = preparedStatement.executeUpdate();//3
                if (row > 0) {
                    throw new ExceptionSMS("SubCategory Delete Successfully");
                } else {
                    throw new ExceptionSMS("SubCategory Failed to Delete");
                }
            } catch (ExceptionSMS e) {
                System.out.println(e.getMessage());
            } finally {
                ConnectionManager.closeconnection(connection, preparedStatement);
            }
            return 0;
        }

    }