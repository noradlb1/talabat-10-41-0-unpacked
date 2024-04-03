package com.talabat.core.buildconfig;

import com.talabat.core.fwf.data.FunWithFlags;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/buildconfig/TalabatEnvironment;", "", "()V", "environment", "", "getEnvironment", "()Ljava/lang/String;", "com_talabat_core_build-config_build-config"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatEnvironment {
    @NotNull
    public static final TalabatEnvironment INSTANCE = new TalabatEnvironment();

    private TalabatEnvironment() {
    }

    @NotNull
    public final String getEnvironment() {
        if (Intrinsics.areEqual((Object) "release", (Object) "release")) {
            return "prod";
        }
        String str = "";
        if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
            str = null;
        }
        if (str == null) {
            return FunWithFlags.ENV_QA;
        }
        return str;
    }
}
