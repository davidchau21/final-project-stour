/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom_components;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.util.function.Function;
import javax.swing.JLabel;

/**
 *
 * @author Asus
 */
public class SVGImage extends JLabel {
    
    private FlatSVGIcon svgIcon;

    public SVGImage() {
    
    }
    
    public SVGImage(String image, int width, int height, Color iconColor) {
        setSVGImage(image, width, height);
        setColor(iconColor);
    }
    
    public SVGImage(String image, int width, int heigth) {
        setSVGImage(image, width, HEIGHT);
    }
    
    public void setSVGImage(String image, int width, int height)
    {
        svgIcon = new FlatSVGIcon(image, width, height);
        setIcon(svgIcon);
    }
    
    public void setColor(Color iconColor) {
        if(svgIcon != null)
        {
            svgIcon.setColorFilter(new FlatSVGIcon.ColorFilter(new Function<Color, Color>() {
                @Override
                public Color apply(Color t) {
                    return iconColor;
                }
            }));
            SVGImage.this.repaint();
        }
    }
}
