package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClosingDialog extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private int i=1;
    private JProgressBar pBar;
    private javax.swing.Timer t;
    /**
     * Launch the application.
     */
    /**
     * Create the dialog.
     */
    public ClosingDialog() {
    	addWindowListener(new WindowAdapter() {
    		@Override
    		public void windowOpened(WindowEvent e) {
    		    t.start();
    		}
    	});
    	setUndecorated(true);
	setBounds(100, 100, 437, 133);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBackground(new Color(192, 192, 192));
	contentPanel.setBorder(new LineBorder(new Color(70, 130, 180), 4));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);
	setModal(true);
	setLocationRelativeTo(null);
	ActionListener al =new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		  if(pBar.getValue()<100){
		      pBar.setValue(pBar.getValue()+5);
		  }else{
		      t.stop();
		      dispose();
		      System.exit(0);
		  }
	}};
	
	 t = new javax.swing.Timer(25, (ActionListener) al);
	
	pBar = new JProgressBar();
	pBar.setStringPainted(true);
	pBar.setForeground(new Color(144, 238, 144));
	pBar.setBounds(30, 44, 377, 45);
	contentPanel.add(pBar);
	
	JLabel lblGuardandoDatos = new JLabel("Guardando Datos");
	lblGuardandoDatos.setForeground(new Color(0, 128, 128));
	lblGuardandoDatos.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblGuardandoDatos.setBounds(169, 15, 136, 16);
	contentPanel.add(lblGuardandoDatos);
	pBar.addChangeListener(new ChangeListener() {

	            @Override
	            public void stateChanged(ChangeEvent e)
	            {
	                if(pBar.getValue() == 100)
	                {
	                   
	                }
	            }
	        });
	
    }

   /* public void run() {
	
        try {
	    Thread.sleep(10);
	} catch (InterruptedException e) {
	    
	}
        pBar.setValue(i);
        pBar.repaint();
        i++;
    
    }*/
    
    
}
