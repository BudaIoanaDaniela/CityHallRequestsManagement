package Presentation;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;





public class LoginView  extends JFrame{


    JButton btnNewButton;
    JButton btnNewButton_1 ;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    JButton adminButton;
    JButton citizenButton;
    JButton registerButton ;

    public LoginView()
    {
        getContentPane().setBackground(new Color(51, 153, 153));

        this.setBounds(200, 200, 753, 599);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome !");
        lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 45));
        lblNewLabel.setBounds(229, 0, 230, 94);
        getContentPane().add(lblNewLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(213, 126, 252, 53);
        getContentPane().add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordTextField = new JTextField();
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(213, 212, 252, 53);
        getContentPane().add(passwordTextField);

        JLabel lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setFont(new Font("Cambria Math", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(35, 125, 149, 53);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setFont(new Font("Cambria Math", Font.PLAIN, 23));
        lblNewLabel_2.setBounds(35, 212, 117, 53);
        getContentPane().add(lblNewLabel_2);

        adminButton = new JButton("Log in as Admin");
        adminButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        adminButton.setBounds(263, 284, 149, 62);
        getContentPane().add(adminButton);

        citizenButton = new JButton("Log in as Citizen");
        citizenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        citizenButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        citizenButton.setBounds(263, 363, 149, 62);
        getContentPane().add(citizenButton);

        JLabel lblNotAMember = new JLabel("REGISTER");
        lblNotAMember.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNotAMember.setBounds(584, 318, 125, 53);
        getContentPane().add(lblNotAMember);

        registerButton = new JButton("New button");
        registerButton.setBounds(572, 400, 137, 69);
        getContentPane().add(registerButton);





    }
    public String getUsername()
    {
        return usernameTextField.getText();
    }
    public String getPassword()
    {
        return passwordTextField.getText();
    }
    public void buttonAdminActionListener( ActionListener a)
    {
        adminButton.addActionListener(a);
    }
    public void buttonUserLogin(ActionListener a)
    {
        citizenButton.addActionListener(a);
    }
    public void buttonRegistrationL(ActionListener a)
    {
        registerButton.addActionListener(a);
    }

    public void succesfullMessage(String message)
    {
        JOptionPane.showMessageDialog(this,message);

    }

}
