package foo.projetglpoo;

import foo.projetglpoo.dao.EuroMillionsDAO;
import foo.projetglpoo.dao.EuroMillionsResult;
import foo.projetglpoo.dao.random.RandomDAO;
import foo.projetglpoo.tableMaster.WindowsOpener;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger log = Logger.getLogger(Launcher.class);

        EuroMillionsDAO api = new RandomDAO();
        List<EuroMillionsResult> results = api.getResults();
        for (EuroMillionsResult result : results) {
            log.debug("result:");
            log.debug(result.getDate());
            log.debug(Arrays.toString(result.getNumbers()));
            log.debug(Arrays.toString(result.getStars()));
        }

        LaunchWindow(results);
    }

    public static void LaunchWindow(List<EuroMillionsResult> results) {
        Object[][] dataSet = new Object[results.size()][8];

        int Cmpt = 0;
        for (EuroMillionsResult result : results) {
            dataSet[Cmpt][0] = result.getDate();

            int[] Numbers = result.getNumbers();
            for (int i = 0; i < 5; i++)
                dataSet[Cmpt][i + 1] = Numbers[i];

            int[] Stars = result.getStars();
            for (int i = 0; i < 2; i++)
                dataSet[Cmpt][i + 6] = Stars[i];
            Cmpt++;
        }

        Dimension WindowDimension = new Dimension();
        WindowDimension.setSize(800, 800);

        WindowsOpener MainWindow = new WindowsOpener(WindowDimension);
        MainWindow.addTableToWindow(dataSet);

        //MainWindow.pack();
        MainWindow.setVisible(true);
    }
}