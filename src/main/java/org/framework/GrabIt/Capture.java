package org.framework.GrabIt;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Capture {
	public String takeShot() throws AWTException, IOException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		String imgName = "C:\\Users\\Admin\\Desktop\\drive.jpg";
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "jpg", new File(imgName));
		
		return imgName;
	}
	
	public void readFile()
	{
		
	}
}
