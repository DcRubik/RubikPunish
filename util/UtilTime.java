/*    */ package util;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ 
/*    */ 
/*    */ public class UtilTime
/*    */ {
/*    */   public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
/*    */   public static final String DATE_FORMAT_DAY = "yyyy-MM-dd";
/*    */   
/*    */   public static String now() {
/* 13 */     Calendar cal = Calendar.getInstance();
/* 14 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 15 */     return sdf.format(cal.getTime());
/*    */   }
/*    */ 
/*    */   
/*    */   public static String when(long time) {
/* 20 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 21 */     return sdf.format(Long.valueOf(time));
/*    */   }
/*    */ 
/*    */   
/*    */   public static String date() {
/* 26 */     Calendar cal = Calendar.getInstance();
/* 27 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/* 28 */     return sdf.format(cal.getTime());
/*    */   }
/*    */ 
/*    */   
/*    */   public static String since(long epoch) {
/* 33 */     return "Took " + convertString(System.currentTimeMillis() - epoch, 1, TimeUnit.FIT) + ".";
/*    */   }
/*    */ 
/*    */   
/*    */   public static double convert(long time, int trim, TimeUnit type) {
/* 38 */     if (type == TimeUnit.FIT)
/*    */     {
/* 40 */       if (time < 60000L) { type = TimeUnit.SECONDS; }
/* 41 */       else if (time < 3600000L) { type = TimeUnit.MINUTES; }
/* 42 */       else if (time < 86400000L) { type = TimeUnit.HOURS; }
/* 43 */       else { type = TimeUnit.DAYS; }
/*    */     
/*    */     }
/* 46 */     if (type == TimeUnit.DAYS) return UtilMath.trim(trim, time / 8.64E7D); 
/* 47 */     if (type == TimeUnit.HOURS) return UtilMath.trim(trim, time / 3600000.0D); 
/* 48 */     if (type == TimeUnit.MINUTES) return UtilMath.trim(trim, time / 60000.0D); 
/* 49 */     if (type == TimeUnit.SECONDS) return UtilMath.trim(trim, time / 1000.0D); 
/* 50 */     return UtilMath.trim(trim, time);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String MakeStr(long time) {
/* 55 */     return convertString(time, 1, TimeUnit.FIT);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String MakeStr(long time, int trim) {
/* 60 */     return convertString(time, trim, TimeUnit.FIT);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String convertString(long time, int trim, TimeUnit type) {
/* 65 */     if (time == -1L) return "Permanent";
/*    */     
/* 67 */     if (type == TimeUnit.FIT)
/*    */     {
/* 69 */       if (time < 60000L) { type = TimeUnit.SECONDS; }
/* 70 */       else if (time < 3600000L) { type = TimeUnit.MINUTES; }
/* 71 */       else if (time < 86400000L) { type = TimeUnit.HOURS; }
/* 72 */       else { type = TimeUnit.DAYS; }
/*    */     
/*    */     }
/* 75 */     if (type == TimeUnit.DAYS) return String.valueOf(UtilMath.trim(trim, time / 8.64E7D)) + " Days"; 
/* 76 */     if (type == TimeUnit.HOURS) return String.valueOf(UtilMath.trim(trim, time / 3600000.0D)) + " Hours"; 
/* 77 */     if (type == TimeUnit.MINUTES) return String.valueOf(UtilMath.trim(trim, time / 60000.0D)) + " Minutes"; 
/* 78 */     if (type == TimeUnit.SECONDS) return String.valueOf(UtilMath.trim(trim, time / 1000.0D)) + " Seconds"; 
/* 79 */     return String.valueOf(UtilMath.trim(trim, time)) + " Milliseconds";
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean elapsed(long from, long required) {
/* 84 */     return (System.currentTimeMillis() - from > required);
/*    */   }
/*    */   
/*    */   public enum TimeUnit
/*    */   {
/* 89 */     FIT,
/* 90 */     DAYS,
/* 91 */     HOURS,
/* 92 */     MINUTES,
/* 93 */     SECONDS,
/* 94 */     MILLISECONDS;
/*    */   }
/*    */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar\\util\UtilTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */