package com.talabat.feature.darkstoresvendor.domain.usecase;

import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.darkstoresvendor.domain.model.VendorParams;
import com.talabat.feature.darkstoresvendor.domain.repository.VendorRepository;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/domain/usecase/GetVendorUseCase;", "", "vendorRepository", "Lcom/talabat/feature/darkstoresvendor/domain/repository/VendorRepository;", "(Lcom/talabat/feature/darkstoresvendor/domain/repository/VendorRepository;)V", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "vendorParams", "Lcom/talabat/feature/darkstoresvendor/domain/model/VendorParams;", "com_talabat_feature_darkstores-vendor_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetVendorUseCase {
    @NotNull
    private final VendorRepository vendorRepository;

    @Inject
    public GetVendorUseCase(@NotNull VendorRepository vendorRepository2) {
        Intrinsics.checkNotNullParameter(vendorRepository2, "vendorRepository");
        this.vendorRepository = vendorRepository2;
    }

    @NotNull
    public final Single<Vendor> invoke(@NotNull VendorParams vendorParams) {
        Intrinsics.checkNotNullParameter(vendorParams, "vendorParams");
        return this.vendorRepository.getVendor(vendorParams);
    }
}
