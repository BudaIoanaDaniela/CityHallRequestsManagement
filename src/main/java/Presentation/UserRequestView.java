package Presentation;

import entity.Adress;
import entity.Document;
import entity.Request;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class UserRequestView extends JFrame {

    private JPanel contentPane;
    private JTable table;

    DefaultListModel<String> model3 = new DefaultListModel<>();
    DefaultListModel<String> model2 = new DefaultListModel<>();
    DefaultListModel<Document> model4 = new DefaultListModel<>();
    DefaultListModel<Adress> model1 = new DefaultListModel<>();
    JButton btnDelete;
    JButton btnUpdateRequest;
    JButton btnUpdateType;
    JButton btnNewRequest;
    JList listDocument;
    JList listAdress;
    JList listDoc;

    JScrollPane panel;
    public UserRequestView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 794, 672);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(219, 122, 241, 53);
        contentPane.add(scrollPane_1);



        listDocument = new JList(model2);
        scrollPane_1.setViewportView(listDocument);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(219, 30, 236, 47);
        contentPane.add(scrollPane);

        listAdress = new JList(model3);
        scrollPane.setViewportView(listAdress);

         btnNewRequest = new JButton("New Request");
        btnNewRequest.setBounds(581, 150, 174, 62);
        contentPane.add(btnNewRequest);

        JLabel lblNewLabel = new JLabel("Request Adress");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 21, 174, 53);
        contentPane.add(lblNewLabel);

        JLabel lblRequestType = new JLabel("Request Type");
        lblRequestType.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRequestType.setBounds(10, 135, 174, 53);
        contentPane.add(lblRequestType);

        panel = new JScrollPane();
        panel.setBounds(10, 282, 718, 332);
        contentPane.add(panel);


        table = new JTable();
      //  table.setBounds(0, 0, 718, 332);
        panel.add(table);
        panel.setViewportView(table);

        btnDelete = new JButton("Delete Request");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnDelete.setBounds(10, 215, 145, 53);
        contentPane.add(btnDelete);

        btnUpdateRequest = new JButton("Update Request Adress");

        btnUpdateRequest.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdateRequest.setBounds(219, 215, 262, 53);
        contentPane.add(btnUpdateRequest);

        btnUpdateType = new JButton("Update Request Type");
        btnUpdateType.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUpdateType.setBounds(550, 222, 230, 53);
        contentPane.add(btnUpdateType);

        JScrollPane scrollPane_2= new JScrollPane();
        scrollPane_2.setBounds(522, 31, 234, 45);
        contentPane.add(scrollPane_2);

         listDoc = new JList((model4));
        scrollPane_2.setViewportView(listDoc);

    }

    public void addDocuments( List<String> list)
    {
        model2.addAll(list);
    }
    public void addAdresses ( List<String > list)
    {
        model3.addAll(list);
    }

    public void addBtnActionlistener(ActionListener a)
    {
         btnNewRequest.addActionListener(a);
    }
    public void deleteBtnActionlistener(ActionListener a)
    {
        btnDelete.addActionListener(a);
    }
    public void updateType( ActionListener a)
    {
        btnUpdateType.addActionListener(a);
    }
    public void updateAdress( ActionListener a)
    {
        btnUpdateRequest.addActionListener(a);
    }

   public String getSelectedType()
   {
       return model2.getElementAt(listDocument.getSelectedIndex());
   }
    public Document getSelectedType2()
    {
        return model4.getElementAt(listDocument.getSelectedIndex());
    }
    public Document getSelectedType3(int id)
    {
        return model4.getElementAt(id);
    }
    public Adress getSelectedAdress(){return model1.getElementAt(listAdress.getSelectedIndex());}
    public int getPlaceOnList()
    {
        return listDocument.getSelectedIndex();
    }
      public void addRealAdresses(Set<Adress> lista)
      {
          model1.addAll(lista);
      }
    public void addDocuments2( List<Document> list)
    {
        model4.addAll(list);
    }


    public void setTable (Set<Request> object, Object objects) {

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
        panel.setViewportView(table);
        setTableValue(table);
    }
    public void setTableValue(JTable table)
    {
        this.table=table;
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
        panel.setViewportView(table);
        setTableValue(table);
    }



    public String getSelectedItem()
    {
        int row= table.getSelectedRow();
        int column = 0;
        System.out.print(table.getValueAt(0, 0).toString());
        return table.getModel().getValueAt(row, column).toString();
    }

}
