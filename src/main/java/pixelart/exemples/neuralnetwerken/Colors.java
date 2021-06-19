/*    */
package pixelart.exemples.neuralnetwerken;

import pixelart.base.BaseMovieGenerator;

import java.awt.*;
import java.util.Hashtable;


 public class Colors
        /*    */ extends BaseMovieGenerator
        /*    */ {
    private static final int NUMFRAMES = 25 * 60 * 6;
    private pixelart.exemples.neuralnetwerken.ColorNetwerk cn = null;

    /*    */
    /*    */
    public Colors(String dossier, String prefix, int largeur, int hauteur, boolean isGui) {
        /* 22 */
        super(dossier, prefix, largeur, hauteur, isGui);
        this.cn = new pixelart.exemples.neuralnetwerken.ColorNetwerk(this.largeur, this.hauteur, 20, 5);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public static void main(String[] args) {
        /* 69 */
        String path = "colors";
        /* 70 */
        boolean isGui = false;
        if (args.length > 0)
            /* 71 */ path = args[0];
        if (args.length > 1)
            isGui = Boolean.parseBoolean(args[1]);
        /* 72 */
        Colors c = new Colors(path, "im2-", 1388, 768, isGui);
        doit(c);
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void initImage() {
        /* 28 */
        this.cn.update();
        /* 29 */
        this.cn.compute();
        /* 30 */
        int x = this.largeur / 2;
        /* 31 */
        int y = this.hauteur / 2;
        /* 32 */
        System.out.println("Max =  " + (this.cn.getRes()[1][x][y] * this.cn.getFacteur()));
        /* 33 */
        g = (Graphics2D) image.getGraphics();
        g.setColor(Color.black);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public void dessiner() {
        /*    */
        /* 39 */
        //Graphics aThisjPanelGraphics = this.jPanel.getGraphics();
        Graphics g = image.getGraphics();
        for (int x = 0; x < this.largeur; x++) {
            /* 40 */
            for (int y = 0; y < this.hauteur; y++) {
                /* 41 */
                g = this.image.getGraphics();
                /* 47 */

                Color color = new Color((
                        /* 48 */               (int) (this.cn.getRes()[0][x][y] * this.cn.getFacteur()) << 16) + (
                        /* 49 */               (int) (this.cn.getRes()[1][x][y] * this.cn.getFacteur()) << 8) +
                        /* 50 */               (int) (this.cn.getRes()[2][x][y] * this.cn.getFacteur()));

                g.setColor(color);
                /* 51 */
                setRGB(x, y, color);
            }
            /* 53 */
        }
        //g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        System.out.println("+");
        /*    */
    }


    public void modifierImage() {
    }


    public void init(Hashtable<String, Object> objects) {
    }

}


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\exemples\neuralnetwerken\Colors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */