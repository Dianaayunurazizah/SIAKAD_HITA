/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTable;

/**
 *
 * @author Acer
 */
public class backgroudPink extends teksRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable t, Object v,
            boolean sel, boolean foc, int r, int c) {
        Component comp = super.getTableCellRendererComponent(t, v, sel, foc, r, c);
        if (comp instanceof JComponent) ((JComponent) comp).setOpaque(true);
        if (!sel) comp.setBackground(KeputusanCell.warnaBaris(t, r));
        return comp;
    }
}
