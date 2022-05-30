import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.print.*;



public class Student extends JFrame{
    JLabel l;
    JTextArea i;
    
  public Student(){

    //Set Font
    Font font1 = new Font("Dialog", Font.PLAIN, 26);
    JFrame frame = new JFrame("Student Registration");
    ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\Background.jpg");
    Image img = icon.getImage();
    Image newimg = img.getScaledInstance(1050, 780, img.SCALE_SMOOTH);
    icon = new ImageIcon(newimg);  
    JLabel background = new JLabel(icon);
    JLabel nameJLabel1 = new JLabel("Student Registration System");
    nameJLabel1.setBounds(425,20,350,30);
    nameJLabel1.setFont(font1);
    JLabel namelabel = new JLabel("Student Name:");
	namelabel.setBounds(50,80,130,25);
	JTextField namefield = new JTextField();
	namefield.setBounds(200,80,200,25);
    JLabel IDblabel = new JLabel("Student ID:");
    IDblabel.setBounds(50,120,130,25);
    JTextField IDfield = new JTextField();
    IDfield.setBounds(200,120,200,25);
    JLabel agelabel = new JLabel("Age:");
    agelabel.setBounds(50,160,130,25);
    JComboBox agefield = new JComboBox(new String[] {"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
    agefield.setBounds(200,160,50,25);
    JLabel emaillabel = new JLabel("Email ID:");
    emaillabel.setBounds(50,200,130,25);
    JTextField emailfield = new JTextField();
    emailfield.setBounds(200,200,200,25);
    JLabel phonelabel = new JLabel("Phone Number:");
    phonelabel.setBounds(50,240,130,25);
    JTextField phonefield = new JTextField();
    phonefield.setBounds(200,240,200,25);
    JLabel addresslabel = new JLabel("Address:");
    addresslabel.setBounds(50,280,130,25);
    JTextField addressfield = new JTextField();
    addressfield.setBounds(200,280,200,80);
    JLabel genderlabel = new JLabel("Gender: ");
    genderlabel.setBounds(50, 380, 130,25);
    JRadioButton box = new JRadioButton("Male");
    box.setBounds(200, 380, 100, 25);
    JRadioButton box1 = new JRadioButton("Female");
    box1.setBounds(300,380,100,25);
    JLabel nationLabel = new JLabel("Nationality");
    nationLabel.setBounds(50, 420,130,25);
    JTextField nationfield = new JTextField();
    nationfield.setBounds(200, 420, 200, 25);
    JLabel yearOLabel = new JLabel("Year of Enrollment: ");
    yearOLabel.setBounds(50, 460, 130, 25);
    JComboBox yearOfield = new JComboBox(new String[] {"2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"});
    yearOfield.setBounds(200, 460, 100, 25);
    JLabel yearOSLabel = new JLabel("Year of Studies: ");
    yearOSLabel.setBounds(50, 500, 130, 25);
    JComboBox yearOSfield = new JComboBox(new String[] {"1","2","3"});
    yearOSfield.setBounds(200, 500, 100, 25);
    JLabel programJLabel = new JLabel("Programme: ");
    programJLabel.setBounds(50, 540, 130, 25);
    JComboBox programfield = new JComboBox(new String[] {"SEDSC","SEAIR","SECEF","SECVR","SEIOT"});
    programfield.setBounds(200, 540, 100, 25);

    

    
    //add a reset button
    JButton resetButton = new JButton("Reset");
    resetButton.setBounds(640, 370, 170, 40);
    background.add(resetButton);
    resetButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            namefield.setText("");
            IDfield.setText("");
            agefield.setSelectedIndex(0);
            emailfield.setText("");
            phonefield.setText("");
            addressfield.setText("");
            nationfield.setText("");
            yearOfield.setSelectedIndex(0);
            yearOSfield.setSelectedIndex(0);
            programfield.setSelectedIndex(0);
        }
    });

	background.add(namelabel);
    background.add(nameJLabel1);
    background.add(IDblabel);
    background.add(IDfield);
    background.add(agelabel);
    background.add(agefield);
    background.add(emaillabel);
    background.add(emailfield);
    background.add(phonelabel);
    background.add(phonefield);
    background.add(addresslabel);
    background.add(addressfield);
    background.add(genderlabel);
    background.add(box);
    background.add(box1);
    background.add(nationLabel);
    background.add(nationfield);
    background.add(yearOLabel);
    background.add(yearOfield);
    background.add(yearOSLabel);
    background.add(yearOSfield);
    background.add(programJLabel);
    background.add(programfield);
	background.add(namefield);
	background.setLayout(null);
	frame.add(background);
	
    frame.setDefaultCloseOperation(1);
    frame.setSize(1080, 800);
    frame.setVisible(true);

    //button for Browse file
    JButton btn = new JButton("Browse");
    btn.setBounds(600,285,100,40);
    l = new JLabel();
    l.setBounds(520,85,250,200);
    background.add(btn);
    background.add(l);
    btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filtering files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png");
        file.addChoosableFileFilter(filter);
        int res = file.showSaveDialog(null);
        //if the user clicks on save in Jfilechooser
        if(res == JFileChooser.APPROVE_OPTION){
          File selFile = file.getSelectedFile();
          String path = selFile.getAbsolutePath();
          l.setIcon(resize(path));

        }
      }
    });
  

  //Generate Receipt
  JButton btn1 = new JButton("Generate Receipt");
  btn1.setBounds(470,370,170,40);
  i = new JTextArea();
  i.setBounds(470,410,510,250);
  background.add(btn1);
  background.add(i);
  btn1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
  i.setText("-------------------------------------------------------Fee Receipt---------------------------------------------------------"+ "\n");
  i.setText(i.getText() + "Student Name: " + namefield.getText() + "\n");
  i.setText(i.getText() + "Student ID: " + IDfield.getText() + "\n");
  i.setText(i.getText() + "Age: " + agefield.getSelectedItem() + "\n");
  i.setText(i.getText() + "Email ID: " + emailfield.getText() + "\n");
  i.setText(i.getText() + "Phone Number: " + phonefield.getText() + "\n");
  i.setText(i.getText() + "Program Applied: " + programfield.getSelectedItem() + "\n");
  if(programfield.getSelectedItem()=="SEAIR") {
    i.setText(i.getText()+"Enrolled Education Program is "+"Artificial Intelligence & Industrial Robotic"+"\n");
    
    if(yearOSfield.getSelectedItem()=="1") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM20000"+"\n");
    }
    if(yearOSfield.getSelectedItem()=="2") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM40000"+"\n");
    }
    if(yearOSfield.getSelectedItem()=="3") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM60000"+"\n");
    }

  }else if(programfield.getSelectedItem()=="SEDSC") {
    i.setText(i.getText()+"Enrolled Education Program is "+"Data Science & Commercial Application Development"+"\n");
    
    if(yearOSfield.getSelectedItem()=="1")
    {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM20000"+"\n");
    }
    if(yearOSfield.getSelectedItem()=="2") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM40000"+"\n");
    }
    if(yearOSfield.getSelectedItem()=="3") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM60000"+"\n");
    }
  }else if(programfield.getSelectedItem()=="SECEF") {
    i.setText(i.getText()+"Enrolled Education Program is "+"E-Commerce and Financial Technology"+"\n");
    
    if(yearOSfield.getSelectedItem()=="1") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM15000"+"\n");
    }
    if(yearOSfield.getSelectedItem()=="2") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM30000"+"\n");
    }
    if(yearOSfield.getSelectedItem()=="3") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM45000"+"\n");
    }
}else if(programfield.getSelectedItem()=="SECVR") {
    i.setText(i.getText()+"Enrolled Education Program is "+"Computer Games Development and VR"+"\n");
    
    if(yearOSfield.getSelectedItem()=="1") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM15000"+"\n");
    }
    if(yearOSfield.getSelectedItem()=="2") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM30000"+"\n");
    }
    if(yearOSfield.getSelectedItem()=="3") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM45000"+"\n");
    }
}else if(programfield.getSelectedItem()=="SEIOT") {
    i.setText(i.getText()+"Enrolled Education Program is "+"Internet of thing"+"\n");
    
    if(yearOSfield.getSelectedItem()=="1") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM15000"+"\n");
    }
    if(yearOSfield.getSelectedItem()=="2") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM30000"+"\n");
    }
    if(yearOSfield.getSelectedItem()=="1") {
        i.setText(i.getText()+"Total Fees Payment for "+yearOSfield.getSelectedItem()+" Year is RM45000"+"\n");
    }
}

}	  			  		   
});
  

//button for print
  JButton btn2 = new JButton("Print");
  btn2.setBounds(810,370,170,40);
  background.add(btn2);
    btn2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        try {
            i.print();
        } catch (PrinterException e1) {
            e1.printStackTrace();
        }
        }
    });
  
  }
  // Method to resize the image with the same size of the Jlabel
  public ImageIcon resize(String imgPath)
  {
    ImageIcon path = new ImageIcon(imgPath);
    Image img = path.getImage();
    Image newImg = img.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
  }

  public static void main(String args[]) {

    new Student();


    

  }
}