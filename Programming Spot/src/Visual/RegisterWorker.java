package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Logico.Admin;
import Logico.Designer;
import Logico.Planner;
import Logico.Programmer;
import Logico.ProjectBoss;
import Logico.SoftwareTester;
import Logico.Worker;

import com.toedter.calendar.JDateChooser;

public class RegisterWorker extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6601467822687581382L;
	private final JPanel contentPanel = new JPanel();
	private JTextField apellidos;
	private JTextField nombres;
	private JTextField salario;
	private JTextField horasTrabajo;
	private JFormattedTextField telefonoText;
	private JTextField localidad;
	private JTextField calle;
	private JTextField numero;
	private ImageIcon workerIcon = new ImageIcon("src/icons/worker.png");
	private ImageIcon contractIcon =new ImageIcon("src/icons/contract.png");
	private ImageIcon clientIcon = new ImageIcon("src/icons/client.png");
	private JFormattedTextField cedulaText;
	private JComboBox<String> sexo;
	private JPasswordField contrasenia;
	private JTextField tipoProgramador;
	private JTextField lenguajeDeProgramacion;
	private JRadioButton planeador;
	private JRadioButton programador;
	private JRadioButton diseniador;
	private JRadioButton tester;
	private JLabel lblcontrasea;
	private JLabel lblNewLabel_8;
	private JLabel lblTipoDeProgramador;
	private JComboBox<String> provincia;
	private JDateChooser dateChooser;
	private Worker worker;
	private JRadioButton jefeProyecto;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegisterWorker(final boolean registerModify, final Worker worker) {
		this.worker = worker;
		setUndecorated(true);
		setBounds(100, 100, 1050, 597);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(1050, 0, 1050, 29);
			contentPanel.add(panel);
			{
				JLabel lblE = new JLabel("e");
				panel.add(lblE);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 1050, 29);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						MainVisual.getInstance().getMenuPanel().setVisible(false);
						MainVisual.getInstance().getWorkersPanel().setVisible(true);
						MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
						MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
						MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
						dispose();
					}
				});
				lblNewLabel.setIcon(new ImageIcon(RegisterWorker.class.getResource("/icons/close.png")));
				lblNewLabel.setBounds(1025, 3, 26, 26);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1;
				if (!registerModify)
				lblNewLabel_1 = new JLabel("Registrar Trabajador");
				else
					lblNewLabel_1 = new JLabel("Modificar Trabajador");
				lblNewLabel_1.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
				lblNewLabel_1.setBounds(12, 1, 185, 27);
				panel.add(lblNewLabel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(220,220,220));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Personales", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 90, 1028, 150);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_3 = new JLabel("*C\u00E9dula: ");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_3.setBounds(12, 30, 75, 16);
				panel.add(lblNewLabel_3);
			}
			MaskFormatter cedula = null;
			MaskFormatter telefono = null;
			try {
				cedula = new MaskFormatter("###-#######-#");
				cedula.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				telefono = new MaskFormatter("###-###-####");
				telefono.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			cedulaText = new JFormattedTextField(cedula);
			cedulaText.setBackground(new Color(230,230,250));
			cedulaText.setHorizontalAlignment(SwingConstants.CENTER);
			cedulaText.setBounds(106, 28, 207, 22);
			panel.add(cedulaText);
			{
				JLabel lblApellidos = new JLabel("*Apellidos: ");
				lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblApellidos.setBounds(360, 30, 75, 16);
				panel.add(lblApellidos);
			}
			
			apellidos = new JTextField();
			apellidos.setHorizontalAlignment(SwingConstants.CENTER);
			apellidos.setBackground(new Color(230,230,250));
			apellidos.setBounds(445, 28, 207, 22);
			panel.add(apellidos);
			apellidos.setColumns(10);
			
			JLabel lblNombres = new JLabel("*Nombres: ");
			lblNombres.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNombres.setBounds(701, 30, 75, 16);
			panel.add(lblNombres);
			
			nombres = new JTextField();
			nombres.setHorizontalAlignment(SwingConstants.CENTER);
			nombres.setBackground(new Color(230,230,250));
			nombres.setBounds(802, 28, 191, 22);
			panel.add(nombres);
			nombres.setColumns(10);
			
			JLabel lblSexo = new JLabel("*Sexo: ");
			lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSexo.setBounds(12, 70, 75, 14);
			panel.add(lblSexo);
			
			sexo = new JComboBox<String>();
			sexo.setBackground(new Color(230,230,250));
			sexo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Masculino ", "Femenino"}));
			sexo.setBounds(106, 67, 207, 22);
			panel.add(sexo);
			
			JLabel lblNewLabel_4 = new JLabel("*Fecha de nacimiento: ");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4.setBounds(360, 70, 157, 14);
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("*Pago por hora: ");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5.setBounds(702, 69, 125, 16);
			panel.add(lblNewLabel_5);
			
			salario = new JTextField();
			salario.setHorizontalAlignment(SwingConstants.CENTER);
			salario.setBackground(new Color(230,230,250));
			salario.setBounds(848, 67, 145, 22);
			panel.add(salario);
			salario.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("*Horas de trabajo: ");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6.setBounds(12, 110, 145, 16);
			panel.add(lblNewLabel_6);
			
			horasTrabajo = new JTextField();
			horasTrabajo.setBackground(new Color(230,230,250));
			horasTrabajo.setHorizontalAlignment(SwingConstants.CENTER);
			horasTrabajo.setBounds(167, 108, 146, 22);
			panel.add(horasTrabajo);
			horasTrabajo.setColumns(10);
			
			JLabel lblTelfono = new JLabel("*Tel\u00E9fono: ");
			lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTelfono.setBounds(360, 111, 86, 14);
			panel.add(lblTelfono);
			
			telefonoText = new JFormattedTextField(telefono);
			telefonoText.setBackground(new Color(230,230,250));
			telefonoText.setHorizontalAlignment(SwingConstants.CENTER);
			telefonoText.setBounds(445, 108, 207, 22);
			panel.add(telefonoText);
			telefonoText.setColumns(10);
			
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("dd/MM/yyyy");
			dateChooser.getDateEditor().setEnabled(false);
			dateChooser.setBounds(527, 68, 125, 22);
			panel.add(dateChooser);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("* -> Par\u00E1metros Obligatorios");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
			lblNewLabel_2.setBounds(22, 51, 197, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Direcci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.setBackground(new Color(220,220,220));
			panel.setBounds(10, 270, 1028, 133);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblProvincia = new JLabel("*Provincia: ");
			lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblProvincia.setBounds(10, 29, 81, 14);
			panel.add(lblProvincia);
			
			JLabel lblLocalidad = new JLabel("*Localidad: ");
			lblLocalidad.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblLocalidad.setBounds(10, 80, 81, 14);
			panel.add(lblLocalidad);
			
			localidad = new JTextField();
			localidad.setBackground(new Color(230,230,250));
			localidad.setBounds(106, 78, 207, 22);
			panel.add(localidad);
			localidad.setColumns(10);
			
			JLabel lblCalle = new JLabel("Calle: ");
			lblCalle.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCalle.setBounds(360, 56, 57, 14);
			panel.add(lblCalle);
			
			calle = new JTextField();
			calle.setBackground(new Color(230,230,250));
			calle.setBounds(445, 53, 207, 22);
			panel.add(calle);
			calle.setColumns(10);
			
			JLabel lblNo = new JLabel("No: ");
			lblNo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNo.setBounds(701, 57, 57, 14);
			panel.add(lblNo);
			
			numero = new JTextField();
			numero.setBackground(new Color(230,230,250));
			numero.setBounds(802, 54, 191, 22);
			panel.add(numero);
			numero.setColumns(10);
			
			provincia = new JComboBox<String>();
			provincia.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", 
					"Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal",
					"Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel",
					"Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "San Crist\u00F3bal", 
					"San Jos\u00E9 De Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "S\u00E1nchez Ramirez", "Santiago",
					"Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
			provincia.setBounds(106, 26, 207, 22);
			panel.add(provincia);
		}
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(RegisterWorker.class.getResource("/icons/registerClient2x.png")));
		lblNewLabel_7.setBounds(505, 28, 48, 64);
		contentPanel.add(lblNewLabel_7);
		
		jefeProyecto = new JRadioButton("Jefe de Proyecto");
        jefeProyecto.setSelected(true);
		jefeProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(true);
				diseniador.setSelected(false);
				programador.setSelected(false);
				planeador.setSelected(false);
				tester.setSelected(false);
			    lblcontrasea.setVisible(true);
			    contrasenia.setVisible(true);
			    lblTipoDeProgramador.setVisible(false);
			    tipoProgramador.setVisible(false);
			    lblNewLabel_8.setVisible(false);
			    lenguajeDeProgramacion.setVisible(false);
			}
		});
		jefeProyecto.setBackground(new Color(220, 220,220));
		jefeProyecto.setFont(new Font("Tahoma", Font.BOLD, 13));
		jefeProyecto.setBounds(10, 421, 146, 23);
		contentPanel.add(jefeProyecto);
		
		planeador = new JRadioButton("Planeador");
		planeador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(false);
				diseniador.setSelected(false);
				programador.setSelected(false);
				planeador.setSelected(true);
				tester.setSelected(false);
			    lblcontrasea.setVisible(false);
			    contrasenia.setVisible(false);
			    lblTipoDeProgramador.setVisible(false);
			    tipoProgramador.setVisible(false);
			    lblNewLabel_8.setVisible(false);
			    lenguajeDeProgramacion.setVisible(false);
			}
		});
		planeador.setBackground(new Color(220, 220,220));
		planeador.setFont(new Font("Tahoma", Font.BOLD, 13));
		planeador.setBounds(264, 421, 109, 23);
		contentPanel.add(planeador);
		
		programador = new JRadioButton("Programador");
		programador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(false);
				diseniador.setSelected(false);
				programador.setSelected(true);
				planeador.setSelected(false);
				tester.setSelected(false);
			    lblcontrasea.setVisible(false);
			    contrasenia.setVisible(false);
			    lblTipoDeProgramador.setVisible(true);
			    tipoProgramador.setVisible(true);
			    lblNewLabel_8.setVisible(true);
			    lenguajeDeProgramacion.setVisible(true);
			}
		});
		programador.setBackground(new Color(220, 220,220));
		programador.setFont(new Font("Tahoma", Font.BOLD, 13));
		programador.setBounds(486, 421, 128, 23);
		contentPanel.add(programador);
		
		diseniador = new JRadioButton("Dise\u00F1ador");
		diseniador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(false);
				diseniador.setSelected(true);
				programador.setSelected(false);
				planeador.setSelected(false);
				tester.setSelected(false);
			    lblcontrasea.setVisible(false);
			    contrasenia.setVisible(false);
			    lblTipoDeProgramador.setVisible(false);
			    tipoProgramador.setVisible(false);
			    lblNewLabel_8.setVisible(false);
			    lenguajeDeProgramacion.setVisible(false);
			}
		});
		diseniador.setBackground(new Color(220, 220,220));
		diseniador.setFont(new Font("Tahoma", Font.BOLD, 13));
		diseniador.setBounds(710, 421, 109, 23);
		contentPanel.add(diseniador);
		
		tester = new JRadioButton("Tester");
		tester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(false);
				diseniador.setSelected(false);
				programador.setSelected(false);
				planeador.setSelected(false);
				tester.setSelected(true);
			    lblcontrasea.setVisible(false);
			    contrasenia.setVisible(false);
			    lblTipoDeProgramador.setVisible(false);
			    tipoProgramador.setVisible(false);
			    lblNewLabel_8.setVisible(false);
			    lenguajeDeProgramacion.setVisible(false);
			}
		});
		tester.setBackground(new Color(220, 220,220));
		tester.setFont(new Font("Tahoma", Font.BOLD, 13));
		tester.setBounds(924, 421, 109, 23);
		contentPanel.add(tester);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Detalles de trabajador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(220,220,220));
		panel.setBounds(10, 462, 1028, 75);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblcontrasea = new JLabel("*Contrase\u00F1a: ");
		lblcontrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblcontrasea.setBounds(10, 32, 102, 14);
		panel.add(lblcontrasea);
		
		contrasenia = new JPasswordField();
		contrasenia.setBackground(new Color(230,230,250));
		contrasenia.setBounds(120, 30, 310, 22);
		panel.add(contrasenia);
		contrasenia.setColumns(10);
		
		lblTipoDeProgramador = new JLabel("*Tipo de programador: ");
		lblTipoDeProgramador.setVisible(false);
		lblTipoDeProgramador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeProgramador.setBounds(10, 31, 169, 16);
		panel.add(lblTipoDeProgramador);
		
		tipoProgramador = new JTextField();
		tipoProgramador.setBackground(new Color(230,230,250));
		tipoProgramador.setVisible(false);
		tipoProgramador.setBounds(189, 29, 241, 22);
		panel.add(tipoProgramador);
		tipoProgramador.setColumns(10);
		
		lblNewLabel_8 = new JLabel("*Lenguaje de programaci\u00F3n: ");
		lblNewLabel_8.setVisible(false);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(473, 31, 203, 16);
		panel.add(lblNewLabel_8);
		
		lenguajeDeProgramacion = new JTextField();
		lenguajeDeProgramacion.setBackground(new Color(230,230,250));
		lenguajeDeProgramacion.setVisible(false);
		lenguajeDeProgramacion.setBounds(722, 29, 251, 22);
		panel.add(lenguajeDeProgramacion);
		lenguajeDeProgramacion.setColumns(10);
		super.getToolkit().getScreenSize(); 
		this.setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setBackground(new Color(220,220,220));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton registrarButton;
				if (!registerModify)
				 registrarButton = new JButton("Registrar");
				else
					 registrarButton = new JButton("Modificar");
				registrarButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						if (!registerModify) {
					    if (cedulaText.getText().equals("___-_______-_")||apellidos.getText().equals("")||provincia.getSelectedIndex()==0||nombres.getText().equals("")||sexo.getSelectedIndex()==0||horasTrabajo.getText().equals("")||telefonoText.getText().equals("___-___-____")||salario.getText().equals("")||localidad.getText().equals("")||((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().equals("")||calle.getText().equals("")||numero.getText().equals(""))
							JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar","Hay campos obligatorios vacios", JOptionPane.WARNING_MESSAGE, null);
					    else if ((jefeProyecto.isSelected()&&contrasenia.getText().equals("")||(programador.isSelected()&&(lenguajeDeProgramacion.getText().equals("")||tipoProgramador.getText().equals(""))))) {
					    	JOptionPane.showMessageDialog(null, "Hay campos obligatorios vacios","Rellene todos los campos para continuar", JOptionPane.WARNING_MESSAGE, null);
					    }
					    else if (!validarFecha(dateChooser))
					    	JOptionPane.showMessageDialog(null, "La trabajador no puede ser tan joven","Fecha inválida", JOptionPane.WARNING_MESSAGE, null);
					    else
					    {
					    	Worker worker = null;
					    	if (jefeProyecto.isSelected()) {
					    		worker = new ProjectBoss();
					    		((ProjectBoss)worker).setPassword(contrasenia.getText());
					    	}
					    	else if (diseniador.isSelected())
					    		worker = new Designer();
					    	else if (programador.isSelected()) {
					    		worker = new Programmer();
					    		((Programmer)worker).setProgrammerType(tipoProgramador.getText());
					    		((Programmer)worker).setProgrammingLanguage(lenguajeDeProgramacion.getText());
					    	}
					    	else if (tester.isSelected())
					    		worker = new SoftwareTester();
					    	else
					    		worker = new Planner();
					    	
					    		worker.setAddress(provincia.getSelectedItem()+"/"+localidad.getText()+"/"+calle.getText()+"/"+numero.getText());
					 
					    	worker.setWorkedHours(Integer.parseInt(horasTrabajo.getText()));
					    	worker.setFirstName(nombres.getText());
					    	worker.setLastName(apellidos.getText());
					    	worker.setIdNumber(cedulaText.getText());
					        worker.setSex(sexo.getSelectedItem().toString());
					    	worker.setBirthday(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					    	worker.setTelefono(telefonoText.getText());
					    	worker.setHourlyPayment(Integer.parseInt(salario.getText()));
					    	Admin.getInstance().addWorker(worker);
							JOptionPane.showMessageDialog(null, "¡El trabajador ha sido agregado!", "Trabajador Agregado", JOptionPane.INFORMATION_MESSAGE, clientIcon);
					        clean();
					    }
					}
						else {
							
							int index = Admin.getInstance().getWorkers().indexOf(worker);
							
							if (cedulaText.getText().equals("___-_______-_")||apellidos.getText().equals("")||provincia.getSelectedIndex()==0||nombres.getText().equals("")||sexo.getSelectedIndex()==0||horasTrabajo.getText().equals("")||telefonoText.getText().equals("___-___-____")||salario.getText().equals("")||localidad.getText().equals("")||((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().equals("")||calle.getText().equals("")||numero.getText().equals(""))
								JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar","Hay campos obligatorios vacios", JOptionPane.WARNING_MESSAGE, null);
						    else if ((jefeProyecto.isSelected()&&contrasenia.getText().equals("")||(programador.isSelected()&&(lenguajeDeProgramacion.getText().equals("")||tipoProgramador.getText().equals(""))))) {
						    	JOptionPane.showMessageDialog(null, "Hay campos obligatorios vacios","Rellene todos los campos para continuar", JOptionPane.WARNING_MESSAGE, null);
						    }
						    else if (!validarFecha(dateChooser))
						    	JOptionPane.showMessageDialog(null, "La trabajador no puede ser tan joven","Fecha inválida", JOptionPane.WARNING_MESSAGE, null);
						    else
						    {
						    	Worker worker = null;
						    	if (jefeProyecto.isSelected()) {
						    		worker = new ProjectBoss();
						    		((ProjectBoss)worker).setPassword(contrasenia.getText());
						    	}
						    	else if (diseniador.isSelected()) {
						    		worker = new Designer();
						    	}
						    	else if (programador.isSelected()) {
						    		worker = new Programmer();
						    		((Programmer)worker).setProgrammerType(tipoProgramador.getText());
						    		((Programmer)worker).setProgrammingLanguage(lenguajeDeProgramacion.getText());
						    	}
						    	else if (tester.isSelected()) {
						    		worker = new SoftwareTester();
						    	}
						    	else {
						    		worker = new Planner();
						    	}
						    	
						    		worker.setAddress(provincia.getSelectedItem()+"/"+localidad.getText()+"/"+calle.getText()+"/"+numero.getText());
						 
						    	worker.setWorkedHours(Integer.parseInt(horasTrabajo.getText()));
						    	worker.setFirstName(nombres.getText());
						    	worker.setLastName(apellidos.getText());
						    	worker.setIdNumber(cedulaText.getText());
						        worker.setSex(sexo.getSelectedItem().toString());
						    	worker.setBirthday(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
						    	worker.setTelefono(telefonoText.getText());
						    	worker.setHourlyPayment(Integer.parseInt(salario.getText()));
						    	Admin.getInstance().getWorkers().remove(index);
						    	Admin.getInstance().getWorkers().add(worker);
								JOptionPane.showMessageDialog(null, "¡El trabajador ha sido modificado!", "Trabajador modificado", JOptionPane.INFORMATION_MESSAGE, clientIcon);
						        dispose();
						    }
							
						}
					}
				
				});
				registrarButton.setBackground(Color.LIGHT_GRAY);
				registrarButton.setActionCommand("OK");
				buttonPane.add(registrarButton);
				getRootPane().setDefaultButton(registrarButton);
			}
			{
				JButton salirButton = new JButton("Salir");
				salirButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						MainVisual.getInstance().getMenuPanel().setVisible(false);
						MainVisual.getInstance().getWorkersPanel().setVisible(true);
						MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
						MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
						MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
						dispose();
					}
				});
				salirButton.setBackground(Color.LIGHT_GRAY);
				salirButton.setActionCommand("Cancel");
				buttonPane.add(salirButton);
				
			}
		}
		if (registerModify)
			loadWorker();
	}
	private boolean validarFecha(JDateChooser fecha) {
		boolean aux = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaActual = new Date();
		Date fecha1 = fecha.getDate();
		String introducido = formato.format(fecha1);
		String hoy = formato.format(fechaActual);
		String[] introd = introducido.split("/");    
		String[] actual = hoy.split("/");
		if (Integer.parseInt(actual[1]) < Integer.parseInt(introd[1])) {
		   if ((Integer.parseInt(actual[2])-Integer.parseInt(introd[2])-1)<21)
			   aux = false;
		   else 
			   aux = true;
		}
		else if (Integer.parseInt(actual[1]) == Integer.parseInt(introd[1])) {
			if (Integer.parseInt(actual[0]) < Integer.parseInt(introd[0])) {
				if ((Integer.parseInt(actual[2])-Integer.parseInt(introd[2])-1)<21)
					   aux = false;
				else
					aux = true;
				
			}
			else {
				if ((Integer.parseInt(actual[2])-Integer.parseInt(introd[2]))<21)
					   aux = false;
				else
					aux = true;
			}
		}
		else {
			if ((Integer.parseInt(actual[2])-Integer.parseInt(introd[2]))<21) 
			    aux = false;
			else 
				aux = true;
		
		}
		return aux;
	}
   private void loadWorker() {
	    cedulaText.setText(worker.getIdNumber());
	    cedulaText.setEditable(false);
	    apellidos.setText(worker.getLastName());
	    nombres.setText(worker.getFirstName());
	    for (int i =0; i<2;i++) {
	    	if (sexo.getItemAt(i).equals(worker.getSex())) 
	    		sexo.setSelectedIndex(i);
	    }
	    sexo.setEnabled(false);
	    ((JTextField)dateChooser.getDateEditor().getUiComponent()).setText(worker.getBirthday());
	    salario.setText(String.valueOf(worker.getHourlyPayment()));
	    horasTrabajo.setText(String.valueOf(worker.getWorkedHours()));
	    telefonoText.setText(worker.getTelefono());
	    String[] separator = worker.getAddress().split("/");
	    for (int i =0;i<32;i++) {
	    	if (provincia.getItemAt(i).equals(separator[0]));
	    	provincia.setSelectedIndex(i);
	    }
	    localidad.setText(separator[1]);
	    calle.setText(separator[2]);
	    numero.setText(separator[3]);
	    if (worker instanceof ProjectBoss) {
	    	jefeProyecto.setSelected(true);
	    	contrasenia.setText(((ProjectBoss)worker).getPassword());
	    }
	    else if (worker instanceof Planner) {
	    	planeador.setSelected(true);
	    }
	    else if (worker instanceof Designer) {
	    	diseniador.setSelected(true);
	    }
	    else if (worker instanceof SoftwareTester) {
	    	tester.setSelected(true);
	    }
	    else {
	    	programador.setSelected(true);
	    	tipoProgramador.setText(((Programmer)worker).getProgrammerType());
	    	lenguajeDeProgramacion.setText(((Programmer)worker).getProgrammingLanguage());
	    }
	    	jefeProyecto.setEnabled(false);
	    	planeador.setEnabled(false);
	    	diseniador.setEnabled(false);
	    	tester.setEnabled(false);
	    	programador.setEnabled(false);
	    	
	    	
	    	tipoProgramador.setEditable(false);
	    	lenguajeDeProgramacion.setEditable(false);
	    	contrasenia.setEditable(false);   
   }
   private void clean() {
	   cedulaText.setValue(null);
	   apellidos.setText("");
	   nombres.setText("");
	   sexo.setSelectedIndex(0);
	   ((JTextField)dateChooser.getDateEditor().getUiComponent()).setText("");
	   salario.setText("");
	   horasTrabajo.setText("");
	   telefonoText.setValue(null);
	   provincia.setSelectedIndex(0);
	   localidad.setText("");
	   calle.setText("");
	   numero.setText("");
	   jefeProyecto.setSelected(true);
	   planeador.setSelected(false);
	   programador.setSelected(false);
	   diseniador.setSelected(false);
	   tester.setSelected(false);
	   tipoProgramador.setText("");
	   lenguajeDeProgramacion.setText("");
	   contrasenia.setText("");
   }
}
