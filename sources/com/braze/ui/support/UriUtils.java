package com.braze.ui.support;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.support.BrazeLogger;
import com.braze.ui.BrazeDeeplinkHandler;
import com.newrelic.agent.android.agentdata.HexAttribute;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001\u001a\u0016\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\f*\u00020\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG", "", "getMainActivityIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "extras", "Landroid/os/Bundle;", "isActivityRegisteredInManifest", "", "className", "getQueryParameters", "", "Landroid/net/Uri;", "android-sdk-ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "UriUtils")
public final class UriUtils {
    @NotNull
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("UriUtils");

    @Nullable
    public static final Intent getMainActivityIntent(@NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_UTILS_GET_MAIN_ACTIVITY_INTENT));
        }
        if (!(bundle == null || launchIntentForPackage == null)) {
            launchIntentForPackage.putExtras(bundle);
        }
        return launchIntentForPackage;
    }

    public static /* synthetic */ Intent getMainActivityIntent$default(Context context, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bundle = null;
        }
        return getMainActivityIntent(context, bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ad A[Catch:{ Exception -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008b A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Map<java.lang.String, java.lang.String> getQueryParameters(@org.jetbrains.annotations.NotNull android.net.Uri r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r0.element = r10
            java.lang.String r10 = r10.getEncodedQuery()
            if (r10 != 0) goto L_0x002a
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r2 = TAG
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.V
            r4 = 0
            r5 = 0
            com.braze.ui.support.UriUtils$getQueryParameters$1 r6 = new com.braze.ui.support.UriUtils$getQueryParameters$1
            r6.<init>(r0)
            r7 = 12
            r8 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.String) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (boolean) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
            java.util.Map r10 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            return r10
        L_0x002a:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            T r2 = r0.element     // Catch:{ Exception -> 0x00b6 }
            android.net.Uri r2 = (android.net.Uri) r2     // Catch:{ Exception -> 0x00b6 }
            boolean r2 = r2.isOpaque()     // Catch:{ Exception -> 0x00b6 }
            if (r2 == 0) goto L_0x0052
            java.lang.String r2 = "://"
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x00b6 }
            android.net.Uri$Builder r2 = r2.buildUpon()     // Catch:{ Exception -> 0x00b6 }
            android.net.Uri$Builder r10 = r2.encodedQuery(r10)     // Catch:{ Exception -> 0x00b6 }
            android.net.Uri r10 = r10.build()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r2 = "parse(\"://\")\n           …\n                .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)     // Catch:{ Exception -> 0x00b6 }
            r0.element = r10     // Catch:{ Exception -> 0x00b6 }
        L_0x0052:
            T r10 = r0.element     // Catch:{ Exception -> 0x00b6 }
            android.net.Uri r10 = (android.net.Uri) r10     // Catch:{ Exception -> 0x00b6 }
            java.util.Set r10 = r10.getQueryParameterNames()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r2 = "uri.queryParameterNames"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r2)     // Catch:{ Exception -> 0x00b6 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b6 }
            r2.<init>()     // Catch:{ Exception -> 0x00b6 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x00b6 }
        L_0x0068:
            boolean r3 = r10.hasNext()     // Catch:{ Exception -> 0x00b6 }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0087
            java.lang.Object r3 = r10.next()     // Catch:{ Exception -> 0x00b6 }
            r6 = r3
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x00b6 }
            if (r6 == 0) goto L_0x007f
            int r6 = r6.length()     // Catch:{ Exception -> 0x00b6 }
            if (r6 != 0) goto L_0x0080
        L_0x007f:
            r4 = r5
        L_0x0080:
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x0068
            r2.add(r3)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x0068
        L_0x0087:
            java.util.Iterator r10 = r2.iterator()     // Catch:{ Exception -> 0x00b6 }
        L_0x008b:
            boolean r2 = r10.hasNext()     // Catch:{ Exception -> 0x00b6 }
            if (r2 == 0) goto L_0x00ca
            java.lang.Object r2 = r10.next()     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00b6 }
            T r3 = r0.element     // Catch:{ Exception -> 0x00b6 }
            android.net.Uri r3 = (android.net.Uri) r3     // Catch:{ Exception -> 0x00b6 }
            java.lang.String r3 = r3.getQueryParameter(r2)     // Catch:{ Exception -> 0x00b6 }
            if (r3 == 0) goto L_0x00aa
            int r6 = r3.length()     // Catch:{ Exception -> 0x00b6 }
            if (r6 != 0) goto L_0x00a8
            goto L_0x00aa
        L_0x00a8:
            r6 = r4
            goto L_0x00ab
        L_0x00aa:
            r6 = r5
        L_0x00ab:
            if (r6 != 0) goto L_0x008b
            java.lang.String r6 = "queryParameterKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)     // Catch:{ Exception -> 0x00b6 }
            r1.put(r2, r3)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x008b
        L_0x00b6:
            r10 = move-exception
            r5 = r10
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r3 = TAG
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            r6 = 0
            com.braze.ui.support.UriUtils$getQueryParameters$2 r7 = new com.braze.ui.support.UriUtils$getQueryParameters$2
            r7.<init>(r0)
            r8 = 8
            r9 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.String) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (boolean) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
        L_0x00ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.ui.support.UriUtils.getQueryParameters(android.net.Uri):java.util.Map");
    }

    public static final boolean isActivityRegisteredInManifest(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.getPackageManager().getActivityInfo(new ComponentName(context, str), PackageManager.ComponentInfoFlags.of(0));
            } else {
                context.getPackageManager().getActivityInfo(new ComponentName(context, str), 0);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new UriUtils$isActivityRegisteredInManifest$1(str), 8, (Object) null);
            return false;
        }
    }
}
