/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Khach_hang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tt
 */
public class UI extends javax.swing.JFrame {

    /**
     * Creates new form UI
     */
    DefaultTableModel defaultTableModel;
    KhachHang kh = new KhachHang();
    KhachHangService khSV = new KhachHangService();
    ButtonGroup btGR = new ButtonGroup();

    public UI() {
        initComponents();
        setLocationRelativeTo(null);
        loadData();
        gioTinh();
    }

    public void gioTinh() {

        btGR.add(rd_nam);
        btGR.add(rd_nu);
    }

    public void loadData() {
        defaultTableModel = (DefaultTableModel) tb_khachhang.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang kh : khSV.getList()) {
            Object[] rowData = {
                kh.getId(), kh.getTen(), kh.getDia_chi(), kh.getEmail(), kh.getTuoi(), kh.GioiTinh()
            };
            defaultTableModel.addRow(rowData);
            
        }
    }
    public void clearForm() {
        lblID.setText("-");
        txt_diachi.setText("");
        txt_email.setText("");
        txt_ten.setText("");
        txt_tuoi.setText("");
        btGR.clearSelection();
    }

    private KhachHang getFrom() {
        String id = lblID.getText();
        String ten = txt_ten.getText().trim();
        String diachi = txt_diachi.getText().trim();
        String email = txt_email.getText().trim();
        String tuoi = txt_tuoi.getText().trim();
        if (ten.length() == 0 || diachi.length() == 0 || email.length() == 0 || tuoi.length() == 0) {
            JOptionPane.showMessageDialog(this, "Khong de thong tin trong");
            return null;
        }
        String regexEmail = "\\w+@\\w+(\\.\\w+){1,2}";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==false){
            JOptionPane.showMessageDialog(this, "Email khong đúng định dạng");
            return null;
        }
        int gioitinh = 0;
        int iD = id.equals("-") ? 0 : Integer.parseInt(id);
        if (rd_nam.isSelected()) {
            gioitinh = 1;
        }
        int TUOI = -1;
        try {
            TUOI = Integer.parseInt(tuoi);
            if (TUOI < 0) {
                JOptionPane.showMessageDialog(this, "Tuoi phai duong");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Tuoi phai nguyen");
            return null;
        }

        KhachHang kh = new KhachHang(iD, ten, diachi, email, TUOI, gioitinh);
        return kh;
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
        tb_khachhang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        txt_tuoi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();
        lblID = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_cl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb_khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ten", "Dia chi", "Email", "tuoi", "Gioi tinh"
            }
        ));
        tb_khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_khachhang);

        jLabel1.setText("ID");

        jLabel2.setText("Ten");

        jLabel3.setText("Dia chi");

        jLabel4.setText("Tuoi");

        jLabel5.setText("Gioi tinh");

        jLabel6.setText("Email");

        rd_nam.setText("Nam");

        rd_nu.setText("Nu");

        lblID.setText("-");

        btn_them.setText("Them");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xoa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_sua.setText("Sua");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_cl.setText("Clear");
        btn_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(344, 344, 344))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_email))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_tuoi))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_diachi)))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them)
                            .addComponent(btn_sua))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cl)
                            .addComponent(btn_xoa))
                        .addGap(104, 104, 104))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblID))
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_nam)
                            .addComponent(rd_nu))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_tuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them)
                            .addComponent(btn_xoa))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua)
                    .addComponent(btn_cl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khachhangMouseClicked
        int row = tb_khachhang.getSelectedRow();
        lblID.setText(tb_khachhang.getValueAt(row, 0).toString());
        txt_ten.setText(tb_khachhang.getValueAt(row, 1).toString());
        txt_diachi.setText(tb_khachhang.getValueAt(row, 2).toString());
        txt_email.setText(tb_khachhang.getValueAt(row, 3).toString());
        txt_tuoi.setText(tb_khachhang.getValueAt(row, 4).toString());
        if (tb_khachhang.getValueAt(row, 5).toString().equals("Nam")) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
    }//GEN-LAST:event_tb_khachhangMouseClicked

    private void btn_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_clActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        KhachHang kh = getFrom();
        if (kh == null) {
            return;
        }
        khSV.insert(kh);
        loadData();
        clearForm();
        JOptionPane.showMessageDialog(this, "Them thanhcong");
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int row = tb_khachhang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 dong roi xoa");
            return;
        }
        KhachHang kh = getFrom();
        if (kh == null) {
            return;
        }

        this.khSV.delete(kh.getId());
        this.loadData();
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Xoa thanh cong");
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int row = tb_khachhang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 dong roi Sua");
            return;
        }
        KhachHang kh = getFrom();
        if (kh == null) {
            return;
        }

        this.khSV.update(kh.getId(), kh);
        this.loadData();
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Sua thanh cong");
    }//GEN-LAST:event_btn_suaActionPerformed

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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cl;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JTable tb_khachhang;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_tuoi;
    // End of variables declaration//GEN-END:variables
}
