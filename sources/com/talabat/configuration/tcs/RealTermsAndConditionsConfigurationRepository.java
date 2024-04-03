package com.talabat.configuration.tcs;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.remote.model.AppInfoEntity;
import com.talabat.configuration.tcs.mapper.TermsAndConditionsConfigMapper;
import dagger.Reusable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/configuration/tcs/RealTermsAndConditionsConfigurationRepository;", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "appInfoContainer", "Lcom/talabat/configuration/AppInfoContainer;", "mapper", "Lcom/talabat/configuration/tcs/mapper/TermsAndConditionsConfigMapper;", "(Lcom/talabat/configuration/AppInfoContainer;Lcom/talabat/configuration/tcs/mapper/TermsAndConditionsConfigMapper;)V", "config", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfig;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class RealTermsAndConditionsConfigurationRepository implements TermsAndConditionsConfigurationRepository {
    @NotNull
    private final AppInfoContainer appInfoContainer;
    @NotNull
    private final TermsAndConditionsConfigMapper mapper;

    @Inject
    public RealTermsAndConditionsConfigurationRepository(@NotNull AppInfoContainer appInfoContainer2, @NotNull TermsAndConditionsConfigMapper termsAndConditionsConfigMapper) {
        Intrinsics.checkNotNullParameter(appInfoContainer2, "appInfoContainer");
        Intrinsics.checkNotNullParameter(termsAndConditionsConfigMapper, "mapper");
        this.appInfoContainer = appInfoContainer2;
        this.mapper = termsAndConditionsConfigMapper;
    }

    @NotNull
    public TermsAndConditionsConfig config() {
        TermsAndConditionsConfig apply;
        AppInfoEntity cachedAppInfoEntity = this.appInfoContainer.getCachedAppInfoEntity();
        if (cachedAppInfoEntity == null || (apply = this.mapper.apply(cachedAppInfoEntity)) == null) {
            return TermsAndConditionsConfig.Companion.getDEFAULT();
        }
        return apply;
    }
}
