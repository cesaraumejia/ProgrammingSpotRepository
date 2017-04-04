package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Logico.Admin;
import Logico.Client;

public class RegisterClient extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPane = new JPanel();
    private JPanel topPanel;
    private int x;
    private int y;
    private JLabel lblNewLabel;
    private JLabel lblClose;
    private ImageIcon windowsCloseIcon =new ImageIcon("src/icons/close.png");
    private ImageIcon workerIcon = new ImageIcon("src/icons/worker.png");
    private ImageIcon contractIcon =new ImageIcon("src/icons/contract.png");
    private ImageIcon clientIcon = new ImageIcon("src/icons/client.png");
    private JTextField tfdName;
    private JTextField tfdLastName;
    private JFormattedTextField formatedPhone;
    private JFormattedTextField formatedID;
    private JTextField tfdEmailSecond;
    private JTextField tfdNumber;
    private JTextField tfdLocation;
    private JTextField tfdStreet;
    private JTextField tfdEmailFirst;
    private JComboBox<String> cbxProvince;
    
    public RegisterClient() {
 ///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
    	setUndecorated(true);
	setBounds(100, 100, 1050, 597);
	getContentPane().setLayout(new BorderLayout());
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	contentPane.setBackground(new Color(220, 220, 220));
	getContentPane().add(contentPane, BorderLayout.CENTER);
	super.getToolkit().getScreenSize(); 
	this.setResizable(false);
	setLocationRelativeTo(null);
	setModal(true);
////////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
	{
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBackground(new Color(220, 220, 220));
	    buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
		JButton btnRegister = new JButton("Registrar");
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String idNumber = formatedID.getText();
			    String name =tfdName.getText();
			    String lastName = tfdLastName.getText();
			    String email= tfdEmailFirst.getText() + "@" + tfdEmailSecond.getText();
			    String phone=formatedPhone.getText();
			    String address = cbxProvince.getSelectedItem().toString() + " " + tfdLocation.getText() + " " + tfdStreet.getText() + " " + tfdNumber.getText();
			    if(idNumber.equalsIgnoreCase("___-_______-_")){
				JOptionPane.showMessageDialog(null, "Asegurese de introducir una cédula", "No se ha encontrado Cédula", JOptionPane.WARNING_MESSAGE, null);
			    }else if(name.equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Recuerde introducir un nombre", "No se ha encontrado un nombre", JOptionPane.WARNING_MESSAGE, null);
			    }else if(lastName.equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Recuerde introducir un apellido", "No se ha encontrado un apellido", JOptionPane.WARNING_MESSAGE, null);
			    }else if(tfdEmailFirst.getText().equalsIgnoreCase("") || tfdEmailSecond.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Asegurese de que el email esté escrito correctamente", "No se ha encontrado un email correcto", JOptionPane.WARNING_MESSAGE, null);
			    }else if(phone.equalsIgnoreCase("___-___-____")){
				JOptionPane.showMessageDialog(null, "Recuerde introducir un teléfono", "No se ha encontrado un teléfono", JOptionPane.WARNING_MESSAGE, null);
			    }else if(cbxProvince.getSelectedIndex()<1){
				JOptionPane.showMessageDialog(null, "Asegurese de seleccionar una provincia", "Provincia no válida", JOptionPane.WARNING_MESSAGE, null);
			    }else if(tfdLocation.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Asegurese de introducir una localidad", "No se ha encontrado una localidad", JOptionPane.WARNING_MESSAGE, null);
			    }else {
				Admin.getInstance().addClient(new Client(idNumber, name, address, lastName, email,phone));
				JOptionPane.showMessageDialog(null, "¡El cliente ha sido agregado!", "Cliente Agregado", JOptionPane.INFORMATION_MESSAGE, clientIcon);
				MainVisual.getInstance().getMenuPanel().setVisible(false);
				MainVisual.getInstance().getClientsPanel().setVisible(true);
				MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
				MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
				MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
				dispose();
				
			    }
			   
			    
			    
			}
		});
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setActionCommand("OK");
		buttonPane.add(btnRegister);
		getRootPane().setDefaultButton(btnRegister);
	    }
	    
	    	topPanel = new JPanel();
	    	topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		topPanel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
		        java.awt.Point point = MouseInfo.getPointerInfo().getLocation();
		        setLocation(point.x - x, point.y - y);
			}
		});
		topPanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
		        x = e.getX();
		        y = e.getY();
			}
		});
		contentPane.setLayout(null);
		topPanel.setBounds(0, 0, 1050, 29);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Registrar Cliente");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 1, 141, 27);
		topPanel.add(lblNewLabel);
		
		
		lblClose = new JLabel("New label");
		lblClose.setBounds(1025, 3, 26, 26);
		topPanel.add(lblClose);
		lblClose.addMouseListener(new MouseAdapter() {   
			public void mouseReleased(MouseEvent e) {
			    	MainVisual.getInstance().getMenuPanel().setVisible(false);
				MainVisual.getInstance().getClientsPanel().setVisible(true);
				MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
				MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
				MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
				dispose();
			}
		});
		lblClose.setIcon(windowsCloseIcon);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Personales", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 103, 1028, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
	
		tfdName = new JTextField();
		tfdName.setBounds(99, 76, 203, 22);
		panel.add(tfdName);
		tfdName.setBackground(new Color(230, 230, 250));
		tfdName.setHorizontalAlignment(SwingConstants.CENTER);

		tfdName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setBounds(12, 79, 75, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidos.setBounds(333, 30, 75, 16);
		panel.add(lblApellidos);
		
		tfdLastName = new JTextField();
		tfdLastName.setColumns(10);
		tfdLastName.setBackground(new Color(230, 230, 250));
		tfdLastName.setBounds(420, 27, 203, 22);
		tfdLastName.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(tfdLastName);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono*:");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelfono.setBounds(333, 79, 75, 16);
		panel.add(lblTelfono);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo Electr\u00F3nico:");
		lblCorreoElectrnico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCorreoElectrnico.setBounds(648, 27, 140, 16);
		panel.add(lblCorreoElectrnico);
		
		MaskFormatter phoneFormatter = null ;
		MaskFormatter idFormatter = null;
	
		
		try {
		    phoneFormatter = new MaskFormatter("###-###-####");
		    phoneFormatter.setPlaceholderCharacter('_');
		    
		    idFormatter = new MaskFormatter("###-#######-#");
		    idFormatter.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		
	
		
		formatedPhone = new JFormattedTextField(phoneFormatter);
		formatedPhone.setBackground(new Color(230, 230, 250));
		formatedPhone.setBounds(420, 76, 203, 22);
		formatedPhone.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(formatedPhone);
		
		
		
		formatedID = new JFormattedTextField(idFormatter);		
		formatedID.setBackground(new Color(230, 230, 250));
		formatedID.setBounds(99, 27, 203, 22);
		formatedID.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(formatedID);
		
		JLabel tfdID = new JLabel("C\u00E9dula*:");
		tfdID.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfdID.setBounds(12, 30, 75, 16);
		panel.add(tfdID);
		
		JLabel label = new JLabel("@");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(909, 27, 18, 16);
		panel.add(label);
		
		tfdEmailSecond = new JTextField();
		tfdEmailSecond.setHorizontalAlignment(SwingConstants.CENTER);
		tfdEmailSecond.setColumns(10);
		tfdEmailSecond.setBackground(new Color(230, 230, 250));
		tfdEmailSecond.setBounds(927, 24, 89, 22);
		panel.add(tfdEmailSecond);
		
		tfdEmailFirst = new JTextField();
		tfdEmailFirst.setHorizontalAlignment(SwingConstants.CENTER);
		tfdEmailFirst.setColumns(10);
		tfdEmailFirst.setBackground(new Color(230, 230, 250));
		tfdEmailFirst.setBounds(780, 24, 117, 22);
		panel.add(tfdEmailFirst);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Direcci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(10, 342, 1028, 135);
		contentPane.add(panel_1);
		
		tfdNumber = new JTextField();
		tfdNumber.setHorizontalAlignment(SwingConstants.CENTER);
		tfdNumber.setColumns(10);
		tfdNumber.setBackground(new Color(230, 230, 250));
		tfdNumber.setBounds(711, 56, 203, 22);
		panel_1.add(tfdNumber);
		
		JLabel lblCalle = new JLabel("No:");
		lblCalle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCalle.setBounds(669, 59, 45, 16);
		panel_1.add(lblCalle);
		
		JLabel tfdLocal = new JLabel("Localidad:*");
		tfdLocal.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfdLocal.setBounds(12, 82, 75, 16);
		panel_1.add(tfdLocal);
		
		tfdLocation = new JTextField();
		tfdLocation.setHorizontalAlignment(SwingConstants.CENTER);
		tfdLocation.setColumns(10);
		tfdLocation.setBackground(new Color(230, 230, 250));
		tfdLocation.setBounds(99, 82, 203, 22);
		panel_1.add(tfdLocation);
		
		JLabel lblCalle_1 = new JLabel("Calle:");
		lblCalle_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCalle_1.setBounds(352, 59, 75, 16);
		panel_1.add(lblCalle_1);
		
		JLabel lblProvincia = new JLabel("Provincia*:");
		lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProvincia.setBounds(12, 30, 75, 16);
		panel_1.add(lblProvincia);
		
		cbxProvince = new JComboBox<String>();
		cbxProvince.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", 
			"Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal",
			"Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel",
			"Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "San Crist\u00F3bal", 
			"San Jos\u00E9 De Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "S\u00E1nchez Ramirez", "Santiago",
			"Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
		
		cbxProvince.setBackground(new Color(230, 230, 250));
		((JLabel)cbxProvince.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		cbxProvince.setBounds(99, 30, 200, 22);

		panel_1.add(cbxProvince);
		
		tfdStreet = new JTextField();
		tfdStreet.setHorizontalAlignment(SwingConstants.CENTER);
		tfdStreet.setColumns(10);
		tfdStreet.setBackground(new Color(230, 230, 250));
		tfdStreet.setBounds(439, 56, 203, 22);
		panel_1.add(tfdStreet);
		
		JLabel lblDominicanIcon = new JLabel("");
		lblDominicanIcon.setBounds(493, 280, 64, 64);
		lblDominicanIcon.setIcon(new ImageIcon("src/icons/domincan.png"));
		contentPane.add(lblDominicanIcon);
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setIcon(new ImageIcon("src/icons/registerClient2x.png"));
		lblUserIcon.setBounds(493, 42, 64, 64);
		contentPane.add(lblUserIcon);
		
		JLabel lblParmetros = new JLabel("* -> Par\u00E1metros obligatorios");
		lblParmetros.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblParmetros.setBounds(23, 63, 197, 16);
		contentPane.add(lblParmetros);
	    
	    
	    {
		JButton btnCancel = new JButton("Salir");
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    MainVisual.getInstance().getMenuPanel().setVisible(false);
			    MainVisual.getInstance().getClientsPanel().setVisible(true);
			    MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
			    MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
			    MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
			    dispose();
			}
		});
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);
	    }
	}
    }
}
