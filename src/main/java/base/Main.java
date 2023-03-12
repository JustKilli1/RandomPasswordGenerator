package base;

import generator.GeneratorPassword;
import gui.RoundBorder;
import gui.controller.ControllerPasswordLengthChanged;
import gui.windows.MainWindow;
import gui.windows.WindowDesign;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MainWindow window = new MainWindow(design);
        new ControllerPasswordLengthChanged(window);
        window.setVisible(true);
    }

    private static WindowDesign builDesign() {
        WindowDesign design = new WindowDesign();
        design.setBackgroundColor(new Color(28, 30, 46));
        design.setBorder(new RoundBorder(new Color(47, 51, 79), 5, 5));
        design.setBackgroundComponents(new Color(47, 51, 79));
        design.setCaretColor(Color.WHITE);
        design.setHeaderColor(Color.WHITE);
        design.setTextColor(Color.WHITE);
        design.setTextFont(new Font("Cascadia Code" , Font.PLAIN, 11));
        design.setHeaderFont(new Font("Cascadia Code", Font.BOLD, 16));
        return design;
    }

}