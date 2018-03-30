package foo.projetglpoo.tableMaster;

import java.awt.Dimension;
import javax.swing.JFrame;

public class WindowsOpener extends JFrame {
	
	private JFrame MainWindow;
	private TableCreator dataTable;
	
	
	public WindowsOpener(Dimension WindowSize)
	{
		this.setSize(WindowSize);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("EuroMillion drawer");
		//TODO : set icon
		MainWindow = this;
	}

    public void addTableToWindow( Object [][] dataSet )
	{
		dataTable = new TableCreator();
		if(dataSet == null)
			return;
		dataTable.CreateTable( MainWindow , dataSet);
	}
	
}
