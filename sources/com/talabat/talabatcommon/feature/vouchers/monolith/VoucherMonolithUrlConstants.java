package com.talabat.talabatcommon.feature.vouchers.monolith;

import com.talabat.core.buildconfig.TalabatEnvironment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/VoucherMonolithUrlConstants;", "", "()V", "getGroceryBaseUrl", "", "getMainBaseUrl", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherMonolithUrlConstants {
    @NotNull
    public static final VoucherMonolithUrlConstants INSTANCE = new VoucherMonolithUrlConstants();

    private VoucherMonolithUrlConstants() {
    }

    @NotNull
    public final String getGroceryBaseUrl() {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "prod") || Intrinsics.areEqual((Object) "release", (Object) "release")) {
            return "https://api.talabat.com/grocery/";
        }
        if (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "mock")) {
            return "http://localhost:8000/";
        }
        return "https://api-qa.dhhmena.com/grocery/";
    }

    @NotNull
    public final String getMainBaseUrl() {
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
