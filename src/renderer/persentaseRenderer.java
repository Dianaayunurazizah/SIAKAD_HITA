/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import com.sun.jdi.DoubleValue;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Locale;
import javax.swing.JTable;
/**
 *
 * @author Acer
 */
public class persentaseRenderer extends DefaultTableCellRenderer{
    
    private double persen;
    public persentaseRenderer(){
        setOpaque(true);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable t, Object v,
            boolean sel, boolean foc, int r, int c) {
        super.getTableCellRendererComponent(t, "", sel, foc, r, c);
        persen =(v instanceof Number) ? ((Number) v).doubleValue():0;
        setBackground(sel ? t.getSelectionBackground():Color.WHITE);
        return this;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Poppins", Font.PLAIN, 10));

        String label = String.format(new Locale("id", "ID"), "%.1f%%", persen);
        int barW = getWidth() - 16 - 8 - g2.getFontMetrics().stringWidth(label);
        int y = (getHeight() - 6) / 2;

        g2.setColor(new Color(0xE5E5E5));
        g2.fillRoundRect(8, y, barW, 6, 6, 6);

        g2.setColor(persen < 70 ? new Color(0xB00020) : new Color(0x1B8A1B));
        g2.fillRoundRect(8, y, (int) (barW * persen / 100), 6, 6, 6);

        g2.setColor(Color.DARK_GRAY);
        g2.drawString(label, 8 + barW + 8, getHeight() / 2 + 4);
        g2.dispose();
    }
}
