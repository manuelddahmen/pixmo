/*     */ package pixelart.exemples.planets;
/*     */ 
/*     */

import java.awt.*;
import java.io.IOException;
import java.util.Hashtable;

/*     */
/*     */
/*     */
/*     */

/*     */
/*     */ public class RisPlanet3
/*     */   extends pixelart.base.BaseMovieGenerator
/*     */ {
/*     */   private int[] x;
/*     */   private int[] y;
/*     */   private int numElectrons;
/*     */   private double[] dx;
/*     */   private double[] dy;
/*     */   private double[] poids;
/*     */   private Point[][] history;
/*     */   private int historySize;
/*     */
/*     */   public RisPlanet3(String dossier, String prefix, int largeur, int hauteur, boolean isGui) {
/*  25 */     super(dossier, prefix, largeur, hauteur, isGui);

/*     */   }
/*     */ 
/*     */   
/*     */   public void init(int numElectrons) {
/*  30 */     this.numElectrons = numElectrons;
/*  31 */     this.x = new int[numElectrons + 1];
/*  32 */     this.y = new int[numElectrons + 1];
/*  33 */     this.dx = new double[numElectrons + 1];
/*  34 */     this.dy = new double[numElectrons + 1];
/*  35 */     this.poids = new double[numElectrons];
/*     */     
/*  37 */     this.poids[0] = 1000.0D; int i;
/*  38 */     for (i = 0; i < this.poids.length; i++)
/*  39 */       this.poids[i] = 1.0D; 
/*  40 */     this.dx[0] = 0.0D;
/*  41 */     this.dy[0] = 0.0D;
/*  42 */     this.x[0] = this.largeur / 2;
/*  43 */     this.y[0] = this.hauteur / 2;
/*  44 */     for (i = 1; i < this.poids.length; i++) {
/*  45 */       double a = Math.random() * 2.0D * Math.PI;
/*  46 */       this.x[i] = this.largeur / 2 + (int)(Math.cos(a) * this.hauteur / 3.0D);
/*  47 */       this.y[i] = this.hauteur / 2 + (int)(Math.sin(a) * this.hauteur / 3.0D);
/*  48 */       a = Math.random() * 2.0D * Math.PI;
/*  49 */       this.dx[i] = -1.0D * Math.cos(a);
/*  50 */       this.dy[i] = -1.0D * Math.sin(a);
/*     */     } 
/*  52 */     this.historySize = 50;
/*  53 */     this.history = new Point[numElectrons + 1][this.historySize];
/*     */   }
/*     */ 
/*     */   
/*     */   public void initImage() {
/*  58 */     for (int j = 0; j < this.numElectrons + 1; j++) {
/*  59 */       for (int k = this.historySize - 1; k > 0; k--) {
/*  60 */         this.history[j][k] = this.history[j][k - 1];
/*     */       }
/*     */       
/*  63 */       this.history[j][0] = new Point(this.x[j], this.y[j]);
/*     */     } 
/*     */     
/*  66 */     for (int i = 1; i < this.numElectrons + 1; i++) {
/*  67 */       this.x[i] = (int)(this.x[i] + this.dx[i]);
/*  68 */       this.y[i] = (int)(this.y[i] + this.dy[i]);
/*  69 */       this.dx[i] = this.dx[i] + -1000.0D * 
/*  70 */         this.poids[0] * Math.signum((this.x[i] - this.x[0])) / ((
/*  71 */         this.x[i] - this.x[0]) * (this.x[i] - this.x[0]) + (this.y[i] - this.y[0]) * (
/*  72 */         this.y[i] - this.y[0]));
/*  73 */       this.dy[i] = this.dy[i] + -1000.0D * 
/*  74 */         this.poids[0] * Math.signum((this.y[i] - this.y[0])) / ((
/*  75 */         this.x[i] - this.x[0]) * (this.x[i] - this.x[0]) + (this.y[i] - this.y[0]) * (
/*  76 */         this.y[i] - this.y[0]));
/*     */     } 
/*  78 */     System.out.println("dx[1]= " + this.dx[1] + "  dy[1]= " + this.dy[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dessiner() {
/*     */     Graphics g2;
/*  85 */     if (this.gPrim != null) {
/*  86 */       g2 = this.gPrim;
/*     */     } else {
/*  88 */       g2 = this.g;
/*  89 */     }  g2.setColor(Color.WHITE);
/*  90 */     g2.fillRect(0, 0, this.largeur, this.hauteur);
/*  91 */     g2.setColor(Color.red);
/*  92 */     g2.fillOval(this.x[0], this.y[0], 30, 30);
/*  93 */     for (int i = 1; i < this.poids.length; i++) {
/*  94 */       g2.setColor(Color.blue);
/*     */ 
/*     */       
/*  97 */       for (int h = 0; h < this.historySize; h++) {
/*  98 */         if (this.history[i][h] != null)
/*  99 */           dessinerForme((int)this.history[i][h].getX(), (int)this.history[i][h].getY(), this.historySize - h); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   protected void dessinerForme(int x0, int y0, int d) {
/* 104 */     for (int i = 0; i < d * 2; i++) {
/* 105 */       for (int j = 0; j < d * 2; j++) {
/* 106 */         if (x0 - d + i >= 0 && x0 - d + i < this.largeur && y0 - d + j >= 0 && 
/* 107 */           y0 - d + j < this.hauteur) {
/* 108 */           float d0 = (float)Math.sqrt(((i - d) * (i - d) + (j - d) * (
/* 109 */               j - d)));
/* 110 */           int c1 = this.image.getRGB(x0 - d + i, y0 - d + j);
/* 111 */           int c = 16777215;
/* 112 */           int c2 = 0;
/* 113 */           if ((c1 >> 16 & 0xFF) + 0.0D < ((c >> 16 & 0xFF) * 
/* 114 */             d0 / d)) {
/* 115 */             c2 += c1 & 0xFF0000;
/*     */           } else {
/* 117 */             c2 = (int)(c * (1.0F - d0 / d));
/* 118 */           }  if ((c1 >> 8 & 0xFF) + 0.0D < ((c >> 8 & 0xFF) * d0 / d)) {
/* 119 */             c2 += c1 & 0xFF00;
/*     */           } else {
/* 121 */             c2 = (int)(c * (1.0F - d0 / d));
/* 122 */           }  if ((c1 & 0xFF) + 0.0D < ((c & 0xFF) * d0 / d)) {
/* 123 */             c2 += c1 & 0xFF;
/*     */           } else {
/* 125 */             c2 = (int)(c * (1.0F - d0 / d));
/* 126 */           }  this.image.setRGB(x0 - d + i, y0 - d + j, c2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void modifierImage() {}
/*     */   
/*     */   public static void main(String[] args) {
/* 136 */     String path = "c:\\users\\manuel\\pictures\\films\\33\\";
            boolean isGui = false;
/* 137 */     if (args.length > 0)
/* 138 */       path = args[0];
    if (args.length > 1)
        isGui = Boolean.parseBoolean(args[1]);
/* 139 */     RisPlanet3 c = new RisPlanet3(path, "im2-", 1388, 768, isGui);
/* 140 */     c.init(100);
/*     */     
/* 142 */     for (int i = 0; i < 12500; i++) {
/* 143 */       c.creerImage();
/* 144 */       c.initImage();
/* 145 */       c.dessiner();
/*     */       try {
/* 147 */         c.enregistrerImage();
/* 148 */         System.out.println(i);
/* 149 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Hashtable<String, Object> objects) {
/* 157 */     init(((Integer)objects.get("nombre")).intValue());
/*     */   }
/*     */ }


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\exemples\planets\Planets2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */