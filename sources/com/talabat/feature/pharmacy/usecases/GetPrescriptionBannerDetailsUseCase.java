package com.talabat.feature.pharmacy.usecases;

import com.talabat.feature.pharmacy.model.BannerData;
import com.talabat.feature.pharmacy.repository.PrescriptionRepository;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/pharmacy/usecases/GetPrescriptionBannerDetailsUseCase;", "Lcom/talabat/feature/pharmacy/usecases/GetPrescriptionBannerDetails;", "prescriptionRepo", "Lcom/talabat/feature/pharmacy/repository/PrescriptionRepository;", "(Lcom/talabat/feature/pharmacy/repository/PrescriptionRepository;)V", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/feature/pharmacy/model/BannerData;", "cityId", "", "countryId", "areaId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lio/reactivex/Single;", "com_talabat_feature_pharmacy_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetPrescriptionBannerDetailsUseCase implements GetPrescriptionBannerDetails {
    @NotNull
    private final PrescriptionRepository prescriptionRepo;

    public GetPrescriptionBannerDetailsUseCase(@NotNull PrescriptionRepository prescriptionRepository) {
        Intrinsics.checkNotNullParameter(prescriptionRepository, "prescriptionRepo");
        this.prescriptionRepo = prescriptionRepository;
    }

    @NotNull
    public Single<BannerData> invoke(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        return this.prescriptionRepo.getPrescriptionBannerDetails(num, num2, num3);
    }
}
