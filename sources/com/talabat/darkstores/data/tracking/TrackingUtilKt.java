package com.talabat.darkstores.data.tracking;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"toMapOfStrings", "", "", "Landroid/os/Bundle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TrackingUtilKt {
    @NotNull
    public static final Map<String, String> toMapOfStrings(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        HashMap hashMap = new HashMap(bundle.size());
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj != null) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                hashMap.put(next, obj.toString());
            }
        }
        return hashMap;
    }
}
