package com.talabat.configuration;

import com.talabat.configuration.language.Language;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/configuration/MutableConfigurationLocalRepository;", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "setSelectedCountry", "", "countryId", "", "setSelectedLanguage", "language", "Lcom/talabat/configuration/language/Language;", "code", "", "com_talabat_core_configuration_local_domain-mutable_domain-mutable"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MutableConfigurationLocalRepository extends ConfigurationLocalRepository {
    void setSelectedCountry(int i11);

    void setSelectedLanguage(@NotNull Language language);

    void setSelectedLanguage(@NotNull String str);
}
