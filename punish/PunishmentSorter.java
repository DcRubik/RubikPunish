/*    */ package punish;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class PunishmentSorter
/*    */   implements Comparator<Map.Entry<Category, Punishment>>
/*    */ {
/*    */   public int compare(Map.Entry<Category, Punishment> a, Map.Entry<Category, Punishment> b) {
/* 11 */     if (((Punishment)a.getValue()).GetTime() > ((Punishment)b.getValue()).GetTime()) {
/* 12 */       return -1;
/*    */     }
/* 14 */     if (((Punishment)a.getValue()).GetTime() == ((Punishment)b.getValue()).GetTime()) {
/* 15 */       return 0;
/*    */     }
/* 17 */     return 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar!\punish\PunishmentSorter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */