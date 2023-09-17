/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_table;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LE PHUC HAU
 */
public class ModelTableVe extends DefaultTableModel{
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == TableVe.indexColEdit || columnIndex == TableVe.indexColDelete)
            return getValueAt(0, columnIndex).getClass();
        else
            return super.getColumnClass(columnIndex);
    }
}
