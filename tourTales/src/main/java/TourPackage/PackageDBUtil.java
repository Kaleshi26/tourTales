package TourPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PackageDBUtil {

    public Connection dbConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/tourTales";
        String un = "tourTalesAdmin";
        String pw = "Admin@1234";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, un, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public List<T_Package> getAllPPackages() {
        List<T_Package> tpList = new ArrayList<>();
        Connection con = dbConnection();
        
        String query = "SELECT * FROM Package";
        
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
                    
            while (rs.next()) {
                int id = rs.getInt("Pid");
                String packName = rs.getString("Pname");
                String type = rs.getString("Type");
                int days = rs.getInt("days");
                double budget = rs.getDouble("budget");
                
                tpList.add(new T_Package(id, packName, type, days, budget));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tpList;
    }

    public void addNewPackage(T_Package pk) {
        try {
            Connection con = dbConnection();
            String sql = "INSERT INTO Package(Pname,Type,days,budget) VALUES(?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pk.getPackName());
            ps.setString(2, pk.getPackType());
            ps.setInt(3, pk.getDays());
            ps.setDouble(4, pk.getpBudget());
            
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public T_Package selectOldPackage(int id) {
        Connection con = dbConnection();
        T_Package oldPackage = null;
        
        try {
            String sql = "SELECT * FROM Package WHERE Pid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String packName = rs.getString("Pname");
                String type = rs.getString("Type");
                int days = rs.getInt("days");
                double budget = rs.getDouble("budget");
                
                oldPackage = new T_Package(id, packName, type, days, budget);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oldPackage;
    }

    public boolean updateOldPackage(T_Package updatedPackage) {
        Connection con = dbConnection();
        boolean update = false;

        try {
            String sql = "UPDATE Package SET Pname = ?, Type = ?, days = ?, budget = ? WHERE Pid = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, updatedPackage.getPackName());
            ps.setString(2, updatedPackage.getPackType());
            ps.setInt(3, updatedPackage.getDays());
            ps.setDouble(4, updatedPackage.getpBudget());
            ps.setInt(5, updatedPackage.getId());

            int row = ps.executeUpdate();

            if (row > 0) {
                update = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }

    public boolean deletePackage(int id) {
        Connection con = dbConnection();
        boolean delete = false;

        try {
            String sql = "DELETE FROM Package WHERE Pid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int row = ps.executeUpdate();

            if (row > 0) {
                delete = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return delete;
    }
}
