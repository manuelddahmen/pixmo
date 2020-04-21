/***
* xyztrgba
**/
package pixelart.base;
import one.empty3.library.shader.Vec;
public class Vec8 extends BaseMovieGenerator {
     Timer timer;
     private Vec[][] vec ;
     private Vec coordXY;
     private long time;
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
     public void color(Vec c) {} 
     public void loop() {
          timer = new Timer() ;
          time++;
          Color c = new Color[ vec.length] [  vec[0] .length ] ;
          for(int i= 0; i<vec.length; i++) {
               
              for(int j= 0; j<vec[i] .length; j++) {
                   coordXY = new Vec ((double)i,
                                     (double)j ) ;
                   
                   main();
              } 
          } 
     } 
     public void main() {
          
     } 
} 
