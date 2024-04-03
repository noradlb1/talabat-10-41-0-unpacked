package ti;

import com.talabat.darkstores.feature.cart.cartabadonment.StartCartClearedEventTrackerUseCase;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StartCartClearedEventTrackerUseCase f57418b;

    public /* synthetic */ c(StartCartClearedEventTrackerUseCase startCartClearedEventTrackerUseCase) {
        this.f57418b = startCartClearedEventTrackerUseCase;
    }

    public final void accept(Object obj) {
        StartCartClearedEventTrackerUseCase.m9840invoke$lambda2(this.f57418b, (Boolean) obj);
    }
}
