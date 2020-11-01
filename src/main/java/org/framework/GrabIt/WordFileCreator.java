package org.framework.GrabIt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordFileCreator 
{
	public void create(String line)throws Exception
	{
		XWPFDocument document = new XWPFDocument();
        
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        Capture capture = new Capture();
        String picName = capture.takeShot();
        System.out.println(picName);
        //run.addPicture(pic, Document.PICTURE_TYPE_JPEG, pic, Units.toEMU(400), Units.toEMU(240));
        run.addCarriageReturn();
        run.addCarriageReturn();
        run.setText(picName);
        run.addCarriageReturn();
        run.addCarriageReturn();
        
        FileOutputStream out = new FileOutputStream(
                new File(line + ".docx"));

        document.write(out);
       
        //Close document
        out.close();
	}
	
}
