package Visual;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Logico.Admin;
import Logico.Worker;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


public class WorkerReports extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4307709260305700899L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblBirth;
	private JLabel lblBest;
	private JLabel lblStats;
	private JPanel panel;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private ImageIcon icon = new ImageIcon("src/icons/backTransition.png");
    private ImageIcon backIcon = new ImageIcon("src/icons/back.png");
	private JLabel lblBack;
	private JLabel lblCumpleaos;
	private JLabel lblEstadsticas;
	private JLabel lblNoSe;
	private JLabel lblNombres;
	private JLabel lblFechaDeCumpleaos;
	private JLabel lblDasRestantes;
	private JPanel panel_2;
	private JPanel panel_4;
	private JTable table;
	private static DefaultTableModel tableModel;
    private static Object[] row;
	private JPanel panel_3;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public WorkerReports() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblBirth.setIcon(new ImageIcon("src/icons/birthday.png"));
				lblBest.setIcon(new ImageIcon("src/icons/best.png"));
				lblStats.setIcon(new ImageIcon("src/icons/analytics.png"));
			}
		});
		///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
		setUndecorated(true);
		setBounds(100, 100, 556, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
		}
		{
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(220,220,220));
			panel_2.setVisible(false);
			panel_2.setBounds(10, 40, 536, 259);
			contentPanel.add(panel_2);
			panel_2.setLayout(null);
			
			panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Trabajadores", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_4.setBackground(new Color(220,220,220));
			panel_4.setBounds(10, 11, 253, 237);
			panel_2.add(panel_4);
			panel_4.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 24, 233, 202);
			panel_4.add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
			
			///////////////////////////////////////Lo que se debe copiar para hacer las tablas/////////////////////////////////////////////////
			String[] columnsHeaders = {"Nombre"};
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
			
			panel_3 = new JPanel();
			panel_3.setBackground(new Color(220,220,220));
			panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Gr\u00E1ficos", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel_3.setBounds(273, 11, 253, 237);
			panel_2.add(panel_3);
		}
		{
			JPanel topPanel = new JPanel();
			topPanel.setBounds(0, 0, 556, 29);
			contentPanel.add(topPanel);
			topPanel.setLayout(null);
			
			JLabel label = new JLabel("");
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					dispose();
				}
			});
			label.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/close.png")));
			label.setBounds(530, 0, 26, 29);
			topPanel.add(label);
			{
				JLabel lblTitle = new JLabel("\u00BFQu\u00E9 desea ver?");
				lblTitle.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
				lblTitle.setBounds(10, 0, 205, 29);
				topPanel.add(lblTitle);
			}
		}
		{
			lblBirth = new JLabel("aqui va un icono");
			lblBirth.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/birthday.png")));
			lblBirth.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					lblBirth.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/birthdaymouseover.png")));	
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblBirth.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/birthday.png")));
					lblBack.setVisible(true);
					panel.setVisible(true);
					disablePrincipal();
				}
			});
			lblBirth.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					lblBirth.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/birthdaymousemotion.png")));
				}
			});
			
			lblBirth.setBounds(48, 85, 97, 96);
			contentPanel.add(lblBirth);
		}
		{
			lblBest = new JLabel("aqui va otro");
			lblBest.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					lblBest.setIcon(new ImageIcon("src/icons/bestmouseover.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					panel_2.setVisible(true);
				}
			});
			lblBest.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					lblBest.setIcon(new ImageIcon("src/icons/bestmousemotion.png"));
				}
			});
			lblBest.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/best.png")));
			lblBest.setBounds(235, 85, 100, 100);
			contentPanel.add(lblBest);
		}
		{
			lblStats = new JLabel("aqui tambien");
			lblStats.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					lblStats.setIcon(new ImageIcon("src/icons/analyticsmpuseover.png"));
				}
			});
			lblStats.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					lblStats.setIcon(new ImageIcon("src/icons/analyticsmousemotion.png"));
				}
			});
			lblStats.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/analytics.png")));
			lblStats.setBounds(410, 85, 97, 108);
			contentPanel.add(lblStats);
		}
		{
			lblCumpleaos = new JLabel("Cumplea\u00F1os");
			lblCumpleaos.setBounds(55, 215, 97, 16);
			contentPanel.add(lblCumpleaos);
			lblCumpleaos.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		}
		{
			lblEstadsticas = new JLabel("Empleado del mes");
			lblEstadsticas.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
			lblEstadsticas.setBounds(215, 215, 145, 14);
			contentPanel.add(lblEstadsticas);
		}
		{
			lblNoSe = new JLabel("Estad\u00EDsticas");
			lblNoSe.setBounds(415, 215, 123, 14);
			contentPanel.add(lblNoSe);
			lblNoSe.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		}
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBounds(10, 40, 536, 259);
		contentPanel.add(panel);
		panel.setBackground(new Color(220,220,220));
		panel.setLayout(null);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(null);
			panel_1.setBackground(new Color(200,200,200));
			panel_1.setBounds(10, 108, 167, 140);
			panel.add(panel_1);
			panel_1.setLayout(null);
			{
				lbl1 = new JLabel("No disponible");
				lbl1.setHorizontalAlignment(SwingConstants.CENTER);
				lbl1.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
				lbl1.setBounds(25, 11, 109, 25);
				panel_1.add(lbl1);
			}
			{
				lbl4 = new JLabel("No disponible");
				lbl4.setHorizontalAlignment(SwingConstants.CENTER);
				lbl4.setBounds(25, 59, 109, 25);
				panel_1.add(lbl4);
				lbl4.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
			}
			{
				lbl7 = new JLabel("No disponible");
				lbl7.setHorizontalAlignment(SwingConstants.CENTER);
				lbl7.setBounds(25, 104, 109, 25);
				panel_1.add(lbl7);
				lbl7.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
			}
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(200,200,200));
			panel_1.setBounds(187, 108, 166, 140);
			panel.add(panel_1);
			panel_1.setLayout(null);
			{
				lbl5 = new JLabel("No disponible");
				lbl5.setHorizontalAlignment(SwingConstants.CENTER);
				lbl5.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
				lbl5.setBounds(24, 59, 121, 25);
				panel_1.add(lbl5);
			}
			{
				lbl2 = new JLabel("No disponible");
				lbl2.setHorizontalAlignment(SwingConstants.CENTER);
				lbl2.setBounds(24, 11, 121, 25);
				panel_1.add(lbl2);
				lbl2.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
			}
			{
				lbl8 = new JLabel("No disponible");
				lbl8.setHorizontalAlignment(SwingConstants.CENTER);
				lbl8.setBounds(24, 104, 121, 25);
				panel_1.add(lbl8);
				lbl8.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
			}
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(200,200,200));
			panel_1.setBounds(363, 108, 165, 140);
			panel.add(panel_1);
			panel_1.setLayout(null);
			{
				lbl3 = new JLabel("No disponible");
				lbl3.setHorizontalAlignment(SwingConstants.CENTER);
				lbl3.setBounds(28, 11, 113, 25);
				panel_1.add(lbl3);
				lbl3.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
			}
			{
				lbl6 = new JLabel("No disponible");
				lbl6.setHorizontalAlignment(SwingConstants.CENTER);
				lbl6.setBounds(28, 57, 113, 25);
				panel_1.add(lbl6);
				lbl6.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
			}
			{
				lbl9 = new JLabel("No disponible");
				lbl9.setBounds(28, 104, 113, 25);
				panel_1.add(lbl9);
				lbl9.setHorizontalAlignment(SwingConstants.CENTER);
				lbl9.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
			}
		}
		{
			JLabel lblCumpleaosPrximos = new JLabel("Cumplea\u00F1os pr\u00F3ximos");
			lblCumpleaosPrximos.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
			lblCumpleaosPrximos.setBounds(175, 21, 178, 27);
			panel.add(lblCumpleaosPrximos);
		}
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/vectores globos fiesta 5_opt (1).png")));
			lblNewLabel.setBounds(70, 0, 50, 71);
			panel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/vectores globos fiesta 5_opt (1).png")));
			lblNewLabel_1.setBounds(414, 0, 50, 71);
			panel.add(lblNewLabel_1);
		}
		{
			lblBack = new JLabel("");
			lblBack.setBounds(0, 0, 24, 29);
			panel.add(lblBack);
			lblBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					lblBack.setIcon(icon);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
			        lblBack.setIcon(backIcon);
			        panel.setVisible(false);
			        activePrincipal();
				}
			});
			lblBack.setVisible(false);
			lblBack.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/back.png")));
			lblBack.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
			lblBack.setHorizontalAlignment(SwingConstants.LEFT);
		}
		{
			lblNombres = new JLabel("Nombres");
			lblNombres.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
			lblNombres.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombres.setForeground(new Color(0, 0, 0));
			lblNombres.setBackground(new Color(240, 255, 240));
			lblNombres.setBounds(35, 70, 118, 27);
			panel.add(lblNombres);
		}
		{
			lblFechaDeCumpleaos = new JLabel("Fecha de Cumplea\u00F1os");
			lblFechaDeCumpleaos.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
			lblFechaDeCumpleaos.setHorizontalAlignment(SwingConstants.CENTER);
			lblFechaDeCumpleaos.setForeground(Color.BLACK);
			lblFechaDeCumpleaos.setBackground(new Color(240, 255, 240));
			lblFechaDeCumpleaos.setBounds(175, 70, 178, 27);
			panel.add(lblFechaDeCumpleaos);
		}
		{
			lblDasRestantes = new JLabel("D\u00EDas restantes");
			lblDasRestantes.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
			lblDasRestantes.setHorizontalAlignment(SwingConstants.CENTER);
			lblDasRestantes.setForeground(Color.BLACK);
			lblDasRestantes.setBackground(new Color(240, 255, 240));
			lblDasRestantes.setBounds(372, 70, 138, 27);
			panel.add(lblDasRestantes);
		}
		super.getToolkit().getScreenSize(); 
		this.setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setReminderDays();
		setWorkers();
	}
	private void setReminderDays() {
		for (Worker i: Admin.getInstance().getWorkers()) {
			Date today = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String aux1 = format.format(today);
			String[] separateDate = aux1.split("/");
			String[] separate = i.getBirthday().split("/");
			String a = separate[0]+"/"+separate[1]+"/"+separateDate[2];
			@SuppressWarnings("deprecation")
			long time = Date.parse(a);
			@SuppressWarnings("deprecation")
			long timeToday = Date.parse(aux1);
			long aux2 = time - timeToday;
			long days = TimeUnit.DAYS.convert(aux2, TimeUnit.MILLISECONDS);
			i.setDaysLeft(days/30);
		}
	}
	private void setWorkers() {
		Collections.sort(Admin.getInstance().getWorkers(), new DaysComparator());
		ArrayList<Worker> workers = new ArrayList<>();
        for (Worker i: Admin.getInstance().getWorkers()) {
        	if (i.getDaysLeft()>0)
        		workers.add(i);
        }
		if (workers.size()>=1) {
			lbl1.setText(workers.get(0).getFirstName()+" "+workers.get(0).getLastName());
			lbl2.setText(workers.get(0).getBirthday());
			lbl3.setText(String.valueOf(workers.get(0).getDaysLeft()));
		}
		if (workers.size()>=2) {
			lbl4.setText(workers.get(1).getFirstName()+" "+workers.get(1).getLastName());
			lbl5.setText(workers.get(1).getBirthday());
			lbl6.setText(String.valueOf(workers.get(1).getDaysLeft()));
		}
		if (workers.size()>=3) {
			lbl7.setText(workers.get(2).getFirstName()+" "+workers.get(2).getLastName());
			lbl8.setText(workers.get(2).getBirthday());
			lbl9.setText(String.valueOf(workers.get(2).getDaysLeft()));
		}
	}
	private void disablePrincipal() {
		lblBest.setVisible(false);
		lblBirth.setVisible(false);
		lblStats.setVisible(false);
		lblCumpleaos.setVisible(false);
		lblNoSe.setVisible(false);
		lblEstadsticas.setVisible(false);
		lblBack.setVisible(true);
	}
	private void activePrincipal() {
		lblBest.setVisible(true);
		lblBirth.setVisible(true);
		lblStats.setVisible(true);
		lblCumpleaos.setVisible(true);
		lblNoSe.setVisible(true);
		lblEstadsticas.setVisible(true);
		lblBack.setVisible(false);
	}
	public void loadContracts() {
	   	tableModel.setRowCount(0);
	   	DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	   	tcr.setHorizontalAlignment(SwingConstants.CENTER);
	   	table.getColumnModel().getColumn(0).setCellRenderer(tcr);
	   	row = new Object[tableModel.getColumnCount()];
	   	for (Worker i: Admin.getInstance().getWorkers()) {
	   	    row[0]=i.getFirstName() +" "+ i.getLastName();
	   	    tableModel.addRow(row);
	   	}
	}
}
