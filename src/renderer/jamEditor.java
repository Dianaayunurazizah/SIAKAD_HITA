/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import com.formdev.flatlaf.ui.FlatLineBorder;
import java.awt.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author Acer
 */
public class jamEditor extends AbstractCellEditor implements  TableCellEditor {
    
    private final JPanel panel = new JPanel (new FlowLayout(FlowLayout.LEFT,8,9));
    private final JFormattedTextField field;
    
    public jamEditor(){
        try {
            MaskFormatter mask = new MaskFormatter("##:##");
            mask.setPlaceholderCharacter('_');
            field = new JFormattedTextField(mask);
        }catch (ParseException e) {
            throw new IllegalStateException(e);
        }
        field.setHorizontalAlignment(SwingConstants.CENTER);
        field.setFont(new Font("Poppins", Font.PLAIN,14));
        field.setPreferredSize(new Dimension(133, 32));
        field.setBorder(new FlatLineBorder(new Insets(1, 1, 1, 1), new Color(0x3B82F6), 1, 10));
        panel.setBackground(Color.WHITE);
        panel.add(field);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable t, Object v,
            boolean sel, int r, int c) {
        field.setValue(v == null || v.toString().isEmpty() ? null : v.toString());
        return panel;
    }
    @Override
    public Object getCellEditorValue(){
        String s = field.getText();
        return s.equals("__:__") ? "":s;
    }
    @Override
    public boolean stopCellEditing(){
        String s = (String) getCellEditorValue();
        if(!s.isEmpty()&& !s.matches("([01]\\d|2[0-3]):[0-5]\\d")) return false;
        return super.stopCellEditing();
    }
}
