package com.talabat.talabatcommon.feature;

import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.secrets.Secrets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/feature/TalabatCommonUrlConstants;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCommonUrlConstants {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/feature/TalabatCommonUrlConstants$Companion;", "", "()V", "getFeatureBaseUrl", "", "mockServerBaseUrl", "productionServerBaseUrl", "qaServerBaseUrl", "instrumentationTestingServer", "buildType", "getProSubscriptionProductId", "getSubscriptionBaseUrl", "getSubscriptionOrganizationToken", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getFeatureBaseUrl(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "mockServerBaseUrl");
            Intrinsics.checkNotNullParameter(str2, "productionServerBaseUrl");
            Intrinsics.checkNotNullParameter(str3, "qaServerBaseUrl");
            Intrinsics.checkNotNullParameter(str4, "instrumentationTestingServer");
            Intrinsics.checkNotNullParameter(str5, "buildType");
            if (Intrinsics.areEqual((Object) str4, (Object) "prod") || Intrinsics.areEqual((Object) str5, (Object) "release")) {
                return str2;
            }
            if (Intrinsics.areEqual((Object) str4, (Object) "mock")) {
                return str;
            }
            return str3;
        }

        @NotNull
        public final String getProSubscriptionProductId(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "buildType");
            Intrinsics.checkNotNullParameter(str2, "instrumentationTestingServer");
            Secrets secrets = new Secrets();
            if (Intrinsics.areEqual((Object) str2, (Object) "prod") || Intrinsics.areEqual((Object) str, (Object) "release")) {
                return secrets.getProSubscriptionProdProductI();
            }
            return secrets.getProSubscriptionQAProductId();
        }

        @NotNull
        public final String getSubscriptionBaseUrl() {
            return getFeatureBaseUrl("http://localhost:8000/", TalabatCommonUrlConstantsKt.SUBSCRIPTION_RELEASE_BASE_URL, TalabatCommonUrlConstantsKt.SUBSCRIPTION_QA_BASE_URL, TalabatEnvironment.INSTANCE.getEnvironment(), "release");
        }

        @NotNull
        public final String getSubscriptionOrganizationToken(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "buildType");
            Secrets secrets = new Secrets();
            if (Intrinsics.areEqual((Object) str, (Object) "release")) {
                return secrets.getSubscriptionReleaseKey();
            }
            return secrets.getSubscriptionQAKey();
        }
    }
}
