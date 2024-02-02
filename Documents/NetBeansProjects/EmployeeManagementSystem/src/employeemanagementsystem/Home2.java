
package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home2 extends JFrame  implements ActionListener  {
    JButton add,view,update,remove,back;
    
    String imgUrl,department;
    
    public Home2(String imgUrl,String department){
        
        this.imgUrl=imgUrl;
        this.department=department;
        
        setLayout(null);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource(imgUrl));
        Image i2=i1.getImage().getScaledInstance(1120, 630, Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading =new JLabel(department+" Management");
        heading.setBounds(650, 20, 400, 40);
        heading.setFont(new Font("segou UI",Font.BOLD,22));
        heading.setForeground(Color.BLACK);
        image.add(heading);
        
         add= new JButton("Add Employee");
        add.setBounds(680, 80 ,160, 40);
        add.addActionListener(this);
        image.add(add);
        
          view= new JButton("View Employee");
        view.setBounds(850, 80 ,160, 40);
         view.addActionListener(this);
        image.add(view);
        
          update= new JButton("Update Employee");
        update.setBounds(680, 140 ,160, 40);
         update.addActionListener(this);
        image.add(update);
        
          remove= new JButton("Remove Employee");
        remove.setBounds(850, 140 ,160, 40);
         remove.addActionListener(this);
        image.add(remove);
        
         back= new JButton(" Back to Main Menu");
        back.setBounds(770, 200 ,160, 40);
         back.addActionListener(this);
        image.add(back);
        
        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
        setTitle("Employee Management System");
    }
    
        @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            setVisible(false);
            new AddEmployee(imgUrl, department);
        }
        else if(ae.getSource() == view){
            setVisible(false);
            new ViewEmployee(imgUrl, department);
        }
        else if(ae.getSource() == update){
             setVisible(false);
            new ViewEmployee(imgUrl, department);
        }
        else if (ae.getSource()==remove){
            setVisible(false);
            new RemoveEmployee(imgUrl, department);
        }
        else{
            setVisible(false);
            new Home1();
        }
    }
    
    public static void main(String[] args) {
    }
}

