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
    
    private ImageIcon windowsCloseIcon =new ImageIcon("src/icons/close.png");
    private ImageIcon workerIcon = new ImageIcon("src/icons/worker.png");
    private ImageIcon contractIcon =new ImageIcon("src/icons/contract.png");
    private ImageIcon clientIcon = new ImageIcon("src/icons/client.png");
    private JScrollPane scrollPaneContracts;
    private String clientID;
    private Client foundClient;
    private JFormattedTextField formattedID;

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

	{

	    	JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Clientes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 42, 691, 400);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(12, 22, 667, 365);
			panel.add(scrollPane);
			{
			    
				String[] columnsHeaders = {"Cédula", "Nombre", "Apellido", "Residencia","Cantidad de Contratos"};
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
				table=new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
					    if(table.getSelectedRow()>=0){
						int index = table.getSelectedRow();
						clientID = (String)table.getModel().getValueAt(index, 0);
						foundClient = Admin.getInstance().searchClientByID(clientID);
						loadContracts(foundClient);
					    }
					}
				});
				scrollPane.setColumnHeaderView(table);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(tableModel);
				scrollPane.setViewportView(table);
			}
	    
		}
		loadClients(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 1003, 29);
		contentPanel.add(panel_1);
		
		JLabel lblListarClientes = new JLabel("Listar Clientes");
		lblListarClientes.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblListarClientes.setBounds(12, 1, 141, 27);
		panel_1.add(lblListarClientes);
		
		JLabel label_1 = new JLabel("New label");
		label_1.addMouseListener(new MouseAdapter() {
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
		label_1.setBounds(977, 3, 26, 26);
		label_1.setIcon(windowsCloseIcon);
		panel_1.add(label_1);
		{
			JPanel panelActiveContracts = new JPanel();
			panelActiveContracts.setBackground(new Color(220, 220, 220));
			panelActiveContracts.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contratos Activos", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panelActiveContracts.setBounds(715, 160, 263, 282);
			contentPanel.add(panelActiveContracts);
			panelActiveContracts.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(null);
			panel_2.setBackground(new Color(220, 220, 220));
			panel_2.setBounds(12, 13, 229, 243);
			panelActiveContracts.add(panel_2);
			
			
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
			
			scrollPaneContracts = new JScrollPane();    
			scrollPaneContracts.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneContracts.setBounds(12, 13, 206, 220);
			panel_2.add(scrollPaneContracts);
			
			
			tableModelContracts.setColumnIdentifiers(columnsHeadersContracts);
			tableContracts=new JTable();
			tableContracts.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
				    if(tableContracts.getSelectedRow()>=0){
					
				    }
				}
			});
			scrollPaneContracts.setColumnHeaderView(tableContracts);
			tableContracts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableContracts.setModel(tableModelContracts);
			scrollPaneContracts.setViewportView(tableContracts);
			
			
		
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "B\u00FAsqueda de clientes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(220, 220, 220));
		panel_2.setBounds(715, 42, 263, 88);
		contentPanel.add(panel_2);
		
		JLabel label = new JLabel("C\u00E9dula:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 37, 46, 14);
		panel_2.add(label);
		
		JLabel lblintroducirCdulaConguiones = new JLabel("*Introducir c\u00E9dula con guiones");
		lblintroducirCdulaConguiones.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblintroducirCdulaConguiones.setBounds(10, 63, 150, 14);
		panel_2.add(lblintroducirCdulaConguiones);
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
		panel_2.add(formattedID);
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBackground(new Color(220, 220, 220));
	    buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
	    	JButton btnDetails = new JButton("Ver detalles de contrato");
	    	buttonPane.add(btnDetails);
	    	btnDetails.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    		}
	    	});
	    	btnDetails.setBackground(new Color(255, 255, 240));
	    	btnDetails.setActionCommand("OK");
	    }
	    {
		JButton btnModify = new JButton("Modificar");
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
    
    private void loadClients( ArrayList<Client> filteredClients) {
	System.out.println();
   	tableModel.setRowCount(0);
   	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
   	tcr.setHorizontalAlignment(SwingConstants.CENTER);
   	table.getColumnModel().getColumn(0).setCellRenderer(tcr);
   	table.getColumnModel().getColumn(1).setCellRenderer(tcr);
   	table.getColumnModel().getColumn(2).setCellRenderer(tcr);
   	table.getColumnModel().getColumn(3).setCellRenderer(tcr);
   	table.getColumnModel().getColumn(4).setCellRenderer(tcr);
   	row = new Object[tableModel.getColumnCount()];
   	ArrayList<Client> clientsList = Admin.getInstance().getClients();
   	if(filteredClients!=null && !formattedID.getText().equals("  ")){
   	    clientsList=filteredClients;
   	}
   	
   	for (Client ct : clientsList) {
   	    row[0]=ct.getIdNumber();
   	    row[1]=ct.getName();
   	    row[2]=ct.getLastName();
   	    row[3]=ct.getAddress();
   	    row[4]=String.valueOf(ct.getContracts().size());
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
