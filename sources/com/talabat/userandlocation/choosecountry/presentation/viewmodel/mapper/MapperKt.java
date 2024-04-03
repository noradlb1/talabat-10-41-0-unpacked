package com.talabat.userandlocation.choosecountry.presentation.viewmodel.mapper;

import com.talabat.configuration.country.Country;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import com.talabat.userandlocation.choosecountry.R;
import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import com.talabat.userandlocation.choosecountry.presentation.displaymodel.CountryDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¨\u0006\n"}, d2 = {"getFlagOfCountry", "", "countryId", "getNameOfCountry", "", "default", "toDisplayModel", "Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/CountryDisplayModel;", "countryEntity", "Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MapperKt {
    private static final int getFlagOfCountry(int i11) {
        if (i11 == Country.UAE.getCountryId()) {
            return R.drawable.flag_uae_country;
        }
        if (i11 == Country.EGYPT.getCountryId()) {
            return R.drawable.flag_egypt_country;
        }
        if (i11 == Country.BAHRAIN.getCountryId()) {
            return R.drawable.flag_bahrain_country;
        }
        if (i11 == Country.JORDAN.getCountryId()) {
            return R.drawable.flag_jordan_country;
        }
        if (i11 == Country.KSA.getCountryId()) {
            return R.drawable.flag_ksa_country;
        }
        if (i11 == Country.KUWAIT.getCountryId()) {
            return R.drawable.flag_kwt_country;
        }
        if (i11 == Country.OMAN.getCountryId()) {
            return R.drawable.flag_oman_country;
        }
        if (i11 == Country.QATAR.getCountryId()) {
            return R.drawable.flag_qatar_country;
        }
        if (i11 == Country.IRAQ.getCountryId()) {
            return R.drawable.flag_iraq_country;
        }
        return -1;
    }

    private static final String getNameOfCountry(int i11, String str) {
        Integer num;
        String localizedString;
        if (i11 == Country.UAE.getCountryId()) {
            num = Integer.valueOf(com.talabat.localization.R.string.side_menu_country_uae);
        } else if (i11 == Country.EGYPT.getCountryId()) {
            num = Integer.valueOf(com.talabat.localization.R.string.side_menu_country_egypt);
        } else if (i11 == Country.BAHRAIN.getCountryId()) {
            num = Integer.valueOf(com.talabat.localization.R.string.side_menu_country_bahrain);
        } else if (i11 == Country.JORDAN.getCountryId()) {
            num = Integer.valueOf(com.talabat.localization.R.string.side_menu_country_jordan);
        } else if (i11 == Country.KSA.getCountryId()) {
            num = Integer.valueOf(com.talabat.localization.R.string.side_menu_country_ksa);
        } else if (i11 == Country.KUWAIT.getCountryId()) {
            num = Integer.valueOf(com.talabat.localization.R.string.side_menu_country_kuwait);
        } else if (i11 == Country.OMAN.getCountryId()) {
            num = Integer.valueOf(com.talabat.localization.R.string.side_menu_country_oman);
        } else if (i11 == Country.QATAR.getCountryId()) {
            num = Integer.valueOf(com.talabat.localization.R.string.side_menu_country_qatar);
        } else if (i11 == Country.IRAQ.getCountryId()) {
            num = Integer.valueOf(com.talabat.localization.R.string.side_menu_country_iraq);
        } else {
            num = null;
        }
        if (num == null || (localizedString = DynamicLocalizationKt.toLocalizedString(num.intValue(), str)) == null) {
            return str;
        }
        return localizedString;
    }

    @NotNull
    public static final CountryDisplayModel toDisplayModel(@NotNull CountryVO countryVO) {
        Intrinsics.checkNotNullParameter(countryVO, "countryEntity");
        return new CountryDisplayModel(countryVO.getId(), getNameOfCountry(countryVO.getId(), countryVO.getName()), getFlagOfCountry(countryVO.getId()), countryVO.isSelected());
    }
}
