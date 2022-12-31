/*    */ package util;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class UtilServer
/*    */ {
/*    */   public static Collection<? extends Player> getPlayers() {
/* 14 */     return getServer().getOnlinePlayers();
/*    */   }
/*    */ 
/*    */   
/*    */   public static Server getServer() {
/* 19 */     return Bukkit.getServer();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void broadcast(String message) {
/* 24 */     for (Player cur : getPlayers()) {
/* 25 */       UtilPlayer.message((Entity)cur, message);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void broadcastSpecial(String event, String message) {
/* 30 */     for (Player cur : getPlayers()) {
/*    */       
/* 32 */       UtilPlayer.message((Entity)cur, "§b§l" + event);
/* 33 */       UtilPlayer.message((Entity)cur, message);
/* 34 */       cur.playSound(cur.getLocation(), Sound.ORB_PICKUP, 2.0F, 0.0F);
/* 35 */       cur.playSound(cur.getLocation(), Sound.ORB_PICKUP, 2.0F, 0.0F);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void broadcast(String sender, String message) {
/* 41 */     broadcast("§f§l" + sender + " " + "§b" + message);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void broadcastMagic(String sender, String message) {
/* 46 */     broadcast("§2§k" + message);
/*    */   }
/*    */ 
/*    */   
/*    */   public static double getFilledPercent() {
/* 51 */     return (getPlayers().size() / getServer().getMaxPlayers());
/*    */   }
/*    */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar\\util\UtilServer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */