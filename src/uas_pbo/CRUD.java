
package uas_pbo;
import java.sql.*;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class CRUD extends javax.swing.JFrame {
 
    ResultSet rs;
    Connection conn;
    
    public CRUD() {
        initComponents();
        showTable();
        
        
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioLCD);
        buttonGroup.add(radioLED);
    }
    
    private void showTable(){
        try {
           DefaultTableModel tbltv = new DefaultTableModel(new String[] {"ID", "NAMA", "WARNA", "BRAND", "SIZE", "TIPE"}, 0);
            ResultSet res = selectData();
            while (res.next()) {
                    tbltv.addRow(new Object[] {res.getString("id"), res.getString("nama_tv"), 
                                              res.getString("warna_tv"), res.getString("brand_tv"), 
                                              res.getString("size_tv"), res.getString("tipe_tv")});
            }
            
         tblData.setModel(tbltv);
        } catch (SQLException ex) {
            System.out.println(ex);
        }    
    }
    
    public void insertData(int id, String nama, String warna, String brand, int size, String tipe) {    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtv", "root", "");
            String query = "insert into tbdatatv values(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, nama);
            pst.setString(3, warna);
            pst.setString(4, brand);
            pst.setInt(5, size);
            pst.setString(6, tipe);
            pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
    public ResultSet selectData() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtv", "root", "");
            String query = "select * from tbdatatv";
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return rs;
    }
    
    public void updateData(int id, String nama, String warna, String brand, int size, String tipe) {    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtv", "root", "");
            String query = "update tbdatatv set nama_tv =?, warna_tv =?, brand_tv =?, size_tv =?, tipe_tv =? wbere id =?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(6, id);
            pst.setString(1, nama);
            pst.setString(2, warna);
            pst.setString(3, brand);
            pst.setInt(4, size);
            pst.setString(5, tipe);
            pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
    public void deleteData(int id) {    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtv", "root", "");
            String query = "delete from tbdatatv where id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblWarna = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboBrand = new javax.swing.JComboBox<>();
        spinnerSize = new javax.swing.JSpinner();
        lblTipe = new javax.swing.JLabel();
        radioLCD = new javax.swing.JRadioButton();
        radioLED = new javax.swing.JRadioButton();
        lblNama = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        txtWarna1 = new javax.swing.JTextField();
        btnTambah1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblManajemen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setPreferredSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("FORM MANAJEMEN");

        lblWarna.setBackground(new java.awt.Color(102, 102, 102));
        lblWarna.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblWarna.setForeground(new java.awt.Color(102, 102, 102));
        lblWarna.setText("WARNA TELEVISI");

        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNama.setForeground(new java.awt.Color(102, 102, 102));

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("BRAND TELEVISI");

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("SIZE TELEVISI");

        comboBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SAMSUNG", "SONY", "SHARP", "LG", "TCL" }));

        lblTipe.setBackground(new java.awt.Color(102, 102, 102));
        lblTipe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTipe.setForeground(new java.awt.Color(102, 102, 102));
        lblTipe.setText("TIPE TELEVISI");

        radioLCD.setText("LCD");
        radioLCD.setBorder(null);

        radioLED.setText("LED");
        radioLED.setBorder(null);

        lblNama.setBackground(new java.awt.Color(102, 102, 102));
        lblNama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(102, 102, 102));
        lblNama.setText("NAMA TELEVISI");

        btnHapus.setBackground(new java.awt.Color(0, 102, 102));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(0, 102, 102));
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(0, 102, 102));
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblID.setBackground(new java.awt.Color(102, 102, 102));
        lblID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(102, 102, 102));
        lblID.setText("ID");

        txtWarna1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtWarna1.setForeground(new java.awt.Color(102, 102, 102));

        btnTambah1.setBackground(new java.awt.Color(0, 102, 102));
        btnTambah1.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah1.setText("TAMBAH");
        btnTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambah1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNama)
                                    .addComponent(jLabel6)
                                    .addComponent(comboBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblID)
                                                .addGap(194, 194, 194)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblWarna)
                                            .addComponent(txtWarna1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTipe)
                                        .addGap(27, 27, 27))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(spinnerSize, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(radioLCD)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioLED)
                                        .addGap(12, 12, 12))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblWarna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtWarna1)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblNama)
                .addGap(18, 18, 18)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(comboBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTipe))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioLCD)
                        .addComponent(radioLED))
                    .addComponent(spinnerSize, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(380, 0, 430, 470);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        lblManajemen.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lblManajemen.setForeground(new java.awt.Color(255, 255, 255));
        lblManajemen.setText("MANAJEMEN DATA TELEVISI");

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "WARNA", "BRAND", "SIZE", "TIPE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDataMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.setForeground(new java.awt.Color(102, 102, 102));

        btnCari.setBackground(new java.awt.Color(0, 204, 204));
        btnCari.setForeground(new java.awt.Color(102, 102, 102));
        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(lblManajemen))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1)
                .addContainerGap(342, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblManajemen)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 380, 460);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here

        String kataKunci = txtCari.getText();
        
        if (kataKunci.trim().isEmpty()) {
            // Jika kata kunci kosong, tampilkan pesan kesalahan
            JOptionPane.showMessageDialog(null, "Masukkan kata kunci untuk melakukan pencarian.");
        } else {
            // Membuat RowSorter untuk jTable
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tblData.getModel());
            tblData.setRowSorter(sorter);
            
            // Menentukan kata kunci dan kolom yang akan dicari
            String kolom = "NAMA"; // Ubah dengan kolom yang ingin Anda cari
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + kataKunci, tblData.getColumnModel().getColumnIndex(kolom)));
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // TODO add your handling code here:
        
        int row = tblData.getSelectedRow();
        if (row >= 0) {
            txtID.setText(tblData.getValueAt(row, 0).toString());
            txtNama.setText(tblData.getValueAt(row, 1).toString());
            txtCari.setText(tblData.getValueAt(row, 2).toString());
            comboBrand.setSelectedItem(tblData.getValueAt(row, 3).toString());
            
            int size = Integer.parseInt(tblData.getValueAt(row, 4).toString());
            spinnerSize.setValue(size);
            
            String tipe = tblData.getValueAt(row, 5).toString();
            if (tipe.equals("LCD")) {
                radioLCD.setSelected(true);
                radioLED.setSelected(false);
            } else if (tipe.equals("LED")) {
                radioLCD.setSelected(false);
                radioLED.setSelected(true);
            }
      }
    }//GEN-LAST:event_tblDataMouseClicked

    private void tblDataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMousePressed
        // TODO add your handling code here:
        
        tblDataMouseClicked(evt);
    }//GEN-LAST:event_tblDataMousePressed
     
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        
        int id = Integer.parseInt(txtID.getText());
        deleteData(id);
        showTable();
        clear();
        
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus !");
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        
        int id = Integer.parseInt(txtID.getText());
        String nama = txtNama.getText();
        String warna = txtCari.getText();
        String brand = comboBrand.getSelectedItem().toString();
        int size = (int) spinnerSize.getValue();
        String tipe = radioLCD.isSelected() ? "LCD" : "LED";

        updateData(id, nama, warna, brand, size, tipe);
        showTable();
        clear();
        JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate !");        
    }//GEN-LAST:event_btnUbahActionPerformed

    public void clear() {
        txtID.setText("");
        txtNama.setText("");
        txtCari.setText("");
        comboBrand.setSelectedIndex(0);
        spinnerSize.setValue(0);
        radioLCD.setSelected(false);
        radioLED.setSelected(false);        
    }
    
    private void logout() {
        int choice = JOptionPane.showConfirmDialog(rootPane,"Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {   
            clear();
     
            Login LoginFrame = new Login();
            LoginFrame.setVisible(true);
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null); 
        }
    }
    
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        
        logout();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambah1ActionPerformed
        // TODO add your handling code here:''
        
        int id = Integer.parseInt(txtID.getText());
        String nama = txtNama.getText();
        String warna = txtCari.getText();
        String brand = comboBrand.getSelectedItem().toString();
        int size = (int) spinnerSize.getValue();
        String tipe = radioLCD.isSelected() ? "LCD" : "LED";

        insertData(id, nama, warna, brand, size, tipe);
        showTable();
        clear();
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah !");    
    }//GEN-LAST:event_btnTambah1ActionPerformed
    
    /**
     * @param args the command line arguments
     */

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTambah1;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> comboBrand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblManajemen;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblTipe;
    private javax.swing.JLabel lblWarna;
    private javax.swing.JRadioButton radioLCD;
    private javax.swing.JRadioButton radioLED;
    private javax.swing.JSpinner spinnerSize;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtWarna1;
    // End of variables declaration//GEN-END:variables
}
