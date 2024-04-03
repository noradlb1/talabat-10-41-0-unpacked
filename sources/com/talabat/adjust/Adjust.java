package com.talabat.adjust;

import android.content.Context;
import com.adjust.sdk.AdjustEvent;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eJ\u001c\u0010\u000f\u001a\u00020\u0006*\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/adjust/Adjust;", "", "()V", "context", "Landroid/content/Context;", "addSessionParameter", "", "key", "", "value", "initialize", "trackEvent", "eventName", "attributes", "", "addParameter", "Lcom/adjust/sdk/AdjustEvent;", "com_talabat_ThirdPartyLibs_Adjust_Adjust"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Adjust {
    @NotNull
    public static final Adjust INSTANCE = new Adjust();
    private static Context context;

    private Adjust() {
    }

    private final void addParameter(AdjustEvent adjustEvent, String str, String str2) {
        boolean z11;
        if (str2.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            adjustEvent.addCallbackParameter(str, str2);
            adjustEvent.addPartnerParameter(str, str2);
        }
    }

    public final void addSessionParameter(@NotNull String str, @NotNull String str2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        if (str2.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            com.adjust.sdk.Adjust.addSessionCallbackParameter(str, str2);
            com.adjust.sdk.Adjust.addSessionPartnerParameter(str, str2);
        }
    }

    @NotNull
    public final Adjust initialize(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        context = context2;
        return this;
    }

    public final void trackEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        AdjustEvent adjustEvent = new AdjustEvent(str);
        for (Map.Entry next : map.entrySet()) {
            INSTANCE.addParameter(adjustEvent, (String) next.getKey(), String.valueOf(next.getValue()));
        }
        com.adjust.sdk.Adjust.trackEvent(adjustEvent);
    }
}
