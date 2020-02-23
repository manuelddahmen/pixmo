/*     */ package pixelart.exemples.neuralnetwerken;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Point;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ColorNetwerk
/*     */ {
/*     */   private double[][] colors;
/*     */   private double[][] sum;
/*     */   private double[][][] res;
/*     */   private int largeur;
/*     */   private int hauteur;
/*     */   private int numColors;
/*     */   private int numNeurons;
/*     */   private double[][] neuronS;
/*     */   private Point[][] centers;
/*     */   
/*     */   public ColorNetwerk(int largeur, int hauteur, int numColors, int numNeurons) {
/*  22 */     this.colors = new double[3][numColors * numNeurons];
/*  23 */     this.sum = new double[3][numColors * numNeurons];
/*  24 */     this.neuronS = new double[3][numNeurons];
/*  25 */     this.res = new double[3][largeur][hauteur];
/*     */     
/*  27 */     this.centers = new Point[3][numNeurons];
/*     */     
/*  29 */     Random r = new Random(); int i;
/*  30 */     for (i = 0; i < numColors; i++) {
/*  31 */       this.colors[0][i] = (Math.abs(r.nextInt()) % 255);
/*  32 */       this.colors[1][i] = (Math.abs(r.nextInt()) % 255);
/*  33 */       this.colors[2][i] = (Math.abs(r.nextInt()) % 255);
/*     */     } 
/*  35 */     for (i = 0; i < numColors * numNeurons; i++) {
/*  36 */       this.sum[0][i] = Math.random();
/*  37 */       this.sum[1][i] = Math.random();
/*  38 */       this.sum[2][i] = Math.random();
/*     */     } 
/*  40 */     this.numColors = numColors;
/*  41 */     this.numNeurons = numNeurons;
/*  42 */     this.largeur = largeur;
/*  43 */     this.hauteur = hauteur;
/*     */     
/*  45 */     for (i = 0; i < 3; i++) {
/*  46 */       for (int j = 0; j < numNeurons; j++)
/*  47 */         this.centers[i][j] = new Point(Math.abs(r.nextInt()) % largeur, 
/*  48 */             Math.abs(r.nextInt()) % hauteur); 
/*     */     } 
/*     */   }
/*     */   public void update() {
/*  52 */     for (int i = 0; i < this.numColors * this.numNeurons; i++) {
/*  53 */       this.colors[0][i] = this.colors[0][i] * (1.0D + Math.signum(Math.random()) * Math.random() * 
/*  54 */         0.01D);
/*  55 */       this.colors[1][i] = this.colors[1][i] * (1.0D + Math.signum(Math.random()) * Math.random() * 
/*  56 */         0.01D);
/*  57 */       this.colors[2][i] = this.colors[2][i] * (1.0D + Math.signum(Math.random()) * Math.random() * 
/*  58 */         0.01D);
/*     */     } 
/*     */   }
/*     */   public void compute() {
/*     */     int i;
/*  63 */     for (i = 0; i < this.largeur; i++) {
/*  64 */       for (int j = 0; j < this.hauteur; j++) {
/*  65 */         this.res[0][i][j] = 0.0D;
/*  66 */         this.res[1][i][j] = 0.0D;
/*  67 */         this.res[2][i][j] = 0.0D;
/*  68 */         for (int n = 0; n < this.numNeurons; n++) {
/*     */           
/*  70 */           this.neuronS[0][n] = 0.0D;
/*  71 */           this.neuronS[1][n] = 0.0D;
/*  72 */           this.neuronS[2][n] = 0.0D;
/*  73 */           for (int k = 0; k < this.numColors; k++) {
/*     */             
/*  75 */             this.neuronS[0][n] = this.neuronS[0][n] + this.colors[0][k] * this.sum[0][k];
/*  76 */             this.neuronS[1][n] = this.neuronS[1][n] + this.colors[1][k] * this.sum[1][k];
/*  77 */             this.neuronS[2][n] = this.neuronS[2][n] + this.colors[2][k] * this.sum[2][k];
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  82 */     for (i = 0; i < this.largeur; i++) {
/*  83 */       for (int j = 0; j < this.hauteur; j++) {
/*  84 */         for (int c = 0; c < 3; c++) {
/*  85 */           this.res[c][i][j] = 0.0D;
/*  86 */           for (int n = 0; n < this.numNeurons; n++) {
/*  87 */             this.res[c][i][j] = this.res[c][i][j] + 1.0D / (
/*  88 */               this.largeur + this.hauteur) / 
/*  89 */               2.0D * (
/*  90 */               Math.abs(i - this.centers[c][n].getX()) + 
/*  91 */               Math.abs(j - this.centers[c][n].getY())) * 
/*  92 */               this.neuronS[c][n] / this.numNeurons;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Color get(int x, int y) {
/* 101 */     int r = (int)(this.res[0][x][y] / this.numColors * 255.0D);
/* 102 */     int b = (int)(this.res[1][x][y] / this.numColors * 255.0D);
/* 103 */     int g = (int)(this.res[2][x][y] / this.numColors * 255.0D);
/* 104 */     Color color = new Color(r << 16 + g << 8 + b);
/* 105 */     return color;
/*     */   }
/*     */   
/*     */   public double[][][] getRes() {
/* 109 */     return this.res;
/*     */   }
/*     */   
/*     */   public double getFacteur() {
/* 113 */     return 1.0D / this.numColors / this.numNeurons * 255.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\exemples\neuralnetwerken\ColorNetwerk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */