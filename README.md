 Today, as we are living in uncertainty, what may happen tomorrow no one knows, whether it is related to our health or the objects around us that we use in our daily life. So, why not take Insurance. Insurance is all about providing financial safety to the individual. It helps us to enjoy financial security. If we have a proper application to access all the Insurance related activity then it will be cheery on top
to manage Insurance-related activity on a single platform. The admin is the user who can check the list of the insurance holder, can add a category, subcategory, add a policy, and etc. Another role here is that of the user who will be a customer who can view the category, subcategory, policy and can apply for a policy listed therein.
This project has all the necessary functionality that an Insurance management application should have. It is built to support all roles, whether it is policymaker and customer.
Insurance Management System where there are majorly two roles: One is the admin and another one is the customer. Admin who is the main user of this application will add the policy, add the category of Insurance along with the subcategory. Another role is that of customers who will buy the policy from this platform and can view the list of policies he/she holds.
The following are the major objective of this application:
1. To provide a bug-free application to the policymaker(admin) as well as the customer.
2. The main objective is to build a secured, robust Insurance Management system where the policies are managed properly.
3. It maintains the record of customers, policies, buyers’ policies efficiently so that it would be easy to access at any time 24*7.

 Modules and Functionalities of an Insurance Management System
There are two main users of this application. One is the Admin whose responsibility is to manage categories and policies and another role is that of the customer who will buy the policy.
1) Admin
● Admin can VIEW the User list.
● Admin can ADD/VIEW/UPDATE/DELETE Category.
● Admin can ADD/VIEW/UPDATE/DELETE Sub-Category.
● Admin can ADD/VIEW/UPDATE/DELETE Policy.
● Admin can VIEW/ACTIVATE/CANCEL the buyers’ policy request.
2) Customer
● Customers can VIEW the list of Categories.
● Customers can VIEW the list of Sub-Categories.
● Customers can Apply for a Policy.
● Customer can VIEW the list of Policy he/she holds.
NOTE: The profile section, log-in, and registration features are common to all users in the system.

MySQL ##Data 
create Database InsuranceMangementSystem
use InsuranceMangementSystem

      CREATE TABLE Users(
      uid INT NOT NULL AUTO_INCREMENT UNIQUE,
      uname VARCHAR(60),
      address VARCHAR(60),
      phone  BIGINT NOT NULL,
      email VARCHAR (50),
      password VARCHAR (50),
      PRIMARY KEY (iD)
);

select*from Users where uid=2;
# ALTER TABLE  Users RENAME column iD to uid;#Rename     
 # ALTER TABLE  Users RENAME column name to uname;#Rename  
#ALTER TABLE  Users RENAME column login  to email;#Rename 
select*from Users
INSERT INTO  Users (name,address,phone,login,password) VALUES ("Pramod","NYC",1237567890,"abcd","apcd@123"),
                                                                 
select*from Users



CREATE TABLE PolicyList (
    ID INT NOT NULL AUTO_INCREMENT UNIQUE,
    Category VARCHAR(60),
    SubCategory VARCHAR(60),
    Name VARCHAR(60),
    `Sum Assured` BIGINT NOT NULL,
    Premium BIGINT NOT NULL,
    Description VARCHAR(255),
    PRIMARY KEY (ID)
);

select*from PolicyList

CREATE TABLE Category (
    ID INT NOT NULL AUTO_INCREMENT UNIQUE,
    Name VARCHAR(60),
    Description VARCHAR(255),
    PRIMARY KEY (ID)
);

CREATE TABLE SubCategory (
    sbid INT NOT NULL AUTO_INCREMENT UNIQUE,
    sbname VARCHAR(60),
    Description VARCHAR(255),
    PRIMARY KEY (ID)
);

CREATE TABLE MY_Policy_List (
    ID INT NOT NULL AUTO_INCREMENT UNIQUE,
    `User Name` VARCHAR(60),
      email VARCHAR(60),
    `Contact No` BIGINT NOT NULL,
    Category VARCHAR(60),
    `Sub Category` VARCHAR(60),
    Name VARCHAR(60),
    `Sum Assured` BIGINT NOT NULL,
    Premium BIGINT NOT NULL,
    Status VARCHAR(255),
    PRIMARY KEY (ID)
);
INSERT INTO MY_Policy_List (`User name`, `email`, `Contact No`, `Category`, `Sub Category`, `Sum Assured`, `Name`, Premium, `Status`)
VALUES  ("Pramod", "abcd@123", 1237567890, "Home", "Fire", 700000, "ABC", 200, "Active"),


select*from PolicyList
select*from MY_Policy_List
select*from SubCategory
select*from Category
select*from Users


SELECT Users.name FROM  Users #inner joint
INNER JOIN MY_Policy_List 
ON Users.name = MY_Policy_List.`User name`

SELECT Users.name FROM  Users #Left Joint
LEFT JOIN MY_Policy_List
ON Users.name = MY_Policy_List.`User name`

SELECT MY_Policy_List.`User name` FROM  MY_Policy_List #Left Joint
LEFT JOIN Users
ON MY_Policy_List.`User name`=Users.name#list left all and matching namefrom  right Table

#RIGHT JOIN is similar to LEFT JOIN. This join returns all the rows of the table on the right side of the join and 
#matching rows for the table on the left side of the join

SELECT Users.name FROM  Users 
right  JOIN MY_Policy_List
ON Users.name = MY_Policy_List.`User name`

SELECT MY_Policy_List.`User name` FROM  MY_Policy_List
right  JOIN Users
ON Users.name=MY_Policy_List.`User name`

select*from SubCategory
select*from Category

#Alise_Name=AS SubCategory,AS Category

SELECT Category.cname AS CategoryName, SubCategory.sbname AS SubCategoryName
# Category and Subcategory joint=Category INNER JOIN SubCategory ON
FROM Category 
INNER JOIN SubCategory ON Category.cid = SubCategory.sbid;

   
     
#get column Value from two table//Core concept
SELECT t1.uname AS `User Name`, t1.email, t1.phone As `Contact No`,
t2.Category, t2.SubCategory As `Sub Category`, t2.Name, t2.`Sum Assured`, t2.Premium
FROM Users t1
JOIN PolicyList t2 ON t1.uid = 12 AND t2.ID = 12;# for MY_policy_list

#add column with default value
ALTER TABLE Users add column role_ID int(5) default 2;#add column
#update Column

ALTER TABLE Users DROP COLUMN  role_ID;#Delete column
ALTER TABLE Users add column role_ID int(5) default 2;#add column

select*from  MY_Policy_List where ID=4 and Status="Active";

Drop Table product
Select*from Table
show Tables
SELECT CURRENT_TIME;# show current TIME

# add column Time for date and time 
ALTER TABLE MY_Policy_List ADD COLUMN Time TIMESTAMP DEFAULT GATEDATE();















