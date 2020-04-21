/***
* xyztrgba
**/
package pixelart.base;
import one.empty3.library.shader.Vec;
public class Vec8 extends BaseMovieGenerator {
     private Vec[][] vec ;
     
     public Vec8(int rx, int ry) {
          vec = new Vec[rx] [ry] ;
     } 
     public double time() {} 
     public Vec coordXY() {
         
     
     } 
     public void color(Vec c) {} 
     public void loop() {
          Timer timer = new Timer() ;
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
