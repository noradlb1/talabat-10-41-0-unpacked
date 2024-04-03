package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"orZero", "", "Lkotlin/Double$Companion;", "(Ljava/lang/Double;)D", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DoubleKt {
    public static final double orZero(@Nullable Double d11) {
        if (d11 != null) {
            return d11.doubleValue();
        }
        return 0.0d;
    }

    public static final double orZero(@NotNull DoubleCompanionObject doubleCompanionObject) {
        Intrinsics.checkNotNullParameter(doubleCompanionObject, "<this>");
        return 0.0d;
    }
}
