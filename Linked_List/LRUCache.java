import java.util.HashMap;

class LRUCache {

    private class CacheEntry {
        int value, lastAccessedTime;

        public CacheEntry(int value, int lastAccessedTime) {
            this.value = value;
            this.lastAccessedTime = lastAccessedTime;
        }
    }

    int globalTime;
    int maximumNumberOfCacheEntries;
    HashMap<Integer, CacheEntry> cacheHashMap;

    public LRUCache(int capacity) {
        globalTime = 0;
        maximumNumberOfCacheEntries = capacity;
        cacheHashMap = new HashMap<Integer, CacheEntry>(capacity);
    }

    public int get(int key) {
        CacheEntry cacheEntry = cacheHashMap.get(key);
        int valueToReturn;

        if (cacheEntry != null) {
            valueToReturn = cacheEntry.value;
            globalTime++;
            cacheEntry.lastAccessedTime = globalTime;
        } else {
            valueToReturn = -1;
        }

        return valueToReturn;
    }

    public void put(int key, int value) {

        // Entry is new and there's no space for it
        if (cacheHashMap.get(key) == null && cacheHashMap.size() + 1 > maximumNumberOfCacheEntries) {

            // First we find the least recently used entry
            int leastRecentlyUsedCacheKeyIndex = cacheHashMap.keySet().iterator().next();
            for (int currentCacheKeyIndex : cacheHashMap.keySet()) {

                if (cacheHashMap.get(currentCacheKeyIndex).lastAccessedTime <= cacheHashMap
                        .get(leastRecentlyUsedCacheKeyIndex).lastAccessedTime) {
                    leastRecentlyUsedCacheKeyIndex = currentCacheKeyIndex;
                }
            }

            // Delete the least recently used entry
            cacheHashMap.remove(leastRecentlyUsedCacheKeyIndex);
        }

        // Add/Update cache entry
        globalTime++;
        cacheHashMap.put(key, new CacheEntry(value, globalTime));
    }
}