package sql;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;


public class Greenhouse{

	private JFrame frmGreenhouse;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_1;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Greenhouse window = new Greenhouse();
					window.frmGreenhouse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Greenhouse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmGreenhouse = new JFrame();
		frmGreenhouse.setTitle("Greenhouse");
		frmGreenhouse.setBounds(100, 100, 1029, 585);
		frmGreenhouse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGreenhouse.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_0 = new JLabel("Type (choose one) :");
		lblNewLabel_0.setBounds(10, 12, 110, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_0);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(10, 58, 96, 19);
		frmGreenhouse.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setBounds(10, 113, 45, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setBounds(10, 139, 96, 19);
		frmGreenhouse.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Color :");
		lblNewLabel_2.setBounds(10, 191, 182, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setBounds(24, 227, 96, 19);
		frmGreenhouse.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Flower  ( Yes or No ) :");
		lblNewLabel_3.setBounds(10, 281, 197, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setBounds(24, 322, 96, 19);
		frmGreenhouse.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Seed ( Yes or No ) :");
		lblNewLabel_4.setBounds(236, 23, 260, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setBounds(236, 58, 96, 19);
		frmGreenhouse.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fruit  ( Yes or No ) :");
		lblNewLabel_5.setBounds(236, 113, 294, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setText("");
		textField_5.setBounds(236, 139, 96, 19);
		frmGreenhouse.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Spore  ( Yes or No ) :");
		lblNewLabel_6.setBounds(236, 191, 270, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setText("");
		textField_6.setBounds(236, 227, 96, 19);
		frmGreenhouse.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("id_plant :");
		lblNewLabel_7.setBounds(236, 281, 245, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setText("");
		textField_7.setBounds(236, 322, 96, 19);
		frmGreenhouse.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = null;
				String urlDatabase = "jdbc:postgresql://localhost:5432/test";
				
				try {
					Class.forName("org.postgresql.Driver");
					con = DriverManager.getConnection(urlDatabase, "postgres", "masterkey");
					JOptionPane.showMessageDialog(null,  "Se ha enlazado con exito!");
					java.sql.Statement st = con.createStatement();
					String sql = "INSERT INTO plant(type, name, color, flower, seed, fruit, spore, id_plant)"
							+ "values('"+ textField.getText() + " ',' " + textField_1.getText() + " ',' " + textField_2.getText() + "','" + textField_3.getText() + "','" + textField_4.getText() + "','" + textField_5.getText() + "','" + textField_6.getText() + "','" + textField_7.getText() + "')" ;
					
					st.executeQuery(sql);
					con.close();
					st.close();
					JOptionPane.showMessageDialog(null, "Se ha almacenado con exito!");
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		
		btnNewButton.setBounds(111, 448, 96, 31);
		
		frmGreenhouse.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				String urlDatabase = "jdbc:postgresql://localhost:5432/test";
				try {
					Class.forName("org.postgresql.Driver");
					con = DriverManager.getConnection(urlDatabase, "postgres", "masterkey");
					JOptionPane.showInputDialog(null, "Se ha enlazado con exito!");
					java.sql.Statement st = con.createStatement();
					String sql = "UPDATE plant" + " set type ='" + textField.getText() + "', name ='"+ textField_1.getText() + "', color ='" + textField_2.getText() + "', flower ='"
							+ textField_3.getText() + "', seed ='" + textField_4.getText() +  "', fruit ='" + textField_5.getText() +  "', spore ='"+ textField_6.getText() +  "' WHERE id_plant ='" + textField_7.getText();
					st.executeQuery(sql);
					con.close();
					st.close();
					JOptionPane.showMessageDialog(null,  "Se ha actualizado con exito!");
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		
		
		btnNewButton_1.setBounds(358, 449, 96, 28);
		frmGreenhouse.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				
				String urlDatabase = "jdbc:postgreslq://localhost:5432/test";
				try {
					Class.forName("org.postgresql.Driver");
					con = DriverManager.getConnection(urlDatabase, "postgres", "masterkey");
					JOptionPane.showMessageDialog(null,  "Se ha eliminado con exito!");
					java.sql.Statement st = con.createStatement();
					String sql = "DELETE FROM plant WHERE id_plant'" + textField_7.getText() + "'";
					st.executeQuery(sql);
					con.close();
					st.close();
					JOptionPane.showMessageDialog(null, "Se ha eliminado con exito!");
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});


		btnNewButton_2.setBounds(849, 450, 96, 26);
		frmGreenhouse.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Presentar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				DefaultTableModel modelo = new DefaultTableModel();
				modelo.addColumn("type");
				modelo.addColumn("name");
				modelo.addColumn("color");
				modelo.addColumn("flower");
				modelo.addColumn("seed");
				modelo.addColumn("fruit");
				modelo.addColumn("spore");
				modelo.addColumn("id_plant");

				table_1.setModel(modelo);
				
				String datos[] = new String[7];
				Connection base = null;
				Statement at = null;
				String url = "jdbc:postgresql://localhost:5432/test";
				
				try {
					base = DriverManager.getConnection(url, "postgres", "masterkey");
					at = base.createStatement();
					ResultSet rs = at.executeQuery("SELECT * FROM plant");
					while(rs.next()) {
						datos[0] = rs.getString("type");
						datos[1] = rs.getString("name");
						datos[2] = rs.getString("color");
						datos[3] = rs.getString("flower");
						datos[4] = rs.getString("seed");
						datos[5] = rs.getString("fruit");
						datos[6] = rs.getString("spore");
						datos[7] = rs.getString("id_plant");


						modelo.addRow(datos);

					}
					
					
					JOptionPane.showMessageDialog(null, "Acepta para continuar");
					rs.close();
					at.close();
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_3.setBounds(606, 450, 96, 26);
		frmGreenhouse.getContentPane().add(btnNewButton_3);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setEnabled(false);
		table_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_1.setBounds(685, 22, 285, 356);
		frmGreenhouse.getContentPane().add(table_1);
		
		JLabel lblNewLabel = new JLabel("Gimnospermas");
		lblNewLabel.setBounds(83, 23, 68, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel(" Angiospermas");
		lblNewLabel_8.setBounds(5, 35, 68, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Briofitas");
		lblNewLabel_9.setBounds(83, 35, 45, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Pteridofitas ");
		lblNewLabel_10.setBounds(10, 23, 96, 13);
		frmGreenhouse.getContentPane().add(lblNewLabel_10);

		


	}
}
