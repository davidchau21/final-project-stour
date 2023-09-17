/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom_components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Asus
 */
public class TableCustom extends JTable {

    private Color headerColor;
    private Color headerFontColor;
    private Font headerFont;
    private int headerHeight;
    private int headerTextAlign;
    
    
    public int getHeaderTextAlign() {
        return headerTextAlign;
    }

    public void setHeaderTextAlign(int headerTextAlign) {
        this.headerTextAlign = headerTextAlign;
        
        switch (headerTextAlign) {
            case 0:
                ((DefaultTableCellRenderer)this.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
                break;
            case 1:
                ((DefaultTableCellRenderer)this.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                break;
            case 2:
                ((DefaultTableCellRenderer)this.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.RIGHT);
                break;
        }
    }

    public Color getHeaderFontColor() {
        return headerFontColor;
    }

    public void setHeaderFontColor(Color headerFontColor) {
        this.headerFontColor = headerFontColor;
        this.getTableHeader().setForeground(headerFontColor);
    }

    public Font getHeaderFont() {
        return headerFont;
    }

    public void setHeaderFont(Font headerFont) {
        this.headerFont = headerFont;
        this.getTableHeader().setFont(headerFont);
    }

    public int getHeaderHeight() {
        return headerHeight;
    }

    public void setHeaderHeight(int headerHeight) {
        this.headerHeight = headerHeight;
        this.getTableHeader().setPreferredSize(new Dimension(getWidth(), headerHeight));
    }
    
    public Color getHeaderColor() {
        return headerColor;
    }

    public void setHeaderColor(Color headerColor) {
        this.headerColor = headerColor;
        this.getTableHeader().setOpaque(false);
        this.getTableHeader().setBackground(headerColor);
    }

    
    
    

    
    
}
