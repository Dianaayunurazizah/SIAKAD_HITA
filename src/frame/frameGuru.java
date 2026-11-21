/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import card.cardPenggunaHeader;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import custom.PanelCustom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ASUS
 */
public class frameGuru extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frameGuru.class.getName());

    private PanelCustom dashboard, jadwalMengajar, absensiSaya, absensiMapel, pergantianGuru;
    private PanelCustom[] semuaMenu;
    
    private boolean sidebarMelebar = true;
    private boolean animasiJalan = false;
    private int lebarSekarang = 264;

    private static final int lebarBuka = 264;
    private static final int lebarKecil = 73;
    
    private JPopupMenu menuUser;
    private long terakhirTutup = 0;
    private static final int LEBAR_MENU_USER = 413;
    private static final int TINGGI_MENU_USER = 307;
    private static final int GESER_KIRI = 16;
    
    /**
     * Creates new form frameGuru
     */
    public frameGuru() {
        initComponents();
        
        panelSidebar();
        setupGarisSidebar();    
        radiusPanel();
        setupMenuUser();
        
        panelUser.add(Box.createHorizontalStrut(12), 1);
        panelUser.add(Box.createHorizontalStrut(8), 3);
    }

    private void panelSidebar() {
        
        iconLogoAplikasi.setIcon(new FlatSVGIcon("iconSidebar/logoaplikasi_sidebar.svg", 185, 34));
        iconGaris.setIcon(new FlatSVGIcon("iconSidebar/garis3.svg", 32, 32));
        
        btnArrowProfil.setIcon(new FlatSVGIcon("iconSidebar/panahPengguna_normal.svg", 24, 24));
        btnArrowProfil.setSelectedIcon(new FlatSVGIcon("iconSidebar/panahPengguna_aktif.svg", 24, 24));

        dashboard = new PanelCustom(iconDashboard, txtDashboard, btnDashboard);
        dashboard.setIconNormal(new FlatSVGIcon("iconSidebar/dashboard_normal.svg", 24, 24));
        dashboard.setIconAktif(new FlatSVGIcon("iconSidebar/dashboard_aktif.svg", 24, 24));

        jadwalMengajar = new PanelCustom(iconJadwal, txtJadwal, btnJadwal);
        jadwalMengajar.setIconNormal(new FlatSVGIcon("iconSidebar/jadwal_normal.svg", 24, 24));
        jadwalMengajar.setIconAktif(new FlatSVGIcon("iconSidebar/jadwal_aktif.svg", 24, 24));

        absensiSaya = new PanelCustom(iconAbsensiSaya, txtAbsensiSaya, btnAbsensiSaya);
        absensiSaya.setIconNormal(new FlatSVGIcon("iconSidebar/abguru_normal.svg", 24, 24));
        absensiSaya.setIconAktif(new FlatSVGIcon("iconSidebar/abguru_aktif.svg", 24, 24));

        absensiMapel = new PanelCustom(iconAbsensiMapel, txtAbsensiMapel, btnAbsensiMapel);
        absensiMapel.setIconNormal(new FlatSVGIcon("iconSidebar/abmapel_normal.svg", 24, 24));
        absensiMapel.setIconAktif(new FlatSVGIcon("iconSidebar/abmapel_aktif.svg", 24, 24));

        pergantianGuru = new PanelCustom(iconPergantian, txtPergantian, btnPergantianGuru);
        pergantianGuru.setIconNormal(new FlatSVGIcon("iconSidebar/pergantian_normal.svg", 24, 24));
        pergantianGuru.setIconAktif(new FlatSVGIcon("iconSidebar/pergantian_aktif.svg", 24, 24));

        semuaMenu = new PanelCustom[]{
            dashboard, jadwalMengajar, absensiSaya, absensiMapel, pergantianGuru
        };
        
        aktifkanMenu(dashboard);
    }

    // menu tanpa submenu (Dashboard, Absensi, Laporan, Pengaturan)
    private void aktifkanMenu(PanelCustom menuAktif) {
        for (PanelCustom menu : semuaMenu) {
            menu.setAktif(menu == menuAktif);
        }
    }
    
    public void setNamaUser(String nama){
        lUsername.setText(nama);
        panelUser.revalidate();
        panelUser.repaint();
        panelHeader.revalidate();
        panelHeader.repaint();
    }

    private void radiusPanel(){
        btnDashboard.putClientProperty("FlatLaf.style", "arc: 25");
        btnJadwal.putClientProperty("FlatLaf.style", "arc: 25");
        btnAbsensiSaya.putClientProperty("FlatLaf.style", "arc: 25");
        btnAbsensiMapel.putClientProperty("FlatLaf.style", "arc: 25");
        btnPergantianGuru.putClientProperty("FlatLaf.style", "arc: 25");
    }
    
    private void setupMenuUser() {
        menuUser = new javax.swing.JPopupMenu();
        menuUser.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0xE5E7EB)));

        cardPenggunaHeader isi = new cardPenggunaHeader();
        isi.putClientProperty("FlatLaf.style", "arc: 50");
        Dimension ukuran = new Dimension(LEBAR_MENU_USER - 2, TINGGI_MENU_USER - 2);   // dikurangi border 1px kiri-kanan dan atas-bawah
        isi.setPreferredSize(ukuran);
        isi.setMinimumSize(ukuran);
        isi.setMaximumSize(ukuran);
        menuUser.add(isi);

        // panah ikut berganti icon saat dropdown terbuka/tertutup
        menuUser.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent e) {
                btnArrowProfil.setSelected(true);
            }

            @Override
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent e) {
                btnArrowProfil.setSelected(false);
                terakhirTutup = System.currentTimeMillis();
            }

            @Override
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent e) {
            }
        });

        // seluruh kartu pengguna bisa diklik, bukan hanya panahnya
        panelUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tampilMenuUser();
            }
        });
    }

    private void tampilMenuUser() {
        if (System.currentTimeMillis() - terakhirTutup < 200) {
            return;                                   // klik saat terbuka = menutup
        }
        int x = panelUser.getWidth() - LEBAR_MENU_USER - GESER_KIRI;   // rata kanan
        menuUser.show(panelUser, x, panelUser.getHeight() + 8);
    }
    
    private void setupGarisSidebar() {
        // lepas semua kunci ukuran dari desainer
        panelMenu.setMinimumSize(null);
        panelMenu.setMaximumSize(null);

        scrollSidebar.setBorder(null);
        scrollSidebar.setHorizontalScrollBarPolicy(
                javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollSidebar.getViewport().setBackground(Color.WHITE);   // area di bawah menu tetap putih

        iconGaris.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                toggleSidebar();
            }
        });

        ukurSidebar(lebarBuka);
    }

    private void ukurSidebar(int w) {
        lebarSekarang = w;

        jPanel3.setPreferredSize(new Dimension(w, jPanel3.getPreferredSize().height));   // header kiri
        scrollSidebar.setPreferredSize(new Dimension(w, 100));

        // hitung ulang tinggi menu (berubah saat submenu buka/tutup), lalu kunci lebarnya
        panelMenu.setPreferredSize(null);
        int tinggi = panelMenu.getPreferredSize().height;
        panelMenu.setPreferredSize(new Dimension(w, tinggi));

        getContentPane().revalidate();
        getContentPane().repaint();
    }

    private void tampilkanTeksMenu(boolean tampil) {
        javax.swing.JLabel[] teks = {
            txtDashboard, txtJadwal, txtAbsensiSaya, txtAbsensiMapel, txtPergantian
        };

        for (javax.swing.JLabel l : teks) {
            l.setVisible(tampil);
        }
    }

    private void toggleSidebar() {
        if (animasiJalan) {
            return;
        }
        final boolean akanMelebar = !sidebarMelebar;

        if (!akanMelebar) {            // mengecil: sembunyikan teks DULU
            tampilkanTeksMenu(false);
        }

        final int target = akanMelebar ? lebarBuka : lebarKecil;
        final int langkah = akanMelebar ? 24 : -24;
        animasiJalan = true;

        final javax.swing.Timer t = new javax.swing.Timer(10, null);
        t.addActionListener(e -> {
            int w = lebarSekarang + langkah;
            boolean selesai = (langkah > 0 && w >= target) || (langkah < 0 && w <= target);
            if (selesai) {
                w = target;
            }

            ukurSidebar(w);

            if (selesai) {
                t.stop();
                animasiJalan = false;
                sidebarMelebar = akanMelebar;
                if (akanMelebar) {
                    tampilkanTeksMenu(true);   // melebar: teks muncul SETELAH selesai
                }
                ukurSidebar(lebarSekarang);
                panelMenu.revalidate();
                panelMenu.repaint();
            }
        });
        t.start();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollSidebar = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JPanel();
        iconDashboard = new javax.swing.JLabel();
        txtDashboard = new javax.swing.JLabel();
        btnJadwal = new javax.swing.JPanel();
        iconJadwal = new javax.swing.JLabel();
        txtJadwal = new javax.swing.JLabel();
        btnAbsensiSaya = new javax.swing.JPanel();
        iconAbsensiSaya = new javax.swing.JLabel();
        txtAbsensiSaya = new javax.swing.JLabel();
        btnAbsensiMapel = new javax.swing.JPanel();
        iconAbsensiMapel = new javax.swing.JLabel();
        txtAbsensiMapel = new javax.swing.JLabel();
        btnPergantianGuru = new javax.swing.JPanel();
        iconPergantian = new javax.swing.JLabel();
        txtPergantian = new javax.swing.JLabel();
        panelHeader = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        iconLogoAplikasi = new javax.swing.JLabel();
        iconGaris = new javax.swing.JLabel();
        panelUser = new javax.swing.JPanel();
        pFotoProfil = new javax.swing.JPanel();
        lUsername = new javax.swing.JLabel();
        btnArrowProfil = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrollSidebar.setInheritsPopupMenu(true);
        scrollSidebar.setMaximumSize(new java.awt.Dimension(256, 32767));
        scrollSidebar.setMinimumSize(new java.awt.Dimension(260, 16));
        scrollSidebar.setPreferredSize(new java.awt.Dimension(264, 100));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelMenu.setMaximumSize(new java.awt.Dimension(250, 196655));
        panelMenu.setMinimumSize(new java.awt.Dimension(250, 652));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 652));
        panelMenu.setLayout(new javax.swing.BoxLayout(panelMenu, javax.swing.BoxLayout.Y_AXIS));

        btnDashboard.setBackground(new java.awt.Color(255, 255, 255));
        btnDashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnDashboard.setMaximumSize(new java.awt.Dimension(32767, 55));
        btnDashboard.setMinimumSize(new java.awt.Dimension(100, 55));
        btnDashboard.setPreferredSize(new java.awt.Dimension(250, 55));
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
        });
        btnDashboard.setLayout(new java.awt.BorderLayout(8, 0));

        iconDashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconDashboard.setMaximumSize(new java.awt.Dimension(37, 37));
        iconDashboard.setMinimumSize(new java.awt.Dimension(37, 37));
        iconDashboard.setPreferredSize(new java.awt.Dimension(37, 37));
        btnDashboard.add(iconDashboard, java.awt.BorderLayout.LINE_START);

        txtDashboard.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtDashboard.setForeground(new java.awt.Color(124, 126, 137));
        txtDashboard.setText("Dashboard");
        btnDashboard.add(txtDashboard, java.awt.BorderLayout.CENTER);

        panelMenu.add(btnDashboard);

        btnJadwal.setBackground(new java.awt.Color(255, 255, 255));
        btnJadwal.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnJadwal.setMaximumSize(new java.awt.Dimension(32767, 55));
        btnJadwal.setMinimumSize(new java.awt.Dimension(100, 55));
        btnJadwal.setPreferredSize(new java.awt.Dimension(250, 55));
        btnJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJadwalMouseClicked(evt);
            }
        });
        btnJadwal.setLayout(new java.awt.BorderLayout(8, 0));

        iconJadwal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconJadwal.setMaximumSize(new java.awt.Dimension(37, 37));
        iconJadwal.setMinimumSize(new java.awt.Dimension(37, 37));
        iconJadwal.setPreferredSize(new java.awt.Dimension(37, 37));
        btnJadwal.add(iconJadwal, java.awt.BorderLayout.LINE_START);

        txtJadwal.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtJadwal.setForeground(new java.awt.Color(124, 126, 137));
        txtJadwal.setText("Jadwal Mangajar");
        btnJadwal.add(txtJadwal, java.awt.BorderLayout.CENTER);

        panelMenu.add(btnJadwal);

        btnAbsensiSaya.setBackground(new java.awt.Color(255, 255, 255));
        btnAbsensiSaya.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnAbsensiSaya.setMaximumSize(new java.awt.Dimension(32767, 55));
        btnAbsensiSaya.setMinimumSize(new java.awt.Dimension(100, 55));
        btnAbsensiSaya.setPreferredSize(new java.awt.Dimension(250, 55));
        btnAbsensiSaya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbsensiSayaMouseClicked(evt);
            }
        });
        btnAbsensiSaya.setLayout(new java.awt.BorderLayout(8, 0));

        iconAbsensiSaya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconAbsensiSaya.setMaximumSize(new java.awt.Dimension(37, 37));
        iconAbsensiSaya.setMinimumSize(new java.awt.Dimension(37, 37));
        iconAbsensiSaya.setPreferredSize(new java.awt.Dimension(37, 37));
        btnAbsensiSaya.add(iconAbsensiSaya, java.awt.BorderLayout.LINE_START);

        txtAbsensiSaya.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtAbsensiSaya.setForeground(new java.awt.Color(124, 126, 137));
        txtAbsensiSaya.setText("Absensi Saya");
        btnAbsensiSaya.add(txtAbsensiSaya, java.awt.BorderLayout.CENTER);

        panelMenu.add(btnAbsensiSaya);

        btnAbsensiMapel.setBackground(new java.awt.Color(255, 255, 255));
        btnAbsensiMapel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnAbsensiMapel.setMaximumSize(new java.awt.Dimension(32767, 55));
        btnAbsensiMapel.setMinimumSize(new java.awt.Dimension(100, 55));
        btnAbsensiMapel.setPreferredSize(new java.awt.Dimension(250, 55));
        btnAbsensiMapel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbsensiMapelMouseClicked(evt);
            }
        });
        btnAbsensiMapel.setLayout(new java.awt.BorderLayout(8, 0));

        iconAbsensiMapel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconAbsensiMapel.setMaximumSize(new java.awt.Dimension(37, 37));
        iconAbsensiMapel.setMinimumSize(new java.awt.Dimension(37, 37));
        iconAbsensiMapel.setPreferredSize(new java.awt.Dimension(37, 37));
        btnAbsensiMapel.add(iconAbsensiMapel, java.awt.BorderLayout.LINE_START);

        txtAbsensiMapel.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtAbsensiMapel.setForeground(new java.awt.Color(124, 126, 137));
        txtAbsensiMapel.setText("Absensi Mapel");
        btnAbsensiMapel.add(txtAbsensiMapel, java.awt.BorderLayout.CENTER);

        panelMenu.add(btnAbsensiMapel);

        btnPergantianGuru.setBackground(new java.awt.Color(255, 255, 255));
        btnPergantianGuru.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnPergantianGuru.setMaximumSize(new java.awt.Dimension(32767, 55));
        btnPergantianGuru.setMinimumSize(new java.awt.Dimension(100, 55));
        btnPergantianGuru.setPreferredSize(new java.awt.Dimension(250, 55));
        btnPergantianGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPergantianGuruMouseClicked(evt);
            }
        });
        btnPergantianGuru.setLayout(new java.awt.BorderLayout(8, 0));

        iconPergantian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconPergantian.setMaximumSize(new java.awt.Dimension(37, 37));
        iconPergantian.setMinimumSize(new java.awt.Dimension(37, 37));
        iconPergantian.setPreferredSize(new java.awt.Dimension(37, 37));
        btnPergantianGuru.add(iconPergantian, java.awt.BorderLayout.LINE_START);

        txtPergantian.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtPergantian.setForeground(new java.awt.Color(124, 126, 137));
        txtPergantian.setText("Pergantian Guru");
        btnPergantianGuru.add(txtPergantian, java.awt.BorderLayout.CENTER);

        panelMenu.add(btnPergantianGuru);

        scrollSidebar.setViewportView(panelMenu);

        getContentPane().add(scrollSidebar, java.awt.BorderLayout.LINE_START);

        panelHeader.setBackground(new java.awt.Color(255, 255, 255));
        panelHeader.setMaximumSize(new java.awt.Dimension(2147483647, 72));
        panelHeader.setMinimumSize(new java.awt.Dimension(1488, 72));
        panelHeader.setPreferredSize(new java.awt.Dimension(1488, 72));
        panelHeader.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        jPanel3.setPreferredSize(new java.awt.Dimension(264, 97));
        jPanel3.setLayout(new java.awt.BorderLayout(16, 0));
        jPanel3.add(iconLogoAplikasi, java.awt.BorderLayout.CENTER);

        iconGaris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconGaris.setPreferredSize(new java.awt.Dimension(36, 36));
        jPanel3.add(iconGaris, java.awt.BorderLayout.WEST);

        panelHeader.add(jPanel3, java.awt.BorderLayout.LINE_START);

        panelUser.setBackground(new java.awt.Color(255, 255, 255));
        panelUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8));
        panelUser.setLayout(new javax.swing.BoxLayout(panelUser, javax.swing.BoxLayout.X_AXIS));

        pFotoProfil.setMaximumSize(new java.awt.Dimension(56, 56));
        pFotoProfil.setMinimumSize(new java.awt.Dimension(56, 56));
        pFotoProfil.setPreferredSize(new java.awt.Dimension(56, 56));
        panelUser.add(pFotoProfil);

        lUsername.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        lUsername.setText("nama yang login");
        lUsername.setMaximumSize(new java.awt.Dimension(400, 30));
        lUsername.setMinimumSize(null);
        lUsername.setPreferredSize(null);
        panelUser.add(lUsername);

        btnArrowProfil.setBorder(null);
        btnArrowProfil.setContentAreaFilled(false);
        btnArrowProfil.setMaximumSize(new java.awt.Dimension(34, 56));
        btnArrowProfil.setMinimumSize(new java.awt.Dimension(34, 56));
        btnArrowProfil.setPreferredSize(new java.awt.Dimension(34, 56));
        btnArrowProfil.addActionListener(this::btnArrowProfilActionPerformed);
        panelUser.add(btnArrowProfil);

        panelHeader.add(panelUser, java.awt.BorderLayout.EAST);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        panelHeader.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.CardLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        // TODO add your handling code here:
        aktifkanMenu(dashboard);
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJadwalMouseClicked
        // TODO add your handling code here:
        aktifkanMenu(jadwalMengajar);
    }//GEN-LAST:event_btnJadwalMouseClicked

    private void btnAbsensiSayaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbsensiSayaMouseClicked
        // TODO add your handling code here:
        aktifkanMenu(absensiSaya);
    }//GEN-LAST:event_btnAbsensiSayaMouseClicked

    private void btnAbsensiMapelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbsensiMapelMouseClicked
        // TODO add your handling code here:
        aktifkanMenu(absensiMapel);
    }//GEN-LAST:event_btnAbsensiMapelMouseClicked

    private void btnPergantianGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPergantianGuruMouseClicked
        // TODO add your handling code here:
        aktifkanMenu(pergantianGuru);
    }//GEN-LAST:event_btnPergantianGuruMouseClicked

    private void btnArrowProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrowProfilActionPerformed
        // TODO add your handling code here:
        tampilMenuUser();
    }//GEN-LAST:event_btnArrowProfilActionPerformed

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
            UIManager.put("Button.arc", 20);
            UIManager.put("Component.arc", 20);
            UIManager.put("Component.borderwidht", 1);
            UIManager.put("Component.borderColor", new Color(0xA0A0A0));
            UIManager.put("PopupMenu.borderCornerRadius", 50); 
            UIManager.put("PopupMenu.background", Color.WHITE);
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new frameGuru().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAbsensiMapel;
    private javax.swing.JPanel btnAbsensiSaya;
    private javax.swing.JButton btnArrowProfil;
    private javax.swing.JPanel btnDashboard;
    private javax.swing.JPanel btnJadwal;
    private javax.swing.JPanel btnPergantianGuru;
    private javax.swing.JLabel iconAbsensiMapel;
    private javax.swing.JLabel iconAbsensiSaya;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconGaris;
    private javax.swing.JLabel iconJadwal;
    private javax.swing.JLabel iconLogoAplikasi;
    private javax.swing.JLabel iconPergantian;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lUsername;
    private javax.swing.JPanel pFotoProfil;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelUser;
    private javax.swing.JScrollPane scrollSidebar;
    private javax.swing.JLabel txtAbsensiMapel;
    private javax.swing.JLabel txtAbsensiSaya;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtJadwal;
    private javax.swing.JLabel txtPergantian;
    // End of variables declaration//GEN-END:variables
}
