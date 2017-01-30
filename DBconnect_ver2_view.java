package dbconnect;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.category.DefaultCategoryDataset; 


public class DBconnect_ver2_view extends Frame implements ActionListener,WindowListener{

	public DBconnect_ver2_view() {
		
		addWindowListener(this);
		setTitle("Graph");
		setLayout(new FlowLayout(FlowLayout.LEADING));
		
		
		int ton, year, id;
		String name;
		ResultSet rs;
		MySQL mysql = new MySQL();
		rs = mysql.selectAll();
		
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		
		try {
			while(rs.next()){
				id = rs.getInt("id");
				name = rs.getString("name");
				year = rs.getInt("year");
				ton = rs.getInt("ton");
				
				data.addValue(ton, name, String.valueOf(year));
				
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		JFreeChart chart = ChartFactory.createLineChart(
				"Import Volume",
				"Year",
				"Ton",
				data,
				PlotOrientation.VERTICAL,
				true,
				false,
				false
		);
		
        ChartPanel cpanel = new ChartPanel(chart);	
        
        add(cpanel);

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
