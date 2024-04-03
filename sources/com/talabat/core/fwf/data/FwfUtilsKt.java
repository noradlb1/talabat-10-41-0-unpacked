package com.talabat.core.fwf.data;

import kotlin.Metadata;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"hash", "", "", "com_talabat_core_fwf_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FwfUtilsKt {
    public static final int hash(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        char c11 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            int charAt = (c11 + str.charAt(i11)) & 536870911;
            char c12 = (charAt + ((524287 & charAt) << 10)) & CharCompanionObject.MAX_VALUE;
            c11 = c12 ^ (c12 >> 6);
        }
        int i12 = (c11 + ((65535 & c11) << 3)) & 536870911;
        int i13 = i12 ^ (i12 >> 11);
        return (int) (((long) i13) + (((long) (i13 << 15)) & 4294967295L));
    }
}
