/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
/**
 *
 * @author Acer
 */
public class SegmentToggle extends JPanel {
    
    public static final String NAIK = "Naik";
    public static final String TINGGAL = "Tinggal";

    private static final int W = 250, H = 34, R = 10;
    private String nilai = NAIK;

    public SegmentToggle() {
        setOpaque(true);
        setFont(new Font("Poppins", Font.PLAIN, 14));
    }

    public void setNilai(String n) { this.nilai = n; }
    public String getNilai()       { return nilai; }

    private Rectangle pill() {
        return new Rectangle(8,(getHeight() - H) / 2,W,H);
    }

    /** Klik kiri = Naik, kanan = Tinggal, di luar pill = null */
    public String hit(Point p) {
        Rectangle b = pill();
        if (!b.contains(p)) return null;
        return p.x < b.x + W / 2 ? NAIK : TINGGAL;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(getFont());

        Rectangle b = pill();
        Shape bentuk = new RoundRectangle2D.Float(b.x, b.y, b.width, b.height, R, R);
 
        g2.setColor(Color.WHITE);
        g2.fill(bentuk);

        g2.setClip(bentuk);
        boolean naik = NAIK.equals(nilai);
        g2.setColor(naik ? new Color(0x2E8B57) : new Color(0xE74C3C));
        if (naik) g2.fillRect(b.x, b.y, W / 2, H);
        else g2.fillRect(b.x + W / 2, b.y, W / 2, H);
        g2.setClip(null);

        g2.setColor(new Color(0xD1D5DB));
        g2.draw(bentuk);
        g2.drawLine(b.x + W / 2, b.y, b.x + W / 2, b.y + H);

        FontMetrics fm = g2.getFontMetrics();
        int ty = b.y + (H + fm.getAscent() - fm.getDescent()) / 2;
        gambarTeks(g2, fm, NAIK,    b.x,         ty, naik);
        gambarTeks(g2, fm, TINGGAL, b.x + W / 2, ty, !naik);
        g2.dispose();
    }

    private void gambarTeks(Graphics2D g2, FontMetrics fm, String s, int x0, int y, boolean aktif) {
        g2.setColor(aktif ? Color.WHITE : new Color(0x6B7280));
        g2.drawString(s, x0 + (W / 2 - fm.stringWidth(s)) / 2, y);
    }
}    
    
