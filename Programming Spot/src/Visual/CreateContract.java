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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
import Logico.Contract;
import Logico.Designer;
import Logico.Planner;
import Logico.Programmer;
import Logico.Project;
import Logico.ProjectBoss;
import Logico.SoftwareTester;
import Logico.Worker;

import javax.swing.UIManager;
import javax.swing.JCheckBox;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

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
    private ImageIcon windowsCloseIcon =new ImageIcon("src/icons/close.png");
    //private ImageIcon workerIcon = new ImageIcon("src/icons/worker.png");
    //private ImageIcon contractIcon =new ImageIcon("src/icons/contract.png");
    //private ImageIcon clientIcon = new ImageIcon("src/icons/client.png");
    private JTextField cliente;
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
    
    /**
     * @param project
     */
    public CreateContract(final Project project, final boolean postpone, Contract contract, final int index) {
 ///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
    	setUndecorated(true);
	setBounds(100, 100, 577, 368);
	getContentPane().setLayout(null);
	contentPane.setBounds(0, 0, 577, 334);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
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
					if (validate(fechaInicial) && validate(fechaFinal) && validarFecha()) {
	    				double price = project.calculateBasePrice()*getDays();
	    				priceLabel.setText(String.valueOf(price));
	    			}
				  }
	    		}
	    });
	    buttonPane.setBounds(0, 333, 577, 35);
	    buttonPane.setBackground(new Color(220, 220, 220));
	    buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane);
	    {
	
	    }
	    
	    	topPanel = new JPanel();
	    	topPanel.setBounds(0, 0, 577, 29);
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
			    	MainVisual.getInstance().getMenuPanel().setVisible(false);
				MainVisual.getInstance().getContractPanel().setVisible(true);
				MainVisual.getInstance().getLblIcon1().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/contract.png")));
				MainVisual.getInstance().getLblIcon2().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/createContract.png")));
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
    				double price = project.calculateBasePrice()*getDays();
    				priceLabel.setText(String.valueOf(price));
    			}
			  }
			}
		});
		panel.setBounds(17, 40, 546, 283);
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Detalles del contrato", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
	
		cliente = new JTextField();
		if (postpone)
			cliente.setEditable(false);
		cliente.setHorizontalAlignment(SwingConstants.LEFT);
		cliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				findClient();
				if (cliente.getText().length()>13)
					cliente.setBackground(new Color(255,220,220));
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if ((cliente.getText().length()==3 || cliente.getText().length()==11)&&e.getKeyCode()!=8) {
					cliente.setText(cliente.getText()+"-");
				}
			}
		});
		cliente.setBounds(104, 62, 396, 22);
		panel.add(cliente);
		cliente.setBackground(new Color(220, 255, 220));

		cliente.setColumns(10);
		
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
				setClientName();
			}
		});
		lblBuscar.setIcon(new ImageIcon(CreateContract.class.getResource("/icons/search.png")));
		lblBuscar.setBounds(510, 62, 24, 29);
		panel.add(lblBuscar);
		
		lblFechaInicial = new JLabel("Fecha inicial:");
		lblFechaInicial.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaInicial.setBounds(10, 113, 85, 14);
		panel.add(lblFechaInicial);
		
		lblFechaFinal = new JLabel("Fecha final:");
		lblFechaFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaFinal.setBounds(281, 113, 102, 14);
		panel.add(lblFechaFinal);
		
		fechaInicial = new JDateChooser();
		if (postpone)
			fechaInicial.setEnabled(false);
		fechaInicial.setBackground(new Color(230, 230, 250));
		fechaInicial.setDateFormatString("dd/MM/yyyy");
		fechaInicial.setBounds(104, 112, 127, 20);
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
		fechaFinal.setBounds(373, 112, 127, 20);
		panel.add(fechaFinal);
		((JTextField)fechaFinal.getDateEditor().getUiComponent()).setEditable(false);
		
		if (!postpone)
			btnCrear = new JButton("Crear");
		else
			btnCrear = new JButton("Posponer");
		btnCrear.setBackground(new Color(255,255,240));
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!postpone) {
				if (!cliente.getText().equals("")||((JTextField)fechaInicial.getDateEditor().getUiComponent()).getText().equals("")||((JTextField)fechaFinal.getDateEditor().getUiComponent()).getText().equals("")) {
					if (findClient(cliente.getText())!=null) {
						if (validate(fechaInicial) && validate(fechaFinal)) {
							if (validarFecha()) {
								String init = ((JTextField)fechaInicial.getDateEditor().getUiComponent()).getText();
								String finall = ((JTextField)fechaFinal.getDateEditor().getUiComponent()).getText();
								Admin.getInstance().createContract(init, finall, createID(), findClient(cliente.getText()), project, project.calculateBasePrice()*getDays());
								JOptionPane.showMessageDialog(null, "El contrato se ha creado exitosamente","Contrato creado", JOptionPane.INFORMATION_MESSAGE, null);
								   MainVisual.getInstance().getMenuPanel().setVisible(false);
								   MainVisual.getInstance().getContractPanel().setVisible(true);
								   MainVisual.getInstance().getLblIcon1().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/contract.png")));
								   MainVisual.getInstance().getLblIcon2().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/createContract.png")));
								   dispose();
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
						JOptionPane.showMessageDialog(null, "Introduzca la cedula del cliente y presione 'buscar'","Nombre inválido", JOptionPane.WARNING_MESSAGE, null);
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
						JOptionPane.showMessageDialog(null, "Se ha pospuesto correctamente el proyecto","", JOptionPane.INFORMATION_MESSAGE, null);
						Admin.getInstance().getContracts().get(index).setPostpone(1);
						dispose();
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
		IDLabel.setText(String.valueOf(Contract.IDnumber++));
		IDLabel.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		IDLabel.setBounds(104, 23, 279, 14);
		panel.add(IDLabel);
		
		lblPrecio = new JLabel("Precio: RD$");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(373, 250, 149, 14);
		panel.add(lblPrecio);
		
		priceLabel = new JLabel("0.00");
		priceLabel.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		priceLabel.setBounds(463, 250, 64, 14);
		panel.add(priceLabel);
		
		label = new JLabel("*Introducir c\u00E9dula con guiones");
		label.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label.setBounds(104, 87, 150, 14);
		panel.add(label);
		
		lblProyecto = new JLabel("Proyecto: ");
		lblProyecto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProyecto.setBounds(10, 160, 85, 14);
		panel.add(lblProyecto);
		
		proyecto = new JTextField();
		proyecto.setBackground(new Color(220,220,220));
		proyecto.setEditable(false);
		proyecto.setBounds(104, 157, 150, 22);
		panel.add(proyecto);
		proyecto.setColumns(10);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(281, 208, 46, 14);
		panel.add(lblTipo);
		
		tipo = new JTextField();
		tipo.setBackground(new Color(220,220,220));
		tipo.setEditable(false);
		tipo.setBounds(337, 205, 163, 22);
		panel.add(tipo);
		tipo.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Lenguaje: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 207, 85, 16);
		panel.add(lblNewLabel_1);
		
		lenguaje = new JTextField();
		lenguaje.setBackground(new Color(220,220,220));
		lenguaje.setEditable(false);
		lenguaje.setBounds(104, 205, 150, 22);
		panel.add(lenguaje);
		lenguaje.setColumns(10);
	    
		if (!postpone)
			load();
	    if (postpone)
	    	loadPostponeWindow();
	    {
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBackground(new Color(255,255,240));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    MainVisual.getInstance().getMenuPanel().setVisible(false);
			    MainVisual.getInstance().getContractPanel().setVisible(true);
			    MainVisual.getInstance().getLblIcon1().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/contract.png")));
			    MainVisual.getInstance().getLblIcon2().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/createContract.png")));
			    dispose();
			}
		});
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);
	    }
	}
	
  }
	private void findClient() {
		String textField = cliente.getText();
		cliente.setBackground(new Color(255, 220, 220));
		if (textField.length()<14) {
			for (Client i: Admin.getInstance().getClients()) {
				String aux = getIDWorker(textField.length(), i);
				if (textField.equals(aux))
					cliente.setBackground(new Color(220, 255, 220));
			}	
		}
		if (textField.length()==0) {
			cliente.setBackground(new Color(220, 255, 220));
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
    		if (ID.equals(cliente.getText())) {
    			aux = i.getName()+" "+i.getLastName();
    	        cliente.setText(aux);
    		}
    		else {
    			aux = "No encontrado";
	        	cliente.setText(aux);
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
    	for (Client i: Admin.getInstance().getClients()) {
    		String nb = i.getName()+" "+i.getLastName();
    		if (nb.equals(name))
    			aux = i;
    	}
    	return aux;
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
    	cliente.setText(contract.getClient().getName()+" "+contract.getClient().getLastName());
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
    	Client client = findClient(cliente.getText());
    	String[] separateTelephone = client.getPhone().split("-");
    	String telephone = separateTelephone[0]+separateTelephone[1]+separateTelephone[2];
        aux = date1 + telephone;
        String aux1 = aux.substring(0,  5);
        String aux2 = aux.substring(5, 10);
        String aux3 = aux.substring(10,15);
        String aux4 = aux.substring(15,aux.length());
        String aux5 = String.valueOf(Contract.IDnumber);
        if (Contract.IDnumber<10)
        	aux = aux1+"-"+aux2+"-"+aux3+"-"+aux4+"0"+aux5;
        else		
        	aux = aux1+"-"+aux2+"-"+aux3+"-"+aux4+aux5;
    	return aux;
    }
}

