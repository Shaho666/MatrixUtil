package com.example.matrixui.uiframe;

import java.awt.Image;
import java.awt.Point;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.example.matrixui.pageswitch.Page;
import com.example.matrixui.uimplement.ReadT;

public class RootPage {
	
	protected static Properties properties = PropertiesInterface.getProperties();
	
	protected static final String CALL = properties.getProperty("CALL");
	protected static final String CRESULT = properties.getProperty("CRESULT");
	protected static final String INPUT = properties.getProperty("INPUT");
	
	protected ReadT readT = null;
	
	protected Page page = null;
	
	protected JFrame frame = null;

	protected JFrameInterface frameInterface = null;

	protected Point at = null;

	protected JComboBox<String> comboBox = null;

	protected Map<String, String> terms = null;
	
	protected String path = null;

	public JFrame getFrame() {
		return frame;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public RootPage() {
		initialize();
	}

	static{
		try {
			
			UIManager.setLookAndFeel(new org.jvnet.substance.skin.SubstanceDustCoffeeLookAndFeel());  

	        JFrame.setDefaultLookAndFeelDecorated(true);  

	        JDialog.setDefaultLookAndFeelDecorated(true);
			
		} catch (Exception e) {
			
		}
	}
	
	protected void jump(String selected){
		
		Map<String, String> allitem = null;

		try {
			
			allitem = HashMapItem.getItems();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		for (Entry<String, String> entry : allitem.entrySet()) {
			
			if (selected.equals(entry.getValue())) {
				page = PageInstanceInterface.getPage(entry.getKey());
				break;
			}

		}

		page.switchpage(at, selected);
	}
	
	private void initialize() {
		
		try {
			
			frameInterface = new JFrameInterface();
			frame = frameInterface.getFrame(null);
			comboBox = frameInterface.getFunctions();
			readT = new ReadT();
			
			path = properties.getProperty("PATH");
			
			Image img = ImageIO.read(this.getClass().getResource(path));
			this.frame.setIconImage(img);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
