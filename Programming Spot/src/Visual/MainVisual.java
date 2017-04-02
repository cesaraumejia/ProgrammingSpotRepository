package Visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainVisual extends JFrame {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel menuPanel;
	private JPanel extendedPanel;
	private JPanel topPanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
    private int x;
    private int y;
    private static MainVisual frame;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel lblClients;
    private JLabel lblContracts;
    private JLabel lblWorkers;
    private JPanel windowsContentPanel;
    private Dimension dim;
    private JLabel lblMinimize;
    private JLabel lblClose;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainVisual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainVisual() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1249, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		dim = super.getToolkit().getScreenSize(); 
		super.setSize((dim.width-10),(dim.height-80));
		this.setResizable(false);
		setLocationRelativeTo(null);
		
		
		
		menuPanel = new JPanel();
		menuPanel.setBounds(0, 34, 34, 966);
		contentPane.add(menuPanel);
		menuPanel.setBackground(new Color(128, 128, 128));
		menuPanel.setLayout(null);
		
		JLabel menuIcon = new JLabel("New label");
		menuIcon.setIcon(new ImageIcon("src/icons/nemu.png"));
		menuIcon.setBounds(3, 0, 24, 37);
		menuPanel.add(menuIcon);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("src/icons/client.png"));
		lblNewLabel_4.setBounds(3, 35, 24, 37);
		menuPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("src/icons/desc.png"));
		lblNewLabel_5.setBounds(3, 82, 24, 37);
		menuPanel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("src/icons/worker.png"));
		lblNewLabel_6.setBounds(3, 130, 24, 37);
		menuPanel.add(lblNewLabel_6);
		menuIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				menuPanel.setVisible(false);
				extendedPanel.setVisible(true);
			}
		});
		
		extendedPanel = new JPanel();
		extendedPanel.setBounds(0, 34, 233, 966);
		contentPane.add(extendedPanel);
		extendedPanel.setBackground(new Color(128, 128, 128));
		extendedPanel.setLayout(null);
		
		label = new JLabel("New label");
		label.setIcon(new ImageIcon("src/icons/worker.png"));
		label.setBounds(3, 130, 24, 37);
		extendedPanel.add(label);
		
		label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("src/icons/desc.png"));
		label_1.setBounds(3, 82, 24, 37);
		extendedPanel.add(label_1);
		
		label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon("src/icons/client.png"));
		label_2.setBounds(3, 35, 24, 37);
		extendedPanel.add(label_2);
		
		label_3 = new JLabel("New label");
		label_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				extendedPanel.setVisible(false);
				menuPanel.setVisible(true);
			}
		});
		label_3.setIcon(new ImageIcon("src/icons/back.png"));
		label_3.setBounds(3, 0, 24, 37);
		extendedPanel.add(label_3);
		
		lblClients = new JLabel("Clientes");
		lblClients.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				lblClients.setForeground(new Color(240, 240, 240));
			}
			public void mouseReleased(MouseEvent e) {
				lblClients.setForeground(new Color(0, 0, 0));
			}
		});
		lblClients.setForeground(new Color(0, 0, 0));

		lblClients.setBackground(new Color(192, 192, 192));		
		lblClients.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblClients.setBounds(58, 35, 143, 37);
		extendedPanel.add(lblClients);
		
		lblContracts = new JLabel("Contratos");
		lblContracts.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				lblContracts.setForeground(new Color(240, 240, 240));
			}
			public void mouseReleased(MouseEvent e) {
				lblContracts.setForeground(new Color(0, 0, 0));
			}
		});
		lblContracts.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblContracts.setBounds(58, 80, 143, 37);
		extendedPanel.add(lblContracts);
		
		lblWorkers = new JLabel("Empleados");
		lblWorkers.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				lblWorkers.setForeground(new Color(240, 240, 240));
			}
			public void mouseReleased(MouseEvent e) {
				lblWorkers.setForeground(new Color(0, 0, 0));
			}
		});
		lblWorkers.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblWorkers.setBounds(58, 130, 143, 37);
		extendedPanel.add(lblWorkers);
		extendedPanel.setVisible(false);
		
		topPanel = new JPanel();
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
		topPanel.setBounds(0, 0, 1910, 34);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		lblMinimize = new JLabel("New label");
		lblMinimize.addMouseListener(new MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				frame.setExtendedState(ICONIFIED);
			}
		});
		lblMinimize.setIcon(new ImageIcon("src/icons/minimize.png"));
		lblMinimize.setBounds((int)dim.width-80, 0, 29, 34);
		topPanel.add(lblMinimize);
		
		lblClose = new JLabel("New label");
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.exit(0);
			}
		});
		lblClose.setIcon(new ImageIcon("src/icons/close.png"));
		lblClose.setBounds((int)dim.width-40, 0, 29, 34);
		topPanel.add(lblClose);
		
		lblNewLabel = new JLabel("Programming Spot");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 2, 261, 32);
		topPanel.add(lblNewLabel);
		
		windowsContentPanel = new JPanel();
		windowsContentPanel.setBounds(233, 34, 1677, 966);
		windowsContentPanel.setBackground(new Color(153, 153, 153));	
		contentPane.add(windowsContentPanel);
		@SuppressWarnings("unused")
		ImageIcon image = new ImageIcon("src/icons/code.png");
		
	}
}
