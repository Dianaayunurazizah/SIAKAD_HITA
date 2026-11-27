/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JTable;

/**
 *
 * @author Acer
 */
public class rekomendasiRenderer extends badgeRenderer{
    
    public rekomendasiRenderer() {
        super(120, FlowLayout.LEFT);
    }
    
    private boolean perluDitinjau(String teks) {
        return teks.equalsIgnoreCase("Perlu Ditinjau");
    }
    
    @Override
    protected Color latar(String teks) {
        return perluDitinjau(teks) ?  new Color(0xFFF3C4) : new Color(0xd5f5e3);
    }
    
    @Override
    protected Color huruf(String teks) {
        return perluDitinjau(teks) ? new Color(0x9A6B00) : new Color(0x2E8B57);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable t, Object v,
            boolean sel, boolean foc, int r, int c) {
        Component com = super.getTableCellRendererComponent(t, v, sel, foc, r, c);
        if (!sel) setBackground(KeputusanCell.warnaBaris(t, r));
        return com;
    }
}
