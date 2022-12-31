/*     */ package punish;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.EventPriority;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*     */ import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import punish.ui.PunishPage;
/*     */ import util.C;
/*     */ import util.F;
/*     */ import util.UtilPlayer;
/*     */ import util.UtilServer;
/*     */ import util.UtilTime;
/*     */ 
/*     */ public class Punish
/*     */   extends JavaPlugin implements Listener {
/*  26 */   private static HashMap<String, PunishClient> _punishClients = new HashMap<>();
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  30 */     Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
/*  31 */     saveDefaultConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onDisable() {
/*  36 */     saveConfig();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
/*  41 */     if (sender instanceof Player) {
/*     */       
/*  43 */       Player p = (Player)sender;
/*     */       
/*  45 */       if ((cmd.getName().equals("p") || cmd.getName().equals("punish")) && 
/*  46 */         p.hasPermission("rubikpunish.use")) {
/*  47 */         if (args.length > 1) {
/*  48 */           p.openInventory(PunishPage.Punish(args[0], p, F.combine(args, 1, null, false)));
/*     */         } else {
/*  50 */           UtilPlayer.message((Entity)p, F.main("/punish <player> <reason>"));
/*  51 */           return false;
/*     */         } 
/*     */       }
/*     */     } 
/*  55 */     return false;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void punishClick(InventoryClickEvent e) {
/*  60 */     if (e.getClickedInventory().getName() == "Punish") {
/*  61 */       e.setCancelled(true);
/*  62 */       if (e.getCurrentItem().equals(PunishPage.Sev1Mute)) {
/*  63 */         e.getWhoClicked().closeInventory();
/*  64 */         AddPunishment(PunishPage._target, Category.ChatOffense, PunishPage._reason, PunishPage._admin, 1, PunishmentSentence.Mute, 2L);
/*  65 */       } else if (e.getCurrentItem().equals(PunishPage.Sev2Mute)) {
/*  66 */         e.getWhoClicked().closeInventory();
/*  67 */         AddPunishment(PunishPage._target, Category.ChatOffense, PunishPage._reason, PunishPage._admin, 2, PunishmentSentence.Mute, 24L);
/*  68 */       } else if (e.getCurrentItem().equals(PunishPage.Sev3Mute)) {
/*  69 */         e.getWhoClicked().closeInventory();
/*  70 */         AddPunishment(PunishPage._target, Category.ChatOffense, PunishPage._reason, PunishPage._admin, 3, PunishmentSentence.Mute, -1L);
/*  71 */       } else if (e.getCurrentItem().equals(PunishPage.Sev1Ban)) {
/*  72 */         e.getWhoClicked().closeInventory();
/*  73 */         AddPunishment(PunishPage._target, Category.Exploiting, PunishPage._reason, PunishPage._admin, 1, PunishmentSentence.Ban, 2L);
/*  74 */       } else if (e.getCurrentItem().equals(PunishPage.Sev2Ban)) {
/*  75 */         e.getWhoClicked().closeInventory();
/*  76 */         AddPunishment(PunishPage._target, Category.Exploiting, PunishPage._reason, PunishPage._admin, 2, PunishmentSentence.Ban, 24L);
/*  77 */       } else if (e.getCurrentItem().equals(PunishPage.Sev3Ban)) {
/*  78 */         e.getWhoClicked().closeInventory();
/*  79 */         AddPunishment(PunishPage._target, Category.Exploiting, PunishPage._reason, PunishPage._admin, 3, PunishmentSentence.Ban, -1L);
/*  80 */       } else if (e.getCurrentItem().equals(PunishPage.Sev1Mod)) {
/*  81 */         e.getWhoClicked().closeInventory();
/*  82 */         AddPunishment(PunishPage._target, Category.Hacking, PunishPage._reason, PunishPage._admin, 1, PunishmentSentence.Ban, 12L);
/*  83 */       } else if (e.getCurrentItem().equals(PunishPage.Sev2Mod)) {
/*  84 */         e.getWhoClicked().closeInventory();
/*  85 */         AddPunishment(PunishPage._target, Category.Hacking, PunishPage._reason, PunishPage._admin, 2, PunishmentSentence.Ban, 168L);
/*  86 */       } else if (e.getCurrentItem().equals(PunishPage.Sev3Mod)) {
/*  87 */         e.getWhoClicked().closeInventory();
/*  88 */         AddPunishment(PunishPage._target, Category.Hacking, PunishPage._reason, PunishPage._admin, 3, PunishmentSentence.Ban, -1L);
/*  89 */       } else if (e.getCurrentItem().equals(PunishPage.permBan)) {
/*  90 */         e.getWhoClicked().closeInventory();
/*  91 */         AddPunishment(PunishPage._target, Category.PermBan, PunishPage._reason, PunishPage._admin, 4, PunishmentSentence.Ban, -1L);
/*  92 */       } else if (e.getCurrentItem().equals(PunishPage.permMute)) {
/*  93 */         e.getWhoClicked().closeInventory();
/*  94 */         AddPunishment(PunishPage._target, Category.PermMute, PunishPage._reason, PunishPage._admin, 4, PunishmentSentence.Mute, -1L);
/*  95 */       } else if (e.getCurrentItem().equals(PunishPage.warning)) {
/*  96 */         e.getWhoClicked().closeInventory();
/*  97 */         AddPunishment(PunishPage._target, Category.Warning, PunishPage._reason, PunishPage._admin, 0, PunishmentSentence.Mute, 0L);
/*  98 */       } else if (e.getCurrentItem().equals(PunishPage.Sev1)) {
/*  99 */         e.getWhoClicked().closeInventory();
/* 100 */         getConfig().set(PunishPage._target, "");
/* 101 */         e.getWhoClicked().sendMessage(F.main("Punish", "Punishment removed. Changes will appear after server reloads or restarts."));
/* 102 */       } else if (e.getCurrentItem().equals(PunishPage.Sev2)) {
/* 103 */         e.getWhoClicked().closeInventory();
/* 104 */         getConfig().set(PunishPage._target, "");
/* 105 */         e.getWhoClicked().sendMessage(F.main("Punish", "Punishment removed. Changes will appear after server reloads or restarts."));
/* 106 */       } else if (e.getCurrentItem().equals(PunishPage.Sev3)) {
/* 107 */         e.getWhoClicked().closeInventory();
/* 108 */         getConfig().set(PunishPage._target, "");
/* 109 */         e.getWhoClicked().sendMessage(F.main("Punish", "Punishment removed. Changes will appear after server reloads or restarts."));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public PunishClient LoadCilent(String name) {
/* 115 */     PunishClient punish = new PunishClient();
/* 116 */     punish.AddPunishment(Category.valueOf(getConfig().getString(String.valueOf(name) + ".category")), new Punishment(this, name, PunishmentSentence.valueOf(getConfig().getString(String.valueOf(name) + ".sentence")), Category.valueOf(getConfig().getString(String.valueOf(name) + ".category")), getConfig().getString(String.valueOf(name) + ".reason"), getConfig().getString(String.valueOf(name) + ".admin"), getConfig().getDouble(String.valueOf(name) + ".hours"), getConfig().getInt(String.valueOf(name) + ".severity"), getConfig().getLong(String.valueOf(name) + ".time")));
/* 117 */     _punishClients.put(name.toLowerCase(), punish);
/* 118 */     return _punishClients.get(name.toLowerCase());
/*     */   }
/*     */ 
/*     */   
/*     */   public static PunishClient GetClient(String name) {
/* 123 */     return _punishClients.get(name.toLowerCase());
/*     */   }
/*     */ 
/*     */   
/*     */   public void AddPunishment(String playerName, Category category, String reason, Player caller, int severity, PunishmentSentence sentence, long duration) {
/* 128 */     PunishClient client = new PunishClient();
/*     */     
/* 130 */     client.AddPunishment(category, new Punishment(this, playerName, sentence, category, reason, caller.getName(), duration, severity, System.currentTimeMillis()));
/*     */     
/* 132 */     _punishClients.put(playerName.toLowerCase(), client);
/*     */     
/* 134 */     if (sentence.equals(PunishmentSentence.Ban)) {
/* 135 */       String time = F.time(UtilTime.convertString(GetClient(playerName).GetPunishment(PunishmentSentence.Ban).GetRemaining(), 0, UtilTime.TimeUnit.FIT));
/*     */       
/* 137 */       if (duration == -1.0D) {
/* 138 */         time = "Permanent";
/*     */       }
/* 140 */       String kickMessage = C.cRed + C.Bold + "You are banned for " + time + "§r\n §f" + reason;
/* 141 */       Bukkit.getPlayerExact(playerName).kickPlayer(kickMessage);
/* 142 */       UtilServer.broadcast(F.main("Punish", String.valueOf(F.elem((caller == null) ? "DcRubik Anti-Cheat" : caller.getName())) + " banned " + F.elem(playerName) + " because of " + F.elem(reason) + " for " + time + "."));
/* 143 */     } else if (sentence.equals(PunishmentSentence.Mute) && !category.equals(Category.Warning)) {
/* 144 */       String time = F.time(UtilTime.convertString(GetClient(playerName).GetPunishment(PunishmentSentence.Mute).GetRemaining(), 0, UtilTime.TimeUnit.FIT));
/*     */       
/* 146 */       if (duration == -1.0D) {
/* 147 */         time = F.time("Permanent");
/*     */       }
/* 149 */       UtilServer.broadcast(F.main("Punish", String.valueOf(F.elem((caller == null) ? "Mineplex Anti-Cheat" : caller.getName())) + " muted " + F.elem(playerName) + " because of " + F.elem(reason) + " for " + time + "."));
/* 150 */     } else if (category.equals(Category.Warning)) {
/* 151 */       Bukkit.getPlayerExact(playerName).sendMessage(String.valueOf(F.main("Punish", F.elem((caller == null) ? "Mineplex Anti-Cheat" : caller.getName()))) + " warned you because of " + F.elem(reason) + ".");
/* 152 */       caller.sendMessage(String.valueOf(F.main("Punish", "You warned " + F.elem(playerName) + " because of " + F.elem(reason))) + ".");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler(priority = EventPriority.LOWEST)
/*     */   public void PunishChatEvent(AsyncPlayerChatEvent event) {
/* 162 */     LoadCilent(event.getPlayer().getName());
/*     */     
/* 164 */     if (GetClient(event.getPlayer().getName()).IsMuted()) {
/*     */       
/* 166 */       String time = F.time(UtilTime.convertString(GetClient(event.getPlayer().getName()).GetPunishment(PunishmentSentence.Mute).GetRemaining(), 0, UtilTime.TimeUnit.FIT));
/*     */       
/* 168 */       if (GetClient(event.getPlayer().getName()).GetPunishment(PunishmentSentence.Mute).GetHours() == -1.0D) {
/* 169 */         time = "Permanent";
/*     */       }
/* 171 */       event.getPlayer().sendMessage(F.main("Punish", "Shh, you're muted because " + GetClient(event.getPlayer().getName()).GetPunishment(PunishmentSentence.Mute).GetReason() + " by " + GetClient(event.getPlayer().getName()).GetPunishment(PunishmentSentence.Mute).GetAdmin() + " for " + C.cGreen + time + "."));
/* 172 */       event.setCancelled(true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler(priority = EventPriority.HIGHEST)
/*     */   public void PlayerLogin(AsyncPlayerPreLoginEvent event) {
/* 180 */     LoadCilent(event.getName());
/*     */     
/* 182 */     if (GetClient(event.getName()).IsBanned()) {
/*     */       
/* 184 */       String time = UtilTime.convertString(GetClient(event.getName()).GetPunishment(PunishmentSentence.Ban).GetRemaining(), 0, UtilTime.TimeUnit.FIT);
/*     */       
/* 186 */       if (GetClient(event.getName()).GetPunishment(PunishmentSentence.Ban).GetHours() == -1.0D) {
/* 187 */         time = "Permanent";
/*     */       }
/* 189 */       String reason = C.cRed + C.Bold + "You are banned for " + time + "§r\n §f" + GetClient(event.getName()).GetPunishment(PunishmentSentence.Ban).GetReason();
/* 190 */       event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, reason);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar!\punish\Punish.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */