package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public NetworkCapability f44882a;

    /* renamed from: b  reason: collision with root package name */
    public Context f44883b;

    /* renamed from: c  reason: collision with root package name */
    public l f44884c;

    public j(Context context, l lVar, NetworkCapability networkCapability) {
        this.f44883b = context;
        this.f44882a = networkCapability;
        this.f44884c = lVar;
    }

    public synchronized void a(boolean z11, k kVar) throws UcsException {
        LogUcs.i("KeyComponentManger", "start download C1 file from Service", new Object[0]);
        try {
            Map hashMap = new HashMap();
            if (!z11) {
                hashMap = kVar.a(this.f44883b);
            }
            String a11 = this.f44884c.a("ucscomponent", "ucscomponent.jws");
            LogUcs.i("KeyComponentManger", "updateFileFromCDN domain is {0}", a11);
            a(this.f44882a.get(new NetworkRequest(a11, hashMap)), kVar);
            LogUcs.i("KeyComponentManger", "updateFileFromCDN OK", new Object[0]);
        } catch (IOException e11) {
            String str = "Update file data get IOException，exception: " + e11.getMessage();
            LogUcs.e("KeyComponentManger", str, new Object[0]);
            throw new UcsException(UcsErrorCode.DOWNLOAD_KEY_COMPONENT_ERROR, str);
        }
    }

    public void a() throws UcsException {
        k kVar = new k();
        if (kVar.b(this.f44883b)) {
            a(false, kVar);
            return;
        }
        try {
            i.a(this.f44883b, kVar);
        } catch (UcsException e11) {
            LogUcs.w("KeyComponentManger", "Init using local file failed, code = {0}, msg = {1}", Long.valueOf(e11.getErrorCode()), e11.getMessage());
            LogUcs.i("KeyComponentManger", "Try update data = componnet from server", new Object[0]);
            a(true, kVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x010f, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0118, code lost:
        throw r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse r9, com.huawei.wisesecurity.ucs_credential.k r10) throws com.huawei.wisesecurity.ucs.common.exception.UcsException {
        /*
            r8 = this;
            boolean r0 = r9.isSuccessful()
            r1 = 0
            if (r0 == 0) goto L_0x0151
            android.content.Context r0 = r8.f44883b
            java.util.Map r2 = r9.getHeaders()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Update local meta data : "
            r3.append(r4)
            java.lang.String r4 = "ucscomponent"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r6 = "LocalCDNFile"
            com.huawei.wisesecurity.ucs.common.log.LogUcs.d(r6, r3, r5)
            java.lang.String r3 = "etag"
            boolean r5 = r2.containsKey(r3)
            if (r5 == 0) goto L_0x0065
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Update local meta data -etag: "
            r5.append(r7)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.huawei.wisesecurity.ucs.common.log.LogUcs.d(r6, r5, r7)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "ETag_"
            r5.append(r7)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.Object r3 = r2.get(r3)
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r3.get(r1)
            java.lang.String r3 = (java.lang.String) r3
            com.huawei.wisesecurity.ucs.common.utils.SpUtil.putString(r5, r3, r0)
        L_0x0065:
            java.lang.String r3 = "last-modified"
            boolean r5 = r2.containsKey(r3)
            if (r5 == 0) goto L_0x00a3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Update local meta data -last-modified: "
            r5.append(r7)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.huawei.wisesecurity.ucs.common.log.LogUcs.d(r6, r5, r7)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Last-Modified_"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.Object r2 = r2.get(r3)
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r2 = r2.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            com.huawei.wisesecurity.ucs.common.utils.SpUtil.putString(r4, r2, r0)
        L_0x00a3:
            java.lang.String r0 = r10.a()
            long r2 = java.lang.System.currentTimeMillis()
            android.content.Context r4 = r8.f44883b
            com.huawei.wisesecurity.ucs.common.utils.SpUtil.putLong(r0, r2, r4)
            android.content.Context r0 = r8.f44883b
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            java.lang.String r4 = "ucscomponent.jws"
            if (r2 < r3) goto L_0x00d0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r0 = r0.createDeviceProtectedStorageContext()
            java.io.File r0 = r0.getFilesDir()
            r2.append(r0)
            java.lang.String r0 = "/"
            r2.append(r0)
            goto L_0x00e0
        L_0x00d0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r0 = r0.getApplicationContext()
            java.io.File r0 = r0.getFilesDir()
            r2.append(r0)
        L_0x00e0:
            r2.append(r4)
            java.lang.String r0 = r2.toString()
            android.content.Context r2 = r8.f44883b
            com.huawei.wisesecurity.ucs.common.utils.SpUtil.putString(r4, r0, r2)
            java.lang.String r9 = r9.getBody()
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0119 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0119 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0119 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0119 }
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x010d }
            byte[] r9 = r9.getBytes(r0)     // Catch:{ all -> 0x010d }
            r2.write(r9)     // Catch:{ all -> 0x010d }
            r2.close()     // Catch:{ IOException -> 0x0119 }
            android.content.Context r9 = r8.f44883b
            com.huawei.wisesecurity.ucs_credential.i.a(r9, r10)
            goto L_0x0187
        L_0x010d:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x010f }
        L_0x010f:
            r10 = move-exception
            r2.close()     // Catch:{ all -> 0x0114 }
            goto L_0x0118
        L_0x0114:
            r0 = move-exception
            r9.addSuppressed(r0)     // Catch:{ IOException -> 0x0119 }
        L_0x0118:
            throw r10     // Catch:{ IOException -> 0x0119 }
        L_0x0119:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Write file data failed : "
            r10.append(r0)
            java.lang.String r2 = r9.getMessage()
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "KeyComponentLocalHandler"
            com.huawei.wisesecurity.ucs.common.log.LogUcs.e(r2, r10, r1)
            com.huawei.wisesecurity.ucs.common.exception.UcsException r10 = new com.huawei.wisesecurity.ucs.common.exception.UcsException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r9 = r9.getMessage()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0 = 1011(0x3f3, double:4.995E-321)
            r10.<init>(r0, r9)
            throw r10
        L_0x0151:
            int r0 = r9.getCode()
            r2 = 304(0x130, float:4.26E-43)
            java.lang.String r3 = "KeyComponentManger"
            if (r0 != r2) goto L_0x0175
            java.lang.Object[] r9 = new java.lang.Object[r1]
            java.lang.String r0 = "file data has not modified!"
            com.huawei.wisesecurity.ucs.common.log.LogUcs.i(r3, r0, r9)
            java.lang.String r9 = r10.a()
            long r0 = java.lang.System.currentTimeMillis()
            android.content.Context r2 = r8.f44883b
            com.huawei.wisesecurity.ucs.common.utils.SpUtil.putLong(r9, r0, r2)
            android.content.Context r9 = r8.f44883b
            com.huawei.wisesecurity.ucs_credential.i.a(r9, r10)
            goto L_0x0187
        L_0x0175:
            r10 = 1
            java.lang.Object[] r10 = new java.lang.Object[r10]
            int r9 = r9.getCode()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r10[r1] = r9
            java.lang.String r9 = "file data update failed And statusCode = {0}"
            com.huawei.wisesecurity.ucs.common.log.LogUcs.i(r3, r9, r10)
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.ucs_credential.j.a(com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse, com.huawei.wisesecurity.ucs_credential.k):void");
    }
}
