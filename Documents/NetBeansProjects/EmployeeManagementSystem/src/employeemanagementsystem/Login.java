
package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String username=userText.getText();
            String password=passText.getText();
            DaoLayer dao = new DaoLayer();
            ResultSet rs =dao.LoginAuthentication(username, password);
            if(rs.next()){
                setVisible(false);
                new Home1();
            }
            else{
                JOptionPane.showMessageDialog(null, "invalid Username and Password");
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    JTextField userText;
    JTextField passText;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel username=new JLabel("USERNAME ");
        username.setBounds(40,20, 100, 30);
        add(username);
        
         userText = new JTextField();
        userText.setBounds(150,20,150,30);
        add(userText);
        
        JLabel password=new JLabel("PASSWORD ");
        password.setBounds(40,70, 100, 30);
        add(password);
        
          passText = new JTextField();
        passText.setBounds(150,70,150,30);
        add(passText);
        
        JButton login=new JButton("LOGIN");
        login.setBounds(150, 120, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(450 ,250);
        setVisible(true);
         setTitle("Employee Management System");
    }
    public static void main(String[] args) {
        new Login();
    }   
}
