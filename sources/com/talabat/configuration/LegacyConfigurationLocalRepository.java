package com.talabat.configuration;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.language.Language;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.helpers.GlobalDataModel;
import com.tekartik.sqflite.Constant;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/talabat/configuration/LegacyConfigurationLocalRepository;", "Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "()V", "selectedCountry", "Lcom/talabat/configuration/country/Country;", "selectedLanguage", "Lcom/talabat/configuration/language/Language;", "setSelectedCountry", "", "countryId", "", "setSelectedLanguage", "language", "code", "", "com_talabat_core_configuration_local_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class LegacyConfigurationLocalRepository implements MutableConfigurationLocalRepository {
    @NotNull
    public Country selectedCountry() {
        return Country.Companion.from(GlobalDataModel.SelectedCountryId);
    }

    @NotNull
    public Language selectedLanguage() {
        Language.Companion companion = Language.Companion;
        String str = GlobalDataModel.SelectedLanguage;
        Intrinsics.checkNotNullExpressionValue(str, "SelectedLanguage");
        return companion.from(str);
    }

    public void setSelectedCountry(int i11) {
        GlobalDataModel.SelectedCountryId = i11;
    }

    public void setSelectedLanguage(@NotNull Language language) {
        Intrinsics.checkNotNullParameter(language, ConstantsKt.ADJUST_LANGUAGE);
        GlobalDataModel.SelectedLanguage = language.getCode();
    }

    public void setSelectedLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        GlobalDataModel.SelectedLanguage = str;
    }
}
