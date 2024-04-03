package com.talabat.talabatcommon.feature.ridersTip;

import com.talabat.core.buildconfig.TalabatEnvironment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/UrlConstants;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UrlConstants {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/UrlConstants$Companion;", "", "()V", "getBaseUrl", "", "getWalletBaseUrl", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getBaseUrl() {
            TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
            if (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "prod") || Intrinsics.areEqual((Object) "release", (Object) "release")) {
                return UrlConstantsKt.BASE_RELEASE_URL;
            }
            if (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "mock")) {
                return UrlConstantsKt.INSTRUMENTATION_TESTING_BASE_URL;
            }
            return UrlConstantsKt.BASE_QA_URL;
        }

        @NotNull
        public final String getWalletBaseUrl() {
            if (Intrinsics.areEqual((Object) "release", (Object) "release")) {
                return "https://walletapi.talabat.com";
            }
            return "https://walletapi-qa.dhhmena.com";
        }
    }
}
