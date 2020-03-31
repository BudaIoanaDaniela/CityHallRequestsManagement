package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class UserRegistrationView extends JFrame {

    private JPanel contentPane;
    private JTextField usernameText;
    private JTextField textField_1;
    JButton btnNewButton;


    public UserRegistrationView() {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 778, 644);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        usernameText = new JTextField();
        usernameText.setBounds(276, 58, 313, 79);
        contentPane.add(usernameText);
        usernameText.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(276, 180, 313, 79);
        contentPane.add(textField_1);

        JLabel lblNewLabel = new JLabel("Insert Username");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(68, 56, 201, 77);
        contentPane.add(lblNewLabel);

        JLabel lblInsertPassword = new JLabel("Insert Password");
        lblInsertPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblInsertPassword.setBounds(68, 193, 201, 77);
        contentPane.add(lblInsertPassword);

        btnNewButton = new JButton("Register");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton.setBounds(615, 461, 139, 79);
        contentPane.add(btnNewButton);
    }

    public void btnRegisterActionListener(ActionListener a)
    {
        btnNewButton.addActionListener(a);
    }


    public String getUsername()
    {

        return usernameText.getText();
    }
    public String getPassword()
    {
        return textField_1.getText();
    }

}
