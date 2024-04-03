package lu;

import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsViewModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo;
import io.reactivex.functions.Function3;
import java.util.List;

public final /* synthetic */ class g implements Function3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuggestionsViewModel f62286a;

    public /* synthetic */ g(SuggestionsViewModel suggestionsViewModel) {
        this.f62286a = suggestionsViewModel;
    }

    public final Object apply(Object obj, Object obj2, Object obj3) {
        return SuggestionsViewModel.m10853mergeVendorsAndSearch$lambda15(this.f62286a, (List) obj, (VendorInfo) obj2, (List) obj3);
    }
}
