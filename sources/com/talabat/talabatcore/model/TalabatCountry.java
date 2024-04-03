package com.talabat.talabatcore.model;

import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.visa.checkout.Profile;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcore/model/TalabatCountry;", "", "code", "", "countryId", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getCode", "()Ljava/lang/String;", "getCountryId", "()I", "KUWAIT", "KSA", "BAHRAIN", "UAE", "OMAN", "QATAR", "LEBANON", "JORDAN", "EGYPT", "IRAQ", "NONE", "Companion", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "This class duplicates the configuration country class, use Country class from core:configuration:local:domain module", replaceWith = @ReplaceWith(expression = "Country", imports = {"com.talabat.configuration.country.Country"}))
public enum TalabatCountry {
    KUWAIT(Profile.Country.KW, 1),
    KSA(Profile.Country.SA, 2),
    BAHRAIN("BH", 3),
    UAE(Profile.Country.AE, 4),
    OMAN("OM", 5),
    QATAR(Profile.Country.QA, 6),
    LEBANON(ExpandedProductParsedResult.POUND, 7),
    JORDAN("JO", 8),
    EGYPT("EG", 9),
    IRAQ("IQ", 10),
    NONE("", 0);
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String code;
    private final int countryId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcore/model/TalabatCountry$Companion;", "", "()V", "fromCountryId", "Lcom/talabat/talabatcore/model/TalabatCountry;", "countryId", "", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final TalabatCountry fromCountryId(int i11) {
            TalabatCountry talabatCountry = TalabatCountry.KUWAIT;
            if (i11 == talabatCountry.getCountryId()) {
                return talabatCountry;
            }
            TalabatCountry talabatCountry2 = TalabatCountry.KSA;
            if (i11 == talabatCountry2.getCountryId()) {
                return talabatCountry2;
            }
            TalabatCountry talabatCountry3 = TalabatCountry.BAHRAIN;
            if (i11 == talabatCountry3.getCountryId()) {
                return talabatCountry3;
            }
            TalabatCountry talabatCountry4 = TalabatCountry.UAE;
            if (i11 == talabatCountry4.getCountryId()) {
                return talabatCountry4;
            }
            TalabatCountry talabatCountry5 = TalabatCountry.OMAN;
            if (i11 == talabatCountry5.getCountryId()) {
                return talabatCountry5;
            }
            TalabatCountry talabatCountry6 = TalabatCountry.QATAR;
            if (i11 == talabatCountry6.getCountryId()) {
                return talabatCountry6;
            }
            TalabatCountry talabatCountry7 = TalabatCountry.LEBANON;
            if (i11 == talabatCountry7.getCountryId()) {
                return talabatCountry7;
            }
            TalabatCountry talabatCountry8 = TalabatCountry.JORDAN;
            if (i11 == talabatCountry8.getCountryId()) {
                return talabatCountry8;
            }
            TalabatCountry talabatCountry9 = TalabatCountry.EGYPT;
            if (i11 == talabatCountry9.getCountryId()) {
                return talabatCountry9;
            }
            TalabatCountry talabatCountry10 = TalabatCountry.IRAQ;
            if (i11 == talabatCountry10.getCountryId()) {
                return talabatCountry10;
            }
            return TalabatCountry.NONE;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private TalabatCountry(String str, int i11) {
        this.code = str;
        this.countryId = i11;
    }

    @JvmStatic
    @NotNull
    public static final TalabatCountry fromCountryId(int i11) {
        return Companion.fromCountryId(i11);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final int getCountryId() {
        return this.countryId;
    }
}
