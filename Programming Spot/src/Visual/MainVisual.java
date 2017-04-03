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
	private JLabel lblIcon1;
	private JLabel lblIcon2;
	private JLabel lblIcon3;
	
	private int x;
        private int y;
        
        private static MainVisual frame;
        
        private JLabel lblWorkerMainIcon;
        private JLabel lblContractsMainIcon;
        private JLabel lblClientMainIcon;
        private JLabel lblBackMain;
        private JLabel lblClientMain;
        private JLabel lblContractMain;
        private JLabel lblWorkerMain;
        private JPanel windowsContentPanel;
        
        private Dimension dim;
        
        private JLabel lblMinimize;
        private JLabel lblClose;
        private JPanel clientsPanel;
        private JLabel lblListClientsIcon;
        private JLabel lblRegisterCLientsIcon;
        private JLabel lblClientsIcon;
        private JLabel lblBackClientIcon;
        private JLabel lblClientsMenu;
        private JLabel lblClientRegister;
        private JLabel lblClientList;
        private JLabel menuIcon;
        
        private ImageIcon backTransitionIcon= new ImageIcon("src/icons/backTransition.png");
        private ImageIcon backIcon = new ImageIcon("src/icons/back.png");
        private ImageIcon workerIcon = new ImageIcon("src/icons/worker.png");
        private ImageIcon contractIcon =new ImageIcon("src/icons/contract.png");
        private ImageIcon clientIcon = new ImageIcon("src/icons/client.png");
        private ImageIcon listClientIcon = new ImageIcon("src/icons/listClient.png");
        private ImageIcon registerClienticon= new ImageIcon("src/icons/registerClient.png");
        private ImageIcon menuImageIcon = new ImageIcon("src/icons/nemu.png");
        private ImageIcon menuTransitionIcon = new ImageIcon("src/icons/menuTransition.png");
        private ImageIcon windowsCloseIcon =new ImageIcon("src/icons/close.png");
        private JPanel workersPanel;


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
		
		workersPanel = new JPanel();
		workersPanel.setBackground(new Color(128,128,128));
		workersPanel.setBounds(0, 34, 233, 966);
		workersPanel.setVisible(false);
		contentPane.add(workersPanel);
		workersPanel.setLayout(null);
		
		final JLabel workersBackButton = new JLabel("New label");
		workersBackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				workersBackButton.setIcon(backIcon);
				extendedPanel.setVisible(true);
				workersPanel.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				workersBackButton.setIcon(backTransitionIcon);
			}
		});
		workersBackButton.setIcon(new ImageIcon(MainVisual.class.getResource("/icons/back.png")));
		workersBackButton.setBounds(3, 0, 24, 37);
		workersPanel.add(workersBackButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(MainVisual.class.getResource("/icons/client.png")));
		lblNewLabel_2.setBounds(3, 35, 24, 37);
		workersPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(MainVisual.class.getResource("/icons/registerClient.png")));
		lblNewLabel_3.setBounds(3, 82, 24, 37);
		workersPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(MainVisual.class.getResource("/icons/listClient.png")));
		lblNewLabel_4.setBounds(3, 130, 24, 37);
		workersPanel.add(lblNewLabel_4);
		
		JLabel lblTrabajadores = new JLabel("Trabajadores");
		lblTrabajadores.setForeground(Color.BLACK);
		lblTrabajadores.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblTrabajadores.setBackground(Color.LIGHT_GRAY);
		lblTrabajadores.setBounds(58, 35, 143, 37);
		workersPanel.add(lblTrabajadores);
		
		final JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblRegistrar.setForeground(new Color(240,240,240));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				 lblIcon1.setIcon(clientIcon);
				    lblIcon2.setIcon(registerClienticon);
				    lblIcon3.setIcon(listClientIcon);
				    menuPanel.setVisible(true);
				    workersPanel.setVisible(false);
				lblRegistrar.setForeground(new Color(0,0,0));
				RegisterWorker workersWindow = new RegisterWorker();
				workersWindow.setVisible(true);
			}
		});
		lblRegistrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblRegistrar.setBounds(58, 80, 143, 37);
		workersPanel.add(lblRegistrar);
		
		JLabel lblListar = new JLabel("Listar");
		lblListar.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblListar.setBounds(58, 130, 143, 37);
		workersPanel.add(lblListar);
		

		
		menuPanel = new JPanel();
		menuPanel.setBounds(0, 34, 34, 966);
		contentPane.add(menuPanel);
		menuPanel.setBackground(new Color(128, 128, 128));
		menuPanel.setLayout(null);
		
		menuIcon = new JLabel("New label");
		menuIcon.setIcon(menuImageIcon);
		menuIcon.setBounds(3, 0, 24, 37);
		menuPanel.add(menuIcon);
		
		lblIcon1 = new JLabel("New label");
		lblIcon1.setIcon(clientIcon);
		lblIcon1.setBounds(3, 35, 24, 37);
		menuPanel.add(lblIcon1);
		
		lblIcon2 = new JLabel("New label");
		lblIcon2.setIcon(contractIcon);
		lblIcon2.setBounds(3, 82, 24, 37);
		menuPanel.add(lblIcon2);
		
		lblIcon3 = new JLabel("New label");
		lblIcon3.setIcon(workerIcon);
		lblIcon3.setBounds(3, 130, 24, 37);
		menuPanel.add(lblIcon3);
		
		menuIcon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				menuIcon.setIcon(menuTransitionIcon);

			}
			@Override
			public void mouseReleased(MouseEvent e) {
			    	menuPanel.setVisible(false);
				extendedPanel.setVisible(true);
				menuIcon.setIcon(menuImageIcon);

			}
		});
		
		extendedPanel = new JPanel();
		extendedPanel.setBounds(0, 34, 233, 966);
		contentPane.add(extendedPanel);
		extendedPanel.setBackground(new Color(128, 128, 128));
		extendedPanel.setLayout(null);
		
		lblWorkerMainIcon = new JLabel("New label");
		lblWorkerMainIcon.setIcon(workerIcon);
		lblWorkerMainIcon.setBounds(3, 130, 24, 37);
		extendedPanel.add(lblWorkerMainIcon);
		
		lblContractsMainIcon = new JLabel("New label");
		lblContractsMainIcon.setIcon(contractIcon);
		lblContractsMainIcon.setBounds(3, 82, 24, 37);
		extendedPanel.add(lblContractsMainIcon);
		
		lblClientMainIcon = new JLabel("New label");
		lblClientMainIcon.setIcon(clientIcon);
		lblClientMainIcon.setBounds(3, 35, 24, 37);
		extendedPanel.add(lblClientMainIcon);
		
		lblBackMain = new JLabel("New label");
		lblBackMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblBackMain.setIcon(backTransitionIcon);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			    	extendedPanel.setVisible(false);
				menuPanel.setVisible(true);
				lblBackMain.setIcon(backIcon);


			}
		});
		lblBackMain.setIcon(backIcon);
		lblBackMain.setBounds(3, 0, 24, 37);
		extendedPanel.add(lblBackMain);
		
		lblClientMain = new JLabel("Clientes");
		lblClientMain.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				lblClientMain.setForeground(new Color(240, 240, 240));
			}
			public void mouseReleased(MouseEvent e) {
				lblClientMain.setForeground(new Color(0, 0, 0));
				extendedPanel.setVisible(false);
				clientsPanel.setVisible(true);
			}
		});
		lblClientMain.setForeground(new Color(0, 0, 0));
		
				lblClientMain.setBackground(new Color(192, 192, 192));		
				lblClientMain.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
				lblClientMain.setBounds(58, 35, 143, 37);
				extendedPanel.add(lblClientMain);
				
				lblContractMain = new JLabel("Contratos");
				lblContractMain.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						lblContractMain.setForeground(new Color(240, 240, 240));
					}
					public void mouseReleased(MouseEvent e) {
						lblContractMain.setForeground(new Color(0, 0, 0));
					}
				});
				lblContractMain.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
				lblContractMain.setBounds(58, 80, 143, 37);
				extendedPanel.add(lblContractMain);
				
				lblWorkerMain = new JLabel("Empleados");
				lblWorkerMain.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						lblWorkerMain.setForeground(new Color(240, 240, 240));
					}
					public void mouseReleased(MouseEvent e) {
						lblWorkerMain.setForeground(new Color(0, 0, 0));
						extendedPanel.setVisible(false);
						workersPanel.setVisible(true);
					}
				});
				lblWorkerMain.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
				lblWorkerMain.setBounds(58, 130, 143, 37);
				extendedPanel.add(lblWorkerMain);
				extendedPanel.setVisible(false);
		
		clientsPanel = new JPanel();
		clientsPanel.setBounds(0, 34, 233, 966);
		contentPane.add(clientsPanel);
		clientsPanel.setBackground(new Color(128, 128, 128));
		clientsPanel.setLayout(null);
		clientsPanel.setVisible(false);
		
		lblListClientsIcon = new JLabel("");
		lblListClientsIcon.setBounds(3, 130, 24, 37);
		clientsPanel.add(lblListClientsIcon);
		lblListClientsIcon.setIcon(listClientIcon);

		
		lblRegisterCLientsIcon = new JLabel("");
		lblRegisterCLientsIcon.setBounds(3, 82, 24, 37);
		clientsPanel.add(lblRegisterCLientsIcon);
		lblRegisterCLientsIcon.setIcon(registerClienticon);

		
		
		lblClientsIcon = new JLabel("");
		lblClientsIcon.setBounds(3, 35, 24, 37);
		clientsPanel.add(lblClientsIcon);
		lblClientsIcon.setIcon(clientIcon);

		
		lblBackClientIcon = new JLabel("");
		lblBackClientIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			    lblBackClientIcon.setIcon(backTransitionIcon);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			    clientsPanel.setVisible(false);
			    extendedPanel.setVisible(true);
			    lblBackClientIcon.setIcon(backIcon);

			}
		});
		lblBackClientIcon.setBounds(3, 0, 24, 37);
		clientsPanel.add(lblBackClientIcon);
		lblBackClientIcon.setIcon(backIcon);

		
		lblClientsMenu = new JLabel("Clientes");
		lblClientsMenu.setForeground(Color.BLACK);
		lblClientsMenu.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblClientsMenu.setBackground(Color.LIGHT_GRAY);
		lblClientsMenu.setBounds(58, 35, 143, 37);
		clientsPanel.add(lblClientsMenu);
		
		
		lblClientRegister = new JLabel("Registrar");
		lblClientRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			    lblClientRegister.setForeground(new Color(240, 240, 240));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			    lblIcon1.setIcon(clientIcon);
			    lblIcon2.setIcon(registerClienticon);
			    lblIcon3.setIcon(listClientIcon);
			    menuPanel.setVisible(true);
			    clientsPanel.setVisible(false);
			    lblClientRegister.setForeground(new Color(0, 0, 0));
			    RegisterClient registerClient=new RegisterClient();
			    registerClient.setVisible(true);
			  
			}
		});
		lblClientRegister.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblClientRegister.setBounds(58, 80, 143, 37);
		clientsPanel.add(lblClientRegister);
		
		lblClientList = new JLabel("Listar");
		lblClientList.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblClientList.setBounds(58, 130, 143, 37);
		clientsPanel.add(lblClientList);
		
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
		lblClose.setIcon(windowsCloseIcon);
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
		windowsContentPanel.setLayout(null);
		@SuppressWarnings("unused")
		ImageIcon image = new ImageIcon("src/icons/code.png");
		
		
		
	}


	///////////////////Getters And Setters//////////////////
	public static MainVisual getInstance(){
	    return frame;
	}
	
	public JPanel getMenuPanel() {
	    return menuPanel;
	}

	public JPanel getClientsPanel() {
	    return clientsPanel;
	}

	public JPanel getExtendedPanel() {
	    return extendedPanel;
	}

	public JLabel getLblIcon1() {
	    return lblIcon1;
	}

	public JLabel getLblIcon2() {
	    return lblIcon2;
	}

	public JLabel getLblIcon3() {
	    return lblIcon3;
	}

	public JPanel getWindowsContentPanel() {
	    return windowsContentPanel;
	}
}
