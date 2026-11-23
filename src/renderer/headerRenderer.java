/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author Acer
 */
public class headerRenderer extends DefaultTableCellRenderer {
    private final int kolomTengah;

    public headerRenderer(int kolomTengah) {
        this.kolomTengah = kolomTengah;
    }

    @Override
    public Component getTableCellRendererComponent(JTable t, Object v,
            boolean sel, boolean foc, int r, int c) {
        super.getTableCellRendererComponent(t, v, false, false, r, c);
        setBackground(new Color(0xF4F6FA));
        setForeground(new Color(0x111827));
        setFont(new Font("Poppins", Font.PLAIN, 18));
        setHorizontalAlignment(c == kolomTengah ? CENTER : LEFT);
        setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        setPreferredSize(new Dimension(getPreferredSize().width, 60));
        return this;
    }
}
