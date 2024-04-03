package com.talabat.configuration;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.language.Language;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/configuration/ConfigurationLocalRepository;", "", "selectedCountry", "Lcom/talabat/configuration/country/Country;", "selectedLanguage", "Lcom/talabat/configuration/language/Language;", "com_talabat_core_configuration_local_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ConfigurationLocalRepository {
    @NotNull
    Country selectedCountry();

    @NotNull
    Language selectedLanguage();
}
