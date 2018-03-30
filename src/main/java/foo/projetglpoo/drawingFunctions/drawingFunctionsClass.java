package foo.projetglpoo.drawingFunctions;

import javax.swing.*;

public class drawingFunctionsClass {



    public interface DrawFunction {
        void runDrawFunction(JFrame drawFrame, Object[][] dataSet);
    }

    public DrawFunction [] drawFunctionArray = null;

    public String[] dropDownInitialisation()
    {	//TODO : REMPLIR LES FONCTIONS DESSINS ICI
        drawFunctionArray = new DrawFunction[2];

        String [] typeOfGraphicsToDrawn = {"Exemple 1", "Exemple 2"};
        drawFunctionArray[0] =  new FunctionDessins1();
        drawFunctionArray[1] =  new FunctionDessins2();

        if(drawFunctionArray == null || typeOfGraphicsToDrawn == null || drawFunctionArray.length != typeOfGraphicsToDrawn.length) {
            System.err.println("Number of function in array does not match number of titles");
            System.exit(-1);
        }
        return typeOfGraphicsToDrawn;
    }


    class FunctionDessins1 implements DrawFunction
    {
        public void runDrawFunction(JFrame drawFrame, Object[][] dataSet)
        {
            System.out.println("Exemple fonctionnel 1");
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
