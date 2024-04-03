package com.talabat.fluttercore.data;

import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.helpers.GlobalConstants;
import com.visa.checkout.PurchaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/fluttercore/data/FlutterConstants;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterConstants {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DEBUG = "debug";
    @NotNull
    public static final String INSTRUMENTATION_TESTING_SERVER_MOCK = "mock";
    @NotNull
    public static final String INSTRUMENTATION_TESTING_SERVER_PRODUCTION = "prod";
    @NotNull
    public static final String NOT_IMPLEMENTED_METHOD_CALL = "Not Implemented";
    @NotNull
    public static final String RELEASE = "release";

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/fluttercore/data/FlutterConstants$Companion;", "", "()V", "DEBUG", "", "INSTRUMENTATION_TESTING_SERVER_MOCK", "INSTRUMENTATION_TESTING_SERVER_PRODUCTION", "NOT_IMPLEMENTED_METHOD_CALL", "RELEASE", "buildType", "isLanguageRTL", "", "language", "selectedCountryCurrencyCode", "countryId", "", "selectedLanguage", "selectedLanguageCode", "selectedLanguageName", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String buildType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "buildType");
            TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
            if (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "prod") || Intrinsics.areEqual((Object) str, (Object) "release")) {
                return "prod";
            }
            if (Intrinsics.areEqual((Object) talabatEnvironment.getEnvironment(), (Object) "mock")) {
                return "mock";
            }
            return "dev";
        }

        public final boolean isLanguageRTL(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, ConstantsKt.ADJUST_LANGUAGE);
            int hashCode = str.hashCode();
            if (hashCode != 93023368) {
                if (hashCode == 96598594) {
                    boolean equals = str.equals("en-US");
                } else if (hashCode == 102348191 && str.equals(GlobalConstants.KURDISH_SORANI)) {
                    return true;
                }
            } else if (str.equals(GlobalConstants.ARABIC)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String selectedCountryCurrencyCode(int i11) {
            switch (i11) {
                case 2:
                    return PurchaseInfo.Currency.SAR;
                case 3:
                    return "BHD";
                case 4:
                    return PurchaseInfo.Currency.AED;
                case 5:
                    return "OMR";
                case 6:
                    return PurchaseInfo.Currency.QAR;
                case 7:
                    return "LBP";
                case 8:
                    return "JOD";
                case 9:
                    return "EGP";
                case 10:
                    return "IQD";
                default:
                    return PurchaseInfo.Currency.KWD;
            }
        }

        @NotNull
        public final String selectedLanguage(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, ConstantsKt.ADJUST_LANGUAGE);
            int hashCode = str.hashCode();
            if (hashCode != 93023368) {
                if (hashCode == 96598594) {
                    boolean equals = str.equals("en-US");
                    return "en";
                } else if (hashCode == 102348191 && str.equals(GlobalConstants.KURDISH_SORANI)) {
                    return GlobalConstants.KURDISH_SORANI_LOCAL;
                } else {
                    return "en";
                }
            } else if (!str.equals(GlobalConstants.ARABIC)) {
                return "en";
            } else {
                return ArchiveStreamFactory.AR;
            }
        }

        @NotNull
        public final String selectedLanguageCode(@NotNull String str) {
            String str2;
            Intrinsics.checkNotNullParameter(str, ConstantsKt.ADJUST_LANGUAGE);
            int hashCode = str.hashCode();
            if (hashCode == 93023368) {
                str2 = GlobalConstants.ARABIC;
                if (!str.equals(str2)) {
                    return "en-US";
                }
            } else if (hashCode == 96598594) {
                boolean equals = str.equals("en-US");
                return "en-US";
            } else if (hashCode != 102348191) {
                return "en-US";
            } else {
                str2 = GlobalConstants.KURDISH_SORANI;
                if (!str.equals(str2)) {
                    return "en-US";
                }
            }
            return str2;
        }

        @NotNull
        public final String selectedLanguageName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, ConstantsKt.ADJUST_LANGUAGE);
            int hashCode = str.hashCode();
            if (hashCode != 93023368) {
                if (hashCode == 96598594) {
                    boolean equals = str.equals("en-US");
                    return "English";
                } else if (hashCode == 102348191 && str.equals(GlobalConstants.KURDISH_SORANI)) {
                    return "Kurdish (Sorani)";
                } else {
                    return "English";
                }
            } else if (!str.equals(GlobalConstants.ARABIC)) {
                return "English";
            } else {
                return "Arabic";
            }
        }
    }
}
