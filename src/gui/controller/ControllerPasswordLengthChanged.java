package gui.controller;

import gui.windows.MainWindow;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
