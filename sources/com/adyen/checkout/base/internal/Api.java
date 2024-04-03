package com.adyen.checkout.base.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.Map;

public abstract class Api {
    private static final int BUFFER_SIZE = 1024;
    @NonNull
    public static final Charset CHARSET = Charset.forName("UTF-8");
    private BaseHttpUrlConnectionFactory mHttpUrlConnectionFactory = new HttpUrlConnectionFactory();

    public enum HttpMethod {
        GET("GET", false),
        POST("POST", true);
        
        private boolean mDoOutput;
        private String mValue;

        private HttpMethod(@NonNull String str, boolean z11) {
            this.mValue = str;
            this.mDoOutput = z11;
        }

        /* access modifiers changed from: private */
        @NonNull
        public String getValue() {
            return this.mValue;
        }

        /* access modifiers changed from: private */
        public boolean isDoOutput() {
            return this.mDoOutput;
        }
    }

    @Nullable
    private byte[] getBytes(@Nullable InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @NonNull
    private HttpURLConnection getUrlConnection(@NonNull String str, @NonNull Map<String, String> map, @NonNull HttpMethod httpMethod) throws IOException {
        HttpURLConnection a11 = this.mHttpUrlConnectionFactory.a(str);
        a11.setRequestMethod(httpMethod.getValue());
        a11.setUseCaches(false);
        a11.setDoInput(true);
        a11.setDoOutput(httpMethod.isDoOutput());
        for (Map.Entry next : map.entrySet()) {
            a11.addRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        return a11;
    }

    @NonNull
    private byte[] handleResponse(@Nullable InputStream inputStream, @Nullable InputStream inputStream2) throws IOException {
        byte[] bytes = getBytes(inputStream);
        if (bytes != null) {
            return bytes;
        }
        throw b(getBytes(inputStream2));
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.NonNull java.util.Map<java.lang.String, java.lang.String> r4) throws java.io.IOException {
        /*
            r2 = this;
            r0 = 0
            com.adyen.checkout.base.internal.Api$HttpMethod r1 = com.adyen.checkout.base.internal.Api.HttpMethod.GET     // Catch:{ all -> 0x001f }
            java.net.HttpURLConnection r3 = r2.getUrlConnection(r3, r4, r1)     // Catch:{ all -> 0x001f }
            r3.connect()     // Catch:{ all -> 0x001c }
            java.io.InputStream r4 = r3.getErrorStream()     // Catch:{ all -> 0x001c }
            if (r4 != 0) goto L_0x0014
            java.io.InputStream r0 = r3.getInputStream()     // Catch:{ all -> 0x001c }
        L_0x0014:
            byte[] r4 = r2.handleResponse(r0, r4)     // Catch:{ all -> 0x001c }
            r3.disconnect()
            return r4
        L_0x001c:
            r4 = move-exception
            r0 = r3
            goto L_0x0020
        L_0x001f:
            r4 = move-exception
        L_0x0020:
            if (r0 == 0) goto L_0x0025
            r0.disconnect()
        L_0x0025:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.base.internal.Api.a(java.lang.String, java.util.Map):byte[]");
    }

    @NonNull
    public IOException b(@Nullable byte[] bArr) {
        String str;
        if (bArr != null) {
            str = new String(bArr, CHARSET);
        } else {
            str = null;
        }
        return new IOException(str);
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] c(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.NonNull java.util.Map<java.lang.String, java.lang.String> r4, @androidx.annotation.NonNull byte[] r5) throws java.io.IOException {
        /*
            r2 = this;
            r0 = 0
            com.adyen.checkout.base.internal.Api$HttpMethod r1 = com.adyen.checkout.base.internal.Api.HttpMethod.POST     // Catch:{ all -> 0x002c }
            java.net.HttpURLConnection r3 = r2.getUrlConnection(r3, r4, r1)     // Catch:{ all -> 0x002c }
            r3.connect()     // Catch:{ all -> 0x0029 }
            java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ all -> 0x0029 }
            r4.write(r5)     // Catch:{ all -> 0x0029 }
            r4.flush()     // Catch:{ all -> 0x0029 }
            r4.close()     // Catch:{ all -> 0x0029 }
            java.io.InputStream r4 = r3.getErrorStream()     // Catch:{ all -> 0x0029 }
            if (r4 != 0) goto L_0x0021
            java.io.InputStream r0 = r3.getInputStream()     // Catch:{ all -> 0x0029 }
        L_0x0021:
            byte[] r4 = r2.handleResponse(r0, r4)     // Catch:{ all -> 0x0029 }
            r3.disconnect()
            return r4
        L_0x0029:
            r4 = move-exception
            r0 = r3
            goto L_0x002d
        L_0x002c:
            r4 = move-exception
        L_0x002d:
            if (r0 == 0) goto L_0x0032
            r0.disconnect()
        L_0x0032:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.base.internal.Api.c(java.lang.String, java.util.Map, byte[]):byte[]");
    }
}
