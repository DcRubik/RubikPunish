/*     */ package util;
/*     */ 
/*     */ import org.bukkit.ChatColor;
/*     */ 
/*     */ 
/*     */ public class F
/*     */ {
/*     */   public static String main(String module, String body) {
/*   9 */     return C.mHead + module + "> " + C.mBody + body;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String tute(String sender, String body) {
/*  14 */     return C.cGold + sender + "> " + C.cWhite + body;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String te(String message) {
/*  19 */     return C.cYellow + message + C.cWhite;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String game(String elem) {
/*  24 */     return C.mGame + elem + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String ta(String message) {
/*  29 */     return C.cGreen + message + C.cWhite;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String ts(String message) {
/*  34 */     return C.cGold + message + C.cWhite;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String sys(String head, String body) {
/*  39 */     return C.sysHead + head + "> " + C.sysBody + body;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String elem(String elem) {
/*  44 */     return C.mElem + elem + ChatColor.RESET + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String name(String elem) {
/*  49 */     return C.mElem + elem + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String count(String elem) {
/*  54 */     return C.mCount + elem + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String item(String elem) {
/*  59 */     return C.mItem + elem + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String link(String elem) {
/*  64 */     return C.mLink + elem + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String skill(String elem) {
/*  69 */     return C.mSkill + elem + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String skill(String a, String b) {
/*  74 */     return C.cYellow + " " + C.cGreen + b + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String time(String elem) {
/*  79 */     return C.mTime + elem + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String desc(String head, String body) {
/*  84 */     return C.descHead + head + ": " + C.descBody + body;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String wField(String field, String data) {
/*  89 */     return C.wFrame + "[" + C.wField + field + C.wFrame + "] " + C.mBody + data + " ";
/*     */   }
/*     */ 
/*     */   
/*     */   public static String value(String variable, String value) {
/*  94 */     return value(0, variable, value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String value(int a, String variable, String value) {
/*  99 */     String indent = "";
/* 100 */     while (indent.length() < a) {
/* 101 */       indent = String.valueOf(indent) + ChatColor.GRAY + ">";
/*     */     }
/* 103 */     return String.valueOf(indent) + C.listTitle + variable + ": " + C.listValue + value;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String value(String variable, String value, boolean on) {
/* 108 */     return value(0, variable, value, on);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String value(int a, String variable, String value, boolean on) {
/* 113 */     String indent = "";
/* 114 */     while (indent.length() < a) {
/* 115 */       indent = String.valueOf(indent) + ChatColor.GRAY + ">";
/*     */     }
/* 117 */     if (on) return String.valueOf(indent) + C.listTitle + variable + ": " + C.listValueOn + value; 
/* 118 */     return String.valueOf(indent) + C.listTitle + variable + ": " + C.listValueOff + value;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String oo(boolean var) {
/* 123 */     if (var)
/* 124 */       return C.listValueOn + "On" + C.mBody; 
/* 125 */     return C.listValueOff + "Off" + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String tf(boolean var) {
/* 130 */     if (var)
/* 131 */       return C.listValueOn + "True" + C.mBody; 
/* 132 */     return C.listValueOff + "False" + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String oo(String variable, boolean value) {
/* 137 */     if (value)
/* 138 */       return C.listValueOn + variable + C.mBody; 
/* 139 */     return C.listValueOff + variable + C.mBody;
/*     */   }
/*     */ 
/*     */   
/*     */   public static String combine(String[] args, int start, String color, boolean comma) {
/* 144 */     if (args.length == 0) {
/* 145 */       return "";
/*     */     }
/* 147 */     String out = "";
/*     */     
/* 149 */     for (int i = start; i < args.length; i++) {
/*     */       
/* 151 */       if (color != null) {
/*     */         
/* 153 */         String preColor = ChatColor.getLastColors(args[i]);
/* 154 */         out = String.valueOf(out) + color + args[i] + preColor;
/*     */       } else {
/*     */         
/* 157 */         out = String.valueOf(out) + args[i];
/*     */       } 
/* 159 */       if (comma) {
/* 160 */         out = String.valueOf(out) + ", ";
/*     */       } else {
/* 162 */         out = String.valueOf(out) + " ";
/*     */       } 
/*     */     } 
/* 165 */     if (out.length() > 0)
/* 166 */       if (comma) { out = out.substring(0, out.length() - 2); }
/* 167 */       else { out = out.substring(0, out.length() - 1); }
/*     */        
/* 169 */     return out;
/*     */   }
/*     */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar\\util\F.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */