/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.StyleConstants;
/**
 *
 * @author Acer
 */
public class fotoRenderer extends DefaultTableCellRenderer{
    private static final int UKURAN = 36;
    private final Map<String, Icon> cache = new HashMap<>();
    
    @Override
    public Component getTableCellRendererComponent(JTable t, Object v,
            boolean sel, boolean foc, int r, int c) {
        super.getTableCellRendererComponent(t,"",sel,false,r,c);
        setHorizontalAlignment(LEFT);
        setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        String path = (v == null) ? "" : v.toString();
        setIcon(cache.computeIfAbsent(path, this::buatIcon));
        return this;    
    }
    
    private Icon buatIcon(String path) {
        BufferedImage out = new BufferedImage(UKURAN, UKURAN, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = out.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setClip(new Ellipse2D.Float(0, 0, UKURAN, UKURAN));
        URL url = path.isEmpty() ? null : getClass().getResource(path);
        if (url != null) {
            g.drawImage(new ImageIcon(url).getImage(), 0, 0, UKURAN, UKURAN, null);
        } else {
            g.setColor(new Color(0xD1D5DB));
            g.fillRect(0, 0, UKURAN, UKURAN);
        }
        g.dispose();
        return new ImageIcon(out);
    }
}
