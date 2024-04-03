package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/facebook/CurrentAccessTokenExpirationBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CurrentAccessTokenExpirationBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        if (Intrinsics.areEqual((Object) AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED, (Object) intent.getAction()) && FacebookSdk.isInitialized()) {
            AccessTokenManager.Companion.getInstance().currentAccessTokenChanged();
        }
    }
}
