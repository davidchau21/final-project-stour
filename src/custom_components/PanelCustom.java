/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom_components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class PanelCustom extends JPanel {

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }
    
    public Color getBorderColorHover() {
        return borderColorHover;
    }

    public void setBorderColorHover(Color borderColorHover) {
        this.borderColorHover = borderColorHover;
    }

    private boolean hover;
    private Color color;
    private Color colorHover;
    private Color colorClick;
    private Color borderColor;
    private Color borderColorTemp;
    private Color borderColorHover;
    private int radius;
    private int borderSize;

    public PanelCustom() {
        setColor(Color.WHITE);
        colorHover = Color.GRAY;
        colorClick = Color.red;
        borderColor = Color.black;
        borderColorHover = new Color(0, 153, 255);
        borderSize = 1;
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorHover);
                borderColorTemp = borderColor;
                setBorderColor(borderColorHover);
                hover = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(color);
                setBorderColor(borderColorTemp);
                hover = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (hover) {
                    setBackground(colorHover);
                } else {
                    setBackground(color);
                }
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2.setColor(getBackground());
        g2.fillRoundRect(borderSize, borderSize, getWidth() - borderSize * 2, getHeight() - borderSize * 2,
                radius - borderSize - getWidth() / 100,
                radius - borderSize - getWidth() / 100);
        super.paintComponent(g);
    }
    
    
}
