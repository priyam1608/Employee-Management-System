
package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home1 extends JFrame  implements ActionListener  {
    JButton IT,prod,sales,finance,exit;

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == IT){
            setVisible(false);
            String imgUrl ="icons/ITDept.jpg";
            String department = "IT Department";
            new Home2(imgUrl,department);
        }
        else if(ae.getSource() == prod){
            setVisible(false);
            String imgUrl ="icons/prod.jpg";
            String department = "Production Department";
            new Home2(imgUrl,department);
        }
        else if(ae.getSource() == sales){
             setVisible(false);
             String imgUrl ="icons/salesDept.jpg";
            String department = "Sales and Marketing Department";
            new Home2(imgUrl,department);
        }
        else if(ae.getSource()==exit){
            System.exit(0);
        }
        else{
            setVisible(false);
            String imgUrl ="icons/financeDept.jpg";
            String department = "Finance Department";
            new Home2(imgUrl,department);
        }
    }
    
    
    
   public  Home1(){
        setLayout(null);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dept.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120, 800, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1120, 800);
        add(image);
        
        JLabel heading =new JLabel("SELECT THE DEPARTMENT");
        heading.setBounds(410, 20, 400, 40);
        heading.setFont(new Font("segou UI",Font.BOLD,22));
        image.add(heading);
        
         IT= new JButton("IT Department");
        IT.setBounds(380, 80 ,180, 40);
        IT.addActionListener(this);
        image.add(IT);
        
          prod= new JButton("Production Department");
        prod.setBounds(580, 80 ,180, 40);
         prod.addActionListener(this);
        image.add(prod);
        
          sales= new JButton("Sales & Marketing Department");
        sales.setBounds(380, 140 ,180, 40);
         sales.addActionListener(this);
        image.add(sales);
        
          finance= new JButton("Finance Department");
        finance.setBounds(580, 140 ,180, 40);
         finance.addActionListener(this);
        image.add(finance);
        
         exit= new JButton("Sign Out");
        exit.setBounds(480, 200 ,180, 40);
         exit.addActionListener(this);
        image.add(exit);
        
        setSize(1120, 800);
        setLocation(250, 50);
        setVisible(true);
        setTitle("Employee Management System");
    }
    public static void main(String[] args) {
        new Home1();
    }
}

