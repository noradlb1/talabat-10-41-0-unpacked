package com.instabug.library.diagnostics.sdkEvents;

import android.content.SharedPreferences;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.diagnostics.configuration.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a {
    private final com.instabug.library.diagnostics.sdkEvents.configurations.a a() {
        return com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.c();
    }

    private final f b() {
        return com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.j();
    }

    private final SharedPreferences c() {
        return com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.b();
    }

    private final List b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        if (!(jSONArray != null && jSONArray.length() > 0)) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        Intrinsics.checkNotNull(jSONArray);
        int length = jSONArray.length();
        while (i11 < length) {
            int i12 = i11 + 1;
            String string = jSONArray.getString(i11);
            Intrinsics.checkNotNullExpressionValue(string, "allowListArray.getString(i)");
            arrayList.add(string);
            i11 = i12;
        }
        return arrayList;
    }

    public void a(@Nullable JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("sdk_events")) != null) {
            a(optJSONObject.optDouble("enabled"));
            a(optJSONObject.optJSONArray("allow_list"));
        }
    }

    private final void a(double d11) {
        boolean isEnabled = a().isEnabled();
        com.instabug.library.percentagefeatures.a.a("SDK_EVENTS", d11);
        a(isEnabled);
    }

    private final void a(boolean z11) {
        if (z11 != a().isEnabled()) {
            SDKCoreEventPublisher.post(new SDKCoreEvent("features", SDKCoreEvent.Feature.VALUE_UPDATED));
        }
    }

    private final void a(JSONArray jSONArray) {
        Set a11 = a().a();
        a(b(jSONArray));
        a(a11);
    }

    private final Unit a(List list) {
        Unit unit;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        SharedPreferences c11;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor putStringSet;
        if (list == null || (c11 = c()) == null || (edit2 = c11.edit()) == null || (putStringSet = edit2.putStringSet("allow_list", CollectionsKt___CollectionsKt.toSet(list))) == null) {
            unit = null;
        } else {
            putStringSet.apply();
            unit = Unit.INSTANCE;
        }
        if (unit != null) {
            return unit;
        }
        SharedPreferences c12 = c();
        if (c12 == null || (edit = c12.edit()) == null || (remove = edit.remove("allow_list")) == null) {
            return null;
        }
        remove.apply();
        return Unit.INSTANCE;
    }

    private final Unit a(Set set) {
        Set a11 = a().a();
        if (!(a11 == null || a11.isEmpty()) || Intrinsics.areEqual((Object) a11, (Object) set)) {
            List a12 = a(set, a11);
            if (a12 == null) {
                return null;
            }
            b().a((Collection) a12);
            return Unit.INSTANCE;
        }
        b().clearCache();
        return Unit.INSTANCE;
    }

    private final List a(Set set, Set set2) {
        ArrayList arrayList;
        if (set2 == null) {
            return null;
        }
        if (set == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object next : set) {
                if (!set2.contains((String) next)) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList != null && (!arrayList.isEmpty())) {
            return arrayList;
        }
        return null;
    }
}
