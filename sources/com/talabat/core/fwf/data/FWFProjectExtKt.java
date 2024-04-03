package com.talabat.core.fwf.data;

import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import com.talabat.secrets.FwfKeys;
import com.talabat.secrets.Secrets;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"FALLBACK_TOKEN_VALUE", "", "isProd", "", "getFwfAdExToken", "secrets", "Lcom/talabat/secrets/Secrets;", "getFwfDefaultToken", "getFwfEcosystemsToken", "getFwfHomePageToken", "getFwfKillSwitchFlagsToken", "getFwfMenuToken", "getFwfOrderingToken", "getFwfPlatformToken", "getFwfPoeToken", "getFwfQCommerceToken", "getFwfSearchToken", "getFwfUserToken", "getFwfVendorListToken", "getToken", "fwfProjectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "com_talabat_core_fwf_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FWFProjectExtKt {
    @NotNull
    private static final String FALLBACK_TOKEN_VALUE = "";
    private static final boolean isProd;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FWFProjectName.values().length];
            iArr[FWFProjectName.DEFAULT.ordinal()] = 1;
            iArr[FWFProjectName.HOME_PAGE.ordinal()] = 2;
            iArr[FWFProjectName.VENDOR_LIST.ordinal()] = 3;
            iArr[FWFProjectName.SEARCH.ordinal()] = 4;
            iArr[FWFProjectName.MENU.ordinal()] = 5;
            iArr[FWFProjectName.ORDERING.ordinal()] = 6;
            iArr[FWFProjectName.Q_COMMERCE.ordinal()] = 7;
            iArr[FWFProjectName.POE.ordinal()] = 8;
            iArr[FWFProjectName.USER.ordinal()] = 9;
            iArr[FWFProjectName.ADEX.ordinal()] = 10;
            iArr[FWFProjectName.KILL_SWITCH_FLAGS.ordinal()] = 11;
            iArr[FWFProjectName.PLATFORM.ordinal()] = 12;
            iArr[FWFProjectName.ECOSYSTEMS.ordinal()] = 13;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        boolean z11 = true;
        if (!Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "prod") && (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) FunWithFlags.ENV_QA) || !Intrinsics.areEqual((Object) "release", (Object) "release"))) {
            z11 = false;
        }
        isProd = z11;
    }

    private static final String getFwfAdExToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfAdExProdToken() : fwfKeys.getGetFwfAdExQaToken();
    }

    private static final String getFwfDefaultToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfDefaultProdToken() : fwfKeys.getGetFwfDefaultQaToken();
    }

    private static final String getFwfEcosystemsToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfEcosystemsProdToken() : fwfKeys.getGetFwfEcosystemsQaToken();
    }

    private static final String getFwfHomePageToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfHomePageProdToken() : fwfKeys.getGetFwfHomePageQaToken();
    }

    private static final String getFwfKillSwitchFlagsToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfKillSwitchFlagsProdToken() : fwfKeys.getGetFwfKillSwitchFlagsQaToken();
    }

    private static final String getFwfMenuToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfMenuProdToken() : fwfKeys.getGetFwfMenuQaToken();
    }

    private static final String getFwfOrderingToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfOrderingProdToken() : fwfKeys.getGetFwfOrderingQaToken();
    }

    private static final String getFwfPlatformToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfPlatformProdToken() : fwfKeys.getGetFwfPlatformQaToken();
    }

    private static final String getFwfPoeToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfPoeProdToken() : fwfKeys.getGetFwfPoeQaToken();
    }

    private static final String getFwfQCommerceToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfQCommerceProdToken() : fwfKeys.getGetFwfQCommerceQaToken();
    }

    private static final String getFwfSearchToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfSearchProdToken() : fwfKeys.getGetFwfSearchQaToken();
    }

    private static final String getFwfUserToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfUserProdToken() : fwfKeys.getGetFwfUserQaToken();
    }

    private static final String getFwfVendorListToken(Secrets secrets) {
        boolean z11 = isProd;
        FwfKeys fwfKeys = secrets.getFwfKeys();
        return z11 ? fwfKeys.getGetFwfVendorListProdToken() : fwfKeys.getGetFwfVendorListQaToken();
    }

    @NotNull
    public static final String getToken(@NotNull FWFProjectName fWFProjectName, @NotNull Secrets secrets) {
        Object obj;
        String str;
        Intrinsics.checkNotNullParameter(fWFProjectName, "fwfProjectName");
        Intrinsics.checkNotNullParameter(secrets, "secrets");
        try {
            Result.Companion companion = Result.Companion;
            switch (WhenMappings.$EnumSwitchMapping$0[fWFProjectName.ordinal()]) {
                case 1:
                    str = getFwfDefaultToken(secrets);
                    break;
                case 2:
                    str = getFwfHomePageToken(secrets);
                    break;
                case 3:
                    str = getFwfVendorListToken(secrets);
                    break;
                case 4:
                    str = getFwfSearchToken(secrets);
                    break;
                case 5:
                    str = getFwfMenuToken(secrets);
                    break;
                case 6:
                    str = getFwfOrderingToken(secrets);
                    break;
                case 7:
                    str = getFwfQCommerceToken(secrets);
                    break;
                case 8:
                    str = getFwfPoeToken(secrets);
                    break;
                case 9:
                    str = getFwfUserToken(secrets);
                    break;
                case 10:
                    str = getFwfAdExToken(secrets);
                    break;
                case 11:
                    str = getFwfKillSwitchFlagsToken(secrets);
                    break;
                case 12:
                    str = getFwfPlatformToken(secrets);
                    break;
                case 13:
                    str = getFwfEcosystemsToken(secrets);
                    break;
                default:
                    str = getFwfDefaultToken(secrets);
                    break;
            }
            obj = Result.m6329constructorimpl(str);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = "";
        }
        return (String) obj;
    }
}
