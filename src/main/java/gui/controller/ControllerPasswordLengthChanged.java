package gui.controller;

import gui.windows.MainWindow;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Controller that's responsible for the Change of the Password Length<br>
 *<br>
 * Linked Views:<br>
 * - {@link MainWindow} --> Contains the Password Length<br>
 *<br>
 * Required Models:<br>
 * */
public class ControllerPasswordLengthChanged {

    private MainWindow view;

    public ControllerPasswordLengthChanged(MainWindow view) {
        this.view = view;

        view.addPasswordLengthChangeListener(new SliderChangeEvent());
    }

    /**
     * Listener Class that's responsible for dealing with the SliderChangeEvent that occurs in the MainWindow.
     * */
    class SliderChangeEvent implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent event) {
            view.updatePasswordLengthDesc();
        }
    }
}
