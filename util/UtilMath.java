/*    */ package util;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ import java.util.Random;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ 
/*    */ public class UtilMath
/*    */ {
/* 12 */   public static Random random = new Random();
/*    */ 
/*    */   
/*    */   public static double trim(int degree, double d) {
/* 16 */     String format = "#.#";
/*    */     
/* 18 */     for (int i = 1; i < degree; i++) {
/* 19 */       format = String.valueOf(format) + "#";
/*    */     }
/* 21 */     DecimalFormat twoDForm = new DecimalFormat(format);
/* 22 */     return Double.valueOf(twoDForm.format(d)).doubleValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public static int r(int i) {
/* 27 */     return random.nextInt(i);
/*    */   }
/*    */ 
/*    */   
/*    */   public static double offset2d(Entity a, Entity b) {
/* 32 */     return offset2d(a.getLocation().toVector(), b.getLocation().toVector());
/*    */   }
/*    */ 
/*    */   
/*    */   public static double offset2d(Location a, Location b) {
/* 37 */     return offset2d(a.toVector(), b.toVector());
/*    */   }
/*    */ 
/*    */   
/*    */   public static double offset2d(Vector a, Vector b) {
/* 42 */     a.setY(0);
/* 43 */     b.setY(0);
/* 44 */     return a.subtract(b).length();
/*    */   }
/*    */ 
/*    */   
/*    */   public static double offset(Entity a, Entity b) {
/* 49 */     return offset(a.getLocation().toVector(), b.getLocation().toVector());
/*    */   }
/*    */ 
/*    */   
/*    */   public static double offset(Location a, Location b) {
/* 54 */     return offset(a.toVector(), b.toVector());
/*    */   }
/*    */ 
/*    */   
/*    */   public static double offset(Vector a, Vector b) {
/* 59 */     return a.subtract(b).length();
/*    */   }
/*    */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar\\util\UtilMath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */