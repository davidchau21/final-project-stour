/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_table;

import custom_components.SVGImage;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererTableDuKhach extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof SVGImage)
        {
            if(column == TableDuKhach.indexColEdit)
            { 
                   return TableDuKhach.iconEdit;
            }
            else if(column == TableDuKhach.indexColDelete)
            {
                return TableDuKhach.iconDelete;
            }
            return (SVGImage)value;
        }
        else
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
    
}
