/*    */ package punish;
/*    */ 
/*    */ public enum Category
/*    */ {
/*  5 */   ChatOffense,
/*  6 */   Exploiting,
/*  7 */   Hacking,
/*  8 */   Warning,
/*  9 */   PermMute,
/* 10 */   PermBan;
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean contains(String s) {
/*    */     try {
/* 16 */       valueOf(s);
/* 17 */       return true;
/*    */     }
/* 19 */     catch (Exception exception) {
/*    */       
/* 21 */       return false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar!\punish\Category.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */