/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_table;

import custom_components.SVGImage;
import javax.swing.table.DefaultTableModel; 

public class ModelTableTour extends DefaultTableModel {

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == TableTour.indexColEdit || columnIndex == TableTour.indexColDelete)
            return getValueAt(0, columnIndex).getClass();
        else
            return super.getColumnClass(columnIndex);
    }
    
    
}
