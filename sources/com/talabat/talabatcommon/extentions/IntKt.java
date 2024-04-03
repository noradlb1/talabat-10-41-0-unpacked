package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0003\u001a\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0005\u001a\u0011\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"isZero", "", "", "(Ljava/lang/Integer;)Z", "orZero", "Lkotlin/Int$Companion;", "(Ljava/lang/Integer;)I", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class IntKt {
    public static final boolean isZero(@Nullable Integer num) {
        return num != null && num.intValue() == 0;
    }

    public static final int orZero(@Nullable Integer num) {
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static final int orZero(@NotNull IntCompanionObject intCompanionObject) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return 0;
    }
}
