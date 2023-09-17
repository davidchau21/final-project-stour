/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author educity
 */
public class XImage {
    public static Image getAppIcon(){// hàm này sẽ đọc đc cái icon lấy từ đường dẫn bên dưới
        URL url =XImage.class.getResource("/pic/icon100.png");// tạo cái địa chỉ url chứa đường dẫn ảnh
      return new ImageIcon(url).getImage();// trả về 1 hình ảnh đọc từ đường dẫn và gọi hàm getImage
    }
    
    public static ImageIcon read(String fileName){
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
    
    public static void save(File src){
        File dst = new File("logos", src.getName());
        if(!dst.getParentFile().exists()){
            dst.getParentFile().mkdirs(); // Tạo thư mục logos nếu chưa tồn tại
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from,to, StandardCopyOption.REPLACE_EXISTING); // Copy file vào thư mục logos 
            
        } catch (Exception e) {
             throw new RuntimeException(e);
        }
    }
}
