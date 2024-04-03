package com.huawei.wisesecurity.ucs_credential;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.interceptors.ReqHeaderInterceptor;
import java.util.HashMap;
import java.util.Map;

public class i {
    public static Map<String, String> a(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(ReqHeaderInterceptor.APP_ID_TITLE, str);
        }
        hashMap.put(ReqHeaderInterceptor.CLIENT_VERSION_TITLE, "1.0.3.313");
        String str4 = Build.MODEL;
        hashMap.put(ReqHeaderInterceptor.TERMINAL_TYPE_TITLE, str4);
        hashMap.put("X-Request-ID", str3);
        hashMap.put("X-Credential-Terminal", "aucs");
        z zVar = new z();
        zVar.f44914a.put(ReqHeaderInterceptor.TERMINAL_TYPE_TITLE, str4);
        zVar.f44914a.put("appPkgName", str2);
        zVar.f44914a.put("callTime", String.valueOf(System.currentTimeMillis()));
        hashMap.put("X-RequestContext", zVar.toString());
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r7, com.huawei.wisesecurity.ucs_credential.k r8) throws com.huawei.wisesecurity.ucs.common.exception.UcsException {
        /*
            java.lang.String r8 = "ucscomponent.jws"
            r0 = 0
            java.lang.String r8 = com.huawei.wisesecurity.ucs.common.utils.SpUtil.getString(r8, r0, r7)
            r0 = 1009(0x3f1, double:4.985E-321)
            if (r8 == 0) goto L_0x007a
            java.io.File r2 = new java.io.File
            r2.<init>(r8)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L_0x007a
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "Start init data =  component through local file"
            java.lang.String r5 = "KeyComponentLocalHandler"
            com.huawei.wisesecurity.ucs.common.log.LogUcs.i(r5, r4, r3)
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0059 }
            r3.<init>(r8)     // Catch:{ IOException -> 0x0059 }
            java.lang.String r8 = "UTF-8"
            java.lang.String r8 = com.huawei.wisesecurity.ucs.common.utils.IOUtils.toString(r3, r8)     // Catch:{ all -> 0x004d }
            com.huawei.wisesecurity.ucs_credential.h r4 = new com.huawei.wisesecurity.ucs_credential.h     // Catch:{ all -> 0x004d }
            r4.<init>(r8)     // Catch:{ all -> 0x004d }
            com.huawei.wisesecurity.ucs_credential.a0.a((android.content.Context) r7, (com.huawei.wisesecurity.ucs_credential.h) r4)     // Catch:{ all -> 0x004d }
            com.huawei.wisesecurity.ucs_credential.h$b r8 = r4.f44875b     // Catch:{ all -> 0x004d }
            java.lang.String r8 = r8.f44881b     // Catch:{ all -> 0x004d }
            byte[] r8 = com.huawei.wisesecurity.ucs.common.utils.StringUtil.base64Decode(r8, r2)     // Catch:{ all -> 0x004d }
            r6 = 32
            com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib.ucsUpdateRootKey(r8, r6)     // Catch:{ all -> 0x004d }
            java.lang.String r8 = "Local-C1-Version"
            com.huawei.wisesecurity.ucs_credential.h$b r4 = r4.f44875b     // Catch:{ all -> 0x004d }
            int r4 = r4.f44880a     // Catch:{ all -> 0x004d }
            com.huawei.wisesecurity.ucs.common.utils.SpUtil.putInt(r8, r4, r7)     // Catch:{ all -> 0x004d }
            r3.close()     // Catch:{ IOException -> 0x0059 }
            return
        L_0x004d:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x004f }
        L_0x004f:
            r8 = move-exception
            r3.close()     // Catch:{ all -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r3 = move-exception
            r7.addSuppressed(r3)     // Catch:{ IOException -> 0x0059 }
        L_0x0058:
            throw r8     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r3 = "Init data failed, msg = "
            r8.append(r3)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.Object[] r8 = new java.lang.Object[r2]
            com.huawei.wisesecurity.ucs.common.log.LogUcs.e(r5, r7, r8)
            com.huawei.wisesecurity.ucs.common.exception.UcsException r8 = new com.huawei.wisesecurity.ucs.common.exception.UcsException
            r8.<init>(r0, r7)
            throw r8
        L_0x007a:
            com.huawei.wisesecurity.ucs.common.exception.UcsException r7 = new com.huawei.wisesecurity.ucs.common.exception.UcsException
            java.lang.String r8 = "Init component from local failed, file error"
            r7.<init>(r0, r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.ucs_credential.i.a(android.content.Context, com.huawei.wisesecurity.ucs_credential.k):void");
    }
}
