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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Logico.Admin;
import Logico.Client;
import Logico.Contract;

public class ListClient extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private static JTable table;
    private static DefaultTableModel tableModel;
    private static Object[] row;
    
    private static JTable tableContracts;
    private static DefaultTableModel tableModelContracts;
    private static Object[] rowContracts;
    
    private ImageIcon windowsCloseIcon =new ImageIcon(ListClient.class.getResource("/icons/close.png"));
    private ImageIcon workerIcon = new ImageIcon(ListClient.class.getResource("/icons/worker.png"));
    private ImageIcon contractIcon =new ImageIcon(ListClient.class.getResource("/icons/contract.png"));
    private ImageIcon clientIcon = new ImageIcon(ListClient.class.getResource("/icons/client.png"));
    private JScrollPane scrollPaneContracts;
    private String clientID;
    private Client foundClient;
    private static JFormattedTextField formattedID;
    private JPanel outPanel;
    private JPanel topPanel;
    private JLabel lblClose;
    private JLabel lblIcon;
    private JPanel outContentPanel;
    private JTextField tfdName;
    private JTextField tfdPrice;
    private JLabel lblDeliverDate;
    private JTextField tfdDeliverDate;
    private JLabel lblPostpone;
    private JTextField tfdPostpone;
    private JButton btnDetails;
    private Contract selectedContract;
    private JButton btnBack;

    /**
     * Launch the application.
     *
     */
 
    public ListClient() {
    	setUndecorated(true);
	setBounds(100, 100, 1003, 500);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBackground(new Color(220, 220, 220));
	contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);
	this.setResizable(false);
	setLocationRelativeTo(null);
	setModal(true);
	
///////////////Inicializaciond de los table models /////////////////
	
	String[] columnsHeaders = {"Cédula", "Cliente", "Residencia","Cantidad de Contratos"};
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
    	String[] columnsHeadersContracts = {"No.", "Tipo", "Lenguaje"};
	tableModelContracts = new DefaultTableModel(){
	    /**
	     * 
	     */
	    private static final long serialVersionUID = 1L;

	    @Override
	    public boolean isCellEditable(int row, int column) {
		
		return false;
	    }
	 
	};
	
	tableModelContracts.setColumnIdentifiers(columnsHeadersContracts);
	
	
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
	
	JPanel mainPanel = new JPanel();
	mainPanel.setBorder(new LineBorder(new Color(112, 128, 144), 2));
	mainPanel.setBackground(new Color(220, 220, 220));
	mainPanel.setBounds(0, 27, 1003, 436);
	contentPanel.add(mainPanel);
	mainPanel.setLayout(null);
	
	JPanel panelSearchClient = new JPanel();
	panelSearchClient.setBounds(716, 13, 263, 88);
	mainPanel.add(panelSearchClient);
	panelSearchClient.setLayout(null);
	panelSearchClient.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "B\u00FAsqueda de clientes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	panelSearchClient.setBackground(new Color(220, 220, 220));
	
	JLabel label = new JLabel("C\u00E9dula:");
	label.setFont(new Font("Tahoma", Font.BOLD, 11));
	label.setBounds(10, 37, 46, 14);
	panelSearchClient.add(label);
	
	JLabel lblintroducirCdulaConguiones = new JLabel("*Introducir c\u00E9dula con guiones");
	lblintroducirCdulaConguiones.setFont(new Font("Tahoma", Font.ITALIC, 10));
	lblintroducirCdulaConguiones.setBounds(10, 63, 150, 14);
	panelSearchClient.add(lblintroducirCdulaConguiones);
	
	formattedID = new JFormattedTextField(idFormatter);
	formattedID.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
	
			loadClients(findClients());
			
		}
	});
	formattedID.setHorizontalAlignment(SwingConstants.CENTER);
	formattedID.setBackground(new Color(230, 230, 250));
	formattedID.setBounds(64, 32, 187, 22);
	panelSearchClient.add(formattedID);
	
		    	JPanel panel = new JPanel();
		    	panel.setBounds(22, 13, 679, 407);
		    	mainPanel.add(panel);
		    	panel.setBackground(new Color(220, 220, 220));
		    	panel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Clientes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		    	panel.setLayout(null);
		    	JScrollPane scrollPane = new JScrollPane();
		    	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    	scrollPane.setBounds(12, 22, 655, 365);
		    	panel.add(scrollPane);
		    	table=new JTable();
		    	table.addMouseListener(new MouseAdapter() {
		    		@Override
		    		public void mouseReleased(MouseEvent e) {
		    		    if(table.getSelectedRow()>=0){
		    			int index = table.getSelectedRow();
		    			clientID = (String)table.getModel().getValueAt(index, 0);
		    			foundClient = Admin.getInstance().searchClientByID(clientID);
		    			loadContracts(foundClient);
		    			btnDetails.setEnabled(false);
		    		    }
		    		}
		    	});
		    	scrollPane.setColumnHeaderView(table);
		    	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    	table.setModel(tableModel);
		    	scrollPane.setViewportView(table);
		    	JPanel panelActiveContracts = new JPanel();
		    	panelActiveContracts.setBounds(713, 121, 263, 299);
		    	mainPanel.add(panelActiveContracts);
		    	panelActiveContracts.setBackground(new Color(220, 220, 220));
		    	panelActiveContracts.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Contratos Activos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		    	panelActiveContracts.setLayout(null);
		    	
		    	JPanel panel_2_1 = new JPanel();
		    	panel_2_1.setLayout(null);
		    	panel_2_1.setBorder(null);
		    	panel_2_1.setBackground(new Color(220, 220, 220));
		    	panel_2_1.setBounds(12, 26, 239, 260);
		    	panelActiveContracts.add(panel_2_1);
		    	
		    	scrollPaneContracts = new JScrollPane();    
		    	scrollPaneContracts.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		    	scrollPaneContracts.setBounds(0, 0, 239, 260);
		    	panel_2_1.add(scrollPaneContracts);
		    	tableContracts=new JTable();
		    	tableContracts.addMouseListener(new MouseAdapter() {
		    		@Override
		    		public void mouseReleased(MouseEvent e) {
		    		    if(tableContracts.getSelectedRow()>=0){
		    			int index = tableContracts.getSelectedRow();
		    			String contractId = (String)tableContracts.getModel().getValueAt(index, 0);
		    			selectedContract=foundClient.searchContractByID(contractId);
		    			btnDetails.setEnabled(true);
		    			loadSideParams();
		    		    }
		    		}
		    	});
		    	scrollPaneContracts.setColumnHeaderView(tableContracts);
		    	tableContracts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    	tableContracts.setModel(tableModelContracts);
		    	scrollPaneContracts.setViewportView(tableContracts);
			
		    	

	{
		loadClients(null);
		
		outPanel = new JPanel();
		outPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		outPanel.setBackground(new Color(220, 220, 220));
		outPanel.setBounds(991, 27, 244, 440);
		contentPanel.add(outPanel);
		outPanel.setLayout(null);
		
		outContentPanel = new JPanel();
		outContentPanel.setBackground(new Color(220, 220, 220));
		outContentPanel.setBounds(30, 10, 200, 410);
		outPanel.add(outContentPanel);
		outContentPanel.setLayout(null);
		
		lblIcon = new JLabel("");
		lblIcon.setBounds(60, 32, 64, 64);
		outContentPanel.add(lblIcon);
		lblIcon.setIcon(new ImageIcon(ListClient.class.getResource("/icons/agreement.png")));
		
		btnBack = new JButton("");
		btnBack.setBackground(new Color(255, 255, 240));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    backToStart();
			}
		});
		btnBack.setBounds(10, 20, 24, 24);
		btnBack.setIcon(new ImageIcon(ListClient.class.getResource("/icons/back.png")));
		outContentPanel.add(btnBack);
		
		JLabel lblName = new JLabel("Proyecto");
		lblName.setBounds(65, 120, 70, 16);
		outContentPanel.add(lblName);
		
		tfdName = new JTextField();
		tfdName.setBackground(new Color(220, 220, 220));
		tfdName.setEditable(false);
		tfdName.setBounds(42, 140, 116, 22);
		outContentPanel.add(tfdName);
		tfdName.setColumns(10);
		
		JLabel lblPrice = new JLabel("Cotizaci\u00F3n");
		lblPrice.setBounds(65, 180, 70, 16);
		outContentPanel.add(lblPrice);
		
		tfdPrice = new JTextField();
		tfdPrice.setBackground(new Color(220, 220, 220));
		tfdPrice.setEditable(false);
		tfdPrice.setBounds(42, 200, 116, 22);
		outContentPanel.add(tfdPrice);
		tfdPrice.setColumns(10);
		
		lblDeliverDate = new JLabel("Entrega");
		lblDeliverDate.setBounds(72, 240, 56, 16);
		outContentPanel.add(lblDeliverDate);
		
		tfdDeliverDate = new JTextField();
		tfdDeliverDate.setEditable(false);
		tfdDeliverDate.setBackground(new Color(220, 220, 220));
		tfdDeliverDate.setBounds(42, 260, 116, 22);
		outContentPanel.add(tfdDeliverDate);
		tfdDeliverDate.setColumns(10);
		
		lblPostpone = new JLabel("\u00BFPospuesto?");
		lblPostpone.setBounds(60, 300, 80, 16);
		outContentPanel.add(lblPostpone);
		
		tfdPostpone = new JTextField();
		tfdPostpone.setBackground(new Color(220, 220, 220));
		tfdPostpone.setEditable(false);
		tfdPostpone.setBounds(42, 320, 116, 22);
		outContentPanel.add(tfdPostpone);
		tfdPostpone.setColumns(10);
		
		topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBorder(new LineBorder(new Color(112, 128, 144), 2));
		topPanel.setBounds(0, 0, 1003, 29);
		contentPanel.add(topPanel);
		
		JLabel lblListarClientes = new JLabel("Listar Clientes");
		lblListarClientes.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblListarClientes.setBounds(12, 1, 141, 27);
		topPanel.add(lblListarClientes);
		
		lblClose = new JLabel("New label");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			    
			    
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				MainVisual.getInstance().getMenuPanel().setVisible(false);
				MainVisual.getInstance().getClientsPanel().setVisible(true);
				MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
				MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
				MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
				dispose();
			}
		});
		lblClose.setBounds(977, 3, 26, 26);
		lblClose.setIcon(windowsCloseIcon);
		topPanel.add(lblClose);
	

	    JPanel buttonPane = new JPanel();
	    buttonPane.setBackground(new Color(220, 220, 220));
	    buttonPane.setBorder(new LineBorder(new Color(112, 128, 144), 2));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
	    	btnDetails = new JButton("Mas detalles del contrato");
	    	btnDetails.setEnabled(false);
	    	buttonPane.add(btnDetails);
	    	btnDetails.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    		    loadSideParams();
	    		    setBounds(100, 100, 1235, 500);
	    		    topPanel.setBounds(0, 0, 1236, 29);
	    		    lblClose.setBounds(1210, 3, 26, 26);
	    		    setLocationRelativeTo(null);
	    		    outContentPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Detalles del Contrato", TitledBorder.CENTER, TitledBorder.TOP, null, null));
	    		    
	    		}
	    	});
	    	btnDetails.setBackground(new Color(255, 255, 240));
	    	btnDetails.setActionCommand("OK");
	    }
	    {
		JButton btnModify = new JButton("Modificar");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()>=0){
					int index = table.getSelectedRow();
					Client client = Admin.getInstance().getClients().get(index);
					RegisterClient regist = new RegisterClient(true, client, index);
					regist.setVisible(true);
				}
			}
		});
		btnModify.setBackground(new Color(255, 255, 240));
		btnModify.setActionCommand("OK");
		buttonPane.add(btnModify);
		getRootPane().setDefaultButton(btnModify);
	    }
	    {
		JButton btnCancel = new JButton("Salir");
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
		btnCancel.setBackground(new Color(255, 255, 240));
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);
	    }
	}
    }
    
    public static void loadClients( ArrayList<Client> filteredClients) {
	System.out.println();
   	tableModel.setRowCount(0);
   	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
   	tcr.setHorizontalAlignment(SwingConstants.CENTER);
   	table.getColumnModel().getColumn(0).setCellRenderer(tcr);
   	table.getColumnModel().getColumn(1).setCellRenderer(tcr);
   	table.getColumnModel().getColumn(2).setCellRenderer(tcr);
   	table.getColumnModel().getColumn(3).setCellRenderer(tcr);
   	row = new Object[tableModel.getColumnCount()];
   	ArrayList<Client> clientsList = Admin.getInstance().getClients();
   	if(filteredClients!=null && !formattedID.getText().equals("  ")){
   	    clientsList=filteredClients;
   	}
   	
   	for (Client ct : clientsList) {
   	    row[0]=ct.getIdNumber();
   	    row[1]=ct.getName() +" "+ct.getLastName();;
   	    row[2]=ct.getAddress();
   	    row[3]=String.valueOf(ct.getContracts().size());
   	    tableModel.addRow(row);
   	}
    }
    
    private void loadContracts(Client client){
	tableModelContracts.setRowCount(0);
   	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
   	tcr.setHorizontalAlignment(SwingConstants.CENTER);
   	tableContracts.getColumnModel().getColumn(0).setCellRenderer(tcr);
   	tableContracts.getColumnModel().getColumn(1).setCellRenderer(tcr);
   	tableContracts.getColumnModel().getColumn(2).setCellRenderer(tcr);
   	rowContracts = new Object[tableModel.getColumnCount()];
   	for (Contract ct : client.getContracts()) {
	    rowContracts[0] = ct.getContractID();
	    rowContracts[1] = ct.getProject().getProgrammingType();
	    rowContracts[2] = ct.getProject().getProgrammingLanguage();
	    tableModelContracts.addRow(rowContracts);
   	}
    }
    
    private void backToStart(){
	  setBounds(100, 100, 1003, 500);
	  topPanel.setBounds(0, 0, 1003, 29);
	  lblClose.setBounds(977, 3, 26, 26);
	  setLocationRelativeTo(null);

    }
    
    private void loadSideParams(){
	    tfdName.setText(selectedContract.getProject().getName());
		    tfdDeliverDate.setText(selectedContract.getFinalDate());
		    tfdPrice.setText(String.valueOf(selectedContract.getFinalPrice()));
		    if(selectedContract.getPostpone()>=1){
			tfdPostpone.setText("Si");
		    }else{
			tfdPostpone.setText("No");
		    }
    }
    
    private ArrayList<Client> findClients() {
	    ArrayList<Client> filteredClients=new ArrayList<>();
	    String filter = formattedID.getText().substring(0,formattedID.getCaretPosition());
	    for (Client ct : Admin.getInstance().getClients()) {
		try {
		    if(ct.getIdNumber().subSequence(0, filter.length()).equals(filter)){
			    filteredClients.add(ct);
			}
		} catch (StringIndexOutOfBoundsException e) {
		    
		}
	    }
	    return filteredClients;
	}
}
