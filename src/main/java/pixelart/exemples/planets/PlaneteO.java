/*     */
package pixelart.exemples.planets;
/*     */
/*     */

import java.awt.*;
import java.util.Hashtable;
//import one.empty3.library.Colors;
/*     */
/*     */
/*     */
/*     */

/*     */
/*     */ public class PlaneteO
        /*     */ extends pixelart.base.BaseMovieGenerator
        /*     */ {
    /*     */
    /*     */ int max;
    /*     */   private int[] x;
    /*     */   private int[] y;
    /*     */   private int numElectrons;
    /*     */   private double[] dx;
    /*     */   private double[] dy;
    /*     */   private double[] poids;
    private Color[] colors;
    /*     */   private Point[][] history;
    /*     */   private int historySize;
    /*     */ private int[][][] pix = new int[largeur][hauteur][3];

    /*     */
    public PlaneteO(String dossier, String prefix, int largeur, int hauteur, boolean isGui) {
        /*  25 */
        super(dossier, prefix, largeur, hauteur, isGui);

        /*     */
    }

    /*     */
    /*     */
    public static void main(String[] args) {
        /* 136 */
        String path = "c:\\users\\manue\\planetO";
        boolean isGui = false;
        if (args.length > 0)
            /* 138 */ path = args[0];
        if (args.length > 1)
            isGui = Boolean.parseBoolean(args[1]);
        /* 139 */
        PlaneteO c = new PlaneteO(path, "img", 1388, 768, isGui);
        c.init(100);
        c.initMontrerImage();
        /*     */
        /* 142 */
        for (int i = 0; i < 12500; i++) {
            /* 143 */
            c.creerImage();
            /* 144 */
            c.initImage();
            /* 145 */
            c.dessiner();
            /* 147 */
            c.enregistrerImage();
            /* 148 */
            System.out.println(i);
            /*     */
        }
        /*     */
    }

    /*     */
    public int[] fromColor(Color color)
    /*     */ {
        return new int[]{color.getRed(), color.getGreen(), color.getBlue()/*, color.getAlpha()*/};
    }

    public Color toColor(int[] colors) {
        return new Color(colors[0], colors[1], colors[2]/*, colors[3] */);
    }

    public int[] modulo(int[] colors, int mod) {
        for (int i = 0; i < colors.length; i++)
            colors[i] = (colors[i] + 256) % mod;
        return colors;
    }

    public int[] plus(int[] arr, int[] plus) {
        for (int c = 0; c < arr.length; c++)
            arr[c] += plus[c];
        return arr;
    }

    public int toInt(int[] colors) {
        return (colors[2] << 16) + (colors[1] << 8) + (colors[0]);
    }

    /*     */
    public void init(int numElectrons) {
        /*  30 */
        this.numElectrons = numElectrons;
        /*  31 */
        this.x = new int[numElectrons + 1];
        /*  32 */
        this.y = new int[numElectrons + 1];
        /*  33 */
        this.dx = new double[numElectrons + 1];
        /*  34 */
        this.dy = new double[numElectrons + 1];
        /*  35 */
        this.poids = new double[numElectrons];
        /*     */
        this.colors = new Color[numElectrons + 1];
        /*  37 */
        this.poids[0] = 1000.0D;
        int i;
        /*  38 */
        for (i = 0; i < this.poids.length; i++)
            /*  39 */
            this.poids[i] = 1.0D;
        /*  40 */
        this.dx[0] = 0.0D;
        /*  41 */
        this.dy[0] = 0.0D;
        /*  42 */
        this.x[0] = this.largeur / 2;
        /*  43 */
        this.y[0] = this.hauteur / 2;
        /*  44 */
        for (i = 1; i < this.poids.length; i++) {
            /*  45 */
            double a = Math.random() * 2.0D * Math.PI;
            /*  46 */
            this.x[i] = this.largeur / 2 + (int) (Math.cos(a) * this.hauteur / 3.0D);
            /*  47 */
            this.y[i] = this.hauteur / 2 + (int) (Math.sin(a) * this.hauteur / 3.0D);
            /*  48 */
            a = Math.random() * 2.0D * Math.PI;
            /*  49 */
            this.dx[i] = -1.0D * Math.cos(a);
            /*  50 */
            this.dy[i] = -1.0D * Math.sin(a);
            /*     */
        }
        /*  52 */
        this.historySize = 50;
        /*  53 */
        this.history = new Point[numElectrons + 1][this.historySize];
        /*     */
    }

    /*     */
    public void initImage() {
        max = Integer.MIN_VALUE;
        /*  58 */
        for (int j = 0; j < this.numElectrons + 1; j++) {
//colors[j] = Colors.random();
            /*  59 */
            for (int k = this.historySize - 1; k > 0; k--) {
                /*  60 */
                this.history[j][k] = this.history[j][k - 1];
                /*     */
            }
            /*     */
            /*  63 */
            this.history[j][0] = new Point(this.x[j], this.y[j]);
            /*     */
        }
        /*     */
        /*  66 */
        for (int i = 1; i < this.numElectrons + 1; i++) {
            /*  67 */
            this.x[i] = (int) (this.x[i] + this.dx[i]);
            /*  68 */
            this.y[i] = (int) (this.y[i] + this.dy[i]);
            /*  69 */
            this.dx[i] = this.dx[i] + -1000.0D *
                    /*  70 */         this.poids[0] * Math.signum((this.x[i] - this.x[0])) / ((
                    /*  71 */         this.x[i] - this.x[0]) * (this.x[i] - this.x[0]) + (this.y[i] - this.y[0]) * (
                    /*  72 */         this.y[i] - this.y[0]));
            /*  73 */
            this.dy[i] = this.dy[i] + -1000.0D *
                    /*  74 */         this.poids[0] * Math.signum((this.y[i] - this.y[0])) / ((
                    /*  75 */         this.x[i] - this.x[0]) * (this.x[i] - this.x[0]) + (this.y[i] - this.y[0]) * (
                    /*  76 */         this.y[i] - this.y[0]));
            /*     */
        }
        /*  78 */
        System.out.println("dx[1]= " + this.dx[1] + "  dy[1]= " + this.dy[1]);
        for (int x = 0; x < largeur; x++)
            for (int y = 0; y < hauteur; y++)
                for (int c = 0; c < 3; c++)
                    pix[x][y][c] = 0;
        /*     */
    }

    /*     */
    /*     */
    public float deltaF() {
        int Tf = 50;
        return (float) ((frame() % Tf) / 25.0);
    }

    /*     */
    /*     */
    public void dessiner() {
        /*  89 */

        g.setColor(Color.BLUE);//new Color(deltaF(), deltaF(), deltaF() )) ;
        /*  90 */     //g2.fillRect(0, 0, this.largeur, this.hauteur);
        /*  91 */
        g.setColor(Color.WHITE);
        /*  92 */     //g2.fillOval(this.x[0], this.y[0], 30, 30);
        /*  93 */
        for (int i = 1; i < this.poids.length; i++) {
            /*  94 */
            /*     */
            g.fillOval(this.x[i], this.y[i], 30, 30);



            /*  97 */
            for (int h = 0; h < this.historySize; h++) {
                /*  98 */
                if (this.history[i][h] != null) {
                    g.setColor(Color.WHITE);
                    g.fillOval((int) history[i][h].getX(), (int) history[i][h].getY(), history[i].length - i, history[i].length - i);
                    /*  99 */
                    dessinerForme((int) this.history[i][h].getX(), (int) this.history[i][h].getY(), historySize - h);
                    /*     */
                }
                /*     */
            }
            /*     */
        }
    }

    /*     */
    protected void dessinerForme(int x0, int y0, int d) {

        /* 104 */
        for (int i = 0; i < d * 2; i++) {
            /* 105 */
            for (int j = 0; j < d * 2; j++) {
                /* 106 */
                if (x0 - d + i >= 0 && x0 - d + i < this.largeur && y0 - d + j >= 0 &&
                        /* 107 */           y0 - d + j < this.hauteur) {
                    /* 108 */
                    float d0 = (float) Math.sqrt(((i - d) * (i - d) + (j - d) * (
                            /* 109 */               j - d)));

                    /* 110 */
                    Color c = getRGB(x0 - d + i, y0 - d + j);
                    /* 111 */
                    int[] c1 = fromColor(c);
//6777215;
                    /* 112 */
                    int[] c2 = new int[]{0, 0, 0};

                    /* 113 */
                    float ratio = d0 / (d < 1f ? 1f : d);
                    /* 115 */
/*     *
/* 117 */
                    c2[0] = (int) ((c1[0] * ratio));

                    /* 119 */
/*     *
/* 121 */
                    c2[1] = (int) ((c1[1]) * (ratio));
                    /* 122 */
                    /* 123 */
/*     *
/* 125 */
                    c2[2] = (int) ((c1[2]) * (ratio));
                    /* 126 */
                    int xo = x0 - d + i;
                    int yo = y0 - d + j;


                    plus(pix[xo][yo], c2);


                    modulo(pix[xo][yo], 256);





                    /*     */
                }
                /*     */
            }
            /*     */
        }
        for (int x = 0; x < largeur; x++)
            for (int y = 0; y < hauteur; y++) {
//for(int c =0; c<4; c++)
//pix[x] [y][c] /= max;
//modulo(pix[x] [y] , 256 ) ;
                setRGB(x, y, toColor(pix[x][y]));
            }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public void modifierImage() {
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void init(Hashtable<String, Object> objects) {
        /* 157 */
        init((Integer) objects.get("nombre"));
        /*     */
    }
    /*     */
}


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\exemples\planets\Planets2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */