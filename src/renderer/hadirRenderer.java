/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author Acer
 */
public class hadirRenderer extends JPanel implements TableCellRenderer{
    private final JLabel badge = new JLabel("Hadir", SwingConstants.CENTER) {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);
            g2.dispose();
            super.paintComponent(g);
        }
    };
    
    public hadirRenderer(){
        setLayout(new FlowLayout(FlowLayout.LEFT,8,7));
        badge.setOpaque(false);
        badge.setFont(new Font("Poppins",Font.PLAIN,14));
        badge.setPreferredSize(new Dimension(80,37));
        badge.setBackground(new Color(0xD5F5E3));
        badge.setForeground(new Color(0x2E8B57));
        add(badge);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable t, Object v,
            boolean sel, boolean foc, int r, int c) {
        setBackground(sel ? t.getSelectionBackground() : Color.WHITE);
        return this;
    }
}
