/*    */ package pixelart.base;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.Ellipse2D;
/*    */ import java.awt.geom.Rectangle2D;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Random;
/*    */ import javax.imageio.ImageIO;
/*    */ 
/*    */ public class Generer {
/*    */   private String dossier;
/*    */   private String prefix;
/*    */   private int largeur;
/*    */   private int hauteur;
/* 18 */   private int frame = 100000;
/*    */   private BufferedImage image;
/*    */   private Graphics2D g;
/* 21 */   private double[] x = new double[10000];
/* 22 */   private double[] y = new double[10000];
/* 23 */   private double[] h = new double[10000];
/* 24 */   private double[] w = new double[10000];
/* 25 */   private int[] dy = new int[10000];
/* 26 */   private int[] dx = new int[10000];
/*    */   public Generer(String dossier, String prefix, int largeur, int hauteur) {
/* 28 */     this.dossier = dossier;
/* 29 */     this.prefix = prefix;
/* 30 */     this.largeur = largeur;
/* 31 */     this.hauteur = hauteur;
/*    */   }
/*    */   
/*    */   public void creerImage() {
/* 35 */     this.image = new BufferedImage(this.largeur, this.hauteur, 1);
/* 36 */     this.g = this.image.createGraphics();
/*    */   }
/*    */   
/*    */   public void dessiner(int i) {
/* 40 */     Random r = new Random();
/*    */     
/* 42 */     this.y[i] = (Math.abs(r.nextInt()) % this.hauteur + this.hauteur);
/* 43 */     this.x[i] = (Math.abs(r.nextInt()) % this.largeur);
/* 44 */     this.w[i] = (Math.abs(r.nextInt()) % 20);
/* 45 */     this.h[i] = this.w[i];
/* 46 */     this.dy[i] = Math.abs(r.nextInt()) % 10;
/* 47 */     this.dx[i] = r.nextInt() % 4;
/*    */   }
/*    */   
/*    */   public void dessiner2(int i) {
/* 51 */     Rectangle2D rect = new Rectangle2D.Float();
/* 52 */     this.y[i] = this.y[i] - this.dy[i];
/* 53 */     this.x[i] = this.x[i] + this.dx[i];
/* 54 */     if (this.y[i] < -50.0D) dessiner(i); 
/* 55 */     rect.setRect(this.x[i], this.y[i], this.w[i], this.h[i]);
/* 56 */     Ellipse2D e = new Ellipse2D.Float();
/* 57 */     e.setFrame(rect);
/* 58 */     this.g.setColor(Color.RED);
/* 59 */     this.g.fill(e);
/*    */   }
/*    */   
/*    */   public void enregistrerImage() throws IOException {
/* 63 */     String filename = String.valueOf(this.dossier) + this.prefix + File.pathSeparator + this.frame + 
/* 64 */       ".jpg";
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 71 */     ImageIO.write(this.image, "jpeg", new File(filename));
/*    */   }
/*    */ 
/*    */   
/*    */   public void modifierImage() {}
/*    */ 
/*    */   
/*    */   public static void main(String[] args) {
/* 79 */     Generer generer = new Generer("c:\\users\\manuel\\Pictures\\films\\2\\", "im", 1000, 700);
/* 80 */     generer.creerImage();
/* 81 */     for (int i = 0; i < 1000; i++) {
/* 82 */       generer.dessiner(i);
/*    */     }
/* 84 */     for (int f = 0; f < 2000; f++) {
/* 85 */       generer.creerImage();
/* 86 */       for (int j = 0; j < 200; j++)
/*    */       {
/* 88 */         generer.dessiner2(j);
/*    */       }
/* 90 */       generer.frame++;
/* 91 */       generer.g.dispose();
/* 92 */       System.out.println(generer.frame);
/*    */       try {
/* 94 */         generer.enregistrerImage();
/* 95 */       } catch (IOException e) {
/*    */         
/* 97 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\base\Generer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */