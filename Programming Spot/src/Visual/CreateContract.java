package Visual;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import Logico.Contract;
import Logico.Project;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("unused")
public class CreateContract extends JDialog {

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
    private JLabel lblBuscar;
    private ImageIcon windowsCloseIcon =new ImageIcon(CreateContract.class.getResource("/icons/close.png"));
    private ImageIcon workerIcon = new ImageIcon("src/icons/worker.png");
    private ImageIcon contractIcon =new ImageIcon("src/icons/contract.png");
    private ImageIcon clientIcon = new ImageIcon("src/icons/client.png");

    private JTextField tfdClientName;
    private JTextField proyecto;
    private JTextField tipo;
    private JTextField lenguaje;
    private Project project;
    private JDateChooser fechaInicial;
    private JDateChooser fechaFinal;
    private JLabel priceLabel;
    private Contract contract;
    private JLabel lblCliente;
    private JLabel lblFechaInicial;
    private JLabel lblFechaFinal;
    private JLabel lblId;
    private JLabel IDLabel;
    private JLabel lblPrecio;
    private JLabel label;
    private JLabel lblProyecto;
    private JLabel lblTipo;
    private JLabel lblNewLabel_1;
    private JButton btnCrear;
    private JFormattedTextField formatedClient;
    private boolean foundClient = false;
    private JLabel lblRegistrarContrato;
    /**
     * @param project
     */
    public CreateContract(final Project project, final boolean postpone, final Contract contract, final int index) {
 ///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
    	setUndecorated(true);
	setBounds(100, 100, 577, 368);
	getContentPane().setLayout(null);
	contentPane.setBounds(0, 0, 577, 334);
	contentPane.setBorder(new LineBorder(new Color(112, 128, 144), 2));
	contentPane.setBackground(new Color(220, 220, 220));
	getContentPane().add(contentPane);
	super.getToolkit().getScreenSize(); 
	this.setResizable(false);
	setLocationRelativeTo(null);
	setModal(true);	
	this.project = project;
	this.contract = contract;
////////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
	{
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.addMouseMotionListener(new MouseMotionAdapter() {
	    	@Override
	    	public void mouseMoved(MouseEvent e) {
	    		if (!((JTextField)fechaInicial.getDateEditor().getUiComponent()).getText().equals("") && !((JTextField)fechaFinal.getDateEditor().getUiComponent()).getText().equals("")) {
					if ((validate(fechaInicial) && validate(fechaFinal) && validarFecha()) || postpone) {
						if(!postpone){
							double price = project.calculateBasePrice()*getDays();
		    				priceLabel.setText(String.valueOf(price));	
						}
						else{
							double price = contract.getProject().calculateBasePrice()*getDays();
		    				priceLabel.setText(String.valueOf(price));	
						}
	    				
					}	
	    		}
	    	}
	    });
	    buttonPane.setBounds(0, 329, 577, 39);
	    buttonPane.setBackground(new Color(220, 220, 220));
	    buttonPane.setBorder(new LineBorder(new Color(112, 128, 144), 2));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane);
	    {
	
	    }
	    
	    	topPanel = new JPanel();
	    	topPanel.setBounds(0, 0, 577, 29);
	    	topPanel.setBorder(new LineBorder(new Color(112, 128, 144), 2));
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
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		if (!postpone)
			lblNewLabel = new JLabel("Crear Contrato");
		else
			lblNewLabel = new JLabel("Posponer Contrato");
		
		lblNewLabel.setBounds(12, 1, 185, 27);
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
		topPanel.add(lblNewLabel);
		
		
		lblClose = new JLabel("");
		lblClose.setBounds(545, 3, 26, 26);
		topPanel.add(lblClose);
		lblClose.addMouseListener(new MouseAdapter() {   
			public void mouseReleased(MouseEvent e) {
				Admin.getInstance().getProjects().remove(project);
			    	MainVisual.getInstance().getMenuPanel().setVisible(false);
				MainVisual.getInstance().getContractPanel().setVisible(true);
//				MainVisual.getInstance().getLblIcon1().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/contract.png")));
//				MainVisual.getInstance().getLblIcon2().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/createContract.png")));
				MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
				MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
				MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
				//If closed remove project and release workers.
				
				
				Admin.getInstance().removeProject(project);
				dispose();
			}
		});
		lblClose.setIcon(windowsCloseIcon);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (!((JTextField)fechaInicial.getDateEditor().getUiComponent()).getText().equals("") && !((JTextField)fechaFinal.getDateEditor().getUiComponent()).getText().equals("")) {
				if (validate(fechaInicial) && validate(fechaFinal) && validarFecha()) {
					if (!postpone) {
						double price = project.calculateBasePrice()*getDays();
						priceLabel.setText(String.valueOf(price));
					}
					else {
						double price = contract.getProject().calculateBasePrice()*getDays();
						priceLabel.setText(String.valueOf(price));
					}
				}
			  }
			}
		});
		panel.setBounds(17, 40, 546, 283);
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Detalles del contrato", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
	
		tfdClientName = new JTextField();
		tfdClientName.setEditable(false);
		//if (postpone)
		//	tfdSearchClient.setEditable(false);
		tfdClientName.setHorizontalAlignment(SwingConstants.CENTER);
		tfdClientName.setBounds(339, 61, 159, 22);
		panel.add(tfdClientName);
		tfdClientName.setBackground(new Color(220, 220, 220));

		tfdClientName.setColumns(10);
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 64, 75, 16);
		panel.add(lblCliente);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				lblBuscar.setIcon(new ImageIcon(CreateContract.class.getResource("/icons/search1.png")));
			}
			public void mouseReleased(MouseEvent e) {
				lblBuscar.setIcon(new ImageIcon(CreateContract.class.getResource("/icons/search.png")));
			}
		});
		lblBuscar.setIcon(new ImageIcon(CreateContract.class.getResource("/icons/search.png")));
		lblBuscar.setBounds(510, 62, 24, 29);
		panel.add(lblBuscar);
		
		lblFechaInicial = new JLabel("Fecha inicial:");
		lblFechaInicial.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaInicial.setBounds(10, 115, 85, 14);
		panel.add(lblFechaInicial);
		
		lblFechaFinal = new JLabel("Fecha final:");
		lblFechaFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaFinal.setBounds(281, 115, 80, 14);
		panel.add(lblFechaFinal);
		
		fechaInicial = new JDateChooser();
		if (postpone)
			fechaInicial.setEnabled(false);
		fechaInicial.setBackground(new Color(230, 230, 250));
		fechaInicial.setDateFormatString("dd/MM/yyyy");
		fechaInicial.setMinSelectableDate(new Date());
		fechaInicial.setBounds(104, 112, 150, 20);
		panel.add(fechaInicial);
		((JTextField)fechaInicial.getDateEditor().getUiComponent()).setEditable(false);
		
		fechaFinal = new JDateChooser();
		fechaFinal.setBackground(new Color(230, 230, 250));
		fechaFinal.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				if (validate(fechaInicial) && validate(fechaFinal) && validarFecha()) {
    				double price = project.calculateBasePrice()*getDays();
    				priceLabel.setText(String.valueOf(price));
    			}
			}
		});
		fechaFinal.setDateFormatString("dd/MM/yyyy");
		fechaFinal.setMinSelectableDate(new Date());
		fechaFinal.setBounds(373, 112, 150, 20);
		panel.add(fechaFinal);
		((JTextField)fechaFinal.getDateEditor().getUiComponent()).setEditable(false);
		
		if (!postpone)
			btnCrear = new JButton("Crear");
		else
			btnCrear = new JButton("Posponer");
		btnCrear.setBackground(new Color(255,255,240));
		btnCrear.setEnabled(false);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!postpone) {
				if (!tfdClientName.getText().equals("")||((JTextField)fechaInicial.getDateEditor().getUiComponent()).getText().equals("")||((JTextField)fechaFinal.getDateEditor().getUiComponent()).getText().equals("")) {
						if (validate(fechaInicial) && validate(fechaFinal)) {
							if (validarFecha()) {
								if(findClient(tfdClientName.getText()).getActiveProjects() < 5){
								String init = ((JTextField)fechaInicial.getDateEditor().getUiComponent()).getText();
								String finall = ((JTextField)fechaFinal.getDateEditor().getUiComponent()).getText();
								Admin.getInstance().createContract(init, finall, createID(), findClient(tfdClientName.getText()), project, project.calculateBasePrice()*getDays());
								//Guardado
								Admin.getInstance().saveContracts();
								Admin.getInstance().saveContractID();
								Admin.getInstance().saveProjects();
								JOptionPane.showMessageDialog(null, "El contrato se ha creado exitosamente","Contrato creado", JOptionPane.INFORMATION_MESSAGE, null);
								   MainVisual.getInstance().getMenuPanel().setVisible(false);
								   MainVisual.getInstance().getContractPanel().setVisible(true);
								   MainVisual.getInstance().getLblIcon1().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/contract.png")));
								   MainVisual.getInstance().getLblIcon2().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/createContract.png")));
								   dispose();
								}else{
									JOptionPane.showMessageDialog(null, "El cliente ha llegado al limite de contrats activos","ERROR", JOptionPane.WARNING_MESSAGE, null);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "La fecha final no puede ser menor que la inicial","Fechas inválidas", JOptionPane.WARNING_MESSAGE, null);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Las fechas no pueden ser menos que la fecha actual","Fechas inválidas", JOptionPane.WARNING_MESSAGE, null);
						}
				}
				else {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar","Hay campos obligatorios vacios", JOptionPane.WARNING_MESSAGE, null);
				}
			}
				else {
					if (((JTextField)fechaFinal.getDateEditor().getUiComponent()).getText().equals(""))
						JOptionPane.showMessageDialog(null, "Rellene todos los cambios para continuar","Campos vacios", JOptionPane.WARNING_MESSAGE, null);
					else {
						Admin.getInstance().getContracts().get(index).setFinalDate(((JTextField)fechaFinal.getDateEditor().getUiComponent()).getText());
						Admin.getInstance().getContracts().get(index).setFinalPrice(Double.parseDouble(priceLabel.getText()));
						JOptionPane.showMessageDialog(null, "Se ha pospuesto correctamente el proyecto","", JOptionPane.INFORMATION_MESSAGE, null);
						Admin.getInstance().getContracts().get(index).setPostpone(1);
						//Guardado
						Admin.getInstance().saveContracts();
						Admin.getInstance().saveContractID();
						Admin.getInstance().saveProjects();
						dispose();
						try {
							ListContract.getInstance().loadContracts(Admin.getInstance().getContracts());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		
		btnCrear.setActionCommand("OK");
		buttonPane.add(btnCrear);
		getRootPane().setDefaultButton(btnCrear);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(10, 22, 46, 14);
		panel.add(lblId);
		
		IDLabel = new JLabel("New label");
		IDLabel.setText(String.valueOf(Contract.IDnumber));
		IDLabel.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		IDLabel.setBounds(104, 23, 150, 14);
		panel.add(IDLabel);
		
		lblPrecio = new JLabel("Precio: RD$");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(373, 250, 80, 14);
		panel.add(lblPrecio);
		
		priceLabel = new JLabel("0.00");
		priceLabel.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		priceLabel.setBounds(463, 250, 64, 14);
		panel.add(priceLabel);
		
		/*label = new JLabel("*Introducir c\u00E9dula con guiones");
		label.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label.setBounds(104, 87, 150, 14);
		panel.add(label);
		*/
		lblProyecto = new JLabel("Proyecto: ");
		lblProyecto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProyecto.setBounds(10, 161, 85, 14);
		panel.add(lblProyecto);
		
		proyecto = new JTextField();
		proyecto.setBackground(new Color(220,220,220));
		proyecto.setEditable(false);
		proyecto.setBounds(104, 157, 150, 22);
		panel.add(proyecto);
		proyecto.setColumns(10);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(281, 209, 46, 14);
		panel.add(lblTipo);
		
		tipo = new JTextField();
		tipo.setBackground(new Color(220,220,220));
		tipo.setEditable(false);
		tipo.setBounds(337, 205, 163, 22);
		panel.add(tipo);
		tipo.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Lenguaje: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 208, 85, 16);
		panel.add(lblNewLabel_1);
		
		lenguaje = new JTextField();
		lenguaje.setBackground(new Color(220,220,220));
		lenguaje.setEditable(false);
		lenguaje.setBounds(104, 205, 150, 22);
		panel.add(lenguaje);
		lenguaje.setColumns(10);
		
		MaskFormatter idFormatter = null;
		
		try {
		    idFormatter = new MaskFormatter("###-#######-#");
		    idFormatter.setPlaceholderCharacter('_');
		    //idFormatter.setValueContainsLiteralCharacters(false);
		    //idFormatter.setOverwriteMode(true);
		} catch (ParseException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		
		formatedClient = new JFormattedTextField(idFormatter);
		formatedClient.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			    if(formatedClient.getCaretPosition()!=0){
				btnCrear.setEnabled(false);
				    if(existingClients()){
					formatedClient.setBackground(new Color(153,255,51));
					if(formatedClient.getCaretPosition()==13){
					   btnCrear.setEnabled(true);
					   Client actualClient = Admin.getInstance().searchClientByID(formatedClient.getText());
					   tfdClientName.setText(actualClient.getName()+ " " + actualClient.getLastName());
					}else{
					    btnCrear.setEnabled(false);
					    tfdClientName.setText("");
					}
				    }else{
					formatedClient.setBackground(new Color(255, 51, 51));
				    }
			    }else{
				formatedClient.setBackground(new Color(230,230,250));
			    }
			
			}
		});
		formatedClient.setHorizontalAlignment(SwingConstants.CENTER);
		formatedClient.setBackground(new Color(230, 230, 250));
		formatedClient.setBounds(104, 61, 223, 22);
		panel.add(formatedClient);
	    
		if (!postpone)
			load();
	    if (postpone)
	    	loadPostponeWindow();
	    {
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBackground(new Color(255,255,240));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Admin.getInstance().getProjects().remove(project);
			    MainVisual.getInstance().getMenuPanel().setVisible(false);
			    MainVisual.getInstance().getContractPanel().setVisible(true);
			   // MainVisual.getInstance().getLblIcon1().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/contract.png")));
			//   MainVisual.getInstance().getLblIcon2().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/createContract.png")));
			   
			    MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
			    MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
			    MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
			    
			    //If closed remove project and release workers.
			    Admin.getInstance().removeProject(project);
			    dispose();
			}
		});
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);
	    }
	}
	
  }
    
    
	private void findClient() {
		String textField = tfdClientName.getText();
		tfdClientName.setBackground(new Color(255, 220, 220));
		if (textField.length()<14) {
			for (Client i: Admin.getInstance().getClients()) {
				String aux = getIDWorker(textField.length(), i);
				if (textField.equals(aux))
					tfdClientName.setBackground(new Color(220, 255, 220));
			}	
		}
		if (textField.length()==0) {
			tfdClientName.setBackground(new Color(220, 255, 220));
		}
	}
	private String getIDWorker(int number, Client client) {
		String aux = null;
		String aux1 = client.getIdNumber();
		aux = aux1.substring(0, number);
		return aux;
	}
    private void setClientName() {
    	String aux = null;
    	for (Client i: Admin.getInstance().getClients()) {
    		String ID = i.getIdNumber();
    		if (ID.equals(tfdClientName.getText())) {
    			aux = i.getName()+" "+i.getLastName();
    	        tfdClientName.setText(aux);
    		}
    		else {
    			aux = "No encontrado";
	        	tfdClientName.setText(aux);
    		}
    	}		
    }
    private void load () {
         proyecto.setText(project.getName());
         tipo.setText(project.getProgrammingType());
         lenguaje.setText(project.getProgrammingLanguage());
    }
    private long getDays() {
    	long aux = 0;
    	Date initialDate = fechaInicial.getDate();
    	Date finalDate = fechaFinal.getDate();
    	aux = finalDate.getTime() - initialDate.getTime();
        return TimeUnit.DAYS.convert(aux, TimeUnit.MILLISECONDS);
    }

    private boolean validarFecha() throws NullPointerException {
		boolean aux = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date initialDate = fechaInicial.getDate();
		Date finalDate = fechaFinal.getDate();
		String introducido = formato.format(initialDate);
		String hoy = formato.format(finalDate);
		String[] introd = introducido.split("/");
		String[] actual = hoy.split("/");
		if (Integer.parseInt(actual[2]) > Integer.parseInt(introd[2])) {
			aux = true;
		}
		else if (Integer.parseInt(actual[2]) < Integer.parseInt(introd[2])) {
			aux = false;
		}
		else {
			if (Integer.parseInt(actual[1]) > Integer.parseInt(introd[1])) {
				aux = true;
			}
			else if (Integer.parseInt(actual[1]) < Integer.parseInt(introd[1])) {
				aux = false;
			}
			else {
				if (Integer.parseInt(actual[0]) > Integer.parseInt(introd[0])) {
					aux = true;
				}
				else if (Integer.parseInt(actual[0]) <= Integer.parseInt(introd[0])) {
					aux = false;
				}
			}
		}
		return aux;
	}
    private Client findClient(String name) {
    	Client aux = null;
    	for (Client ct: Admin.getInstance().getClients()) {
    		String nb = ct.getName()+" "+ct.getLastName();
    		if (nb.equals(name))
    			aux = ct;
    	}
    	return aux;
    }
    
    private boolean existingClients(){
	boolean clientsExisting=false;
	String filter = formatedClient.getText().substring(0,formatedClient.getCaretPosition());
	for (Client ct : Admin.getInstance().getClients()) {
	    if(ct.getIdNumber().subSequence(0, filter.length()).equals(filter)){
		clientsExisting=true;
		break;
	    }
	}
	return clientsExisting;
    }
    
    private boolean validate(JDateChooser fecha) throws NullPointerException {
		boolean aux = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaActual = new Date();
		Date fecha1 = fecha.getDate();
		String introducido = formato.format(fecha1);
		String hoy = formato.format(fechaActual);
		String[] introd = introducido.split("/");
		String[] actual = hoy.split("/");
		if (Integer.parseInt(actual[2]) < Integer.parseInt(introd[2])) {
			aux = true;
		}
		else if (Integer.parseInt(actual[2]) > Integer.parseInt(introd[2])) {
			aux = false;
		}
		else {
			if (Integer.parseInt(actual[1]) < Integer.parseInt(introd[1])) {
				aux = true;
			}
			else if (Integer.parseInt(actual[1]) > Integer.parseInt(introd[1])) {
				aux = false;
			}
			else {
				if (Integer.parseInt(actual[0]) < Integer.parseInt(introd[0])) {
					aux = true;
				}
				else if (Integer.parseInt(actual[0]) >= Integer.parseInt(introd[0])) {
					aux = false;
				}
			}
		}
		return aux;
	}
    private void loadPostponeWindow() {
    	IDLabel.setText(contract.getContractID());
    	tfdClientName.setText(contract.getClient().getName()+" "+contract.getClient().getLastName());
    	((JTextField)fechaInicial.getDateEditor().getUiComponent()).setText(contract.getInitialDate());
    	proyecto.setText(contract.getProject().getName());
    	tipo.setText(contract.getProject().getProgrammingType());
    	lenguaje.setText(contract.getProject().getProgrammingLanguage());
    	priceLabel.setText(String.valueOf(contract.getFinalPrice()));
    }
    private String createID() {
    	String aux = null;
    	String[] date = ((JTextField)fechaInicial.getDateEditor().getUiComponent()).getText().split("/");
    	String date1 = date[0]+date[1]+date[2];
    	Client client = findClient(tfdClientName.getText());
    	String[] separateTelephone = client.getPhone().split("-");
    	String telephone = separateTelephone[0]+separateTelephone[1]+separateTelephone[2];
        aux = date1 + telephone;
        String aux1 = aux.substring(0,  5);
        String aux2 = aux.substring(5, 10);
        String aux3 = aux.substring(10,15);
        String aux4 = aux.substring(15,aux.length());
        String aux5 = String.valueOf(Contract.IDnumber++);
        if (Contract.IDnumber<10)
        	aux = aux1+"-"+aux2+"-"+aux3+"-"+aux4+"0"+aux5;
        else		
        	aux = aux1+"-"+aux2+"-"+aux3+"-"+aux4+aux5;
    	return aux;
    }
}

