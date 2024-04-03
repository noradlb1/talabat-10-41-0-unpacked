package com.talabat.talabatcommon.extentions;

import kotlin.Metadata;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\u000f\u0010\u0002\u001a\u00020\u0001*\u00020\u0003¢\u0006\u0002\u0010\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"isFalse", "", "orFalse", "Lkotlin/Boolean$Companion;", "(Lkotlin/jvm/internal/BooleanCompanionObject;)Z", "(Ljava/lang/Boolean;)Z", "orTrue", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BooleanKt {
    public static final boolean isFalse(boolean z11) {
        return !z11;
    }

    public static final boolean orFalse(@Nullable Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean orFalse(@NotNull BooleanCompanionObject booleanCompanionObject) {
        Intrinsics.checkNotNullParameter(booleanCompanionObject, "<this>");
        return false;
    }

    public static final boolean orTrue(@Nullable Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }
}
