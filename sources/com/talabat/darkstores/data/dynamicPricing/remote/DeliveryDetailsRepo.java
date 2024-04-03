package com.talabat.darkstores.data.dynamicPricing.remote;

import com.integration.nfv.observability.NfvObservabilityHandler;
import com.talabat.darkstores.common.extensions.SingleExtensionsKt;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.di.LibScope;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import fi.a;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\f\u001a\u00020\t*\u00020\rH\u0002R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/data/dynamicPricing/remote/DeliveryDetailsRepo;", "", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lio/reactivex/Scheduler;)V", "deliveryDetailsModel", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/dynamicPricing/remote/DeliveryDetails;", "getDeliveryDetailsModel", "()Lio/reactivex/Single;", "toDeliveryDetails", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@LibScope
public final class DeliveryDetailsRepo {
    @NotNull
    private final Single<DeliveryDetails> deliveryDetailsModel;

    @Inject
    public DeliveryDetailsRepo(@NotNull DarkstoresRepo darkstoresRepo, @IoScheduler @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Single<R> subscribeOn = darkstoresRepo.getVendor().map(new a(this)).subscribeOn(scheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "darkstoresRepo.getVendor….subscribeOn(ioScheduler)");
        this.deliveryDetailsModel = SingleExtensionsKt.cacheButRetryOnError(subscribeOn);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final DeliveryDetails m9719_init_$lambda0(DeliveryDetailsRepo deliveryDetailsRepo, Vendor vendor) {
        Intrinsics.checkNotNullParameter(deliveryDetailsRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "it");
        return deliveryDetailsRepo.toDeliveryDetails(vendor);
    }

    private final DeliveryDetails toDeliveryDetails(Vendor vendor) {
        float f11 = 0.0f;
        if (vendor.getDeliveryFee() >= 0.0f) {
            f11 = vendor.getDeliveryFee();
        } else {
            NfvObservabilityHandler.INSTANCE.onNegativeDeliveryFeeFromVendor();
        }
        return new DeliveryDetails(f11, vendor.getDeliveryTime(), vendor.getMinimumOrderValue(), vendor.getBasketDeliveryFeeTiersInfo(), vendor.isTPro());
    }

    @NotNull
    public final Single<DeliveryDetails> getDeliveryDetailsModel() {
        return this.deliveryDetailsModel;
    }
}
