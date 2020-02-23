/*     */ package pixelart.exemples.planets;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ import java.io.IOException;
/*     */ import java.util.Hashtable;
/*     */ import pixelart.base.BaseMovieGenerator;
/*     */ 
/*     */ public class Planets
/*     */   extends BaseMovieGenerator
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
/*     */   public Planets() {}
/*     */   
/*     */   public Planets(String dossier, String prefix, int largeur, int hauteur) {
/*  25 */     super(largeur, hauteur);
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
/*  52 */     this.historySize = 10;
/*  53 */     this.history = new Point[numElectrons + 1][this.historySize];
/*     */   }
/*     */ 
/*     */   
/*     */   public void initImage() {
/*  58 */     for (int j = 0; j < this.numElectrons + 1; j++) {
/*  59 */       for (int k = this.historySize - 1; k > 0; k--)
/*     */       {
/*  61 */         this.history[j][k] = this.history[j][k - 1];
/*     */       }
/*     */       
/*  64 */       this.history[j][0] = new Point(this.x[j], this.y[j]);
/*     */     } 
/*     */     
/*  67 */     for (int i = 1; i < this.numElectrons + 1; i++) {
/*  68 */       this.x[i] = (int)(this.x[i] + this.dx[i]);
/*  69 */       this.y[i] = (int)(this.y[i] + this.dy[i]);
/*  70 */       this.dx[i] = this.dx[i] + -1000.0D * this.poids[0] * Math.signum((this.x[i] - this.x[0])) / ((
/*  71 */         this.x[i] - this.x[0]) * (this.x[i] - this.x[0]) + (this.y[i] - this.y[0]) * (
/*  72 */         this.y[i] - this.y[0]));
/*  73 */       this.dy[i] = this.dy[i] + -1000.0D * this.poids[0] * Math.signum((this.y[i] - this.y[0])) / ((
/*  74 */         this.x[i] - this.x[0]) * (this.x[i] - this.x[0]) + (this.y[i] - this.y[0]) * (
/*  75 */         this.y[i] - this.y[0]));
/*     */     } 
/*  77 */     System.out.println("dx[1]= " + this.dx[1] + "  dy[1]= " + this.dy[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dessiner() {
/*     */     Graphics g2;
/*  84 */     if (this.gPrim != null) {
/*  85 */       g2 = this.gPrim;
/*     */     } else {
/*  87 */       g2 = this.g;
/*  88 */     }  g2.clearRect(0, 0, this.largeur, this.hauteur);
/*  89 */     g2.setColor(Color.red);
/*  90 */     g2.fillOval(this.x[0], this.y[0], 30, 30);
/*  91 */     for (int i = 1; i < this.poids.length; i++) {
/*  92 */       g2.setColor(Color.blue);
/*  93 */       g2.fillOval(this.x[i], this.y[i], 10, 10);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void modifierImage() {}
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 103 */     String path = "c:\\users\\manuel\\pictures\\films\\20\\";
/* 104 */     if (args.length > 0)
/* 105 */       path = args[0]; 
/* 106 */     Planets c = new Planets(path, "im2-", 1388, 768);
/* 107 */     c.init(100);
/*     */     
/* 109 */     for (int i = 0; i < 12500; i++) {
/* 110 */       c.creerImage();
/* 111 */       c.initImage();
/* 112 */       c.dessiner();
/*     */       try {
/* 114 */         c.enregistrerImage();
/* 115 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Hashtable<String, Object> objects) {
/* 123 */     init(((Integer)objects.get("numElectrons")).intValue());
/*     */   }
/*     */ }


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\exemples\planets\Planets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */