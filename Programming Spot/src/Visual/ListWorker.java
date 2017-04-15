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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Logico.Admin;
import Logico.Contract;
import Logico.Designer;
import Logico.Planner;
import Logico.Programmer;
import Logico.ProjectBoss;
import Logico.SoftwareTester;
import Logico.Worker;

public class ListWorker extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5748751159444413874L;
	private final JPanel contentPanel = new JPanel();
	private ImageIcon workerIcon = new ImageIcon(ListWorker.class.getResource("/icons/worker.png"));
	private ImageIcon contractIcon =new ImageIcon(ListWorker.class.getResource("/icons/contract.png"));
	private ImageIcon clientIcon = new ImageIcon(ListWorker.class.getResource("/icons/client.png"));
	
	private JTable table;
	private static DefaultTableModel tableModel;
    private static Object[] row;
    
    private JTable projectsTable;
    private static DefaultTableModel tableModel1;
    private static Object[] row1;
    
    private JRadioButton jefeProyecto;
    private JRadioButton planeador;
    private JRadioButton tester;
    private JRadioButton diseniador;
    private JRadioButton programador;
    private JRadioButton todos;
    private JFormattedTextField busquedaCedula;
    private ArrayList<Worker> deleted = new ArrayList<>();
    private JButton modificar;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public ListWorker() throws ParseException  {
		setUndecorated(true);
		setBounds(100, 100, 1050, 597);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(112, 128, 144), 2));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		super.getToolkit().getScreenSize(); 
		this.setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(112, 128, 144), 2));
		panel.setBounds(0, 0, 1050, 29);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Trabajadores");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 1, 180, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_1.setIcon(new ImageIcon(ListWorker.class.getResource("/icons/close.png")));
		lblNewLabel_1.setBounds(1025, 3, 26, 26);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220,220,220));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Lista de trabajadores", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 139, 691, 395);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();   
		scrollPane.setBounds(14, 28, 667, 356);
		panel_1.add(scrollPane);
		///////////////////////////////////////Lo que se debe copiar para hacer las tablas/////////////////////////////////////////////////
		String[] columnsHeaders = {"Cédula", "Nombre", "Apellido",  "Cantidad de contratos", "Teléfono", "Tipo de trabajador"};
		tableModel = new DefaultTableModel(){
		    /**
		     * 
		     */
		    private static final long serialVersionUID = 1L;

		    @Override
		    public boolean isCellEditable(int row, int column) {
			
			return false;
		    }
		 
		};
		tableModel.setColumnIdentifiers(columnsHeaders);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			    if(table.getSelectedRow()>=0){
				      int index = table.getSelectedRow();
				      loadProjects(Admin.getInstance().getWorkers().get(index).getContract());
			    }
			}
		});
		scrollPane.setColumnHeaderView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		////////////////////////////////////////////////Lo que se debe copiar para hacer las tablas/////////////////////////////////////////
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220,220,220));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Projectos Activos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(715, 36, 323, 498);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(211,211,211));
		panel_3.setBounds(12, 24, 299, 463);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 13, 275, 439);
		panel_3.add(scrollPane_1);
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String[] columnsHeaders1 = {"Nombre", "Orientación", "Lenguaje"};
		tableModel1 = new DefaultTableModel(){
		    /**
		     * 
		     */
		    private static final long serialVersionUID = 1L;

		    @Override
		    public boolean isCellEditable(int row, int column) {
			
			return false;
		    }
		 
		};
		tableModel1.setColumnIdentifiers(columnsHeaders1);
		projectsTable = new JTable();
		scrollPane_1.setViewportView(projectsTable);
		scrollPane_1.setColumnHeaderView(projectsTable);
		projectsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		projectsTable.setModel(tableModel1);
		scrollPane_1.setViewportView(projectsTable);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(220,220,220));
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Filtro por tipo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(10, 40, 445, 88);
		contentPanel.add(panel_4);
		panel_4.setLayout(null);
		
		jefeProyecto = new JRadioButton("Jefe de Proyecto");
		jefeProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(true);
				planeador.setSelected(false);
				diseniador.setSelected(false);
				tester.setSelected(false);
				programador.setSelected(false);
				todos.setSelected(false);
				filter();
			}
		});
		jefeProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
		jefeProyecto.setBackground(new Color(220,220,220));
		jefeProyecto.setBounds(6, 21, 141, 23);
		panel_4.add(jefeProyecto);
		
		planeador = new JRadioButton("Planeador");
		planeador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(false);
				planeador.setSelected(true);
				diseniador.setSelected(false);
				tester.setSelected(false);
				programador.setSelected(false);
				todos.setSelected(false);
				filter();
			}
		});
		planeador.setFont(new Font("Tahoma", Font.BOLD, 11));
		planeador.setBackground(new Color(220,220,220));
		planeador.setBounds(192, 21, 109, 23);
		panel_4.add(planeador);
		
		tester = new JRadioButton("Tester");
		tester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(false);
				planeador.setSelected(false);
				diseniador.setSelected(false);
				tester.setSelected(true);
				programador.setSelected(false);
				todos.setSelected(false);
				filter();
			}
		});
		tester.setFont(new Font("Tahoma", Font.BOLD, 11));
		tester.setBackground(new Color(220,220,220));
		tester.setBounds(365, 21, 74, 23);
		panel_4.add(tester);
		
		diseniador = new JRadioButton("Dise\u00F1ador");
		diseniador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(false);
				planeador.setSelected(false);
				diseniador.setSelected(true);
				tester.setSelected(false);
				programador.setSelected(false);
				todos.setSelected(false);
				filter();
			}
		});
		diseniador.setFont(new Font("Tahoma", Font.BOLD, 11));
		diseniador.setBackground(new Color(220,220,220));
		diseniador.setBounds(6, 47, 109, 23);
		panel_4.add(diseniador);
		
		programador = new JRadioButton("Programador");
		programador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(false);
				planeador.setSelected(false);
				diseniador.setSelected(false);
				tester.setSelected(false);
				programador.setSelected(true);
				todos.setSelected(false);
				filter();
			}
		});
		programador.setFont(new Font("Tahoma", Font.BOLD, 11));
		programador.setBackground(new Color(220,220,220));
		programador.setBounds(192, 47, 132, 23);
		panel_4.add(programador);
		
		todos = new JRadioButton("Todos");
		todos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jefeProyecto.setSelected(false);
				planeador.setSelected(false);
				diseniador.setSelected(false);
				tester.setSelected(false);
				programador.setSelected(false);
				todos.setSelected(true);
				filter();
			}
		});
		todos.setSelected(true);
		todos.setFont(new Font("Tahoma", Font.BOLD, 11));
		todos.setBackground(new Color(220,220,220));
		todos.setBounds(365, 47, 74, 23);
		panel_4.add(todos);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(220,220,220));;
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "B\u00FAsqueda", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(465, 40, 238, 88);
		contentPanel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCedula.setBounds(10, 38, 46, 14);
		panel_5.add(lblCedula);
		
		MaskFormatter mask = new MaskFormatter("###-#######-#");
		
		busquedaCedula = new JFormattedTextField(mask);
		busquedaCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				findWorker();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				//if ((busquedaCedula.getText().length()==3 || busquedaCedula.getText().length()==11)&& e.getKeyCode()!=8) {
				//	busquedaCedula.setText(busquedaCedula.getText()+"-");
				//}
			}
		});
		busquedaCedula.setBounds(66, 35, 162, 22);
		panel_5.add(busquedaCedula);
		busquedaCedula.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("*Introducir c\u00E9dula con guiones");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2.setBounds(10, 63, 150, 14);
		panel_5.add(lblNewLabel_2);
		
		
		filter();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(112, 128, 144), 2));
			buttonPane.setBackground(new Color(220,220,220));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Eliminar");
				okButton.setBackground(new Color(255, 255, 240));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (table.getSelectedRow()>=0) {
							int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este Trabajador?", null, JOptionPane.WARNING_MESSAGE);
							if(JOptionPane.OK_OPTION==resp) {
						     Worker worker = Admin.getInstance().getWorkers().get(table.getSelectedRow());
						     deleted.add(worker);
						     filter();
								JOptionPane.showMessageDialog(null, "Se ha eliminado este trabajador", null, JOptionPane.INFORMATION_MESSAGE, null);
							}
						}
					}
				});
				
				modificar = new JButton("Modificar");
				modificar.setBackground(new Color(255, 255, 240));
				modificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (table.getSelectedRow()>=0) {
						int index = table.getSelectedRow();
						Worker work = notDeleted().get(index);
						RegisterWorker modify;
						try {
							modify = new RegisterWorker(true, work);
							modify.setVisible(true);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						}
					}
				});
				buttonPane.add(modificar);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setBackground(new Color(255, 255, 240));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainVisual.getInstance().getMenuPanel().setVisible(false);
						MainVisual.getInstance().getWorkersPanel().setVisible(true);
						MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
						MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
						MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void loadWorkers(ArrayList<Worker> workers) {
	   	tableModel.setRowCount(0);
	   	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	   	tcr.setHorizontalAlignment(SwingConstants.CENTER);
	   	table.getColumnModel().getColumn(0).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(1).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(2).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(3).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(4).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(5).setCellRenderer(tcr);
	   	row = new Object[tableModel.getColumnCount()];
	   	for (Worker ct : workers) {
	   	    row[0]=ct.getIdNumber();
	   	    row[1]=ct.getFirstName();
	   	    row[2]=ct.getLastName();
	   	    row[3]=ct.getAvailable();
	   	    row[4]=ct.getTelefono();
	   	    String aux = null;
	   	    if (ct instanceof ProjectBoss)
	   	    	aux = "Jefe de proyecto";
	   	    else if (ct instanceof Planner)
	   	    	aux = "Planeador";
	   	    else if (ct instanceof SoftwareTester)
	   	    	aux = "Tester";
	   	    else if (ct instanceof Designer)
	   	    	aux = "Diseñador";
	   	    else
	   	    	aux = "Programador";
	   	    row[5]=aux;
	   	    tableModel.addRow(row);
	   	}
	    }
	private void findWorker() {
		String textField = busquedaCedula.getText().substring(0, busquedaCedula.getCaretPosition());
		ArrayList<Worker> workers = notDeleted();
		ArrayList<Worker> selected = new ArrayList<>();
		//if (textField.length()<14) {
		for (Worker i: workers) {
			String aux = getIDWorker(busquedaCedula.getCaretPosition(), i);
			if (textField.equals(aux))
				selected.add(i);
		   } 
		//}
		loadWorkers(selected);
	}
	private ArrayList<Worker> notDeleted(){
		ArrayList<Worker> workersNotDeleted = new ArrayList<>();
		for (Worker i: Admin.getInstance().getWorkers()) {
			if (!deleted.contains(i))
				workersNotDeleted.add(i);
		}
		return workersNotDeleted;
	}

	private String getIDWorker(int number, Worker worker) {
		String aux = null;
		String aux1 = worker.getIdNumber();
		aux = aux1.substring(0, number);
		return aux;
	}
	private void filter() {
		ArrayList<Worker> workers = new ArrayList<>();
		for (Worker i: Admin.getInstance().getWorkers()) {
			if(!deleted.contains(i)) {
			if (jefeProyecto.isSelected()) {
				if (i instanceof ProjectBoss)
					workers.add(i);
			}
			else if (planeador.isSelected()) {
				if (i instanceof Planner)
					workers.add(i);
			}
			else if (tester.isSelected()) {
				if (i instanceof SoftwareTester)
					workers.add(i);
			}
			else if (diseniador.isSelected()) {
				if (i instanceof Designer)
					workers.add(i);
			}
			else if (programador.isSelected()) {
				if (i instanceof Programmer)
					workers.add(i);
			}
			else  {
					workers.add(i);
			}
			}		
		}
		loadWorkers(workers);
	}
    private void loadProjects(ArrayList<Contract> contracts) {
       	tableModel1.setRowCount(0);
	   	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	   	tcr.setHorizontalAlignment(SwingConstants.CENTER);
	   	projectsTable.getColumnModel().getColumn(0).setCellRenderer(tcr);
	   	projectsTable.getColumnModel().getColumn(1).setCellRenderer(tcr);
	   	projectsTable.getColumnModel().getColumn(2).setCellRenderer(tcr);
	   	row1 = new Object[tableModel1.getColumnCount()];
	   	for (Contract pr : contracts) {
	   	    row1[0]=pr.getProject().getName();
	   	    row1[1]=pr.getProject().getProgrammingType();
	   	    row1[2]=pr.getProject().getProgrammingLanguage();
	   	    tableModel1.addRow(row1);
	   	}
    }
    
}
