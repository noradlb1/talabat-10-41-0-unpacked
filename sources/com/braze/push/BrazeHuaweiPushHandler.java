package com.braze.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.braze.push.BrazePushReceiver;
import com.braze.support.BrazeLogger;
import com.braze.support.BundleUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¨\u0006\n"}, d2 = {"Lcom/braze/push/BrazeHuaweiPushHandler;", "", "()V", "handleHmsRemoteMessageData", "", "context", "Landroid/content/Context;", "hmsRemoteMessageData", "", "", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeHuaweiPushHandler {
    @NotNull
    public static final BrazeHuaweiPushHandler INSTANCE = new BrazeHuaweiPushHandler();

    private BrazeHuaweiPushHandler() {
    }

    public final boolean handleHmsRemoteMessageData(@NotNull Context context, @Nullable Map<String, String> map) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeHuaweiPushHandler$handleHmsRemoteMessageData$1(map), 6, (Object) null);
        if (map == null || map.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) BrazeHuaweiPushHandler$handleHmsRemoteMessageData$2.INSTANCE, 6, (Object) null);
            return false;
        }
        Bundle bundle = BundleUtils.toBundle(map);
        if (!bundle.containsKey("_ab") || !Intrinsics.areEqual((Object) "true", (Object) bundle.getString("_ab"))) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) BrazeHuaweiPushHandler$handleHmsRemoteMessageData$3.INSTANCE, 6, (Object) null);
            return false;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new BrazeHuaweiPushHandler$handleHmsRemoteMessageData$4(bundle), 6, (Object) null);
        Intent intent = new Intent(BrazePushReceiver.HMS_PUSH_SERVICE_ROUTING_ACTION);
        intent.putExtras(bundle);
        BrazePushReceiver.Companion.handleReceivedIntent$default(BrazePushReceiver.Companion, context, intent, false, 4, (Object) null);
        return true;
    }
}
