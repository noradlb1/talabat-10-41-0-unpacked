package com.android.volley;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NetworkResponse {
    @Nullable
    public final List<Header> allHeaders;
    public final byte[] data;
    @Nullable
    public final Map<String, String> headers;
    public final long networkTimeMs;
    public final boolean notModified;
    public final int statusCode;

    @Deprecated
    public NetworkResponse(int i11, byte[] bArr, @Nullable Map<String, String> map, boolean z11, long j11) {
        this(i11, bArr, map, toAllHeaderList(map), z11, j11);
    }

    @Nullable
    private static List<Header> toAllHeaderList(@Nullable Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new Header((String) next.getKey(), (String) next.getValue()));
        }
        return arrayList;
    }

    @Nullable
    private static Map<String, String> toHeaderMap(@Nullable List<Header> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header next : list) {
            treeMap.put(next.getName(), next.getValue());
        }
        return treeMap;
    }

    public NetworkResponse(int i11, byte[] bArr, boolean z11, long j11, @Nullable List<Header> list) {
        this(i11, bArr, toHeaderMap(list), list, z11, j11);
    }

    @Deprecated
    public NetworkResponse(int i11, byte[] bArr, @Nullable Map<String, String> map, boolean z11) {
        this(i11, bArr, map, z11, 0);
    }

    public NetworkResponse(byte[] bArr) {
        this(200, bArr, false, 0, (List<Header>) Collections.emptyList());
    }

    @Deprecated
    public NetworkResponse(byte[] bArr, @Nullable Map<String, String> map) {
        this(200, bArr, map, false, 0);
    }

    private NetworkResponse(int i11, byte[] bArr, @Nullable Map<String, String> map, @Nullable List<Header> list, boolean z11, long j11) {
        this.statusCode = i11;
        this.data = bArr;
        this.headers = map;
        if (list == null) {
            this.allHeaders = null;
        } else {
            this.allHeaders = Collections.unmodifiableList(list);
        }
        this.notModified = z11;
        this.networkTimeMs = j11;
    }
}
