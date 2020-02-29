/*    */ package pixelart.exemples.maxibulles;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics;
/*    */ import java.awt.geom.Ellipse2D;
/*    */ import java.awt.geom.Rectangle2D;
/*    */ import java.util.Hashtable;
/*    */ import java.util.Random;
/*    */ import pixelart.base.BaseMovieGenerator;
/*    */ 
/*    */ public class Bulles
/*    */   extends BaseMovieGenerator {
/* 13 */   private double[] x = new double[10000];
/* 14 */   private double[] y = new double[10000];
/* 15 */   private double[] h = new double[10000];
/* 16 */   private double[] w = new double[10000];
/* 17 */   private int[] dy = new int[10000];
/* 18 */   private int[] dx = new int[10000];

    public Bulles(String dossier, String prefix, int largeur, int hauteur, boolean isGui) {
        super(dossier, prefix, largeur, hauteur, isGui);
    }


    /*    */
/*    */   public void dessiner2(int i) {
/* 26 */     Random r = new Random();
/*    */     
/* 28 */     this.y[i] = (Math.abs(r.nextInt()) % this.hauteur + this.hauteur);
/* 29 */     this.x[i] = (Math.abs(r.nextInt()) % this.largeur);
/* 30 */     this.w[i] = (Math.abs(r.nextInt()) % 20);
/* 31 */     this.h[i] = this.w[i];
/* 32 */     this.dy[i] = Math.abs(r.nextInt()) % 10;
/* 33 */     this.dx[i] = r.nextInt() % 4;
/*    */   }
/*    */ 
/*    */   
/*    */   public void dessiner(int i) {
/*    */     Graphics g2;
/* 39 */     if (this.gPrim != null) {
/* 40 */       g2 = this.gPrim;
/*    */     } else {
/* 42 */       g2 = this.g;
/*    */     } 
/*    */     
/* 45 */     Rectangle2D rect = new Rectangle2D.Float();
/* 46 */     this.y[i] = this.y[i] - this.dy[i];
/* 47 */     this.x[i] = this.x[i] + this.dx[i];
/* 48 */     if (this.y[i] < -50.0D)
/* 49 */       dessiner2(i); 
/* 50 */     rect.setRect(this.x[i], this.y[i], this.w[i], this.h[i]);
/* 51 */     Ellipse2D e = new Ellipse2D.Float();
/* 52 */     e.setFrame(rect);
/* 53 */     g2.setColor(Color.RED);
/* 54 */     g2.fillOval((int)this.x[i], (int)this.y[i], (int)this.w[i], (int)this.h[i]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void modifierImage() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void dessiner() {
/* 65 */     for (int i = 0; i < 200; i++)
/*    */     {
/* 67 */       dessiner(i);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(Hashtable<String, Object> objects) {
/* 73 */     for (int i = 0; i < 200; i++)
/*    */     {
/* 75 */       dessiner2(i);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void initImage() {
/*    */     Graphics g2;
/* 84 */     if (this.gPrim != null) {
/* 85 */       g2 = this.gPrim;
/*    */     } else {
/* 87 */       g2 = this.g;
/* 88 */     }  g2.setColor(Color.BLACK);
/* 89 */     g2.fillRect(0, 0, this.largeur, this.hauteur);
/*    */   }
/*    */ }


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\exemples\maxibulles\Bulles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */