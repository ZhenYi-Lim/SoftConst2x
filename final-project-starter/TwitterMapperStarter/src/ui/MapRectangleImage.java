package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapRectangleImpl;

import javax.swing.*;
import java.awt.*;

public class MapRectangleImage extends MapRectangleImpl {
    private Color color;
    private Image image;
    private Point position;
    private String text;

    private static int OFFSET = 10;
    private static int MARGIN = 5;

    public MapRectangleImage(Coordinate topLeft, Coordinate bottomRight, Color color, Image image, Point position, String text) {
        super(topLeft, bottomRight);
        this.color = color;
        this.image = image;
        this.position = position;
        this.text = text;
    }

    @Override
    public void paint(Graphics g, Point topLeft, Point bottomRight) {
        if (g instanceof Graphics2D && this.getBackColor() != null) {
            Graphics2D g2 = (Graphics2D) g;
            Composite oldComposite = g2.getComposite();
            g2.setComposite(AlphaComposite.getInstance(3));
            g2.setPaint(this.getBackColor());
            g2.setComposite(oldComposite);
        }

        int rectX = position.x + OFFSET;
        int rectY = position.y + OFFSET;

        int imgX = rectX + MARGIN;
        int imgY = rectY + MARGIN;

        int imgWidth = (int) (this.image.getWidth(null));
        int imgHeight = (int) (this.image.getHeight(null));

        FontMetrics metrics = g.getFontMetrics();
        int txtWidth = SwingUtilities.computeStringWidth(metrics, text);
        int txtHeight = metrics.getHeight();

        int rectWidth = imgWidth + txtWidth + 3* MARGIN;
        int rectHeight = imgHeight + 2* MARGIN;

        int txtX = rectX + imgWidth + 2* MARGIN;
        int txtY = rectY + imgHeight - (imgHeight-txtHeight)/2 + MARGIN - 3; //assumes imgHeight > txtHeight

        g.setColor(this.color);
        g.drawRect(rectX, rectY, rectWidth, rectHeight);
        g.fillRect(rectX, rectY, rectWidth, rectHeight);
        g.drawImage(this.image, imgX, imgY, null);
        g.setColor(Color.black);
        g.drawString(text, txtX, txtY);
    }
}
