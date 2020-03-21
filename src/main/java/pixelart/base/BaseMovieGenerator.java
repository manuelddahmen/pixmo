/*     */
package pixelart.base;
/*     */ 
/*     */

import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Hashtable;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;

/*     */
/*     */ public abstract class BaseMovieGenerator
/*     */ {
    protected boolean isGui;
    /*  18 */    protected String dossier = "";
    /*  19 */    protected String prefix = "";
    /*  20 */   protected int largeur = 1388;
    /*  21 */   protected int hauteur = 768;
    /*  22 */   private int frame = 100000;
    /*  23 */   protected BufferedImage image = null;
    /*  24 */   protected Graphics2D g = null;
    /*     */
/*     */ 
/*     */   
/*     */   protected Graphics gPrim;
    /*     */
/*     */ 
/*     */   
/*     */   protected JPanel jPanel;
    /*     */
/*     */ 
/*     */   
/*     */   protected int frame0;
    /*     */
/*     */ 
/*     */   
/*     */   private JLabel label;
    private Graphics g2;

    /*     */
/*     */ 
/*     */   
/*     */
    public BaseMovieGenerator(String dossier, String prefix, int largeur, int hauteur, boolean isGui) {
/*  45 */
/*  46 */

        this.dossier = dossier;
        this.prefix = prefix;
        this.largeur = largeur;
/*  47 */
        this.hauteur = hauteur;
/*     */

        this.isGui = isGui;
      new File(dossier). mkdirs() ;

        //initFolder();
    }
public int frame() {
  return frame0;
} 
    /*     */
/*     */ 
/*     */   
/*     */
    public void creerImage() {
/*  53 */
        this.image = new BufferedImage(this.largeur, this.hauteur, BufferedImage.TYPE_INT_ARGB);
/*  54 */
        this.g = this.image.createGraphics();
        if (isGui)
            this.g2 = this.jPanel.getGraphics();
/*     */
    }

    /*     */
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */
    public void enregistrerImage() throws IOException {
/*  62 */
        String filename = this.dossier + File.separator + this.prefix + this.frame +
/*  63 */       ".jpg";
/*  64 */
        this.frame++;

        System.out.println(new File(filename)) ;

        ImageIO.write(this.image, "jpg", new File(filename));
/*  66 */
/*     */
    }

    /*     */
/*     */ 
/*     */   
/*     */
    public void initMontrerImage() {
/*  72 */
        if (isGui) {
            JFrame jjFrame = new JFrame("Video");
/*  73 */
            this.jPanel = new JPanel();
/*  74 */
            this.jPanel.setMinimumSize(new Dimension(this.largeur, this.hauteur));
/*  75 */
            jjFrame.add(this.jPanel);
/*  76 */
            jjFrame.setContentPane(this.jPanel);
/*  77 */
            jjFrame.setMinimumSize(new Dimension(this.largeur, this.hauteur));
/*  78 */
            this.jPanel.setBounds(0, 0, this.largeur, this.hauteur);
/*  79 */
            jjFrame.setDefaultCloseOperation(3);
/*  80 */
            jjFrame.pack();
/*  81 */
            jjFrame.setVisible(true);
        }
/*     */     
/*  83 */
        //this.gPrim = this.jPanel.getGraphics();
/*  84 */
        //this.gPrim.setColor(Color.black);
/*  85 */
        //this.gPrim.drawRect(0, 0, 100, 100);
/*     */
    }

    /*     */
/*     */   
/*     */
    public void montrerImage() {
    }

    /*     */
/*     */   
/*     */
    public String getDossier() {
/*  93 */
        return this.dossier;
/*     */
    }

    /*     */
/*     */
    public String getPrefix() {
/*  97 */
        return this.prefix;
/*     */
    }

    /*     */
/*     */
    public int getLargeur() {
/* 101 */
        return this.largeur;
/*     */
    }

    /*     */
/*     */
    public int getHauteur() {
/* 105 */
        return this.hauteur;
/*     */
    }

    /*     */
/*     */
    public int getFrame() {
/* 109 */
        return this.frame;
/*     */
    }

    /*     */
/*     */
    public BufferedImage getImage() {
/* 113 */
        return this.image;
/*     */
    }

    /*     */
/*     */
    public static void doIt() {
    }

    /*     */
/* 118 */
  /*  public void initFolder() {
        this.frame0 = 0;
        pixelart.base.Directories d = new pixelart.base.Directories();
        int i = 0;
        d.setBaseDir("");
        d.setMovieDir(getClass());
        this.dossier = String.valueOf(d.getBaseDir());
        File f = new File(String.valueOf(this.dossier) + File.separator + "0");
        while (f.exists())
            f = new File(String.valueOf(this.dossier) + File.separator + i++);
        this.dossier = String.valueOf(f.getAbsolutePath()) + File.separator;
        f.mkdirs();
/*     
        this.prefix = "im-";
/*     
        this.largeur = 1388;
/* 122 
        this.hauteur = 768;
    }*/

    public int getFrame0() {
        return this.frame0;
    }

    /*     */
/*     */   
/*     */
    public void doit(BaseMovieGenerator b, Hashtable<String, Object> params) {
/* 126 */if(params  == null) 
  params = new Hashtable() ;
       // this.largeur = Integer.parseInt((String) params.get("largeur"));
/* 127 */
        //this.hauteur = Integer.parseInt((String) params.get("hauteur"));
/* 128 */
        b.frame0 = 0;
/* 129 */
        b.init(params);
/* 130 */
       // if (params.containsKey("ecran"))
/* 131 */ b.initMontrerImage();
/* 132 */

        for (int i = 0; i < 12590/*((Integer) params.get("nombre")).intValue()*/; i++) {
/* 133 */   b.initImage();
            b.creerImage();
/* 134 */
            b.initImage();
/* 135 */
            b.dessiner();
/*     */
            try {
/* 137 */
                b
                  
                
                 . enregistrerImage();
/* 138 */
                System.out.println(i);
/* 139 */
            } catch (IOException e) {
/* 140 */
                e.printStackTrace();

            }
/* 142 */
            this.frame0++;
/* 143 */
           // this.label.setText(String.valueOf(this.frame0));
/*     */
        }
/*     */
    }

    /*     */
/*     
    public void doit(Hashtable<String, Object> hashtable, JLabel nbrImages) {
/* 148
        this.label = nbrImages;
/* 149 
        doit(hashtable);
/*     
    }

    /*     */
/*     */
    public abstract void init(Hashtable<String, Object> paramHashtable);

    /*     */
/*     */
    public abstract void initImage();

    /*     */
/*     */
    public abstract void dessiner();

    /*     */
/*     */
    public abstract void modifierImage();
/*     */


    public void setRGB(int x, int y, Color color) {
      
        //g.setColor(color);

        image.setRGB(x, y, color.getRGB());
      if(isGui) {
        g2.drawRect((int) (1.0 * x / image.getWidth() * jPanel.getWidth()),
                (int) (1.0 * y / image.getHeight() * jPanel.getHeight())
                , 1, 1);
       } 
    }
  
  public Color
    
getRGB(int x, int y) {
    return new Color(image. getRGB(x, y) ) ;
  } 
  public static void doit(BaseMovieGenerator b) {
    b. 
doit(b, null) ;
  } 
}


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\base\BaseMovieGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */