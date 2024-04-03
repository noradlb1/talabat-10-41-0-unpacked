package com.talabat.restaurants.v2.data.swimlane;

import com.talabat.core.buildconfig.TalabatEnvironment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/restaurants/v2/data/swimlane/SwimlaneUrlConstants;", "", "()V", "getBaseUrl", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneUrlConstants {
    @NotNull
    public static final SwimlaneUrlConstants INSTANCE = new SwimlaneUrlConstants();

    private SwimlaneUrlConstants() {
    }

    @NotNull
    public final String getBaseUrl() {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "prod") || Intrinsics.areEqual((Object) "release", (Object) "release")) {
            return "https://api.talabat.com/";
        }
        if (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "mock")) {
            return "http://localhost:8000/";
        }
        return "https://qa.talabat.com/";
    }
}
