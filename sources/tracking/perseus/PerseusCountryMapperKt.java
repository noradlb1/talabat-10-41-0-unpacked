package tracking.perseus;

import com.talabat.configuration.country.Country;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"perseusCountryCode", "", "Lcom/talabat/configuration/country/Country;", "perseusGlobalEntityId", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PerseusCountryMapperKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Country.values().length];
            iArr[Country.BAHRAIN.ordinal()] = 1;
            iArr[Country.EGYPT.ordinal()] = 2;
            iArr[Country.IRAQ.ordinal()] = 3;
            iArr[Country.JORDAN.ordinal()] = 4;
            iArr[Country.KSA.ordinal()] = 5;
            iArr[Country.KUWAIT.ordinal()] = 6;
            iArr[Country.OMAN.ordinal()] = 7;
            iArr[Country.QATAR.ordinal()] = 8;
            iArr[Country.UAE.ordinal()] = 9;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final String perseusCountryCode(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "<this>");
        if (country == Country.UNDEFINED) {
            return "";
        }
        return country.twoLetterCodeUpperCase();
    }

    @NotNull
    public static final String perseusGlobalEntityId(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[country.ordinal()]) {
            case 1:
                return "TB_BH";
            case 2:
                return "HF_EG";
            case 3:
                return "TB_IQ";
            case 4:
                return "TB_JO";
            case 5:
                return "TB_SA";
            case 6:
                return "TB_KW";
            case 7:
                return "TB_OM";
            case 8:
                return "TB_QA";
            case 9:
                return "TB_AE";
            default:
                return "TB";
        }
    }
}
