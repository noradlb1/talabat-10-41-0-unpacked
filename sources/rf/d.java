package rf;

import com.talabat.busypopup.viewModel.BusyPopupViewModelImpl;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BusyPopupViewModelImpl f57281b;

    public /* synthetic */ d(BusyPopupViewModelImpl busyPopupViewModelImpl) {
        this.f57281b = busyPopupViewModelImpl;
    }

    public final void accept(Object obj) {
        BusyPopupViewModelImpl.m9537getRestaurantListWithCuisine$lambda1(this.f57281b, (List) obj);
    }
}
