/*    */ package util;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class NautHashMap<KeyType, ValueType>
/*    */ {
/* 10 */   private HashMap<KeyType, ValueType> _wrappedHashMap = new HashMap<>();
/*    */ 
/*    */   
/*    */   public boolean containsKey(KeyType key) {
/* 14 */     return this._wrappedHashMap.containsKey(key);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean containsValue(ValueType key) {
/* 19 */     return this._wrappedHashMap.containsValue(key);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<Map.Entry<KeyType, ValueType>> entrySet() {
/* 24 */     return this._wrappedHashMap.entrySet();
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<KeyType> keySet() {
/* 29 */     return this._wrappedHashMap.keySet();
/*    */   }
/*    */ 
/*    */   
/*    */   public Collection<ValueType> values() {
/* 34 */     return this._wrappedHashMap.values();
/*    */   }
/*    */ 
/*    */   
/*    */   public ValueType get(KeyType key) {
/* 39 */     return this._wrappedHashMap.get(key);
/*    */   }
/*    */ 
/*    */   
/*    */   public ValueType remove(KeyType key) {
/* 44 */     return this._wrappedHashMap.remove(key);
/*    */   }
/*    */ 
/*    */   
/*    */   public ValueType put(KeyType key, ValueType value) {
/* 49 */     return this._wrappedHashMap.put(key, value);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 54 */     this._wrappedHashMap.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 59 */     return this._wrappedHashMap.size();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEmpty() {
/* 64 */     return this._wrappedHashMap.isEmpty();
/*    */   }
/*    */ }


/* Location:              C:\Users\jesus\Desktop\Rubik\Lobby-1\plugins\Punish.jar\\util\NautHashMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */