package com.huawei.wearengine;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.wearengine.IdentityStoreCallback;
import com.huawei.wearengine.common.Constants;
import com.huawei.wearengine.common.a;
import com.huawei.wearengine.utils.b;

class WearEngineClientInner$3 extends IdentityStoreCallback.Stub {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f35106b;

    public WearEngineClientInner$3(d dVar) {
        this.f35106b = dVar;
    }

    public void storePermissionIdentity(String str) {
        if (TextUtils.isEmpty(str)) {
            a.c("WearEngineClientInner", "storePermissionIdentity permissionIdentity isEmpty");
            return;
        }
        Context a11 = b.a();
        if (a11 != null && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = a11.getSharedPreferences(Constants.WEAR_ENGINE_PERMISSION_IDENTITY_STORE, 0).edit();
            edit.putString(Constants.WEAR_ENGINE_PERMISSION_IDENTITY, str);
            edit.commit();
        }
    }
}
