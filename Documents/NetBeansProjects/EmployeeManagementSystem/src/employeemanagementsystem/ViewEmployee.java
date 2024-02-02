package employeemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewEmployee extends JFrame implements ActionListener {
    
    String imgUrl,department;

    JTable table;
    Choice employeeid;
    JButton Search, Print, Update, Back;
    DaoLayer dao= new DaoLayer();

    ViewEmployee(String imgUrl,String department) {
        this.imgUrl=imgUrl;
        this.department=department;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel search = new JLabel("Search by Employee ID");
        search.setBounds(20, 40, 150, 20);
        add(search);

        employeeid = new Choice();
        employeeid.setBounds(180, 40, 150, 20);
        add(employeeid);

        try {
            ResultSet rs = dao.FetchEmployee(department);
            while (rs.next()) {
                employeeid.add(rs.getString("empid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            ResultSet rs = dao.FetchEmployee(department);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 150, 900, 600);
        add(jsp);

        Search = new JButton("Search");
        Search.setBounds(20, 110, 80, 20);
        Search.addActionListener(this);
        add(Search);

        Print = new JButton("Print");
        Print.setBounds(120, 110, 80, 20);
        Print.addActionListener(this);
        add(Print);

        Update = new JButton("Update");
        Update.setBounds(220, 110, 80, 20);
        Update.addActionListener(this);
        add(Update);

        Back = new JButton("Back");
        Back.setBounds(320, 110, 80, 20);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewemp.png"));
        Image i2 = i1.getImage().getScaledInstance(404, 125, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 10, 404, 125);
        add(image);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
         setTitle("Employee Management System");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Search) {
            try {
                ResultSet rs = dao.FetchEmployee(employeeid.getSelectedItem(),department);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        
        else if (ae.getSource() == Print) {
            try {
                table.print();
            } catch (PrinterException ex) {
                Logger.getLogger(ViewEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        else if (ae.getSource() == Update) {
            setVisible(false);
            new UpdateEmployee(employeeid.getSelectedItem(),imgUrl,department);
        } else {
            setVisible(false);
            new Home2(imgUrl,department);
        }
    }

    public static void main(String[] args) {
//        new ViewEmployee();
    }
}
