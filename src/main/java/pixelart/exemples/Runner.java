/*    */ package pixelart.exemples;
/*    */ 
/*    */ import java.util.Hashtable;
/*    */ import javax.swing.JLabel;
/*    */ import pixelart.base.BaseMovieGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Runner
/*    */ {
/* 11 */   private Hashtable<Class, Hashtable<String, Object>> gens = new Hashtable<>();
/*    */   
/*    */   public void addGen(Class c, Hashtable<String, Object> t) {
/* 14 */     this.gens.put(c, t);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void doit(final Class gen, final JLabel nbrImages) throws InstantiationException, IllegalAccessException {
/* 20 */     final Object o = gen.newInstance();
/* 21 */     (new Thread()
/*    */       {
/*    */         
/*    */         public void run()
/*    */         {
/* 26 */           BaseMovieGenerator.doit((BaseMovidGenerator)o);
/*    */         }
/* 28 */       }).start();
/*    */   }
/*    */   
/*    */   public Hashtable<Class, Hashtable<String, Object>> getGens() {
/* 32 */     return this.gens;
/*    */   }
/*    */   
/*    */   public void setGens(Hashtable<Class, Hashtable<String, Object>> gens) {
/* 36 */     this.gens = gens;
/*    */   }
/*    */ }


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\exemples\Runner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
