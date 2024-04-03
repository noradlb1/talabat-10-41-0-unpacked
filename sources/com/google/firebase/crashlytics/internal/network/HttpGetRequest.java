package com.google.firebase.crashlytics.internal.network;

import com.huawei.hms.framework.common.ContainerUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.bytebuddy.description.type.TypeDescription;

@Instrumented
public class HttpGetRequest {
    private static final int DEFAULT_TIMEOUT_MS = 10000;
    private static final String METHOD_GET = "GET";
    private static final int READ_BUFFER_SIZE = 8192;
    private final Map<String, String> headers = new HashMap();
    private final Map<String, String> queryParams;
    private final String url;

    public HttpGetRequest(String str, Map<String, String> map) {
        this.url = str;
        this.queryParams = map;
    }

    private String createParamsString(Map<String, String> map) throws UnsupportedEncodingException {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        Map.Entry next = it.next();
        sb2.append((String) next.getKey());
        sb2.append("=");
        if (next.getValue() != null) {
            str = URLEncoder.encode((String) next.getValue(), "UTF-8");
        } else {
            str = "";
        }
        sb2.append(str);
        while (it.hasNext()) {
            Map.Entry next2 = it.next();
            sb2.append(ContainerUtils.FIELD_DELIMITER);
            sb2.append((String) next2.getKey());
            sb2.append("=");
            if (next2.getValue() != null) {
                str2 = URLEncoder.encode((String) next2.getValue(), "UTF-8");
            } else {
                str2 = "";
            }
            sb2.append(str2);
        }
        return sb2.toString();
    }

    private String createUrlWithParams(String str, Map<String, String> map) throws UnsupportedEncodingException {
        String createParamsString = createParamsString(map);
        if (createParamsString.isEmpty()) {
            return str;
        }
        if (str.contains(TypeDescription.Generic.OfWildcardType.SYMBOL)) {
            if (!str.endsWith(ContainerUtils.FIELD_DELIMITER)) {
                createParamsString = ContainerUtils.FIELD_DELIMITER + createParamsString;
            }
            return str + createParamsString;
        }
        return str + TypeDescription.Generic.OfWildcardType.SYMBOL + createParamsString;
    }

    private String readStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        char[] cArr = new char[8192];
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                return sb2.toString();
            }
            sb2.append(cArr, 0, read);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.crashlytics.internal.network.HttpResponse execute() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = r5.url     // Catch:{ all -> 0x0088 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.queryParams     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = r5.createUrlWithParams(r1, r2)     // Catch:{ all -> 0x0088 }
            com.google.firebase.crashlytics.internal.Logger r2 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch:{ all -> 0x0088 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0088 }
            r3.<init>()     // Catch:{ all -> 0x0088 }
            java.lang.String r4 = "GET Request URL: "
            r3.append(r4)     // Catch:{ all -> 0x0088 }
            r3.append(r1)     // Catch:{ all -> 0x0088 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0088 }
            r2.v(r3)     // Catch:{ all -> 0x0088 }
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x0088 }
            r2.<init>(r1)     // Catch:{ all -> 0x0088 }
            java.net.URLConnection r1 = r2.openConnection()     // Catch:{ all -> 0x0088 }
            java.net.URLConnection r1 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r1)     // Catch:{ all -> 0x0088 }
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ all -> 0x0088 }
            r2 = 10000(0x2710, float:1.4013E-41)
            r1.setReadTimeout(r2)     // Catch:{ all -> 0x0086 }
            r1.setConnectTimeout(r2)     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ all -> 0x0086 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r5.headers     // Catch:{ all -> 0x0086 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0086 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0086 }
        L_0x0047:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0086 }
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0086 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0086 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x0086 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0086 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0086 }
            r1.addRequestProperty(r4, r3)     // Catch:{ all -> 0x0086 }
            goto L_0x0047
        L_0x0063:
            r1.connect()     // Catch:{ all -> 0x0086 }
            int r2 = r1.getResponseCode()     // Catch:{ all -> 0x0086 }
            java.io.InputStream r3 = r1.getInputStream()     // Catch:{ all -> 0x0086 }
            if (r3 == 0) goto L_0x0078
            java.lang.String r0 = r5.readStream(r3)     // Catch:{ all -> 0x0075 }
            goto L_0x0078
        L_0x0075:
            r2 = move-exception
            r0 = r3
            goto L_0x008a
        L_0x0078:
            if (r3 == 0) goto L_0x007d
            r3.close()
        L_0x007d:
            r1.disconnect()
            com.google.firebase.crashlytics.internal.network.HttpResponse r1 = new com.google.firebase.crashlytics.internal.network.HttpResponse
            r1.<init>(r2, r0)
            return r1
        L_0x0086:
            r2 = move-exception
            goto L_0x008a
        L_0x0088:
            r2 = move-exception
            r1 = r0
        L_0x008a:
            if (r0 == 0) goto L_0x008f
            r0.close()
        L_0x008f:
            if (r1 == 0) goto L_0x0094
            r1.disconnect()
        L_0x0094:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.network.HttpGetRequest.execute():com.google.firebase.crashlytics.internal.network.HttpResponse");
    }

    public HttpGetRequest header(String str, String str2) {
        this.headers.put(str, str2);
        return this;
    }

    public HttpGetRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }
}
