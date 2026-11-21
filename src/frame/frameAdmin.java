/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import card.cardPenggunaHeader;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import custom.PanelCustom;
import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import panelMasterAdmin.dashboard;
import panelMasterAdmin.panelGuru;
import panelMasterAdmin.panelGenerate;
import panelMasterAdmin.panelKelas;
import panelMasterAdmin.panelMapel;
import panelMasterAdmin.panelSiswa;
import panelMasterAdmin.panelTahun;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPopupMenu;

/**
 *
 * @author ASUS
 */
public class frameAdmin extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frameAdmin.class.getName());

    private CardLayout cardLayout;

    private PanelCustom dashboard, master, akademik, absensi, laporan, pengaturan,
            guru, kelas, siswa, mapel, tahun, generate,
            wali, penugasan, jadwal, kenaikan,
            absensiGuru, absensiQR, absensiMapel, pergantianGuru,
            laporanGuru, laporanSiswa;
    private PanelCustom[] semuaMenu;

    private static class SubItem {

        String nama;
        PanelCustom induk;
        PanelCustom panel;

        SubItem(String nama, PanelCustom induk, PanelCustom panel) {
            this.nama = nama;
            this.induk = induk;
            this.panel = panel;
        }
    }

    private final ArrayList<SubItem> daftarSub = new ArrayList<>();   // semua item submenu
    private ArrayList<JPanel> grupSub;

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
     * Creates new form frameAdmin
     */
    public frameAdmin() {
        initComponents();

        inisiasiPanel();
        panelSidebar();
        setupGarisSidebar();
        radiusPanel();

        panelUser.add(Box.createHorizontalStrut(12), 1);
        panelUser.add(Box.createHorizontalStrut(8), 3);
    }

    private void radiusPanel() {
        pFotoProfil.putClientProperty("FlatLaf.style", "arc: 100");
        
        btnDashboard.putClientProperty("FlatLaf.style", "arc: 25");
        btnMaster.putClientProperty("FlatLaf.style", "arc: 25");
        btnGuru.putClientProperty("FlatLaf.style", "arc: 25");
        btnKelas.putClientProperty("FlatLaf.style", "arc: 25");
        btnSiswa.putClientProperty("FlatLaf.style", "arc: 25");
        btnMapel.putClientProperty("FlatLaf.style", "arc: 25");
        btnTahun.putClientProperty("FlatLaf.style", "arc: 25");
        btnGenerate.putClientProperty("FlatLaf.style", "arc: 25");
        btnAkademik.putClientProperty("FlatLaf.style", "arc: 25");
        btnAbsensi.putClientProperty("FlatLaf.style", "arc: 25");
        btnLaporan.putClientProperty("FlatLaf.style", "arc: 25");
        btnPengaturan.putClientProperty("FlatLaf.style", "arc: 25");
    }

    private void panelSidebar() {

        iconLogoAplikasi.setIcon(new FlatSVGIcon("iconSidebar/logoaplikasi_sidebar.svg", 185, 34));
        iconGaris.setIcon(new FlatSVGIcon("iconSidebar/garis3.svg", 32, 32));

        btnArrowProfil.setIcon(new FlatSVGIcon("iconSidebar/panahPengguna_normal.svg", 24, 24));
        btnArrowProfil.setSelectedIcon(new FlatSVGIcon("iconSidebar/panahPengguna_aktif.svg", 24, 24));

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

        guru = new PanelCustom(iconGuru, txtGuru, btnGuru);
        guru.setIconNormal(new FlatSVGIcon("iconSidebar/guru_normal.svg", 24, 24));
        guru.setIconAktif(new FlatSVGIcon("iconSidebar/guru_aktif.svg", 24, 24));

        kelas = new PanelCustom(iconKelas, txtKelas, btnKelas);
        kelas.setIconNormal(new FlatSVGIcon("iconSidebar/kelas_normal.svg", 24, 24));
        kelas.setIconAktif(new FlatSVGIcon("iconSidebar/kelas_aktif.svg", 24, 24));

        siswa = new PanelCustom(iconSiswa, txtSiswa, btnSiswa);
        siswa.setIconNormal(new FlatSVGIcon("iconSidebar/siswa_normal.svg", 24, 24));
        siswa.setIconAktif(new FlatSVGIcon("iconSidebar/siswa_aktif.svg", 24, 24));

        mapel = new PanelCustom(iconMapel, txtMapel, btnMapel);
        mapel.setIconNormal(new FlatSVGIcon("iconSidebar/mapel_normal.svg", 24, 24));
        mapel.setIconAktif(new FlatSVGIcon("iconSidebar/mapel_aktif.svg", 24, 24));

        tahun = new PanelCustom(iconTahun, txtTahun, btnTahun);
        tahun.setIconNormal(new FlatSVGIcon("iconSidebar/tahun_normal.svg", 24, 24));
        tahun.setIconAktif(new FlatSVGIcon("iconSidebar/tahun_aktif.svg", 24, 24));

        generate = new PanelCustom(iconGenerate, txtGenerate, btnGenerate);
        generate.setIconNormal(new FlatSVGIcon("iconSidebar/generate_normal.svg", 24, 24));
        generate.setIconAktif(new FlatSVGIcon("iconSidebar/generate_aktif.svg", 24, 24));

        akademik = new PanelCustom(iconAkademik, txtAkademik, arrowAkademik, btnAkademik);
        akademik.setIconNormal(new FlatSVGIcon("iconSidebar/akademik_normal.svg", 24, 24));
        akademik.setIconAktif(new FlatSVGIcon("iconSidebar/akademik_aktif.svg", 24, 24));
        akademik.setArrowNormal(new FlatSVGIcon("iconSidebar/arrow_normal.svg", 24, 24));
        akademik.setArrowAktif(new FlatSVGIcon("iconSidebar/arrow_aktif.svg", 24, 24));
        akademik.setWarnaAktif(new Color(224, 231, 255));
        akademik.setTeksAktif(new Color(55, 48, 163));

        wali = new PanelCustom(iconWali, txtWali, btnWali);
        wali.setIconNormal(new FlatSVGIcon("iconSidebar/wali_normal.svg", 24, 24));
        wali.setIconAktif(new FlatSVGIcon("iconSidebar/wali_aktif.svg", 24, 24));

        penugasan = new PanelCustom(iconPenugasan, txtPenugasan, btnPenugasan);
        penugasan.setIconNormal(new FlatSVGIcon("iconSidebar/penugasan_normal.svg", 24, 24));
        penugasan.setIconAktif(new FlatSVGIcon("iconSidebar/penugasan_aktif.svg", 24, 24));

        jadwal = new PanelCustom(iconJadwal, txtJadwal, btnJadwal);
        jadwal.setIconNormal(new FlatSVGIcon("iconSidebar/jadwal_normal.svg", 24, 24));
        jadwal.setIconAktif(new FlatSVGIcon("iconSidebar/jadwal_aktif.svg", 24, 24));

        kenaikan = new PanelCustom(iconKenaikan, txtKenaikan, btnKenaikan);
        kenaikan.setIconNormal(new FlatSVGIcon("iconSidebar/kenaikan_normal.svg", 24, 24));
        kenaikan.setIconAktif(new FlatSVGIcon("iconSidebar/kenaikan_aktif.svg", 24, 24));

        absensi = new PanelCustom(iconAbsensi, txtAbsensi, arrowAbsensi, btnAbsensi);
        absensi.setIconNormal(new FlatSVGIcon("iconSidebar/absensi_normal.svg", 24, 24));
        absensi.setIconAktif(new FlatSVGIcon("iconSidebar/absensi_aktif.svg", 24, 24));
        absensi.setArrowNormal(new FlatSVGIcon("iconSidebar/arrow_normal.svg", 24, 24));
        absensi.setArrowAktif(new FlatSVGIcon("iconSidebar/arrow_aktif.svg", 24, 24));
        absensi.setWarnaAktif(new Color(224, 231, 255));
        absensi.setTeksAktif(new Color(55, 48, 163));
        
        absensiGuru = new PanelCustom(iconAbsensiGuru, txtAbsensiGuru, btnAbsensiGuru);
        absensiGuru.setIconNormal(new FlatSVGIcon("iconSidebar/abguru_normal.svg", 24, 24));
        absensiGuru.setIconAktif(new FlatSVGIcon("iconSidebar/abguru_aktif.svg", 24, 24));

        absensiQR = new PanelCustom(iconQR, txtQR, btnQR);
        absensiQR.setIconNormal(new FlatSVGIcon("iconSidebar/abqr_normal.svg", 24, 24));
        absensiQR.setIconAktif(new FlatSVGIcon("iconSidebar/abqr_aktif.svg", 24, 24));

        absensiMapel = new PanelCustom(iconAbsensiMapel, txtAbsensiMapel, btnAbsensiMapel);
        absensiMapel.setIconNormal(new FlatSVGIcon("iconSidebar/abmapel_normal.svg", 24, 24));
        absensiMapel.setIconAktif(new FlatSVGIcon("iconSidebar/abmapel_aktif.svg", 24, 24));

        pergantianGuru = new PanelCustom(iconPergantianGuru, txtPergantianGuru, btnPergantianGuru);
        pergantianGuru.setIconNormal(new FlatSVGIcon("iconSidebar/pergantian_normal.svg", 24, 24));
        pergantianGuru.setIconAktif(new FlatSVGIcon("iconSidebar/pergantian_aktif.svg", 24, 24));

        laporan = new PanelCustom(iconLaporan, txtLaporan, arrowLaporan, btnLaporan);
        laporan.setIconNormal(new FlatSVGIcon("iconSidebar/laporan_normal.svg", 24, 24));
        laporan.setIconAktif(new FlatSVGIcon("iconSidebar/laporan_aktif.svg", 24, 24));
        laporan.setArrowNormal(new FlatSVGIcon("iconSidebar/arrow_normal.svg", 24, 24));
        laporan.setArrowAktif(new FlatSVGIcon("iconSidebar/arrow_aktif.svg", 24, 24));
        laporan.setWarnaAktif(new Color(224, 231, 255));
        laporan.setTeksAktif(new Color(55, 48, 163));

        laporanGuru = new PanelCustom(iconLaporanGuru, txtLaporanGuru, btnLaporanGuru);
        laporanGuru.setIconNormal(new FlatSVGIcon("iconSidebar/lapguru_normal.svg", 24, 24));
        laporanGuru.setIconAktif(new FlatSVGIcon("iconSidebar/lapguru_aktif.svg", 24, 24));

        laporanSiswa = new PanelCustom(iconLaporanSiswa, txtLaporanSiswa, btnLaporanSiswa);
        laporanSiswa.setIconNormal(new FlatSVGIcon("iconSidebar/lapsiswa_normal.svg", 24, 24));
        laporanSiswa.setIconAktif(new FlatSVGIcon("iconSidebar/lapsiswa_aktif.svg", 24, 24));

        pengaturan = new PanelCustom(iconPengaturan, txtPengaturan, arrowPengaturan, btnPengaturan);
        pengaturan.setIconNormal(new FlatSVGIcon("iconSidebar/pengaturan_normal.svg", 24, 24));
        pengaturan.setIconAktif(new FlatSVGIcon("iconSidebar/pengaturan_aktif.svg", 24, 24));
        pengaturan.setArrowNormal(new FlatSVGIcon("iconSidebar/arrow_normal.svg", 24, 24));
        pengaturan.setArrowAktif(new FlatSVGIcon("iconSidebar/arrow_aktif.svg", 24, 24));
        pengaturan.setWarnaAktif(new Color(224, 231, 255));
        pengaturan.setTeksAktif(new Color(55, 48, 163));

        semuaMenu = new PanelCustom[]{
            dashboard, master, akademik, absensi, laporan, pengaturan,
            guru, kelas, siswa, mapel, tahun, generate,
            wali, penugasan, jadwal, kenaikan,
            absensiGuru, absensiQR, absensiMapel, pergantianGuru
        };

        // daftar grup submenu, lalu sembunyikan semuanya
        grupSub = new ArrayList<>(Arrays.asList(pMaster, pAkademik, pAbsensi, pLaporan));
        for (JPanel g : grupSub) {
            g.setVisible(false);
        }

        buatSub("guru", master, guru, btnGuru);
        buatSub("kelas", master, kelas, btnKelas);
        buatSub("siswa", master, siswa, btnSiswa);
        buatSub("mapel", master, mapel, btnMapel);
        buatSub("tahun", master, tahun, btnTahun);
        buatSub("generate", master, generate, btnGenerate);

        buatSub("wali", akademik, wali, btnWali);
        buatSub("penugasan", akademik, penugasan, btnPenugasan);
        buatSub("jadwal", akademik, jadwal, btnJadwal);
        buatSub("kenaikan", akademik, kenaikan, btnKenaikan);
        
        buatSub("absensi guru", absensi, absensiGuru, btnAbsensiGuru);
        buatSub("absensi qr", absensi, absensiQR, btnQR);
        buatSub("absensi mapel", absensi, absensiMapel, btnAbsensiMapel);
        buatSub("pergantian guru", absensi, pergantianGuru, btnPergantianGuru);

        buatSub("laporan guru", laporan, laporanGuru, btnLaporanGuru);
        buatSub("laporan siswa", laporan, laporanSiswa, btnLaporanSiswa);

        aktifkanMenu(dashboard);
    }

    // membuat satu item submenu dan mendaftarkannya ke daftarSub
    private void buatSub(String nama, PanelCustom induk, PanelCustom p, JPanel panel) {
        panel.putClientProperty("FlatLaf.style", "arc: 25");

        daftarSub.add(new SubItem(nama, induk, p));
        pasangKlikSub(panel, nama);
    }

    private void resetSubItem() {
        for (SubItem s : daftarSub) {
            s.panel.setAktif(false);
        }
    }

    private void tutupSemuaSub() {
        for (JPanel g : grupSub) {
            g.setVisible(false);
        }
        resetSubItem();
    }

    // buka/tutup satu grup submenu (accordion)
    private void toggleSub(JPanel sub, PanelCustom induk, String itemPertama) {
        if (!sidebarMelebar || animasiJalan) {
            return;
        }

        boolean sudahTerbuka = sub.isVisible();
        tutupSemuaSub();                         // tutup yang lain dulu

        if (sudahTerbuka) {
            induk.setAktif(false);               // klik lagi = menutup
        } else {
            sub.setVisible(true);
            aktifkanSubMenu(itemPertama);
        }
        refreshSidebar();
    }

    // saat submenu diklik: tanpa switch, cukup cari lewat nama
    private void aktifkanSubMenu(String nama) {
        for (PanelCustom menu : semuaMenu) {
            if (menu != null) {
                menu.setAktif(false);
            }
        }

        for (SubItem s : daftarSub) {
            boolean dipilih = s.nama.equals(nama);
            s.panel.setAktif(dipilih);
            if (dipilih) {
                s.induk.setAktif(true);          // menu induknya ikut aktif
            }
        }

        // nanti: cardLayout.show(panelContainer, nama);
    }

    private void refreshSidebar() {
        ukurSidebar(lebarSekarang);
        panelMenu.revalidate();
        panelMenu.repaint();
    }

    // memasang klik ke tombol submenu
    private void pasangKlikSub(JPanel tombol, String nama) {
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
            if (menu != null) {
                menu.setAktif(menu == menuAktif);
            }
        }
        tutupSemuaSub();
        refreshSidebar();
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
            txtDashboard, txtMaster, txtAkademik, txtAbsensi, txtLaporan, txtPengaturan
        };
        javax.swing.JLabel[] panah = {
            arrowMaster, arrowAkademik, arrowAbsensi, arrowLaporan, arrowPengaturan
        };

        for (javax.swing.JLabel l : teks) {
            l.setVisible(tampil);
        }
        for (javax.swing.JLabel l : panah) {
            l.setVisible(tampil);
        }
    }

    private void toggleSidebar() {
        if (animasiJalan) {
            return;
        }
        final boolean akanMelebar = !sidebarMelebar;

        if (!akanMelebar) {            // mengecil: tutup submenu & sembunyikan teks DULU
            tutupSemuaSub();
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
                refreshSidebar();
            }
        });
        t.start();
    }

    public void setNamaUser(String nama) {
        lUsername.setText(nama);
        panelUser.revalidate();
        panelUser.repaint();
        panelHeader.revalidate();
        panelHeader.repaint();
    }

    void inisiasiPanel() {
        cardLayout = (CardLayout) panelContainer.getLayout();
        panelContainer.add(new dashboard(), "dashboard");
        
        panelContainer.add(new panelGuru(), "guru");
        panelContainer.add(new panelKelas(), "kelas");
        panelContainer.add(new panelSiswa(), "siswa");
        panelContainer.add(new panelMapel(), "mata pelajaran");
        panelContainer.add(new panelTahun(), "tahun ajaran");
        panelContainer.add(new panelGenerate(), "generate");
        
        panelContainer.add(new dashboard(), "wali kelas");
        panelContainer.add(new dashboard(), "penugasan guru");
        panelContainer.add(new dashboard(), "jadwal");
        panelContainer.add(new dashboard(), "kenaikan kelas");
        
        panelContainer.add(new dashboard(), "absensi guru");
        panelContainer.add(new dashboard(), "absensi qr");
        panelContainer.add(new dashboard(), "absensi mapel");
        panelContainer.add(new dashboard(), "pergantian guru");
        
        panelContainer.add(new dashboard(), "laporan guru");
        panelContainer.add(new dashboard(), "laporan siswa");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        iconLogoAplikasi = new javax.swing.JLabel();
        iconGaris = new javax.swing.JLabel();
        panelUser = new javax.swing.JPanel();
        pFotoProfil = new javax.swing.JPanel();
        lUsername = new javax.swing.JLabel();
        btnArrowProfil = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollSidebar = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JPanel();
        iconDashboard = new javax.swing.JLabel();
        txtDashboard = new javax.swing.JLabel();
        btnMaster = new javax.swing.JPanel();
        iconMaster = new javax.swing.JLabel();
        arrowMaster = new javax.swing.JLabel();
        txtMaster = new javax.swing.JLabel();
        pMaster = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnGuru = new javax.swing.JPanel();
        iconGuru = new javax.swing.JLabel();
        txtGuru = new javax.swing.JLabel();
        btnKelas = new javax.swing.JPanel();
        iconKelas = new javax.swing.JLabel();
        txtKelas = new javax.swing.JLabel();
        btnSiswa = new javax.swing.JPanel();
        iconSiswa = new javax.swing.JLabel();
        txtSiswa = new javax.swing.JLabel();
        btnMapel = new javax.swing.JPanel();
        iconMapel = new javax.swing.JLabel();
        txtMapel = new javax.swing.JLabel();
        btnTahun = new javax.swing.JPanel();
        iconTahun = new javax.swing.JLabel();
        txtTahun = new javax.swing.JLabel();
        btnGenerate = new javax.swing.JPanel();
        iconGenerate = new javax.swing.JLabel();
        txtGenerate = new javax.swing.JLabel();
        btnAkademik = new javax.swing.JPanel();
        iconAkademik = new javax.swing.JLabel();
        arrowAkademik = new javax.swing.JLabel();
        txtAkademik = new javax.swing.JLabel();
        pAkademik = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnWali = new javax.swing.JPanel();
        iconWali = new javax.swing.JLabel();
        txtWali = new javax.swing.JLabel();
        btnPenugasan = new javax.swing.JPanel();
        iconPenugasan = new javax.swing.JLabel();
        txtPenugasan = new javax.swing.JLabel();
        btnJadwal = new javax.swing.JPanel();
        iconJadwal = new javax.swing.JLabel();
        txtJadwal = new javax.swing.JLabel();
        btnKenaikan = new javax.swing.JPanel();
        iconKenaikan = new javax.swing.JLabel();
        txtKenaikan = new javax.swing.JLabel();
        btnAbsensi = new javax.swing.JPanel();
        iconAbsensi = new javax.swing.JLabel();
        arrowAbsensi = new javax.swing.JLabel();
        txtAbsensi = new javax.swing.JLabel();
        pAbsensi = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btnAbsensiGuru = new javax.swing.JPanel();
        iconAbsensiGuru = new javax.swing.JLabel();
        txtAbsensiGuru = new javax.swing.JLabel();
        btnQR = new javax.swing.JPanel();
        iconQR = new javax.swing.JLabel();
        txtQR = new javax.swing.JLabel();
        btnAbsensiMapel = new javax.swing.JPanel();
        iconAbsensiMapel = new javax.swing.JLabel();
        txtAbsensiMapel = new javax.swing.JLabel();
        btnPergantianGuru = new javax.swing.JPanel();
        iconPergantianGuru = new javax.swing.JLabel();
        txtPergantianGuru = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JPanel();
        iconLaporan = new javax.swing.JLabel();
        arrowLaporan = new javax.swing.JLabel();
        txtLaporan = new javax.swing.JLabel();
        pLaporan = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        btnLaporanGuru = new javax.swing.JPanel();
        iconLaporanGuru = new javax.swing.JLabel();
        txtLaporanGuru = new javax.swing.JLabel();
        btnLaporanSiswa = new javax.swing.JPanel();
        iconLaporanSiswa = new javax.swing.JLabel();
        txtLaporanSiswa = new javax.swing.JLabel();
        btnPengaturan = new javax.swing.JPanel();
        iconPengaturan = new javax.swing.JLabel();
        arrowPengaturan = new javax.swing.JLabel();
        txtPengaturan = new javax.swing.JLabel();
        panelContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1347, 765));
        setPreferredSize(new java.awt.Dimension(1347, 765));

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
        iconGaris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        scrollSidebar.setBorder(null);
        scrollSidebar.setInheritsPopupMenu(true);
        scrollSidebar.setMaximumSize(null);
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

        pMaster.setBackground(new java.awt.Color(255, 255, 255));
        pMaster.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 1, 8, 1));
        pMaster.setMaximumSize(new java.awt.Dimension(248, 346));
        pMaster.setMinimumSize(new java.awt.Dimension(248, 346));
        pMaster.setPreferredSize(new java.awt.Dimension(248, 346));
        pMaster.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 24, 1, 14));
        jPanel4.setPreferredSize(new java.awt.Dimension(40, 330));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);

        pMaster.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        btnGuru.setBackground(new java.awt.Color(255, 255, 255));
        btnGuru.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnGuru.setMaximumSize(new java.awt.Dimension(210, 55));
        btnGuru.setMinimumSize(new java.awt.Dimension(210, 55));
        btnGuru.setPreferredSize(new java.awt.Dimension(210, 55));
        btnGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuruMouseClicked(evt);
            }
        });
        btnGuru.setLayout(new java.awt.BorderLayout(8, 0));

        iconGuru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconGuru.setInheritsPopupMenu(false);
        iconGuru.setMaximumSize(new java.awt.Dimension(37, 37));
        iconGuru.setMinimumSize(new java.awt.Dimension(37, 37));
        iconGuru.setPreferredSize(new java.awt.Dimension(37, 37));
        btnGuru.add(iconGuru, java.awt.BorderLayout.LINE_START);

        txtGuru.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtGuru.setForeground(new java.awt.Color(124, 126, 137));
        txtGuru.setText("Guru");
        btnGuru.add(txtGuru, java.awt.BorderLayout.CENTER);

        jPanel6.add(btnGuru);

        btnKelas.setBackground(new java.awt.Color(255, 255, 255));
        btnKelas.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnKelas.setMaximumSize(new java.awt.Dimension(210, 55));
        btnKelas.setMinimumSize(new java.awt.Dimension(210, 55));
        btnKelas.setPreferredSize(new java.awt.Dimension(210, 55));
        btnKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKelasMouseClicked(evt);
            }
        });
        btnKelas.setLayout(new java.awt.BorderLayout(8, 0));

        iconKelas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconKelas.setInheritsPopupMenu(false);
        iconKelas.setMaximumSize(new java.awt.Dimension(37, 37));
        iconKelas.setMinimumSize(new java.awt.Dimension(37, 37));
        iconKelas.setPreferredSize(new java.awt.Dimension(37, 37));
        btnKelas.add(iconKelas, java.awt.BorderLayout.LINE_START);

        txtKelas.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtKelas.setForeground(new java.awt.Color(124, 126, 137));
        txtKelas.setText("Kelas");
        btnKelas.add(txtKelas, java.awt.BorderLayout.CENTER);

        jPanel6.add(btnKelas);

        btnSiswa.setBackground(new java.awt.Color(255, 255, 255));
        btnSiswa.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnSiswa.setMaximumSize(new java.awt.Dimension(210, 55));
        btnSiswa.setMinimumSize(new java.awt.Dimension(210, 55));
        btnSiswa.setPreferredSize(new java.awt.Dimension(210, 55));
        btnSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiswaMouseClicked(evt);
            }
        });
        btnSiswa.setLayout(new java.awt.BorderLayout(8, 0));

        iconSiswa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSiswa.setInheritsPopupMenu(false);
        iconSiswa.setMaximumSize(new java.awt.Dimension(37, 37));
        iconSiswa.setMinimumSize(new java.awt.Dimension(37, 37));
        iconSiswa.setPreferredSize(new java.awt.Dimension(37, 37));
        btnSiswa.add(iconSiswa, java.awt.BorderLayout.LINE_START);

        txtSiswa.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtSiswa.setForeground(new java.awt.Color(124, 126, 137));
        txtSiswa.setText("Siswa");
        btnSiswa.add(txtSiswa, java.awt.BorderLayout.CENTER);

        jPanel6.add(btnSiswa);

        btnMapel.setBackground(new java.awt.Color(255, 255, 255));
        btnMapel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnMapel.setMaximumSize(new java.awt.Dimension(210, 55));
        btnMapel.setMinimumSize(new java.awt.Dimension(210, 55));
        btnMapel.setPreferredSize(new java.awt.Dimension(210, 55));
        btnMapel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMapelMouseClicked(evt);
            }
        });
        btnMapel.setLayout(new java.awt.BorderLayout(8, 0));

        iconMapel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconMapel.setInheritsPopupMenu(false);
        iconMapel.setMaximumSize(new java.awt.Dimension(37, 37));
        iconMapel.setMinimumSize(new java.awt.Dimension(37, 37));
        iconMapel.setPreferredSize(new java.awt.Dimension(37, 37));
        btnMapel.add(iconMapel, java.awt.BorderLayout.LINE_START);

        txtMapel.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtMapel.setForeground(new java.awt.Color(124, 126, 137));
        txtMapel.setText("Mata Pelajaran");
        btnMapel.add(txtMapel, java.awt.BorderLayout.CENTER);

        jPanel6.add(btnMapel);

        btnTahun.setBackground(new java.awt.Color(255, 255, 255));
        btnTahun.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnTahun.setMaximumSize(new java.awt.Dimension(210, 55));
        btnTahun.setMinimumSize(new java.awt.Dimension(210, 55));
        btnTahun.setPreferredSize(new java.awt.Dimension(210, 55));
        btnTahun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTahunMouseClicked(evt);
            }
        });
        btnTahun.setLayout(new java.awt.BorderLayout(8, 0));

        iconTahun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconTahun.setInheritsPopupMenu(false);
        iconTahun.setMaximumSize(new java.awt.Dimension(37, 37));
        iconTahun.setMinimumSize(new java.awt.Dimension(37, 37));
        iconTahun.setPreferredSize(new java.awt.Dimension(37, 37));
        btnTahun.add(iconTahun, java.awt.BorderLayout.LINE_START);

        txtTahun.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtTahun.setForeground(new java.awt.Color(124, 126, 137));
        txtTahun.setText("Tahun Ajaran");
        btnTahun.add(txtTahun, java.awt.BorderLayout.CENTER);

        jPanel6.add(btnTahun);

        btnGenerate.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerate.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnGenerate.setMaximumSize(new java.awt.Dimension(210, 55));
        btnGenerate.setMinimumSize(new java.awt.Dimension(210, 55));
        btnGenerate.setPreferredSize(new java.awt.Dimension(210, 55));
        btnGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerateMouseClicked(evt);
            }
        });
        btnGenerate.setLayout(new java.awt.BorderLayout(8, 0));

        iconGenerate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconGenerate.setInheritsPopupMenu(false);
        iconGenerate.setMaximumSize(new java.awt.Dimension(37, 37));
        iconGenerate.setMinimumSize(new java.awt.Dimension(37, 37));
        iconGenerate.setPreferredSize(new java.awt.Dimension(37, 37));
        btnGenerate.add(iconGenerate, java.awt.BorderLayout.LINE_START);

        txtGenerate.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtGenerate.setForeground(new java.awt.Color(124, 126, 137));
        txtGenerate.setText("Generate QR");
        btnGenerate.add(txtGenerate, java.awt.BorderLayout.CENTER);

        jPanel6.add(btnGenerate);

        pMaster.add(jPanel6, java.awt.BorderLayout.CENTER);

        panelMenu.add(pMaster);

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

        pAkademik.setBackground(new java.awt.Color(255, 255, 255));
        pAkademik.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 1, 8, 1));
        pAkademik.setMaximumSize(new java.awt.Dimension(250, 236));
        pAkademik.setPreferredSize(new java.awt.Dimension(250, 236));
        pAkademik.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 24, 1, 14));
        jPanel7.setPreferredSize(new java.awt.Dimension(40, 330));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8, java.awt.BorderLayout.CENTER);

        pAkademik.add(jPanel7, java.awt.BorderLayout.LINE_START);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.Y_AXIS));

        btnWali.setBackground(new java.awt.Color(255, 255, 255));
        btnWali.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnWali.setMaximumSize(new java.awt.Dimension(210, 55));
        btnWali.setMinimumSize(new java.awt.Dimension(210, 55));
        btnWali.setPreferredSize(new java.awt.Dimension(210, 55));
        btnWali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWaliMouseClicked(evt);
            }
        });
        btnWali.setLayout(new java.awt.BorderLayout(8, 0));

        iconWali.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconWali.setInheritsPopupMenu(false);
        iconWali.setMaximumSize(new java.awt.Dimension(37, 37));
        iconWali.setMinimumSize(new java.awt.Dimension(37, 37));
        iconWali.setPreferredSize(new java.awt.Dimension(37, 37));
        btnWali.add(iconWali, java.awt.BorderLayout.LINE_START);

        txtWali.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtWali.setForeground(new java.awt.Color(124, 126, 137));
        txtWali.setText("Wali Kelas");
        btnWali.add(txtWali, java.awt.BorderLayout.CENTER);

        jPanel9.add(btnWali);

        btnPenugasan.setBackground(new java.awt.Color(255, 255, 255));
        btnPenugasan.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnPenugasan.setMaximumSize(new java.awt.Dimension(210, 55));
        btnPenugasan.setMinimumSize(new java.awt.Dimension(210, 55));
        btnPenugasan.setPreferredSize(new java.awt.Dimension(210, 55));
        btnPenugasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPenugasanMouseClicked(evt);
            }
        });
        btnPenugasan.setLayout(new java.awt.BorderLayout(8, 0));

        iconPenugasan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconPenugasan.setInheritsPopupMenu(false);
        iconPenugasan.setMaximumSize(new java.awt.Dimension(37, 37));
        iconPenugasan.setMinimumSize(new java.awt.Dimension(37, 37));
        iconPenugasan.setPreferredSize(new java.awt.Dimension(37, 37));
        btnPenugasan.add(iconPenugasan, java.awt.BorderLayout.LINE_START);

        txtPenugasan.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtPenugasan.setForeground(new java.awt.Color(124, 126, 137));
        txtPenugasan.setText("Penugasan Guru");
        btnPenugasan.add(txtPenugasan, java.awt.BorderLayout.CENTER);

        jPanel9.add(btnPenugasan);

        btnJadwal.setBackground(new java.awt.Color(255, 255, 255));
        btnJadwal.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnJadwal.setMaximumSize(new java.awt.Dimension(210, 55));
        btnJadwal.setMinimumSize(new java.awt.Dimension(210, 55));
        btnJadwal.setPreferredSize(new java.awt.Dimension(210, 55));
        btnJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJadwalMouseClicked(evt);
            }
        });
        btnJadwal.setLayout(new java.awt.BorderLayout(8, 0));

        iconJadwal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconJadwal.setInheritsPopupMenu(false);
        iconJadwal.setMaximumSize(new java.awt.Dimension(37, 37));
        iconJadwal.setMinimumSize(new java.awt.Dimension(37, 37));
        iconJadwal.setPreferredSize(new java.awt.Dimension(37, 37));
        btnJadwal.add(iconJadwal, java.awt.BorderLayout.LINE_START);

        txtJadwal.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtJadwal.setForeground(new java.awt.Color(124, 126, 137));
        txtJadwal.setText("Jadwal");
        btnJadwal.add(txtJadwal, java.awt.BorderLayout.CENTER);

        jPanel9.add(btnJadwal);

        btnKenaikan.setBackground(new java.awt.Color(255, 255, 255));
        btnKenaikan.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnKenaikan.setMaximumSize(new java.awt.Dimension(210, 55));
        btnKenaikan.setMinimumSize(new java.awt.Dimension(210, 55));
        btnKenaikan.setPreferredSize(new java.awt.Dimension(210, 55));
        btnKenaikan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKenaikanMouseClicked(evt);
            }
        });
        btnKenaikan.setLayout(new java.awt.BorderLayout(8, 0));

        iconKenaikan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconKenaikan.setInheritsPopupMenu(false);
        iconKenaikan.setMaximumSize(new java.awt.Dimension(37, 37));
        iconKenaikan.setMinimumSize(new java.awt.Dimension(37, 37));
        iconKenaikan.setPreferredSize(new java.awt.Dimension(37, 37));
        btnKenaikan.add(iconKenaikan, java.awt.BorderLayout.LINE_START);

        txtKenaikan.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtKenaikan.setForeground(new java.awt.Color(124, 126, 137));
        txtKenaikan.setText("Kenaikan Kelas");
        btnKenaikan.add(txtKenaikan, java.awt.BorderLayout.CENTER);

        jPanel9.add(btnKenaikan);

        pAkademik.add(jPanel9, java.awt.BorderLayout.CENTER);

        panelMenu.add(pAkademik);

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

        pAbsensi.setBackground(new java.awt.Color(255, 255, 255));
        pAbsensi.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 1, 8, 1));
        pAbsensi.setMaximumSize(new java.awt.Dimension(250, 236));
        pAbsensi.setPreferredSize(new java.awt.Dimension(250, 236));
        pAbsensi.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 24, 1, 14));
        jPanel11.setPreferredSize(new java.awt.Dimension(40, 330));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel12, java.awt.BorderLayout.CENTER);

        pAbsensi.add(jPanel11, java.awt.BorderLayout.LINE_START);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.Y_AXIS));

        btnAbsensiGuru.setBackground(new java.awt.Color(255, 255, 255));
        btnAbsensiGuru.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnAbsensiGuru.setMaximumSize(new java.awt.Dimension(210, 55));
        btnAbsensiGuru.setMinimumSize(new java.awt.Dimension(210, 55));
        btnAbsensiGuru.setPreferredSize(new java.awt.Dimension(210, 55));
        btnAbsensiGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbsensiGuruMouseClicked(evt);
            }
        });
        btnAbsensiGuru.setLayout(new java.awt.BorderLayout(8, 0));

        iconAbsensiGuru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconAbsensiGuru.setInheritsPopupMenu(false);
        iconAbsensiGuru.setMaximumSize(new java.awt.Dimension(37, 37));
        iconAbsensiGuru.setMinimumSize(new java.awt.Dimension(37, 37));
        iconAbsensiGuru.setPreferredSize(new java.awt.Dimension(37, 37));
        btnAbsensiGuru.add(iconAbsensiGuru, java.awt.BorderLayout.LINE_START);

        txtAbsensiGuru.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtAbsensiGuru.setForeground(new java.awt.Color(124, 126, 137));
        txtAbsensiGuru.setText("Absensi Guru");
        btnAbsensiGuru.add(txtAbsensiGuru, java.awt.BorderLayout.CENTER);

        jPanel13.add(btnAbsensiGuru);

        btnQR.setBackground(new java.awt.Color(255, 255, 255));
        btnQR.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnQR.setMaximumSize(new java.awt.Dimension(210, 55));
        btnQR.setMinimumSize(new java.awt.Dimension(210, 55));
        btnQR.setPreferredSize(new java.awt.Dimension(210, 55));
        btnQR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQRMouseClicked(evt);
            }
        });
        btnQR.setLayout(new java.awt.BorderLayout(8, 0));

        iconQR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconQR.setInheritsPopupMenu(false);
        iconQR.setMaximumSize(new java.awt.Dimension(37, 37));
        iconQR.setMinimumSize(new java.awt.Dimension(37, 37));
        iconQR.setPreferredSize(new java.awt.Dimension(37, 37));
        btnQR.add(iconQR, java.awt.BorderLayout.LINE_START);

        txtQR.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtQR.setForeground(new java.awt.Color(124, 126, 137));
        txtQR.setText("Absensi QR");
        btnQR.add(txtQR, java.awt.BorderLayout.CENTER);

        jPanel13.add(btnQR);

        btnAbsensiMapel.setBackground(new java.awt.Color(255, 255, 255));
        btnAbsensiMapel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnAbsensiMapel.setMaximumSize(new java.awt.Dimension(210, 55));
        btnAbsensiMapel.setMinimumSize(new java.awt.Dimension(210, 55));
        btnAbsensiMapel.setPreferredSize(new java.awt.Dimension(210, 55));
        btnAbsensiMapel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbsensiMapelMouseClicked(evt);
            }
        });
        btnAbsensiMapel.setLayout(new java.awt.BorderLayout(8, 0));

        iconAbsensiMapel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconAbsensiMapel.setInheritsPopupMenu(false);
        iconAbsensiMapel.setMaximumSize(new java.awt.Dimension(37, 37));
        iconAbsensiMapel.setMinimumSize(new java.awt.Dimension(37, 37));
        iconAbsensiMapel.setPreferredSize(new java.awt.Dimension(37, 37));
        btnAbsensiMapel.add(iconAbsensiMapel, java.awt.BorderLayout.LINE_START);

        txtAbsensiMapel.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtAbsensiMapel.setForeground(new java.awt.Color(124, 126, 137));
        txtAbsensiMapel.setText("Absensi Mapel");
        btnAbsensiMapel.add(txtAbsensiMapel, java.awt.BorderLayout.CENTER);

        jPanel13.add(btnAbsensiMapel);

        btnPergantianGuru.setBackground(new java.awt.Color(255, 255, 255));
        btnPergantianGuru.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnPergantianGuru.setMaximumSize(new java.awt.Dimension(210, 55));
        btnPergantianGuru.setMinimumSize(new java.awt.Dimension(210, 55));
        btnPergantianGuru.setPreferredSize(new java.awt.Dimension(210, 55));
        btnPergantianGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPergantianGuruMouseClicked(evt);
            }
        });
        btnPergantianGuru.setLayout(new java.awt.BorderLayout(8, 0));

        iconPergantianGuru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconPergantianGuru.setInheritsPopupMenu(false);
        iconPergantianGuru.setMaximumSize(new java.awt.Dimension(37, 37));
        iconPergantianGuru.setMinimumSize(new java.awt.Dimension(37, 37));
        iconPergantianGuru.setPreferredSize(new java.awt.Dimension(37, 37));
        btnPergantianGuru.add(iconPergantianGuru, java.awt.BorderLayout.LINE_START);

        txtPergantianGuru.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtPergantianGuru.setForeground(new java.awt.Color(124, 126, 137));
        txtPergantianGuru.setText("Pergantian Guru");
        btnPergantianGuru.add(txtPergantianGuru, java.awt.BorderLayout.CENTER);

        jPanel13.add(btnPergantianGuru);

        pAbsensi.add(jPanel13, java.awt.BorderLayout.CENTER);

        panelMenu.add(pAbsensi);

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

        pLaporan.setBackground(new java.awt.Color(255, 255, 255));
        pLaporan.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 1, 8, 1));
        pLaporan.setMaximumSize(new java.awt.Dimension(250, 126));
        pLaporan.setPreferredSize(new java.awt.Dimension(250, 126));
        pLaporan.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 24, 1, 14));
        jPanel15.setPreferredSize(new java.awt.Dimension(40, 330));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel16, java.awt.BorderLayout.CENTER);

        pLaporan.add(jPanel15, java.awt.BorderLayout.LINE_START);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.Y_AXIS));

        btnLaporanGuru.setBackground(new java.awt.Color(255, 255, 255));
        btnLaporanGuru.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnLaporanGuru.setMaximumSize(new java.awt.Dimension(210, 55));
        btnLaporanGuru.setMinimumSize(new java.awt.Dimension(210, 55));
        btnLaporanGuru.setPreferredSize(new java.awt.Dimension(210, 55));
        btnLaporanGuru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaporanGuruMouseClicked(evt);
            }
        });
        btnLaporanGuru.setLayout(new java.awt.BorderLayout(8, 0));

        iconLaporanGuru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLaporanGuru.setInheritsPopupMenu(false);
        iconLaporanGuru.setMaximumSize(new java.awt.Dimension(37, 37));
        iconLaporanGuru.setMinimumSize(new java.awt.Dimension(37, 37));
        iconLaporanGuru.setPreferredSize(new java.awt.Dimension(37, 37));
        btnLaporanGuru.add(iconLaporanGuru, java.awt.BorderLayout.LINE_START);

        txtLaporanGuru.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtLaporanGuru.setForeground(new java.awt.Color(124, 126, 137));
        txtLaporanGuru.setText("Laporan Guru");
        btnLaporanGuru.add(txtLaporanGuru, java.awt.BorderLayout.CENTER);

        jPanel17.add(btnLaporanGuru);

        btnLaporanSiswa.setBackground(new java.awt.Color(255, 255, 255));
        btnLaporanSiswa.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        btnLaporanSiswa.setMaximumSize(new java.awt.Dimension(210, 55));
        btnLaporanSiswa.setMinimumSize(new java.awt.Dimension(210, 55));
        btnLaporanSiswa.setPreferredSize(new java.awt.Dimension(210, 55));
        btnLaporanSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaporanSiswaMouseClicked(evt);
            }
        });
        btnLaporanSiswa.setLayout(new java.awt.BorderLayout(8, 0));

        iconLaporanSiswa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLaporanSiswa.setInheritsPopupMenu(false);
        iconLaporanSiswa.setMaximumSize(new java.awt.Dimension(37, 37));
        iconLaporanSiswa.setMinimumSize(new java.awt.Dimension(37, 37));
        iconLaporanSiswa.setPreferredSize(new java.awt.Dimension(37, 37));
        btnLaporanSiswa.add(iconLaporanSiswa, java.awt.BorderLayout.LINE_START);

        txtLaporanSiswa.setFont(new java.awt.Font("Poppins Medium", 0, 16)); // NOI18N
        txtLaporanSiswa.setForeground(new java.awt.Color(124, 126, 137));
        txtLaporanSiswa.setText("Laporan Siswa");
        btnLaporanSiswa.add(txtLaporanSiswa, java.awt.BorderLayout.CENTER);

        jPanel17.add(btnLaporanSiswa);

        pLaporan.add(jPanel17, java.awt.BorderLayout.CENTER);

        panelMenu.add(pLaporan);

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

        scrollSidebar.setViewportView(panelMenu);

        getContentPane().add(scrollSidebar, java.awt.BorderLayout.LINE_START);

        panelContainer.setPreferredSize(new java.awt.Dimension(56, 56));
        panelContainer.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelContainer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        // TODO add your handling code here:
        aktifkanMenu(dashboard);
        cardLayout.show(panelContainer, "dashboard");
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnMasterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMasterMouseClicked
        // TODO add your handling code here:
        toggleSub(pMaster, master, "guru");
        cardLayout.show(panelContainer, "guru");
    }//GEN-LAST:event_btnMasterMouseClicked

    private void btnAkademikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAkademikMouseClicked
        // TODO add your handling code here:
        toggleSub(pAkademik, akademik, "wali");
        cardLayout.show(panelContainer, "wali kelas");
    }//GEN-LAST:event_btnAkademikMouseClicked

    private void btnAbsensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbsensiMouseClicked
        // TODO add your handling code here:
        toggleSub(pAbsensi, absensi, "absensi guru");
        cardLayout.show(panelContainer, "absensi guru");
    }//GEN-LAST:event_btnAbsensiMouseClicked

    private void btnLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseClicked
        // TODO add your handling code here:
        toggleSub(pLaporan, laporan, "laporan guru");
        cardLayout.show(panelContainer, "laporan guru");
    }//GEN-LAST:event_btnLaporanMouseClicked

    private void btnPengaturanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengaturanMouseClicked
        // TODO add your handling code here:
        aktifkanMenu(pengaturan);
    }//GEN-LAST:event_btnPengaturanMouseClicked

    private void btnArrowProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArrowProfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnArrowProfilActionPerformed

    private void btnGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuruMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "guru");
    }//GEN-LAST:event_btnGuruMouseClicked

    private void btnKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKelasMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "kelas");
    }//GEN-LAST:event_btnKelasMouseClicked

    private void btnSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiswaMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "siswa");
    }//GEN-LAST:event_btnSiswaMouseClicked

    private void btnMapelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMapelMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "mata pelajaran");
    }//GEN-LAST:event_btnMapelMouseClicked

    private void btnTahunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTahunMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "tahun ajaran");
    }//GEN-LAST:event_btnTahunMouseClicked

    private void btnGenerateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerateMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "generate");
    }//GEN-LAST:event_btnGenerateMouseClicked

    private void btnWaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWaliMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "wali kelas");
    }//GEN-LAST:event_btnWaliMouseClicked

    private void btnPenugasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPenugasanMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "penugasan guru");
    }//GEN-LAST:event_btnPenugasanMouseClicked

    private void btnJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJadwalMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "jadwal");
    }//GEN-LAST:event_btnJadwalMouseClicked

    private void btnKenaikanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKenaikanMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "kenaikan kelas");
    }//GEN-LAST:event_btnKenaikanMouseClicked

    private void btnAbsensiGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbsensiGuruMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "absensi guru");
    }//GEN-LAST:event_btnAbsensiGuruMouseClicked

    private void btnQRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQRMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "absensi qr");
    }//GEN-LAST:event_btnQRMouseClicked

    private void btnAbsensiMapelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbsensiMapelMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "absensi mapel");
    }//GEN-LAST:event_btnAbsensiMapelMouseClicked

    private void btnPergantianGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPergantianGuruMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "pergantian guru");
    }//GEN-LAST:event_btnPergantianGuruMouseClicked

    private void btnLaporanGuruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanGuruMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "laporan guru");
    }//GEN-LAST:event_btnLaporanGuruMouseClicked

    private void btnLaporanSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanSiswaMouseClicked
        // TODO add your handling code here:
        cardLayout.show(panelContainer, "laporan siswa");
    }//GEN-LAST:event_btnLaporanSiswaMouseClicked

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
    private javax.swing.JPanel btnAbsensiGuru;
    private javax.swing.JPanel btnAbsensiMapel;
    private javax.swing.JPanel btnAkademik;
    private javax.swing.JButton btnArrowProfil;
    private javax.swing.JPanel btnDashboard;
    private javax.swing.JPanel btnGenerate;
    private javax.swing.JPanel btnGuru;
    private javax.swing.JPanel btnJadwal;
    private javax.swing.JPanel btnKelas;
    private javax.swing.JPanel btnKenaikan;
    private javax.swing.JPanel btnLaporan;
    private javax.swing.JPanel btnLaporanGuru;
    private javax.swing.JPanel btnLaporanSiswa;
    private javax.swing.JPanel btnMapel;
    private javax.swing.JPanel btnMaster;
    private javax.swing.JPanel btnPengaturan;
    private javax.swing.JPanel btnPenugasan;
    private javax.swing.JPanel btnPergantianGuru;
    private javax.swing.JPanel btnQR;
    private javax.swing.JPanel btnSiswa;
    private javax.swing.JPanel btnTahun;
    private javax.swing.JPanel btnWali;
    private javax.swing.JLabel iconAbsensi;
    private javax.swing.JLabel iconAbsensiGuru;
    private javax.swing.JLabel iconAbsensiMapel;
    private javax.swing.JLabel iconAkademik;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel iconGaris;
    private javax.swing.JLabel iconGenerate;
    private javax.swing.JLabel iconGuru;
    private javax.swing.JLabel iconJadwal;
    private javax.swing.JLabel iconKelas;
    private javax.swing.JLabel iconKenaikan;
    private javax.swing.JLabel iconLaporan;
    private javax.swing.JLabel iconLaporanGuru;
    private javax.swing.JLabel iconLaporanSiswa;
    private javax.swing.JLabel iconLogoAplikasi;
    private javax.swing.JLabel iconMapel;
    private javax.swing.JLabel iconMaster;
    private javax.swing.JLabel iconPengaturan;
    private javax.swing.JLabel iconPenugasan;
    private javax.swing.JLabel iconPergantianGuru;
    private javax.swing.JLabel iconQR;
    private javax.swing.JLabel iconSiswa;
    private javax.swing.JLabel iconTahun;
    private javax.swing.JLabel iconWali;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lUsername;
    private javax.swing.JPanel pAbsensi;
    private javax.swing.JPanel pAkademik;
    private javax.swing.JPanel pFotoProfil;
    private javax.swing.JPanel pLaporan;
    private javax.swing.JPanel pMaster;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelUser;
    private javax.swing.JScrollPane scrollSidebar;
    private javax.swing.JLabel txtAbsensi;
    private javax.swing.JLabel txtAbsensiGuru;
    private javax.swing.JLabel txtAbsensiMapel;
    private javax.swing.JLabel txtAkademik;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtGenerate;
    private javax.swing.JLabel txtGuru;
    private javax.swing.JLabel txtJadwal;
    private javax.swing.JLabel txtKelas;
    private javax.swing.JLabel txtKenaikan;
    private javax.swing.JLabel txtLaporan;
    private javax.swing.JLabel txtLaporanGuru;
    private javax.swing.JLabel txtLaporanSiswa;
    private javax.swing.JLabel txtMapel;
    private javax.swing.JLabel txtMaster;
    private javax.swing.JLabel txtPengaturan;
    private javax.swing.JLabel txtPenugasan;
    private javax.swing.JLabel txtPergantianGuru;
    private javax.swing.JLabel txtQR;
    private javax.swing.JLabel txtSiswa;
    private javax.swing.JLabel txtTahun;
    private javax.swing.JLabel txtWali;
    // End of variables declaration//GEN-END:variables
}
