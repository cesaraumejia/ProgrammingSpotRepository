package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Logico.Admin;
import Logico.ReturnableGraphic;


public class SoftwareReport extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7095664060161443355L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblClose;
	private JPanel startPanel;
	private JPanel operativySystemPanel;
	private JButton btnLanguage;
	private ImageIcon platformIconOut=new ImageIcon("src/icons/platform.png");
	private ImageIcon languageOutIcon=new ImageIcon("src/icons/binary.png");
	private ImageIcon languageTransitionIcon=new ImageIcon("src/icons/binaryTransition.png");
	private ImageIcon platformTransitionIcon=new ImageIcon("src/icons/platformTransition.png");
	private ImageIcon backIcon=new ImageIcon("src/icons/backSoftware.png");
	private JButton btnOperativeSystem;
	private JPanel mostUsedSystemPanel;
	private JLabel lblTitle;
	private JButton btnBack;
	private JSplitPane splitPane;
	private JTextArea textAreaLeftPlatform;
	private Panel graphicPanel;
	private ChartPanel chartPanel;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public SoftwareReport() {
		///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
		setUndecorated(true);
		setBounds(100, 100, 701, 346);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		DefaultCategoryDataset data = new DefaultCategoryDataset();


		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 0, 701, 31);
		contentPanel.add(topPanel);
		
		lblClose = new JLabel("");
		lblClose.setBounds(675, 0, 26, 29);
		lblClose.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/close.png")));
		topPanel.add(lblClose);
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		
		lblTitle = new JLabel("\u00BFQu\u00E9 desea ver?");
		lblTitle.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblTitle.setBounds(12, 0, 205, 29);
		topPanel.add(lblTitle);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(220, 220, 220));
		layeredPane.setBounds(0, 32, 701, 279);
		contentPanel.add(layeredPane);
		
		startPanel = new JPanel();
		startPanel.setBackground(new Color(220, 220, 220));
		startPanel.setBounds(0, 0, 701, 279);
		layeredPane.add(startPanel);
		startPanel.setLayout(null);
		
		JPanel panelForBorder = new JPanel();
		panelForBorder.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			    btnLanguage.setIcon(languageOutIcon);
			    btnOperativeSystem.setIcon(platformIconOut);
			}
		});
		panelForBorder.setBackground(new Color(220, 220, 220));
		panelForBorder.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Selecci\u00F3n de Reporte", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelForBorder.setBounds(12, 13, 677, 253);
		startPanel.add(panelForBorder);
		panelForBorder.setLayout(null);
		
		btnOperativeSystem = new JButton("");
		btnOperativeSystem.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			    btnOperativeSystem.setIcon(platformTransitionIcon);
			}
		});
		btnOperativeSystem.setBackground(new Color(220, 220, 220));
		btnOperativeSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    lblTitle.setText("Reporte de Plataformas");
			    operativySystemPanel.setVisible(true);
			    startPanel.setVisible(false);
			    btnBack.setVisible(true);
			}
		});
		btnOperativeSystem.setBounds(30, 58, 128, 128);
		btnOperativeSystem.setIcon(platformIconOut);
		btnOperativeSystem.setBorder(emptyBorder);
		panelForBorder.add(btnOperativeSystem);
		
		JLabel lblPlatform = new JLabel("Reporte de Plataformas");
		lblPlatform.setBounds(26, 195, 137, 16);
		panelForBorder.add(lblPlatform);
		
		btnLanguage = new JButton("");
		btnLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLanguage.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			    btnLanguage.setIcon(languageTransitionIcon);
			}
		});
		btnLanguage.setBackground(new Color(220, 220, 220));
		btnLanguage.setBounds(271, 58, 128, 128);
		btnLanguage.setBorder(emptyBorder);
		btnLanguage.setIcon(languageOutIcon);
		panelForBorder.add(btnLanguage);
		
		JLabel lblLenguajeMsUtilizado = new JLabel("Lenguaje m\u00E1s utilizado");
		lblLenguajeMsUtilizado.setBounds(267, 195, 137, 16);
		panelForBorder.add(lblLenguajeMsUtilizado);
		
		operativySystemPanel = new JPanel();
		operativySystemPanel.setBounds(0, 0, 701, 279);
		layeredPane.add(operativySystemPanel);
		operativySystemPanel.setLayout(null);
		
		mostUsedSystemPanel = new JPanel();
		mostUsedSystemPanel.setBounds(0, 0, 701, 279);
		operativySystemPanel.add(mostUsedSystemPanel);
		mostUsedSystemPanel.setBackground(new Color(220, 220, 220));
		mostUsedSystemPanel.setLayout(null);
		
		splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 701, 279);
		mostUsedSystemPanel.add(splitPane);
		
		textAreaLeftPlatform = new JTextArea();
		textAreaLeftPlatform.setEditable(false);
		textAreaLeftPlatform.setText("This is the Text Area Test");
		splitPane.setLeftComponent(textAreaLeftPlatform);
		
		ArrayList<String> platforms = new ArrayList<>();
		platforms.add("Escritorio");
		platforms.add("Web");
		platforms.add("M\u00F3vil");
		final String mostRequested = "Más Solicitada";
		final String lessRequested = "Menos Solicitada";
		ReturnableGraphic mostUsedPlatform =Admin.getInstance().getMostUsedPlatform(platforms);
		ReturnableGraphic lessUsedPlatform =Admin.getInstance().getLessUsedPlatform(platforms);
		data.addValue(mostUsedPlatform.getOcurrences(),mostRequested,mostUsedPlatform.getReturnType());
		data.addValue(lessUsedPlatform.getOcurrences(),lessRequested, lessUsedPlatform.getReturnType());
		JFreeChart grafico = ChartFactory.createBarChart3D("Solicitud de las plataformas", "Plataforma", "Cantidad de Contratos", data, PlotOrientation.VERTICAL, true, true, false);
		
		graphicPanel = new Panel();
		splitPane.setRightComponent(graphicPanel);
		graphicPanel.setLayout(new GridLayout(0, 1, 0, 0));
		chartPanel = new ChartPanel(grafico);
		chartPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gr\u00E1fico", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		graphicPanel.add(chartPanel);
		super.getToolkit().getScreenSize(); 
		this.setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		////////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnExit = new JButton("Salir");
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					    dispose();
					}
				});
				
				btnBack = new JButton("Atr\u00E1s");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					    btnBack.setVisible(false);
					    operativySystemPanel.setVisible(false);
					    startPanel.setVisible(true);
					    lblTitle.setText("¿Qué desea ver?");
					   
					}
				});
				btnBack.setActionCommand("Cancel");
				buttonPane.add(btnBack);
				btnBack.setIcon(backIcon);
				btnBack.setVisible(false);
				btnExit.setActionCommand("Cancel");
				buttonPane.add(btnExit);
			}
		}
	}
}
