package gui.windows;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private WindowDesign design;

    private JPanel pnlMain;
    private JTextField tfPasswordView, tfSpecialChars;
    private JButton cmdGenerate;
    private JSlider sPasswordLength;
    private JLabel lblPasswordLengthDesc;

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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Build the Window and all necessary Components that are needed to secure the base functionality of the window.
     * */
    private void build() {
        pnlMain = new JPanel(new GridLayout(4, 1, 10, 20));
        pnlMain.setBackground(design.getBackgroundColor());
        pnlMain.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        buildPasswordView();
        buildPasswordOptions();

        add(pnlMain);
    }
    /**
     * Builds the Password View Components.
     * */
    private void buildPasswordView() {

        JLabel lblPWDesc = new JLabel("Password");
        lblPWDesc.setFont(design.getTextFont());
        lblPWDesc.setForeground(design.getTextColor());
        lblPWDesc.setBackground(design.getBackgroundComponents());
        lblPWDesc.setVerticalAlignment(SwingConstants.BOTTOM);

        tfPasswordView = new JTextField();
        tfPasswordView.setBackground(design.getBackgroundComponents());
        tfPasswordView.setForeground(design.getTextColor());
        tfPasswordView.setFont(design.getTextFont());
        tfPasswordView.setCaretColor(design.getCaretColor());
        tfPasswordView.setBorder(design.getBorder());
        tfPasswordView.setEditable(false);

        JPanel pnlPV = new JPanel(new BorderLayout(0, 5));
        pnlPV.add(lblPWDesc, BorderLayout.NORTH);
        pnlPV.add(tfPasswordView, BorderLayout.CENTER);
        pnlPV.setBackground(design.getBackgroundColor());

        pnlMain.add(pnlPV);
    }

    /**
     * Builds the Password Options Components.
     * */
    private void buildPasswordOptions() {

        lblPasswordLengthDesc = new JLabel();
        lblPasswordLengthDesc.setFont(design.getTextFont());
        lblPasswordLengthDesc.setForeground(design.getTextColor());
        lblPasswordLengthDesc.setBackground(design.getBackgroundComponents());
        lblPasswordLengthDesc.setVerticalAlignment(SwingConstants.BOTTOM);
        updatePasswordLengthDesc(20);

        sPasswordLength = new JSlider(1, 200, 20);
        sPasswordLength.setBackground(design.getBackgroundComponents());
        sPasswordLength.setForeground(design.getTextColor());
        sPasswordLength.setBorder(design.getBorder());

        JLabel lblSCDesc = new JLabel("Special Character");
        lblSCDesc.setFont(design.getTextFont());
        lblSCDesc.setForeground(design.getTextColor());
        lblSCDesc.setBackground(design.getBackgroundComponents());
        lblSCDesc.setVerticalAlignment(SwingConstants.BOTTOM);

        tfSpecialChars = new JTextField();
        tfSpecialChars.setBackground(design.getBackgroundComponents());
        tfSpecialChars.setForeground(design.getTextColor());
        tfSpecialChars.setFont(design.getTextFont());
        tfSpecialChars.setCaretColor(design.getCaretColor());
        tfSpecialChars.setBorder(design.getBorder());
        tfSpecialChars.setText("!\"§$%&/()=?`{[]}\\+*#',;.:-_<>|");

        cmdGenerate = new JButton("Generate");
        cmdGenerate.setBackground(design.getBackgroundComponents());
        cmdGenerate.setForeground(design.getTextColor());
        cmdGenerate.setBorder(design.getBorder());
        cmdGenerate.setFont(design.getHeaderFont());

        JPanel pnlPwLength = new JPanel(new BorderLayout(0, 5));
        pnlPwLength.add(lblPasswordLengthDesc, BorderLayout.CENTER);
        pnlPwLength.add(sPasswordLength, BorderLayout.SOUTH);
        pnlPwLength.setBackground(design.getBackgroundColor());

        JPanel pnlSC = new JPanel(new BorderLayout(0, 5));
        pnlSC.add(lblSCDesc, BorderLayout.CENTER);
        pnlSC.add(tfSpecialChars, BorderLayout.SOUTH);
        pnlSC.setBackground(design.getBackgroundColor());

        pnlMain.add(pnlPwLength);
        pnlMain.add(pnlSC);
        pnlMain.add(cmdGenerate);
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
