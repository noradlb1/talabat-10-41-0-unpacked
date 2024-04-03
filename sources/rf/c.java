package rf;

import com.talabat.busypopup.viewModel.BusyPopupViewModelImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BusyPopupViewModelImpl f57280b;

    public /* synthetic */ c(BusyPopupViewModelImpl busyPopupViewModelImpl) {
        this.f57280b = busyPopupViewModelImpl;
    }

    public final Object apply(Object obj) {
        return this.f57280b.generateVendorsDisplayModels((List) obj);
    }
}
