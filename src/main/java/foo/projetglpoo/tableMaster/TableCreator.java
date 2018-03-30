package foo.projetglpoo.tableMaster;

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

    public void CreateTable(JFrame MainWindow, Object[][] tableDatas) {
        Window = MainWindow;

        final String[] enTetes = {"Date", "1", "2", "3", "4", "5", "Star1", "Star2"};
        SetTableModel(tableDatas, enTetes);
        InitTableProp();
        addTableButtons();
    }

    void addTableButtons() {
        final JPanel ButtonPanel = new JPanel();
        ButtonPanel.setBackground(Color.GRAY);
        Window.getContentPane().add(ButtonPanel, BorderLayout.SOUTH);

        LaunchButton = new JButton(new LaunchGraphicGenAction());
        ButtonPanel.add(LaunchButton);

        JButton datavisualB = new JButton(new LaunchDataVisual());
        ButtonPanel.add(datavisualB);

        LaunchButton.setEnabled(false);
        datavisualB.setEnabled(true);
    }

    void InitTableProp() {
        lotoTable = new JTable(model);

        Window.getContentPane().add(new JScrollPane(lotoTable));
        lotoTable.setAutoCreateRowSorter(true);
        lotoTable.getSelectionModel().addListSelectionListener(new EventListener());    //add event listener to table so it can activate and deactivate buttons
    }

    void SetTableModel(Object[][] tableDatas, String[] enTetes) {    //model for column order
        model = new DefaultTableModel(tableDatas, enTetes) {
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

    Object[][] getSelectedColumnsFromTab() {    //get all the selected cells
        int[] selected = lotoTable.getSelectedRows();

        Object[][] tableToSend = new Object[selected.length][8];

        for (int i = 0; i < selected.length; i++)
            for (int j = 0; j < 8; j++)
                tableToSend[i][j] = model.getValueAt(selected[i], j);

        return tableToSend;
    }

    void DrawDataSet(JFrame drawnWindow, Object[][] dataSet) {
        // GRAPHIC PART TO LINK
    }

    void dataVisualisation(JFrame drawnWindow, Object[][] dataSet) {
        //TODO : data visualisation with JTable
    }

    private class LaunchGraphicGenAction extends AbstractAction {
        public LaunchGraphicGenAction() {
            super("Graphics generation");
        }

        public void actionPerformed(ActionEvent arg0) {
            JFrame drawframe = new JFrame("A new window for data drawing");
            drawframe.setVisible(true);

            DrawDataSet(drawframe, getSelectedColumnsFromTab());
        }
    }

    private class LaunchDataVisual extends AbstractAction {
        public LaunchDataVisual() {
            super("View dataset apparition");
        }

        public void actionPerformed(ActionEvent arg0) {
            JFrame drawframe = new JFrame("A new window for data visual");
            drawframe.setVisible(true);

            dataVisualisation(drawframe, getSelectedColumnsFromTab());
        }
    }

    private class EventListener implements ListSelectionListener {    //Button ativation event
        public void valueChanged(ListSelectionEvent event) {
            if (lotoTable.getSelectedRows().length > 0) {
                LaunchButton.setEnabled(true);
            } else {
                LaunchButton.setEnabled(false);
            }
        }
    }
}
