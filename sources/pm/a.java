package pm;

import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.DarkstoresScheduledDeliveryUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresScheduledDeliveryUseCase f62791b;

    public /* synthetic */ a(DarkstoresScheduledDeliveryUseCase darkstoresScheduledDeliveryUseCase) {
        this.f62791b = darkstoresScheduledDeliveryUseCase;
    }

    public final Object apply(Object obj) {
        return DarkstoresScheduledDeliveryUseCase.m10209getDeliverySlots$lambda0(this.f62791b, (List) obj);
    }
}
