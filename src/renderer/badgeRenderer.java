/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Acer
 */
public class badgeRenderer extends JPanel implements TableCellRenderer{
        private final int lebarTetap;   

    private final JLabel badge = new JLabel("", SwingConstants.CENTER) {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14);
            g2.dispose();
            super.paintComponent(g);
        }
    };

    public badgeRenderer(int lebarTetap, int rata) {
        this.lebarTetap = lebarTetap;
        setLayout(new FlowLayout(rata, 8, 13));  
        setOpaque(true);
        badge.setOpaque(false);
        badge.setFont(new Font("Poppins", Font.PLAIN, 12));
        add(badge);
    }

    protected Color latar(String teks) {
        return new Color(0xD5F5E3);
    }

    protected Color huruf(String teks) {
        return new Color(0x2E8B57);
    }

    @Override
    public Component getTableCellRendererComponent(JTable t, Object v,
            boolean sel, boolean foc, int r, int c) {
        String teks = String.valueOf(v);
        setBackground(sel ? t.getSelectionBackground() : Color.WHITE);
        badge.setText(teks);
        badge.setBackground(latar(teks));
        badge.setForeground(huruf(teks));

        int lebar = lebarTetap > 0
                ? lebarTetap
                : badge.getFontMetrics(badge.getFont()).stringWidth(teks) + 32;
        badge.setPreferredSize(new Dimension(lebar, 26));
        return this;
    }
}

