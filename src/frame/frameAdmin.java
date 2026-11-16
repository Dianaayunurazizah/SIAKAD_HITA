/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import card.subAbsensiAdmin;
import card.subAkademikAdmin;
import card.subLaporanAdmin;
import card.subMasterAdmin;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import custom.PanelCustom;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ASUS
 */
public class frameAdmin extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frameAdmin.class.getName());

    private PanelCustom dashboard, master, akademik, absensi, laporan, pengaturan;
    private PanelCustom[] semuaMenu;

    private subMasterAdmin subMaster;
    private boolean subMasterTerbuka = false;

    private subAkademikAdmin subAkademik;
    private boolean subAkademikTerbuka = false;
    
    private subAbsensiAdmin subAbsensi;
    private boolean subAbsensiTerbuka = false;
    
    private subLaporanAdmin subLaporan;
    private boolean subLaporanTerbuka = false;
    

    /**
     * Creates new form frameAdmin
     */
    public frameAdmin() {
        initComponents();

        panelSidebar();
        
        radiusPanel();
    }

    private void panelSidebar() {
        
        iconLogoAplikasi.setIcon(new FlatSVGIcon("iconSidebar/logoaplikasi_sidebar.svg", 185, 34));
        iconGaris.setIcon(new FlatSVGIcon("iconSidebar/garis3.svg", 32, 32));

        dashboard = new PanelCustom(iconDashboard, txtDashboard, btnDashboard);
        dashboard.setIconNormal(new FlatSVGIcon("iconSidebar/dashboard_normal.svg", 24, 24));
        dashboard.setIconAktif(new FlatSVGIcon("iconSidebar/dashboard_aktif.svg", 24, 24));

        master = new PanelCustom(iconMaster, txtMaster, arrowMaster, btnMaster);
        master.setIconNormal(new FlatSVGIcon("iconSidebar/master_normal.svg", 24, 24));
        master.setIconAktif(new FlatSVGIcon("iconSidebar/master_aktif.svg", 24, 24));
        master.setArrowNormal(new FlatSVGIcon("iconSidebar/arrow_normal.svg", 24, 24));
        master.setArrowAktif(new FlatSVGIcon("iconSidebar/arrow_aktif.svg", 24, 24));
        master.setWarnaAktif(new Color(224, 231, 255));
        master.setTeksAktif(new Color(55, 48, 163));

        akademik = new PanelCustom(iconAkademik, txtAkademik, arrowAkademik, btnAkademik);
        akademik.setIconNormal(new FlatSVGIcon("iconSidebar/akademik_normal.svg", 24, 24));
        akademik.setIconAktif(new FlatSVGIcon("iconSidebar/akademik_aktif.svg", 24, 24));
        akademik.setArrowNormal(new FlatSVGIcon("iconSidebar/arrow_normal.svg", 24, 24));
        akademik.setArrowAktif(new FlatSVGIcon("iconSidebar/arrow_aktif.svg", 24, 24));
        akademik.setWarnaAktif(new Color(224, 231, 255));
        akademik.setTeksAktif(new Color(55, 48, 163));

        absensi = new PanelCustom(iconAbsensi, txtAbsensi, arrowAbsensi, btnAbsensi);
        absensi.setIconNormal(new FlatSVGIcon("iconSidebar/absensi_normal.svg", 24, 24));
        absensi.setIconAktif(new FlatSVGIcon("iconSidebar/absensi_aktif.svg", 24, 24));
        absensi.setArrowNormal(new FlatSVGIcon("iconSidebar/arrow_normal.svg", 24, 24));
        absensi.setArrowAktif(new FlatSVGIcon("iconSidebar/arrow_aktif.svg", 24, 24));
        absensi.setWarnaAktif(new Color(224, 231, 255));
        absensi.setTeksAktif(new Color(55, 48, 163));

        laporan = new PanelCustom(iconLaporan, txtLaporan, arrowLaporan, btnLaporan);
        laporan.setIconNormal(new FlatSVGIcon("iconSidebar/laporan_normal.svg", 24, 24));
        laporan.setIconAktif(new FlatSVGIcon("iconSidebar/laporan_aktif.svg", 24, 24));
        laporan.setArrowNormal(new FlatSVGIcon("iconSidebar/arrow_normal.svg", 24, 24));
        laporan.setArrowAktif(new FlatSVGIcon("iconSidebar/arrow_aktif.svg", 24, 24));
        laporan.setWarnaAktif(new Color(224, 231, 255));
        laporan.setTeksAktif(new Color(55, 48, 163));

        pengaturan = new PanelCustom(iconPengaturan, txtPengaturan, arrowPengaturan, btnPengaturan);
        pengaturan.setIconNormal(new FlatSVGIcon("iconSidebar/pengaturan_normal.svg", 24, 24));
        pengaturan.setIconAktif(new FlatSVGIcon("iconSidebar/pengaturan_aktif.svg", 24, 24));
        pengaturan.setArrowNormal(new FlatSVGIcon("iconSidebar/arrow_normal.svg", 24, 24));
        pengaturan.setArrowAktif(new FlatSVGIcon("iconSidebar/arrow_aktif.svg", 24, 24));
        pengaturan.setWarnaAktif(new Color(224, 231, 255));
        pengaturan.setTeksAktif(new Color(55, 48, 163));

        semuaMenu = new PanelCustom[]{
            dashboard, master, akademik, absensi, laporan, pengaturan
        };

        //submenu master
        subMaster = new subMasterAdmin();
        subMaster.setVisible(false);
        panelMenu.add(subMaster, panelMenu.getComponentZOrder(btnMaster) + 1);

        pasangKlikSub(subMaster.getBtnGuru(), "guru");
        pasangKlikSub(subMaster.getBtnKelas(), "kelas");
        pasangKlikSub(subMaster.getBtnSiswa(), "siswa");
        pasangKlikSub(subMaster.getBtnMapel(), "mapel");
        pasangKlikSub(subMaster.getBtnTahun(), "tahun");
        pasangKlikSub(subMaster.getBtnGenerate(), "generate");

        //submenu akademik
        subAkademik = new subAkademikAdmin();
        subAkademik.setVisible(false);
        panelMenu.add(subAkademik, panelMenu.getComponentZOrder(btnAkademik) + 1);

        pasangKlikSub(subAkademik.getBtnWali(), "wali");
        pasangKlikSub(subAkademik.getBtnPenugasan(), "penugasan");
        pasangKlikSub(subAkademik.getBtnJadwal(), "jadwal");
        pasangKlikSub(subAkademik.getBtnKenaikan(), "kenaikan");
        
        //submenu akademik
        subAbsensi = new subAbsensiAdmin();
        subAbsensi.setVisible(false);
        panelMenu.add(subAbsensi, panelMenu.getComponentZOrder(btnAbsensi) + 1);

        pasangKlikSub(subAbsensi.getBtnAbsensiGuru(), "absensi guru");
        pasangKlikSub(subAbsensi.getBtnAbsensiQr(), "absensi qr");
        pasangKlikSub(subAbsensi.getBtnAbsensiMapel(), "absensi mapel");
        pasangKlikSub(subAbsensi.getBtnPergantianGuru(), "pergantian guru");
        
        subLaporan = new subLaporanAdmin();
        subAbsensi.setVisible(false);
        panelMenu.add(subLaporan, panelMenu.getComponentZOrder(btnLaporan) + 1);
        
        pasangKlikSub(subLaporan.getBtnLaporanGuru(), "laporan guru");
        pasangKlikSub(subLaporan.getBtnLaporanSiswa(), "laporan siswa");
        
        aktifkanMenu(dashboard);
    }

    private void tutupSemuaSub() {
        subMaster.setVisible(false);
        subMasterTerbuka = false;
        subMaster.resetAktifMaster();

        subAkademik.setVisible(false);
        subAkademikTerbuka = false;
        subAkademik.resetAktifAkademik();
        
        subAbsensi.setVisible(false);
        subAbsensiTerbuka = false;
        subAbsensi.resetAktifAbsensi();
        
        subLaporan.setVisible(false);
        subLaporanTerbuka = false;
        subLaporan.resetAktifLaporan();
    }

    private void refreshSidebar() {
        panelMenu.revalidate();
        panelMenu.repaint();
    }

    // buka/tutup submenu Master
    private void toggleSubMaster() {
        boolean sedangTerbuka = subMasterTerbuka;
        tutupSemuaSub();

        if (sedangTerbuka) {
            master.setAktif(false);          // klik lagi = menutup
        } else {
            subMasterTerbuka = true;
            subMaster.setVisible(true);
            aktifkanSubMenu("guru");
        }
        refreshSidebar();
    }

    private void toggleSubAkademik() {
        boolean sedangTerbuka = subAkademikTerbuka;
        tutupSemuaSub();

        if (sedangTerbuka) {
            akademik.setAktif(false);
        } else {
            subAkademikTerbuka = true;
            subAkademik.setVisible(true);
            aktifkanSubMenu("wali");
        }
        refreshSidebar();
    }

    private void toggleSubAbsensi() {
        boolean sedangTerbuka = subAbsensiTerbuka;
        tutupSemuaSub();

        if (sedangTerbuka) {
            absensi.setAktif(false);
        } else {
            subAbsensiTerbuka = true;
            subAbsensi.setVisible(true);
            aktifkanSubMenu("absensi guru");
        }
        refreshSidebar();
    }
    
    private void toggleSubLaporan() {
        boolean sedangTerbuka = subLaporanTerbuka;
        tutupSemuaSub();

        if (sedangTerbuka) {
            laporan.setAktif(false);
        } else {
            subLaporanTerbuka = true;
            subLaporan.setVisible(true);
            aktifkanSubMenu("laporan guru");
        }
        refreshSidebar();
    }

    // saat submenu diklik
    private void aktifkanSubMenu(String nama) {

        // menu utama (termasuk Master) jadi tidak aktif
        for (PanelCustom menu : semuaMenu) {
            menu.setAktif(false);
        }

        // submenu: reset semua, lalu aktifkan yang dipilih
        subMaster.resetAktifMaster();
        subAkademik.resetAktifAkademik();
        subAbsensi.resetAktifAbsensi();
        subLaporan.resetAktifLaporan();

        switch (nama) {
            //Master
            case "guru":
                master.setAktif(true);
                subMaster.getGuru().setAktif(true);
                // tampilkan halaman guru
                break;
            case "kelas":
                master.setAktif(true);
                subMaster.getKelas().setAktif(true);
                break;
            case "siswa":
                master.setAktif(true);
                subMaster.getSiswa().setAktif(true);
                break;
            case "mapel":
                master.setAktif(true);
                subMaster.getMapel().setAktif(true);
                break;
            case "tahun":
                master.setAktif(true);
                subMaster.getTahun().setAktif(true);
                break;
            case "generate":
                master.setAktif(true);
                subMaster.getGenerate().setAktif(true);
                break;

            //Akademik    
            case "wali":
                akademik.setAktif(true);
                subAkademik.getWali().setAktif(true);
                break;
            case "penugasan":
                akademik.setAktif(true);
                subAkademik.getPenugasan().setAktif(true);
                break;
            case "jadwal":
                akademik.setAktif(true);
                subAkademik.getJadwal().setAktif(true);
                break;
            case "kenaikan":
                akademik.setAktif(true);
                subAkademik.getKenaikan().setAktif(true);
                break;
                
            //Absensi   
            case "absensi guru":
                absensi.setAktif(true);
                subAbsensi.getAbsensiGuru().setAktif(true);
                break;
            case "absensi qr":
                absensi.setAktif(true);
                subAbsensi.getAbsensiQr().setAktif(true);
                break;
            case "absensi mapel":
                absensi.setAktif(true);
                subAbsensi.getAbsensiMapel().setAktif(true);
                break;
            case "pergantian guru":
                absensi.setAktif(true);
                subAbsensi.getPergantianGuru().setAktif(true);
                break;
                
            //laporan
            case "laporan guru":
                laporan.setAktif(true);
                subLaporan.getLaporanGuru().setAktif(true);
                break;
            case "laporan siswa":
                laporan.setAktif(true);
                subLaporan.getLaporanSiswa().setAktif(true);
                break;
        }
    }

    // memasang klik ke tombol submenu
    private void pasangKlikSub(javax.swing.JPanel tombol, String nama) {
        tombol.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aktifkanSubMenu(nama);
            }
        });
    }

    // menu tanpa submenu (Dashboard, Absensi, Laporan, Pengaturan)
    private void aktifkanMenu(PanelCustom menuAktif) {
        for (PanelCustom menu : semuaMenu) {
            menu.setAktif(menu == menuAktif);
        }
        tutupSemuaSub();
        refreshSidebar();
    }

    private void radiusPanel(){
        btnDashboard.putClientProperty("FlatLaf.style", "arc: 25");
        btnMaster.putClientProperty("FlatLaf.style", "arc: 25");
        btnAkademik.putClientProperty("FlatLaf.style", "arc: 25");
        btnAbsensi.putClientProperty("FlatLaf.style", "arc: 25");
        btnLaporan.putClientProperty("FlatLaf.style", "arc: 25");
        btnPengaturan.putClientProperty("FlatLaf.style", "arc: 25");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        iconLogoAplikasi = new javax.swing.JLabel();
        iconGaris = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JPanel();
        iconDashboard = new javax.swing.JLabel();
        txtDashboard = new javax.swing.JLabel();
        btnMaster = new javax.swing.JPanel();
        iconMaster = new javax.swing.JLabel();
        arrowMaster = new javax.swing.JLabel();
        txtMaster = new javax.swing.JLabel();
        btnAkademik = new javax.swing.JPanel();
        iconAkademik = new javax.swing.JLabel();
        arrowAkademik = new javax.swing.JLabel();
        txtAkademik = new javax.swing.JLabel();
        btnAbsensi = new javax.swing.JPanel();
        iconAbsensi = new javax.swing.JLabel();
        arrowAbsensi = new javax.swing.JLabel();
        txtAbsensi = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JPanel();
        iconLaporan = new javax.swing.JLabel();
        arrowLaporan = new javax.swing.JLabel();
        txtLaporan = new javax.swing.JLabel();
        btnPengaturan = new javax.swing.JPanel();
        iconPengaturan = new javax.swing.JLabel();
        arrowPengaturan = new javax.swing.JLabel();
        txtPengaturan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 72));
        jPanel4.setMinimumSize(new java.awt.Dimension(1488, 72));
        jPanel4.setPreferredSize(new java.awt.Dimension(1488, 72));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        jPanel3.setPreferredSize(new java.awt.Dimension(264, 97));
        jPanel3.setLayout(new java.awt.BorderLayout(16, 0));
        jPanel3.add(iconLogoAplikasi, java.awt.BorderLayout.CENTER);

        iconGaris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconGaris.setPreferredSize(new java.awt.Dimension(36, 36));
        jPanel3.add(iconGaris, java.awt.BorderLayout.WEST);

        jPanel4.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 8, 16));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel6.setPreferredSize(new java.awt.Dimension(56, 56));
        jPanel5.add(jPanel6, java.awt.BorderLayout.WEST);

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel1, java.awt.BorderLayout.EAST);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setInheritsPopupMenu(true);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(256, 32767));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(260, 16));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(264, 100));

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

        btnMaster.setBackground(new java.awt.Color(255, 255, 255));
        btnMaster.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnMaster.setMaximumSize(new java.awt.Dimension(32767, 55));
        btnMaster.setMinimumSize(new java.awt.Dimension(100, 55));
        btnMaster.setPreferredSize(new java.awt.Dimension(250, 55));
        btnMaster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMasterMouseClicked(evt);
            }
        });
        btnMaster.setLayout(new java.awt.BorderLayout(8, 0));

        iconMaster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconMaster.setMaximumSize(new java.awt.Dimension(37, 37));
        iconMaster.setMinimumSize(new java.awt.Dimension(37, 37));
        iconMaster.setPreferredSize(new java.awt.Dimension(37, 37));
        btnMaster.add(iconMaster, java.awt.BorderLayout.LINE_START);

        arrowMaster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowMaster.setMaximumSize(new java.awt.Dimension(37, 37));
        arrowMaster.setMinimumSize(new java.awt.Dimension(37, 37));
        arrowMaster.setPreferredSize(new java.awt.Dimension(37, 37));
        btnMaster.add(arrowMaster, java.awt.BorderLayout.LINE_END);

        txtMaster.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtMaster.setForeground(new java.awt.Color(124, 126, 137));
        txtMaster.setText("Master Data");
        btnMaster.add(txtMaster, java.awt.BorderLayout.CENTER);

        panelMenu.add(btnMaster);

        btnAkademik.setBackground(new java.awt.Color(255, 255, 255));
        btnAkademik.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnAkademik.setMaximumSize(new java.awt.Dimension(32767, 55));
        btnAkademik.setMinimumSize(new java.awt.Dimension(100, 55));
        btnAkademik.setPreferredSize(new java.awt.Dimension(250, 55));
        btnAkademik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAkademikMouseClicked(evt);
            }
        });
        btnAkademik.setLayout(new java.awt.BorderLayout(8, 0));

        iconAkademik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconAkademik.setMaximumSize(new java.awt.Dimension(37, 37));
        iconAkademik.setMinimumSize(new java.awt.Dimension(37, 37));
        iconAkademik.setPreferredSize(new java.awt.Dimension(37, 37));
        btnAkademik.add(iconAkademik, java.awt.BorderLayout.LINE_START);

        arrowAkademik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowAkademik.setMaximumSize(new java.awt.Dimension(37, 37));
        arrowAkademik.setMinimumSize(new java.awt.Dimension(37, 37));
        arrowAkademik.setPreferredSize(new java.awt.Dimension(37, 37));
        btnAkademik.add(arrowAkademik, java.awt.BorderLayout.LINE_END);

        txtAkademik.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtAkademik.setForeground(new java.awt.Color(124, 126, 137));
        txtAkademik.setText("Akademik");
        btnAkademik.add(txtAkademik, java.awt.BorderLayout.CENTER);

        panelMenu.add(btnAkademik);

        btnAbsensi.setBackground(new java.awt.Color(255, 255, 255));
        btnAbsensi.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnAbsensi.setMaximumSize(new java.awt.Dimension(32767, 55));
        btnAbsensi.setMinimumSize(new java.awt.Dimension(100, 55));
        btnAbsensi.setPreferredSize(new java.awt.Dimension(250, 55));
        btnAbsensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbsensiMouseClicked(evt);
            }
        });
        btnAbsensi.setLayout(new java.awt.BorderLayout(8, 0));

        iconAbsensi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconAbsensi.setMaximumSize(new java.awt.Dimension(37, 37));
        iconAbsensi.setMinimumSize(new java.awt.Dimension(37, 37));
        iconAbsensi.setPreferredSize(new java.awt.Dimension(37, 37));
        btnAbsensi.add(iconAbsensi, java.awt.BorderLayout.LINE_START);

        arrowAbsensi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowAbsensi.setMaximumSize(new java.awt.Dimension(37, 37));
        arrowAbsensi.setMinimumSize(new java.awt.Dimension(37, 37));
        arrowAbsensi.setPreferredSize(new java.awt.Dimension(37, 37));
        btnAbsensi.add(arrowAbsensi, java.awt.BorderLayout.LINE_END);

        txtAbsensi.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtAbsensi.setForeground(new java.awt.Color(124, 126, 137));
        txtAbsensi.setText("Absensi");
        btnAbsensi.add(txtAbsensi, java.awt.BorderLayout.CENTER);

        panelMenu.add(btnAbsensi);

        btnLaporan.setBackground(new java.awt.Color(255, 255, 255));
        btnLaporan.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnLaporan.setMaximumSize(new java.awt.Dimension(32767, 55));
        btnLaporan.setMinimumSize(new java.awt.Dimension(100, 55));
        btnLaporan.setPreferredSize(new java.awt.Dimension(250, 55));
        btnLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaporanMouseClicked(evt);
            }
        });
        btnLaporan.setLayout(new java.awt.BorderLayout(8, 0));

        iconLaporan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLaporan.setMaximumSize(new java.awt.Dimension(37, 37));
        iconLaporan.setMinimumSize(new java.awt.Dimension(37, 37));
        iconLaporan.setPreferredSize(new java.awt.Dimension(37, 37));
        btnLaporan.add(iconLaporan, java.awt.BorderLayout.LINE_START);

        arrowLaporan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowLaporan.setMaximumSize(new java.awt.Dimension(37, 37));
        arrowLaporan.setMinimumSize(new java.awt.Dimension(37, 37));
        arrowLaporan.setPreferredSize(new java.awt.Dimension(37, 37));
        btnLaporan.add(arrowLaporan, java.awt.BorderLayout.LINE_END);

        txtLaporan.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtLaporan.setForeground(new java.awt.Color(124, 126, 137));
        txtLaporan.setText("Laporan");
        btnLaporan.add(txtLaporan, java.awt.BorderLayout.CENTER);

        panelMenu.add(btnLaporan);

        btnPengaturan.setBackground(new java.awt.Color(255, 255, 255));
        btnPengaturan.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnPengaturan.setMaximumSize(new java.awt.Dimension(32767, 55));
        btnPengaturan.setMinimumSize(new java.awt.Dimension(100, 55));
        btnPengaturan.setPreferredSize(new java.awt.Dimension(250, 55));
        btnPengaturan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPengaturanMouseClicked(evt);
            }
        });
        btnPengaturan.setLayout(new java.awt.BorderLayout(8, 0));

        iconPengaturan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconPengaturan.setMaximumSize(new java.awt.Dimension(37, 37));
        iconPengaturan.setMinimumSize(new java.awt.Dimension(37, 37));
        iconPengaturan.setPreferredSize(new java.awt.Dimension(37, 37));
        btnPengaturan.add(iconPengaturan, java.awt.BorderLayout.LINE_START);

        arrowPengaturan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowPengaturan.setMaximumSize(new java.awt.Dimension(37, 37));
        arrowPengaturan.setMinimumSize(new java.awt.Dimension(37, 37));
        arrowPengaturan.setPreferredSize(new java.awt.Dimension(37, 37));
        btnPengaturan.add(arrowPengaturan, java.awt.BorderLayout.LINE_END);

        txtPengaturan.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtPengaturan.setForeground(new java.awt.Color(124, 126, 137));
        txtPengaturan.setText("Pengaturan");
        btnPengaturan.add(txtPengaturan, java.awt.BorderLayout.CENTER);

        panelMenu.add(btnPengaturan);

        jScrollPane2.setViewportView(panelMenu);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        // TODO add your handling code here:
        aktifkanMenu(dashboard);
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnMasterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasterMouseClicked
        // TODO add your handling code here:
        toggleSubMaster();
    }//GEN-LAST:event_btnMasterMouseClicked

    private void btnAkademikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAkademikMouseClicked
        // TODO add your handling code here:
        toggleSubAkademik();
    }//GEN-LAST:event_btnAkademikMouseClicked

    private void btnAbsensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbsensiMouseClicked
        // TODO add your handling code here:
        toggleSubAbsensi();
    }//GEN-LAST:event_btnAbsensiMouseClicked

    private void btnLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseClicked
        // TODO add your handling code here:
        toggleSubLaporan();
    }//GEN-LAST:event_btnLaporanMouseClicked

    private void btnPengaturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengaturanMouseClicked
        // TODO add your handling code here:
        aktifkanMenu(pengaturan);
    }//GEN-LAST:event_btnPengaturanMouseClicked

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
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new frameAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arrowAbsensi;
    private javax.swing.JLabel arrowAkademik;
    private javax.swing.JLabel arrowLaporan;
    private javax.swing.JLabel arrowMaster;
    private javax.swing.JLabel arrowPengaturan;
    private javax.swing.JPanel btnAbsensi;
    private javax.swing.JPanel btnAkademik;
    private javax.swing.JPanel btnDashboard;
    private javax.swing.JPanel btnLaporan;
    private javax.swing.JPanel btnMaster;
    private javax.swing.JPanel btnPengaturan;
    private javax.swing.JLabel iconAbsensi;
    private javax.swing.JLabel iconAkademik;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconGaris;
    private javax.swing.JLabel iconLaporan;
    private javax.swing.JLabel iconLogoAplikasi;
    private javax.swing.JLabel iconMaster;
    private javax.swing.JLabel iconPengaturan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JLabel txtAbsensi;
    private javax.swing.JLabel txtAkademik;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtLaporan;
    private javax.swing.JLabel txtMaster;
    private javax.swing.JLabel txtPengaturan;
    // End of variables declaration//GEN-END:variables
}
