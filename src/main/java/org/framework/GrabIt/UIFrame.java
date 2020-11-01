package org.framework.GrabIt;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import oracle.jrockit.jfr.JFR;

public class UIFrame {
	
	int clickCount=0;
	boolean fileWasOpened = false;
	File fileToSave=null;
	XWPFDocument docx;
	XWPFRun run;
	FileOutputStream out;
	JFrame jFrame;
	public void createFrame()
	{
		jFrame = new JFrame();

		jFrame.setUndecorated(true);
		jFrame.setOpacity(0.6f);
		jFrame.setVisible(true);
		jFrame.setSize(200, 100);
		jFrame.setAlwaysOnTop(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
	    Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
	    int x = 0;
	    int y = (int) rect.getMaxY() - jFrame.getHeight();
	    jFrame.setLocation(x, y);
		JPanel panel = new JPanel(new GridLayout(1, 3));
		
		JButton Open = new JButton("Open");
		JButton Click = new JButton("Click");
		JButton Close = new JButton("Close");
		
		panel.add(Open);
		panel.add(Click);
		panel.add(Close);
		
		jFrame.add(panel);
		jFrame.pack();
		
		Open.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				openActions();
			}
		});
		
		Click.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				clickActions();
				
			}

		});
		
		Close.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				closeActions();
			}
		});
	}
	

	public void openActions() {
		clickCount=0;
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Specify a file to save");
		chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
		
		int userSelection = chooser.showSaveDialog(jFrame);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			fileWasOpened=true;
		    fileToSave = chooser.getSelectedFile();
		    try {
		    	docx = new XWPFDocument();
	            run = docx.createParagraph().createRun();
	            out = new FileOutputStream(fileToSave+".docx");

		    }catch(Exception e3) {}
		}
	}
	
	public void clickActions() {
		clickCount=0;
		try {
			TakeScreenShots.captureScreenShot(docx, run, out);
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void closeActions() {
		clickCount++;
		if(clickCount>1 || fileWasOpened==false) {
			System.exit(0);
		}else {
			try {
				docx.write(out);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            try {
				out.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            try {
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            try {
				docx.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	
	}
}
