package com.talabat.feature.darkstores.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/darkstores/domain/DarkstoresFeatureApi;", "Lcom/talabat/core/di/Api;", "darkstoresNavigator", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "darkstoresRepository", "Lcom/talabat/feature/darkstores/domain/repository/DarkstoresRepository;", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresFeatureApi extends Api {
    @NotNull
    DarkstoresNavigator darkstoresNavigator();

    @NotNull
    DarkstoresRepository darkstoresRepository();
}
