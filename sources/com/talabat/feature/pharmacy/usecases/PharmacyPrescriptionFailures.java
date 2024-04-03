package com.talabat.feature.pharmacy.usecases;

import com.talabat.talabatcore.exception.Failure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/pharmacy/usecases/PharmacyPrescriptionFailures;", "Lcom/talabat/talabatcore/exception/Failure$FeatureFailure;", "()V", "FailToLoadBannerInfo", "UnverifiedMobileNumber", "Lcom/talabat/feature/pharmacy/usecases/PharmacyPrescriptionFailures$FailToLoadBannerInfo;", "Lcom/talabat/feature/pharmacy/usecases/PharmacyPrescriptionFailures$UnverifiedMobileNumber;", "com_talabat_feature_pharmacy_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PharmacyPrescriptionFailures extends Failure.FeatureFailure {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/pharmacy/usecases/PharmacyPrescriptionFailures$FailToLoadBannerInfo;", "Lcom/talabat/feature/pharmacy/usecases/PharmacyPrescriptionFailures;", "()V", "com_talabat_feature_pharmacy_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FailToLoadBannerInfo extends PharmacyPrescriptionFailures {
        @NotNull
        public static final FailToLoadBannerInfo INSTANCE = new FailToLoadBannerInfo();

        private FailToLoadBannerInfo() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/pharmacy/usecases/PharmacyPrescriptionFailures$UnverifiedMobileNumber;", "Lcom/talabat/feature/pharmacy/usecases/PharmacyPrescriptionFailures;", "()V", "com_talabat_feature_pharmacy_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnverifiedMobileNumber extends PharmacyPrescriptionFailures {
        @NotNull
        public static final UnverifiedMobileNumber INSTANCE = new UnverifiedMobileNumber();

        private UnverifiedMobileNumber() {
            super((DefaultConstructorMarker) null);
        }
    }

    private PharmacyPrescriptionFailures() {
    }

    public /* synthetic */ PharmacyPrescriptionFailures(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
