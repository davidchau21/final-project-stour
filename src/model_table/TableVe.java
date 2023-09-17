/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_table;

import connectDB.ConnectDB;
import custom_components.SVGImage;
import entity.Ve;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import utils.VNCharacterUtils;
import dao.VeDAO;
import java.text.DecimalFormat;

/**
 *
 * @author LE PHUC HAU
 */
public class TableVe {
    private DefaultTableCellRenderer TEXT_ALIGN_RIGHT = new DefaultTableCellRenderer();
    private DefaultTableCellRenderer TEXT_ALIGN_CENTER = new DefaultTableCellRenderer();
    private DefaultTableCellRenderer TEXT_ALIGN_LEFT = new DefaultTableCellRenderer();
    
    private ModelTableVe modelTableVe;
    
    public static List<Ve> dsVe;
    
    public static int indexColEdit = 7;
    public static int indexColDelete = 8;
    
    public static SVGImage iconEdit = new SVGImage("svg/pen-to-square-solid.svg", 17, 17, new Color(23, 217, 182));
    public static SVGImage iconDelete = new SVGImage("svg/trash-solid.svg", 13, 17, new Color(237, 196, 20));
    
    private Object cols[] = {"TT", "Mã Vé", "Mã Du Khách", "Tên Tour", "Mã Lộ Trình", "Giá Vé", "Ghi chú", "", ""};
    
    
    public void createTableVe(JTable tbVe) {
        
        TEXT_ALIGN_RIGHT.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        TEXT_ALIGN_CENTER.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        TEXT_ALIGN_LEFT.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
        
        modelTableVe = new ModelTableVe() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Object o : cols) {
            modelTableVe.addColumn(o);
        }
        
        tbVe.setModel(modelTableVe);
        tbVe.setDefaultRenderer(Object.class, new RendererTableNhanVien());
        tbVe.setRowHeight(30);
        
        TableColumnModel tbVeColumnModel = tbVe.getColumnModel();
        tbVeColumnModel.getColumn(0).setMaxWidth(35);
        tbVeColumnModel.getColumn(1).setMaxWidth(150);
        
        tbVeColumnModel.getColumn(indexColEdit).setMaxWidth(35);
        tbVeColumnModel.getColumn(indexColDelete).setMaxWidth(35);
        
        tbVeColumnModel.getColumn(0).setCellRenderer(TEXT_ALIGN_CENTER);
        tbVeColumnModel.getColumn(1).setCellRenderer(TEXT_ALIGN_CENTER);
        tbVeColumnModel.getColumn(4).setCellRenderer(TEXT_ALIGN_CENTER);
        
        // load data to table
        ConnectDB.connect();
        loadData();
    }
    
    public List<Ve> loadData() {
        dsVe = VeDAO.getAllVe();

        addDataToTable(dsVe);

        return dsVe;
    }
    
    public void addDataToTable(List<Ve> dsVe) {
        modelTableVe.setRowCount(0);
        DecimalFormat df = new DecimalFormat("###,000");
        for (int i = 0; i < dsVe.size(); i++) 
        {
            Vector vector = new Vector();
            vector.add(i + 1);
            vector.add(dsVe.get(i).getMaVe());
            vector.add(dsVe.get(i).getMaDK());
            vector.add(dsVe.get(i).getTenTour());
            vector.add(dsVe.get(i).getMaLoTrinh());
            vector.add(df.format(dsVe.get(i).getGiaVe()));
            vector.add(dsVe.get(i).getGhiChu());
            vector.add(iconEdit);
            vector.add(iconDelete);
            modelTableVe.addRow(vector);
        }
    }
    
    public List<Ve> findVe(int ma){
       dsVe = VeDAO.selectfindVe(ma);
       return dsVe;
   }
    
    public Ve getVe(int maV) {
        Ve ve = new Ve(maV);
        int index = TableVe.dsVe.indexOf(ve);
        if(index >= 0)
            return dsVe.get(index);
        return null;
    }
}
