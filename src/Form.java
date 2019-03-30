import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.FileWriter;


public class Form extends JFrame {

    private Container c;
    private JLabel nameLabel,fnameLabel,mnameLabel,Bgrp,studentId,department,gender;
    private JLabel nationality;
    private JLabel division;
    private JLabel district;
    private JLabel thana;
    private JLabel phone;
    private JTextField ntf,ftf,mtf,sidtf,nationalitytf,districttf,thanatf,phonetf;
    private JComboBox bgbox,depbox,divBox;
    private JRadioButton male,female, other;
    private ButtonGroup group1;
    private Border border;
    private JButton btn;

    private String[] bloodGroup = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
    private String[] departments ={"Computer Science & Engineering","Electrical & Electronic Engineering","Applied Chemistry & Chemical Engineering","Information & Communication Engineering","Applied Physics & Electronic Engineering","Materials Science & Engineering"};
    private String[] divisionName ={"Rajshahi","Dhaka","Chitagong","Mymensingh","Khulna","Barishal","Rangpur","Sylhet"};
    private String sgender;

    Form(){
        initComponent();
    }

    public void initComponent(){
        c = this.getContentPane();
        c.setLayout(null);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(100,80,150,30);
        nameLabel.setOpaque(true);
        c.add(nameLabel);

        ntf = new JTextField();
        ntf.setBounds(250,80,300,30);
        c.add(ntf);

        fnameLabel = new JLabel("Father's Name: ");
        fnameLabel.setBounds(100,120,150,30);
        c.add(fnameLabel);

        ftf = new JTextField();
        ftf.setBounds(250,120,300,30);
        c.add(ftf);

        mnameLabel = new JLabel("Mother's Name: ");
        mnameLabel.setBounds(100,160,150,30);
        c.add(mnameLabel);

        mtf = new JTextField();
        mtf.setBounds(250,160,300,30);
        c.add(mtf);

        studentId = new JLabel("Student ID: ");
        studentId.setBounds(100,200,150,30);
        c.add(studentId);

        sidtf = new JTextField();
        sidtf.setBounds(250,200,300,30);
        c.add(sidtf);

        department = new JLabel("Department: ");
        department.setBounds(100,240,150,30);
        c.add(department);

        depbox = new JComboBox(departments);
        depbox.setBounds(250,240,300,30);
        c.add(depbox);

        Bgrp = new JLabel("Blood Group: ");
        Bgrp.setBounds(100,280,150,30);
        c.add(Bgrp);

        bgbox = new JComboBox(bloodGroup);
        bgbox.setBounds(250,280,100,30);
        c.add(bgbox);

        gender = new JLabel("Gender: ");
        gender.setBounds(100,320,150,30);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(250,320,120,30);
        c.add(male);

        female = new JRadioButton("Female");
        female.setBounds(250,360,120,30);
        c.add(female);

        other = new JRadioButton("Other");
        other.setBounds(250,400,120,30);
        c.add(other);

        group1 = new ButtonGroup();

        group1.add(male);
        group1.add(female);
        group1.add(other);

        nationality = new JLabel("Nationality: ");
        nationality.setBounds(100,450,150,30);
        c.add(nationality);

        nationalitytf = new JTextField("Bangladeshi");
        nationalitytf.setBounds(250,450,200,30);
        c.add(nationalitytf);

        division = new JLabel("Division :");
        division.setBounds(100,490,150,30);
        c.add(division);

        divBox = new JComboBox(divisionName);
        divBox.setBounds(250,490,200,30);
        c.add(divBox);


        district = new JLabel("District :");
        district.setBounds(100,530,150,30);
        c.add(district);

        districttf = new JTextField();
        districttf.setBounds(250,530,200,30);
        c.add(districttf);

        thana = new JLabel("Thana :");
        thana.setBounds(100,570,150,30);
        c.add(thana);

        thanatf = new JTextField();
        thanatf.setBounds(250,570,200,30);
        c.add(thanatf);

        phone = new JLabel("Phone :");
        phone.setBounds(100,610,150,30);
        c.add(phone);

        phonetf = new JTextField();
        phonetf.setBounds(250,610,200,30);
        c.add(phonetf);

        btn = new JButton();
        btn.setText("Save");
        btn.setBounds(250,650,80,35);
        c.add(btn);


        Handler handle = new Handler();

        btn.addActionListener(handle);
        male.addActionListener(handle);
        female.addActionListener(handle);
        other.addActionListener(handle);
    }





    public  class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if(male.isSelected()){
                sgender = male.getText();
            }else if(female.isSelected()){
                sgender = female.getText();
            }else  if(other.isSelected()){
                sgender = other.getText();

            }

            String sname = ntf.getText();
            String sfname = ftf.getText();
            String smname = mtf.getText();
            String sid = sidtf.getText();
            String sdept = depbox.getSelectedItem().toString();
            String sbgrp = bgbox.getSelectedItem().toString();
            String snationality = nationalitytf.getText();
            String sdivition = divBox.getSelectedItem().toString();
            String sdistrict = districttf.getText();
            String sthana = thanatf.getText();
            String sphone = phonetf.getText();

            if(e.getSource() == btn){
                try{
                    BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt",true));
                    bw.write(""+sname+";"+""+sfname+";"+""+smname+";"+sid+";"+sdept+";"+sbgrp+";"+sgender+";"+snationality+";"+sdivition+";"+sdistrict+";"+sthana+";"+sphone);
                    bw.write("\r\n");
                    bw.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"Registration Successful!");

                ntf.setText("");
                ftf.setText("");
                mtf.setText("");
                sidtf.setText("");
                districttf.setText("");
                thanatf.setText("");
                phonetf.setText("");
            }
        }
    }


    public static void main(String[] args) {
        Form frame = new Form();
        frame.setDefaultCloseOperation(Form.EXIT_ON_CLOSE);
        frame.setTitle("Form Fillup");
        frame.setBounds(180,0,800,800);
        frame.setVisible(true);
    }
}
