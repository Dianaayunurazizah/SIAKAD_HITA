/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author Acer
 */
public class aksiRenderer extends JPanel implements TableCellRenderer{
    
    private final JLabel[] ikon;
    
    //FLOW layout center buat titik tiga, FLOW layout left untuk pensil dan hapus
    public aksiRenderer(int rata, String... pathIkon){
        setLayout(new FlowLayout(rata,12,16));
        setOpaque(true);
        ikon = new JLabel[pathIkon.length];
        for (int i =0; i < pathIkon.length; i++){
            ikon[i] = new JLabel(new FlatSVGIcon(pathIkon[i],20,20));
            add(ikon[i]);
        }
    }
            
    @Override
    public Component getTableCellRendererComponent(JTable t, Object v,
            boolean sel, boolean foc, int r, int c) {
        setBackground(sel ? t.getSelectionBackground():Color.WHITE);
        return this;
    }
    
    public int ikonDiKlik(JTable t, int baris, int kolom, Point titik) {
        Rectangle sel = t.getCellRect(baris, kolom,false);
        setSize(sel.width, sel.height);
        doLayout();
        Component yangKena = getComponentAt(titik.x - sel.x, titik.y-sel.y);
        for (int i = 0 ; i<ikon.length; i++) {
            if (yangKena == ikon[i]) return i;
        }
        return -1;
    }
}
