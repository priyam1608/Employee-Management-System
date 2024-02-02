package employeemanagementsystem;

import com.mysql.cj.util.StringUtils;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DaoLayer {

    public ResultSet LoginAuthentication(String username, String password) {
        try {
            Conn c = new Conn();
            String query = "select * from login where username = '" + username + "'and  password ='" + password + "'";
            ResultSet rs = c.s.executeQuery(query);
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void AddEmployee(String name, String fname, String dob, String salary, String address, String phone, String email, String education, String designation, String aadhaar, String empid, String department) {
        String table =department.toLowerCase().replaceAll("\\s","") ;
        try {
            Conn c = new Conn();
            String query = "insert into "+table +" values ('" + name + "' , '" + fname + "' , '" + dob + "','" + salary + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation + "','" + aadhaar + "','" + empid + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details Added Succcessfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet FetchEmployee(String department) {
        String table =department.toLowerCase().replaceAll("\\s","") ;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from "+table);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet FetchEmployee(String empid,String department) {
        String table =department.toLowerCase().replaceAll("\\s","") ;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from "+table+" where empid =" + empid);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void UpdateEmployee(String fname, String salary, String address, String phone, String email, String education, String designation, String empid,String department) {
        String table =department.toLowerCase().replaceAll("\\s","") ;
        try {
            Conn c = new Conn();
            String query = "update "+table +" set fname = '" + fname + "', salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email =  '" + email + "', education = '" + education + "', designation = '" + designation + "' where empId = '" + empid + "'";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details Updated Succcessfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void RemoveEmployee(String empid,String department){
        String table =department.toLowerCase().replaceAll("\\s","") ;
        try {
                Conn c = new Conn();
                String query = "delete from "+table +" where empid = '" +empid + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Removed Successfully ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
