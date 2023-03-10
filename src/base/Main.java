package base;

import generator.GeneratorPassword;
import gui.RoundBorder;
import gui.controller.ControllerPasswordLengthChanged;
import gui.windows.MainWindow;
import gui.windows.WindowDesign;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
/*        System.out.println("Hello world!");
        WindowDesign design = new WindowDesign();
        design.setBackgroundColor(Color.BLACK);
        design.setBorder(new RoundBorder(Color.GRAY, 5, 5));
        design.setBackgroundComponents(Color.GRAY);
        design.setCaretColor(Color.WHITE);
        design.setHeaderColor(Color.WHITE);
        design.setTextColor(Color.WHITE);
        design.setTextFont(new Font("Arial" , Font.PLAIN, 11));
        design.setHeaderFont(new Font("Arial", 0, 16));
        MainWindow window = new MainWindow(design);
        new ControllerPasswordLengthChanged(window);
        window.setVisible(true);*/

        GeneratorPassword generatorPassword = new GeneratorPassword(20, "$!/&§$%=?", 100000000);
        long before = System.currentTimeMillis();
        generatorPassword.generate();
/*        for(int i = 0; i < 10000000; i++) {
           generatorPassword.generate();
        }*/
        long after = System.currentTimeMillis();
        long timeSec = (after - before) / 1000;
        System.out.println("Execution Time: " + timeSec + " s");
    }

}