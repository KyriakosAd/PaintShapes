import java.awt.*;
import java.awt.geom.Area;

class FullShape {
    int option;
    int initX;
    int initY;
    int finalX;
    int finalY;
    int shapeWidth;
    int shapeHeight;
    Area combinedShape;
    Color fill = new Color(255, 255, 255, 0);
    Color outline = new Color(150, 150, 150);
    Shape actualShape;
    Graphics g = GUI.canvas.getGraphics();
    Graphics2D g2d = (Graphics2D) g;
    RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
    );

    FullShape(int initX, int initY, int finalX, int finalY, int option){
        this.option = option;
        this.initX = initX;
        this.initY = initY;
        this.finalX = finalX;
        this.finalY = finalY;
    }
}
    