package employeemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateEmployee extends JFrame implements ActionListener {
    
    String imgUrl,department;

    JTextField tfname, tsalary, taddress, tphone, temail, tdesignation; // this variables are declared as they are editable
    JLabel tname, tdob, taadhaar, tempid;  // these are not editable
    JComboBox teducation;  // it is also an editable
    JButton update, back;
    String empid;

    DaoLayer dao=new DaoLayer();
    UpdateEmployee(String empid, String imgUrl, String department) {
        this.imgUrl =imgUrl;
        this.department =department;
        this.empid = empid;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        //heading
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(name);

        tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        add(tname);

        //father name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);

        //dob
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(dob);

        tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        add(tdob);

        //salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        add(tsalary);

        //address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);

        //phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        add(tphone);

//        email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        add(temail);

        //education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(education);

        String courses[] = {"BCA", "B.Tech", "BBA", "BA", "B.Com", "B.Sc", "BJMC", "B.Ed", "MBA", "M.Tech", "M.Sc", "PhD",};

        teducation = new JComboBox(courses);
        teducation.setBounds(600, 300, 150, 30);
        add(teducation);

        //designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        add(tdesignation);

        //aadhar
        JLabel aadhaar = new JLabel("Adhaar Number");
        aadhaar.setBounds(400, 350, 150, 30);
        aadhaar.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(aadhaar);

        taadhaar = new JLabel();
        taadhaar.setBounds(600, 350, 150, 30);
        add(taadhaar);

        //employee id
        JLabel empidL = new JLabel("Employee ID");
        empidL.setBounds(50, 400, 150, 30);
        empidL.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(empidL);

        tempid = new JLabel();
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(tempid);

        try { 
            //this try catch is used to parse data from database
            ResultSet rs = dao.FetchEmployee(empid,department);
            System.out.println(rs);
            
            while (rs.next()) {
                // setting the data from database to these labels and textfields
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tdob.setText(rs.getString("dob"));
                tsalary.setText(rs.getString("salary"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                tdesignation.setText(rs.getString("designation"));
                teducation.setSelectedItem(rs.getString("education"));
                taadhaar.setText(rs.getString("aadhaar"));
                tempid.setText(rs.getString("empid"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update Employee");
        update.setBounds(250, 550, 160, 40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(450, 550, 160, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
         setTitle("Employee Management System");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) teducation.getSelectedItem();
            String designation = tdesignation.getText();

            try {
                // this used to update the new details into database
                dao.UpdateEmployee(fname, salary, address, phone, email, education, designation, empid,department);
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
//        new UpdateEmployee("");
    }
}
