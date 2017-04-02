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

public class RegisterClient extends JDialog {

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
    
    public RegisterClient() {
    	setUndecorated(true);
	setBounds(100, 100, 1050, 597);
	getContentPane().setLayout(new BorderLayout());
	contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	contentPane.setBackground(new Color(128, 128, 128));
	getContentPane().add(contentPane, BorderLayout.CENTER);
	super.getToolkit().getScreenSize(); 
	this.setResizable(false);
	setLocationRelativeTo(null);
	setModal(true);
	{
	    
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    getContentPane().add(buttonPane, BorderLayout.SOUTH);
	    {
		JButton btnRegister = new JButton("OK");
		btnRegister.setActionCommand("OK");
		buttonPane.add(btnRegister);
		getRootPane().setDefaultButton(btnRegister);
	    }
	    
	    	topPanel = new JPanel();
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
		topPanel.setBounds(0, 0, 1051, 29);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Registrar Cliente");
		lblNewLabel.setFont(new Font("Century Schoolbook", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 1, 141, 27);
		topPanel.add(lblNewLabel);
		
		
		lblClose = new JLabel("New label");
		lblClose.setBounds(1025, 3, 26, 26);
		topPanel.add(lblClose);
		lblClose.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		lblClose.setIcon(windowsCloseIcon);
	    
	    
	    {
		JButton btnCancel = new JButton("Transicion");
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
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);
	    }
	}
    }

}
