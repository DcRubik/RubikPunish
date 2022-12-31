/*     */ package util;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import javax.security.auth.callback.Callback;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UtilPlayer
/*     */ {
/*     */   public static void message(Entity client, LinkedList<String> messageList) {
/*  20 */     message(client, messageList, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void message(Entity client, String message) {
/*  25 */     message(client, message, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void message(Entity client, LinkedList<String> messageList, boolean wiki) {
/*  30 */     for (String curMessage : messageList)
/*     */     {
/*  32 */       message(client, curMessage, wiki);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void message(Entity client, String message, boolean wiki) {
/*  38 */     if (client == null) {
/*     */       return;
/*     */     }
/*  41 */     if (!(client instanceof Player)) {
/*     */       return;
/*     */     }
/*     */     
/*  45 */     ((Player)client).sendMessage(message);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Player searchExact(String name) {
/*  50 */     for (Player cur : Bukkit.getOnlinePlayers()) {
/*  51 */       if (cur.getName().equalsIgnoreCase(name))
/*  52 */         return cur; 
/*     */     } 
/*  54 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String searchCollection(Player caller, String player, Collection<String> coll, String collName, boolean inform) {
/*  59 */     LinkedList<String> matchList = new LinkedList<>();
/*     */     
/*  61 */     for (String cur : coll) {
/*     */       
/*  63 */       if (cur.equalsIgnoreCase(player)) {
/*  64 */         return cur;
/*     */       }
/*  66 */       if (cur.toLowerCase().contains(player.toLowerCase())) {
/*  67 */         matchList.add(cur);
/*     */       }
/*     */     } 
/*     */     
/*  71 */     if (matchList.size() != 1) {
/*     */       
/*  73 */       if (!inform) {
/*  74 */         return null;
/*     */       }
/*     */       
/*  77 */       message((Entity)caller, F.main(String.valueOf(collName) + " Search", 
/*  78 */             C.mCount + matchList.size() + 
/*  79 */             C.mBody + " matches for [" + 
/*  80 */             C.mElem + player + 
/*  81 */             C.mBody + "]."));
/*     */       
/*  83 */       if (matchList.size() > 0) {
/*     */         
/*  85 */         String matchString = "";
/*  86 */         for (String cur : matchList) {
/*  87 */           matchString = String.valueOf(matchString) + cur + " ";
/*     */         }
/*  89 */         message((Entity)caller, F.main(String.valueOf(collName) + " Search", 
/*  90 */               C.mBody + " Matches [" + 
/*  91 */               C.mElem + matchString + 
/*  92 */               C.mBody + "]."));
/*     */       } 
/*     */       
/*  95 */       return null;
/*     */     } 
/*     */     
/*  98 */     return matchList.get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Player searchOnline(Player caller, String player, boolean inform) {
/* 103 */     LinkedList<Player> matchList = new LinkedList<>();
/*     */     
/* 105 */     for (Player cur : Bukkit.getOnlinePlayers()) {
/*     */       
/* 107 */       if (cur.getName().equalsIgnoreCase(player)) {
/* 108 */         return cur;
/*     */       }
/* 110 */       if (cur.getName().toLowerCase().contains(player.toLowerCase())) {
/* 111 */         matchList.add(cur);
/*     */       }
/*     */     } 
/*     */     
/* 115 */     if (matchList.size() != 1) {
/*     */       
/* 117 */       if (!inform) {
/* 118 */         return null;
/*     */       }
/*     */       
/* 121 */       message((Entity)caller, F.main("Online Player Search", 
/* 122 */             C.mCount + matchList.size() + 
/* 123 */             C.mBody + " matches for [" + 
/* 124 */             C.mElem + player + 
/* 125 */             C.mBody + "]."));
/*     */       
/* 127 */       if (matchList.size() > 0) {
/*     */         
/* 129 */         String matchString = "";
/* 130 */         for (Player cur : matchList)
/* 131 */           matchString = String.valueOf(matchString) + F.elem(cur.getName()) + ", "; 
/* 132 */         if (matchString.length() > 1) {
/* 133 */           matchString = matchString.substring(0, matchString.length() - 2);
/*     */         }
/* 135 */         message((Entity)caller, F.main("Online Player Search", 
/* 136 */               C.mBody + "Matches [" + 
/* 137 */               C.mElem + matchString + 
/* 138 */               C.mBody + "]."));
/*     */       } 
/*     */       
/* 141 */       return null;
/*     */     } 
/*     */     
/* 144 */     return matchList.get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void searchOffline(List<String> matches, Callback callback, Player caller, String player, boolean inform) {
/* 149 */     if (matches.size() != 1) {
/*     */       
/* 151 */       if (!inform || !caller.isOnline()) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 156 */       message((Entity)caller, F.main("Offline Player Search", 
/* 157 */             C.mCount + matches.size() + 
/* 158 */             C.mBody + " matches for [" + 
/* 159 */             C.mElem + player + 
/* 160 */             C.mBody + "]."));
/*     */       
/* 162 */       if (matches.size() > 0) {
/*     */         
/* 164 */         String matchString = "";
/* 165 */         for (String cur : matches)
/* 166 */           matchString = String.valueOf(matchString) + cur + " "; 
/* 167 */         if (matchString.length() > 1) {
/* 168 */           matchString = matchString.substring(0, matchString.length() - 2);
/*     */         }
/* 170 */         message((Entity)caller, F.main("Offline Player Search", 
/* 171 */               C.mBody + "Matches [" + 
/* 172 */               C.mElem + matchString + 
/* 173 */               C.mBody + "]."));
/*     */       } 
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static LinkedList<Player> matchOnline(Player caller, String players, boolean inform) {
/* 182 */     LinkedList<Player> matchList = new LinkedList<>();
/*     */     
/* 184 */     String failList = ""; byte b; int i;
/*     */     String[] arrayOfString;
/* 186 */     for (i = (arrayOfString = players.split(",")).length, b = 0; b < i; ) { String cur = arrayOfString[b];
/*     */       
/* 188 */       Player match = searchOnline(caller, cur, inform);
/*     */       
/* 190 */       if (match != null) {
/* 191 */         matchList.add(match);
/*     */       } else {
/*     */         
/* 194 */         failList = String.valueOf(failList) + cur + " ";
/*     */       }  b++; }
/*     */     
/* 197 */     if (inform && failList.length() > 0) {
/*     */       
/* 199 */       failList = failList.substring(0, failList.length() - 1);
/* 200 */       message((Entity)caller, F.main("Online Player(s) Search", 
/* 201 */             C.mBody + "Invalid [" + 
/* 202 */             C.mElem + failList + 
/* 203 */             C.mBody + "]."));
/*     */     } 
/*     */     
/* 206 */     return matchList;
/*     */   }
/*     */ 
/*     */   
/*     */   public static LinkedList<Player> getNearby(Location loc, double maxDist) {
/* 211 */     LinkedList<Player> nearbyMap = new LinkedList<>();
/*     */     
/* 213 */     for (Player cur : loc.getWorld().getPlayers()) {
/*     */       
/* 215 */       if (cur.getGameMode() != GameMode.CREATIVE)
/*     */       {
/* 217 */         if (!cur.isDead()) {
/*     */           
/* 219 */           double dist = loc.toVector().subtract(cur.getLocation().toVector()).length();
/*     */           
/* 221 */           if (dist <= maxDist) {
/*     */             
/* 223 */             for (int i = 0; i < nearbyMap.size(); i++) {
/*     */               
/* 225 */               if (dist < loc.toVector().subtract(((Player)nearbyMap.get(i)).getLocation().toVector()).length()) {
/*     */                 
/* 227 */                 nearbyMap.add(i, cur);
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/* 232 */             if (!nearbyMap.contains(cur))
/* 233 */               nearbyMap.addLast(cur); 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/* 238 */     return nearbyMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Player getClosest(Location loc, Collection<Player> ignore) {
/* 243 */     Player best = null;
/* 244 */     double bestDist = 0.0D;
/*     */     
/* 246 */     for (Player cur : loc.getWorld().getPlayers()) {
/*     */       
/* 248 */       if (cur.getGameMode() != GameMode.CREATIVE)
/*     */       {
/* 250 */         if (!cur.isDead())
/*     */         {
/* 252 */           if (ignore == null || !ignore.contains(cur)) {
/*     */             
/* 254 */             double dist = UtilMath.offset(cur.getLocation(), loc);
/*     */             
/* 256 */             if (best == null || dist < bestDist) {
/*     */               
/* 258 */               best = cur;
/* 259 */               bestDist = dist;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       }
/*     */     } 
/* 265 */     return best;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Player getClosest(Location loc, Entity ignore) {
/* 270 */     Player best = null;
/* 271 */     double bestDist = 0.0D;
/*     */     
/* 273 */     for (Player cur : loc.getWorld().getPlayers()) {
/*     */       
/* 275 */       if (cur.getGameMode() != GameMode.CREATIVE)
/*     */       {
/* 277 */         if (!cur.isDead())
/*     */         {
/* 279 */           if (ignore == null || !ignore.equals(cur)) {
/*     */             
/* 281 */             double dist = UtilMath.offset(cur.getLocation(), loc);
/*     */             
/* 283 */             if (best == null || dist < bestDist) {
/*     */               
/* 285 */               best = cur;
/* 286 */               bestDist = dist;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       }
/*     */     } 
/* 292 */     return best;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void kick(Player player, String module, String message) {
/* 297 */     kick(player, module, message, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void kick(Player player, String module, String message, boolean log) {
/* 302 */     if (player == null) {
/*     */       return;
/*     */     }
/* 305 */     String out = ChatColor.RED + module + 
/* 306 */       ChatColor.WHITE + " - " + 
/* 307 */       ChatColor.YELLOW + message;
/* 308 */     player.kickPlayer(out);
/*     */     
/* 310 */     if (log) {
/* 311 */       System.out.println("Kicked Client [" + player.getName() + "] for [" + module + " - " + message + "]");
/*     */     }
/*     */   }
/*     */   
/*     */   public static HashMap<Player, Double> getInRadius(Location loc, double dR) {
/* 316 */     HashMap<Player, Double> players = new HashMap<>();
/*     */     
/* 318 */     for (Player cur : loc.getWorld().getPlayers()) {
/*     */       
/* 320 */       if (cur.getGameMode() != GameMode.CREATIVE) {
/*     */         
/* 322 */         double offset = UtilMath.offset(loc, cur.getLocation());
/*     */         
/* 324 */         if (offset < dR)
/* 325 */           players.put(cur, Double.valueOf(1.0D - offset / dR)); 
/*     */       } 
/*     */     } 
/* 328 */     return players;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void health(Player player, double mod) {
/* 333 */     if (player.isDead()) {
/*     */       return;
/*     */     }
/* 336 */     double health = player.getHealth() + mod;
/*     */     
/* 338 */     if (health < 0.0D) {
/* 339 */       health = 0.0D;
/*     */     }
/* 341 */     if (health > player.getMaxHealth()) {
/* 342 */       health = player.getMaxHealth();
/*     */     }
/* 344 */     player.setHealth(health);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void hunger(Player player, int mod) {
/* 349 */     if (player.isDead()) {
/*     */       return;
/*     */     }
/* 352 */     int hunger = player.getFoodLevel() + mod;
/*     */     
/* 354 */     if (hunger < 0) {
/* 355 */       hunger = 0;
/*     */     }
/* 357 */     if (hunger > 20) {
/* 358 */       hunger = 20;
/*     */     }
/* 360 */     player.setFoodLevel(hunger);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isOnline(String name) {
/* 365 */     return (searchExact(name) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String safeNameLength(String name) {
/* 370 */     if (name.length() > 16) {
/* 371 */       name = name.substring(0, 16);
/*     */     }
/* 373 */     return name;
/*     */   }
/*     */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar\\util\UtilPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */