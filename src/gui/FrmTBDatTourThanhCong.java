/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Color;
import app.Application;

public class FrmTBDatTourThanhCong extends javax.swing.JFrame {

    /**
     * Creates new form FrmTBDatTourThanhCong
     */
    public FrmTBDatTourThanhCong() {
        initComponents();
        addControls();
    }

    private void addControls() {
        iconCheck.setSVGImage("svg/check-solid.svg", 140, 140);
        iconCheck.setColor(new Color(0, 153, 51));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iconCheck = new custom_components.SVGImage();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnQuayLaiTrangChu = new custom_components.ButtonCustom();
        btnXemTourDaDat = new custom_components.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        iconCheck.setBackground(new java.awt.Color(0, 153, 51));
        iconCheck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel1.setText("ĐẶT TOUR THÀNH CÔNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bạn vui lòng thanh toán trong vòng 24 để hoàn tất đặt Tour");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cảm ơn bạn đã tin tưởng và đặt Tour tại công ty chúng tôi");

        btnQuayLaiTrangChu.setBackground(new java.awt.Color(255, 204, 0));
        btnQuayLaiTrangChu.setBorder(null);
        btnQuayLaiTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        btnQuayLaiTrangChu.setText("QUAY LẠI TRANG CHỦ");
        btnQuayLaiTrangChu.setBorderColor(new java.awt.Color(204, 204, 204));
        btnQuayLaiTrangChu.setColor(new java.awt.Color(255, 204, 0));
        btnQuayLaiTrangChu.setColorClick(new java.awt.Color(255, 204, 102));
        btnQuayLaiTrangChu.setColorHover(new java.awt.Color(255, 204, 102));
        btnQuayLaiTrangChu.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        btnQuayLaiTrangChu.setRadius(45);
        btnQuayLaiTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnQuayLaiTrangChuMousePressed(evt);
            }
        });

        btnXemTourDaDat.setBackground(new java.awt.Color(51, 153, 255));
        btnXemTourDaDat.setBorder(null);
        btnXemTourDaDat.setForeground(new java.awt.Color(255, 255, 255));
        btnXemTourDaDat.setText("XEM TOUR ĐÃ ĐẶT");
        btnXemTourDaDat.setBorderColor(new java.awt.Color(240, 240, 240));
        btnXemTourDaDat.setColor(new java.awt.Color(51, 153, 255));
        btnXemTourDaDat.setColorClick(new java.awt.Color(102, 153, 255));
        btnXemTourDaDat.setColorHover(new java.awt.Color(102, 153, 255));
        btnXemTourDaDat.setFont(new java.awt.Font("Mulish", 1, 14)); // NOI18N
        btnXemTourDaDat.setRadius(40);
        btnXemTourDaDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnXemTourDaDatMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnXemTourDaDatMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(iconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnQuayLaiTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXemTourDaDat, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addGap(4, 4, 4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(iconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXemTourDaDat, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuayLaiTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuayLaiTrangChuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuayLaiTrangChuMousePressed
        Application.frmTrangChu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiTrangChuMousePressed

    private void btnXemTourDaDatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXemTourDaDatMousePressed
//        Application.frmTourDaDat.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnXemTourDaDatMousePressed

    private void btnXemTourDaDatMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXemTourDaDatMouseReleased
        // TODO add your handling code here:
        Application.frmTourDaDat.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnXemTourDaDatMouseReleased

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
            java.util.logging.Logger.getLogger(FrmTBDatTourThanhCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTBDatTourThanhCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTBDatTourThanhCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTBDatTourThanhCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTBDatTourThanhCong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_components.ButtonCustom btnQuayLaiTrangChu;
    private custom_components.ButtonCustom btnXemTourDaDat;
    private custom_components.SVGImage iconCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
