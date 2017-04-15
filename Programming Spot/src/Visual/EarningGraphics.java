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
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import Logico.Admin;
import Logico.Project;

public class EarningGraphics extends JDialog {

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
    private ImageIcon windowsCloseIcon =new ImageIcon(EarningGraphics.class.getResource("/icons/close.png"));
    private ImageIcon workerIcon = new ImageIcon(EarningGraphics.class.getResource("/icons/worker.png"));
    private ImageIcon contractIcon =new ImageIcon(EarningGraphics.class.getResource("/icons/contract.png"));
    private ImageIcon clientIcon = new ImageIcon(EarningGraphics.class.getResource("/icons/client.png"));
    private JPanel graphicPanel;
    private ChartPanel chartPanel;
    private JPanel selectionPanel;
    private JPanel tablePanel;
    private JScrollPane scrollPane;
    private int index = 0;
    
    private	JTable table;
	private static DefaultTableModel tableModel;
    private static Object[] row;
    
	private DefaultCategoryDataset data = new DefaultCategoryDataset();
	final String ganancias = "Ganancias";
	final String perdidas = "P\u00e9rdidas";
	private JFreeChart grafico;
    
    public EarningGraphics() {
 ///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
    setUndecorated(true);
	setBounds(100, 100, 715, 461);
	getContentPane().setLayout(new BorderLayout());
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	contentPane.setBackground(new Color(220, 220, 220));
	getContentPane().add(contentPane, BorderLayout.CENTER);
	super.getToolkit().getScreenSize(); 
	this.setResizable(false);
	setLocationRelativeTo(null);
	setModal(true);
////////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
	{
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBackground(new Color(220, 220, 220));
	    buttonPane.setBorder(new LineBorder(new Color(112, 128, 144), 2));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
	    	
		JButton btnGenerateReport = new JButton("Ver todas las ganancias");
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allEarnings();
			}
		});
		btnGenerateReport.setBackground(new Color(255, 255, 240));
		btnGenerateReport.setActionCommand("OK");
		buttonPane.add(btnGenerateReport);
		getRootPane().setDefaultButton(btnGenerateReport);
		
	    }
	    
	    	topPanel = new JPanel();
	    	topPanel.setBounds(0, 0, 715, 29);
	    	topPanel.setBorder(new LineBorder(new Color(112, 128, 144), 2));
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
		
		lblNewLabel = new JLabel("Ganancias y P\u00E9rdidas");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 1, 256, 27);
		topPanel.add(lblNewLabel);
		
		
		lblClose = new JLabel("New label");
		lblClose.setBounds(680, 1, 26, 26);
		topPanel.add(lblClose);
		lblClose.addMouseListener(new MouseAdapter() {   
			public void mouseReleased(MouseEvent e) {
			    MainVisual.getInstance().getMenuPanel().setVisible(false);
				MainVisual.getInstance().getClientsPanel().setVisible(true);
				MainVisual.getInstance().getLblIcon1().setIcon(clientIcon);
				MainVisual.getInstance().getLblIcon2().setIcon(contractIcon);
				MainVisual.getInstance().getLblIcon3().setIcon(workerIcon);
				dispose();
			}
		});
		lblClose.setIcon(windowsCloseIcon);
		
		graphicPanel = new JPanel();
		graphicPanel.setBackground(new Color(128, 128, 128));
		graphicPanel.setBounds(271, 29, 444, 397);
		contentPane.add(graphicPanel);
		graphicPanel.setLayout(null);
		

		grafico = ChartFactory.createBarChart3D("Ganancias & P\u00e9rdidas", "", "Ganancias", data, PlotOrientation.VERTICAL, true, true, false);
		chartPanel = new ChartPanel(grafico);
		chartPanel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Gr\u00E1fico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		chartPanel.setBounds(27, 11, 408, 375);
		graphicPanel.add(chartPanel);
		
		selectionPanel = new JPanel();
		selectionPanel.setBackground(new Color(128, 128, 128));
		selectionPanel.setBounds(0, 29, 274, 397);
		contentPane.add(selectionPanel);
		selectionPanel.setLayout(null);
		
		tablePanel = new JPanel();
		tablePanel.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180)), "Seleccione proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tablePanel.setBounds(10, 11, 247, 375);
		selectionPanel.add(tablePanel);
		tablePanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 227, 343);
		tablePanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table.getSelectedRow();
				updateGraph();
			}
		});
		String[] columsHeaders = {"Nombre del proyecto"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columsHeaders);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
	    
		}
	
	load();
	//fillReportField();
    }
    
	private void load() {
		tableModel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		tableModel.setRowCount(0);
		row = new Object[tableModel.getColumnCount()];
		int i = 0;
		ArrayList<Project> projects = new ArrayList<>();
		for(i = 0; i < Admin.getInstance().getContracts().size(); i++){
			if(Admin.getInstance().getContracts().get(i).getProject().getState().equals("Finalizado")){
				projects.add(Admin.getInstance().getContracts().get(i).getProject());
			}
		}
		for (int j = 0; j < projects.size(); j++){
			row[0] = projects.get(j).getName();
			tableModel.addRow(row);
		}
	}
	
	
	public void updateGraph(){
		@SuppressWarnings("deprecation")
		long time = Date.parse(Admin.getInstance().getContracts().get(index).getFinalDate());
		@SuppressWarnings("deprecation")
		long time1 = Date.parse(Admin.getInstance().getContracts().get(index).getInitialDate());
		long time2 =  time - time1;
		long date = TimeUnit.DAYS.convert(time2, TimeUnit.MILLISECONDS) / 30;
		data.addValue(Admin.getInstance().getContracts().get(index).getProject().earnings()*date, ganancias, "Ganancias");
		data.addValue(Admin.getInstance().getContracts().get(index).getLostMoney(), perdidas, "P\u00e9rdidas");
	}
	
	public void allEarnings(){
		float sum = 0f;
		float lost =  0f;
		for(int i = 0; i < Admin.getInstance().getContracts().size(); i++){
			if(Admin.getInstance().getContracts().get(i).getProject().getState().equals("Finalizado")){
				@SuppressWarnings("deprecation")
				long time = Date.parse(Admin.getInstance().getContracts().get(i).getFinalDate());
				@SuppressWarnings("deprecation")
				long time1 = Date.parse(Admin.getInstance().getContracts().get(i).getInitialDate());
				long time2 =  time - time1;
				long date = TimeUnit.DAYS.convert(time2, TimeUnit.MILLISECONDS) / 30;
				sum += Admin.getInstance().getContracts().get(i).getProject().earnings()*date;
				lost += Admin.getInstance().getContracts().get(index).getLostMoney();
			}
		}
		data.addValue(sum, ganancias, "Ganancias");
		data.addValue(lost, perdidas, "P\u00e9rdidas");
	}	
}
