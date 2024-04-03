package com.talabat.home;

import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.helpers.ApptimizeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/home/HomeApptimizeFwFIntegration;", "", "()V", "initApptimizeGlobal", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeApptimizeFwFIntegration {
    @NotNull
    public static final HomeApptimizeFwFIntegration INSTANCE = new HomeApptimizeFwFIntegration();

    private HomeApptimizeFwFIntegration() {
    }

    public final void initApptimizeGlobal() {
        Boolean bool = BuildConfig.IS_ALPHA;
        Intrinsics.checkNotNullExpressionValue(bool, "IS_ALPHA");
        ApptimizeHelper.enableGoogleSearchOptimization(bool.booleanValue());
    }
}
