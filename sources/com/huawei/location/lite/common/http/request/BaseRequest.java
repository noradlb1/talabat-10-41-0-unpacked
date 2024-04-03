package com.huawei.location.lite.common.http.request;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.HttpUtils;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.description.type.TypeDescription;

public class BaseRequest {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    private String baseUrl;
    private final byte[] body;
    private final String contentType;
    private final HeadBuilder heads;
    private final String method;
    private String path;
    private SortedMap<String, String> queryMap;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String baseUrl;
        /* access modifiers changed from: private */
        public byte[] body;
        /* access modifiers changed from: private */
        public String contentType;
        /* access modifiers changed from: private */
        public HeadBuilder heads;
        /* access modifiers changed from: private */
        public String method = "POST";
        /* access modifiers changed from: private */
        public String path;
        /* access modifiers changed from: private */
        public SortedMap<String, String> queryMap;

        public Builder(String str) {
            this.path = str;
        }

        public Builder addAllQuery(SortedMap<String, String> sortedMap) {
            if (sortedMap == null) {
                return this;
            }
            if (this.queryMap == null) {
                this.queryMap = new TreeMap();
            }
            this.queryMap.putAll(sortedMap);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            if (this.heads == null) {
                this.heads = new HeadBuilder();
            }
            this.heads.add(str, str2);
            return this;
        }

        public Builder addHeaders(HashMap<String, String> hashMap) {
            if (this.heads == null) {
                this.heads = new HeadBuilder();
            }
            if (hashMap != null) {
                this.heads.addAll(hashMap);
            }
            return this;
        }

        public Builder addQuery(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.queryMap == null) {
                    this.queryMap = new TreeMap();
                }
                this.queryMap.put(str, str2);
            }
            return this;
        }

        public BaseRequest build() {
            if (TextUtils.isEmpty(this.baseUrl)) {
                this.baseUrl = LocationNlpGrsHelper.getGrsHostAddress("com.huawei.hms.location");
            }
            return new BaseRequest(this);
        }

        public Builder removeHeader(String str) {
            HeadBuilder headBuilder = this.heads;
            if (headBuilder == null) {
                return this;
            }
            headBuilder.remove(str);
            return this;
        }

        public Builder setBaseUrl(String str) {
            this.baseUrl = str;
            return this;
        }

        public Builder setBody(RequestJsonBody requestJsonBody) {
            this.body = requestJsonBody.getBody().getBytes();
            this.contentType = requestJsonBody.contentType();
            return this;
        }

        public Builder setBody(RequestsStreamBody requestsStreamBody) {
            this.body = requestsStreamBody.getBody();
            this.contentType = requestsStreamBody.contentType();
            return this;
        }

        public Builder setBody(byte[] bArr, String str) {
            this.body = bArr;
            this.contentType = str;
            return this;
        }

        public Builder setHeads(HeadBuilder headBuilder) {
            this.heads = headBuilder;
            return this;
        }

        public Builder setMethod(String str) {
            this.method = str;
            return this;
        }
    }

    public BaseRequest(Builder builder) {
        this.baseUrl = builder.baseUrl;
        this.heads = builder.heads;
        this.body = builder.body;
        this.method = builder.method;
        this.contentType = builder.contentType;
        this.path = builder.path;
        this.queryMap = builder.queryMap;
        parsePathQuery();
    }

    private void parsePathQuery() {
        if (this.path.contains(TypeDescription.Generic.OfWildcardType.SYMBOL)) {
            if (this.queryMap == null) {
                this.queryMap = new TreeMap();
            }
            try {
                URI create = URI.create(HttpUtils.urlDecode(this.baseUrl + this.path));
                String query = create.getQuery();
                if (query != null) {
                    this.baseUrl = create.getScheme() + "://" + create.getHost();
                    this.path = create.getPath();
                    String[] split = query.split(ContainerUtils.FIELD_DELIMITER);
                    int length = split.length;
                    for (int i11 = 0; i11 < length; i11++) {
                        String[] split2 = split[i11].split("=");
                        if (split2.length == 2) {
                            this.queryMap.put(split2[0], split2[1]);
                        }
                    }
                }
            } catch (IllegalArgumentException unused) {
                LogConsole.e("BaseRequest", "parse query failed");
            }
        }
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public byte[] getBody() {
        return this.body;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFullUrl() {
        Uri.Builder buildUpon = Uri.parse(this.baseUrl).buildUpon();
        if (!TextUtils.isEmpty(this.path)) {
            buildUpon.path(this.path);
        }
        SortedMap<String, String> sortedMap = this.queryMap;
        if (sortedMap != null) {
            for (Map.Entry next : sortedMap.entrySet()) {
                buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
            }
        }
        return HttpUtils.urlDecode(buildUpon.build().toString());
    }

    public HeadBuilder getHeads() {
        return this.heads;
    }

    public String getMethod() {
        return this.method;
    }

    public String getPath() {
        return this.path;
    }

    public SortedMap<String, String> getQueryMap() {
        return this.queryMap;
    }

    public String getQueryString() {
        if (this.queryMap == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : this.queryMap.entrySet()) {
            if (sb2.length() > 0) {
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb2.append((String) next.getKey());
            sb2.append("=");
            sb2.append((String) next.getValue());
        }
        return sb2.toString();
    }

    public Builder newBuilder() {
        return new Builder(this.path).setBaseUrl(this.baseUrl).setBody(this.body, this.contentType).setHeads(this.heads).setMethod(this.method).addAllQuery(this.queryMap);
    }

    public String toString() {
        return "BaseRequest{method='" + this.method + '\'' + ", baseUrl='" + this.baseUrl + '\'' + ", path='" + this.path + '\'' + ", heads=" + this.heads + ", contentType='" + this.contentType + '\'' + ", body=" + Arrays.toString(this.body) + AbstractJsonLexerKt.END_OBJ;
    }
}
