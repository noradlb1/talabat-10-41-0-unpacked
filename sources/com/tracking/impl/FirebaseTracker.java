package com.tracking.impl;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tracking.Tracker;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.TalabatFirebase;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/tracking/impl/FirebaseTracker;", "Lcom/tracking/Tracker;", "()V", "mapToBundle", "Landroid/os/Bundle;", "params", "", "", "", "sendEvent", "", "eventName", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FirebaseTracker implements Tracker {
    private final Bundle mapToBundle(Map<String, ? extends Object> map) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof Integer) {
                bundle.putInt((String) next.getKey(), ((Integer) next.getValue()).intValue());
            } else if (value instanceof Float) {
                bundle.putFloat((String) next.getKey(), ((Float) next.getValue()).floatValue());
            } else if (value instanceof Boolean) {
                bundle.putBoolean((String) next.getKey(), ((Boolean) next.getValue()).booleanValue());
            } else if (value instanceof String) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            } else {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            arrayList.add(Unit.INSTANCE);
        }
        return bundle;
    }

    @NotNull
    public Map<String, Object> createParameters(@NotNull String str, @NotNull String str2) {
        return Tracker.DefaultImpls.createParameters(this, str, str2);
    }

    public void sendEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        TalabatFirebase.Companion.dispatchEvent$default(TalabatFirebase.Companion, (Context) null, str, mapToBundle(map), 1, (Object) null);
    }
}
