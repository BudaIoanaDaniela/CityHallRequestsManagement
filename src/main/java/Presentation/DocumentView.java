package Presentation;

import entity.Document;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class DocumentView extends JFrame {


    private JPanel contentPane;
    private JTable table ;
    JScrollPane scrollPane;
    private JButton btnDelete;
    private JButton btnAdd;
    private JTextField textField;

    JTextField   textField_1;
    /**
     * Launch the application.


     /**
     * Create the frame.
     */
    public DocumentView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 781, 748);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 145, 730, 365);
        getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDelete.setBounds(10, 10, 185, 68);
        contentPane.add(btnDelete);

        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnAdd.setBounds(504, 10, 185, 68);
        contentPane.add(btnAdd);

        textField = new JTextField();
        textField.setBounds(229, 42, 204, 36);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblInsertId = new JLabel("Insert ID");
        lblInsertId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblInsertId.setBounds(271, 10, 185, 36);
        contentPane.add(lblInsertId);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(229, 109, 204, 36);
        contentPane.add(textField_1);

        JLabel lblNewLabel = new JLabel("lnsert type");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(252, 88, 123, 22);
        contentPane.add(lblNewLabel);

    }



    public void setTable (List<Document> object, Object objects) {

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
                    vector[i]=f.get(ob);
                    i++;
                }
                model.addColumn(f.getName(),vector);
            }
        }
        catch(Exception e)
        {

        }

        scrollPane.setViewportView(table);
        this.table=table ;
    }

    public String getSelectedItem()
    {
        int row= table.getSelectedRow();
        int column = 0;
        System.out.print(table.getValueAt(0, 0).toString());
        return table.getModel().getValueAt(row, column).toString();
    }
    public void setBtnAdd( ActionListener a)
    {
        btnAdd.addActionListener(a);
    }
    public void setBtnDelete(ActionListener a)
    {
        btnDelete.addActionListener(a);
    }
    public String getId()
    {
         return textField.getText();
    }
    public String getNewType()
    {
        return   textField_1.getText();
    }

}
