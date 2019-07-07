package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;

import java.awt.*;

public class MapMarkerImage extends MapMarkerCircle {
    public static final double defaultMarkerSize = 20.0;
    private Image image;
    private String tweetText;
    private Coordinate coord;

    public MapMarkerImage(Layer layer, Coordinate coord, Color color, Image image, String tweetText) {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(color);
        setBackColor(color);
        this.image = image;
        this.tweetText = tweetText;
        this.coord = coord;
    }

    @Override
    public void paint(Graphics g, Point position, int radius) {
        int size = radius * 2;
        if(g instanceof Graphics2D && this.getBackColor() != null) {
            Graphics2D g2 = (Graphics2D)g;
            Composite oldComposite = g2.getComposite();
            g2.setComposite(AlphaComposite.getInstance(3));
            g2.setPaint(this.getBackColor());
            g.fillOval(position.x - radius, position.y - radius, size, size);
            g2.setComposite(oldComposite);
        }

        int width = (int) (this.image.getWidth(null));
        int height = (int) (this.image.getHeight(null));

        g.setColor(this.getColor());
        g.drawOval(position.x - radius, position.y - radius, size, size);
        g.drawImage(this.image, position.x - width/2, position.y - height/2, width, height, null);
        if(this.getLayer() == null || this.getLayer().isVisibleTexts().booleanValue()) {
            this.paintText(g, position);
        }

    }

    public String getTweetText() {
        return tweetText;
    }

    public Image getImage() {
        return image;
    }
}

