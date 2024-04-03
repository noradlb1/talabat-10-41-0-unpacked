package com.huawei.wearengine.auth;

import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.wearengine.AuthManager;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.b;
import com.huawei.wearengine.c;
import com.huawei.wearengine.d;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.lang.ref.WeakReference;

@Instrumented
public class a implements c {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f35120d;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public volatile AuthManager f35121a = null;

    /* renamed from: b  reason: collision with root package name */
    private final Object f35122b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public IBinder.DeathRecipient f35123c = new C0013a();

    /* renamed from: com.huawei.wearengine.auth.a$a  reason: collision with other inner class name */
    public class C0013a implements IBinder.DeathRecipient {
        public C0013a() {
        }

        public void binderDied() {
            if (a.this.f35121a != null) {
                a.this.f35121a.asBinder().unlinkToDeath(a.this.f35123c, 0);
                AuthManager unused = a.this.f35121a = null;
            }
        }
    }

    private a() {
        d.g().a((d.b) new b(new WeakReference(this)));
    }

    public static a a() {
        if (f35120d == null) {
            synchronized (a.class) {
                if (f35120d == null) {
                    f35120d = new a();
                }
            }
        }
        return f35120d;
    }

    private Boolean[] a(boolean[] zArr) {
        if (zArr == null || zArr.length == 0) {
            return new Boolean[0];
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i11 = 0; i11 < zArr.length; i11++) {
            boolArr[i11] = Boolean.valueOf(zArr[i11]);
        }
        return boolArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [android.content.Intent] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int b(com.huawei.wearengine.auth.AuthListener r13, com.huawei.wearengine.auth.Permission[] r14) {
        /*
            r12 = this;
            java.lang.String r0 = "AuthServiceProxy"
            if (r14 == 0) goto L_0x00fd
            int r1 = r14.length
            if (r1 != 0) goto L_0x0009
            goto L_0x00fd
        L_0x0009:
            r1 = 12
            r12.b()     // Catch:{ IllegalStateException -> 0x00f7, RemoteException -> 0x00f1 }
            com.huawei.wearengine.AuthManager r2 = r12.f35121a     // Catch:{ IllegalStateException -> 0x00f7, RemoteException -> 0x00f1 }
            if (r2 == 0) goto L_0x00ea
            com.huawei.wearengine.AuthManager r2 = r12.f35121a     // Catch:{ IllegalStateException -> 0x00f7, RemoteException -> 0x00f1 }
            java.lang.String r13 = r2.preStartAuth(r13)     // Catch:{ IllegalStateException -> 0x00f7, RemoteException -> 0x00f1 }
            boolean r2 = android.text.TextUtils.isEmpty(r13)     // Catch:{ IllegalStateException -> 0x00f7, RemoteException -> 0x00f1 }
            if (r2 == 0) goto L_0x0024
            java.lang.String r13 = "startAuth targetJson is empty"
            com.huawei.wearengine.common.a.c(r0, r13)     // Catch:{ IllegalStateException -> 0x00f7, RemoteException -> 0x00f1 }
            return r1
        L_0x0024:
            android.content.Context r2 = com.huawei.wearengine.utils.b.a()
            r3 = 0
            r4 = 0
            java.lang.String r5 = "WearEngineAuthUtil"
            if (r2 != 0) goto L_0x0035
            java.lang.String r13 = "getAuthIntent appContext is null"
            com.huawei.wearengine.common.a.c(r5, r13)
            goto L_0x00de
        L_0x0035:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00d9 }
            r6.<init>((java.lang.String) r13)     // Catch:{ JSONException -> 0x00d9 }
            java.lang.String r7 = "target_package_name"
            boolean r7 = r6.has(r7)     // Catch:{ JSONException -> 0x00d9 }
            if (r7 == 0) goto L_0x00d3
            java.lang.String r7 = "target_activity_name"
            boolean r6 = r6.has(r7)     // Catch:{ JSONException -> 0x00d9 }
            if (r6 != 0) goto L_0x004c
            goto L_0x00d3
        L_0x004c:
            java.lang.String r6 = r2.getPackageName()
            android.content.Intent r7 = new android.content.Intent
            r7.<init>()
            r7.setPackage(r6)
            java.lang.Class<com.huawei.wearengine.ClientHubActivity> r8 = com.huawei.wearengine.ClientHubActivity.class
            r7.setClass(r2, r8)
            r8 = 268435456(0x10000000, float:2.5243549E-29)
            r7.setFlags(r8)
            java.util.HashSet r8 = new java.util.HashSet
            int r9 = r14.length
            r8.<init>(r9)
            int r9 = r14.length
            r10 = r3
        L_0x006a:
            if (r10 >= r9) goto L_0x0078
            r11 = r14[r10]
            java.lang.String r11 = r11.getName()
            r8.add(r11)
            int r10 = r10 + 1
            goto L_0x006a
        L_0x0078:
            java.lang.String[] r14 = new java.lang.String[r3]
            java.lang.Object[] r14 = r8.toArray(r14)
            java.lang.String[] r14 = (java.lang.String[]) r14
            org.json.JSONArray r8 = new org.json.JSONArray
            r8.<init>()
            int r9 = r14.length
            r10 = r3
        L_0x0087:
            if (r10 >= r9) goto L_0x0091
            r11 = r14[r10]
            r8.put((java.lang.Object) r11)
            int r10 = r10 + 1
            goto L_0x0087
        L_0x0091:
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            java.lang.String r11 = "package_name"
            r10.put((java.lang.String) r11, (java.lang.Object) r6)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r6 = "permissions"
            r10.put((java.lang.String) r6, (java.lang.Object) r8)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r6 = "request_type"
            java.lang.String r8 = "request_auth"
            r9.put((java.lang.String) r6, (java.lang.Object) r8)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r6 = "request_header"
            r14.put((java.lang.String) r6, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r6 = "request_body"
            r14.put((java.lang.String) r6, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x00c0 }
            java.lang.String r4 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r14)
            goto L_0x00c5
        L_0x00c0:
            java.lang.String r14 = "requestDataToJsonString JSONException"
            com.huawei.wearengine.common.a.a((java.lang.String) r5, (java.lang.String) r14)
        L_0x00c5:
            if (r4 == 0) goto L_0x00cc
            java.lang.String r14 = "start_request_json"
            r7.putExtra(r14, r4)
        L_0x00cc:
            java.lang.String r14 = "target_json"
            r7.putExtra(r14, r13)
            r4 = r7
            goto L_0x00de
        L_0x00d3:
            java.lang.String r13 = "getAuthIntent targetActivityJson is invalid"
            com.huawei.wearengine.common.a.c(r5, r13)     // Catch:{ JSONException -> 0x00d9 }
            goto L_0x00de
        L_0x00d9:
            java.lang.String r13 = "getAuthIntent JSONException"
            com.huawei.wearengine.common.a.a((java.lang.String) r5, (java.lang.String) r13)
        L_0x00de:
            if (r4 != 0) goto L_0x00e1
            return r1
        L_0x00e1:
            java.lang.String r13 = "startAuth: start ClientHubActivity"
            com.huawei.wearengine.common.a.b(r0, r13)
            r2.startActivity(r4)
            return r3
        L_0x00ea:
            java.lang.String r13 = "startAuth mAuthManager is null"
            com.huawei.wearengine.common.a.c(r0, r13)     // Catch:{ IllegalStateException -> 0x00f7, RemoteException -> 0x00f1 }
            r13 = 6
            return r13
        L_0x00f1:
            java.lang.String r13 = "requestPermission RemoteException"
            com.huawei.wearengine.common.a.a((java.lang.String) r0, (java.lang.String) r13)
            return r1
        L_0x00f7:
            r13 = move-exception
            com.huawei.wearengine.WearEngineException r13 = com.huawei.wearengine.WearEngineException.convertIllegalStateException(r13)
            throw r13
        L_0x00fd:
            java.lang.String r13 = "startAuth permissions is null or empty"
            com.huawei.wearengine.common.a.c(r0, r13)
            r13 = 5
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wearengine.auth.a.b(com.huawei.wearengine.auth.AuthListener, com.huawei.wearengine.auth.Permission[]):int");
    }

    private void b() {
        synchronized (this.f35122b) {
            if (this.f35121a == null) {
                d.g().b();
                IBinder a11 = d.g().a(5);
                if (a11 != null) {
                    this.f35121a = AuthManager.Stub.asInterface(a11);
                    this.f35121a.asBinder().linkToDeath(this.f35123c, 0);
                } else {
                    com.huawei.wearengine.common.a.c("AuthServiceProxy", "binder == null");
                    throw new WearEngineException(2);
                }
            }
        }
    }

    public int a(AuthListener authListener, Permission[] permissionArr) {
        try {
            b();
            if (com.huawei.wearengine.utils.a.a("auth_pre_start_auth")) {
                return b(authListener, permissionArr);
            }
            if (this.f35121a != null) {
                return this.f35121a.requestPermission(authListener, permissionArr);
            }
            return 6;
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            com.huawei.wearengine.common.a.a("AuthServiceProxy", "requestPermission RemoteException");
            return 12;
        }
    }

    public boolean a(Permission permission) {
        try {
            b();
            if (this.f35121a != null) {
                return this.f35121a.checkPermission(permission);
            }
            throw new WearEngineException(6);
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a("AuthServiceProxy", "checkPermission RemoteException", 12);
        }
    }

    public Boolean[] a(Permission[] permissionArr) {
        try {
            b();
            if (this.f35121a != null) {
                return a(this.f35121a.checkPermissions(permissionArr));
            }
            throw new WearEngineException(6);
        } catch (IllegalStateException e11) {
            throw WearEngineException.convertIllegalStateException(e11);
        } catch (RemoteException unused) {
            throw com.huawei.wearengine.a.a("AuthServiceProxy", "checkPermissions RemoteException", 12);
        }
    }

    public void clearBinderProxy() {
        this.f35121a = null;
    }
}
