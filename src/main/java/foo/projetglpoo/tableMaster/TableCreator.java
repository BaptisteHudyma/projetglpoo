package foo.projetglpoo.tableMaster;

import foo.projetglpoo.drawingFunctions.drawingFunctionsClass;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Date;

public class TableCreator {
	private DefaultTableModel model;
	private JTable lotoTable;
	private JFrame Window;

	private JButton LaunchButton;
	private JComboBox dropDownMenu;

	private drawingFunctionsClass drawClass;

	public void CreateTable(JFrame MainWindow, Object[][] tableDatas) {
		Window = MainWindow;

		final String[] headTitles = { "Date", "1", "2", "3", "4", "5", "Star1", "Star2" };
		SetTableModel(tableDatas, headTitles);
		InitTableProp();
		addTableButtons();
	}

	private void addTableButtons() {
		final JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBackground(Color.GRAY);
		Window.getContentPane().add(ButtonPanel, BorderLayout.EAST);

		drawClass = new drawingFunctionsClass();
		String[] typeOfGraphicsToDrawn = drawClass.dropDownInitialisation();

		dropDownMenu = new JComboBox<>( typeOfGraphicsToDrawn );
		LaunchButton = new JButton(new LaunchGraphicGenAction());
		JButton dataVisualB = new JButton(new LaunchDataVisual());

		ButtonPanel.setLayout(new GridLayout(10,1, 0,10));
		ButtonPanel.add(dataVisualB);
		ButtonPanel.add(dropDownMenu);
		ButtonPanel.add(LaunchButton);

		LaunchButton.setEnabled(false);
		dataVisualB.setEnabled(true);
	}

	private void InitTableProp() {
		lotoTable = new JTable(model);

		Window.getContentPane().add(new JScrollPane(lotoTable));
		lotoTable.setAutoCreateRowSorter(true);
		lotoTable.getSelectionModel().addListSelectionListener(new EventListener());	//add event listener to table so it can activate and deactivate buttons
	}

	private void SetTableModel(Object[][] dataTable, String[] headTitle) {	//model for column order
		model = new DefaultTableModel(dataTable, headTitle) {
			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return Date.class;
				default:
					return int.class;
				}
			}
		};
	}

	private class LaunchGraphicGenAction extends AbstractAction {
		private LaunchGraphicGenAction() {
			super("Graphics generation");
		}

		public void actionPerformed(ActionEvent arg0) {
			DrawDataSet(getSelectedColumnsFromTab());
		}
	}
	
	private class LaunchDataVisual extends AbstractAction {
		public LaunchDataVisual() {
			super("View dataSet apparition");
		}

		public void actionPerformed(ActionEvent arg0) {
			dataVisualisation(getSelectedColumnsFromTab());
		}
	}

	private class EventListener implements ListSelectionListener {	//Button activation event
		public void valueChanged(ListSelectionEvent event) {
			if (lotoTable.getSelectedRows().length > 0)
				LaunchButton.setEnabled(true);
			else
				LaunchButton.setEnabled(false);
		}
	}

	private Object[][] getSelectedColumnsFromTab() {	//return all the selected cells
		int[] selected = lotoTable.getSelectedRows();

		Object[][] tableToSend = new Object[selected.length][8];

		for (int i = 0; i < selected.length; i++)
			for (int j = 0; j < 8; j++)
				tableToSend[i][j] = model.getValueAt(selected[i], j);

		return tableToSend;
	}

	private void DrawDataSet(Object[][] dataSet) {
		// GRAPHIC PART TO LINK
		int dropDownIndex = dropDownMenu.getSelectedIndex();
		if(drawClass.drawFunctionArray != null && dataSet != null ) {
			if (dropDownIndex >= 0 && dropDownIndex < drawClass.drawFunctionArray.length) {
				JFrame drawFrame = new JFrame("qrgdegv");
				drawFrame.setVisible(true);
				drawClass.drawFunctionArray[dropDownIndex].runDrawFunction(drawFrame, dataSet);
			}
		}
	}
	
	private void dataVisualisation(Object[][] dataSet)
	{
            //TODO : data visualisation with JTable
		JFrame drawFrame = new JFrame("A new window for data drawing");
		drawFrame.setVisible(true);
	}

}
