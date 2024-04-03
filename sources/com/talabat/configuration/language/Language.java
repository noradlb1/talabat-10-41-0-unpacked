package com.talabat.configuration.language;

import com.talabat.helpers.GlobalConstants;
import com.tekartik.sqflite.Constant;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/talabat/configuration/language/Language;", "", "isoCode", "", "languageCode", "countryCode", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "code", "getCode", "()Ljava/lang/String;", "getCountryCode", "getIsoCode", "getLanguageCode", "ENGLISH", "ARABIC", "KURDISH_BADINI", "KURDISH_SORANI", "UNKNOWN", "Companion", "com_talabat_core_configuration_local_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum Language {
    ENGLISH("en-US", "en", Profile.Country.US),
    ARABIC(GlobalConstants.ARABIC, ArchiveStreamFactory.AR, Profile.Country.KW),
    KURDISH_BADINI(GlobalConstants.KURDISH_BADINI, "ku", "IR"),
    KURDISH_SORANI(GlobalConstants.KURDISH_SORANI, GlobalConstants.KURDISH_SORANI_LOCAL, ""),
    UNKNOWN("o", "o", "o");
    
    @NotNull
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    @NotNull
    public static final Language[] values = null;
    @NotNull
    private final String code;
    @NotNull
    private final String countryCode;
    @NotNull
    private final String isoCode;
    @NotNull
    private final String languageCode;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/talabat/configuration/language/Language$Companion;", "", "()V", "values", "", "Lcom/talabat/configuration/language/Language;", "[Lcom/talabat/configuration/language/Language;", "from", "code", "", "com_talabat_core_configuration_local_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Language from(@NotNull String str) {
            Language language;
            boolean z11;
            Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
            Language[] access$getValues$cp = Language.values;
            int length = access$getValues$cp.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    language = null;
                    break;
                }
                language = access$getValues$cp[i11];
                if (Intrinsics.areEqual((Object) language.getIsoCode(), (Object) str) || Intrinsics.areEqual((Object) language.getLanguageCode(), (Object) str)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    break;
                }
                i11++;
            }
            if (language == null) {
                return Language.ENGLISH;
            }
            return language;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        values = values();
    }

    private Language(String str, String str2, String str3) {
        this.isoCode = str;
        this.languageCode = str2;
        this.countryCode = str3;
        this.code = str;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    @NotNull
    public final String getIsoCode() {
        return this.isoCode;
    }

    @NotNull
    public final String getLanguageCode() {
        return this.languageCode;
    }
}
