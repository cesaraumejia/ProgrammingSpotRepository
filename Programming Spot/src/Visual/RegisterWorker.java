package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
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
	private JFormattedTextField telefonoText;
	private JTextField localidad;
	private JTextField calle;
	private ImageIcon workerIcon = new ImageIcon(RegisterWorker.class.getResource("/icons/worker.png"));
	private ImageIcon contractIcon =new ImageIcon(RegisterClient.class.getResource("/icons/contract.png"));
	private ImageIcon clientIcon = new ImageIcon(RegisterClient.class.getResource("/icons/client.png"));
	private JFormattedTextField cedulaText;
	private JComboBox<String> sexo;
	private JTextField tipoProgramador;
	private JTextField lenguajeDeProgramacion;
	private JRadioButton planeador;
	private JRadioButton programador;
	private JRadioButton diseniador;
	private JRadioButton tester;
	private JLabel lblcontrasea;
	private JLabel lblLenguaje;
	private JLabel lblTipoDeProgramador;
	private JComboBox<String> provincia;
	private JDateChooser dateChooser;
	private Worker worker;
	private JRadioButton jefeProyecto;
	private JTextField softwareDisenio;
	private JTextField testingSoftware;
	private JLabel softwarePrueba;
	private JLabel softwareD;
	private JLabel lblOrientacion;
	private JLabel lblMetodologia;
	private JComboBox<String> metodologia;
	private JComboBox<String> orientacion;
	private JSpinner horasTrabajo;
	private JSpinner aniosExperiencia;
	private JSpinner numero;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RegisterWorker(final boolean registerModify, final Worker worker) throws ParseException {
		this.worker = worker;
		setUndecorated(true);
		setBounds(100, 100, 690, 597);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(112, 128, 144), 2));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(1050, 0, 690, 29);
			contentPanel.add(panel);
			{
				JLabel lblE = new JLabel("e");
				panel.add(lblE);
			}
		}
		{
			JPanel topPanel = new JPanel();
			topPanel.setBorder(new LineBorder(new Color(112, 128, 144), 2));
			topPanel.setBounds(0, 0, 690, 29);
			contentPanel.add(topPanel);
			topPanel.setLayout(null);
			{
				JLabel lblNewLabel_1;
				if (!registerModify)
				lblNewLabel_1 = new JLabel("Registrar Trabajador");
				else
					lblNewLabel_1 = new JLabel("Modificar Trabajador");
				lblNewLabel_1.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
				lblNewLabel_1.setBounds(12, 1, 185, 27);
				topPanel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(662, 0, 26, 26);
				topPanel.add(lblNewLabel);
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
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(220,220,220));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Datos Personales", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 55, 670, 204);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel_3 = new JLabel("C\u00E9dula: ");
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
				JLabel lblApellidos = new JLabel("Apellidos: ");
				lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblApellidos.setBounds(12, 69, 75, 16);
				panel.add(lblApellidos);
			}
			
			apellidos = new JTextField();
			apellidos.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú'))
						e.consume();
				}
			});
			apellidos.setHorizontalAlignment(SwingConstants.CENTER);
			apellidos.setBackground(new Color(230,230,250));
			apellidos.setBounds(106, 67, 207, 22);
			panel.add(apellidos);
			apellidos.setColumns(10);
			
			JLabel lblNombres = new JLabel("Nombres: ");
			lblNombres.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNombres.setBounds(360, 30, 75, 16);
			panel.add(lblNombres);
			
			nombres = new JTextField();
			nombres.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú'))
						e.consume();
				}
			});
			nombres.setHorizontalAlignment(SwingConstants.CENTER);
			nombres.setBackground(new Color(230,230,250));
			nombres.setBounds(455, 28, 191, 22);
			panel.add(nombres);
			nombres.setColumns(10);
			
			JLabel lblSexo = new JLabel("Sexo: ");
			lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSexo.setBounds(12, 112, 75, 14);
			panel.add(lblSexo);
			
			sexo = new JComboBox<String>();
			sexo.setBackground(new Color(230,230,250));
			sexo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Masculino ", "Femenino"}));
			sexo.setBounds(106, 108, 207, 22);
			((JLabel)sexo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(sexo);
			
			JLabel lblNewLabel_4 = new JLabel("Fecha de nacimiento: ");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4.setBounds(360, 73, 157, 14);
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("Pago por hora: ");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_5.setBounds(360, 154, 125, 16);
			panel.add(lblNewLabel_5);
			
			salario = new JTextField();
			salario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c =  e.getKeyChar();
					if((c < '0' || c > '9') && c != '.')
						e.consume();
					if (dotAmount() && c=='.')
						e.consume();
					if (c=='.' && salario.getText().length()==0)
						e.consume();
				}
			});
			salario.setHorizontalAlignment(SwingConstants.CENTER);
			salario.setBackground(new Color(230,230,250));
			salario.setBounds(501, 152, 145, 22);
			panel.add(salario);
			salario.setColumns(10);
			
			JLabel lblNewLabel_6 = new JLabel("Horas de trabajo: ");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_6.setBounds(12, 150, 145, 16);
			panel.add(lblNewLabel_6);
			
			JLabel lblTelfono = new JLabel("Tel\u00E9fono: ");
			lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTelfono.setBounds(360, 111, 86, 14);
			panel.add(lblTelfono);
			
			telefonoText = new JFormattedTextField(telefono);
			telefonoText.setBackground(new Color(230,230,250));
			telefonoText.setHorizontalAlignment(SwingConstants.CENTER);
			telefonoText.setBounds(439, 108, 207, 22);
			panel.add(telefonoText);
			telefonoText.setColumns(10);
			
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("dd/MM/yyyy");
			dateChooser.getDateEditor().setEnabled(false);
			dateChooser.setBounds(521, 69, 125, 22);
			dateChooser.getJCalendar().setSelectableDateRange(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970"), new Date());
			panel.add(dateChooser);
			
			horasTrabajo = new JSpinner();
			horasTrabajo.setEnabled(false);
			horasTrabajo.setModel(new SpinnerNumberModel(8, 8, 8, 1));
			horasTrabajo.setBounds(167, 149, 146, 21);
			panel.add(horasTrabajo);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Nota: Todos los campos son obligatorios");
			lblNewLabel_2.setForeground(new Color(255, 0, 0));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
			lblNewLabel_2.setBounds(10, 35, 255, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Direcci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBackground(new Color(220,220,220));
			panel.setBounds(10, 270, 670, 133);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblProvincia = new JLabel("Provincia: ");
			lblProvincia.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblProvincia.setBounds(10, 35, 81, 14);
			panel.add(lblProvincia);
			
			JLabel lblLocalidad = new JLabel("Localidad: ");
			lblLocalidad.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblLocalidad.setBounds(358, 35, 81, 14);
			panel.add(lblLocalidad);
			
			localidad = new JTextField();
			localidad.setHorizontalAlignment(SwingConstants.CENTER);
			localidad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú'))
						e.consume();
				}
			});
			localidad.setBackground(new Color(230,230,250));
			localidad.setBounds(445, 30, 207, 22);
			panel.add(localidad);
			localidad.setColumns(10);
			
			JLabel lblCalle = new JLabel("Calle: ");
			lblCalle.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCalle.setBounds(10, 84, 57, 14);
			panel.add(lblCalle);
			
			calle = new JTextField();
			calle.setHorizontalAlignment(SwingConstants.CENTER);
		
			calle.setBackground(new Color(230,230,250));
			calle.setBounds(106, 80, 207, 22);
			panel.add(calle);
			calle.setColumns(10);
			
			JLabel lblNo = new JLabel("No: ");
			lblNo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNo.setBounds(358, 84, 57, 14);
			panel.add(lblNo);
			
			provincia = new JComboBox<String>();
			provincia.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Azua", "Bahoruco", "Barahona", "Dajab\u00F3n", 
					"Distrito Nacional", "Duarte", "El\u00EDas Pi\u00F1a", "El Seibo", "Espaillat", "Hato Mayor", "Hermanas Mirabal",
					"Independencia", "La Altagracia", "La Romana", "La Vega", "Mar\u00EDa Trinidad S\u00E1nchez", "Monse\u00F1or Nouel",
					"Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata", "Saman\u00E1", "San Crist\u00F3bal", 
					"San Jos\u00E9 De Ocoa", "San Juan", "San Pedro de Macor\u00EDs", "S\u00E1nchez Ramirez", "Santiago",
					"Santiago Rodr\u00EDguez", "Santo Domingo", "Valverde"}));
			provincia.setBounds(106, 29, 207, 22);
			((JLabel)provincia.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(provincia);
			
			numero = new JSpinner();
			numero.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			numero.setBackground(new Color(230, 230, 250));
			numero.setBounds(445, 82, 207, 21);
			panel.add(numero);
		}
		
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
			    aniosExperiencia.setVisible(true);
			    lblTipoDeProgramador.setVisible(false);
			    tipoProgramador.setVisible(false);
			    lblLenguaje.setVisible(false);
			    lenguajeDeProgramacion.setVisible(false);
			    
			    lblOrientacion.setVisible(false);
			    orientacion.setVisible(false);
			    softwareD.setVisible(false);
			    softwareDisenio.setVisible(false);
			    softwarePrueba.setVisible(false);
			    testingSoftware.setVisible(false);
			    lblMetodologia.setVisible(false);
			    metodologia.setVisible(false);
			    
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
			    aniosExperiencia.setVisible(false);
			    lblTipoDeProgramador.setVisible(false);
			    tipoProgramador.setVisible(false);
			    lblLenguaje.setVisible(false);
			    lenguajeDeProgramacion.setVisible(false);
			    
			    lblOrientacion.setVisible(false);
			    orientacion.setVisible(false);
			    softwareD.setVisible(false);
			    softwareDisenio.setVisible(false);
			    softwarePrueba.setVisible(false);
			    testingSoftware.setVisible(false);
			    lblMetodologia.setVisible(true);
			    metodologia.setVisible(true);
			}
		});
		planeador.setBackground(new Color(220, 220,220));
		planeador.setFont(new Font("Tahoma", Font.BOLD, 13));
		planeador.setBounds(167, 421, 109, 23);
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
			    aniosExperiencia.setVisible(false);
			    lblTipoDeProgramador.setVisible(true);
			    tipoProgramador.setVisible(true);
			    lblLenguaje.setVisible(true);
			    lenguajeDeProgramacion.setVisible(true);
			    
			    lblOrientacion.setVisible(false);
			    orientacion.setVisible(false);
			    softwareD.setVisible(false);
			    softwareDisenio.setVisible(false);
			    softwarePrueba.setVisible(false);
			    testingSoftware.setVisible(false);
			    lblMetodologia.setVisible(false);
			    metodologia.setVisible(false);
			}
		});
		programador.setBackground(new Color(220, 220,220));
		programador.setFont(new Font("Tahoma", Font.BOLD, 13));
		programador.setBounds(292, 421, 128, 23);
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
			    aniosExperiencia.setVisible(false);
			    lblTipoDeProgramador.setVisible(false);
			    tipoProgramador.setVisible(false);
			    lblLenguaje.setVisible(false);
			    lenguajeDeProgramacion.setVisible(false);
			    
			    lblOrientacion.setVisible(true);
			    orientacion.setVisible(true);
			    softwareD.setVisible(true);
			    softwareDisenio.setVisible(true);
			    softwarePrueba.setVisible(false);
			    testingSoftware.setVisible(false);
			    lblMetodologia.setVisible(false);
			    metodologia.setVisible(false);
			}
		});
		diseniador.setBackground(new Color(220, 220,220));
		diseniador.setFont(new Font("Tahoma", Font.BOLD, 13));
		diseniador.setBounds(437, 421, 109, 23);
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
			    aniosExperiencia.setVisible(false);
			    lblTipoDeProgramador.setVisible(false);
			    tipoProgramador.setVisible(false);
			    lblLenguaje.setVisible(false);
			    lenguajeDeProgramacion.setVisible(false);
			    
			    lblOrientacion.setVisible(false);
			    orientacion.setVisible(false);
			    softwareD.setVisible(false);
			    softwareDisenio.setVisible(false);
			    softwarePrueba.setVisible(true);
			    testingSoftware.setVisible(true);
			    lblMetodologia.setVisible(false);
			    metodologia.setVisible(false);
			}
		});
		tester.setBackground(new Color(220, 220,220));
		tester.setFont(new Font("Tahoma", Font.BOLD, 13));
		tester.setBounds(570, 421, 109, 23);
		contentPanel.add(tester);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Detalles de trabajador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(220,220,220));
		panel.setBounds(10, 462, 670, 75);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblcontrasea = new JLabel("A\u00F1os de experiencia: ");
		lblcontrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblcontrasea.setBounds(10, 31, 158, 14);
		panel.add(lblcontrasea);
		
		lblTipoDeProgramador = new JLabel("Tipo de programador: ");
		lblTipoDeProgramador.setVisible(false);
		lblTipoDeProgramador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeProgramador.setBounds(10, 31, 169, 16);
		panel.add(lblTipoDeProgramador);
		
		tipoProgramador = new JTextField();
		tipoProgramador.setHorizontalAlignment(SwingConstants.CENTER);
		tipoProgramador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú'))
					e.consume();
			}
		});
		tipoProgramador.setBackground(new Color(230,230,250));
		tipoProgramador.setVisible(false);
		tipoProgramador.setBounds(189, 29, 168, 22);
		panel.add(tipoProgramador);
		tipoProgramador.setColumns(10);
		
		lblLenguaje = new JLabel("Lenguaje: ");
		lblLenguaje.setVisible(false);
		lblLenguaje.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLenguaje.setBounds(367, 31, 203, 16);
		panel.add(lblLenguaje);
		
		lenguajeDeProgramacion = new JTextField();
		lenguajeDeProgramacion.setHorizontalAlignment(SwingConstants.CENTER);
		lenguajeDeProgramacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c != ' ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú'))
					e.consume();
			}
		});
		lenguajeDeProgramacion.setBackground(new Color(230,230,250));
		lenguajeDeProgramacion.setVisible(false);
		lenguajeDeProgramacion.setBounds(446, 28, 190, 22);
		panel.add(lenguajeDeProgramacion);
		lenguajeDeProgramacion.setColumns(10);
		
		lblOrientacion = new JLabel("Orientaci\u00F3n de Dise\u00F1o: ");
		lblOrientacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrientacion.setBounds(10, 31, 158, 16);
		panel.add(lblOrientacion);
		
		softwareD = new JLabel("Software de dise\u00F1o: ");
		softwareD.setFont(new Font("Tahoma", Font.BOLD, 13));
		softwareD.setBounds(367, 31, 203, 16);
		panel.add(softwareD);
		
		softwareDisenio = new JTextField();
		softwareDisenio.setHorizontalAlignment(SwingConstants.CENTER);
		softwareDisenio.setBackground(new Color(230, 230, 250));
		softwareDisenio.setBounds(507, 28, 147, 22);
		panel.add(softwareDisenio);
		softwareDisenio.setColumns(10);
		
		softwarePrueba = new JLabel("Softwares de prueba: ");
		softwarePrueba.setFont(new Font("Tahoma", Font.BOLD, 13));
		softwarePrueba.setBounds(10, 31, 158, 16);
		panel.add(softwarePrueba);
		
		testingSoftware = new JTextField();
		testingSoftware.setHorizontalAlignment(SwingConstants.CENTER);
		testingSoftware.setBackground(new Color(230, 230, 250));
		testingSoftware.setBounds(178, 29, 179, 22);
		panel.add(testingSoftware);
		testingSoftware.setColumns(10);
		
		lblMetodologia = new JLabel("Metodolog\u00EDa: ");
		lblMetodologia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMetodologia.setBounds(10, 31, 118, 16);
		panel.add(lblMetodologia);
		
		metodologia = new JComboBox();
		metodologia.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Scrum\t", "Cristal", "XP (Xtreme Programming)"}));
		metodologia.setBounds(138, 29, 219, 22);
		((JLabel)metodologia.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(metodologia);
		
		orientacion = new JComboBox();
		orientacion.setVisible(false);
		orientacion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Web", "Desktop"}));
		orientacion.setBounds(178, 29, 179, 22);
		((JLabel)orientacion.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(orientacion);
		
		aniosExperiencia = new JSpinner();
		aniosExperiencia.setBackground(new Color(230, 230, 250));
		aniosExperiencia.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		aniosExperiencia.setBounds(178, 29, 179, 21);
		panel.add(aniosExperiencia);
		super.getToolkit().getScreenSize(); 
		this.setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		
		  lblOrientacion.setVisible(false);
		  softwareD.setVisible(false);
		  softwareDisenio.setVisible(false);
		  softwarePrueba.setVisible(false);
		  testingSoftware.setVisible(false);
		  lblMetodologia.setVisible(false);
		  metodologia.setVisible(false);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(112, 128, 144), 2));
			buttonPane.setBackground(new Color(220,220,220));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton registrarButton;
				if (!registerModify)
				 registrarButton = new JButton("Registrar");
				else
					 registrarButton = new JButton("Modificar");
				registrarButton.setBackground(new Color(255,255,240));
				registrarButton.addActionListener(new ActionListener() {
					/* (non-Javadoc)
					 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
					 */
					public void actionPerformed(ActionEvent e) {
						if (!registerModify) {
					    if (cedulaText.getText().equals("___-_______-_")||apellidos.getText().equals("")||provincia.getSelectedIndex()==0||nombres.getText().equals("")||sexo.getSelectedIndex()==0||telefonoText.getText().equals("___-___-____")||salario.getText().equals("")||localidad.getText().equals("")||((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().equals("")||calle.getText().equals(""))
							JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar","Hay campos obligatorios vacios", JOptionPane.WARNING_MESSAGE, null);
					    else if ((programador.isSelected()&&(lenguajeDeProgramacion.getText().equals("")||tipoProgramador.getText().equals("")))||(planeador.isSelected()&&(metodologia.getSelectedIndex()==0))||(tester.isSelected()&&testingSoftware.getText().equals(""))||(diseniador.isSelected()&&(orientacion.getSelectedIndex()==0||softwareDisenio.getText().equals("")))) {
					    	JOptionPane.showMessageDialog(null, "Hay campos obligatorios vacios","Rellene todos los campos para continuar", JOptionPane.WARNING_MESSAGE, null);
					    }
					    else if (!validarFecha(dateChooser))
					    	JOptionPane.showMessageDialog(null, "La trabajador no puede ser tan joven","Fecha inválida", JOptionPane.WARNING_MESSAGE, null);
					    else if (!existingID(cedulaText.getText()))
					    {
					    	Worker worker = null;
					    	if (jefeProyecto.isSelected()) {
					    		worker = new ProjectBoss();
					    		((ProjectBoss)worker).setExperienceYears((int)aniosExperiencia.getValue());
					    	}
					    	else if (diseniador.isSelected()){
					    		worker = new Designer();
					    		((Designer)worker).setDesignerField(orientacion.getSelectedItem().toString());
					    		((Designer)worker).setDesigningSoftware((softwareDisenio.getText()));
					    	}
					    	else if (programador.isSelected()) {
					    		worker = new Programmer();
					    		((Programmer)worker).setProgrammerType(tipoProgramador.getText());
					    		((Programmer)worker).setProgrammingLanguage(lenguajeDeProgramacion.getText());
					    	}
					    	else if (tester.isSelected()) {
					    		worker = new SoftwareTester();
					    		((SoftwareTester)worker).setTestingSoftware(testingSoftware.getText());
					    		
					    	}
					    	else {
					    		worker = new Planner();
					    	    ((Planner)worker).setMethodology(metodologia.getSelectedItem().toString());
					    	}
					    		worker.setAddress(provincia.getSelectedItem()+"/"+localidad.getText()+"/"+calle.getText()+"/"+numero.getValue());
					 
					    	worker.setWorkedHours((int) horasTrabajo.getValue());
					    	worker.setFirstName(nombres.getText());
					    	worker.setLastName(apellidos.getText());
					    	worker.setIdNumber(cedulaText.getText());
					        worker.setSex(sexo.getSelectedItem().toString());
					    	worker.setBirthday(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					    	worker.setTelefono(telefonoText.getText());
					    	worker.setHourlyPayment(Float.parseFloat(salario.getText()));
					    	Admin.getInstance().addWorker(worker);
					    	//Guardado
					    	Admin.getInstance().saveWorkers();
					    	//
						JOptionPane.showMessageDialog(null, "¡El trabajador ha sido agregado!", "Trabajador Agregado", JOptionPane.INFORMATION_MESSAGE, clientIcon);
					        clean();
					    }
					    else {
							JOptionPane.showMessageDialog(null, "Este trabajador ya existe", "Trabajador existente", JOptionPane.WARNING_MESSAGE, clientIcon);
					    }
					}
						else {
							
							int index = Admin.getInstance().getWorkers().indexOf(worker);
							
							if (cedulaText.getText().equals("___-_______-_")||apellidos.getText().equals("")||provincia.getSelectedIndex()==0||nombres.getText().equals("")||sexo.getSelectedIndex()==0||telefonoText.getText().equals("___-___-____")||salario.getText().equals("")||localidad.getText().equals("")||((JTextField)dateChooser.getDateEditor().getUiComponent()).getText().equals("")||calle.getText().equals(""))
								JOptionPane.showMessageDialog(null, "Rellene todos los campos para continuar","Hay campos obligatorios vacios", JOptionPane.WARNING_MESSAGE, null);
							else if ((jefeProyecto.isSelected())||(programador.isSelected()&&(lenguajeDeProgramacion.getText().equals("")||tipoProgramador.getText().equals("")))||(planeador.isSelected()&&(metodologia.getSelectedIndex()==0))||(tester.isSelected()&&testingSoftware.getText().equals(""))||(diseniador.isSelected()&&(orientacion.getSelectedIndex()==0||softwareDisenio.getText().equals("")))){
						    	JOptionPane.showMessageDialog(null, "Hay campos obligatorios vacios","Rellene todos los campos para continuar", JOptionPane.WARNING_MESSAGE, null);
						    }
						    else if (!validarFecha(dateChooser))
						    	JOptionPane.showMessageDialog(null, "La trabajador no puede ser tan joven","Fecha inválida", JOptionPane.WARNING_MESSAGE, null);
						    else if (!existingID(cedulaText.getText()))
						    {
						    	Worker worker = null;
						    	if (jefeProyecto.isSelected()) {
						    		worker = new ProjectBoss();
						    		((ProjectBoss)worker).setExperienceYears((int)aniosExperiencia.getValue());
						    	}
						    	else if (diseniador.isSelected()){
						    		worker = new Designer();
						    		((Designer)worker).setDesignerField(orientacion.getSelectedItem().toString());
						    		((Designer)worker).setDesigningSoftware((softwareDisenio.getText()));
						    	}
						    	else if (programador.isSelected()) {
						    		worker = new Programmer();
						    		((Programmer)worker).setProgrammerType(tipoProgramador.getText());
						    		((Programmer)worker).setProgrammingLanguage(lenguajeDeProgramacion.getText());
						    	}
						    	else if (tester.isSelected()) {
						    		worker = new SoftwareTester();
						    		((SoftwareTester)worker).setTestingSoftware(testingSoftware.getText());
						    		
						    	}
						    	else {
						    		worker = new Planner();
						    	    ((Planner)worker).setMethodology(metodologia.getSelectedItem().toString());
						    	}
						    	
						    		worker.setAddress(provincia.getSelectedItem()+"/"+localidad.getText()+"/"+calle.getText()+"/"+numero.getValue());
						 
						    	worker.setWorkedHours((int)horasTrabajo.getValue());
						    	worker.setFirstName(nombres.getText());
						    	worker.setLastName(apellidos.getText());
						    	worker.setIdNumber(cedulaText.getText());
						        worker.setSex(sexo.getSelectedItem().toString());
						    	worker.setBirthday(((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
						    	worker.setTelefono(telefonoText.getText());
						    	worker.setHourlyPayment(Float.parseFloat((salario.getText())));
						    	worker.setAvailable(0);
						    	Admin.getInstance().getWorkers().remove(index);
						    	Admin.getInstance().getWorkers().add(worker);
						    	//Guardado
						    	Admin.getInstance().saveWorkers();
						    	//
							JOptionPane.showMessageDialog(null, "¡El trabajador ha sido modificado!", "Trabajador modificado", JOptionPane.INFORMATION_MESSAGE, clientIcon);
						        dispose();
						    }
						    else {
								JOptionPane.showMessageDialog(null, "Este trabajador ya existe", "Trabajador existente", JOptionPane.WARNING_MESSAGE, clientIcon);
						    }
							
						}
					}
				
				});
				registrarButton.setActionCommand("OK");
				buttonPane.add(registrarButton);
				getRootPane().setDefaultButton(registrarButton);
			}
			{
				JButton salirButton = new JButton("Salir");
				salirButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
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
				salirButton.setBackground(new Color(255, 255, 240));
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
		   if ((Integer.parseInt(actual[2])-Integer.parseInt(introd[2])-1)<18)
			   aux = false;
		   else 
			   aux = true;
		}
		else if (Integer.parseInt(actual[1]) == Integer.parseInt(introd[1])) {
			if (Integer.parseInt(actual[0]) < Integer.parseInt(introd[0])) {
				if ((Integer.parseInt(actual[2])-Integer.parseInt(introd[2])-1)<18)
					   aux = false;
				else
					aux = true;
				
			}
			else {
				if ((Integer.parseInt(actual[2])-Integer.parseInt(introd[2]))<18)
					   aux = false;
				else
					aux = true;
			}
		}
		else {
			if ((Integer.parseInt(actual[2])-Integer.parseInt(introd[2]))<18) 
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
	    horasTrabajo.setValue(worker.getWorkedHours());
	    telefonoText.setText(worker.getTelefono());
	    String[] separator = worker.getAddress().split("/");
	    for (int i =0;i<32;i++) {
	    	if (provincia.getItemAt(i).equals(separator[0]));
	    	provincia.setSelectedIndex(i);
	    }
	    localidad.setText(separator[1]);
	    calle.setText(separator[2]);
	    numero.setValue(Integer.parseInt(separator[3]));
	    if (worker instanceof ProjectBoss) {
	    	jefeProyecto.setSelected(true);
	    	aniosExperiencia.setValue(((ProjectBoss)worker).getExperienceYears());
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
	    	aniosExperiencia.setEnabled(false);   
   }
   private void clean() {
	   cedulaText.setValue(null);
	   apellidos.setText("");
	   nombres.setText("");
	   sexo.setSelectedIndex(0);
	   ((JTextField)dateChooser.getDateEditor().getUiComponent()).setText("");
	   salario.setText("");
	   horasTrabajo.setValue(1);
	   telefonoText.setValue(null);
	   provincia.setSelectedIndex(0);
	   localidad.setText("");
	   calle.setText("");
	   numero.setValue(1);
	   jefeProyecto.setSelected(true);
	   planeador.setSelected(false);
	   programador.setSelected(false);
	   diseniador.setSelected(false);
	   tester.setSelected(false);
	   tipoProgramador.setText("");
	   lenguajeDeProgramacion.setText("");
	   aniosExperiencia.setValue(0);
	   
	   lblcontrasea.setVisible(true);
	    aniosExperiencia.setVisible(true);
	    lblTipoDeProgramador.setVisible(false);
	    tipoProgramador.setVisible(false);
	    lblLenguaje.setVisible(false);
	    lenguajeDeProgramacion.setVisible(false);
	    
	    lblOrientacion.setVisible(false);
	    orientacion.setVisible(false);
	    softwareD.setVisible(false);
	    softwareDisenio.setVisible(false);
	    softwarePrueba.setVisible(false);
	    testingSoftware.setVisible(false);
	    lblMetodologia.setVisible(false);
	    metodologia.setVisible(false);
   }
   private boolean existingID(String ID) {
	   boolean aux = false;
	   for (Worker i: Admin.getInstance().getWorkers()) {
		   if (i.getIdNumber().equals(ID))
			   aux = true;
	   }
	   return aux;
   }
   private boolean dotAmount() {
	   boolean aux = false;
	   String aux1 = salario.getText();
	   char[] aux2 = aux1.toCharArray();
	   for (int i =0;i<aux2.length;i++) {
		   if (aux2[i]=='.')
			   aux = true;
	   }
	   return aux;
   }
}