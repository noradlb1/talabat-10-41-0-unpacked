package com.talabat.feature.pharmacy.remote;

import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.feature.pharmacy.model.PrescriptionBannerDetails;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ1\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/pharmacy/remote/PrescriptionApiImpl;", "Lcom/talabat/feature/pharmacy/remote/PrescriptionApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "baseUrl", "Lcom/talabat/feature/pharmacy/remote/PharmacyPrescriptionBaseUrl;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;Lcom/talabat/feature/pharmacy/remote/PharmacyPrescriptionBaseUrl;)V", "getPrescriptionBannerDetails", "Lio/reactivex/Single;", "Lcom/talabat/feature/pharmacy/model/PrescriptionBannerDetails;", "cityId", "", "countryId", "areaId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/Single;", "com_talabat_feature_pharmacy_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrescriptionApiImpl implements PrescriptionApi {
    @NotNull
    private final PharmacyPrescriptionBaseUrl baseUrl;
    @NotNull
    private final BaseUrlFactory baseUrlFactory;
    @NotNull
    private final TalabatAPIBuilder talabatAPIBuilder;

    @Inject
    public PrescriptionApiImpl(@NotNull TalabatAPIBuilder talabatAPIBuilder2, @NotNull BaseUrlFactory baseUrlFactory2, @NotNull PharmacyPrescriptionBaseUrl pharmacyPrescriptionBaseUrl) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder2, "talabatAPIBuilder");
        Intrinsics.checkNotNullParameter(baseUrlFactory2, "baseUrlFactory");
        Intrinsics.checkNotNullParameter(pharmacyPrescriptionBaseUrl, "baseUrl");
        this.talabatAPIBuilder = talabatAPIBuilder2;
        this.baseUrlFactory = baseUrlFactory2;
        this.baseUrl = pharmacyPrescriptionBaseUrl;
    }

    @NotNull
    public Single<PrescriptionBannerDetails> getPrescriptionBannerDetails(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        return ((PrescriptionApi) this.talabatAPIBuilder.createApi(this.baseUrlFactory.baseUrl(this.baseUrl), PrescriptionApi.class)).getPrescriptionBannerDetails(num, num2, num3);
    }
}
