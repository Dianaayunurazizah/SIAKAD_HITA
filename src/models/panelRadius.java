/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.JPanel;
/**
 *
 * @author Acer
 */
public class panelRadius extends JPanel {
    private int kiriAtas, kananAtas, kananBawah, kiriBawah;

    // semua sudut sama
    public panelRadius(int radius) {
        this(radius, radius, radius, radius);
    }

    // tiap sudut berbeda: kiriAtas, kananAtas, kananBawah, kiriBawah
    public panelRadius(int kiriAtas, int kananAtas, int kananBawah, int kiriBawah) {
        this.kiriAtas = kiriAtas;
        this.kananAtas = kananAtas;
        this.kananBawah = kananBawah;
        this.kiriBawah = kiriBawah;
        setOpaque(false);
    }

    public void setRadius(int kiriAtas, int kananAtas, int kananBawah, int kiriBawah) {
        this.kiriAtas = kiriAtas;
        this.kananAtas = kananAtas;
        this.kananBawah = kananBawah;
        this.kiriBawah = kiriBawah;
        repaint();
    }

    public int getKiriAtas() {
        return kiriAtas;
    }

    public int getKananAtas() {
        return kananAtas;
    }

    public int getKananBawah() {
        return kananBawah;
    }

    public int getKiriBawah() {
        return kiriBawah;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(buatBentuk(getWidth(), getHeight()));
        g2.dispose();
        super.paintComponent(g);
    }

    private Path2D buatBentuk(int w, int h) {
        Path2D p = new Path2D.Float();
        p.moveTo(kiriAtas, 0);
        p.lineTo(w - kananAtas, 0);
        p.quadTo(w, 0, w, kananAtas);
        p.lineTo(w, h - kananBawah);
        p.quadTo(w, h, w - kananBawah, h);
        p.lineTo(kiriBawah, h);
        p.quadTo(0, h, 0, h - kiriBawah);
        p.lineTo(0, kiriAtas);
        p.quadTo(0, 0, kiriAtas, 0);
        p.closePath();
        return p;
    }
}
