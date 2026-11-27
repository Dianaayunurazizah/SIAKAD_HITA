/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author Acer
 */
public class KeputusanCell extends AbstractCellEditor implements TableCellRenderer, TableCellEditor{
    public final SegmentToggle toggle = new SegmentToggle();
    
    private static final int KOL_REKOMENDASI = 4;

    public static Color warnaBaris(JTable t, int row) {
        Object v = t.getValueAt(row, KOL_REKOMENDASI);
        return "Perlu ditinjau".equalsIgnoreCase(String.valueOf(v))
                ? new Color(0xFFF1F1) : Color.WHITE;
    }
    
    public KeputusanCell() {
        toggle.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String pilihan = toggle.hit(e.getPoint());
                if (pilihan != null) toggle.setNilai(pilihan);
                fireEditingStopped();
            }
        });
    }
    
    private Component siapkan(JTable t, Object v, int r, boolean sel) {
        toggle.setNilai(String.valueOf(v));
        toggle.setBackground(sel ? t.getSelectionBackground() : warnaBaris(t, r));
        return toggle;
    }

    @Override
    public Component getTableCellRendererComponent(JTable t, Object v,
            boolean sel, boolean foc, int r, int c) {
        return siapkan(t, v, r, sel);
    }

    @Override
    public Component getTableCellEditorComponent(JTable t, Object v,
            boolean sel, int r, int c) {
        return siapkan(t, v, r, false);
    }

    @Override
    public Object getCellEditorValue() { return toggle.getNilai(); }
}
