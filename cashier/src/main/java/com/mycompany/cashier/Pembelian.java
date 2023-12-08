/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cashier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author PaulTitto
 */
public class Pembelian extends javax.swing.JFrame {

    /**
     * Creates new form Pembelian
     */
    public Pembelian() {
        initComponents();
        LoadDatabarang();
        IDOtomatis();
        LoadMember();
        Tablebarang.getColumnModel().getColumn(0).setPreferredWidth(30);
        Tablebarang.getColumnModel().getColumn(1).setPreferredWidth(200);
    }
    public void LoadMember(){
        Connection kon = db_koneksi.koneksiDb();
        Object header[]={"ID MEMBER","NAMA"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        TableMember.setModel(data);
        String sql_data = "SELECT * FROM member";
        try{
            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(sql_data);
            while(rs.next()){
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d[] = {d1,d2};
                data.addRow(d);
                
            }
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void LoadDatabarang(){
        Connection kon = db_koneksi.koneksiDb();
        Object header[]={"ID barang","NAMA","HARGA"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        Tablebarang.setModel(data);
        String sql_data = "SELECT * FROM barangan";
        try{
            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(sql_data);
            while(rs.next()){
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);
                String d[] = {d1,d2,d3};
                data.addRow(d);
                
            }
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void addtable(String id ,String Name, int Qty ,Double Price){
  
      DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
      
      Vector v = new Vector() ;
      
      v.add(id);
      v.add(Name);
      v.add(Qty);
      v.add(Price);
      
      dt.addRow(v);
      
      
      
      
  
  }
     
    public void addtables(String id ,String Name,int Qty ,Double Price){
    
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        
       DecimalFormat df = new DecimalFormat("00.00") ;       
       double totPrice = Price * Double.valueOf(Qty) ;
       
       String TotalPrice = df.format(totPrice);
        
        for (int row = 0; row < jTable1.getRowCount(); row++) {
            
            if (Name == jTable1.getValueAt(row, 1)) {
                
                dt.removeRow(jTable1.convertRowIndexToModel(row));
                
            } 
        }
        Vector v = new Vector();
        
        v.add(id);
        v.add(Name);
        v.add(Qty);
        v.add(TotalPrice); // total price
        
        dt.addRow(v);
    }
    
    public void cal(){
    //cal total table values
   
   int numOfRow = jTable1.getRowCount() ;
   double tot = 0.0 ;
   
       for (int i = 0; i < numOfRow; i++) {
           
           double value = Double.valueOf(jTable1.getValueAt(i, 3).toString());
          
           tot += value ;
           
       }
       
       DecimalFormat df = new DecimalFormat("00.00") ;
       total.setText(df.format(tot));
    
   
   
   } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tablebarang = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        b = new javax.swing.JTextArea();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        pay = new javax.swing.JTextField();
        bal = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        LOGOUT = new javax.swing.JButton();
        Member = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableMember = new javax.swing.JTable();
        Ref = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        tanggal = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        BSearch = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        IDmember = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tablebarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tablebarang.setToolTipText("");
        Tablebarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablebarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tablebarang);

        jTable1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Iteam", "Qty", "Price"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        b.setColumns(20);
        b.setRows(5);
        jScrollPane2.setViewportView(b);

        jButton13.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jButton13.setText("Delete");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Total :");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Cash :");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Kembalian :");

        total.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        total.setText("00");

        pay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });

        bal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bal.setText("00");

        jButton11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton11.setText("Bayar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton12.setText("Print");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        LOGOUT.setText("LOGOUT");
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });

        Member.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Is Member :");

        TableMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableMember.setToolTipText("");
        TableMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMemberMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TableMember);

        Ref.setText("Refresh");
        Ref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefActionPerformed(evt);
            }
        });

        jLabel5.setText("Kode Transaksi");

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        tanggal.setDateFormatString("yyyy-MM-dd");

        jLabel6.setText("Tanggal Transaksi");

        jLabel7.setText("Cari Member");

        BSearch.setText("SEARCH");
        BSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSearchActionPerformed(evt);
            }
        });

        jLabel8.setText("ID MEMBER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(Member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LOGOUT)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(bal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(Ref)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(35, 35, 35)
                        .addComponent(IDmember, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(tanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(IDmember, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(total))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(bal))
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Ref)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(6, 6, 6))
                                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BSearch)
                                .addGap(122, 122, 122)))
                        .addGap(16, 16, 16)))
                .addComponent(LOGOUT)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private Map<String, Integer> itemQuantities = new HashMap<>();
    private void TablebarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablebarangMouseClicked
        // TODO add your handling code here:
        int bar = Tablebarang.getSelectedRow();
        String a = Tablebarang.getValueAt(bar, 0).toString();
        String b = Tablebarang.getValueAt(bar, 1).toString();
        String c = Tablebarang.getValueAt(bar, 2).toString();
        if (itemQuantities.containsKey(c)) {
            // If yes, increment the quantity
            int quantity = itemQuantities.get(c);
            quantity++;
            itemQuantities.put(c, quantity);
        } else {
            // If no, add the item to the map with quantity 1
            itemQuantities.put(c, 1);
        }

//        int i = 0;
//        
//        ++i;
//        q1.setText(String.valueOf(i));
        
        addtables(a, b, itemQuantities.get(c), Double.parseDouble(c));
        
        cal();
        
    }//GEN-LAST:event_TablebarangMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // delete some iteam

        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();

        String r = dt.getValueAt(jTable1.getSelectedRow(), 0).toString();

        //remove product
        int rw = jTable1.getSelectedRow();
        dt.removeRow(rw);

        //remove Qty Lable
        

        cal(); // after iteam delete calculate total

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // pat btn

        double tot = Double.valueOf(total.getText());
        double paid = Double.valueOf(pay.getText());
        String mem = (String) Member.getSelectedItem();

        double discount = 0;
        if (mem == "YES") {
            discount = tot * 0.10;
        }

        double balance = paid - tot + discount;

        DecimalFormat df = new DecimalFormat("00.00");
        bal.setText(String.valueOf(df.format(balance)));


    }//GEN-LAST:event_jButton11ActionPerformed

    private void input_data() {
    try {
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();

        StringBuilder displayDetails = new StringBuilder();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String Name = df.getValueAt(i, 1).toString();
            String Qty = df.getValueAt(i, 2).toString();
            String Price = df.getValueAt(i, 3).toString();
            displayDetails.append("  ").append(Name).append("\t\t").append(Qty).append("\t").append(Price).append("\n");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try (Connection kon = db_koneksi.koneksiDb();
             PreparedStatement st = kon.prepareStatement("INSERT INTO transaksi VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            st.setString(1, ID.getText());
            st.setString(2, sdf.format(tanggal.getDate()));
            st.setString(3, total.getText());
            st.setString(4, pay.getText());
            st.setString(5, bal.getText());
            st.setString(6, displayDetails.toString());
            st.setString(7, IDmember.getText());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Anggota Berhasil diInput");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}



    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // bill print

        try {

            b.setText("                         Mosa Food & Beverage \n");
            b.setText(b.getText() + "                         50/ Adi Sucipto, \n");
            b.setText(b.getText() + "                         Surakarta, Indonesia, \n");
            b.setText(b.getText() + "                         +62 85728927751, \n");
            b.setText(b.getText() + "---------------------------------------------------------------------\n");
            b.setText(b.getText() + "  Item \t\tQty \tPrice" +"\n");
            b.setText(b.getText() + "---------------------------------------------------------------------\n");

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();

            // get table Product details

            for (int i = 0; i < jTable1.getRowCount(); i++) {

                String Name = df.getValueAt(i, 1).toString();
                String Qty = df.getValueAt(i, 2).toString();
                String Price = df.getValueAt(i, 3).toString();

                b.setText(b.getText() +"  "+ Name+"\t\t"+Qty +"\t"+Price + "\n");
            }

            b.setText(b.getText() + "---------------------------------------------------------------------\n");
            b.setText(b.getText() + "Jumlah Beli : " + total.getText() +"\n");
            b.setText(b.getText() + "Pembayaran  : " + pay.getText() +".00" +"\n");
            b.setText(b.getText() + "Kembalian   : " + bal.getText() +"\n");
            b.setText(b.getText() + "---------------------------------------------------------------------\n");
            b.setText(b.getText() + "                     Terima Kasih atas Pembeliannya...!"+"\n");
            b.setText(b.getText() + "---------------------------------------------------------------------\n");

            b.print(); //print
            input_data();

        } catch (Exception e) {

            System.out.println(e);

        }

    }//GEN-LAST:event_jButton12ActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payActionPerformed

    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
        // TODO add your handling code here:
        int keluar;
        keluar= JOptionPane.showOptionDialog(this,
            "Keluar dari Aplikasi",
            "Exit",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null,null,null);
        if (keluar== JOptionPane.YES_NO_OPTION){
            new FKasir().show();
            this.dispose();
        }
        
    }//GEN-LAST:event_LOGOUTActionPerformed

    private void TableMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMemberMouseClicked
        // TODO add your handling code here:
        int bar = TableMember.getSelectedRow();
        String a = TableMember.getValueAt(bar, 0).toString();
        String b = TableMember.getValueAt(bar, 1).toString();
        
        
        IDmember.setText(a);
    }//GEN-LAST:event_TableMemberMouseClicked

    private void RefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefActionPerformed
        // TODO add your handling code here:
        new Pembelian().show();
        this.dispose();
    }//GEN-LAST:event_RefActionPerformed
    private void IDOtomatis(){
        try{
            Connection kon=db_koneksi.koneksiDb();
            Statement st=kon.createStatement();
            String sql_id="SELECT * FROM transaksi order by id_transaksi desc";
            ResultSet rs=st.executeQuery(sql_id);
            if(rs.next()){
                String id_transaksi=rs.getString("id_transaksi").substring(3);
                String AN=""+(Integer.parseInt(id_transaksi)+1);
                String Nol="";
                switch (AN.length()) {
                    case 1 -> Nol = "000";
                    case 2 -> Nol = "00";
                    case 3 -> Nol = "0";
                    default -> {
                    }
                }
                ID.setText("TRN"+Nol+AN);
                        
            }else{
                ID.setText("TRN00001");
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void BSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSearchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) TableMember.getModel();
        TableRowSorter<DefaultTableModel> obj= new TableRowSorter<>(ob);
        TableMember.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txtsearch.getText()));
    }//GEN-LAST:event_BSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BSearch;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField IDmember;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JComboBox<String> Member;
    private javax.swing.JButton Ref;
    private javax.swing.JTable Tablebarang;
    private javax.swing.JTable TableMember;
    private javax.swing.JTextArea b;
    private javax.swing.JLabel bal;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pay;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JLabel total;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
