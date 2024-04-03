package com.talabat.configuration.country;

import com.talabat.core.fwf.data.FunWithFlags;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemap.HomeMapConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b \b\u0001\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001$BG\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006%"}, d2 = {"Lcom/talabat/configuration/country/Country;", "", "countryId", "", "countryName", "", "twoLetterCode", "threeLetterCode", "phoneCode", "phoneCodeISO3166", "shortCountryName", "globalEntityId", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCountryId", "()I", "getCountryName", "()Ljava/lang/String;", "getGlobalEntityId", "getPhoneCode", "getPhoneCodeISO3166", "getShortCountryName", "getThreeLetterCode", "getTwoLetterCode", "threeLetterCodeUpperCase", "twoLetterCodeUpperCase", "UNDEFINED", "KUWAIT", "KSA", "BAHRAIN", "UAE", "OMAN", "QATAR", "LEBANON", "JORDAN", "EGYPT", "IRAQ", "Companion", "com_talabat_core_configuration_local_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum Country {
    UNDEFINED(0, "", "kw", "kwt", "", 0, "", "TB_KW"),
    KUWAIT(1, "Kuwait", "kw", "kwt", "+965", 414, HomeMapConstants.GEO_POLYGON_COUNTRY_KUWAIT, "TB_KW"),
    KSA(2, "Saudi Arabia", "sa", "sau", "+966", 682, "ksa", "TB_SA"),
    BAHRAIN(3, "Bahrain", "bh", "bhr", "+973", 48, "bahrain", "TB_BH"),
    UAE(4, "United Arab Emirates", "ae", "are", "+971", 784, "uae", "TB_AE"),
    OMAN(5, HomeMapConstants.GEO_POLYGON_COUNTRY_OMAN, "om", "omn", "+968", 512, "oman", "TB_OM"),
    QATAR(6, HomeMapConstants.GEO_POLYGON_COUNTRY_QATAR, FunWithFlags.ENV_QA, "qat", "+974", 634, "qatar", "TB_QA"),
    LEBANON(7, "Lebanon", "lb", "lbn", "+961", 422, "lebanon", "TB_LB"),
    JORDAN(8, HomeMapConstants.GEO_POLYGON_COUNTRY_JORDAN, "jo", "jor", "+962", 400, "jordan", "TB_JO"),
    EGYPT(9, "Egypt", "eg", "egy", "+20", 818, "egypt", "HF_EG"),
    IRAQ(10, "Iraq", "iq", "irq", "+964", 368, "iraq", "TB_IQ");
    
    @NotNull
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    @NotNull
    public static final Country[] values = null;
    private final int countryId;
    @NotNull
    private final String countryName;
    @NotNull
    private final String globalEntityId;
    @NotNull
    private final String phoneCode;
    private final int phoneCodeISO3166;
    @NotNull
    private final String shortCountryName;
    @NotNull
    private final String threeLetterCode;
    @NotNull
    private final String twoLetterCode;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/talabat/configuration/country/Country$Companion;", "", "()V", "values", "", "Lcom/talabat/configuration/country/Country;", "[Lcom/talabat/configuration/country/Country;", "from", "countryId", "", "com_talabat_core_configuration_local_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Country from(int i11) {
            Country country;
            boolean z11;
            Country[] access$getValues$cp = Country.values;
            int length = access$getValues$cp.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    country = null;
                    break;
                }
                country = access$getValues$cp[i12];
                if (country.getCountryId() == i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    break;
                }
                i12++;
            }
            if (country == null) {
                return Country.UNDEFINED;
            }
            return country;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
        values = values();
    }

    private Country(int i11, String str, String str2, String str3, String str4, int i12, String str5, String str6) {
        this.countryId = i11;
        this.countryName = str;
        this.twoLetterCode = str2;
        this.threeLetterCode = str3;
        this.phoneCode = str4;
        this.phoneCodeISO3166 = i12;
        this.shortCountryName = str5;
        this.globalEntityId = str6;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @NotNull
    public final String getCountryName() {
        return this.countryName;
    }

    @NotNull
    public final String getGlobalEntityId() {
        return this.globalEntityId;
    }

    @NotNull
    public final String getPhoneCode() {
        return this.phoneCode;
    }

    public final int getPhoneCodeISO3166() {
        return this.phoneCodeISO3166;
    }

    @NotNull
    public final String getShortCountryName() {
        return this.shortCountryName;
    }

    @NotNull
    public final String getThreeLetterCode() {
        return this.threeLetterCode;
    }

    @NotNull
    public final String getTwoLetterCode() {
        return this.twoLetterCode;
    }

    @NotNull
    public final String threeLetterCodeUpperCase() {
        String upperCase = this.threeLetterCode.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    @NotNull
    public final String twoLetterCodeUpperCase() {
        String upperCase = this.twoLetterCode.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }
}
