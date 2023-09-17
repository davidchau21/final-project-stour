/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import custom_components.ScrollBarCustom;
import entity.Tour;
import java.awt.Image;
import java.util.Locale;
import javax.swing.ImageIcon;
import java.text.NumberFormat;
import javax.swing.JScrollBar;

/**
 *
 * @author Asus
 */
public class FrmThongTinTour extends javax.swing.JFrame {

    private Tour tour;
    
    
    public FrmThongTinTour() {
        initComponents();
    }
    
    public FrmThongTinTour(Tour tour) {
        initComponents();
        
        this.tour = tour;
        
        addControls();
    }
    
    private void addControls() {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scroll.setHorizontalScrollBar(sp);
        
        loadDataToForm();
    }

    private void loadDataToForm() {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(tour.getGhiChu()));
        Image image = imageIcon.getImage().getScaledInstance(1180 , 1180 * imageIcon.getIconHeight() / imageIcon.getIconWidth(), Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        imageTour.setIcon(imageIcon1);
        
        lblTenTour.setText("<html>" + tour.getTenTour() + "</html>");
        Locale localVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localVN);
        lblGiaTour.setText(vn.format(tour.getGiaTour()));
        lblThoiGian.setText(Integer.toString(tour.getSoNgay()) + " ngày");
        lblMaTour.setText("Mã tour: " + tour.getMaTour());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        imageTour = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTenTour = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblThoiGian = new javax.swing.JLabel();
        lblMaTour = new javax.swing.JLabel();
        lblNgayKhoHanh = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblGiaTour = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnDatVe = new custom_components.ButtonCustom();
        btnLienHeTuVan = new custom_components.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 750));
        setSize(new java.awt.Dimension(1200, 750));

        jPanel1.setBackground(new java.awt.Color(247, 248, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageTour.setBackground(new java.awt.Color(102, 153, 255));
        imageTour.setToolTipText("");
        imageTour.setOpaque(true);
        jPanel1.add(imageTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 370));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("<html><div class=\"col-xs-12 no-padding tourDetailContainer\">\n                                        <div class=\"col-xs-12 no-padding tourDetailMainDiv\">\n                                            <div class=\"col-xs-12 no-padding\" id=\"tour-overview\">\n                                                <h3 class=\"tourDetailheadLine vcolor-primary\">\n                                                    <div class=\"fb-like fb_iframe_widget\" data-href=\"https://www.ivivu.com/du-lich/tour-chau-au-11n10d-trai-nghiem-phap-thuy-si-y/1668\" data-layout=\"button\" data-action=\"like\" data-size=\"small\" data-show-faces=\"true\" data-share=\"true\" style=\"float:right\" fb-xfbml-state=\"rendered\" fb-iframe-plugin-query=\"action=like&amp;app_id=628025334278848&amp;container_width=0&amp;href=https%3A%2F%2Fwww.ivivu.com%2Fdu-lich%2Ftour-chau-au-11n10d-trai-nghiem-phap-thuy-si-y%2F1668&amp;layout=button&amp;locale=vi_VN&amp;sdk=joey&amp;share=true&amp;show_faces=true&amp;size=small\"><span style=\"vertical-align: bottom; width: 120px; height: 28px;\"><iframe name=\"f3192a0f5ad53ac\" width=\"1000px\" height=\"1000px\" data-testid=\"fb:like Facebook Social Plugin\" title=\"fb:like Facebook Social Plugin\" frameborder=\"0\" allowtransparency=\"true\" allowfullscreen=\"true\" scrolling=\"no\" allow=\"encrypted-media\" src=\"https://www.facebook.com/v10.0/plugins/like.php?action=like&amp;app_id=628025334278848&amp;channel=https%3A%2F%2Fstaticxx.facebook.com%2Fx%2Fconnect%2Fxd_arbiter%2F%3Fversion%3D46%23cb%3Df137deb8e2aaa1c%26domain%3Dwww.ivivu.com%26is_canvas%3Dfalse%26origin%3Dhttps%253A%252F%252Fwww.ivivu.com%252Ff1edd843b69b84%26relation%3Dparent.parent&amp;container_width=0&amp;href=https%3A%2F%2Fwww.ivivu.com%2Fdu-lich%2Ftour-chau-au-11n10d-trai-nghiem-phap-thuy-si-y%2F1668&amp;layout=button&amp;locale=vi_VN&amp;sdk=joey&amp;share=true&amp;show_faces=true&amp;size=small\" style=\"border: none; visibility: visible; width: 120px; height: 28px;\" class=\"\"></iframe></span></div>\n                                                    Khám Phá Châu Âu Quyến Rũ\n                                                </h3>\n                                                <div class=\"col-xs-12 tourScheduleContainer\">\n                                                    <div class=\"tourSchedule\">\n                                                        <p>Hãy tưởng tượng sự kết hợp hoàn hảo của văn hóa, lịch sử, thiên nhiên và ẩm thực mang tính biểu tượng. Chiêm ngưỡng những đại lộ rộng lớn của Paris, những món ăn ngon tự làm của Ý và những đỉnh núi đáng kinh ngạc của Thụy Sĩ. Chuyến du lịch Pháp, Thụy Sĩ và Ý sẽ mang đến cho quý khách một trải nghiệm ngoạn mục với những kỳ quan của lục địa già, những lâu đài cổ kính, đắm chìm trong vẻ đẹp của thị trấn sơn cước thơ mộng ẩn mình trong dãy núi Alps hùng vĩ, thưởng thức những tuyệt tác kiến trúc ven kênh đào đẹp như tranh vẽ hay dạo trên con thuyền Gondola nổi tiếng. Ngại ngần gì không trải nghiệm cùng iVIVU ngay hôm nay!</p>\n                                                    </div>\n                                                </div>\n                                            </div>\n                                                <div class=\"col-xs-12 no-padding\">\n                                                    <h3 class=\"tourDetailheadLine vcolor-primary\">\n                                                        Những trải nghiệm thú vị trong chương trình\n                                                    </h3>\n                                                    <div class=\"col-xs-12 tourScheduleContainer\">\n                                                        <div class=\"tourSchedule\">\n                                                            <p>- <strong>Tháp Eiffel</strong> – Biểu tượng của Pháp.</p>\n<p>- <strong>Nhà thờ lớn thứ 4 Thế Giới - Notre Dame Strasbourg</strong></p>\n<p>- Một trong những <strong>thị trấn đẹp nhất ở Thụy Sĩ - Zermatt</strong></p>\n<p>- Thành phố Tình yêu <strong>Venice</strong></p>\n<p>- <strong>Tháp nghiêng Pisa.</strong></p>\n<p>-&nbsp;<strong>Tòa Thánh Vatican.</strong></p>\n                                                        </div>\n                                                    </div>\n                                                </div>\n                                                                                            <div class=\"col-xs-12 no-padding\">\n                                                    <h3 class=\"tourDetailheadLine vcolor-primary\">\n                                                        Bạn có sẵn sàng\n                                                    </h3>\n                                                    <div class=\"col-xs-12 tourScheduleContainer\">\n                                                        <div class=\"tourSchedule\">\n                                                            <p>Một số điều kiện chung giúp Quý Khách nâng cao tỷ lệ xin Visa Châu Âu thành công:</p>\n<p>- Đã từng đi du lịch các nước phát triển như Hàn Quốc, Nhật Bản, Mỹ...</p>\n<p>- Có công việc ổn định và thu nhập tốt&nbsp;</p>\n<p>- Có tài sản đứng tên như nhà đất, xe hơi, sổ tiết kiệm...</p>\n<p>- Chưa từng bị từ chối visa trước đây</p>\n<p>iVIVU luôn sẵn sàng tư vấn chi tiết cho Quý Khách theo từng trường hợp cụ thể.</p>\n                                                        </div>\n                                                    </div>\n                                                </div>\n                                        </div>\n                                    </div></html>");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setPreferredSize(new java.awt.Dimension(1000, 450));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 690, 670));

        lblTenTour.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTenTour.setForeground(new java.awt.Color(0, 60, 113));
        lblTenTour.setText("<html>Du lịch Hè - Tour Du lịch Quy Nhơn - Phú Yên từu Sài Gòn 2022</html>");
        jPanel2.add(lblTenTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 710, 100));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 780, 800));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(231, 231, 231));
        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Thời gian");
        jLabel8.setOpaque(true);

        lblThoiGian.setBackground(new java.awt.Color(85, 85, 85));
        lblThoiGian.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        lblThoiGian.setForeground(new java.awt.Color(255, 255, 255));
        lblThoiGian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoiGian.setText("4 ngày 3 đêm");
        lblThoiGian.setOpaque(true);

        lblMaTour.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblMaTour.setForeground(new java.awt.Color(40, 163, 181));
        lblMaTour.setText("Ma tour: DL123");

        lblNgayKhoHanh.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblNgayKhoHanh.setForeground(new java.awt.Color(40, 163, 181));
        lblNgayKhoHanh.setText("Ngay khoi hanh: 24/05/2022");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Giá TOUR");

        lblGiaTour.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblGiaTour.setForeground(new java.awt.Color(233, 154, 62));
        lblGiaTour.setText("10.000.000");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(233, 154, 62));
        jLabel14.setText("VND");

        btnDatVe.setBackground(new java.awt.Color(51, 153, 255));
        btnDatVe.setBorder(null);
        btnDatVe.setForeground(new java.awt.Color(255, 255, 255));
        btnDatVe.setText("ĐẶT VÉ");
        btnDatVe.setBorderSize(0);
        btnDatVe.setColor(new java.awt.Color(51, 153, 255));
        btnDatVe.setColorClick(new java.awt.Color(102, 153, 255));
        btnDatVe.setColorHover(new java.awt.Color(102, 153, 255));
        btnDatVe.setFont(new java.awt.Font("Mulish Medium", 1, 13)); // NOI18N
        btnDatVe.setRadius(20);
        btnDatVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDatVeMousePressed(evt);
            }
        });

        btnLienHeTuVan.setBorder(null);
        btnLienHeTuVan.setForeground(new java.awt.Color(255, 255, 255));
        btnLienHeTuVan.setText("Liên hệ tư vấn");
        btnLienHeTuVan.setBorderSize(0);
        btnLienHeTuVan.setColor(new java.awt.Color(255, 204, 0));
        btnLienHeTuVan.setColorClick(new java.awt.Color(255, 204, 102));
        btnLienHeTuVan.setColorHover(new java.awt.Color(255, 204, 102));
        btnLienHeTuVan.setFont(new java.awt.Font("Mulish Medium", 1, 13)); // NOI18N
        btnLienHeTuVan.setRadius(20);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(lblThoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(83, 83, 83))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblGiaTour)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblNgayKhoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDatVe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLienHeTuVan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblGiaTour)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMaTour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNgayKhoHanh)
                .addGap(18, 18, 18)
                .addComponent(btnDatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLienHeTuVan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 310, 310));

        scroll.setViewportView(jPanel1);

        getContentPane().add(scroll, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatVeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatVeMousePressed
        FrmTTCTVe frmVe = new FrmTTCTVe(tour);
        frmVe.setVisible(true);
    }//GEN-LAST:event_btnDatVeMousePressed

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
            java.util.logging.Logger.getLogger(FrmThongTinTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmThongTinTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmThongTinTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmThongTinTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmThongTinTour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_components.ButtonCustom btnDatVe;
    private custom_components.ButtonCustom btnLienHeTuVan;
    private javax.swing.JLabel imageTour;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblGiaTour;
    private javax.swing.JLabel lblMaTour;
    private javax.swing.JLabel lblNgayKhoHanh;
    private javax.swing.JLabel lblTenTour;
    private javax.swing.JLabel lblThoiGian;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
