/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */

public class PanelCustom{
    
    private JLabel icon;
    private JLabel tulisan;
    private JLabel arrow;
    private JPanel panel;
    
    private Icon iconNormal;
    private Icon iconAktif;
    
    private Icon arrowNormal;
    private Icon arrowAktif;
    
    private boolean hover = false;
    private boolean aktif = false;
    
    //warna button
    private Color warnaNormal = new Color(255, 255, 255);
    private Color warnaHover = new Color(239, 239, 240);
    private Color warnaAktif = new Color(35, 128, 234);
    
    //warna teks & icon
    private Color teksNormal = new Color(124, 126, 137);
    private Color teksAktif = new Color(255, 255, 255);
    
    //constructor
    public PanelCustom(JLabel icon, JLabel tulisan, JLabel arrow, JPanel panel){
        this.icon = icon;
        this.tulisan = tulisan;
        this.arrow = arrow;
        this.panel = panel;
        
        panel.setOpaque(true);
        panel.setBackground(warnaNormal);
        
        //kondisi awal
        icon.setIcon(iconNormal);
        tulisan.setForeground(teksNormal);
        if (arrow != null){
            arrow.setIcon(arrowNormal);
        }
        
        tambahMouseListener();
    }
    
    public PanelCustom(JLabel icon, JLabel tulisan, JPanel panel){
        this.icon = icon;
        this.tulisan = tulisan;
        this.panel = panel;
        
        panel.setOpaque(true);
        panel.setBackground(warnaNormal);
        
        //kondisi awal
        icon.setIcon(iconNormal);
        tulisan.setForeground(teksNormal);
        
        tambahMouseListener();
    }
    
    //mouselistener
    private void tambahMouseListener(){
        
        panel.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e){
                
                hover = true;
                
                if (!aktif){
                    panel.setBackground(warnaHover);
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                
                hover = false;
                
                if (!aktif){
                    panel.setBackground(warnaNormal);
                }
            }
        });
    }
    
    //aktif
    public void setAktif(boolean aktif){
        
        this.aktif = aktif;
        
        if (aktif){
            
            panel.setBackground(warnaAktif);            
            icon.setIcon(iconAktif);            
            tulisan.setForeground(teksAktif);            
            if (arrow != null) arrow.setIcon(arrowAktif);
            
        } else {
            
            panel.setBackground(warnaNormal);            
            icon.setIcon(iconNormal);           
            tulisan.setForeground(teksNormal);
            if (arrow != null) arrow.setIcon(arrowNormal);
        }
    }
    
    public boolean isAktif(){
        return aktif;
    }
    
    //icon normal
    public void setIconNormal(Icon iconNormal){
        this.iconNormal = iconNormal;
        
        if (!aktif){
            icon.setIcon(iconNormal);
        }
    }
    
    public Icon getIconNormal(){
        return iconNormal;
    }
    
    //icon aktif
    public void setIconAktif(Icon iconAktif){
        this.iconAktif = iconAktif;
        
        if (aktif){
            icon.setIcon(iconAktif);
        }
    }
    
    public Icon getIconAktif(){
        return iconAktif;
    }
    
     //arrow normal
    public void setArrowNormal(Icon arrowNormal){
        this.arrowNormal = arrowNormal;
        
        if (!aktif && arrow != null){
            arrow.setIcon(arrowNormal);
        }
    }
    
    public Icon getArrowNormal(){
        return arrowNormal;
    }
    
    //arrow aktif
    public void setArrowAktif(Icon arrowAktif){
        this.arrowAktif = arrowAktif;
        
        if (aktif && arrow != null){
            arrow.setIcon(arrowAktif);
        }
    }
    
    public Icon getArrowAktif(){
        return arrowAktif;
    }
    
    
    //warna normal
    public void setWarnaNormal(Color warnaNormal){
        this.warnaNormal = warnaNormal;
        
        if (!aktif && !hover){
            panel.setBackground(warnaNormal);
        }
    }
    
    public Color getWarnaNormal(){
        return warnaNormal;
    }
    
    //warna hover
    public void setWarnaHover(Color warnaHover){
        this.warnaHover = warnaHover;
        
        if (!aktif && hover){
            panel.setBackground(warnaHover);
        }
    }
    
    public Color getWarnaHover(){
        return warnaHover;
    }
    
    //warna aktif
    public void setWarnaAktif(Color warnaAktif){
        this.warnaAktif = warnaAktif;
        
        if (aktif){
            panel.setBackground(warnaAktif);
        }
    }
    
    public Color getWarnaAktif(){
        return warnaAktif;
    }
    
    //teks normal
    public void setTeksNormal(Color teksNormal){
        this.teksNormal = teksNormal;
        
        if (!aktif){
            tulisan.setForeground(teksNormal);
        }
    }
    
    public Color getTeksNormal(){
        return teksNormal;
    }
    
    //teks aktif
    public void setTeksAktif(Color teksAktif){
        this.teksAktif = teksAktif;
        
        if (aktif){
            tulisan.setForeground(teksAktif);
        }
    }
    
    public Color getTeksAktif(){
        return teksAktif;
    }
    
}
