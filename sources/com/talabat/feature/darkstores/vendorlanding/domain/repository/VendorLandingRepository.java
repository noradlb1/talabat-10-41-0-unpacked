package com.talabat.feature.darkstores.vendorlanding.domain.repository;

import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLanding;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLandingRequest;
import com.talabat.feature.darkstores.vendorlanding.domain.model.VendorLandingRequestV2;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/repository/VendorLandingRepository;", "", "getVendorLandingResponse", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLanding;", "vendorLandingRequest", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLandingRequest;", "getVendorLandingResponseV2", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/VendorLandingRequestV2;", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorLandingRepository {
    @NotNull
    Single<VendorLanding> getVendorLandingResponse(@NotNull VendorLandingRequest vendorLandingRequest);

    @NotNull
    Single<VendorLanding> getVendorLandingResponseV2(@NotNull VendorLandingRequestV2 vendorLandingRequestV2);
}
