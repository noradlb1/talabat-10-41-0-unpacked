package com.talabat.offering.data;

import com.talabat.configuration.country.Country;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\r\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"BAHRAIN_COUNTRY_ID", "", "EGYPT_COUNTRY_ID", "IRAQ_COUNTRY_ID", "JORDAN_COUNTRY_ID", "KSA_COUNTRY_ID", "KUWAIT_COUNTRY_ID", "LEBANON_COUNTRY_ID", "OMAN_COUNTRY_ID", "QATAR_COUNTRY_ID", "UAE_COUNTRY_ID", "UNDEFINED_COUNTRY_ID", "subscriptionCountryId", "Lcom/talabat/configuration/country/Country;", "com_talabat_NewArchi_Offering_Offering"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCountryMapperKt {
    public static final int BAHRAIN_COUNTRY_ID = 48;
    public static final int EGYPT_COUNTRY_ID = 818;
    public static final int IRAQ_COUNTRY_ID = 368;
    public static final int JORDAN_COUNTRY_ID = 400;
    public static final int KSA_COUNTRY_ID = 682;
    public static final int KUWAIT_COUNTRY_ID = 414;
    public static final int LEBANON_COUNTRY_ID = 422;
    public static final int OMAN_COUNTRY_ID = 512;
    public static final int QATAR_COUNTRY_ID = 634;
    public static final int UAE_COUNTRY_ID = 784;
    public static final int UNDEFINED_COUNTRY_ID = -1;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Country.values().length];
            iArr[Country.UNDEFINED.ordinal()] = 1;
            iArr[Country.EGYPT.ordinal()] = 2;
            iArr[Country.BAHRAIN.ordinal()] = 3;
            iArr[Country.JORDAN.ordinal()] = 4;
            iArr[Country.KSA.ordinal()] = 5;
            iArr[Country.KUWAIT.ordinal()] = 6;
            iArr[Country.OMAN.ordinal()] = 7;
            iArr[Country.QATAR.ordinal()] = 8;
            iArr[Country.LEBANON.ordinal()] = 9;
            iArr[Country.UAE.ordinal()] = 10;
            iArr[Country.IRAQ.ordinal()] = 11;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int subscriptionCountryId(@NotNull Country country) {
        Intrinsics.checkNotNullParameter(country, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[country.ordinal()]) {
            case 1:
                return -1;
            case 2:
                return 818;
            case 3:
                return 48;
            case 4:
                return 400;
            case 5:
                return 682;
            case 6:
                return 414;
            case 7:
                return 512;
            case 8:
                return 634;
            case 9:
                return 422;
            case 10:
                return 784;
            case 11:
                return 368;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
