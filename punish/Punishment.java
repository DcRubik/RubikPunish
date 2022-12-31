/*    */ package punish;
/*    */ 
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ 
/*    */ public class Punishment
/*    */ {
/*    */   private PunishmentSentence _punishmentType;
/*    */   private Category _category;
/*    */   private String _reason;
/*    */   private String _admin;
/*    */   private double _hours;
/*    */   private int _severity;
/*    */   private long _time;
/*    */   
/*    */   public Punishment(JavaPlugin plugin, String name, PunishmentSentence punishmentType, Category category, String reason, String admin, double hours, int severity, long time) {
/* 17 */     this._punishmentType = punishmentType;
/* 18 */     this._category = category;
/* 19 */     this._reason = reason;
/* 20 */     this._admin = admin;
/* 21 */     this._hours = hours;
/* 22 */     this._severity = severity;
/* 23 */     this._time = time;
/* 24 */     plugin.getConfig().set(String.valueOf(name) + ".sentence", punishmentType.toString());
/* 25 */     plugin.getConfig().set(String.valueOf(name) + ".category", category.toString());
/* 26 */     plugin.getConfig().set(String.valueOf(name) + ".reason", reason);
/* 27 */     plugin.getConfig().set(String.valueOf(name) + ".admin", admin);
/* 28 */     plugin.getConfig().set(String.valueOf(name) + ".hours", Double.valueOf(hours));
/* 29 */     plugin.getConfig().set(String.valueOf(name) + ".severity", Integer.valueOf(severity));
/* 30 */     plugin.getConfig().set(String.valueOf(name) + ".time", Long.valueOf(time));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PunishmentSentence GetPunishmentType() {
/* 36 */     return this._punishmentType;
/*    */   }
/*    */ 
/*    */   
/*    */   public Category GetCategory() {
/* 41 */     return this._category;
/*    */   }
/*    */ 
/*    */   
/*    */   public String GetReason() {
/* 46 */     return this._reason;
/*    */   }
/*    */ 
/*    */   
/*    */   public String GetAdmin() {
/* 51 */     return this._admin;
/*    */   }
/*    */ 
/*    */   
/*    */   public double GetHours() {
/* 56 */     return this._hours;
/*    */   }
/*    */ 
/*    */   
/*    */   public int GetSeverity() {
/* 61 */     return this._severity;
/*    */   }
/*    */ 
/*    */   
/*    */   public long GetTime() {
/* 66 */     return this._time;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean IsBanned() {
/* 71 */     return (this._punishmentType == PunishmentSentence.Ban && (GetRemaining() > 0L || this._hours < 0.0D));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean IsMuted() {
/* 76 */     return (this._punishmentType == PunishmentSentence.Mute && (GetRemaining() > 0L || this._hours < 0.0D));
/*    */   }
/*    */ 
/*    */   
/*    */   public long GetRemaining() {
/* 81 */     return (this._hours < 0.0D) ? -1L : (long)(this._time + 3600000.0D * this._hours - System.currentTimeMillis());
/*    */   }
/*    */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar!\punish\Punishment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */