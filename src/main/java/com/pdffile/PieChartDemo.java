package com.pdffile;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PieChartDemo {


	
	public  JFreeChart generatePieChart() {
	DefaultPieDataset dataSet = new DefaultPieDataset();
	   
	    dataSet.setValue("China", 19);
		dataSet.setValue("India", 17);
		dataSet.setValue("United States", 10);
		dataSet.setValue("Indonesia", 20);
		dataSet.setValue("Brazil", 3);
              
                 JFreeChart chart = ChartFactory.createPieChart(
				"World Population by countries", dataSet, true, true, false);
                 PiePlot3D plot = (PiePlot3D) chart.getPlot();
                 plot.setBackgroundPaint(new Color(255, 255, 255, 0));
                 plot.setSectionPaint("1", new Color(31, 73, 125));
                 plot.setSectionPaint("2", new Color(192, 80, 77));
                 plot.setSectionPaint("3", new Color(155, 187, 89));
                 plot.setSectionPaint("4", new Color(128, 100, 162));

		return chart;
	}
}