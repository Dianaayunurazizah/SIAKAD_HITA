/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author Acer
 */
public class absensiGuruRenderer extends JPanel implements TableCellRenderer{
    
    private final JLabel kotak = new JLabel("", SwingConstants.CENTER);
    
    public absensiGuruRenderer(){
        setLayout(new FlowLayout(FlowLayout.LEFT,8,9));
        setOpaque(true);
        kotak.setOpaque(true);
        kotak.setBackground(Color.WHITE);
        kotak.setFont(new Font("Poppins", Font.PLAIN, 14));
        kotak.setForeground(new Color(0x111827));
        kotak.setBorder(new FlatLineBorder(new Insets(1, 1, 1, 1), new Color(0xD1D5DB),1,10));
        kotak.setPreferredSize(new Dimension(133,32));
        add(kotak);
    }        
        @Override
        public Component getTableCellRendererComponent(JTable t, Object v,
        boolean sel, boolean foc, int r, int c) {
            setBackground(sel ? t.getSelectionBackground() : Color.WHITE);
            kotak.setText(v ==  null ? "" : v.toString());
            return this;
        }
}
