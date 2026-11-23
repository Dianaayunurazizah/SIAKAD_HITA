/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Acer
 */
public class teksRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable t, Object v,
            boolean sel, boolean foc, int r, int c) {
        super.getTableCellRendererComponent(t, v, sel, false, r, c);
        setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 0));
        setForeground(new Color(0x111827)); // warna atur tulisan
        return this;

    }
}
