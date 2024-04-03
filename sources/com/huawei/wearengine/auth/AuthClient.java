package com.huawei.wearengine.auth;

import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.wearengine.WearEngineException;
import com.huawei.wearengine.auth.AuthListener;
import java.util.concurrent.Callable;

public class AuthClient {

    /* renamed from: b  reason: collision with root package name */
    private static volatile AuthClient f35108b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f35109a = a.a();

    public class a implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AuthCallback f35112b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Permission[] f35113c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AuthListener f35114d;

        public a(AuthCallback authCallback, Permission[] permissionArr, AuthListener authListener) {
            this.f35112b = authCallback;
            this.f35113c = permissionArr;
            this.f35114d = authListener;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f35112b, (Object) "AuthCallback can not be null!");
            com.huawei.wearengine.common.a.a(this.f35113c, (Object) "Permissions can not be null!");
            int a11 = AuthClient.this.f35109a.a(this.f35114d, this.f35113c);
            if (a11 == 0) {
                return null;
            }
            throw new WearEngineException(a11);
        }
    }

    public class b implements Callable<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Permission f35116b;

        public b(Permission permission) {
            this.f35116b = permission;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f35116b, (Object) "Permission can not be null!");
            return Boolean.valueOf(AuthClient.this.f35109a.a(this.f35116b));
        }
    }

    public class c implements Callable<Boolean[]> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Permission[] f35118b;

        public c(Permission[] permissionArr) {
            this.f35118b = permissionArr;
        }

        public Object call() {
            com.huawei.wearengine.common.a.a(this.f35118b, (Object) "Permissions can not be null!");
            if (this.f35118b.length <= 3) {
                return AuthClient.this.f35109a.a(this.f35118b);
            }
            throw new WearEngineException(5);
        }
    }

    private AuthClient() {
    }

    public static AuthClient getInstance() {
        if (f35108b == null) {
            synchronized (AuthClient.class) {
                if (f35108b == null) {
                    f35108b = new AuthClient();
                }
            }
        }
        return f35108b;
    }

    public Task<Boolean> checkPermission(Permission permission) {
        return Tasks.callInBackground(new b(permission));
    }

    public Task<Boolean[]> checkPermissions(Permission[] permissionArr) {
        return Tasks.callInBackground(new c(permissionArr));
    }

    public Task<Void> requestPermission(final AuthCallback authCallback, Permission... permissionArr) {
        return Tasks.callInBackground(new a(authCallback, permissionArr, new AuthListener.Stub() {
            public void onCancel() {
                authCallback.onCancel();
            }

            public void onOk(Permission[] permissionArr) {
                authCallback.onOk(permissionArr);
            }
        }));
    }
}
