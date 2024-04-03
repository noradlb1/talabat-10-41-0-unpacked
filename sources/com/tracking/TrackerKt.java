package com.tracking;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u0007"}, d2 = {"addParameter", "", "", "", "", "key", "value", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TrackerKt {
    @NotNull
    public static final Map<String, Object> addParameter(@NotNull Map<String, Object> map, @NotNull String str, @NotNull String str2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        boolean z12 = true;
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            if (str2.length() != 0) {
                z12 = false;
            }
            if (!z12) {
                map.put(str, str2);
            }
        }
        return map;
    }
}
