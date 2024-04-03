package com.checkout.logging.utils;

import com.adjust.sdk.AdjustConfig;
import com.checkout.base.model.Environment;
import com.checkout.eventlogger.Environment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"toLoggingEnvironment", "Lcom/checkout/eventlogger/Environment;", "Lcom/checkout/base/model/Environment;", "toLoggingName", "", "checkout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class EnvironmentExtensionKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Environment.values().length];
            iArr[Environment.PRODUCTION.ordinal()] = 1;
            iArr[Environment.SANDBOX.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final com.checkout.eventlogger.Environment toLoggingEnvironment(@NotNull Environment environment) {
        Intrinsics.checkNotNullParameter(environment, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i11 == 1) {
            return Environment.PRODUCTION.INSTANCE;
        }
        if (i11 == 2) {
            return Environment.SANDBOX.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final String toLoggingName(@NotNull com.checkout.base.model.Environment environment) {
        Intrinsics.checkNotNullParameter(environment, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[environment.ordinal()];
        if (i11 == 1) {
            return AdjustConfig.ENVIRONMENT_PRODUCTION;
        }
        if (i11 == 2) {
            return AdjustConfig.ENVIRONMENT_SANDBOX;
        }
        throw new NoWhenBranchMatchedException();
    }
}
