package gui.controller;

import gui.windows.MainWindow;
import model.PasswordGeneratorModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerGeneratePassword {

    private PasswordGeneratorModel model;
    private MainWindow view;

    public ControllerGeneratePassword(PasswordGeneratorModel model, MainWindow view) {
        this.model = model;
        this.view = view;

        view.addGenerateBtnActionListener(new GeneratePasswordActionListener());
    }

    class GeneratePasswordActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String password = model.generatePassword(view.getPasswordLength(), view.getSpecialChars());
            view.setGeneratedPassword(password);
        }
    }

}
