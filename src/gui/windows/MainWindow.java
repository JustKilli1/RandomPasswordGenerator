package gui.windows;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private WindowDesign design;

    private JPanel pnlPasswordView, pnlPasswordOptions;
    private JTextField tfPasswordView, tfSpecialChars;
    private JSlider sPasswordLength;
    private JLabel lPasswordLengthDesc;

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

        lPasswordLengthDesc = new JLabel("Password Length: 0 Characters");
        lPasswordLengthDesc.setFont(design.getHeaderFont());
        lPasswordLengthDesc.setForeground(design.getHeaderColor());
        lPasswordLengthDesc.setBackground(design.getBackgroundColor());

        sPasswordLength = new JSlider(1, 0, 200, 120);
        sPasswordLength.setPreferredSize(new Dimension(200, 100));
        sPasswordLength.setBackground(design.getBackgroundComponents());
        sPasswordLength.setForeground(design.getTextColor());
        sPasswordLength.setBorder(design.getBorder());

        pnlPasswordOptions.add(lPasswordLengthDesc);
        pnlPasswordOptions.add(sPasswordLength);
    }

}
