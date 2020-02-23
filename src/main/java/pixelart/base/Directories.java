/*    */ package pixelart.base;
/*    */ import java.io.File;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Dictionary;
/*    */ import java.util.Hashtable;
import java.util.List;
/*    */ import pixelart.exemples.planets.Planets2;
/*    */ 
/*    */ public class Directories {
/*  9 */   private final String dirName = "MovieEncoder";
/*    */   
/*    */   private String baseDir;
/* 12 */   private Dictionary<Class, String> movieDir = (Dictionary)new Hashtable<Class<?>, String>();
/* 13 */   private ArrayList<String> run = new ArrayList<String>();
/*    */   
/*    */   public void setBaseDir(String baseDir) {
/* 16 */     if (baseDir == null || baseDir.equals("")) {
/*    */       
/* 18 */       baseDir = System.getProperty("user.home");
/* 19 */       baseDir = String.valueOf(baseDir) + File.separator + "MovieEncoder" + File.separator;
/*    */     } 
/* 21 */     this.baseDir = baseDir;
/*    */   }
/*    */   
/*    */   public String getBaseDir() {
/* 25 */     return this.baseDir;
/*    */   }
/*    */   
/*    */   public void setMovieDir(Class movie) {
/* 29 */     this.movieDir.put(movie, String.valueOf(this.baseDir) + movie.getCanonicalName());
/*    */   }
/*    */   
/*    */   public String getMovieDir(Class movie) {
/* 33 */     return this.movieDir.get(movie);
/*    */   }
/*    */   public void setRun(String run) {
/* 36 */     this.run.add(run);
/*    */   }
/*    */   public List<String> getRun() {
/* 39 */     return this.run;
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 43 */     Directories d = new Directories();
/* 44 */     d.setBaseDir("");
/* 45 */     System.out.println(d.getBaseDir());
/* 46 */     d.setMovieDir(Planets2.class);
/* 47 */     System.out.println(d.getBaseDir());
/*    */   }
/*    */ }


/* Location:              C:\Users\P1779\Downloads\pixelart.jar!\pixelart\base\Directories.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */