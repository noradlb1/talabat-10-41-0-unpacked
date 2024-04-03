package com.facebook.internal;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.facebook.internal.InstallReferrerUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, d2 = {"com/facebook/internal/InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "onInstallReferrerServiceDisconnected", "", "onInstallReferrerSetupFinished", "responseCode", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1 implements InstallReferrerStateListener {
    final /* synthetic */ InstallReferrerUtil.Callback $callback;
    final /* synthetic */ InstallReferrerClient $referrerClient;

    public InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1(InstallReferrerClient installReferrerClient, InstallReferrerUtil.Callback callback) {
        this.$referrerClient = installReferrerClient;
        this.$callback = callback;
    }

    public void onInstallReferrerServiceDisconnected() {
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @com.facebook.internal.instrument.crashshield.AutoHandleExceptions
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onInstallReferrerSetupFinished(int r5) {
        /*
            r4 = this;
            r0 = 2
            if (r5 == 0) goto L_0x000c
            if (r5 == r0) goto L_0x0006
            goto L_0x0039
        L_0x0006:
            com.facebook.internal.InstallReferrerUtil r5 = com.facebook.internal.InstallReferrerUtil.INSTANCE
            r5.updateReferrer()
            goto L_0x0039
        L_0x000c:
            com.android.installreferrer.api.InstallReferrerClient r5 = r4.$referrerClient     // Catch:{ RemoteException -> 0x003e }
            com.android.installreferrer.api.ReferrerDetails r5 = r5.getInstallReferrer()     // Catch:{ RemoteException -> 0x003e }
            java.lang.String r1 = "{\n                      referrerClient.installReferrer\n                    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)     // Catch:{ RemoteException -> 0x003e }
            java.lang.String r5 = r5.getInstallReferrer()
            if (r5 == 0) goto L_0x0034
            java.lang.String r1 = "fb"
            r2 = 0
            r3 = 0
            boolean r1 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r1, (boolean) r2, (int) r0, (java.lang.Object) r3)
            if (r1 != 0) goto L_0x002f
            java.lang.String r1 = "facebook"
            boolean r0 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r1, (boolean) r2, (int) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0034
        L_0x002f:
            com.facebook.internal.InstallReferrerUtil$Callback r0 = r4.$callback
            r0.onReceiveReferrerUrl(r5)
        L_0x0034:
            com.facebook.internal.InstallReferrerUtil r5 = com.facebook.internal.InstallReferrerUtil.INSTANCE
            r5.updateReferrer()
        L_0x0039:
            com.android.installreferrer.api.InstallReferrerClient r5 = r4.$referrerClient     // Catch:{  }
            r5.endConnection()     // Catch:{  }
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1.onInstallReferrerSetupFinished(int):void");
    }
}
