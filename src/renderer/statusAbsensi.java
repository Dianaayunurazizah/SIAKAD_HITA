/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package renderer;

import java.awt.Color;
/**
 *
 * @author Acer
 */
public enum statusAbsensi {
    HADIR("Hadir", new Color(0xDBEAFE), new Color(0x2563EB)),
    IZIN("Izin", new Color(0xE0E7FF), new Color(0x4F46E5)),
    SAKIT("Sakit", new Color(0xFEF3C7), new Color(0xB45309)),
    ALPA("Alpa", new Color(0xFEE2E2), new Color(0xDC2626));
    
    public final String label;
    public final Color latar, huruf;

    statusAbsensi(String label, Color latar, Color huruf) {
        this.label = label;
        this.latar = latar;
        this.huruf = huruf;
    }
    
    
}
