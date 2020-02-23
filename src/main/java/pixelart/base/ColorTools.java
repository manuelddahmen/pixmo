/*    */ package pixelart.base;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class ColorTools {
/*    */   public static Color[] degrade(Color c1, Color c2, int niveaux) {
/*  7 */     Color[] colors = new Color[niveaux];
/*    */     
/*  9 */     for (int i = 0; i < niveaux; i++) {
/* 10 */       colors[i] = new Color(1.0F * (c2.getRed() - c1.getRed()) * i / 
/* 11 */           niveaux, 1.0F * (c2.getGreen() - c1.getGreen()) * i / 
/* 12 */           niveaux, 1.0F * (c2.getBlue() - c1.getBlue()) * i / 
/* 13 */           niveaux);
/*    */     }
/* 15 */     return colors;
/*    */   }
/*    */ }


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\base\ColorTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */