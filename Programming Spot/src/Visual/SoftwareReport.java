package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class SoftwareReport extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7095664060161443355L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public SoftwareReport() {
		///////////////////////////////////////////////Base form of every window (copy for each new window)//////////////////////////////////////
		setUndecorated(true);
		setBounds(100, 100, 556, 461);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setBackground(new Color(220, 220, 220));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 0, 556, 29);
		contentPanel.add(topPanel);
		
		JLabel label = new JLabel("");
		label.setBounds(530, 0, 26, 29);
		label.setIcon(new ImageIcon(WorkerReports.class.getResource("/icons/close.png")));
		topPanel.add(label);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		
		JLabel label_1 = new JLabel("\u00BFQu\u00E9 desea ver?");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_1.setBounds(10, 0, 205, 29);
		topPanel.add(label_1);
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
