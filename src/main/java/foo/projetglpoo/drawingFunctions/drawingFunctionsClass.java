package foo.projetglpoo.drawingFunctions;

import javax.swing.*;
import foo.projetglpoo.drawingFunctions.fourier.*;

public class drawingFunctionsClass {



    public interface DrawFunction {
        void runDrawFunction(JFrame drawFrame, Object[][] dataSet);
    }

    public DrawFunction [] drawFunctionArray = null;

    public String[] dropDownInitialisation()
    {	//TODO : REMPLIR LES FONCTIONS DESSINS ICI
        drawFunctionArray = new DrawFunction[2];

        String [] typeOfGraphicsToDrawn = {"Fourier", "Exemple 2"};
        drawFunctionArray[0] =  new CallFourier();
        drawFunctionArray[1] =  new FunctionDessins2();

        if(drawFunctionArray == null || typeOfGraphicsToDrawn == null || drawFunctionArray.length != typeOfGraphicsToDrawn.length) {
            System.err.println("Number of function in array does not match number of titles");
            System.exit(-1);
        }
        return typeOfGraphicsToDrawn;
    }


    class CallFourier implements DrawFunction
    {
        public void runDrawFunction(JFrame drawFrame, Object[][] dataSet)
        {
            System.out.println("Drawing dataSet as a Fourier Series");
            Fourier.start(drawFrame, dataSet);
        }
    }

    class FunctionDessins2 implements DrawFunction
    {
        public void runDrawFunction(JFrame drawFrame, Object[][] dataSet)
        {
            System.out.println("Exemple fonctionnel 2");
        }
    }



}
