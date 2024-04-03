package fi;

import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetailsRepo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeliveryDetailsRepo f56826b;

    public /* synthetic */ a(DeliveryDetailsRepo deliveryDetailsRepo) {
        this.f56826b = deliveryDetailsRepo;
    }

    public final Object apply(Object obj) {
        return DeliveryDetailsRepo.m9719_init_$lambda0(this.f56826b, (Vendor) obj);
    }
}
