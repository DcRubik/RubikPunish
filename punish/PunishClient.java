/*    */ package punish;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import util.NautHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PunishClient
/*    */ {
/* 15 */   private NautHashMap<Category, List<Punishment>> _punishments = new NautHashMap();
/*    */ 
/*    */ 
/*    */   
/*    */   public void AddPunishment(Category category, Punishment punishment) {
/* 20 */     if (!this._punishments.containsKey(category)) {
/* 21 */       this._punishments.put(category, new ArrayList());
/*    */     }
/* 23 */     ((List<Punishment>)this._punishments.get(category)).add(punishment);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean IsBanned() {
/* 29 */     for (Iterator<List<Punishment>> localIterator1 = this._punishments.values().iterator(); localIterator1.hasNext(); 
/* 30 */       localIterator2.hasNext()) {
/*    */       
/* 32 */       List<Punishment> punishments = localIterator1.next();
/*    */       
/* 34 */       Iterator<Punishment> localIterator2 = punishments.iterator(); Punishment punishment = localIterator2.next();
/*    */       
/* 36 */       if (punishment.IsBanned())
/*    */       {
/* 38 */         return true;
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean IsMuted() {
/* 49 */     for (Iterator<List<Punishment>> localIterator1 = this._punishments.values().iterator(); localIterator1.hasNext(); 
/* 50 */       localIterator2.hasNext()) {
/*    */       
/* 52 */       List<Punishment> punishments = localIterator1.next();
/*    */       
/* 54 */       Iterator<Punishment> localIterator2 = punishments.iterator(); Punishment punishment = localIterator2.next();
/*    */       
/* 56 */       if (punishment.IsMuted())
/*    */       {
/* 58 */         return true;
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 63 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Punishment GetPunishment(PunishmentSentence sentence) {
/* 69 */     for (Iterator<List<Punishment>> localIterator1 = this._punishments.values().iterator(); localIterator1.hasNext(); 
/* 70 */       localIterator2.hasNext()) {
/*    */       
/* 72 */       List<Punishment> punishments = localIterator1.next();
/*    */       
/* 74 */       Iterator<Punishment> localIterator2 = punishments.iterator(); Punishment punishment = localIterator2.next();
/*    */       
/* 76 */       if (sentence == PunishmentSentence.Ban && punishment.IsBanned())
/*    */       {
/* 78 */         return punishment;
/*    */       }
/* 80 */       if (sentence == PunishmentSentence.Mute && punishment.IsMuted())
/*    */       {
/* 82 */         return punishment;
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 87 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public NautHashMap<Category, List<Punishment>> GetPunishments() {
/* 92 */     return this._punishments;
/*    */   }
/*    */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar!\punish\PunishClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */