/***
* xyztrgba
**/
package pixelart.base;
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
          for(int i= 0; i<vec.length; i++) {
               
              for(int j= 0; j<vec[i] .length; j++) {
                   coordXY = new Vec ((double)i,
                                     (double)j ) ;
              } 
          } 
     } 
     public void main() {
          
     } 
} 
