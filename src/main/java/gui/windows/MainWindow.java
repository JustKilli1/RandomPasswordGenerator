package gui.windows;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private WindowDesign design;

    private JPanel pnlMain, pnlPasswordView, pnlPasswordLength, pnlSpecialCharacter;
    private JTextField tfPasswordView, tfSpecialChars;
    private JButton cmdGenerate;
    private JSlider sPasswordLength;
    private JLabel lblPasswordLengthDesc, lblSpecialCharsDesc, lblPaswordViewDesc;

    public MainWindow(WindowDesign design) throws HeadlessException {
        super("Password Generator");
        this.design = design;
        init();
        build();
    }

    /**
     * Sets some Default Window Values
     * */
    private void init() {
        setSize(500, 350);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Build the Window and all necessary Components that are needed to secure the base functionality of the window.
     * */
    private void build() {
        pnlMain = new JPanel(new GridLayout(4, 1, 10, 20));

        buildPasswordView();
        buildPasswordOptions();
        design(design);

        add(pnlMain);
    }
    /**
     * Builds the Password View Components.
     * */
    private void buildPasswordView() {
        lblPaswordViewDesc = new JLabel("Password");
        lblPaswordViewDesc.setVerticalAlignment(SwingConstants.BOTTOM);

        tfPasswordView = new JTextField();
        tfPasswordView.setEditable(false);

        pnlPasswordView = new JPanel(new BorderLayout(0, 5));
        pnlPasswordView.add(lblPaswordViewDesc, BorderLayout.NORTH);
        pnlPasswordView.add(tfPasswordView, BorderLayout.CENTER);

        pnlMain.add(pnlPasswordView);
    }

    /**
     * Builds the Password Options Components.
     * */
    private void buildPasswordOptions() {
        lblPasswordLengthDesc = new JLabel();
        lblPasswordLengthDesc.setVerticalAlignment(SwingConstants.BOTTOM);
        updatePasswordLengthDesc(20);
        sPasswordLength = new JSlider(1, 200, 20);

        lblSpecialCharsDesc = new JLabel("Special Character");
        lblSpecialCharsDesc.setVerticalAlignment(SwingConstants.BOTTOM);
        tfSpecialChars = new JTextField();
        tfSpecialChars.setText("!\"§$%&/()=?`{[]}\\+*#',;.:-_<>|");

        cmdGenerate = new JButton("Generate");

        pnlPasswordLength = new JPanel(new BorderLayout(0, 5));
        pnlPasswordLength.add(lblPasswordLengthDesc, BorderLayout.CENTER);
        pnlPasswordLength.add(sPasswordLength, BorderLayout.SOUTH);

        pnlSpecialCharacter = new JPanel(new BorderLayout(0, 5));
        pnlSpecialCharacter.add(lblSpecialCharsDesc, BorderLayout.CENTER);
        pnlSpecialCharacter.add(tfSpecialChars, BorderLayout.SOUTH);

        pnlMain.add(pnlPasswordLength);
        pnlMain.add(pnlSpecialCharacter);
        pnlMain.add(cmdGenerate);
    }

    public void design(WindowDesign design) {

        pnlMain.setBackground(design.getBackgroundColor());
        pnlMain.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        //Password View Component Design
        lblPaswordViewDesc.setFont(design.getTextFont());
        lblPaswordViewDesc.setForeground(design.getTextColor());
        lblPaswordViewDesc.setBackground(design.getBackgroundComponents());

        tfPasswordView.setBackground(design.getBackgroundComponents());
        tfPasswordView.setForeground(design.getTextColor());
        tfPasswordView.setFont(design.getTextFont());
        tfPasswordView.setCaretColor(design.getCaretColor());
        tfPasswordView.setBorder(design.getBorder());

        pnlPasswordView.setBackground(design.getBackgroundColor());

        //Password Options Component Design
        lblPasswordLengthDesc.setFont(design.getTextFont());
        lblPasswordLengthDesc.setForeground(design.getTextColor());
        lblPasswordLengthDesc.setBackground(design.getBackgroundComponents());

        sPasswordLength.setBackground(design.getBackgroundComponents());
        sPasswordLength.setForeground(design.getTextColor());
        sPasswordLength.setBorder(design.getBorder());

        lblSpecialCharsDesc.setFont(design.getTextFont());
        lblSpecialCharsDesc.setForeground(design.getTextColor());
        lblSpecialCharsDesc.setBackground(design.getBackgroundComponents());

        tfSpecialChars.setBackground(design.getBackgroundComponents());
        tfSpecialChars.setForeground(design.getTextColor());
        tfSpecialChars.setFont(design.getTextFont());
        tfSpecialChars.setCaretColor(design.getCaretColor());
        tfSpecialChars.setBorder(design.getBorder());

        cmdGenerate.setBackground(design.getBackgroundComponents());
        cmdGenerate.setForeground(design.getTextColor());
        cmdGenerate.setBorder(design.getBorder());
        cmdGenerate.setFont(design.getHeaderFont());

        pnlPasswordLength.setBackground(design.getBackgroundColor());
        pnlSpecialCharacter.setBackground(design.getBackgroundColor());
    }

    public void addPasswordLengthChangeListener(ChangeListener listener) {
        sPasswordLength.addChangeListener(listener);
    }

    /**
    * Updates the Value of the Label {@code lblPasswordLengthDesc}.
     * This Label displays the current selected Password Length.
     * @param newValue The new Selected Password Length
    * */
    public void updatePasswordLengthDesc(int newValue) {
        lblPasswordLengthDesc.setText("Password Length: " + newValue + " Characters");
    }
    public void updatePasswordLengthDesc() {
        updatePasswordLengthDesc(getPasswordLength());
    }

    public int getPasswordLength() { return sPasswordLength.getValue(); }

    public String getSpecialChars() { return tfSpecialChars.getText(); }

    public void addGenerateBtnActionListener(ActionListener listener) { cmdGenerate.addActionListener(listener); }

    public void setGeneratedPassword(String password) {
        tfPasswordView.setText(password);
    }

}
