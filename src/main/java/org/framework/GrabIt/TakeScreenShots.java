package org.framework.GrabIt;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class TakeScreenShots {

	public static void captureScreenShot(XWPFDocument docx, XWPFRun run, FileOutputStream out) throws Exception {

        String screenshot_name = System.currentTimeMillis() + ".jpg";
        BufferedImage image = new Robot()
                .createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        File file = new File("C:/Users/"+ System.getProperty("user.name")+"/Pictures/" + screenshot_name);
        ImageIO.write(image, "jpg", file);
        InputStream pic = new FileInputStream("C:/Users/"+ System.getProperty("user.name")+"/Pictures/" + screenshot_name);
        run.addBreak();
        run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, screenshot_name, Units.toEMU(430), Units.toEMU(250));
        run.addCarriageReturn();
        run.addCarriageReturn();
        pic.close();
        file.delete();
    }

}
