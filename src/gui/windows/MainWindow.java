package gui.windows;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MainWindow extends JFrame {

    private WindowDesign design;

    private JPanel pnlPasswordView, pnlPasswordOptions;
    private JTextField tfPasswordView, tfSpecialChars;
    private JSlider sPasswordLength;
    private JLabel lblPasswordLengthDesc;

    public MainWindow(WindowDesign design) throws HeadlessException {
        super("Password Generator");
        this.design = design;
        init();
        build();
    }

    private void init() {
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
    }

    private void build() {
        buildPasswordView();
        buildPasswordOptions();

        add(pnlPasswordView);
        add(pnlPasswordOptions);
    }

    private void buildPasswordView() {
        pnlPasswordView = new JPanel();
        pnlPasswordView.setBackground(design.getBackgroundColor());

        tfPasswordView = new JTextField();
        tfPasswordView.setBackground(design.getBackgroundComponents());
        tfPasswordView.setForeground(design.getTextColor());
        tfPasswordView.setFont(design.getTextFont());
        tfPasswordView.setCaretColor(design.getCaretColor());
        tfPasswordView.setBorder(design.getBorder());
        tfPasswordView.setPreferredSize(new Dimension(300, 50));
        pnlPasswordView.add(tfPasswordView);
    }

    private void buildPasswordOptions() {
        pnlPasswordOptions = new JPanel();

        lblPasswordLengthDesc = new JLabel();
        lblPasswordLengthDesc.setFont(design.getHeaderFont());
        lblPasswordLengthDesc.setForeground(design.getHeaderColor());
        lblPasswordLengthDesc.setBackground(design.getBackgroundColor());
        updatePasswordLengthDesc(0);

        sPasswordLength = new JSlider(0, 200, 120);
        sPasswordLength.setPreferredSize(new Dimension(200, 100));
        sPasswordLength.setBackground(design.getBackgroundComponents());
        sPasswordLength.setForeground(design.getTextColor());
        sPasswordLength.setBorder(design.getBorder());

        pnlPasswordOptions.add(lblPasswordLengthDesc);
        pnlPasswordOptions.add(sPasswordLength);
    }
    
    public void addPasswordLengthChangeListener(ChangeListener listener) {
        sPasswordLength.addChangeListener(listener);
    }
    
    public void updatePasswordLengthDesc(int newValue) {
        lblPasswordLengthDesc.setText("Password Length: " + newValue + " Characters");
    }
    public void updatePasswordLengthDesc() {
        updatePasswordLengthDesc(getPasswordLength());
    }

    public int getPasswordLength() { return sPasswordLength.getValue(); }

}
