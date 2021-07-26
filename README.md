# Bank_Account_Management_System
It is a project about Bank Account Management System using Java and DBMS. The main purpose of this project is to perform various banking tasks and to  make a secure automated system which will keep the banking records of any  person secure and safe.

***Problem Statement***

      The main purpose of this project is to perform various banking tasks and to
      make a secure automated system which will keep the banking records of any
      person secure and safe.
      It can do the following job automatically,
       View existing details
       To add a new details of a person
       Deleting any record
       Search any particular record of any person based on his or her account
      number
      These are our problem statement that we are solving using java and oracle
      database.

***Solution***

      To overcome these problem we need to do,
       First we have created needed table in Oracle database
       Then create java file to add new record
       Create java file to delete any specific record
       Search any particular record of any person with his or her account
      number with SQL command.
      Lastly we have made only one java file containing solutions of all the problem
      statements.

***Methods and Algorithm***

       We have made this project with the help of Oracle, and notepad jdk platform(
      any others also work on this project). We have to set the environments first
      to make the project successful. First we have created three tables of Bank
      named Bank Account, Branch, Loan in Oracle with SQL commands, to store
      the all banking information of any person. Then we have inserted and
      deleted required data of a person using JAVA .
       Now the important thing is to connect the JAVA files with Oracle database
      that are Bank Account, Branch, Loan. For that we need JDBC driver for SQL
      which will make the connection in between the JAVA files and the Database.
       The con.java is the main connection file for this project without which we
      cannot make any connection between database and JAVA.
      In our project there are three database tables.
       First one is ‘Bank Account’ contains of nine(9) attributes these are
      Account number(PRIMARY KEY), Account_holder_firstname,
      Account_holder_lastname, Gender, Date_of_birth, Mobile_number, Address,
      Account type and Balance. Based on these nine attributes we have taken the
      information of any account holder and stored it in the database.
       Second one is Branch database table containing three attributes that are
      Branch_name, Branch city and Assets.
       Third one is Loan database table that containing three attributes those are
      Loan_number, Branch_name and Amount.

***Conclusion and Discussion***

      In this project we have taken data of any bank account holder, stored them safely in a
      accurate and efficient way for any future purpose. All the procedures have been working
      correctly. It provides all necessary information to the customers with the use of this
      system. One can simply sit in front of a system and easily monitor all the activities
      without any physical movement. The code is based on accurately,
       Adding new data in the database
       View existing table
       Deleting any record
      So, we can conclude that the project has done correctly and implemented successfully to
      do aforementioned procedures.
