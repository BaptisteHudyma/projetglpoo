package foo.projetglpoo.tableMaster;

import javax.swing.*;
import java.awt.*;

public class WindowsOpener extends JFrame {
    private JFrame MainWindow;
    private TableCreator dataTable;

    public WindowsOpener(Dimension WindowSize) {
        this.setSize(WindowSize);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Euromillion drawer");

        MainWindow = this;
    }

    public void addTableToWindow(Object[][] dataSet) {
        dataTable = new TableCreator();
        if (dataSet == null) {
            return;
        }
        dataTable.CreateTable(MainWindow, dataSet);
    }
}