package Visual;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.ImageIcon;


public class TrayIconDemo {	
	    public void displayTray() throws AWTException, java.net.MalformedURLException {
	        //Obtain only one instance of the SystemTray object
	        SystemTray tray = SystemTray.getSystemTray();

	        //If the icon is a file
	  
	        ImageIcon imageIcon = new ImageIcon(TrayIcon.class.getResource("/icons/trayIcon.png"));
	        TrayIcon trayIcon = new TrayIcon(imageIcon.getImage(), "Advertencia");
	        trayIcon.setImageAutoSize(true);
	        //Set tooltip text for the tray icon
	        trayIcon.setToolTip("Hay contratos que pueden vencer dentro de los proximos siete dias.");
	        tray.add(trayIcon);
	        trayIcon.displayMessage("Contratos Próximos a Vencer", "Advertencia", MessageType.INFO);
	        MouseListener listener = new MouseListener() {
		    
		    @Override
		    public void mouseReleased(MouseEvent e) {
			ListContract listContract;
			try {
			    listContract = new ListContract();
			    listContract.setVisible(true);
			} catch (ParseException e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
			}
			
		    }

		    @Override
		    public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		    }

		    @Override
		    public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		    }

		    @Override
		    public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		    }
		    
		
		};
	  
		trayIcon.addMouseListener(listener);
	    }
}
