package com.pdffile;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.FileOutputStream;

import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

@SpringBootApplication
public class PdfFilegenerationApplication {
    @Autowired
	static PieChartDemo piechart;
	 
    public static void main(String[] args) {
		SpringApplication.run(PdfFilegenerationApplication.class, args);
  
		try {
	//		writeChartToPDF(piechart.generateBarChart(), 400, 400,"/home/sanjay/Desktop/PdfFile/barchart.pdf");
		
			writeChartToPDF(piechart.generatePieChart(), 250, 250,"/home/sanjay/Desktop/PdfFile/pieChart.pdf");
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writeChartToPDF(JFreeChart chart, int width, int height, String fileName) {
		PdfWriter writer = null;
		Document document = new Document();
		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(
					fileName));
			document.open();
			PdfContentByte contentByte = writer.getDirectContent();
			
			PdfTemplate template = contentByte.createTemplate(width, height);
			
			Graphics2D graphics2d = template.createGraphics(width,height,
			
					new DefaultFontMapper());
		
			Rectangle2D rectangle2d = new Rectangle2D.Double(0,0,width,
					height);

			chart.draw(graphics2d, rectangle2d);
			
			graphics2d.dispose();
			
			contentByte.addTemplate(template,150,150);

		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
	}

}
