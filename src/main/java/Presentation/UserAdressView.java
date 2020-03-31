package Presentation;

import entity.Adress;
import entity.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserAdressView extends JFrame {

    private JPanel contentPane;
    private JTextField adressText;
    private JTextField adressNr;
    private JTable table;
    JButton btnAddNewAdress ;
    JButton  btnDeleteAdress;
    JScrollPane scrollPane;
    JButton btnAcessRequests;

    public UserAdressView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 657, 625);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        adressText = new JTextField();
        adressText.setBounds(268, 25, 252, 54);
        contentPane.add(adressText);
        adressText.setColumns(10);

        adressNr = new JTextField();
        adressNr.setBounds(268, 101, 252, 54);
        contentPane.add(adressNr);
        adressNr.setColumns(10);

        JLabel lblNewLabel = new JLabel("Insert Adress Street");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(39, 25, 194, 54);
        contentPane.add(lblNewLabel);

        JLabel lblInsertAdresNr = new JLabel("Insert Adress Nr");
        lblInsertAdresNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblInsertAdresNr.setBounds(39, 101, 194, 54);
        contentPane.add(lblInsertAdresNr);

        btnAddNewAdress = new JButton("Add adress");
        btnAddNewAdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAddNewAdress.setBounds(520, 172, 113, 54);
        contentPane.add(btnAddNewAdress);

         scrollPane = new JScrollPane();
        scrollPane.setBounds(24, 256, 588, 322);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        btnDeleteAdress = new JButton("delete Adress");
        btnDeleteAdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDeleteAdress.setBounds(39, 172, 135, 54);
        contentPane.add(btnDeleteAdress);

        btnAcessRequests = new JButton("Access Requests");
        btnAcessRequests.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnAcessRequests.setBounds(235, 169, 176, 57);
        contentPane.add(btnAcessRequests);

    }

    public String getAdresStreet()
    {
        return adressText.getText();
    }
    public String getAdressNr()
    {
        return adressNr.getText();
    }
    public void addAdressActionListener( ActionListener a)
    {
        btnAddNewAdress.addActionListener(a);
    }
    public void deleteAdressActionListener( ActionListener a)
    {
        btnDeleteAdress.addActionListener(a);
    }
    public String getSelectedItem()
    {
        int row= table.getSelectedRow();
        int column = 0;
        System.out.print(table.getValueAt(0, 0).toString());
        return table.getModel().getValueAt(row, column).toString();
    }

    public void setTable (List<Adress> object, Object objects) {

        DefaultTableModel model = new DefaultTableModel();

        JTable table=new JTable(model);
        String[] coloane=new String[20];
        int j=0;

        int i=0;
        try {
            for(Field f:objects.getClass().getDeclaredFields())
            {   i=0;
                f.setAccessible(true);
                coloane[j]=f.getName();
                Object[] vector=new Object[20];
                for(Object ob:object)
                {
                    if(!f.getName().equals("user_id")&&!f.getName().equals("request"))
                    {

                        vector[i]=f.get(ob);
                        i++;
                    }

                }
                model.addColumn(f.getName(),vector);
            }
        }
        catch(Exception e)
        {

        }

        scrollPane.setViewportView(table);
        this.setTableValue(table);
    }

 public void setTableValue(JTable table)
 {
     this.table=table;
 }

    public void setBtnAccesRequest(ActionListener a)
    {
        btnAcessRequests.addActionListener(a);
    }
}
