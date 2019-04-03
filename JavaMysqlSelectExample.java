import java.sql.*;
import java.util.Scanner;

public class JavaMysqlSelectExample {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a variable name");
    String var = sc.nextLine();
    String keyword = "";
    int flag = 0;
      for (int i=0; i<=var.length()-1; i++) {
        if((var.charAt(i) >= 65 && var.charAt(i) <= 90) || (var.charAt(i) >= 97 && var.charAt(i) <= 122) || var.charAt(i) == 95 || var.charAt(i) == 36 || (var.charAt(i) >= 48 && var.charAt(i) <= 57) ) {
          if((var.charAt(0) >= 48 && var.charAt(0) <= 57)){
            flag = 1;
            keyword = " variables cannot start with numbers! ";
          }
        }
        else {
          flag = 1;
          keyword = " variables cannot contain special characters other than $ and _ ";
        }
      }
    try
    {
      // create our mysql database connection
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/var?useSSL=false&allowPublicKeyRetrieval=true";
       Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl,"raz","khanz");
      
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM Keywords";

      // create the java statement
      Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      // iterate through the java resultset
      while (rs.next())
      {
        String word = rs.getString("words");
        if(var.equals(word)) {
          flag = 1;
          keyword = " matches the Keyword " + word;
        }
      }
      st.close();
      if(flag == 0) {
        System.out.println("Valid Variable!");
      }
      else {
        System.out.println("InValid Variable! " + var + keyword);
      }
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
}