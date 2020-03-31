package Presentation ;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminView  extends JFrame{


    JButton btnNewButton ;
    JButton btnViewAllRequests;
    JButton btnViewAllDocuments;
    public AdminView ()
    {

        getContentPane().setBackground(new Color(51, 153, 153));

        this.setBounds(200, 200, 753, 599);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnNewButton = new JButton("Access users");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.setBounds(222, 10, 321, 71);
        getContentPane().add(btnNewButton);

        btnViewAllRequests = new JButton("Access requests");
        btnViewAllRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnViewAllRequests.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnViewAllRequests.setBounds(222, 157, 321, 71);
        getContentPane().add(btnViewAllRequests);

        btnViewAllDocuments = new JButton("Access documents");
        btnViewAllDocuments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnViewAllDocuments.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnViewAllDocuments.setBounds(222, 321, 321, 71);
        getContentPane().add(btnViewAllDocuments);

    }
    public void btnAccessUsers( ActionListener a)
    {
        btnNewButton.addActionListener(a);
    }
    public void btnAccessDocuments( ActionListener a)
    {
        btnViewAllDocuments.addActionListener(a);
    }

    public void btnAccessrRequests( ActionListener a)
    {
        btnViewAllRequests.addActionListener(a);
    }



}
