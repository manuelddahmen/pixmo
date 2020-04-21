/***
* xyztrgba
**/
package pixelart.base;
import one.empty3.library.shader.Vec;
import java.awt.Color;
public class Vec8 extends BaseMovieGenerator {
     //Timer timer;
     private Vec[][] vec ;
     private Vec coordXY;
     private long time;
     private Color color;
     public Vec8(int rx, int ry) {
          super() ;
          vec = new Vec[rx] [ry] ;
     } 
     public double time() {
          return ((double) time) / fps;
        // return timer.getTimeElapsed();

     } 
     public Vec coordXY() {
         return coordXY;
     
     } 
     
     public void modifierImage() {
        // TODO METTRE LA LOOP ICI ET DESSINER SUR L IMAGE
          loop() ;
     } 
     public void color(Color c) {
         this.color = color;
     } 
    public Color color() {
        return color;
    } 
     
     
     public void loop() {
          timer = new Timer() ;
          time++;
          Color c = new Color[ vec.length] [  vec[0] .length ] ;
          for(int i= 0; i<vec.length; i++) {
               
              for(int j= 0; j<vec[i] .length; j++) {
                   coordXY = new Vec ((double)i,
                                     (double)j ) ;
                   
                   main(i, j, color() );
                   
                   setRGB(i, j, color() ) 
              } 
          } 
     } 
     public void main() {
          
     } 
} 
