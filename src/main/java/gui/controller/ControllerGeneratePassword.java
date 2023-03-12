package gui.controller;

import gui.windows.MainWindow;
import model.PasswordGeneratorModel;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller that's responsible for Generating a new Random Password<br>
 *<br>
 * Linked Views:<br>
 * - {@link MainWindow} --> Contains the Password Length and the SpecialChars needed for the Password Generation<br>
 *<br>
 * Required Models:<br>
 * - {@link PasswordGeneratorModel} --> Generates a new Random Password<br>
 * */
public class ControllerGeneratePassword {

    private PasswordGeneratorModel model;
    private MainWindow view;

    public ControllerGeneratePassword(PasswordGeneratorModel model, MainWindow view) {
        this.model = model;
        this.view = view;

        view.addGenerateBtnActionListener(new GeneratePasswordActionListener());
    }

    /**
     * ActionListener that generates a new Password and display it in the View
     * */
    class GeneratePasswordActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String password = model.generatePassword(view.getPasswordLength(), view.getSpecialChars());
            view.setGeneratedPassword(password);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(password), null);
        }
    }

}
