package employeemanagementsystem;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    String imgUrl,department;

    JTextField tname, tfname, tsalary, taddress, tphone, temail, tdesignation, taadhaar;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox teducation;
    JButton add, back;

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) teducation.getSelectedItem();
            String designation = tdesignation.getText();
            String aadhaar = taadhaar.getText();
            String empId = tempid.getText();

            DaoLayer dao= new  DaoLayer();
            dao.AddEmployee(name,fname,dob,salary,address,phone,email,education,designation,aadhaar,empId,department);
            setVisible(false);
            new Home2(imgUrl,department);
            
        } else {
            setVisible(false);
            new Home2(imgUrl,department);
        }
    }

    AddEmployee(String imgUrl,String department) {
        this.imgUrl=imgUrl;
        this.department=department;
        
        Random n = new Random();
        int number = n.nextInt(999999);

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
        name.setFont(new Font("SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        add(tname);

        //father name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);

        //dob
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        add(tdob);

        //salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        add(tsalary);

        //address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);

        //phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        add(tphone);

//        email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        add(temail);

        //education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 170, 30);
        education.setFont(new Font("SERIF", Font.BOLD, 20));
        add(education);

        String courses[] = {"BCA", "B.Tech", "BBA", "BA", "B.Com", "B.Sc", "BJMC", "B.Ed", "MBA", "M.Tech", "M.Sc", "PhD",};

        teducation = new JComboBox(courses);
        teducation.setBounds(600, 300, 150, 30);
        add(teducation);

        //designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        add(tdesignation);

        //aadhar
        JLabel aadhaar = new JLabel("Adhaar Number");
        aadhaar.setBounds(400, 350, 150, 30);
        aadhaar.setFont(new Font("SERIF", Font.BOLD, 20));
        add(aadhaar);

        taadhaar = new JTextField();
        taadhaar.setBounds(600, 350, 150, 30);
        add(taadhaar);

        //employee id
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel("" + number);
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SERIF", Font.PLAIN, 20));
        add(tempid);

        add = new JButton("Add Employee");
        add.setBounds(250, 550, 160, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 160, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 700, Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
         setTitle("Employee Management System");
    }

    public static void main(String[] args) {
//        new AddEmployee();
    }
}
