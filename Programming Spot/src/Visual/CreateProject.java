package Visual;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Logico.Admin;
import Logico.Designer;
import Logico.Planner;
import Logico.Programmer;
import Logico.Project;
import Logico.ProjectBoss;
import Logico.SoftwareTester;
import Logico.Worker;

@SuppressWarnings("unused")
public class CreateProject extends JDialog {

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
    private JTextField tfdTitulo;
    
    // ***Check Boxes***
    private JCheckBox chkJefeDeProyecto;
    private JCheckBox chkProgramador1;
    private JCheckBox chkProgramador2;
    private JCheckBox chkPlaneador;
    private JCheckBox chkDiseador;
    private JCheckBox chkTester;
    
    // ***Combo Boxes***
    private JComboBox<String> cbxTipo;
    private JComboBox<String> cbxLenguaje;
    private JComboBox<String> cbxJefeDeProyecto;
    private JComboBox<String> cbxProgramador1;
    private JComboBox<String> cbxProgramador2;
    private JComboBox<String> cbxPlaneador;
    private JComboBox<String> cbxDiseador;
    private JComboBox<String> cbxTester;
    private JLabel lblNewLabel_1;
    
    public CreateProject() {
 ///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
    	setUndecorated(true);
	setBounds(100, 100, 702, 346);
	getContentPane().setLayout(new BorderLayout());
	contentPane.setBorder(new LineBorder(new Color(112, 128, 144), 2));
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
	    buttonPane.setBorder(new LineBorder(new Color(112, 128, 144), 2));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBackground(new Color(255,255,240));
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = tfdTitulo.getText();
				String tipo = cbxTipo.getSelectedItem().toString();
				String lenguaje = cbxLenguaje.getSelectedItem().toString();
				String nombreJefe = cbxJefeDeProyecto.getSelectedItem().toString();
				String nombreProgramador1 = cbxProgramador1.getSelectedItem().toString();
				String nombreProgramador2 = cbxProgramador2.getSelectedItem().toString();
				String nombrePlaneador = cbxPlaneador.getSelectedItem().toString();
				String nombreDiseador = cbxDiseador.getSelectedItem().toString();
				String nombreTester = cbxTester.getSelectedItem().toString();
				
				if(tfdTitulo.getText().equalsIgnoreCase("") || cbxTipo.getSelectedItem().equals("<Seleccione>") 
						|| (cbxLenguaje.getSelectedItem().equals("<Seleccione un tipo>") || cbxLenguaje.getSelectedItem().equals("<Seleccione un lenguaje>")) || cbxJefeDeProyecto.getSelectedItem().equals("<Seleccione>") 
						|| cbxProgramador1.getSelectedItem().equals("<Seleccione>") || cbxProgramador2.getSelectedItem().equals("<Seleccione>") 
						|| (chkPlaneador.isSelected() && cbxPlaneador.getSelectedItem().equals("<Seleccione>")) 
						|| (chkDiseador.isSelected() && cbxDiseador.getSelectedItem().equals("<Seleccione>"))
						|| (chkTester.isSelected() && cbxTester.getSelectedItem().equals("<Seleccione>"))){
					JOptionPane.showMessageDialog(null, "Asegurese de llenar los campos obligatorios.", "Campos vacios", JOptionPane.WARNING_MESSAGE, null);
				}
				else if (chkDiseador.isSelected() && !chkPlaneador.isSelected() && !chkTester.isSelected()){
					ProjectBoss jefeProyecto = Admin.getInstance().bossByName(nombreJefe);
					jefeProyecto.setAvailable(jefeProyecto.getAvailable() + 1);
					Programmer programador1 = Admin.getInstance().programmerByName(nombreProgramador1);
					programador1.setAvailable(programador1.getAvailable() + 1);
					Programmer  programador2 = Admin.getInstance().programmerByName(nombreProgramador2);
					programador2.setAvailable(programador2.getAvailable() + 1);
					Designer designer = Admin.getInstance().designerByName(nombreDiseador);
					designer.setAvailable(designer.getAvailable() + 1);
					Project newProject = Admin.getInstance().createProject(titulo, tipo, lenguaje, "En progreso", jefeProyecto, null, designer, null, programador1, programador2);
					Admin.getInstance().addProject(newProject);
					//JOptionPane.showMessageDialog(null, "¡El proyecto ha sido agregado!", "Proyecto agregado", JOptionPane.INFORMATION_MESSAGE, contractIcon);
					//clean();
					dispose();
					CreateContract contract = new CreateContract(newProject, false, null, -1);
					contract.setVisible(true);
					
				}
				else if(chkPlaneador.isSelected() && !chkDiseador.isSelected() && !chkTester.isSelected()){
					ProjectBoss jefeProyecto = Admin.getInstance().bossByName(nombreJefe);
					jefeProyecto.setAvailable(jefeProyecto.getAvailable() + 1);
					Programmer programador1 = Admin.getInstance().programmerByName(nombreProgramador1);
					programador1.setAvailable(programador1.getAvailable() + 1);
					Programmer  programador2 = Admin.getInstance().programmerByName(nombreProgramador2);
					programador2.setAvailable(programador2.getAvailable() + 1);
					Planner planner = Admin.getInstance().plannerByName(nombrePlaneador);
					planner.setAvailable(planner.getAvailable() + 1);
					Project newProject = Admin.getInstance().createProject(titulo, tipo, lenguaje, "En progreso", jefeProyecto, planner, null, null, programador1, programador2);
					Admin.getInstance().addProject(newProject);
					//JOptionPane.showMessageDialog(null, "¡El proyecto ha sido agregado!", "Proyecto agregado", JOptionPane.INFORMATION_MESSAGE, contractIcon);
					//clean();
					dispose();
					CreateContract contract = new CreateContract(newProject, false, null, -1);
					contract.setVisible(true);
				}
				else if(chkPlaneador.isSelected() && chkDiseador.isSelected() && !chkTester.isSelected()){
					ProjectBoss jefeProyecto = Admin.getInstance().bossByName(nombreJefe);
					Programmer programador1 = Admin.getInstance().programmerByName(nombreProgramador1);
					Programmer  programador2 = Admin.getInstance().programmerByName(nombreProgramador2);
					jefeProyecto.setAvailable(jefeProyecto.getAvailable() + 1);
					programador1.setAvailable(programador1.getAvailable() + 1);
					programador2.setAvailable(programador2.getAvailable() + 1);
					Planner planner = Admin.getInstance().plannerByName(nombrePlaneador);
					Designer designer = Admin.getInstance().designerByName(nombreDiseador);
					planner.setAvailable(planner.getAvailable() + 1);
					designer.setAvailable(designer.getAvailable() + 1);
					Project newProject = Admin.getInstance().createProject(titulo, tipo, lenguaje, "En progreso", jefeProyecto, planner, designer, null, programador1, programador2);
					Admin.getInstance().addProject(newProject);
					//JOptionPane.showMessageDialog(null, "¡El proyecto ha sido agregado!", "Proyecto agregado", JOptionPane.INFORMATION_MESSAGE, contractIcon);
					//clean();
					dispose();
					CreateContract contract = new CreateContract(newProject, false, null, -1);
					contract.setVisible(true);
				}
				else if(!chkPlaneador.isSelected() && !chkDiseador.isSelected() && chkTester.isSelected()){
					ProjectBoss jefeProyecto = Admin.getInstance().bossByName(nombreJefe);
					Programmer programador1 = Admin.getInstance().programmerByName(nombreProgramador1);
					Programmer  programador2 = Admin.getInstance().programmerByName(nombreProgramador2);
					SoftwareTester tester = Admin.getInstance().testerByName(nombreTester);
					jefeProyecto.setAvailable(jefeProyecto.getAvailable() + 1);
					programador1.setAvailable(programador1.getAvailable() + 1);
					programador2.setAvailable(programador2.getAvailable() + 1);
					tester.setAvailable(tester.getAvailable() + 1);
					
					Project newProject = Admin.getInstance().createProject(titulo, tipo, lenguaje, "En progreso", jefeProyecto, null, null, tester, programador1, programador2);
					Admin.getInstance().addProject(newProject);
					//JOptionPane.showMessageDialog(null, "¡El proyecto ha sido agregado!", "Proyecto agregado", JOptionPane.INFORMATION_MESSAGE, contractIcon);
					//clean();
					dispose();
					CreateContract contract = new CreateContract(newProject, false, null, -1);
					contract.setVisible(true);
				}
				else if(!chkPlaneador.isSelected() && chkDiseador.isSelected() && chkTester.isSelected()){
					ProjectBoss jefeProyecto = Admin.getInstance().bossByName(nombreJefe);
					Programmer programador1 = Admin.getInstance().programmerByName(nombreProgramador1);
					Programmer  programador2 = Admin.getInstance().programmerByName(nombreProgramador2);
					SoftwareTester tester = Admin.getInstance().testerByName(nombreTester);
					Designer designer = Admin.getInstance().designerByName(nombreDiseador);
					jefeProyecto.setAvailable(jefeProyecto.getAvailable() + 1);
					programador1.setAvailable(programador1.getAvailable() + 1);
					programador2.setAvailable(programador2.getAvailable() + 1);
					designer.setAvailable(designer.getAvailable() + 1);
					tester.setAvailable(tester.getAvailable() + 1);
					Project newProject = Admin.getInstance().createProject(titulo, tipo, lenguaje, "En progreso", jefeProyecto, null, designer, tester, programador1, programador2);
					Admin.getInstance().addProject(newProject);
					//JOptionPane.showMessageDialog(null, "¡El proyecto ha sido agregado!", "Proyecto agregado", JOptionPane.INFORMATION_MESSAGE, contractIcon);
					//clean();
					dispose();
					CreateContract contract = new CreateContract(newProject, false, null, -1);
					contract.setVisible(true);
				}
				else if(chkPlaneador.isSelected() && !chkDiseador.isSelected() && chkTester.isSelected()){
					ProjectBoss jefeProyecto = Admin.getInstance().bossByName(nombreJefe);
					Programmer programador1 = Admin.getInstance().programmerByName(nombreProgramador1);
					Programmer  programador2 = Admin.getInstance().programmerByName(nombreProgramador2);
					Planner planner = Admin.getInstance().plannerByName(nombrePlaneador);
					SoftwareTester tester = Admin.getInstance().testerByName(nombreTester);
					jefeProyecto.setAvailable(jefeProyecto.getAvailable() + 1);
					programador1.setAvailable(programador1.getAvailable() + 1);
					programador2.setAvailable(programador2.getAvailable() + 1);
					tester.setAvailable(tester.getAvailable() + 1);
					planner.setAvailable(planner.getAvailable() + 1);
					Project newProject = Admin.getInstance().createProject(titulo, tipo, lenguaje, "En progreso", jefeProyecto, planner, null, tester, programador1, programador2);
					Admin.getInstance().addProject(newProject);
					//JOptionPane.showMessageDialog(null, "¡El proyecto ha sido agregado!", "Proyecto agregado", JOptionPane.INFORMATION_MESSAGE, contractIcon);
					//clean();
					dispose();
					CreateContract contract = new CreateContract(newProject, false, null, -1);
					contract.setVisible(true);
				}
				else if(chkPlaneador.isSelected() && chkDiseador.isSelected() && chkTester.isSelected()){
					ProjectBoss jefeProyecto = Admin.getInstance().bossByName(nombreJefe);
					Programmer programador1 = Admin.getInstance().programmerByName(nombreProgramador1);
					Programmer  programador2 = Admin.getInstance().programmerByName(nombreProgramador2);
					Planner planner = Admin.getInstance().plannerByName(nombrePlaneador);
					SoftwareTester tester = Admin.getInstance().testerByName(nombreTester);
					Designer designer = Admin.getInstance().designerByName(nombreDiseador);
					jefeProyecto.setAvailable(jefeProyecto.getAvailable() + 1);
					programador1.setAvailable(programador1.getAvailable() + 1);
					programador2.setAvailable(programador2.getAvailable() + 1);
					tester.setAvailable(tester.getAvailable() + 1);
					designer.setAvailable(designer.getAvailable() + 1);
					Project newProject = Admin.getInstance().createProject(titulo, tipo, lenguaje, "En progreso", jefeProyecto, planner, designer, tester, programador1, programador2);
					Admin.getInstance().addProject(newProject);
					//JOptionPane.showMessageDialog(null, "¡El proyecto ha sido agregado!", "Proyecto agregado", JOptionPane.INFORMATION_MESSAGE, contractIcon);
					//clean();
					dispose();
					CreateContract contract = new CreateContract(newProject, false, null, -1);
					contract.setVisible(true);
				}
				else{
					ProjectBoss jefeProyecto = Admin.getInstance().bossByName(nombreJefe);
					Programmer programador1 = Admin.getInstance().programmerByName(nombreProgramador1);
					Programmer  programador2 = Admin.getInstance().programmerByName(nombreProgramador2);
					jefeProyecto.setAvailable(jefeProyecto.getAvailable() + 1);
					programador1.setAvailable(programador1.getAvailable() + 1);
					programador2.setAvailable(programador2.getAvailable() + 1);
					Project newProject = Admin.getInstance().createProject(titulo, tipo, lenguaje, "En progreso", jefeProyecto, null, null, null, programador1, programador2);
					Admin.getInstance().addProject(newProject);
					//JOptionPane.showMessageDialog(null, "¡El proyecto ha sido agregado!", "Proyecto agregado", JOptionPane.INFORMATION_MESSAGE, contractIcon);
					//clean();
					dispose();
					CreateContract contract = new CreateContract(newProject, false, null, -1);
					contract.setVisible(true);
				}  
			}
		});
		btnSiguiente.setActionCommand("OK");
		buttonPane.add(btnSiguiente);
		getRootPane().setDefaultButton(btnSiguiente);
	    }
	    
	    	topPanel = new JPanel();
	    	topPanel.setBounds(0, 0, 702, 29);
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
		
		lblNewLabel = new JLabel("Registrar Proyecto");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 1, 185, 27);
		topPanel.add(lblNewLabel);
		
		
		lblClose = new JLabel("");
		lblClose.setBounds(672, 3, 26, 26);
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
		panel.setBounds(17, 60, 667, 240);
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Detalles del proyecto", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
	
		tfdTitulo = new JTextField();
		tfdTitulo.setBounds(87, 38, 236, 22);
		panel.add(tfdTitulo);
		tfdTitulo.setBackground(new Color(230, 230, 250));
		tfdTitulo.setHorizontalAlignment(SwingConstants.CENTER);

		tfdTitulo.setColumns(10);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo*:");
		lblTitulo.setBounds(10, 40, 75, 16);
		panel.add(lblTitulo);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblTipo = new JLabel("Tipo*:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(10, 87, 75, 16);
		panel.add(lblTipo);
		
		JLabel lblLenguaje = new JLabel("Lenguaje*:");
		lblLenguaje.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLenguaje.setBounds(10, 131, 75, 16);
		panel.add(lblLenguaje);
				
		cbxTipo = new JComboBox<String>();
		cbxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxTipo.getSelectedItem().toString().equalsIgnoreCase("Escritorio")){
					cbxLenguaje.removeAllItems();
					cbxLenguaje.addItem("<Seleccione un lenguaje>");
					cbxLenguaje.addItem("Java");
					cbxLenguaje.addItem("C#");
					cbxLenguaje.addItem("Visual Basic");
				}
				else if(cbxTipo.getSelectedItem().toString().equalsIgnoreCase("M\u00F3vil")){
					cbxLenguaje.removeAllItems();
					cbxLenguaje.addItem("<Seleccione un lenguaje>");
					cbxLenguaje.addItem("C++");
					cbxLenguaje.addItem("Objective C");
					cbxLenguaje.addItem("Java");	
					cbxLenguaje.addItem("Swift");
				}
				else if(cbxTipo.getSelectedItem().toString().equalsIgnoreCase("Web")){
					cbxLenguaje.removeAllItems();
					cbxLenguaje.addItem("<Seleccione un lenguaje>");
					cbxLenguaje.addItem("HTML & CSS");
					cbxLenguaje.addItem("PHP");
					cbxLenguaje.addItem("JavaScript");	
					cbxLenguaje.addItem("Swift");
				}
				else{
					cbxLenguaje.removeAllItems();
					cbxLenguaje.addItem("<Seleccione un tipo>");
				}
			}
		});
		cbxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Escritorio", "M\u00F3vil", "Web"}));
		cbxTipo.setBackground(new Color(230, 230, 250));
		cbxTipo.setBounds(87, 85, 236, 22);
		((JLabel)cbxTipo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);	
		panel.add(cbxTipo);
		cbxLenguaje = new JComboBox<String>();
		cbxLenguaje.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione un tipo>"}));
		cbxLenguaje.setBackground(new Color(230, 230, 250));
		cbxLenguaje.setBounds(87, 129, 236, 22);
		((JLabel)cbxLenguaje.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(cbxLenguaje);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Seleccione los trabajdores", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(335, 32, 322, 197);
		panel_1.setBackground(new Color(220, 220, 220));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		chkJefeDeProyecto = new JCheckBox("Jefe de proyecto:");
		chkJefeDeProyecto.setEnabled(false);
		chkJefeDeProyecto.setSelected(true);
		chkJefeDeProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkJefeDeProyecto.setBounds(6, 33, 132, 23);
		chkJefeDeProyecto.setBackground(new Color(220, 220, 220));
		panel_1.add(chkJefeDeProyecto);
		
		chkProgramador1 = new JCheckBox("Programador:");
		chkProgramador1.setSelected(true);
		chkProgramador1.setEnabled(false);
		chkProgramador1.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkProgramador1.setBounds(6, 59, 132, 23);
		chkProgramador1.setBackground(new Color(220, 220, 220));
		panel_1.add(chkProgramador1);
		
		chkProgramador2 = new JCheckBox("Programador:");
		chkProgramador2.setEnabled(false);
		chkProgramador2.setSelected(true);
		chkProgramador2.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkProgramador2.setBounds(6, 85, 132, 23);
		chkProgramador2.setBackground(new Color(220, 220, 220));
		panel_1.add(chkProgramador2);
		
		chkPlaneador = new JCheckBox("Planeador:");
		chkPlaneador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkPlaneador.isSelected()){
					cbxPlaneador.setEnabled(true);
				}
				else{
					cbxPlaneador.setEnabled(false);
					cbxPlaneador.setSelectedIndex(0);
				}
			}
		});
		chkPlaneador.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkPlaneador.setBackground(new Color(220, 220, 220));
		chkPlaneador.setBounds(6, 111, 132, 23);
		panel_1.add(chkPlaneador);
		
		chkDiseador = new JCheckBox("Dise\u00F1ador:");
		chkDiseador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkDiseador.isSelected()){
					cbxDiseador.setEnabled(true);
				}
				else{
					cbxDiseador.setEnabled(false);
					cbxDiseador.setSelectedIndex(0);
				}
			}
		});
		chkDiseador.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkDiseador.setBounds(6, 137, 132, 23);
		chkDiseador.setBackground(new Color(220, 220, 220));
		panel_1.add(chkDiseador);
		
		chkTester = new JCheckBox("Tester:");
		chkTester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkTester.isSelected()){
					cbxTester.setEnabled(true);
				}
				else{
					cbxTester.setEnabled(false);
					cbxTester.setSelectedIndex(0);
				}
			}
		});
		chkTester.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkTester.setBounds(6, 163, 132, 23);
		chkTester.setBackground(new Color(220, 220, 220));
		panel_1.add(chkTester);
		
		cbxJefeDeProyecto = new JComboBox<String>();
		cbxJefeDeProyecto.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
		cbxJefeDeProyecto.setBackground(new Color(230, 230, 250));
		cbxJefeDeProyecto.setBounds(144, 33, 168, 23);
		((JLabel)cbxJefeDeProyecto.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(cbxJefeDeProyecto);
		
		cbxProgramador1 = new JComboBox<String>();
		cbxProgramador1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ( cbxProgramador1.getSelectedIndex()>0) {
					String aux = cbxProgramador1.getSelectedItem().toString();
					cbxProgramador2.removeItem(aux);
					for (int i =0;i<Admin.getInstance().getWorkers().size();i++) {
						String aux1 = Admin.getInstance().getWorkers().get(i).getFirstName()+" "+Admin.getInstance().getWorkers().get(i).getLastName();
						if (Admin.getInstance().getWorkers().get(i) instanceof Programmer && !aux1.equals(aux) && !contains(aux1, cbxProgramador2))
							cbxProgramador2.addItem(aux1);
					}
			  }
				else {
					for (int i =0;i<Admin.getInstance().getWorkers().size();i++) {
						String aux1 = Admin.getInstance().getWorkers().get(i).getFirstName()+" "+Admin.getInstance().getWorkers().get(i).getLastName();
						if ( Admin.getInstance().getWorkers().get(i) instanceof Programmer && !contains(aux1, cbxProgramador2)) {
						cbxProgramador2.addItem(aux1);
						}
						if ( Admin.getInstance().getWorkers().get(i) instanceof Programmer && !contains(aux1, cbxProgramador1)) {
						cbxProgramador1.addItem(aux1);
						}
					}
				}
			}
		});
		cbxProgramador1.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
		cbxProgramador1.setBackground(new Color(230, 230, 250));
		cbxProgramador1.setBounds(144, 59, 168, 23);
		((JLabel)cbxProgramador1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(cbxProgramador1);
		
		cbxProgramador2 = new JComboBox<String>();
		cbxProgramador2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ( cbxProgramador2.getSelectedIndex()>0) {
					String aux = cbxProgramador2.getSelectedItem().toString();
					cbxProgramador1.removeItem(aux);
					for (int i =0;i<Admin.getInstance().getWorkers().size();i++) {
						String aux1 = Admin.getInstance().getWorkers().get(i).getFirstName()+" "+Admin.getInstance().getWorkers().get(i).getLastName();
						if (Admin.getInstance().getWorkers().get(i) instanceof Programmer && !aux1.equals(aux) && !contains(aux1, cbxProgramador1))
							cbxProgramador1.addItem(aux1);
					}
			  }
				else {
					for (int i =0;i<Admin.getInstance().getWorkers().size();i++) {
						String aux1 = Admin.getInstance().getWorkers().get(i).getFirstName()+" "+Admin.getInstance().getWorkers().get(i).getLastName();
						if ( Admin.getInstance().getWorkers().get(i) instanceof Programmer && !contains(aux1, cbxProgramador1)) {
						cbxProgramador1.addItem(aux1);
						}
						if ( Admin.getInstance().getWorkers().get(i) instanceof Programmer && !contains(aux1, cbxProgramador2)) {
						cbxProgramador2.addItem(aux1);
						}
					}
				}
			}
		});
		cbxProgramador2.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
		cbxProgramador2.setBackground(new Color(230, 230, 250));
		cbxProgramador2.setBounds(144, 85, 168, 23);
		((JLabel)cbxProgramador2.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(cbxProgramador2);
		
		cbxPlaneador = new JComboBox<String>();
		cbxPlaneador.setEnabled(false);
		cbxPlaneador.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
		cbxPlaneador.setBackground(new Color(230, 230, 250));
		cbxPlaneador.setBounds(144, 111, 168, 23);
		((JLabel)cbxPlaneador.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(cbxPlaneador);
		
		cbxDiseador = new JComboBox<String>();
		cbxDiseador.setEnabled(false);
		cbxDiseador.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
		cbxDiseador.setBackground(new Color(230, 230, 250));
		cbxDiseador.setBounds(144, 137, 168, 23);
		((JLabel)cbxDiseador.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(cbxDiseador);
		
		cbxTester = new JComboBox<String>();
		cbxTester.setEnabled(false);
		cbxTester.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
		cbxTester.setBackground(new Color(230, 230, 250));
		cbxTester.setBounds(144, 163, 168, 23);
		((JLabel)cbxTester.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(cbxTester);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CreateProject.class.getResource("/icons/lcontract.png")));
		lblNewLabel_1.setBounds(277, 171, 46, 41);
		panel.add(lblNewLabel_1);
		
		fillCbxs();
		
		JLabel lblParmetros = new JLabel("* -> Par\u00E1metros obligatorios");
		lblParmetros.setBounds(17, 42, 197, 16);
		lblParmetros.setFont(new Font("Tahoma", Font.ITALIC, 13));
		contentPane.add(lblParmetros);
	    
	    
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

	public JCheckBox getChkJefeDeProyecto() {
		return chkJefeDeProyecto;
	}

	public void setChkJefeDeProyecto(JCheckBox chkJefeDeProyecto) {
		this.chkJefeDeProyecto = chkJefeDeProyecto;
	}

	public JCheckBox getChkProgramador1() {
		return chkProgramador1;
	}

	public void setChkProgramador1(JCheckBox chkProgramador1) {
		this.chkProgramador1 = chkProgramador1;
	}

	public JCheckBox getChkProgramador2() {
		return chkProgramador2;
	}

	public void setChkProgramador2(JCheckBox chkProgramador2) {
		this.chkProgramador2 = chkProgramador2;
	}

	public JCheckBox getChkPlaneador() {
		return chkPlaneador;
	}

	public void setChkPlaneador(JCheckBox chkPlaneador) {
		this.chkPlaneador = chkPlaneador;
	}

	public JCheckBox getChkDiseador() {
		return chkDiseador;
	}

	public void setChkDiseador(JCheckBox chkDiseador) {
		this.chkDiseador = chkDiseador;
	}

	public JCheckBox getChkTester() {
		return chkTester;
	}

	public void setChkTester(JCheckBox chkTester) {
		this.chkTester = chkTester;
	}

	public JComboBox<String> getCbxJefeDeProyecto() {
		return cbxJefeDeProyecto;
	}

	public void setCbxJefeDeProyecto(JComboBox<String> cbxJefeDeProyecto) {
		this.cbxJefeDeProyecto = cbxJefeDeProyecto;
	}

	public JComboBox<String> getCbxProgramador1() {
		return cbxProgramador1;
	}

	public void setCbxProgramador1(JComboBox<String> cbxProgramador1) {
		this.cbxProgramador1 = cbxProgramador1;
	}

	public JComboBox<String> getCbxProgramador2() {
		return cbxProgramador2;
	}

	public void setCbxProgramador2(JComboBox<String> cbxProgramador2) {
		this.cbxProgramador2 = cbxProgramador2;
	}

	public JComboBox<String> getCbxPlaneador() {
		return cbxPlaneador;
	}

	public void setCbxPlaneador(JComboBox<String> cbxPlaneador) {
		this.cbxPlaneador = cbxPlaneador;
	}

	public JComboBox<String> getCbxDiseador() {
		return cbxDiseador;
	}

	public void setCbxDiseador(JComboBox<String> cbxDiseador) {
		this.cbxDiseador = cbxDiseador;
	}

	public JComboBox<String> getCbxTester() {
		return cbxTester;
	}

	public void setCbxTester(JComboBox<String> cbxTester) {
		this.cbxTester = cbxTester;
	}
	
	public void fillCbxs(){
		for (Worker worker : Admin.getInstance().getWorkers()) {
			if(worker instanceof ProjectBoss && (worker.getContract().size() < 2))
				getCbxJefeDeProyecto().addItem(worker.getFirstName() + " " + worker.getLastName());
				
			else if(worker instanceof Programmer && (worker.getContract().size() < 1)){
				getCbxProgramador1().addItem(worker.getFirstName() + " " + worker.getLastName());
				getCbxProgramador2().addItem(worker.getFirstName() + " " + worker.getLastName());
			}
			else if(worker instanceof Planner && (worker.getContract().size() < 3))
				getCbxPlaneador().addItem(worker.getFirstName() + " " + worker.getLastName());
			else if(worker instanceof Designer && (worker.getContract().size() < 2))
				getCbxDiseador().addItem(worker.getFirstName() + " " + worker.getLastName());
			else if(worker instanceof SoftwareTester && (worker.getContract().size() < 3))
				getCbxTester().addItem(worker.getFirstName() + " " + worker.getLastName());
	    }
		
	}
	
	   private void clean() {
		   tfdTitulo.setText("");
		   cbxTipo.setSelectedIndex(-1);
		   cbxLenguaje.setSelectedIndex(-1);
		   cbxJefeDeProyecto.setSelectedIndex(0);
		   cbxProgramador1.setSelectedIndex(0);
		   cbxProgramador2.setSelectedIndex(0);
		   cbxPlaneador.setSelectedIndex(0);
		   cbxDiseador.setSelectedIndex(0);
		   cbxTester.setSelectedIndex(0);
		   chkPlaneador.setSelected(false);
		   chkDiseador.setSelected(false);
		   chkTester.setSelected(false);
	   }
	   private boolean contains(String item, JComboBox<String> cbx) {
		   boolean aux = false;
		   for (int i =0;i<cbx.getItemCount();i++) {
			   if (cbx.getItemAt(i).equals(item))
				   aux = true;
		   }
		   return aux;
	   }
	
}

