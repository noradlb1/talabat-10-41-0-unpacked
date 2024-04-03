package om;

import com.talabat.feature.darkstoresscheduleddelivery.data.repository.DarkstoresScheduledDeliveryRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresScheduledDeliveryRepositoryImpl f62396b;

    public /* synthetic */ a(DarkstoresScheduledDeliveryRepositoryImpl darkstoresScheduledDeliveryRepositoryImpl) {
        this.f62396b = darkstoresScheduledDeliveryRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return DarkstoresScheduledDeliveryRepositoryImpl.m10208getDeliverySlots$lambda0(this.f62396b, (List) obj);
    }
}
