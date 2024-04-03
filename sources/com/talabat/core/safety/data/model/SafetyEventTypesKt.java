package com.talabat.core.safety.data.model;

import com.talabat.core.safety.domain.SafetyEventType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"SAFETY_EVENT_LOGIN", "", "SAFETY_EVENT_SIGNUP", "toInt", "Lcom/talabat/core/safety/domain/SafetyEventType;", "com_talabat_core_safety_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SafetyEventTypesKt {
    public static final int SAFETY_EVENT_LOGIN = 1;
    public static final int SAFETY_EVENT_SIGNUP = 0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SafetyEventType.values().length];
            iArr[SafetyEventType.SIGNUP.ordinal()] = 1;
            iArr[SafetyEventType.LOGIN.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int toInt(@NotNull SafetyEventType safetyEventType) {
        Intrinsics.checkNotNullParameter(safetyEventType, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[safetyEventType.ordinal()];
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
