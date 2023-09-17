/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model_table;

import custom_components.SVGImage;
import entity.Tour;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectOutput;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumnModel;
import connectDB.ConnectDB;
import dao.Tour_DAO;
import java.text.DecimalFormat;
import java.util.Vector;
/**
 *
 * @author Asus
 */
public class TableTour{
    
    private ModelTableTour modelTableTour;
    
    private static DefaultTableCellRenderer TEXT_ALIGN_RIGHT = new DefaultTableCellRenderer();
    private static DefaultTableCellRenderer TEXT_ALIGN_CENTER = new DefaultTableCellRenderer();
    private static DefaultTableCellRenderer TEXT_ALIGN_LEFT = new DefaultTableCellRenderer();
    
   
    
    public static List<Tour> lstTour;
    
    public static int indexColEdit = 5;
    public static int indexColDelete = 6;
    
    private Object[] cols = {"Mã Tour","Tên Tour","Số Ngày","Giá Tour","Ghi Chú","",""};
    
    public static SVGImage iconEdit = new SVGImage("svg/pen-to-square-solid.svg", 17, 17, new Color(23, 217, 182));
    public static SVGImage iconDelete = new SVGImage("svg/trash-solid.svg", 13, 17, new Color(237, 196, 20));
    
    
    public void createTableTour(JTable tb) {
        
        TEXT_ALIGN_RIGHT.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        TEXT_ALIGN_CENTER.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        TEXT_ALIGN_LEFT.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
        
        modelTableTour = new ModelTableTour(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //return super.isCellEditable(row, column); 
                return false;
            } 
    };
        
        //them tieu de cot
        for (Object col : cols ) {
            modelTableTour.addColumn(col);
        }
        
        tb.setModel(modelTableTour);
        tb.setDefaultRenderer(Object.class, new RendererTableTour());
        tb.setRowHeight(35);
        
        TableColumnModel tbTourColumnModel = tb.getColumnModel();
        
        //set width cho cot
        tbTourColumnModel.getColumn(0).setMaxWidth(100);
        tbTourColumnModel.getColumn(indexColEdit).setMaxWidth(35);
        tbTourColumnModel.getColumn(indexColDelete).setMaxWidth(35);
        
        tbTourColumnModel.getColumn(0).setCellRenderer(TEXT_ALIGN_CENTER);
        tbTourColumnModel.getColumn(2).setCellRenderer(TEXT_ALIGN_RIGHT);
        tbTourColumnModel.getColumn(3).setCellRenderer(TEXT_ALIGN_RIGHT);
        tbTourColumnModel.getColumn(4).setCellRenderer(TEXT_ALIGN_CENTER);
        
        
        ConnectDB.connect();
        loadDataTour();
         
   }
    
   public void loadDataTour(){
       lstTour = Tour_DAO.getAllTour();
       modelTableTour.setRowCount(0);
       DecimalFormat df = new DecimalFormat("###,000");
       for (Tour t : lstTour){
           modelTableTour.addRow(new Object[]{t.getMaTour(),
                                                t.getTenTour(),
                                                t.getSoNgay(),
                                                df.format(t.getGiaTour()),
                                                t.getGhiChu(),
                                                iconEdit,
                                                iconDelete
           });
       }
   }
   
   public List<Tour> findTour(String ma){
       lstTour = Tour_DAO.selectfindTours(ma);
       return lstTour;
   }
   
   public Tour getTour(String ma){
       Tour t = new Tour(ma);
       int index = TableTour.lstTour.indexOf(t);
       if(index !=- 1 ){
           return lstTour.get(index);
       }
       return null;
   }
   
   public void addDataToTable(List<Tour> ds) {
        modelTableTour.setRowCount(0);
        DecimalFormat df = new DecimalFormat("###,000");
        for (int i = 0; i < ds.size(); i++) 
        {
            Vector vector = new Vector();
            vector.add(ds.get(i).getMaTour());
            vector.add(ds.get(i).getTenTour());
            vector.add(ds.get(i).getSoNgay());
            vector.add(df.format(ds.get(i).getGiaTour()));
            vector.add(ds.get(i).getGhiChu());
            vector.add(iconEdit);
            vector.add(iconDelete);
            modelTableTour.addRow(vector);
        }
    }
}
