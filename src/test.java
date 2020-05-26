import codegym.controller.regexsearch.RegexSearch;
import codegym.crawl_manager.Crawl_Phone;

import java.io.File;
import java.sql.*;

public class test {
//    public static void main(String[] args) {
//        RegexSearch test = new RegexSearch();
//       String string = "iPhone 11 pro max";
//        boolean result = test.regexSearch(string,"iPhone 11 Pro Max 256GB");
//       System.out.println(result);
//        Crawl_Phone myCrawl = new Crawl_Phone();
//        myCrawl.startThread();
//    }
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Kết nối thành công");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM products";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("productName");
                String code = resultSet.getString("productCode");
                System.out.println(id +" "+code+" "+name);
            }
        } catch (SQLException e) {
            System.err.println("Kết nối thất bại");
            e.printStackTrace();
        }
    }
}
