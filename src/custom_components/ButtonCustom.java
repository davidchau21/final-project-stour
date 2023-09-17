/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom_components;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Function;
import javax.swing.JButton;
import javax.swing.plaf.BorderUIResource;

/**
 *
 * @author Asus
 */
public class ButtonCustom extends JButton {
    private boolean hover;
    private Color color;
    private Color colorHover;
    private Color colorClick;
    private Color borderColor;
    private int radius;
    private int borderSize;

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }
    
    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public Color getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public ButtonCustom() {
        setColor(Color.WHITE);
        colorHover = Color.GRAY;
        colorClick = Color.red;
        borderColor = Color.black;
        borderSize = 1;
        setOpaque(false);
        
        setContentAreaFilled(false);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorHover);
                hover = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(color);
                hover = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               if(hover)
                   setBackground(colorHover);
               else
                   setBackground(color);
            }
            
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        g2.fillRoundRect(borderSize, borderSize, getWidth() - borderSize * 2, getHeight() - borderSize * 2,
                radius - borderSize - getWidth() / 100,
                radius - borderSize - getWidth() / 100);
        super.paintComponent(g);
    }
    
    private FlatSVGIcon svgIcon;
    
    public void setSVGImage(String image, int width, int height)
    {
        svgIcon = new FlatSVGIcon(image, width, height);
        setIcon(svgIcon);
    }
    
    public void setSVGImage(String image, int width, int height, Color color) {
        setSVGImage(image, width, height);
        setIconColor(color);
    }
    
    public void setIconColor(Color iconColor) {
        if(svgIcon != null)
        {
            svgIcon.setColorFilter(new FlatSVGIcon.ColorFilter(new Function<Color, Color>() {
                @Override
                public Color apply(Color t) {
                    return iconColor;
                }
            }));
            ButtonCustom.this.repaint();
        }
    }
}
