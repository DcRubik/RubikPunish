/*     */ package punish.ui;
/*     */ 
/*     */ import java.util.AbstractMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.DyeColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.inventory.meta.SkullMeta;
/*     */ import org.bukkit.material.MaterialData;
/*     */ import punish.Category;
/*     */ import punish.Punish;
/*     */ import punish.PunishClient;
/*     */ import punish.Punishment;
/*     */ import punish.PunishmentSentence;
/*     */ import punish.PunishmentSorter;
/*     */ import util.UtilTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PunishPage
/*     */ {
/*     */   static Inventory punish;
/*     */   public static String _target;
/*     */   public static String _category;
/*     */   public static PunishmentSentence _sentence;
/*     */   public static String _reason;
/*     */   public static double _duration;
/*     */   public static Player _admin;
/*     */   public static long _time;
/*     */   public static int _severity;
/*  41 */   public static ItemStack Sev1Mute = makeColouredMaterial(Material.INK_SACK, DyeColor.GREEN).toItemStack();
/*  42 */   public static ItemStack Sev2Mute = makeColouredMaterial(Material.INK_SACK, DyeColor.ORANGE).toItemStack();
/*  43 */   public static ItemStack Sev3Mute = makeColouredMaterial(Material.INK_SACK, DyeColor.RED).toItemStack();
/*  44 */   public static ItemStack Sev1Ban = makeColouredMaterial(Material.INK_SACK, DyeColor.GREEN).toItemStack();
/*  45 */   public static ItemStack Sev2Ban = makeColouredMaterial(Material.INK_SACK, DyeColor.ORANGE).toItemStack();
/*  46 */   public static ItemStack Sev3Ban = makeColouredMaterial(Material.INK_SACK, DyeColor.RED).toItemStack();
/*  47 */   public static ItemStack Sev1Mod = makeColouredMaterial(Material.INK_SACK, DyeColor.GREEN).toItemStack();
/*  48 */   public static ItemStack Sev2Mod = makeColouredMaterial(Material.INK_SACK, DyeColor.ORANGE).toItemStack();
/*  49 */   public static ItemStack Sev3Mod = makeColouredMaterial(Material.INK_SACK, DyeColor.RED).toItemStack();
/*  50 */   public static ItemStack Sev1 = makeColouredMaterial(Material.INK_SACK, DyeColor.GREEN).toItemStack();
/*  51 */   public static ItemStack Sev2 = makeColouredMaterial(Material.INK_SACK, DyeColor.ORANGE).toItemStack();
/*  52 */   public static ItemStack Sev3 = makeColouredMaterial(Material.INK_SACK, DyeColor.RED).toItemStack();
/*  53 */   public static ItemStack warning = new ItemStack(Material.PAPER);
/*  54 */   public static ItemStack permBan = new ItemStack(Material.REDSTONE_BLOCK);
/*  55 */   public static ItemStack permMute = new ItemStack(Material.EMERALD_BLOCK);
/*     */ 
/*     */   
/*     */   public static Inventory Punish(String _target, Player player, String _reason) {
/*  59 */     int chatOffenseCount = 0;
/*  60 */     int exploitingCount = 0;
/*  61 */     int hackingCount = 0;
/*     */     
/*  63 */     PunishClient client = Punish.GetClient(_target);
/*     */     
/*  65 */     List<AbstractMap.SimpleEntry<Category, Punishment>> punishments = new ArrayList<>();
/*     */     
/*  67 */     if (client != null) {
/*  68 */       for (Category category : client.GetPunishments().keySet()) {
/*     */         
/*  70 */         for (Punishment punishment : client.GetPunishments().get(category))
/*     */         {
/*  72 */           punishments.add(new AbstractMap.SimpleEntry<>(category, punishment));
/*     */         }
/*     */         
/*  75 */         switch (category) {
/*     */           
/*     */           case null:
/*  78 */             chatOffenseCount = ((List)client.GetPunishments().get(category)).size();
/*     */             break;
/*     */           case Exploiting:
/*  81 */             exploitingCount = ((List)client.GetPunishments().get(category)).size();
/*     */             break;
/*     */           case Hacking:
/*  84 */             hackingCount = ((List)client.GetPunishments().get(category)).size();
/*     */             break;
/*     */ 
/*     */ 
/*     */           
/*     */           case PermBan:
/*     */           case PermMute:
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/*     */     }
/*  97 */     PunishPage._target = _target;
/*  98 */     PunishPage._reason = _reason;
/*  99 */     _admin = player;
/*     */     
/* 101 */     punish = Bukkit.createInventory(null, 54, "Punish");
/* 102 */     ItemStack target = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
/* 103 */     ItemMeta targetm = target.getItemMeta();
/* 104 */     ArrayList<String> targetl = new ArrayList<>();
/* 105 */     targetl.add(ChatColor.RESET + _reason);
/* 106 */     targetm.setDisplayName("§a" + _target);
/* 107 */     targetm.setLore(targetl);
/* 108 */     target.setItemMeta(targetm);
/* 109 */     SkullMeta targets = (SkullMeta)target.getItemMeta();
/* 110 */     targets.setOwner(_target);
/* 111 */     target.setItemMeta((ItemMeta)targets);
/*     */     
/* 113 */     punish.setItem(4, target);
/*     */     
/* 115 */     String examplePrefix = ChatColor.RESET + ChatColor.GRAY;
/* 116 */     String examplePrefixEx = ChatColor.RESET + ChatColor.WHITE;
/* 117 */     String examplePrefixNote = ChatColor.RESET + ChatColor.DARK_GREEN;
/*     */     
/* 119 */     ItemStack chatOffense = new ItemStack(Material.BOOK_AND_QUILL);
/* 120 */     ItemMeta chatOffenseM = chatOffense.getItemMeta();
/* 121 */     ArrayList<String> chatOffenseL = new ArrayList<>();
/* 122 */     chatOffenseM.setDisplayName("§aChat Offense");
/* 123 */     chatOffenseL.add(ChatColor.RESET + "Past offenses : " + ChatColor.YELLOW + chatOffenseCount);
/* 124 */     chatOffenseL.add(String.valueOf(examplePrefix) + "Verbal Abuse, Spam, Harassment, Trolling, etc");
/* 125 */     chatOffenseM.setLore(chatOffenseL);
/* 126 */     chatOffense.setItemMeta(chatOffenseM);
/*     */     
/* 128 */     ItemStack exploiting = new ItemStack(Material.HOPPER);
/* 129 */     ItemMeta exploitingM = exploiting.getItemMeta();
/* 130 */     ArrayList<String> exploitingL = new ArrayList<>();
/* 131 */     exploitingM.setDisplayName("§aGeneral Offense");
/* 132 */     exploitingL.add(ChatColor.RESET + "Past offenses : " + ChatColor.YELLOW + exploitingCount);
/* 133 */     exploitingL.add(String.valueOf(examplePrefix) + "Commmand/Map/Class/Skill exploits, etc");
/* 134 */     exploitingM.setLore(exploitingL);
/* 135 */     exploiting.setItemMeta(exploitingM);
/*     */     
/* 137 */     ItemStack hacking = new ItemStack(Material.IRON_SWORD);
/* 138 */     ItemMeta hackingM = hacking.getItemMeta();
/* 139 */     ArrayList<String> hackingL = new ArrayList<>();
/* 140 */     hackingM.setDisplayName("§aClient Mod");
/* 141 */     hackingL.add(ChatColor.RESET + "Past offenses : " + ChatColor.YELLOW + hackingCount);
/* 142 */     hackingL.add(String.valueOf(examplePrefix) + "X-ray, Forcefield, Speed, Fly, Inventory Hacks, etc");
/* 143 */     hackingM.setLore(hackingL);
/* 144 */     hacking.setItemMeta(hackingM);
/*     */     
/* 146 */     punish.setItem(10, chatOffense);
/* 147 */     punish.setItem(12, exploiting);
/* 148 */     punish.setItem(14, hacking);
/*     */     
/* 150 */     Sev1Mute.setAmount(1);
/* 151 */     ItemMeta Sev1MuteM = Sev1Mute.getItemMeta();
/* 152 */     ArrayList<String> Sev1MuteL = new ArrayList<>();
/* 153 */     Sev1MuteM.setDisplayName("§aSeverity 1");
/* 154 */     Sev1MuteL.add(ChatColor.RESET + "Mute Duration: " + ChatColor.YELLOW + "2 Hours");
/* 155 */     Sev1MuteL.add(" ");
/* 156 */     Sev1MuteL.add(String.valueOf(examplePrefix) + "Spamming same thing in chat (3-5 times)");
/* 157 */     Sev1MuteL.add(" ");
/* 158 */     Sev1MuteL.add(String.valueOf(examplePrefix) + "Light Advertising;");
/* 159 */     Sev1MuteL.add(String.valueOf(examplePrefixEx) + "   'anyone want to play on minecade?'");
/* 160 */     Sev1MuteL.add(" ");
/* 161 */     Sev1MuteL.add(String.valueOf(examplePrefix) + "Trolling");
/* 162 */     Sev1MuteL.add(" ");
/* 163 */     Sev1MuteL.add(String.valueOf(examplePrefix) + "Constantly just talking crap");
/* 164 */     Sev1MuteL.add(" ");
/* 165 */     Sev1MuteL.add(String.valueOf(examplePrefix) + "Pestering staff in admin chat");
/* 166 */     Sev1MuteL.add(" ");
/* 167 */     Sev1MuteL.add(String.valueOf(examplePrefix) + "Accusing a player of hacks in chat");
/* 168 */     Sev1MuteL.add(" ");
/* 169 */     Sev1MuteL.add(String.valueOf(examplePrefixNote) + "Use Severity 2 if many Severity 1 past offences");
/* 170 */     Sev1MuteM.setLore(Sev1MuteL);
/* 171 */     Sev1Mute.setItemMeta(Sev1MuteM);
/*     */     
/* 173 */     AddButton(19, Sev1Mute);
/*     */ 
/*     */     
/* 176 */     Sev2Mute.setAmount(1);
/* 177 */     ItemMeta Sev2MuteM = Sev2Mute.getItemMeta();
/* 178 */     ArrayList<String> Sev2MuteL = new ArrayList<>();
/* 179 */     Sev2MuteM.setDisplayName("§aSeverity 2");
/* 180 */     Sev2MuteL.add(ChatColor.RESET + "Mute Duration: " + ChatColor.YELLOW + "24 Hours");
/* 181 */     Sev2MuteL.add(" ");
/* 182 */     Sev2MuteL.add(String.valueOf(examplePrefix) + "Spamming same thing in chat (6-14 times)");
/* 183 */     Sev2MuteL.add(" ");
/* 184 */     Sev2MuteL.add(String.valueOf(examplePrefix) + "Medium Advertising;");
/* 185 */     Sev2MuteL.add(String.valueOf(examplePrefixEx) + "   'check out my server! crap.server.net'");
/* 186 */     Sev2MuteL.add(" ");
/* 187 */     Sev2MuteL.add(String.valueOf(examplePrefix) + "Rudeness, arguing or abuse between players;");
/* 188 */     Sev2MuteL.add(String.valueOf(examplePrefixEx) + "   'youre terrible, learn to play'");
/* 189 */     Sev2MuteL.add(String.valueOf(examplePrefixEx) + "   'SHIT ADMINS ARE SHIT!!!'");
/* 190 */     Sev2MuteL.add(String.valueOf(examplePrefixEx) + "   'youre terrible, learn to play'");
/* 191 */     Sev2MuteL.add(" ");
/* 192 */     Sev2MuteL.add(String.valueOf(examplePrefixNote) + "Use Severity 3 if many Severity 2 past offences");
/* 193 */     Sev2MuteM.setLore(Sev2MuteL);
/* 194 */     Sev2Mute.setItemMeta(Sev2MuteM);
/*     */     
/* 196 */     AddButton(28, Sev2Mute);
/*     */     
/* 198 */     Sev3Mute.setAmount(1);
/* 199 */     ItemMeta Sev3MuteM = Sev3Mute.getItemMeta();
/* 200 */     ArrayList<String> Sev3MuteL = new ArrayList<>();
/* 201 */     Sev3MuteM.setDisplayName("§aSeverity 3");
/* 202 */     Sev3MuteL.add(ChatColor.RESET + "Mute Duration: " + ChatColor.YELLOW + "Permanent");
/* 203 */     Sev3MuteL.add(" ");
/* 204 */     Sev3MuteL.add(String.valueOf(examplePrefix) + "Spamming same thing in chat (15+ times)");
/* 205 */     Sev3MuteL.add(" ");
/* 206 */     Sev3MuteL.add(String.valueOf(examplePrefix) + "Strong Advertising;");
/* 207 */     Sev3MuteL.add(String.valueOf(examplePrefixEx) + "   'JOIN HYPIXEL!! RUBIK SUCKS'");
/* 208 */     Sev3MuteL.add(" ");
/* 209 */     Sev3MuteL.add(String.valueOf(examplePrefix) + "Severe chat abuse towards players/staff");
/* 210 */     Sev3MuteL.add(String.valueOf(examplePrefixEx) + "   'go fucking die in a fire you fucking sack of shit'");
/* 211 */     Sev3MuteM.setLore(Sev3MuteL);
/* 212 */     Sev3Mute.setItemMeta(Sev3MuteM);
/*     */     
/* 214 */     AddButton(37, Sev3Mute);
/*     */     
/* 216 */     Sev1Ban.setAmount(1);
/* 217 */     ItemMeta Sev1BanM = Sev1Ban.getItemMeta();
/* 218 */     ArrayList<String> Sev1BanL = new ArrayList<>();
/* 219 */     Sev1BanM.setDisplayName("§aSeverity 1");
/* 220 */     Sev1BanL.add(ChatColor.RESET + "Ban Duration: " + ChatColor.YELLOW + "2 Hours");
/* 221 */     Sev1BanL.add(" ");
/* 222 */     Sev1BanL.add(String.valueOf(examplePrefix) + "Some Examples;");
/* 223 */     Sev1BanL.add(String.valueOf(examplePrefixEx) + "   Trolling (Gameplay Only)");
/* 224 */     Sev1BanL.add(String.valueOf(examplePrefixEx) + "   ");
/* 225 */     Sev1BanL.add(" ");
/* 226 */     Sev1BanL.add(String.valueOf(examplePrefixNote) + "Use Severity 2 if many Severity 1 past offences");
/* 227 */     Sev1BanM.setLore(Sev1BanL);
/* 228 */     Sev1Ban.setItemMeta(Sev1BanM);
/*     */     
/* 230 */     AddButton(21, Sev1Ban);
/*     */ 
/*     */     
/* 233 */     Sev2Ban.setAmount(1);
/* 234 */     ItemMeta Sev2BanM = Sev2Ban.getItemMeta();
/* 235 */     ArrayList<String> Sev2BanL = new ArrayList<>();
/* 236 */     Sev2BanM.setDisplayName("§aSeverity 2");
/* 237 */     Sev2BanL.add(ChatColor.RESET + "Ban Duration: " + ChatColor.YELLOW + "24 Hours");
/* 238 */     Sev2BanL.add(" ");
/* 239 */     Sev2BanL.add(String.valueOf(examplePrefix) + "Examples;");
/* 240 */     Sev2BanL.add(String.valueOf(examplePrefixEx) + "   Team killing with water in Bridges");
/* 241 */     Sev2BanL.add(String.valueOf(examplePrefixEx) + "   Wither Skeleton block glitching in SSM to hide");
/* 242 */     Sev2BanL.add(" ");
/* 243 */     Sev2BanL.add(String.valueOf(examplePrefixNote) + "Use Severity 3 if many Severity 2 past offences");
/* 244 */     Sev2BanM.setLore(Sev2BanL);
/* 245 */     Sev2Ban.setItemMeta(Sev2BanM);
/*     */     
/* 247 */     AddButton(30, Sev2Ban);
/*     */     
/* 249 */     Sev3Ban.setAmount(1);
/* 250 */     ItemMeta Sev3BanM = Sev3Ban.getItemMeta();
/* 251 */     ArrayList<String> Sev3BanL = new ArrayList<>();
/* 252 */     Sev3BanM.setDisplayName("§aSeverity 3");
/* 253 */     Sev3BanL.add(ChatColor.RESET + "Ban Duration: " + ChatColor.YELLOW + "Permanent");
/* 254 */     Sev3BanL.add(" ");
/* 255 */     Sev3BanL.add(String.valueOf(examplePrefix) + "Examples;");
/* 256 */     Sev3BanL.add(String.valueOf(examplePrefixEx) + "   Repeatedly crashing server with glitch");
/* 257 */     Sev3BanL.add(" ");
/* 258 */     Sev3BanM.setLore(Sev3BanL);
/* 259 */     Sev3Ban.setItemMeta(Sev3BanM);
/*     */     
/* 261 */     AddButton(39, Sev3Ban);
/*     */     
/* 263 */     Sev1Mod.setAmount(1);
/* 264 */     ItemMeta Sev1ModM = Sev1Mod.getItemMeta();
/* 265 */     ArrayList<String> Sev1ModL = new ArrayList<>();
/* 266 */     Sev1ModM.setDisplayName("§aSeverity 1");
/* 267 */     Sev1ModL.add(ChatColor.RESET + "Ban Duration: " + ChatColor.YELLOW + "12 Hours");
/* 268 */     Sev1ModL.add(" ");
/* 269 */     Sev1ModL.add(String.valueOf(examplePrefix) + "Damage Indicators, Better Sprint, Minimaps");
/* 270 */     Sev1ModL.add(" ");
/* 271 */     Sev1ModL.add(String.valueOf(examplePrefixNote) + "Use this for 1st Offence");
/* 272 */     Sev1ModM.setLore(Sev1ModL);
/* 273 */     Sev1Mod.setItemMeta(Sev1ModM);
/*     */     
/* 275 */     AddButton(23, Sev1Mod);
/*     */     
/* 277 */     Sev2Mod.setAmount(1);
/* 278 */     ItemMeta Sev2ModM = Sev1Mod.getItemMeta();
/* 279 */     ArrayList<String> Sev2ModL = new ArrayList<>();
/* 280 */     Sev2ModM.setDisplayName("§aSeverity 2");
/* 281 */     Sev2ModL.add(ChatColor.RESET + "Ban Duration: " + ChatColor.YELLOW + "1 Week");
/* 282 */     Sev2ModL.add(" ");
/* 283 */     Sev2ModL.add(String.valueOf(examplePrefix) + "Examples;");
/* 284 */     Sev2ModL.add(String.valueOf(examplePrefixEx) + "   Damage Indicators");
/* 285 */     Sev2ModL.add(String.valueOf(examplePrefixEx) + "   Better Sprint");
/* 286 */     Sev2ModL.add(String.valueOf(examplePrefixEx) + "   Player Radar");
/* 287 */     Sev2ModL.add(" ");
/* 288 */     Sev2ModL.add(String.valueOf(examplePrefixNote) + "Use this for 2nd Offence");
/* 289 */     Sev2ModL.add(" ");
/* 290 */     Sev2ModL.add(String.valueOf(examplePrefixNote) + "Use Severity 3 for 3rd Offence");
/* 291 */     Sev2ModM.setLore(Sev2ModL);
/* 292 */     Sev2Mod.setItemMeta(Sev2ModM);
/*     */     
/* 294 */     AddButton(32, Sev2Mod);
/*     */ 
/*     */     
/* 297 */     Sev3Mod.setAmount(1);
/* 298 */     ItemMeta Sev3ModM = Sev3Mod.getItemMeta();
/* 299 */     ArrayList<String> Sev3ModL = new ArrayList<>();
/* 300 */     Sev3ModM.setDisplayName("§aSeverity 3");
/* 301 */     Sev3ModL.add(ChatColor.RESET + "Ban Duration: " + ChatColor.YELLOW + "Permanent");
/* 302 */     Sev3ModL.add(" ");
/* 303 */     Sev3ModL.add(String.valueOf(examplePrefix) + "Examples;");
/* 304 */     Sev3ModL.add(String.valueOf(examplePrefixEx) + "   Fly Hack");
/* 305 */     Sev3ModL.add(String.valueOf(examplePrefixEx) + "   Speed Hack");
/* 306 */     Sev3ModL.add(String.valueOf(examplePrefixEx) + "   Forcefield");
/* 307 */     Sev3ModL.add(" ");
/* 308 */     Sev3ModL.add(String.valueOf(examplePrefixNote) + "Must be 100% sure they were hacking!");
/* 309 */     Sev3ModM.setLore(Sev3ModL);
/* 310 */     Sev3Mod.setItemMeta(Sev3ModM);
/*     */     
/* 312 */     AddButton(41, Sev3Mod);
/*     */     
/* 314 */     ItemMeta warningM = warning.getItemMeta();
/* 315 */     ArrayList<String> warningL = new ArrayList<>();
/* 316 */     warningM.setDisplayName("§aWarning");
/* 317 */     warningL.add(" ");
/* 318 */     warningL.add(String.valueOf(examplePrefix) + "Example Warning Input;");
/* 319 */     warningL.add(String.valueOf(examplePrefixEx) + "   Spam - Repeatedly writing MEOW");
/* 320 */     warningL.add(String.valueOf(examplePrefixEx) + "   Swearing - Saying 'fuck' and 'shit'");
/* 321 */     warningL.add(String.valueOf(examplePrefixEx) + "   Hack Accusation - Accused Tomp13 of hacking");
/* 322 */     warningL.add(String.valueOf(examplePrefixEx) + "   Trolling - was trying to make bob angry in chat");
/* 323 */     warningM.setLore(warningL);
/* 324 */     warning.setItemMeta(warningM);
/*     */     
/* 326 */     AddButton(25, warning);
/*     */     
/* 328 */     ItemMeta permBanM = permBan.getItemMeta();
/* 329 */     ArrayList<String> permBanL = new ArrayList<>();
/* 330 */     permBanM.setDisplayName("§aPermanent Ban");
/* 331 */     permBanL.add(ChatColor.RESET + "Ban Duration: " + ChatColor.YELLOW + "Permanent");
/* 332 */     permBanL.add(" ");
/* 333 */     permBanL.add(String.valueOf(examplePrefixNote) + "Must supply detailed reason for Ban.");
/* 334 */     permBanM.setLore(permBanL);
/* 335 */     permBan.setItemMeta(permBanM);
/*     */     
/* 337 */     AddButton(34, permBan);
/*     */     
/* 339 */     ItemMeta permMuteM = permMute.getItemMeta();
/* 340 */     ArrayList<String> permMuteL = new ArrayList<>();
/* 341 */     permMuteM.setDisplayName("§aPermanent Mute");
/* 342 */     permMuteL.add(ChatColor.RESET + "Mute Duration: " + ChatColor.YELLOW + "Permanent");
/* 343 */     permMuteL.add(" ");
/* 344 */     permMuteL.add(String.valueOf(examplePrefixNote) + "Must supply detailed reason for Mute.");
/* 345 */     permMuteM.setLore(permMuteL);
/* 346 */     permMute.setItemMeta(permMuteM);
/*     */     
/* 348 */     AddButton(43, permMute);
/*     */     
/* 350 */     Collections.sort(punishments, (Comparator<? super AbstractMap.SimpleEntry<Category, Punishment>>)new PunishmentSorter());
/*     */     
/* 352 */     int slot = 45;
/*     */     
/* 354 */     if (client != null)
/*     */     {
/* 356 */       for (Map.Entry<Category, Punishment> punishmentEntry : punishments) {
/*     */ 
/*     */         
/* 359 */         if (slot >= 54) {
/*     */           break;
/*     */         }
/*     */         
/* 363 */         Punishment punishment = punishmentEntry.getValue();
/*     */         
/* 365 */         if (punishment.GetSeverity() == 1) {
/* 366 */           ItemMeta Sev1M = Sev1.getItemMeta();
/* 367 */           Sev1M.setDisplayName("§aSeverity 1");
/* 368 */           Sev1.setAmount(1);
/* 369 */           ArrayList<String> Sev1L = new ArrayList<>();
/* 370 */           Sev1L.add(ChatColor.RESET + "Punishment Type: " + ChatColor.YELLOW + punishment.GetCategory().toString());
/* 371 */           Sev1L.add(ChatColor.RESET + "Severity: " + ChatColor.YELLOW + punishment.GetSeverity());
/* 372 */           Sev1L.add(" ");
/* 373 */           Sev1L.add(ChatColor.RESET + "Reason: " + ChatColor.YELLOW + punishment.GetReason());
/* 374 */           Sev1L.add(" ");
/* 375 */           Sev1L.add(ChatColor.RESET + "Admin: " + ChatColor.YELLOW + punishment.GetAdmin());
/* 376 */           Sev1L.add(ChatColor.RESET + "Date: " + ChatColor.YELLOW + UtilTime.when(punishment.GetTime()));
/* 377 */           Sev1M.setLore(Sev1L);
/* 378 */           Sev1.setItemMeta(Sev1M);
/*     */           
/* 380 */           AddButton(slot, Sev1);
/* 381 */         } else if (punishment.GetSeverity() == 2) {
/* 382 */           ItemMeta Sev2M = Sev2.getItemMeta();
/* 383 */           Sev2M.setDisplayName("§aSeverity 2");
/* 384 */           Sev2.setAmount(1);
/* 385 */           ArrayList<String> Sev2L = new ArrayList<>();
/* 386 */           Sev2L.add(ChatColor.RESET + "Punishment Type: " + ChatColor.YELLOW + punishment.GetCategory().toString());
/* 387 */           Sev2L.add(ChatColor.RESET + "Severity: " + ChatColor.YELLOW + punishment.GetSeverity());
/* 388 */           Sev2L.add(" ");
/* 389 */           Sev2L.add(ChatColor.RESET + "Reason: " + ChatColor.YELLOW + punishment.GetReason());
/* 390 */           Sev2L.add(" ");
/* 391 */           Sev2L.add(ChatColor.RESET + "Admin: " + ChatColor.YELLOW + punishment.GetAdmin());
/* 392 */           Sev2L.add(ChatColor.RESET + "Date: " + ChatColor.YELLOW + UtilTime.when(punishment.GetTime()));
/* 393 */           Sev2M.setLore(Sev2L);
/* 394 */           Sev2.setItemMeta(Sev2M);
/*     */           
/* 396 */           AddButton(slot, Sev2);
/* 397 */         } else if (punishment.GetSeverity() == 3) {
/* 398 */           ItemMeta Sev3M = Sev3.getItemMeta();
/* 399 */           Sev3M.setDisplayName("§aSeverity 3");
/* 400 */           Sev3.setAmount(1);
/* 401 */           ArrayList<String> Sev3L = new ArrayList<>();
/* 402 */           Sev3L.add(ChatColor.RESET + "Punishment Type: " + ChatColor.YELLOW + punishment.GetCategory().toString());
/* 403 */           Sev3L.add(ChatColor.RESET + "Severity: " + ChatColor.YELLOW + punishment.GetSeverity());
/* 404 */           Sev3L.add(" ");
/* 405 */           Sev3L.add(ChatColor.RESET + "Reason: " + ChatColor.YELLOW + punishment.GetReason());
/* 406 */           Sev3L.add(" ");
/* 407 */           Sev3L.add(ChatColor.RESET + "Admin: " + ChatColor.YELLOW + punishment.GetAdmin());
/* 408 */           Sev3L.add(ChatColor.RESET + "Date: " + ChatColor.YELLOW + UtilTime.when(punishment.GetTime()));
/* 409 */           Sev3M.setLore(Sev3L);
/* 410 */           Sev3.setItemMeta(Sev3M);
/*     */           
/* 412 */           AddButton(slot, Sev3);
/*     */         }
/* 414 */         else if (punishment.GetCategory() == Category.PermBan) {
/* 415 */           ItemStack PermBan = permBan.clone();
/* 416 */           ItemMeta PermBanM = PermBan.getItemMeta();
/* 417 */           PermBanM.setDisplayName("§aPermanent Ban");
/* 418 */           PermBan.setAmount(1);
/* 419 */           ArrayList<String> PermBanL = new ArrayList<>();
/* 420 */           PermBanL.add(ChatColor.RESET + "Punishment Type: " + ChatColor.YELLOW + punishment.GetCategory().toString());
/* 421 */           PermBanL.add(ChatColor.RESET + "Severity: " + ChatColor.YELLOW + punishment.GetSeverity());
/* 422 */           PermBanL.add(" ");
/* 423 */           PermBanL.add(ChatColor.RESET + "Reason: " + ChatColor.YELLOW + punishment.GetReason());
/* 424 */           PermBanL.add(" ");
/* 425 */           PermBanL.add(ChatColor.RESET + "Admin: " + ChatColor.YELLOW + punishment.GetAdmin());
/* 426 */           PermBanL.add(ChatColor.RESET + "Date: " + ChatColor.YELLOW + UtilTime.when(punishment.GetTime()));
/* 427 */           PermBanM.setLore(PermBanL);
/* 428 */           PermBan.setItemMeta(PermBanM);
/*     */           
/* 430 */           AddButton(slot, PermBan);
/* 431 */         } else if (punishment.GetCategory() == Category.PermMute) {
/* 432 */           ItemStack PermMute = permMute.clone();
/* 433 */           ItemMeta PermMuteM = PermMute.getItemMeta();
/* 434 */           PermMuteM.setDisplayName("§aPermanent Mute");
/* 435 */           PermMute.setAmount(1);
/* 436 */           ArrayList<String> PermMuteL = new ArrayList<>();
/* 437 */           PermMuteL.add(ChatColor.RESET + "Punishment Type: " + ChatColor.YELLOW + punishment.GetCategory().toString());
/* 438 */           PermMuteL.add(ChatColor.RESET + "Severity: " + ChatColor.YELLOW + punishment.GetSeverity());
/* 439 */           PermMuteL.add(" ");
/* 440 */           PermMuteL.add(ChatColor.RESET + "Reason: " + ChatColor.YELLOW + punishment.GetReason());
/* 441 */           PermMuteL.add(" ");
/* 442 */           PermMuteL.add(ChatColor.RESET + "Admin: " + ChatColor.YELLOW + punishment.GetAdmin());
/* 443 */           PermMuteL.add(ChatColor.RESET + "Date: " + ChatColor.YELLOW + UtilTime.when(punishment.GetTime()));
/* 444 */           PermMuteM.setLore(PermMuteL);
/* 445 */           PermMute.setItemMeta(PermMuteM);
/*     */           
/* 447 */           AddButton(slot, PermMute);
/* 448 */         } else if (punishment.GetCategory() == Category.Warning) {
/* 449 */           ItemStack Warning = warning.clone();
/* 450 */           ItemMeta WarningM = Warning.getItemMeta();
/* 451 */           WarningM.setDisplayName("§aWarning");
/* 452 */           Warning.setAmount(1);
/* 453 */           ArrayList<String> WarningL = new ArrayList<>();
/* 454 */           WarningL.add(ChatColor.RESET + "Punishment Type: " + ChatColor.YELLOW + punishment.GetCategory().toString());
/* 455 */           WarningL.add(ChatColor.RESET + "Severity: " + ChatColor.YELLOW + punishment.GetSeverity());
/* 456 */           WarningL.add(" ");
/* 457 */           WarningL.add(ChatColor.RESET + "Reason: " + ChatColor.YELLOW + punishment.GetReason());
/* 458 */           WarningL.add(" ");
/* 459 */           WarningL.add(ChatColor.RESET + "Admin: " + ChatColor.YELLOW + punishment.GetAdmin());
/* 460 */           WarningL.add(ChatColor.RESET + "Date: " + ChatColor.YELLOW + UtilTime.when(punishment.GetTime()));
/* 461 */           WarningM.setLore(WarningL);
/* 462 */           Warning.setItemMeta(WarningM);
/*     */           
/* 464 */           AddButton(slot, Warning);
/*     */         } 
/* 466 */         slot++;
/*     */       } 
/*     */     }
/*     */     
/* 470 */     return punish;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static MaterialData makeColouredMaterial(Material mat, DyeColor colour) {
/* 476 */     if (mat == Material.GLASS) { mat = Material.STAINED_GLASS; }
/* 477 */     else if (mat == Material.THIN_GLASS)
/* 478 */     { mat = Material.STAINED_GLASS_PANE; }
/*     */     
/* 480 */     return new MaterialData(mat, (mat == Material.INK_SACK) ? colour.getDyeData() : colour.getWoolData());
/*     */   }
/*     */ 
/*     */   
/*     */   private static void AddButton(int slot, ItemStack item) {
/* 485 */     punish.setItem(slot, item);
/*     */   }
/*     */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar!\punis\\ui\PunishPage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */