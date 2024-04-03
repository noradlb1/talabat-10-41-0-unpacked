package com.android.volley.toolbox;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyLog;
import com.google.common.net.HttpHeaders;
import datamodels.TypesAliasesKt;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class HttpHeaderParser {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String RFC1123_OUTPUT_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";
    private static final String RFC1123_PARSE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";

    public static List<Header> combineHeaders(List<Header> list, Cache.Entry entry) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (Header name2 : list) {
                treeSet.add(name2.getName());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<Header> list2 = entry.allResponseHeaders;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (Header next : entry.allResponseHeaders) {
                    if (!treeSet.contains(next.getName())) {
                        arrayList.add(next);
                    }
                }
            }
        } else if (!entry.responseHeaders.isEmpty()) {
            for (Map.Entry next2 : entry.responseHeaders.entrySet()) {
                if (!treeSet.contains(next2.getKey())) {
                    arrayList.add(new Header((String) next2.getKey(), (String) next2.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static String formatEpochAsRfc1123(long j11) {
        return newUsGmtFormatter(RFC1123_OUTPUT_FORMAT).format(new Date(j11));
    }

    public static Map<String, String> getCacheHeaders(Cache.Entry entry) {
        if (entry == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = entry.etag;
        if (str != null) {
            hashMap.put(HttpHeaders.IF_NONE_MATCH, str);
        }
        long j11 = entry.lastModified;
        if (j11 > 0) {
            hashMap.put(HttpHeaders.IF_MODIFIED_SINCE, formatEpochAsRfc1123(j11));
        }
        return hashMap;
    }

    private static SimpleDateFormat newUsGmtFormatter(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    @Nullable
    public static Cache.Entry parseCacheHeaders(NetworkResponse networkResponse) {
        long j11;
        long j12;
        long j13;
        boolean z11;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        NetworkResponse networkResponse2 = networkResponse;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = networkResponse2.headers;
        if (map == null) {
            return null;
        }
        String str = map.get(HttpHeaders.DATE);
        if (str != null) {
            j11 = parseDateAsEpoch(str);
        } else {
            j11 = 0;
        }
        String str2 = map.get("Cache-Control");
        int i11 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z11 = false;
            j13 = 0;
            j12 = 0;
            while (i11 < split.length) {
                String trim = split[i11].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j13 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j12 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z11 = true;
                }
                i11++;
            }
            i11 = 1;
        } else {
            z11 = false;
            j13 = 0;
            j12 = 0;
        }
        String str3 = map.get(HttpHeaders.EXPIRES);
        if (str3 != null) {
            j14 = parseDateAsEpoch(str3);
        } else {
            j14 = 0;
        }
        String str4 = map.get(HttpHeaders.LAST_MODIFIED);
        if (str4 != null) {
            j15 = parseDateAsEpoch(str4);
        } else {
            j15 = 0;
        }
        String str5 = map.get(HttpHeaders.ETAG);
        if (i11 != 0) {
            j17 = currentTimeMillis + (j13 * 1000);
            if (z11) {
                j18 = j17;
            } else {
                Long.signum(j12);
                j18 = (j12 * 1000) + j17;
            }
            j16 = j18;
        } else {
            j16 = 0;
            if (j11 <= 0 || j14 < j11) {
                j17 = 0;
            } else {
                j17 = currentTimeMillis + (j14 - j11);
                j16 = j17;
            }
        }
        Cache.Entry entry = new Cache.Entry();
        entry.data = networkResponse2.data;
        entry.etag = str5;
        entry.softTtl = j17;
        entry.ttl = j16;
        entry.serverDate = j11;
        entry.lastModified = j15;
        entry.responseHeaders = map;
        entry.allResponseHeaders = networkResponse2.allHeaders;
        return entry;
    }

    public static String parseCharset(@Nullable Map<String, String> map, String str) {
        String str2;
        if (!(map == null || (str2 = map.get("Content-Type")) == null)) {
            String[] split = str2.split(TypesAliasesKt.separator, 0);
            for (int i11 = 1; i11 < split.length; i11++) {
                String[] split2 = split[i11].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static long parseDateAsEpoch(String str) {
        try {
            return newUsGmtFormatter(RFC1123_PARSE_FORMAT).parse(str).getTime();
        } catch (ParseException e11) {
            if ("0".equals(str) || "-1".equals(str)) {
                VolleyLog.v("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
            VolleyLog.e(e11, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    public static List<Header> toAllHeaderList(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new Header((String) next.getKey(), (String) next.getValue()));
        }
        return arrayList;
    }

    public static Map<String, String> toHeaderMap(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header next : list) {
            treeMap.put(next.getName(), next.getValue());
        }
        return treeMap;
    }

    public static String parseCharset(@Nullable Map<String, String> map) {
        return parseCharset(map, "ISO-8859-1");
    }
}
