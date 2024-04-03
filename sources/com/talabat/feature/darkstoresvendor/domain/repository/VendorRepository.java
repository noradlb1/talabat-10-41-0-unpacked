package com.talabat.feature.darkstoresvendor.domain.repository;

import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.darkstoresvendor.domain.model.VendorParams;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/domain/repository/VendorRepository;", "", "clearVendorCache", "", "getVendor", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "vendorParams", "Lcom/talabat/feature/darkstoresvendor/domain/model/VendorParams;", "com_talabat_feature_darkstores-vendor_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorRepository {
    void clearVendorCache();

    @NotNull
    Single<Vendor> getVendor(@NotNull VendorParams vendorParams);
}
