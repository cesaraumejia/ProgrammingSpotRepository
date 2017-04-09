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
import java.util.ArrayList;

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
    private ImageIcon workerIcon = new ImageIcon("src/icons/worker.png");
    private ImageIcon contractIcon =new ImageIcon("src/icons/contract.png");
    private ImageIcon clientIcon = new ImageIcon("src/icons/client.png");
    private JTextField tfdCliente;
    
    public CreateContract() {
 ///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
    	setUndecorated(true);
	setBounds(100, 100, 577, 346);
	getContentPane().setLayout(null);
	contentPane.setBounds(0, 0, 577, 311);
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	contentPane.setBackground(new Color(220, 220, 220));
	getContentPane().add(contentPane);
	super.getToolkit().getScreenSize(); 
	this.setResizable(false);
	setLocationRelativeTo(null);
	setModal(true);	
////////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
	{
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBounds(0, 311, 577, 35);
	    buttonPane.setBackground(new Color(220, 220, 220));
	    buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane);
	    {
		JButton btnCrear = new JButton("Crear");
		
		
		btnCrear.setBackground(Color.LIGHT_GRAY);
		btnCrear.setActionCommand("OK");
		buttonPane.add(btnCrear);
		getRootPane().setDefaultButton(btnCrear);
	    }
	    
	    	topPanel = new JPanel();
	    	topPanel.setBounds(0, 0, 710, 29);
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
		
		lblNewLabel = new JLabel("Crear Contrato");
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
		panel.setBounds(17, 40, 546, 260);
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Detalles del contrato", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
	
		tfdCliente = new JTextField();
		tfdCliente.setBounds(104, 62, 396, 22);
		panel.add(tfdCliente);
		tfdCliente.setBackground(new Color(230, 230, 250));
		tfdCliente.setHorizontalAlignment(SwingConstants.CENTER);

		tfdCliente.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente:");
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
		
		JLabel lblFechaInicial = new JLabel("Fecha inicial:");
		lblFechaInicial.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaInicial.setBounds(10, 113, 85, 14);
		panel.add(lblFechaInicial);
		
		JLabel lblFechaFinal = new JLabel("Fecha final:");
		lblFechaFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaFinal.setBounds(281, 113, 102, 14);
		panel.add(lblFechaFinal);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(104, 112, 127, 20);
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(373, 112, 127, 20);
		panel.add(dateChooser_1);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(10, 22, 46, 14);
		panel.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(104, 23, 127, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblPrecio = new JLabel("Precio: RD$");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(373, 187, 149, 14);
		panel.add(lblPrecio);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Book Antiqua", Font.ITALIC, 13));
		lblNewLabel_2.setBounds(458, 188, 64, 14);
		panel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("*Introducir c\u00E9dula con guiones");
		label.setFont(new Font("Tahoma", Font.ITALIC, 10));
		label.setBounds(104, 87, 150, 14);
		panel.add(label);
	    
	    
	    {
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBackground(Color.LIGHT_GRAY);
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
}

