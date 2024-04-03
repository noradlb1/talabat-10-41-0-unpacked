package org.apache.commons.compress.harmony.unpack200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

public class SegmentConstantPoolArrayCache {
    protected IdentityHashMap knownArrays = new IdentityHashMap(1000);
    protected String[] lastArray;
    protected List lastIndexes;
    protected String lastKey;

    public class CachedArray {
        int lastKnownSize;
        String[] primaryArray;
        HashMap primaryTable = new HashMap(this.lastKnownSize);

        public CachedArray(String[] strArr) {
            this.primaryArray = strArr;
            this.lastKnownSize = strArr.length;
            cacheIndexes();
        }

        public void cacheIndexes() {
            int i11 = 0;
            while (true) {
                String[] strArr = this.primaryArray;
                if (i11 < strArr.length) {
                    String str = strArr[i11];
                    if (!this.primaryTable.containsKey(str)) {
                        this.primaryTable.put(str, new ArrayList());
                    }
                    ((ArrayList) this.primaryTable.get(str)).add(Integer.valueOf(i11));
                    i11++;
                } else {
                    return;
                }
            }
        }

        public List indexesForKey(String str) {
            if (!this.primaryTable.containsKey(str)) {
                return Collections.EMPTY_LIST;
            }
            return (List) this.primaryTable.get(str);
        }

        public int lastKnownSize() {
            return this.lastKnownSize;
        }
    }

    public boolean arrayIsCached(String[] strArr) {
        if (this.knownArrays.containsKey(strArr) && ((CachedArray) this.knownArrays.get(strArr)).lastKnownSize() == strArr.length) {
            return true;
        }
        return false;
    }

    public void cacheArray(String[] strArr) {
        if (!arrayIsCached(strArr)) {
            this.knownArrays.put(strArr, new CachedArray(strArr));
            this.lastArray = null;
            return;
        }
        throw new IllegalArgumentException("Trying to cache an array that already exists");
    }

    public List indexesForArrayKey(String[] strArr, String str) {
        if (!arrayIsCached(strArr)) {
            cacheArray(strArr);
        }
        if (this.lastArray == strArr && this.lastKey == str) {
            return this.lastIndexes;
        }
        this.lastArray = strArr;
        this.lastKey = str;
        List indexesForKey = ((CachedArray) this.knownArrays.get(strArr)).indexesForKey(str);
        this.lastIndexes = indexesForKey;
        return indexesForKey;
    }
}
