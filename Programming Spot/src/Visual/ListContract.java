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
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import Logico.Client;
import Logico.Contract;
import Logico.Worker;

public class ListContract extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8170564605223578877L;
	private final JPanel contentPane = new JPanel();
	private JTable table;
	private static DefaultTableModel tableModel;
	private static Object[] row;
	
        private JTable table_1;
        private static DefaultTableModel tableModel1;
        private static Object[] row1;
        private JFormattedTextField busqueda;
        private static ListContract listInstance;
        private ArrayList<Contract> active = new ArrayList<>();
        private ArrayList<Contract> finished = new ArrayList<>();
    
    	private ImageIcon workerIcon = new ImageIcon(ListWorker.class.getResource("/icons/worker.png"));
	private ImageIcon contractIcon =new ImageIcon(ListWorker.class.getResource("/icons/contract.png"));
	private ImageIcon clientIcon = new ImageIcon(ListWorker.class.getResource("/icons/client.png"));
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public ListContract() throws ParseException {
		load();
///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
		setUndecorated(true);
		setBounds(100, 100, 806, 455);
		getContentPane().setLayout(new BorderLayout());
		contentPane.setBorder(new LineBorder(new Color(112, 128, 144), 2));
		contentPane.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "B\u00FAsqueda", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(220,220,220));
		panel_1.setBounds(460, 32, 336, 62);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		MaskFormatter mask = new MaskFormatter("#####-#####-#####-#####");
		
		busqueda = new JFormattedTextField(mask);
		busqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				findContract();
			}
		});
		busqueda.setBounds(110, 22, 216, 22);
		panel_1.add(busqueda);
		busqueda.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Identificador:");
		lblNewLabel.setBounds(10, 26, 90, 14);
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(112, 128, 144), 2));
		panel.setBounds(0, 0, 806, 29);
		contentPane.add(panel);
		
		JLabel lblListarContratos = new JLabel("Listar Contratos");
		lblListarContratos.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
		lblListarContratos.setBounds(12, 1, 185, 27);
		panel.add(lblListarContratos);
		
		JLabel lblClose = new JLabel("");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			  	MainVisual.getInstance().getMenuPanel().setVisible(false);
				MainVisual.getInstance().getContractPanel().setVisible(true);
//				MainVisual.getInstance().getLblIcon1().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/contract.png")));
//				MainVisual.getInstance().getLblIcon2().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/createContract.png")));
				MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
				MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
				MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
				refreshAdmin();
				dispose();
			}
		});
		lblClose.setIcon(new ImageIcon(ListContract.class.getResource("/icons/close.png")));
		lblClose.setBounds(780, 2, 26, 26);
		panel.add(lblClose);
		
		JPanel activeContracts = new JPanel();
		activeContracts.setBackground(new Color(220,220,220));
		activeContracts.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Contratos Activos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		activeContracts.setBounds(10, 32, 440, 371);
		contentPane.add(activeContracts);
		activeContracts.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 420, 336);
		activeContracts.add(scrollPane);

		
		///////////////////////////////////////Lo que se debe copiar para hacer las tablas/////////////////////////////////////////////////
		String[] columnsHeaders = {"Cliente", "Proyecto", "Entrega", "Cotización", "ID"};
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
				
			         
			    }
			}
		});
		scrollPane.setColumnHeaderView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		////////////////////////////////////////////////Lo que se debe copiar para hacer las tablas/////////////////////////////////////////
		loadContracts(active);
		
		JPanel finishedContracts = new JPanel();
		finishedContracts.setBackground(new Color(220,220,220));
		finishedContracts.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), " Contratos Finalizados", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		finishedContracts.setBounds(460, 105, 336, 298);
		contentPane.add(finishedContracts);
		finishedContracts.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 24, 316, 263);
		finishedContracts.add(scrollPane_1);
		
		super.getToolkit().getScreenSize(); 
		this.setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);	
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String[] columnsHeaders1 = {"Cliente", "Proyecto", "Precio Final", "Pérdidas"};
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
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			    if(table_1.getSelectedRow()>=0){
			         
			    }
			}
		});
		scrollPane_1.setColumnHeaderView(table_1);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setModel(tableModel1);
		scrollPane_1.setViewportView(table_1);
		loadFinishedContracts(finished);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
////////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(112, 128, 144), 2));
			buttonPane.setBackground(new Color(220,220,220));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				JButton btnPosponerContrato = new JButton("Posponer contrato");
				btnPosponerContrato.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (table.getSelectedRow()>=0) {
							int index = table.getSelectedRow();
							Contract contract = Admin.getInstance().getContracts().get(index);
							if (contract.getPostpone()==0) {
								CreateContract cont = new CreateContract(null, true, contract, index);
								cont.setVisible(true);
							}
							else {
								JOptionPane.showMessageDialog(null, "Este contrato ya ha sido pospuesto 1 vez", null, JOptionPane.WARNING_MESSAGE, null);
							}
						}
					}
				});
				JButton okButton = new JButton("Finalizar Contrato");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (table.getSelectedRow()>=0) {
							   int index = table.getSelectedRow();
							   int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea finalizar este contrato?", null, JOptionPane.WARNING_MESSAGE);
								if(JOptionPane.OK_OPTION==resp) {
									if (validarFecha(active.get(index).getFinalDate(),new Date())) {
									freeWorkers(active.get(index));
									remove(active.get(index));
									if (finishContract(index)) {
										JOptionPane.showMessageDialog(null, "Se ha finalizado el contrato", null, JOptionPane.INFORMATION_MESSAGE, null);
									}
									else {
										JOptionPane.showMessageDialog(null, "No se podido finalizar el contrato. No se ha cumplido el tiempo estipulado", null, JOptionPane.WARNING_MESSAGE, null);
									}
									}
								}
						}
					}
				});
				okButton.setBackground(new Color(255,255,240));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				btnPosponerContrato.setBackground(new Color(255,255,240));
				buttonPane.add(btnPosponerContrato);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						  MainVisual.getInstance().getMenuPanel().setVisible(false);
						  MainVisual.getInstance().getContractPanel().setVisible(true);
//						  MainVisual.getInstance().getLblIcon1().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/contract.png")));
//						  MainVisual.getInstance().getLblIcon2().setIcon(new ImageIcon(MainVisual.class.getResource("/icons/createContract.png")));
						   MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
						    MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
						    MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
						  refreshAdmin();
						  dispose();
					}
				});
				cancelButton.setBackground(new Color(255,255,240));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		listInstance=this;
	}
	public void loadContracts(ArrayList<Contract> contracts) {
	   	tableModel.setRowCount(0);
	   	int actualRow=0;
	   	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	   	tcr.setHorizontalAlignment(SwingConstants.CENTER);
	   	table.getColumnModel().getColumn(0).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(1).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(2).setCellRenderer(tcr);
	   	table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table.getColumnModel().getColumn(4).setCellRenderer(tcr);
	   	row = new Object[tableModel.getColumnCount()];
	   	for (Contract ct: contracts) {
	   		if (ct.getProject().getState().equals("En progreso")) {
	   	    row[0]=ct.getClient().getName() +" "+ ct.getClient().getLastName();
	   	    row[1]=ct.getProject().getName();
	   	    row[2]=ct.getFinalDate();
	   	
	   	    row[3]=String.format("%.2f",ct.getFinalPrice());
	   	    row[4]=ct.getContractID();
	   	    tableModel.addRow(row);
//	   	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//	   	    Date date=new Date();
//	   	    int days = Admin.getInstance().calculateDays(dateFormat.format(date), ct.getFinalDate());
	   	    /*if(days<=7){
	   		table.getValueAt(row, colum);
	   	    }*/
	   	}
	   	actualRow++;
	  }
   }
    private void loadFinishedContracts(ArrayList<Contract> contracts) {
       	tableModel1.setRowCount(0);
	   	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	   	tcr.setHorizontalAlignment(SwingConstants.CENTER);
	   	table_1.getColumnModel().getColumn(0).setCellRenderer(tcr);
	   	table_1.getColumnModel().getColumn(1).setCellRenderer(tcr);
	   	table_1.getColumnModel().getColumn(2).setCellRenderer(tcr);
	   	table_1.getColumnModel().getColumn(3).setCellRenderer(tcr);
	   	row1 = new Object[tableModel1.getColumnCount()];
	   	for (Contract pr : contracts) {
	   		if (pr.getProject().getState().equals("Finalizado")) {
	   	    row1[0]=pr.getClient().getName()+" "+pr.getClient().getLastName();
	   	    row1[1]=pr.getProject().getName();
	   	    row1[2]=String.format("%.2f",pr.getFinalPrice());
	   	    row1[3]=pr.getLostMoney();
	   	    tableModel1.addRow(row1);
	   		}
	   	}
    }
    @SuppressWarnings({ "deprecation"})
	private boolean finishContract(int index) {
    	Date today = new Date();
    	boolean aux = false;
    	Contract contract = active.get(index);
     	if (validarFecha(active.get(index).getFinalDate(),today)) {
     		String[] separate = contract.getFinalDate().split("/");
    		long finalTime = Date.parse(giveMonth(Integer.parseInt(separate[1]))+" "+separate[0]+", "+separate[2]);  // Chequear esto, puede que de errores
			long time = finalTime - today.getTime();
    		long days = (TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS));
    		active.get(index).setLostMoney(contract.getFinalPrice()*days*0.01);
    		active.get(index).setFinalPrice(contract.getFinalPrice() - contract.getLostMoney());
    		active.get(index).getProject().setState("Finalizado");
    		loadContracts(active);
    		finished.add(active.get(index));
    		active.remove(index);
    		loadFinishedContracts(finished);
    		aux = true;
    	}
    	return aux;
    }
    private boolean validarFecha(String fechaInicial, Date fechaFinal) throws NullPointerException {
		boolean aux = false;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String hoy = formato.format(fechaFinal);
		String[] introd = fechaInicial.split("/");
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
				if (Integer.parseInt(actual[0]) >= Integer.parseInt(introd[0])) {
					aux = true;
				}
				else if (Integer.parseInt(actual[0]) < Integer.parseInt(introd[0])) {
					aux = false;
				}
			}
		}
		return aux;
	}
    
    public static ListContract getInstance() throws ParseException{
	if(listInstance==null){
	    return new ListContract();
	}else{
	    return listInstance;
	}
    }
    public static String giveMonth(int number) {
    	String aux = null;
    	if (number==1)
    		aux = "Jan";
    	else if (number==2)
    		aux = "Feb";
    	else if (number==3)
    		aux = "Mar";
    	else if (number==4)
    		aux = "Apr";
    	else if (number==5)
    		aux = "May";
    	else if (number==6)
    		aux = "Jun";
    	else if (number==7)
    		aux = "Jul";
    	else if (number==8)
    		aux = "Aug";
    	else if (number==9)
    		aux = "Sep";
    	else if (number==10)
    		aux = "Oct";
    	else if (number==11)
    		aux = "Nov";
    	else if (number==12)
    		aux = "Dec";
    	
    	return aux;
    }
    private void load() {
    	for (Contract i: Admin.getInstance().getContracts()) {
    		if (i.getProject().getState().equals("En progreso"))
    			active.add(i);
    		else
    			finished.add(i);
    	}
    }
    private void refreshAdmin() {
    	Admin.getInstance().getContracts().removeAll(Admin.getInstance().getContracts());
    	for (Contract i: active) {
    		Admin.getInstance().getContracts().add(i);
    	}
    	for (Contract j: finished) {
    		Admin.getInstance().getContracts().add(j);
    	}
    }
	private void findContract() {
		String textField = busqueda.getText().substring(0, busqueda.getCaretPosition());
		ArrayList<Contract> selected = new ArrayList<>();
		if (textField.length()!=0) {
		for (Contract i: Admin.getInstance().getContracts()) {
			String aux = getIDContract(busqueda.getCaretPosition(), i);
			if (textField.equals(aux))
				selected.add(i);
		   }
		}
		else {
			selected = Admin.getInstance().getContracts();
		}
		loadContracts(selected);
		
	}

	private String getIDContract(int number, Contract contract) {
		String aux = null;
		String aux1 = contract.getContractID();
		aux = aux1.substring(0, number);
		return aux;
	}
	private void freeWorkers(Contract contract) {
		ArrayList<Worker> workers = contract.getProject().getWorkers();
		for (Worker i: workers) {
			int index = Admin.getInstance().getWorkers().indexOf(i);
			Admin.getInstance().getWorkers().get(index).setAvailable(Admin.getInstance().getWorkers().get(index).getAvailable()-1);
		}
	}
   private void remove(Contract contract) {
	   for (Client i: Admin.getInstance().getClients()) {
		   if (i.getContracts().contains(contract))
			   i.getContracts().remove(contract);
	   }
   }
}
