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
import javax.swing.JSpinner;
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
    private JTextField tfdLocation;
    private JTextField tfdStreet;
    private JTextField tfdEmailFirst;
    private JComboBox<String> cbxProvince;
    private JSpinner spnNumber;
    private JButton btnRegister;
    
    public RegisterClient(final boolean update,final Client client, final int index) {
 ///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
    setUndecorated(true);
	setBounds(100, 100, 702, 461);
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
	    	if (!update)
	    		btnRegister = new JButton("Registrar");
	    	else
	    		btnRegister = new JButton("Modificar");
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!update){
				    String idNumber = formatedID.getText();
				    String name =tfdName.getText();
				    String lastName = tfdLastName.getText();
				    String email= tfdEmailFirst.getText() + "@" + tfdEmailSecond.getText();
				    String phone=formatedPhone.getText();
				    String address = cbxProvince.getSelectedItem().toString() + " " + tfdLocation.getText() + " " + tfdStreet.getText() + " " + spnNumber.getValue().toString();
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
				    }else if (!existingID(idNumber)){
					Admin.getInstance().addClient(new Client(idNumber, name, address, lastName, email,phone));
					JOptionPane.showMessageDialog(null, "¡El cliente ha sido agregado!", "Cliente Agregado", JOptionPane.INFORMATION_MESSAGE, clientIcon);
					MainVisual.getInstance().getMenuPanel().setVisible(false);
					MainVisual.getInstance().getClientsPanel().setVisible(true);
					MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
					MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
					MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
					dispose();
					
				    }
				    else {
						JOptionPane.showMessageDialog(null, "Este cliente ya existe", "Cliente existente", JOptionPane.WARNING_MESSAGE, null);
				    }   
			} else{
				
			    String idNumber = formatedID.getText();
			    String name =tfdName.getText();
			    String lastName = tfdLastName.getText();
			    String email= tfdEmailFirst.getText() + "@" + tfdEmailSecond.getText();
			    String phone=formatedPhone.getText();
			    String address = cbxProvince.getSelectedItem().toString() + " " + tfdLocation.getText() + " " + tfdStreet.getText() + " " + spnNumber.getValue().toString();
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
				Admin.getInstance().getClients().get(index).setAddress(address);
				Admin.getInstance().getClients().get(index).setEmail(email);
				Admin.getInstance().getClients().get(index).setPhone(phone);
				JOptionPane.showMessageDialog(null, "¡El cliente ha sido modificado!", "Cliente Modificado", JOptionPane.INFORMATION_MESSAGE, clientIcon);
				MainVisual.getInstance().getMenuPanel().setVisible(false);
				MainVisual.getInstance().getClientsPanel().setVisible(true);
				MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
				MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
				MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
				dispose();
				
			    }
				
			}
		}
		});
		btnRegister.setBackground(new Color(255, 255, 240));
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
		topPanel.setBounds(0, 0, 710, 29);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		if(update)
			lblNewLabel = new JLabel("Modificar Cliente");
		else
			lblNewLabel = new JLabel("Registrar Cliente");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 1, 141, 27);
		topPanel.add(lblNewLabel);
		
		
		lblClose = new JLabel("New label");
		lblClose.setBounds(672, 3, 26, 26);
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
		panel.setBounds(17, 60, 667, 176);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
	
		tfdName = new JTextField();
		tfdName.setBounds(89, 76, 236, 22);
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
		lblApellidos.setBounds(355, 79, 75, 16);
		panel.add(lblApellidos);
		
		tfdLastName = new JTextField();
		tfdLastName.setColumns(10);
		tfdLastName.setBackground(new Color(230, 230, 250));
		tfdLastName.setBounds(442, 76, 203, 22);
		tfdLastName.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(tfdLastName);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono*:");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelfono.setBounds(355, 128, 75, 16);
		panel.add(lblTelfono);
		
		JLabel lblCorreoElectrnico = new JLabel("Email:");
		lblCorreoElectrnico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCorreoElectrnico.setBounds(12, 128, 75, 16);
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
		formatedPhone.setBounds(442, 125, 203, 22);
		formatedPhone.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(formatedPhone);
		
		
		
		formatedID = new JFormattedTextField(idFormatter);		
		formatedID.setBackground(new Color(230, 230, 250));
		formatedID.setBounds(89, 27, 236, 22);
		formatedID.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(formatedID);
		
		JLabel tfdID = new JLabel("C\u00E9dula*:");
		tfdID.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfdID.setBounds(12, 34, 75, 16);
		panel.add(tfdID);
		
		JLabel label = new JLabel("@");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(218, 128, 18, 16);
		panel.add(label);
		
		tfdEmailSecond = new JTextField();
		tfdEmailSecond.setHorizontalAlignment(SwingConstants.CENTER);
		tfdEmailSecond.setColumns(10);
		tfdEmailSecond.setBackground(new Color(230, 230, 250));
		tfdEmailSecond.setBounds(236, 125, 89, 22);
		panel.add(tfdEmailSecond);
		
		tfdEmailFirst = new JTextField();
		tfdEmailFirst.setHorizontalAlignment(SwingConstants.CENTER);
		tfdEmailFirst.setColumns(10);
		tfdEmailFirst.setBackground(new Color(230, 230, 250));
		tfdEmailFirst.setBounds(89, 125, 117, 22);
		panel.add(tfdEmailFirst);
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setBounds(519, 13, 64, 64);
		panel.add(lblUserIcon);
		lblUserIcon.setIcon(new ImageIcon("src/icons/registerClient2x.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Direcci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(17, 256, 667, 141);
		contentPane.add(panel_1);
		
		JLabel lblCalle = new JLabel("No:");
		lblCalle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCalle.setBounds(562, 89, 30, 16);
		panel_1.add(lblCalle);
		
		JLabel tfdLocal = new JLabel("Localidad:*");
		tfdLocal.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfdLocal.setBounds(12, 88, 75, 16);
		panel_1.add(tfdLocal);
		
		tfdLocation = new JTextField();
		tfdLocation.setHorizontalAlignment(SwingConstants.CENTER);
		tfdLocation.setColumns(10);
		tfdLocation.setBackground(new Color(230, 230, 250));
		tfdLocation.setBounds(99, 86, 203, 22);
		panel_1.add(tfdLocation);
		
		JLabel lblCalle_1 = new JLabel("Calle:");
		lblCalle_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCalle_1.setBounds(320, 89, 45, 16);
		panel_1.add(lblCalle_1);
		
		JLabel lblProvincia = new JLabel("Provincia*:");
		lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProvincia.setBounds(12, 36, 75, 16);
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
		cbxProvince.setBounds(99, 32, 200, 22);

		panel_1.add(cbxProvince);
		
		tfdStreet = new JTextField();
		tfdStreet.setHorizontalAlignment(SwingConstants.CENTER);
		tfdStreet.setColumns(10);
		tfdStreet.setBackground(new Color(230, 230, 250));
		tfdStreet.setBounds(376, 86, 164, 22);
		panel_1.add(tfdStreet);
		
		spnNumber = new JSpinner();
		spnNumber.setBackground(new Color(230, 230, 250));
		spnNumber.setBounds(587, 86, 60, 22);
		panel_1.add(spnNumber);
		
		JLabel lblDominicanIcon = new JLabel("");
		lblDominicanIcon.setBounds(489, 13, 64, 64);
		panel_1.add(lblDominicanIcon);
		lblDominicanIcon.setIcon(new ImageIcon("src/icons/domincan.png"));
		
		JLabel lblParmetros = new JLabel("* -> Par\u00E1metros obligatorios");
		lblParmetros.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblParmetros.setBounds(17, 42, 197, 16);
		contentPane.add(lblParmetros);
	    
	    
	    {
		JButton btnCancel = new JButton("Salir");
		btnCancel.setBackground(new Color(255, 255, 240));
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
	if (update){
		load(client);
		formatedID.setEditable(false);
		tfdName.setEditable(false);
		tfdLastName.setEditable(false);
	}
    }
    private boolean existingID(String ID) {
    	boolean aux = false;
    	for (Client i: Admin.getInstance().getClients()) {
    		if (i.getIdNumber().equals(ID))
    			aux = true;
    	}
    	return aux;
    }
    private void load(Client client){
    	formatedID.setText(client.getIdNumber());
    	tfdName.setText(client.getName());
    	tfdLastName.setText(client.getLastName());
    	String[] aux = client.getEmail().split("@");
    	tfdEmailFirst.setText(aux[0]);
    	tfdEmailSecond.setText(aux[1]);
    	formatedPhone.setText(client.getPhone());
    	String[] aux1 = client.getAddress().split(" ");
    	for (int i=0;i<cbxProvince.getComponentCount();i++){
    		if (cbxProvince.getItemAt(i).equals(aux1[0]));
    			cbxProvince.setSelectedItem(aux1[0]);
    	}
    	tfdLocation.setText(aux1[1]);
    	tfdStreet.setText(aux1[2]);
    	spnNumber.setValue(Integer.valueOf(aux1[3]));
    }
}
