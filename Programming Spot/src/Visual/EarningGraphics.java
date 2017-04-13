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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;

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
    private ImageIcon windowsCloseIcon =new ImageIcon("src/icons/close.png");
    private ImageIcon workerIcon = new ImageIcon("src/icons/worker.png");
    private ImageIcon contractIcon =new ImageIcon("src/icons/contract.png");
    private ImageIcon clientIcon = new ImageIcon("src/icons/client.png");
    private JPanel panel;
    private JPanel graphicPanel;
    private JPanel reportsPanel;
    private ChartPanel chartPanel;
    
    public EarningGraphics() {
 ///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
    setUndecorated(true);
	setBounds(100, 100, 902, 461);
	getContentPane().setLayout(new BorderLayout());
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	contentPane.setBackground(new Color(220, 220, 220));
	getContentPane().add(contentPane, BorderLayout.CENTER);
	super.getToolkit().getScreenSize(); 
	this.setResizable(false);
	setLocationRelativeTo(null);
	setModal(true);
	DefaultCategoryDataset data = new DefaultCategoryDataset();
////////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
	{
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBackground(new Color(220, 220, 220));
	    buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
	    	
		JButton btnRegister = new JButton("Registrar");
		btnRegister.setBackground(new Color(255, 255, 240));
		btnRegister.setActionCommand("OK");
		buttonPane.add(btnRegister);
		getRootPane().setDefaultButton(btnRegister);
		
	    }
	    
	    	topPanel = new JPanel();
	    	topPanel.setBounds(0, 0, 902, 29);
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
		
		lblNewLabel = new JLabel("Ganancias y P\u00E9rdidas");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 1, 256, 27);
		topPanel.add(lblNewLabel);
		
		
		lblClose = new JLabel("New label");
		lblClose.setBounds(876, 1, 26, 26);
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
		
		panel = new JPanel();
		panel.setBounds(0, 29, 351, 397);
		panel.setBackground(new Color(128, 128, 128));
		contentPane.add(panel);
		panel.setLayout(null);
		
		reportsPanel = new JPanel();
		reportsPanel.setBorder(new TitledBorder(null, "Reporte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		reportsPanel.setBounds(10, 11, 331, 375);
		panel.add(reportsPanel);
		reportsPanel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(10, 21, 311, 343);
		reportsPanel.add(textArea);
		
		graphicPanel = new JPanel();
		graphicPanel.setBackground(new Color(128, 128, 128));
		graphicPanel.setBounds(349, 29, 553, 397);
		contentPane.add(graphicPanel);
		graphicPanel.setLayout(null);
		
		final String ganancias = "Ganancias";
		final String perdidas = "P\u00e9rdidas";
		data.addValue(100, ganancias, "Dato 1");
		data.addValue(10, perdidas, "Dato 2");
		JFreeChart grafico = ChartFactory.createBarChart3D("Prueba", "Prueba", "Prueba", data, PlotOrientation.VERTICAL, true, true, false);
		chartPanel = new ChartPanel(grafico);
		chartPanel.setBorder(new TitledBorder(null, "Gr\u00E1fico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		chartPanel.setBounds(0, 11, 543, 375);
		graphicPanel.add(chartPanel);
		
		
	    {
		JButton btnCancel = new JButton("Salir");
		btnCancel.setBackground(new Color(255, 255, 240));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    dispose();
			}
		});
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);
	    }
	    
		}
    }
}
