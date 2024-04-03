package rf;

import com.talabat.busypopup.viewModel.BusyPopupViewModelImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f57279b;

    public /* synthetic */ b(int i11) {
        this.f57279b = i11;
    }

    public final Object apply(Object obj) {
        return BusyPopupViewModelImpl.m9536getRestaurantListWithCuisine$lambda0(this.f57279b, (List) obj);
    }
}
