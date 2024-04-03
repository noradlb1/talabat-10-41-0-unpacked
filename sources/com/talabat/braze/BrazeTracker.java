package com.talabat.braze;

import android.content.Context;
import com.braze.Braze;
import com.braze.models.outgoing.BrazeProperties;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bJ\u001c\u0010\f\u001a\u00020\u0007*\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/braze/BrazeTracker;", "", "()V", "context", "Landroid/content/Context;", "initialize", "logCustomEvent", "", "eventName", "", "attributes", "", "addTypedProperty", "Lcom/braze/models/outgoing/BrazeProperties;", "key", "value", "com_talabat_ThirdPartyLibs_Braze_Braze"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeTracker {
    @NotNull
    public static final BrazeTracker INSTANCE = new BrazeTracker();
    private static Context context;

    private BrazeTracker() {
    }

    private final void addTypedProperty(BrazeProperties brazeProperties, String str, Object obj) {
        if (obj instanceof Long) {
            brazeProperties.addProperty(str, obj);
        } else if (obj instanceof Integer) {
            brazeProperties.addProperty(str, obj);
        } else if (obj instanceof Double) {
            brazeProperties.addProperty(str, obj);
        } else if (obj instanceof Boolean) {
            brazeProperties.addProperty(str, obj);
        } else if (obj instanceof Date) {
            brazeProperties.addProperty(str, obj);
        } else if (obj instanceof String) {
            brazeProperties.addProperty(str, obj);
        } else {
            brazeProperties.addProperty(str, obj.toString());
        }
    }

    @NotNull
    public final BrazeTracker initialize(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        context = context2;
        return this;
    }

    public final void logCustomEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        BrazeProperties brazeProperties = new BrazeProperties();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value != null) {
                INSTANCE.addTypedProperty(brazeProperties, (String) next.getKey(), value);
            }
        }
        Braze.Companion companion = Braze.Companion;
        Context context2 = context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        companion.getInstance(context2).logCustomEvent(str, brazeProperties);
    }
}
