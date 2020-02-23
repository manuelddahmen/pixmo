/*    */
package pixelart.exemples.neuralnetwerken;
/*    */ 
/*    */

import java.awt.*;
/*    */
/*    */ import java.io.IOException;
/*    */ import java.util.Hashtable;
/*    */ import pixelart.base.BaseMovieGenerator;

/*    */
/*    */ public class Colors
/*    */ extends BaseMovieGenerator
/*    */ {
    private static final int NUMFRAMES = 25 * 60 * 6;
    /* 12 */   private pixelart.exemples.neuralnetwerken.ColorNetwerk cn = null;

    /*    */
/*    */
    public Colors(String dossier, String prefix, int largeur, int hauteur) {
/* 15 */
        super(largeur, hauteur);
/* 16 */
        this.cn = new pixelart.exemples.neuralnetwerken.ColorNetwerk(largeur, hauteur, 20, 5);
/*    */
    }

    /*    */
/*    */ 
/*    */   
/*    */
    public Colors() {
/* 22 */
        this.cn = new pixelart.exemples.neuralnetwerken.ColorNetwerk(this.largeur, this.hauteur, 20, 5);
/*    */
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
        Graphics aThisjPanelGraphics = this.jPanel.getGraphics();
        for (int x = 0; x < this.largeur; x++) {
/* 40 */
            for (int y = 0; y < this.hauteur; y++) {
/* 41 */
                Graphics g2 = null;
                g2 = this.image.getGraphics();
/* 47 */

                Color color =new Color((
/* 48 */               (int) (this.cn.getRes()[0][x][y] * this.cn.getFacteur()) << 16) + (
/* 49 */               (int) (this.cn.getRes()[1][x][y] * this.cn.getFacteur()) << 8) +
/* 50 */               (int) (this.cn.getRes()[2][x][y] * this.cn.getFacteur())) ;

                g2.setColor(color);
/* 51 */
                setRgb(color, x, y);
            }
/* 53 */
        }
        aThisjPanelGraphics.drawImage(image, 0, 0, jPanel.getWidth(), jPanel.getHeight(), null);
        System.out.println("+");
/*    */
    }

    /*    */
/*    */ 
/*    */   
/*    */
    public void modifierImage() {
    }

    /*    */
/*    */   
/*    */
    public static void main(String[] args) {
/* 69 */
        String path = "outimg\\";
/* 70 */
        if (args.length > 0)
/* 71 */ path = args[0];
/* 72 */
        Colors c = new Colors(path, "im2-", 1388, 768);
/* 73 */
        c.initMontrerImage();
/* 74 */
        for (int i = 0; i < NUMFRAMES; i++) {
/* 75 */
            c.creerImage();
/* 76 */
            c.initImage();
/* 77 */
            c.dessiner();
/*    */
            try {
/* 79 */
                c.enregistrerImage();
/* 80 */
            } catch (IOException e) {
/*    */         
/* 82 */
                e.printStackTrace();
/*    */
            }
/*    */
        }
/*    */
    }

    /*    */
/*    */
    public void init(Hashtable<String, Object> objects) {
    }
/*    */
}


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\exemples\neuralnetwerken\Colors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */