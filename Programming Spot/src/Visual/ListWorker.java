package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Logico.Admin;
import Logico.Contract;
import Logico.Designer;
import Logico.Planner;
import Logico.Programmer;
import Logico.ProjectBoss;
import Logico.SoftwareTester;
import Logico.Worker;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ListWorker extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5748751159444413874L;
	private final JPanel contentPanel = new JPanel();
	private ImageIcon workerIcon = new ImageIcon("src/icons/worker.png");
	private ImageIcon contractIcon =new ImageIcon("src/icons/contract.png");
	private ImageIcon clientIcon = new ImageIcon("src/icons/client.png");
	
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
    private JTextField busquedaCedula;
    
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ListWorker() {
		setUndecorated(true);
		setBounds(100, 100, 1050, 597);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		super.getToolkit().getScreenSize(); 
		this.setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		
		JPanel panel = new JPanel();
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
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lista de trabajadores", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 139, 691, 395);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();   
		scrollPane.setBounds(14, 28, 667, 356);
		panel_1.add(scrollPane);
		///////////////////////////////////////Lo que se debe copiar para hacer las tablas/////////////////////////////////////////////////
		String[] columnsHeaders = {"C�dula", "Nombre", "Apellido", "Salario","Projectos", "Disponibilidad", "Tel�fono", "Tipo"};
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
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Projectos Activos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		String[] columnsHeaders1 = {"Nombre", "Orientaci�n", "Lenguaje"};
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
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Filtro por tipo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
				filter(1);
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
				filter(2);
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
				filter(3);
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
				filter(4);
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
				filter(5);
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
				filter(6);
			}
		});
		todos.setSelected(true);
		todos.setFont(new Font("Tahoma", Font.BOLD, 11));
		todos.setBackground(new Color(220,220,220));
		todos.setBounds(365, 47, 74, 23);
		panel_4.add(todos);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(220,220,220));;
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "B\u00FAsqueda", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_5.setBounds(465, 40, 238, 88);
		contentPanel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCedula.setBounds(10, 38, 46, 14);
		panel_5.add(lblCedula);
		
		busquedaCedula = new JTextField();
		busquedaCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				find();
			}
		});
		busquedaCedula.setBounds(66, 35, 162, 22);
		panel_5.add(busquedaCedula);
		busquedaCedula.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("*Introducir c\u00E9dula sin guiones");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_2.setBounds(10, 63, 150, 14);
		panel_5.add(lblNewLabel_2);
		
		
		loadWorkers(Admin.getInstance().getWorkers());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(220,220,220));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Eliminar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
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
	   	table.getColumnModel().getColumn(6).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(7).setCellRenderer(tcr);
	   	row = new Object[tableModel.getColumnCount()];
	   	for (Worker ct : workers) {
	   	    row[0]=ct.getIdNumber();
	   	    row[1]=ct.getFirstName();
	   	    row[2]=ct.getLastName();
	   	    row[3]=ct.computeSalary();
	   	    row[4]=String.valueOf(ct.getContract().size());
	   	    row[5]=ct.isAvailable();
	   	    row[6]=ct.getTelefono();
	   	    if (ct instanceof ProjectBoss)
	      	    row[7]="Jefe de Projecto";
	   	    else if (ct instanceof Planner)
	   	    	row[7]="Planeador";
	   	  else if (ct instanceof SoftwareTester)
	   	    	row[7]="Tester";
	   	  else if (ct instanceof Designer)
	   	    	row[7]="Dise�ador";
	   	  else 
	   	    	row[7]="Programador";
	   	    tableModel.addRow(row);
	   	}
	    }
	private void find() {
		String textField = busquedaCedula.getText();
		ArrayList<Worker> selected = new ArrayList<>();
		if (textField.length()==0) {
			selected = Admin.getInstance().getWorkers();
		}
		else if (textField.length()==1) {
			for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(1, i);
				if (textField.equals(aux))
					selected.add(i);
			}
		}
        else if (textField.length()==2) {
        	for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(2, i);
				if (textField.equals(aux))
					selected.add(i);
			}
		}
        else if (textField.length()==3) {
        	for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(3, i);
				if (textField.equals(aux))
					selected.add(i);
			}
        }
        else if (textField.length()==4) {
        	for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(4, i);
				if (textField.equals(aux))
					selected.add(i);
			}
        }
        else if (textField.length()==5) {
        	for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(5, i);
				if (textField.equals(aux))
					selected.add(i);
			}
        }
        else if (textField.length()==6) {
        	for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(6, i);
				if (textField.equals(aux))
					selected.add(i);
			}
        }
        else if (textField.length()==7) {
        	for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(7, i);
				if (textField.equals(aux))
					selected.add(i);
			}
        }
        else if (textField.length()==8) {
        	for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(8, i);
				if (textField.equals(aux))
					selected.add(i);
			}
        }
        else if (textField.length()==9) {
        	for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(9, i);
				if (textField.equals(aux))
					selected.add(i);
			}
        }
        else if (textField.length()==10) {
        	for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(10, i);
				if (textField.equals(aux))
					selected.add(i);
			}
        }
        else if (textField.length()==11) {
        	for (Worker i: Admin.getInstance().getWorkers()) {
				String aux = getIDWorker(11, i);
				if (textField.equals(aux))
					selected.add(i);
			}
        }
		loadWorkers(selected);
	}
	private String separator(String cedula) {
		String[] separado = cedula.split("-");
		cedula = separado[0]+separado[1]+separado[2];
		return cedula;
	}
	private String getIDWorker(int number, Worker worker) {
		String aux = null;
		String aux1 = separator(worker.getIdNumber());
		aux = aux1.substring(0, number);
		return aux;
	}
	private void filter(int number) {
		ArrayList<Worker> workers = new ArrayList<>();
		for (Worker i: Admin.getInstance().getWorkers()) {
			if (number==1) {
				if (i instanceof ProjectBoss)
					workers.add(i);
			}
			else if (number==2) {
				if (i instanceof Planner)
					workers.add(i);
			}
			else if (number==3) {
				if (i instanceof SoftwareTester)
					workers.add(i);
			}
			else if (number==4) {
				if (i instanceof Designer)
					workers.add(i);
			}
			else if (number==5) {
				if (i instanceof Programmer)
					workers.add(i);
			}
			else if (number==6) {
					workers.add(i);
			}
				
		}
		loadWorkers(workers);
	}
    private void loadProjects(ArrayList<Contract> contracts) {
       	tableModel.setRowCount(0);
	   	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	   	tcr.setHorizontalAlignment(SwingConstants.CENTER);
	   	table.getColumnModel().getColumn(0).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(1).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(2).setCellRenderer(tcr);
	   	row1 = new Object[tableModel.getColumnCount()];
	   	for (Contract pr : contracts) {
	   	    row1[0]=pr.getProject().getName();
	   	    row1[1]=pr.getProject().getProgrammingType();
	   	    row1[2]=pr.getProject().getProgrammingLanguage();
	   	}
    }
}
