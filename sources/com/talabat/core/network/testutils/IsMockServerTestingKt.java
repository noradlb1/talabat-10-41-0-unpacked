package com.talabat.core.network.testutils;

import com.talabat.core.buildconfig.TalabatEnvironment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"isIdlingResourceRequired", "", "isMockServerTesting", "com_talabat_core_network_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class IsMockServerTestingKt {
    public static final boolean isIdlingResourceRequired() {
        return false;
    }

    public static final boolean isMockServerTesting() {
        return Intrinsics.areEqual((Object) TalabatEnvironment.INSTANCE.getEnvironment(), (Object) "mock");
    }
}
