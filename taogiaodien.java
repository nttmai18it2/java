package student;



import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.*;

import com.mysql.jdbc.Statement;

public class taogiaodien extends JFrame implements ActionListener {
    JLabel lblac ;
    JLabel lblpas ;
    JTextField tfac ; 
    JTextField tfpas ; 
    JButton btnDk ; 
    //tao doi tuong connect
    Connection conn;
    Statement stmt;
    //tao ham connect DB
    public void connectDB() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/studentdbt","root","");
			System.out.println("Connect Success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    
    public taogiaodien() {
    	lblac = new JLabel() ; 
    	lblac.setText(" User name ");
    	tfac  = new JTextField(20) ;
    	lblpas = new JLabel() ;
    	lblpas.setText(" Password ");
    	tfpas = new JTextField(20) ;
    	btnDk = new JButton(" Sign up ");
    	btnDk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					connectDB();
					stmt = (Statement) conn.createStatement();
					int n = stmt.executeUpdate("Insert into Account values('"+tfac.getText() +"','"+tfpas.getText()+"')");
					if (n>0) JOptionPane.showMessageDialog(null, "Success");
					else JOptionPane.showMessageDialog(null, "Fail");
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});  	
    	Container cont = this.getContentPane();
    	setSize(500, 500);
    	cont.setLayout(new FlowLayout());
    	cont.add(lblac);
    	cont.add(tfac);
    	cont.add(lblpas);
    	cont.add(tfpas);
    	cont.add(btnDk);
    	setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new taogiaodien() ;
	}
	public void actionPerformed(ActionEvent e) {
		
		JOptionPane.showMessageDialog(null,"");
	}

}