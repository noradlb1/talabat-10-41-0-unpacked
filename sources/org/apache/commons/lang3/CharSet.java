package org.apache.commons.lang3;

import j$.util.DesugarCollections;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharSet implements Serializable {
    public static final CharSet ASCII_ALPHA;
    public static final CharSet ASCII_ALPHA_LOWER;
    public static final CharSet ASCII_ALPHA_UPPER;
    public static final CharSet ASCII_NUMERIC;
    protected static final Map<String, CharSet> COMMON;
    public static final CharSet EMPTY;
    private static final long serialVersionUID = 5947847346149275958L;
    private final Set<CharRange> set = Collections.synchronizedSet(new HashSet());

    static {
        CharSet charSet = new CharSet(null);
        EMPTY = charSet;
        CharSet charSet2 = new CharSet("a-zA-Z");
        ASCII_ALPHA = charSet2;
        CharSet charSet3 = new CharSet("a-z");
        ASCII_ALPHA_LOWER = charSet3;
        CharSet charSet4 = new CharSet("A-Z");
        ASCII_ALPHA_UPPER = charSet4;
        CharSet charSet5 = new CharSet("0-9");
        ASCII_NUMERIC = charSet5;
        Map<String, CharSet> synchronizedMap = DesugarCollections.synchronizedMap(new HashMap());
        COMMON = synchronizedMap;
        synchronizedMap.put((Object) null, charSet);
        synchronizedMap.put("", charSet);
        synchronizedMap.put("a-zA-Z", charSet2);
        synchronizedMap.put("A-Za-z", charSet2);
        synchronizedMap.put("a-z", charSet3);
        synchronizedMap.put("A-Z", charSet4);
        synchronizedMap.put("0-9", charSet5);
    }

    public CharSet(String... strArr) {
        for (String add : strArr) {
            add(add);
        }
    }

    public static CharSet getInstance(String... strArr) {
        CharSet charSet;
        if (strArr == null) {
            return null;
        }
        if (strArr.length != 1 || (charSet = COMMON.get(strArr[0])) == null) {
            return new CharSet(strArr);
        }
        return charSet;
    }

    public void add(String str) {
        if (str != null) {
            int length = str.length();
            int i11 = 0;
            while (i11 < length) {
                int i12 = length - i11;
                if (i12 >= 4 && str.charAt(i11) == '^' && str.charAt(i11 + 2) == '-') {
                    this.set.add(CharRange.isNotIn(str.charAt(i11 + 1), str.charAt(i11 + 3)));
                    i11 += 4;
                } else if (i12 >= 3 && str.charAt(i11 + 1) == '-') {
                    this.set.add(CharRange.isIn(str.charAt(i11), str.charAt(i11 + 2)));
                    i11 += 3;
                } else if (i12 < 2 || str.charAt(i11) != '^') {
                    this.set.add(CharRange.is(str.charAt(i11)));
                    i11++;
                } else {
                    this.set.add(CharRange.isNot(str.charAt(i11 + 1)));
                    i11 += 2;
                }
            }
        }
    }

    public boolean contains(char c11) {
        for (CharRange contains : this.set) {
            if (contains.contains(c11)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharSet)) {
            return false;
        }
        return this.set.equals(((CharSet) obj).set);
    }

    public CharRange[] getCharRanges() {
        Set<CharRange> set2 = this.set;
        return (CharRange[]) set2.toArray(new CharRange[set2.size()]);
    }

    public int hashCode() {
        return this.set.hashCode() + 89;
    }

    public String toString() {
        return this.set.toString();
    }
}
