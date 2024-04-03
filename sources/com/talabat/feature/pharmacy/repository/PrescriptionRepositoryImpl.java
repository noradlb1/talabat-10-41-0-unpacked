package com.talabat.feature.pharmacy.repository;

import com.talabat.feature.pharmacy.model.BannerData;
import com.talabat.feature.pharmacy.model.PrescriptionBannerDetails;
import com.talabat.feature.pharmacy.model.PrescriptionBannerDetailsKt;
import com.talabat.feature.pharmacy.remote.PrescriptionApiImpl;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import on.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J1\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/pharmacy/repository/PrescriptionRepositoryImpl;", "Lcom/talabat/feature/pharmacy/repository/PrescriptionRepository;", "prescriptionApi", "Lcom/talabat/feature/pharmacy/remote/PrescriptionApiImpl;", "(Lcom/talabat/feature/pharmacy/remote/PrescriptionApiImpl;)V", "getPrescriptionBannerDetails", "Lio/reactivex/Single;", "Lcom/talabat/feature/pharmacy/model/BannerData;", "cityId", "", "countryId", "areaId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/Single;", "com_talabat_feature_pharmacy_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrescriptionRepositoryImpl implements PrescriptionRepository {
    @NotNull
    private final PrescriptionApiImpl prescriptionApi;

    @Inject
    public PrescriptionRepositoryImpl(@NotNull PrescriptionApiImpl prescriptionApiImpl) {
        Intrinsics.checkNotNullParameter(prescriptionApiImpl, "prescriptionApi");
        this.prescriptionApi = prescriptionApiImpl;
    }

    /* access modifiers changed from: private */
    /* renamed from: getPrescriptionBannerDetails$lambda-0  reason: not valid java name */
    public static final BannerData m10241getPrescriptionBannerDetails$lambda0(PrescriptionBannerDetails prescriptionBannerDetails) {
        Intrinsics.checkNotNullParameter(prescriptionBannerDetails, "it");
        return PrescriptionBannerDetailsKt.toDomain(prescriptionBannerDetails);
    }

    @NotNull
    public Single<BannerData> getPrescriptionBannerDetails(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        Single<R> map = this.prescriptionApi.getPrescriptionBannerDetails(num, num2, num3).map(new a());
        Intrinsics.checkNotNullExpressionValue(map, "prescriptionApi.getPresc…  ).map { it.toDomain() }");
        return map;
    }
}
