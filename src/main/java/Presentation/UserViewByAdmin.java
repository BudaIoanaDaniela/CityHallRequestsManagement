package Presentation;
import entity.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class UserViewByAdmin extends JFrame {

    private JPanel contentPane;
    private JTable table ;
    JScrollPane scrollPane;
    /**
     * Launch the application.


     /**
     * Create the frame.
     */
    public UserViewByAdmin() {
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


    }


// era mai grav daca importam swing in user
    public void setTable (List<User> object, Object objects) {

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
    }
}

