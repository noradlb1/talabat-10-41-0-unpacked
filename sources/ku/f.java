package ku;

import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.GlobalSearchViewModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo;
import io.reactivex.functions.Function3;
import java.util.List;

public final /* synthetic */ class f implements Function3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalSearchViewModel f62230a;

    public /* synthetic */ f(GlobalSearchViewModel globalSearchViewModel) {
        this.f62230a = globalSearchViewModel;
    }

    public final Object apply(Object obj, Object obj2, Object obj3) {
        return GlobalSearchViewModel.m10836mergeVenodrsAndSearch$lambda9(this.f62230a, (List) obj, (VendorInfo) obj2, (List) obj3);
    }
}
