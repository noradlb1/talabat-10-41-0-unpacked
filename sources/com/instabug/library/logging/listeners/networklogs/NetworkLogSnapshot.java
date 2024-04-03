package com.instabug.library.logging.listeners.networklogs;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NetworkLogSnapshot {
    @Nullable
    private String requestBody;
    @Nullable
    private Map<String, Object> requestHeaders;
    @Nullable
    private String response;
    @Nullable
    private Map<String, Object> responseHeaders;
    @Nullable
    private String url;

    public NetworkLogSnapshot(@Nullable String str, @Nullable Map<String, Object> map, @Nullable String str2, @Nullable Map<String, Object> map2, @Nullable String str3) {
        this.url = str;
        this.requestHeaders = map;
        this.requestBody = str2;
        this.responseHeaders = map2;
        this.response = str3;
    }

    public static /* synthetic */ NetworkLogSnapshot copy$default(NetworkLogSnapshot networkLogSnapshot, String str, Map<String, Object> map, String str2, Map<String, Object> map2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = networkLogSnapshot.url;
        }
        if ((i11 & 2) != 0) {
            map = networkLogSnapshot.requestHeaders;
        }
        Map<String, Object> map3 = map;
        if ((i11 & 4) != 0) {
            str2 = networkLogSnapshot.requestBody;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            map2 = networkLogSnapshot.responseHeaders;
        }
        Map<String, Object> map4 = map2;
        if ((i11 & 16) != 0) {
            str3 = networkLogSnapshot.response;
        }
        return networkLogSnapshot.copy(str, map3, str4, map4, str3);
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    @Nullable
    public final Map<String, Object> component2() {
        return this.requestHeaders;
    }

    @Nullable
    public final String component3() {
        return this.requestBody;
    }

    @Nullable
    public final Map<String, Object> component4() {
        return this.responseHeaders;
    }

    @Nullable
    public final String component5() {
        return this.response;
    }

    @NotNull
    public final NetworkLogSnapshot copy(@Nullable String str, @Nullable Map<String, Object> map, @Nullable String str2, @Nullable Map<String, Object> map2, @Nullable String str3) {
        return new NetworkLogSnapshot(str, map, str2, map2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkLogSnapshot)) {
            return false;
        }
        NetworkLogSnapshot networkLogSnapshot = (NetworkLogSnapshot) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) networkLogSnapshot.url) && Intrinsics.areEqual((Object) this.requestHeaders, (Object) networkLogSnapshot.requestHeaders) && Intrinsics.areEqual((Object) this.requestBody, (Object) networkLogSnapshot.requestBody) && Intrinsics.areEqual((Object) this.responseHeaders, (Object) networkLogSnapshot.responseHeaders) && Intrinsics.areEqual((Object) this.response, (Object) networkLogSnapshot.response);
    }

    @Nullable
    public final String getRequestBody() {
        return this.requestBody;
    }

    @Nullable
    public final Map<String, Object> getRequestHeaders() {
        return this.requestHeaders;
    }

    @Nullable
    public final String getResponse() {
        return this.response;
    }

    @Nullable
    public final Map<String, Object> getResponseHeaders() {
        return this.responseHeaders;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Map<String, Object> map = this.requestHeaders;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.requestBody;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, Object> map2 = this.responseHeaders;
        int hashCode4 = (hashCode3 + (map2 == null ? 0 : map2.hashCode())) * 31;
        String str3 = this.response;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode4 + i11;
    }

    public final void setRequestBody(@Nullable String str) {
        this.requestBody = str;
    }

    public final void setRequestHeaders(@Nullable Map<String, Object> map) {
        this.requestHeaders = map;
    }

    public final void setResponse(@Nullable String str) {
        this.response = str;
    }

    public final void setResponseHeaders(@Nullable Map<String, Object> map) {
        this.responseHeaders = map;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    @NotNull
    public String toString() {
        return "NetworkLogSnapshot(url=" + this.url + ", requestHeaders=" + this.requestHeaders + ", requestBody=" + this.requestBody + ", responseHeaders=" + this.responseHeaders + ", response=" + this.response + ')';
    }
}
