package com.talabat.feature.darkstores.vendorlanding.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstores.vendorlanding.domain.repository.VendorLandingRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/VendorLandingFeatureApi;", "Lcom/talabat/core/di/Api;", "repository", "Lcom/talabat/feature/darkstores/vendorlanding/domain/repository/VendorLandingRepository;", "getRepository", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/repository/VendorLandingRepository;", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorLandingFeatureApi extends Api {
    @NotNull
    VendorLandingRepository getRepository();
}
