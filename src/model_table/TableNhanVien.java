/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_table;

import connectDB.ConnectDB;
import custom_components.SVGImage;
import dao.NhanVien_DAO;
import entity.NhanVien;
import gui.FrmQLNhanVien;
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
public class TableNhanVien{

    private DefaultTableCellRenderer TEXT_ALIGN_RIGHT = new DefaultTableCellRenderer();
    private DefaultTableCellRenderer TEXT_ALIGN_CENTER = new DefaultTableCellRenderer();
    private DefaultTableCellRenderer TEXT_ALIGN_LEFT = new DefaultTableCellRenderer();
    
    private ModelTableNhanVien modelTableNhanVien;
    
    public static List<NhanVien> dsNhanVien;
    
    public static int indexColEdit = 7;
    public static int indexColDelete = 8;
    
    public static SVGImage iconEdit = new SVGImage("svg/pen-to-square-solid.svg", 17, 17, new Color(23, 217, 182));
    public static SVGImage iconDelete = new SVGImage("svg/trash-solid.svg", 13, 17, new Color(237, 196, 20));
    
    private Object cols[] = {"TT", "Mã NV", "Tên nhân viên", "Số điện thoại", "Vai trò", "Email", "Ghi chú", "", ""};
    
    
    public void createTableNhanVien(JTable tbNhanVien) {
        
        TEXT_ALIGN_RIGHT.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        TEXT_ALIGN_CENTER.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        TEXT_ALIGN_LEFT.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
        
        modelTableNhanVien = new ModelTableNhanVien() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        for (Object o : cols) {
            modelTableNhanVien.addColumn(o);
        }
        
        tbNhanVien.setModel(modelTableNhanVien);
        tbNhanVien.setDefaultRenderer(Object.class, new RendererTableNhanVien());
        tbNhanVien.setRowHeight(30);
        
        TableColumnModel tbNhanVienColumnModel = tbNhanVien.getColumnModel();
        tbNhanVienColumnModel.getColumn(0).setMaxWidth(35);
        tbNhanVienColumnModel.getColumn(1).setMaxWidth(150);
        
        tbNhanVienColumnModel.getColumn(indexColEdit).setMaxWidth(35);
        tbNhanVienColumnModel.getColumn(indexColDelete).setMaxWidth(35);
        
        tbNhanVienColumnModel.getColumn(0).setCellRenderer(TEXT_ALIGN_CENTER);
        tbNhanVienColumnModel.getColumn(1).setCellRenderer(TEXT_ALIGN_CENTER);
        tbNhanVienColumnModel.getColumn(4).setCellRenderer(TEXT_ALIGN_CENTER);
        
        // load data to table
        ConnectDB.connect();
        loadData();
    }
    
    public List<NhanVien> loadData() {
        dsNhanVien = NhanVien_DAO.getAllNhanVien();

        addDataToTable(dsNhanVien);

        return dsNhanVien;
    }
    
    public void addDataToTable(List<NhanVien> dsNhanVien) {
        modelTableNhanVien.setRowCount(0);
        for (int i = 0; i < dsNhanVien.size(); i++) 
        {
            Vector vector = new Vector();
            vector.add(i + 1);
            vector.add(dsNhanVien.get(i).getMaNV());
            vector.add(dsNhanVien.get(i).getTenNV());
            vector.add(dsNhanVien.get(i).getSDT());
            vector.add(dsNhanVien.get(i).getVaiTro() ? "Nhân viên" : "Quản lý");
            vector.add(dsNhanVien.get(i).getEmail());
            vector.add(dsNhanVien.get(i).getGhiChu());
            vector.add(iconEdit);
            vector.add(iconDelete);
            modelTableNhanVien.addRow(vector);
        }
    }
    
    public List<NhanVien> timKiemNhanVien(String strTimKiem) {
        List<NhanVien> ketQuaTimKiem = new ArrayList<NhanVien>();
        String newStrTimKiem = VNCharacterUtils.removeAccent(strTimKiem).toLowerCase();
        
        for (NhanVien nhanVien : dsNhanVien) 
        {
            if(nhanVien.getMaNV().toLowerCase().contains(newStrTimKiem) 
                    || VNCharacterUtils.removeAccent(nhanVien.getTenNV()).toLowerCase().contains(newStrTimKiem))
                ketQuaTimKiem.add(nhanVien);
                
        }
        return ketQuaTimKiem;
    }
    
    public NhanVien getNhanVien(String maNV) {
        NhanVien nhanVien = new NhanVien(maNV);
        int index = TableNhanVien.dsNhanVien.indexOf(nhanVien);
        if(index >= 0)
            return dsNhanVien.get(index);
        return null;
    }
}
