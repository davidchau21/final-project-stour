
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_table;

import connectDB.ConnectDB;
import custom_components.SVGImage;
import dao.DuKhach_DAO;
import entity.DuKhach;
import gui.FrmQLDuKhach;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import utils.VNCharacterUtils;

/**
 *
 * @author Asus
 */
public class TableDuKhach{

    private DefaultTableCellRenderer TEXT_ALIGN_RIGHT = new DefaultTableCellRenderer();
    private DefaultTableCellRenderer TEXT_ALIGN_CENTER = new DefaultTableCellRenderer();
    private DefaultTableCellRenderer TEXT_ALIGN_LEFT = new DefaultTableCellRenderer();
    
    private ModelTableDuKhach modelTableDuKhach;
    
    public static List<DuKhach> dsDuKhach;
    
    public static int indexColEdit = 6;
    public static int indexColDelete = 7;
    
    public static SVGImage iconEdit = new SVGImage("svg/pen-to-square-solid.svg", 17, 17, new Color(23, 217, 182));
    public static SVGImage iconDelete = new SVGImage("svg/trash-solid.svg", 13, 17, new Color(237, 196, 20));
    
    private Object cols[] = {"TT", "Mã DK", "Tên du khách", "Số điện thoại", "Email", "Ghi chú", "", ""};
    
    
    public void createTableDuKhach(JTable tbDuKhach) {
        
        TEXT_ALIGN_RIGHT.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        TEXT_ALIGN_CENTER.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        TEXT_ALIGN_LEFT.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
        
        modelTableDuKhach = new ModelTableDuKhach() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Object o : cols) {
            modelTableDuKhach.addColumn(o);
        }
        
        tbDuKhach.setModel(modelTableDuKhach);
        tbDuKhach.setDefaultRenderer(Object.class, new RendererTableDuKhach());
        tbDuKhach.setRowHeight(30);
        
        TableColumnModel tbDuKhachColumnModel = tbDuKhach.getColumnModel();
        tbDuKhachColumnModel.getColumn(0).setMaxWidth(35);
        tbDuKhachColumnModel.getColumn(1).setMaxWidth(150);
        
        tbDuKhachColumnModel.getColumn(indexColEdit).setMaxWidth(35);
        tbDuKhachColumnModel.getColumn(indexColDelete).setMaxWidth(35);
        
        tbDuKhachColumnModel.getColumn(0).setCellRenderer(TEXT_ALIGN_CENTER);
        tbDuKhachColumnModel.getColumn(1).setCellRenderer(TEXT_ALIGN_CENTER);
        tbDuKhachColumnModel.getColumn(4).setCellRenderer(TEXT_ALIGN_CENTER);
        
        // load data to table
        ConnectDB.connect();
        loadData();
    }
    
    public List<DuKhach> loadData() {
        dsDuKhach = DuKhach_DAO.getAllDuKhach();

        addDataToTable(dsDuKhach);

        return dsDuKhach;
    }
    
    public void addDataToTable(List<DuKhach> dsDuKhach) {
        modelTableDuKhach.setRowCount(0);
        for (int i = 0; i < dsDuKhach.size(); i++) 
        {
            Vector vector = new Vector();
            vector.add(i + 1);
            vector.add(dsDuKhach.get(i).getMaDK());
            vector.add(dsDuKhach.get(i).getTenDK());
            vector.add(dsDuKhach.get(i).getSDT());
//            vector.add(dsDuKhach.get(i).getVaiTro() ? "du khách" : "Quản lý");
            vector.add(dsDuKhach.get(i).getEmail());
            vector.add(dsDuKhach.get(i).getGhiChu());
            vector.add(iconEdit);
            vector.add(iconDelete);
            modelTableDuKhach.addRow(vector);
        }
    }
    
    public List<DuKhach> timKiemDuKhach(String strTimKiem) {
        List<DuKhach> ketQuaTimKiem = new ArrayList<DuKhach>();
        String newStrTimKiem = VNCharacterUtils.removeAccent(strTimKiem).toLowerCase();
        
        for (DuKhach duKhach : dsDuKhach) 
        {
            if(duKhach.getMaDK().toLowerCase().contains(newStrTimKiem) 
                    || duKhach.getTenDK().toLowerCase().contains(newStrTimKiem))
                ketQuaTimKiem.add(duKhach);
                
        }
        return ketQuaTimKiem;
    }
    
    public DuKhach getDuKhach(String maDK) {
        DuKhach duKhach = new DuKhach(maDK);
        int index = TableDuKhach.dsDuKhach.indexOf(duKhach);
        if(index != -1){
            return dsDuKhach.get(index);
        }
            return null;
    }
}
