/*    */
package pixelart.exemples.neuralnetwerken;

import pixelart.base.BaseMovieGenerator;

import java.awt.*;
import java.util.Hashtable;


 public class Colors extends BaseMovieGenerator {
    private static final int NUMFRAMES = 25 * 60 * 6;
    private pixelart.exemples.neuralnetwerken.ColorNetwerk cn = null;

    public Colors(String dossier, String prefix, int largeur, int hauteur, boolean isGui) {
        super(dossier, prefix, largeur, hauteur, isGui);
        this.cn = new pixelart.exemples.neuralnetwerken.ColorNetwerk(this.largeur, this.hauteur, 20, 5);
    }

    public static void main(String[] args) {
        String path = "colors";
        boolean isGui = false;
        if (args.length > 0)
            path = args[0];
        if (args.length > 1)
            isGui = Boolean.parseBoolean(args[1]);
        Colors c = new Colors(path, "im2-", 1388, 768, isGui);
        doit(c);
    }

    public void initImage() {
        this.cn.update();
        this.cn.compute();
        int x = this.largeur / 2;
        int y = this.hauteur / 2;
        System.out.println("Max =  " + (this.cn.getRes()[1][x][y] * this.cn.getFacteur()));
        g = (Graphics2D) image.getGraphics();
        g.setColor(Color.black);
    }

    public void dessiner() {
        Graphics g = image.getGraphics();
        for (int x = 0; x < this.largeur; x++) {
            for (int y = 0; y < this.hauteur; y++) {
                g = this.image.getGraphics();

                Color color = new Color((
        (int) (this.cn.getRes()[0][x][y] * this.cn.getFacteur()) << 16) + (
                       (int) (this.cn.getRes()[1][x][y] * this.cn.getFacteur()) << 8) +
                       (int) (this.cn.getRes()[2][x][y] * this.cn.getFacteur()));

                g.setColor(color);
                setRGB(x, y, color);
            }
        }
        System.out.println("+");
    }


    public void modifierImage() {
    }


    public void init(Hashtable<String, Object> objects) {
    }

}
