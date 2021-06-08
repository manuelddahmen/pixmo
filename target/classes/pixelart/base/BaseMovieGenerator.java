/*     */
package pixelart.base;
/*     */
/*     */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

public abstract class BaseMovieGenerator {
    protected boolean isGui;
        protected String dossier = "";
    protected String prefix = "";
    protected int largeur = 1388;
    protected int hauteur = 768;
    protected BufferedImage image = null;
    protected Graphics2D g = null;
    protected Graphics gPrim;
    protected JPanel jPanel;
    protected int frame0;
    private int frame = 100000;
    private JLabel label;
    public BaseMovieGenerator(String dossier, String prefix, int largeur, int hauteur, boolean isGui) {

        this.dossier = dossier;
        this.prefix = prefix;
        this.largeur = largeur;
        this.hauteur = hauteur;

        this.isGui = isGui;
        new File(dossier).mkdirs();
    }

    private Graphics g2;
    public static void doIt() {
    }

    public static void doit(BaseMovieGenerator b) {
        b.
                doit(b, null);
    }

    public int frame() {
        return frame;
    }
    public void creerImage() {
        this.image = new BufferedImage(this.largeur, this.hauteur, BufferedImage.TYPE_INT_ARGB);
        this.g = this.image.createGraphics();
        if (isGui)
            this.g2 = this.jPanel.getGraphics();
    }

    public void enregistrerImage() {
        try {
            String filename = this.dossier + File.separator + this.prefix + this.frame + ".jpg";
            this.frame++;

            System.out.println(new File(filename).getAbsolutePath());

            if(image!=null) {
                ImageIO.write(this.image, "jpg", new File(filename));
            }
            else
                throw new NullPointerException("Image is null (BaseMovieGenerator");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void initMontrerImage() {
        if (isGui) {
            JFrame jjFrame = new JFrame("Video");
            this.jPanel = new JPanel();
            this.jPanel.setMinimumSize(new Dimension(this.largeur, this.hauteur));
            jjFrame.add(this.jPanel);
            jjFrame.setContentPane(this.jPanel);
            jjFrame.setMinimumSize(new Dimension(this.largeur, this.hauteur));
            this.jPanel.setBounds(0, 0, this.largeur, this.hauteur);
            jjFrame.setDefaultCloseOperation(3);
            jjFrame.pack();
            jjFrame.setVisible(true);
        }
    }
    public void montrerImage() {
    }

    public String getDossier() {
        return this.dossier;
    }
    public String getPrefix() {
        return this.prefix;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public int getHauteur() {
        return this.hauteur;
    }

    public int getFrame() {
        return this.frame;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public int getFrame0() {
        return this.frame0;
    }

    public void doit(BaseMovieGenerator b, Hashtable<String, Object> params) {
        if (params == null)
            params = new Hashtable();
        b.frame0 = 0;
        b.init(params);
        b.initMontrerImage();

        for (int i = 0; i < 12590/*((Integer) params.get("nombre")).intValue()*/; i++) {
            b.initImage();
            b.creerImage();
            b.initImage();
            b.dessiner();
            b.enregistrerImage();
            System.out.println(i);
            this.frame0++;

        }
    }

    public abstract void init(Hashtable<String, Object> paramHashtable);

    public abstract void initImage();
    public abstract void dessiner();
    public abstract void modifierImage();

    public void setRGB(int x, int y, Color color) {
        image.setRGB(x, y, color.getRGB());
        if (isGui) {
            g2.drawRect((int) (1.0 * x / image.getWidth() * jPanel.getWidth()),
                    (int) (1.0 * y / image.getHeight() * jPanel.getHeight())
                    , 1, 1);
        }
    }

    public Color

    getRGB(int x, int y) {
        return new Color(image.getRGB(x, y));
    }
}


