package employeemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    String imgUrl,department;
    DaoLayer dao= new DaoLayer();

    Choice cempid;
    JButton back, remove;

    RemoveEmployee(String imgUrl,String department) {
        this.imgUrl=imgUrl;
        this.department=department;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(30, 40, 150, 20);
        add(heading);

        cempid = new Choice();
        cempid.setBounds(200, 40, 150, 20);
        add(cempid);

        try {
            ResultSet rs = dao.FetchEmployee(department);
            while (rs.next()) {
                cempid.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("EMPLOYEE NAME ");
        name.setBounds(30, 120, 200, 20);
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200, 120, 200, 20);
        tname.setFont(new Font("serif", Font.PLAIN, 15));
        add(tname);

        JLabel designation = new JLabel("DESIGNATION ");
        designation.setBounds(30, 170, 200, 20);
        add(designation);

        JLabel tdesignation = new JLabel();
        tdesignation.setBounds(200, 170, 200, 20);
        tdesignation.setFont(new Font("serif", Font.PLAIN, 15));
        add(tdesignation);

        JLabel email = new JLabel("EMAIL ID ");
        email.setBounds(30, 220, 200, 20);
        add(email);

        JLabel temail = new JLabel();
        temail.setBounds(200, 220, 200, 20);
        temail.setFont(new Font("serif", Font.PLAIN, 15));
        add(temail);

        JLabel phone = new JLabel("PHONE NUMBER ");
        phone.setBounds(30, 270, 200, 20);
        add(phone);

        JLabel tphone = new JLabel();
        tphone.setBounds(200, 270, 200, 20);
        tphone.setFont(new Font("serif", Font.PLAIN, 15));
        add(tphone);

        JLabel empid = new JLabel("EMPLOYEE ID ");
        empid.setBounds(30, 320, 200, 20);
        add(empid);

        JLabel tempid = new JLabel();
        tempid.setBounds(200, 320, 200, 20);
        tempid.setFont(new Font("serif", Font.PLAIN, 15));
        add(tempid);

        back = new JButton("Back");
        back.setBounds(50, 380, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        remove = new JButton("Remove");
        remove.setBounds(170, 380, 100, 30);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        add(remove);

        try {
            ResultSet rs =dao.FetchEmployee(cempid.getSelectedItem(),department);
            while (rs.next()) {
                tname.setText(rs.getString("name"));
                tdesignation.setText(rs.getString("designation"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                tempid.setText(rs.getString("empid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cempid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ae) {
                try {
                    ResultSet rs = dao.FetchEmployee(cempid.getSelectedItem(),department);
                    while (rs.next()) {
                        tname.setText(rs.getString("name"));
                        tdesignation.setText(rs.getString("designation"));
                        tphone.setText(rs.getString("phone"));
                        temail.setText(rs.getString("email"));
                        tempid.setText(rs.getString("empid"));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 0, 600, 400);
        add(image);

        setSize(1000, 500);
        setLocation(300, 150);
        setVisible(true);
         setTitle("Employee Management System");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == remove) {
            try {
                dao.RemoveEmployee(cempid.getSelectedItem(),department);
                setVisible(false);
                new Home2(imgUrl,department);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home2(imgUrl,department);
        }
    }

    public static void main(String[] args) {
//        new RemoveEmployee();
    }
}
