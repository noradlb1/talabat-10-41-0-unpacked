package org.apache.commons.compress.compressors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FileNameUtil {
    private final Map<String, String> compressSuffix = new HashMap();
    private final String defaultExtension;
    private final int longestCompressedSuffix;
    private final int longestUncompressedSuffix;
    private final int shortestCompressedSuffix;
    private final int shortestUncompressedSuffix;
    private final Map<String, String> uncompressSuffix;

    public FileNameUtil(Map<String, String> map, String str) {
        this.uncompressSuffix = Collections.unmodifiableMap(map);
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MAX_VALUE;
        int i14 = Integer.MIN_VALUE;
        for (Map.Entry next : map.entrySet()) {
            int length = ((String) next.getKey()).length();
            i11 = length > i11 ? length : i11;
            i12 = length < i12 ? length : i12;
            String str2 = (String) next.getValue();
            int length2 = str2.length();
            if (length2 > 0) {
                if (!this.compressSuffix.containsKey(str2)) {
                    this.compressSuffix.put(str2, next.getKey());
                }
                i14 = length2 > i14 ? length2 : i14;
                if (length2 < i13) {
                    i13 = length2;
                }
            }
        }
        this.longestCompressedSuffix = i11;
        this.longestUncompressedSuffix = i14;
        this.shortestCompressedSuffix = i12;
        this.shortestUncompressedSuffix = i13;
        this.defaultExtension = str;
    }

    public String getCompressedFilename(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        int i11 = this.shortestUncompressedSuffix;
        while (i11 <= this.longestUncompressedSuffix && i11 < length) {
            int i12 = length - i11;
            String str2 = this.compressSuffix.get(lowerCase.substring(i12));
            if (str2 != null) {
                return str.substring(0, i12) + str2;
            }
            i11++;
        }
        return str + this.defaultExtension;
    }

    public String getUncompressedFilename(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        int i11 = this.shortestCompressedSuffix;
        while (i11 <= this.longestCompressedSuffix && i11 < length) {
            int i12 = length - i11;
            String str2 = this.uncompressSuffix.get(lowerCase.substring(i12));
            if (str2 != null) {
                return str.substring(0, i12) + str2;
            }
            i11++;
        }
        return str;
    }

    public boolean isCompressedFilename(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        int length = lowerCase.length();
        int i11 = this.shortestCompressedSuffix;
        while (i11 <= this.longestCompressedSuffix && i11 < length) {
            if (this.uncompressSuffix.containsKey(lowerCase.substring(length - i11))) {
                return true;
            }
            i11++;
        }
        return false;
    }
}
