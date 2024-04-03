package com.talabat.feature.darkstoresvendor.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.darkstoresvendor.domain.repository.VendorRepository;
import com.talabat.feature.darkstoresvendor.domain.usecase.GetVendorUseCase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/domain/DarkstoresVendorApi;", "Lcom/talabat/core/di/Api;", "getVendorUseCase", "Lcom/talabat/feature/darkstoresvendor/domain/usecase/GetVendorUseCase;", "vendorRepository", "Lcom/talabat/feature/darkstoresvendor/domain/repository/VendorRepository;", "com_talabat_feature_darkstores-vendor_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresVendorApi extends Api {
    @NotNull
    GetVendorUseCase getVendorUseCase();

    @NotNull
    VendorRepository vendorRepository();
}
