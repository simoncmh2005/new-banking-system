package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, dobTextField, phoneTextField, emailTextField,addressTextField, cityTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    Date birthDate;
    
    SignupOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290,80,400,40);
        add(personDetails);
        
        JLabel lastname = new JLabel("Last Name:");
        lastname.setFont(new Font("Raleway", Font.BOLD, 20));
        lastname.setBounds(100,140,200,30);
        add(lastname);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel firstname = new JLabel("First Name");
        firstname.setFont(new Font("Raleway", Font.BOLD, 20));
        firstname.setBounds(100,200,200,30);
        add(firstname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300,200,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of birth");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,260,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 260, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,320,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 320, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 320, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setFont(new Font("Raleway", Font.BOLD, 20));
        phone.setBounds(100,380,200,30);
        add(phone);
        
        phoneTextField = new JTextField();
        phoneTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        phoneTextField.setBounds(300,380,400,30);
        add(phoneTextField);
        
        JLabel email = new JLabel("Email Address");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,440,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300,440,400,30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital status");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,500,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 500, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 500, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630, 500, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,560,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300,560,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,620,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300,620,400,30);
        add(cityTextField);
                
        next = new JButton ("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random; //long
        String lastname = nameTextField.getText(); // setText
        String firstname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年M月d日"); // Update date format pattern
        Date birthDate; // Declare the birthDate variable
        try {
            birthDate = dateFormat.parse(dob); // Parse the date of birth string
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        
        try{
            if(lastname.equals("")){
                JOptionPane.showMessageDialog(null, "Last name is Required");
            }else if(!lastname.matches("[a-zA-Z]+")){
                JOptionPane.showMessageDialog(null, "Last name should only contain characters");
            }else if(firstname.equals("")){
                JOptionPane.showMessageDialog(null, "First name is Required");
            }else if(!firstname.matches("[a-zA-Z]+")){
                JOptionPane.showMessageDialog(null, "First name should only contain characters");
            }else if(birthDate != null){
                Date cutoffDate = new Date();
                cutoffDate.setYear(cutoffDate.getYear() - 18);

                if (birthDate.after(cutoffDate)) {
                    JOptionPane.showMessageDialog(null, "Only adults can open a bank account.");
                }
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+lastname+"','"+firstname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"')";
                //String query1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }   
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    

    public static void main(String args[]) {
        new SignupOne();
    }
}
