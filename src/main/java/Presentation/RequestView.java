package Presentation;


import entity.Request;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class RequestView extends JFrame {

    private JPanel contentPane;
    private JTable table ;
    JScrollPane scrollPane;
    private JButton btnNewButton;
    JButton btnDelete;
    JTextPane textPane;
    JList list;
    JButton btnSortby;
    JButton btnFilterby;

    /**
     * Launch the application.


     /**
     * Create the frame.
     */
    public RequestView() {
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

        btnNewButton = new JButton("Aprove/Disaprove");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(20, 8, 156, 60);
        contentPane.add(btnNewButton);


        JLabel lblInsertId = new JLabel("Pick selection");
        lblInsertId.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblInsertId.setBounds(263, 20, 160, 35);
        contentPane.add(lblInsertId);

        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDelete.setBounds(20, 60, 156, 60);
        contentPane.add(btnDelete);


         btnFilterby = new JButton("FilterBy");
        btnFilterby.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnFilterby.setBounds(574, 8, 156, 60);
        contentPane.add(btnFilterby);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(232, 65, 176, 35);
        contentPane.add(scrollPane_1);

         list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setModel(new AbstractListModel() {
            String[] values = new String[] {"Date", "Adress", "User","Document"};
            public int getSize() {
                return values.length;
            }
            public Object getElementAt(int index) {
                return values[index];
            }
        });
        scrollPane_1.setViewportView(list);

        btnSortby = new JButton("SortBy");
        btnSortby.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSortby.setBounds(574, 78, 156, 60);
        contentPane.add(btnSortby);






    }

    public Object getSelectedValue()
    {
        return list.getSelectedValue();
    }
    public void btnSortByActionListener(ActionListener a)
    {
        btnSortby.addActionListener(a);
    }
    public void btnFilterByActionListener(ActionListener a)
    {
        btnFilterby.addActionListener(a);
    }





    public void setTable (List<Request> object, Request objects) {

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
                System.out.print("field="+f.getName());
                for(Request ob:object)
                {



                    System.out.print("obj=" +f.get(ob));
                    if(f.getName().equals("user"))
                    {
                        vector[i] = ob.getUser().getName();

                    }
                    else{
                        if(f.getName().equals("documentType"))
                        {
                            vector[i]=ob.getDocumentType().getType();

                        }
                        else
                        {
                            if(f.getName().equals("adress"))
                            {
                                vector[i]=ob.getAdress().getStreet();
                            }
                            else{
                                vector[i]=f.get(ob);
                                // if(f.getName().equals("))
                            }
                        }


                    }


                    i++;
                }

                model.addColumn(f.getName(),vector);
            }
        }
        catch(Exception e)
        {

        }
        scrollPane.setViewportView(table);
        setTableValue(table);
    }

    public String getSelectedItem()
    {
        int row= table.getSelectedRow();
        int column = 0;
        System.out.print(table.getValueAt(0, 0).toString());
        return table.getModel().getValueAt(row, column).toString();
    }
    public String getSelectedIndex()
    {
        int row= table.getSelectedRow();
        int column = table.getSelectedColumn();
        System.out.print(table.getValueAt(0, 0).toString());
        return table.getModel().getValueAt(row, column).toString();
    }
    public String getSelectedId()
    {
        int row= table.getSelectedRow();
        int column = table.getSelectedColumn();
        System.out.print(table.getValueAt(0, 0).toString());
        return table.getModel().getValueAt(row, column).toString();
    }

    public void setTableValue(JTable table)
    {
        this.table=table;
    }
    public String getId()
    {
        return textPane.getText();
    }
    public void setbtnAproval(ActionListener a)
    {
        btnNewButton.addActionListener(a);
    }
    public void setBtnDelete(ActionListener a)
    {
        btnDelete.addActionListener(a);
    }



}
